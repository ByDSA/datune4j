package es.danisales.datune;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.ChordMidiTransformations;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.midi.binaries.events.NoteOff;
import es.danisales.datune.midi.binaries.events.NoteOn;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

class Loader {
    private Tonality tonality;
    private JPanel panel;
    private JPanel[][] panels = new JPanel[7][6];
    private AtomicReference<DiatonicChordMidi> lastPlayed;

    Loader(@NonNull Tonality tonality, @NonNull JPanel panel) {
        this.tonality = Objects.requireNonNull(tonality);
        this.panel = Objects.requireNonNull(panel);
    }

    private Set<ChromaticChord> chords() {
        Set<ChromaticChord> chromaticChordSet = new HashSet<>();
        for (DiatonicFunction diatonicFunction : DiatonicFunction.TRIADS) {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .tonality(tonality)
                    .diatonicFunction(diatonicFunction)
                    .build();
            chromaticChordSet.add(chromaticChord);
        }
/*
        for (ChromaticFunction chromaticFunction : ChromaticFunction.values())
            chromaticChordSet.add(
                    ChromaticChord.builder()
                            .tonality(tonality)
                            .chromaticFunction(chromaticFunction)
                            .build()
            );
*/
        if (tonality.isMajorOrMinor()) {
            Tonality otherTonality = tonality.clone();
            if (otherTonality.isMajor())
                otherTonality.setScale(Scale.MINOR);
            else
                otherTonality.setScale(Scale.MAJOR);

            for (DiatonicFunction diatonicFunction : DiatonicFunction.TRIADS) {
                ChromaticChord chromaticChord = ChromaticChord.builder()
                        .tonality(otherTonality)
                        .diatonicFunction(diatonicFunction)
                        .build();
                System.out.println(chromaticChord + " " + otherTonality);
                chromaticChordSet.add(chromaticChord);
            }
        }


        return chromaticChordSet;
    }

    private DiatonicDegree getDegree(@NonNull HarmonicFunction harmonicFunction) {
        DiatonicDegree degree;
        if (harmonicFunction instanceof DiatonicFunction)
            degree = DiatonicDegree.from((DiatonicFunction) harmonicFunction);
        else
            degree = DiatonicDegree.from((ChromaticFunction) harmonicFunction);

        return degree;
    }

