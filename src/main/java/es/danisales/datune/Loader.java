package es.danisales.datune;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.tonal.TonalChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.DiatonicDegree;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.function.ChromaticDegreeFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.NoteMidi;
import es.danisales.datune.midi.binaries.events.NoteOff;
import es.danisales.datune.midi.binaries.events.NoteOn;
import es.danisales.datune.tonality.*;
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
    private TonalityModern tonality;
    private JPanel panel;
    private JPanel[][] panels = new JPanel[7][6];
    private AtomicReference<ChordMidi> lastPlayed;

    Loader(@NonNull TonalityModern tonality, @NonNull JPanel panel) {
        this.tonality = Objects.requireNonNull(tonality);
        this.panel = Objects.requireNonNull(panel);
    }

    private void addDiatonicChords(List<TonalChord> chromaticChordSet) {
        for (DiatonicFunction diatonicFunction : DiatonicFunction.immutableValues()) {
            TonalChord parametricChord = TonalChord.from(tonality, diatonicFunction);
            chromaticChordSet.add(parametricChord);
        }
    }

    private void addChromaticFunctions(List<TonalChord> chromaticChordSet) {
       for (ChromaticDegreeFunction chromaticFunction : SecondaryDominant.values()) {
            TonalChord parametricChord = TonalChord.from(tonality, chromaticFunction);

            chromaticChordSet.add(parametricChord);
            System.out.println("Added chord: " + chromaticFunction + " from " + tonality);
        }

        for (ChromaticDegreeFunction chromaticFunction : ChromaticDegreeFunction.SUS4_FUNCTIONS) {
            TonalChord parametricChord = TonalChord.from(tonality, chromaticFunction);
            ChromaticChord chromaticChord = ChromaticChord.from(parametricChord);
            if ( tonality.containsAll(chromaticChord) ) {
                chromaticChordSet.add(parametricChord);
                System.out.println("Added chord: " + chromaticFunction + " from " + tonality);
            }
        }
    }

    private void addBorrowedChords(List<TonalChord> chromaticChordSet) {
        if (tonality.getScale().equals(Scale.MAJOR) || tonality.getScale().equals(Scale.MINOR)) {
            Tonality otherTonality = tonality.clone();
            if (TonalityUtils.isMajor(otherTonality))
                otherTonality.setScale(Scale.MINOR);
            else
                otherTonality.setScale(Scale.MAJOR);

            for (DiatonicFunction diatonicFunction : DiatonicFunction.TRIADS) {
                if (diatonicFunction == DiatonicFunction.I)
                    continue;
                TonalChord chromaticChord = TonalChord.from(otherTonality, diatonicFunction);
                System.out.println("Added borrowed chord: " + chromaticChord + " from " + otherTonality);
                chromaticChordSet.add(chromaticChord);
            }
        }
    }

    private List<TonalChord> chords() {
        List<TonalChord> chromaticChordSet = new ArrayList<>();

        addDiatonicChords(chromaticChordSet);

        addChromaticFunctions(chromaticChordSet);

        addBorrowedChords(chromaticChordSet);

        return chromaticChordSet;
    }

    private DiatonicDegree getDegree(@NonNull HarmonicFunction harmonicFunction) {
        DiatonicDegree degree = null;
        if (harmonicFunction instanceof DiatonicFunction)
            degree = ((DiatonicFunction) harmonicFunction).getDiatonicDegree();
        else if (harmonicFunction instanceof ChromaticDegreeFunction) {
            int n = ((ChromaticDegreeFunction) harmonicFunction).getChromaticDegree().ordinal();
            switch (n) {
                case 0:
                case 1:
                    degree = DiatonicDegree.I;
                    break;
                case 2:
                    degree = DiatonicDegree.II;
                    break;
                case 3:
                case 4:
                    degree = DiatonicDegree.III;
                    break;
                case 5:
                case 6:
                    degree = DiatonicDegree.IV;
                    break;
                case 7:
                case 8:
                    degree = DiatonicDegree.V;
                    break;
                case 9:
                    degree = DiatonicDegree.VI;
                    break;
                case 10:
                case 11:
                    degree = DiatonicDegree.VII;
                    break;
            }
        }

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
            Chromatic chromatic;
            try {
                chromatic = tonality.getNote(diatonicDegree);
            } catch (ScaleRelativeDegreeException e) {
                continue;
            }
            panelF[i].add(new JLabel(chromatic.toString()));
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
        mapKey.put(KeyEvent.VK_U, ChromaticDegreeFunction.VII0);
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

        for (TonalChord parametricChord : chords()) {
            ChordMidi chordMidi;
            try {
                chordMidi = ChordMidi.builder()
                        .fromChromaticChord(ChromaticChord.from(parametricChord))
                        .build();
                // check(diatonicChordMidi, parametricChord, ton);
            } catch (RuntimeException e) {
                System.out.println(parametricChord);
                e.printStackTrace();
                continue;
            }

            ChromaticChord chromaticChord = null;
            try {
                if (parametricChord.getHarmonicFunction() != null)
                    chromaticChord = parametricChord.getHarmonicFunction().getChord((TonalityModern)parametricChord.getTonality());
                if (chromaticChord == null)
                    throw new RuntimeException();
            } catch (Exception e) {
                continue;
            }
            if (addedChords.contains(chromaticChord))
                continue;
            addedChords.add(chromaticChord);

            JButton jButton = addButton(chordMidi, chromaticChord, parametricChord, tonality);
            if (mapKey.inverse().get(parametricChord.getHarmonicFunction()) != null && parametricChord.getTonality().equals(tonality)) {
                mapButton.put(parametricChord.getHarmonicFunction(), jButton);
            }
        }
        panel.revalidate();

        System.out.println("Tonalidad cambiada a " + tonality);
    }

    private static boolean isChromaticDegreeFunction(Tonality tonality, ChromaticChord chromaticChord) {
        for(Object harmonicFunction : tonality.getFunctionsFrom(chromaticChord)) {
            if (harmonicFunction instanceof ChromaticDegreeFunction)
                return true;
        }

        return false;
    }

    private JButton addButton(ChordMidi chordMidi, ChromaticChord chromaticChord, TonalChord parametricChord, Tonality<Chromatic> tonality) {
        final HarmonicFunction harmonicFunction = parametricChord.getHarmonicFunction();
        DiatonicDegree degree = getDegree(harmonicFunction);

        JButton jButton = new JButton(harmonicFunction.toString());

        int degreeOrdinal = degree.ordinal();
        panels[degreeOrdinal][chromaticChord.size() - 2].add(jButton);

        if (!tonality.containsAll(chromaticChord)) {
            if (isChromaticDegreeFunction(tonality, chromaticChord))
                jButton.setForeground(Color.BLUE);
            else {
                jButton.setForeground(Color.RED);
                jButton.setText(harmonicFunction.toString() + " (" + parametricChord.getTonality() + ")");
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
                            //ChordMidiTransformations.minimizeDistanceTo(chordMidi, lastPlayed.fromInt());
                        }

                        lastPlayed.set(chordMidi);

                        play(chordMidi);
                        System.out.println("Press " + jButton.getText() + " " + chordMidi);
                    } else {
                        stop(chordMidi);
                        System.out.println("Release " + jButton.getText() + " " + chordMidi);
                    }
                }
            }
        });

        return jButton;
    }

    private static void play(ChordMidi chordMidi) {
        EventSequence es = new EventSequence();
        for (NoteMidi noteMidi : chordMidi) {
            NoteOn noteOn;
            try {
                noteOn = NoteOn.builder()
                        .from(noteMidi)
                        .build();
            } catch (BuildingException e) {
                throw NeverHappensException.make("");
            }
            es.add(0, noteOn);
        }
        es.play();
    }

    private static void stop(ChordMidi chordMidi) {
        EventSequence es = new EventSequence();
        for (NoteMidi noteMidi : chordMidi) {
            NoteOff noteOff;
            try {
                noteOff = NoteOff.builder()
                        .from(noteMidi)
                        .build();
            } catch (BuildingException e) {
                throw NeverHappensException.make("");
            }
            es.add(0, noteOff);
        }
        es.play();
    }
}
