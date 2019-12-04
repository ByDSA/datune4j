package es.danisales.datune.midi;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiatonicChordMidiTransformations {
    private DiatonicChordMidiTransformations() {
    }

    public static ChromaticChordMidi reduceDistances(ChromaticChordMidi chord) {
        return chord.clone();
    }

    public static ArrayList<ChromaticChordMidi> reduceDistances(final List<ChromaticChordMidi> chords) {
        ArrayList<ChromaticChordMidi> out = new ArrayList<>();
        for (ChromaticChordMidi c : chords) {
            out.add(reduceDistances(c));
        }

        return out;
    }

    public static void showPossibleProgressionsMajorMinor(List<ChromaticChord> cs) {
        assert cs != null;
        showPossibleProgressionsMajorMinor((c) -> {
            return true;
        }, cs);
    }

    public static void showPossibleProgressionsMajorMinor(Function<DiatonicChordMidi, Boolean> f, List<ChromaticChord> cs) {
        assert f != null;
        assert cs != null;
        showPossibleProgressions((DiatonicChordMidi c) -> {
            return (c.tonality != null && c.tonality.isMajorOrMinor()
                    || c.tonality.isMajorOrMinor()) && f.apply(c);
        }, cs);
    }

    public static void showPossibleProgressions(Function<DiatonicChordMidi, Boolean> f, List<ChromaticChord> chordsIn) {

        List<Tonality> possibleTonalitiesList = TonalityRetrieval.getFromChords(true, chordsIn);

        // DEBUG
        if (possibleTonalitiesList == null || possibleTonalitiesList.isEmpty()) {
            for (ChromaticChord c : chordsIn) {
                for (Chromatic chromaticMidi : c)
                    System.out.print(chromaticMidi + "  ");
                System.out.println();
            }
        }

        assert possibleTonalitiesList != null
                && !possibleTonalitiesList.isEmpty() : "No se ha encontrado escala";

        // Mostrar por consola
        for (Tonality tonality : possibleTonalitiesList) {
            if (tonality.isMajorOrMinor()) {
                StringBuilder sb = new StringBuilder();
                boolean yep = true;
                sb.append("----").append(tonality).append("----");
                for (ChromaticChord chromaticChord : chordsIn) {
                    DiatonicChordMidi c = DiatonicChordMidi.builder().from(tonality, chromaticChord);
                    if (!f.apply(c)) {
                        yep = false;
                        break;
                    }

                    sb.append("\n").append(c);
                }

                if (yep)
                    System.out.println(sb);

            }
        }
    }

    public static List<DiatonicChordMidi> chordsWhereTonalityIs(List<DiatonicChordMidi> in, Tonality t, boolean meta, boolean intercambioModal) {
        List<DiatonicChordMidi> cs = new ArrayList<>();
        List<DiatonicChordMidi> csModal = new ArrayList<>();

        for (final DiatonicChordMidi i : in)
            if (meta && i.tonality.equals(t) || !meta && i.getTonality().equals(t)) {
                cs.add(i);
            } else if (intercambioModal && i.tonality.isModeOf(t))
                csModal.add(i);

        if (cs.isEmpty())
            return csModal;
        else
            return cs;
    }

    public static DiatonicChordMidi chordWhereTonalityIs(ArrayList<DiatonicChordMidi> in, Tonality t, boolean meta, boolean intercambioModal) {
        List<DiatonicChordMidi> cs = chordsWhereTonalityIs(in, t, meta, intercambioModal);
        if (cs.size() == 0)
            throw new RuntimeException("No hay un acorde");

        return cs.get(0);
    }

    public static void addDuplicate(DiatonicChordMidi diatonicChordMidi, int oct) throws PitchMidiException {
        if (oct == 0)
            throw new AddedException(diatonicChordMidi);

        int sizeIni = diatonicChordMidi.size();
        for (int i = 0; i < sizeIni; i++) {
            DiatonicMidi n = diatonicChordMidi.get(i).clone();
            n.getPitch().shiftOctave(oct);
            diatonicChordMidi.add(n);
        }
    }

}