    private void initializePanels() {
        JPanel[] panelF = new JPanel[7];
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 5));
        labelPanel.add(new JLabel());

        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(labelPanel);
        for (int i = 0; i < panels.length; i++) {
            panelF[i] = new JPanel();
            DiatonicDegree diatonicDegree = DiatonicDegree.values()[i];
            DiatonicAlt diatonicAlt;
            try {
                diatonicAlt = tonality.getNote(diatonicDegree);
            } catch (ScaleDegreeException e) {
                continue;
            }
            panelF[i].add(new JLabel(diatonicAlt.toString()));
            panelF[i].setLayout(new GridLayout(1, 5));
            for (int j = 0; j < panels[i].length; j++) {
                panels[i][j] = new JPanel();
                panelF[i].add(panels[i][j]);
                if (i == 0) {
                    labelPanel.add(new JLabel(Integer.toString(j + 2)));
                }
            }
            panel.add(panelF[i]);
        }
    }

    private static final BiMap<Integer, HarmonicFunction> mapKey = HashBiMap.create();

    static {
        mapKey.put(KeyEvent.VK_1, DiatonicFunction.I);
        mapKey.put(KeyEvent.VK_2, DiatonicFunction.II);
        mapKey.put(KeyEvent.VK_3, DiatonicFunction.III);
        mapKey.put(KeyEvent.VK_4, DiatonicFunction.IV);
        mapKey.put(KeyEvent.VK_5, DiatonicFunction.V);
        mapKey.put(KeyEvent.VK_6, DiatonicFunction.VI);
        mapKey.put(KeyEvent.VK_7, DiatonicFunction.VII);
        mapKey.put(KeyEvent.VK_U, ChromaticFunction.VII0);
    }

    private static final Map<HarmonicFunction, JButton> mapButton = new HashMap<>();

    private static final Map<Integer, Boolean> pressedMap = new ConcurrentHashMap<>();

    private void key(int keyCode, boolean press) {
        pressedMap.put(keyCode, press);

        HarmonicFunction harmonicFunction = mapKey.get(keyCode);
        if (harmonicFunction == null)
            return;

        JButton jButton = mapButton.get(harmonicFunction);
        if (jButton == null)
            return;

        jButton.getModel().setPressed(press);
        jButton.getChangeListeners()[0].stateChanged(new ChangeEvent(jButton));
    }

    private void check(DiatonicChordMidi diatonicChordMidi, ChromaticChord chromaticChord, Tonality ton) {
        ChromaticChord chromaticChord1 = ChromaticChord.builder()
                .fromDiatonicChordMidi(diatonicChordMidi)
                .build();
        if (!chromaticChord1.equals(chromaticChord))
            System.err.println(chromaticChord1 + " " + chromaticChord + " " + ton);
    }

    void load() {
        initializePanels();

        lastPlayed = new AtomicReference<>(null);

        Set<ChromaticChord> addedChords = new HashSet<>();

        KeyEventDispatcher myKeyEventDispatcher = e -> {
            pressedMap.putIfAbsent(e.getKeyCode(), false);
            if (e.getID() == KeyEvent.KEY_PRESSED && !pressedMap.get(e.getKeyCode())) {
                System.out.println("Pressed " + e.getKeyChar() + pressedMap.get(e.getKeyCode()));
                key(e.getKeyCode(), true);

                return true;
            } else if (e.getID() == KeyEvent.KEY_RELEASED && pressedMap.get(e.getKeyCode())) {
                pressedMap.put(e.getKeyCode(), false);
                System.out.println("Released " + e.getKeyChar());

                key(e.getKeyCode(), false);
                return true;
            }
            return false;
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(myKeyEventDispatcher);

        for (ChromaticChord chromaticChord : chords()) {
            Tonality ton = tonality.clone();
            if (HarmonicFunction.get(chromaticChord, ton) == null)
                if (ton.isMajor())
                    ton.setScale(Scale.MINOR);
                else if (ton.isMinor())
                    ton.setScale(Scale.MAJOR);

            DiatonicChordMidi diatonicChordMidi;
            try {
                diatonicChordMidi = DiatonicChordMidi.builder()
                        .from(chromaticChord, ton)
                        .build();
                check(diatonicChordMidi, chromaticChord, ton);
            } catch (RuntimeException | BuildingException e) {
                System.err.println("Fail " + chromaticChord + " " + chromaticChord.getNotes());
                e.printStackTrace();
                continue;
            }

            if (addedChords.contains(chromaticChord))
                continue;
            addedChords.add(chromaticChord);

            JButton jButton = addButton(diatonicChordMidi, chromaticChord);
            HarmonicFunction harmonicFunction = HarmonicFunction.get(chromaticChord, tonality);
            if (harmonicFunction != null && mapKey.inverse().get(harmonicFunction) != null) {
                mapButton.put(harmonicFunction, jButton);
            }
        }
        panel.revalidate();

        System.out.println("Tonalidad cambiada a " + tonality);
    }

    private JButton addButton(DiatonicChordMidi diatonicChordMidi, @NonNull ChromaticChord chromaticChord) {
        HarmonicFunction harmonicFunction = diatonicChordMidi.getTonality().getFunctionFrom(chromaticChord);
        DiatonicDegree degree = getDegree(harmonicFunction);

        JButton jButton = new JButton(chromaticChord.toString());

        int degreeOrdinal = degree.ordinal();
        panels[degreeOrdinal][chromaticChord.size() - 2].add(jButton);

        if (!diatonicChordMidi.getTonality().equals(tonality)) {
            if (ArrayUtils.contains(harmonicFunction, ChromaticFunction.TENSIONS))
                jButton.setForeground(Color.BLUE);
            else
                jButton.setForeground(Color.RED);
            jButton.setOpaque(true);
        }

        jButton.getModel().addChangeListener(new ChangeListener() {
            private boolean pressed = false; // holds the last pressed state patternFrom the button

            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                // if the current state differs patternFrom the previous state
                if (model.isPressed() != pressed) {
                    pressed = model.isPressed();
                    if (pressed) {
                        if (lastPlayed.get() != null) {
                            ChordMidiTransformations.minimizeDistanceTo(diatonicChordMidi, lastPlayed.get());
                        }

                        lastPlayed.set(diatonicChordMidi);

                        play(diatonicChordMidi);
                        System.out.println("Press " + jButton.getText() + " " + diatonicChordMidi + " " + ChordNamer.from(diatonicChordMidi));
                    } else {
                        stop(diatonicChordMidi);
                        System.out.println("Release " + jButton.getText() + " " + diatonicChordMidi);
                    }
                }
            }
        });

        return jButton;
    }

    private static <T extends NoteMidi<?>> void play(ChordMidi<T, ?, ?> diatonicChordMidi) {
        EventSequence es = new EventSequence();
        for (T diatonicMidi : diatonicChordMidi) {
            NoteOn noteOn = null;
            try {
                noteOn = NoteOn.builder()
                        .from(diatonicMidi)
                        .build();
            } catch (BuildingException e) {
                throw NeverHappensException.make("");
            }
            es.add(0, noteOn);
        }
        es.play();
    }

    private static <T extends NoteMidi<?>> void stop(ChordMidi<T, ?, ?> diatonicChordMidi) {
        EventSequence es = new EventSequence();
        for (T diatonicMidi : diatonicChordMidi) {
            NoteOff noteOff = null;
            try {
                noteOff = NoteOff.builder()
                        .from(diatonicMidi)
                        .build();
            } catch (BuildingException e) {
                throw NeverHappensException.make("");
            }
            es.add(0, noteOff);
        }
        es.play();
    }
}
