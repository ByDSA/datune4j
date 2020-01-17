package es.danisales.datune;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.degrees.scale.DiatonicDegree;
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
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.chords.ChromaticChordBuilder;
import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.chords.ParametricChord;
import es.danisales.datune.chords.ChordNamer;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityUtils;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
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

    private void addDiatonicChords(List<ParametricChord> chromaticChordSet) {
        for (DiatonicFunction diatonicFunction : DiatonicFunction.TRIADS) {
            ParametricChord parametricChord = ParametricChord.from(tonality, diatonicFunction);
            chromaticChordSet.add(parametricChord);
        }
    }

    private void addChromaticFunctions(List<ParametricChord> chromaticChordSet) {
        for (ChromaticFunction chromaticFunction : ChromaticFunction.values()) {
            if (ArrayUtils.contains(chromaticFunction, ChromaticFunction.TRIAD_FUNCTIONS))
                continue;
            ParametricChord chromaticChord = ParametricChord.from(tonality, chromaticFunction);
            chromaticChordSet.add(chromaticChord);
            System.out.println("Added chord: " + chromaticFunction + " from " + tonality);
        }
    }

    private void addBorrowedChords(List<ParametricChord> chromaticChordSet) {
        if (tonality.getScale().equals(Scale.MAJOR) || tonality.getScale().equals(Scale.MINOR)) {
            Tonality otherTonality = tonality.clone();
            if (TonalityUtils.isMajor(otherTonality))
                otherTonality.setScale(Scale.MINOR);
            else
                otherTonality.setScale(Scale.MAJOR);

            for (DiatonicFunction diatonicFunction : DiatonicFunction.TRIADS) {
                if (diatonicFunction == DiatonicFunction.I)
                    continue;
                ParametricChord chromaticChord = ParametricChord.from(otherTonality, diatonicFunction);
                System.out.println("Added borrowed chord: " + chromaticChord + " from " + otherTonality);
                chromaticChordSet.add(chromaticChord);
            }
        }
    }

    private List<ParametricChord> chords() {
        List<ParametricChord> chromaticChordSet = new ArrayList<>();

        addDiatonicChords(chromaticChordSet);

        addChromaticFunctions(chromaticChordSet);

        addBorrowedChords(chromaticChordSet);

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
            } catch (ScaleRelativeDegreeException e) {
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

        for (ParametricChord parametricChord : chords()) {
            DiatonicChordMidi diatonicChordMidi;
            try {
                diatonicChordMidi = DiatonicChordMidi.builder()
                        .from(parametricChord.getHarmonicFunction(), parametricChord.getTonality())
                        .build();
                // check(diatonicChordMidi, parametricChord, ton);
            } catch (RuntimeException | BuildingException e) {
                System.out.println(parametricChord);
                e.printStackTrace();
                continue;
            }

            ChromaticChordBuilder chromaticChordBuilder = ChromaticChord.builder();
            if (parametricChord.getHarmonicFunction() instanceof DiatonicFunction)
                chromaticChordBuilder.diatonicFunction((DiatonicFunction) parametricChord.getHarmonicFunction());
            else
                chromaticChordBuilder.chromaticFunction((ChromaticFunction) parametricChord.getHarmonicFunction());

            chromaticChordBuilder.tonality(parametricChord.getTonality());
            ChromaticChord chromaticChord = chromaticChordBuilder.build();
            if (addedChords.contains(chromaticChord))
                continue;
            addedChords.add(chromaticChord);

            JButton jButton = addButton(diatonicChordMidi, parametricChord, tonality);
            if (mapKey.inverse().get(parametricChord.getHarmonicFunction()) != null && parametricChord.getTonality().equals(tonality)) {
                mapButton.put(parametricChord.getHarmonicFunction(), jButton);
            }
        }
        panel.revalidate();

        System.out.println("Tonalidad cambiada a " + tonality);
    }

    private JButton addButton(DiatonicChordMidi diatonicChordMidi, ParametricChord parametricChord, Tonality tonality) {
        final HarmonicFunction harmonicFunction = parametricChord.getHarmonicFunction();
        DiatonicDegree degree = getDegree(harmonicFunction);

        JButton jButton = new JButton(harmonicFunction.toString());

        int degreeOrdinal = degree.ordinal();
        panels[degreeOrdinal][diatonicChordMidi.size() - 2].add(jButton);

        if (!diatonicChordMidi.getTonality().equals(tonality)) {
            if (ArrayUtils.contains(harmonicFunction, ChromaticFunction.TENSIONS))
                jButton.setForeground(Color.BLUE);
            else {
                jButton.setForeground(Color.RED);
                jButton.setText(harmonicFunction + " (" + diatonicChordMidi.getTonality() + ")");
            }
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
            NoteOn noteOn;
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
