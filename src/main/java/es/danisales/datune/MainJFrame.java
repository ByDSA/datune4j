package es.danisales.datune;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.eventsequences.Instrument;
import es.danisales.datune.midi.binaries.Midi;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainJFrame extends JFrame {
    private JPanel panel;

    private JComboBox<Tonality<Chromatic>> tonalitiesComboBox;
    private JComboBox<Instrument> instrumentJComboBox;

    private @NonNull Tonality<Chromatic> getSelectedTonality() {
        //noinspection unchecked
        return Objects.requireNonNull((Tonality<Chromatic>) tonalitiesComboBox.getSelectedItem());
    }

    private @NonNull Instrument getSelectedInstrument() {
        return Objects.requireNonNull((Instrument) instrumentJComboBox.getSelectedItem());
    }

    private void initializeTonalitiesJComboBox() {
        tonalitiesComboBox = new JComboBox<>();
        for (Tonality<Chromatic> t : TonalityRetrieval.ET12.ALL_MAJOR_MINOR)
            tonalitiesComboBox.addItem(t);

        tonalitiesComboBox.addActionListener(e -> {
            Tonality<Chromatic> tonality = getSelectedTonality();
            new Loader(tonality, panel).load();
        });
    }

    private MainJFrame() {
        try {
            javax.swing.UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {
        }

        panel = new JPanel();

        JPanel selectorPanel = new JPanel();

        initializeTonalitiesJComboBox();
        selectorPanel.add(tonalitiesComboBox);

        initialiceInstrumentJComboBox();
        selectorPanel.add(instrumentJComboBox);

        getContentPane().add(selectorPanel, BorderLayout.NORTH);

        getContentPane().add(panel, BorderLayout.CENTER);

        Tonality<Chromatic> initialTonality = Tonality.ET12.C;
        tonalitiesComboBox.setSelectedItem(initialTonality);
        new Loader(initialTonality, panel).load();

        setVisible(true);
        setResizable(true);
        setTitle("aa");
        setSize(1450, 850);
    }

    private void initialiceInstrumentJComboBox() {
        instrumentJComboBox = new JComboBox<>();
        for (Instrument instrument : Instrument.all())
            instrumentJComboBox.addItem(instrument);

        instrumentJComboBox.addActionListener(e -> {
            Instrument newSelectedInstrument = getSelectedInstrument();
            System.out.println("Instrumento cambiado a " + newSelectedInstrument);
            Midi.setInstrument(newSelectedInstrument);
        });
    }

    public static void main(String[] args) {
        new MainJFrame().setVisible(true);
    }
}
