package es.danisales.datune;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.eventsequences.Instrument;
import es.danisales.datune.midi.ChordMidiTransformations;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.binaries.Midi;
import es.danisales.datune.midi.binaries.events.NoteOff;
import es.danisales.datune.midi.binaries.events.NoteOn;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

public class MainJFrame extends JFrame {
    JPanel panel;

    boolean sus24 = false;
    boolean modal = false;

    public void load(Tonality ton) {
        assert ton != null;
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel[][] panels = new JPanel[7][6];
        JPanel[] panelF = new JPanel[7];
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 5));
        labelPanel.add(new JLabel());
        panel.add(labelPanel);
        for (int i = 0; i < panels.length; i++) {
            panelF[i] = new JPanel();
            DiatonicDegree diatonicDegree = DiatonicDegree.values()[i];
            panelF[i].add(new JLabel(ton.getNote(diatonicDegree).toString()));
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

        AtomicReference<DiatonicChordMidi> lastPlayed = new AtomicReference<>(null);

        java.util.List<ChromaticChord> fs = new ArrayList<>();
        java.util.Set<ChromaticChord> chromaticChordSet = new HashSet<>();
        for (DiatonicFunction diatonicFunction : DiatonicFunction.values())
            chromaticChordSet.add(
                    ChromaticChord.builder()
                            .tonality(ton)
                            .diatonicFunction(diatonicFunction)
                            .build()
            );

        for (ChromaticFunction chromaticFunction : ChromaticFunction.values())
            chromaticChordSet.add(
                    ChromaticChord.builder()
                            .tonality(ton)
                            .chromaticFunction(chromaticFunction)
                            .build()
            );

        for (ChromaticChord chromaticChord : chromaticChordSet) {
            System.out.println(chromaticChord + " " + chromaticChord.getNotes() + " " + ton);
            DiatonicChordMidi c;
            try {
                c = DiatonicChordMidi.builder()
                        .from(chromaticChord, ton)
                        .build();
            } catch (RuntimeException e) {
                System.out.println("Fail");
                continue;
            }

            if (fs.contains(chromaticChord))
                continue;
            fs.add(chromaticChord);


            JButton jButton = new JButton(
                    ChromaticChord.builder().fromDiatonicChordMidi(c).build().toString()
            );
            DiatonicDegree degree = null;
            try {
                degree = (DiatonicDegree) ton.getDegreeFrom(chromaticChord.getRoot());
            } catch (TonalityException ignored) {
            }
            HarmonicFunction harmonicFunction = ton.getFunctionFrom(chromaticChord);
            if (harmonicFunction instanceof ChromaticFunction)
                switch ((ChromaticFunction) harmonicFunction) {
                    case SUBV7:
                        degree = DiatonicDegree.I;
                        break;
                    case V_II:
                    case V7_II:
                    case SUBV7_II:
                        degree = DiatonicDegree.II;
                        break;
                    case V_III:
                    case V7_III:
                    case SUBV7_III:
                        degree = DiatonicDegree.III;
                        break;
                    case V_IV:
                    case V7_IV:
                    case SUBV7_IV:
                        degree = DiatonicDegree.IV;
                        break;
                    case V_V:
                    case V7_V:
                    case SUBV7_V:
                        degree = DiatonicDegree.V;
                        break;
                    case V_VI:
                    case V7_VI:
                    case SUBV7_VI:
                        degree = DiatonicDegree.VI;
                        break;
                }
            assert degree != null : c + " " + harmonicFunction;

            Integer d = degree.ordinal();

            panels[d][c.size() - 2].add(jButton);

            if (!c.getTonality().equals(ton)) {
                if (ArrayUtils.contains(harmonicFunction, ChromaticFunction.TENSIONS))
                    jButton.setForeground(Color.BLUE);
                else
                    jButton.setForeground(Color.RED);
                jButton.setOpaque(true);
            }

            jButton.getModel().addChangeListener(new ChangeListener() {
                private boolean pressed = false; // holds the last pressed state from the button

                @Override
                public void stateChanged(ChangeEvent e) {
                    ButtonModel model = (ButtonModel) e.getSource();

                    // if the current state differs from the previous state
                    if (model.isPressed() != pressed) {
                        pressed = model.isPressed();
                        if (pressed) {
                            if (lastPlayed.get() != null && false) {
                                ChordMidiTransformations.minimizeDistanceTo(c, lastPlayed.get());
                            }

                            lastPlayed.set(c);

                            EventSequence es = new EventSequence();
                            for (DiatonicMidi n : c)
                                es.add(0, new NoteOn(n));
                            es.play();
                            System.out.println("Press " + c + " " + ChordNamer.from(c));
                        } else {
                            EventSequence es = new EventSequence();
                            for (DiatonicMidi n : c)
                                es.add(0, new NoteOff(n));
                            es.play();
                            System.out.println("Release " + c);
                        }
                    }
                }
            });
        }
        panel.revalidate();

        System.out.println("Tonalidad cambiada a " + ton);
    }

    MainJFrame() {
        try {
            javax.swing.UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
        }

        panel = new JPanel();

        JPanel selectorPanel = new JPanel();

        JComboBox<Tonality> combo = new JComboBox<>();
        for (Tonality t : Tonality.all())
            combo.addItem(t);

        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tonality t = (Tonality) combo.getSelectedItem();
                load(t);
            }
        });
        selectorPanel.add(combo);

        JCheckBox susBox = new JCheckBox("sus2-4");
        susBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                sus24 = susBox.isSelected();
                Tonality t = (Tonality) combo.getSelectedItem();
                load(t);
            }
        });
        selectorPanel.add(susBox);

        JCheckBox modalBox = new JCheckBox("modal");
        modalBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                modal = modalBox.isSelected();
                Tonality t = (Tonality) combo.getSelectedItem();
                load(t);
            }
        });
        selectorPanel.add(modalBox);

        JComboBox<Instrument> combo2 = new JComboBox<>();
        for (Instrument t : Instrument.all())
            combo2.addItem(t);

        combo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instrument t = (Instrument) combo2.getSelectedItem();
                System.out.println("Instrumento cambiado a " + t);
                Midi.setInstrument(t);
            }
        });
        selectorPanel.add(combo2);

        getContentPane().add(selectorPanel, BorderLayout.NORTH);

        getContentPane().add(panel, BorderLayout.CENTER);

        load(Tonality.C);

        setVisible(true);
        this.setResizable(true);
        this.setTitle("aa");
        setSize(1450, 850);
    }

    public static void main(String[] args) {
        new MainJFrame().setVisible(true);
    }
}
