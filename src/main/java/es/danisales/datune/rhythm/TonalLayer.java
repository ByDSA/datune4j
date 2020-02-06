package es.danisales.datune.rhythm;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.chords.Chord;
import es.danisales.datune.chords.ChordProgression;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.MainTonalFunction;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class TonalLayer extends SequentialTimeEvents<HarmonicFunction, DurableEvent<HarmonicFunction, MusicalTime>, MusicalTime> {
    private RhythmLayer rhythmLayer;
    private ChordsLayer chordsLayer;

    private TonalLayer(RhythmLayer rhythmLayer, ChordsLayer chordsLayer) {
        this.rhythmLayer = rhythmLayer;
        this.chordsLayer = chordsLayer;
    }

    public static @NonNull TonalLayer create(@NonNull RhythmLayer rhythmLayer, @NonNull ChordsLayer chordLayer) {
        return new TonalLayer(rhythmLayer, chordLayer);
    }

    public void get() { // todo: to class
        MusicalTime firstCompass = rhythmLayer.getFirstCompassTime();

        Iterator<Map.Entry<MusicalTime, DurableEvent<ChromaticChord, MusicalTime>>> iterator = chordsLayer.iterator();

        Map.Entry<MusicalTime, DurableEvent<ChromaticChord, MusicalTime>> entry = null;
        while (iterator.hasNext()) {
            entry = iterator.next();
            if (entry.getKey().compareTo(firstCompass) >= 0)
                break;
        }

        if (!iterator.hasNext() || !entry.getKey().equals(firstCompass))
            throw new RuntimeException();

        ChordProgression<Chromatic> chromaticChordProgression = ChordProgression.create();
        MusicalTime nextCompassTime = rhythmLayer.getNextCompassTime(rhythmLayer.getFirstCompassTime());
        System.out.println(nextCompassTime);
        System.out.println("-------------");
        for (MusicalTime iTime = firstCompass.clone(); iTime.compareTo(nextCompassTime) < 0; iTime = entry.getKey()) {
            chromaticChordProgression.add(entry.getValue().getNote());
            if (!iterator.hasNext())
                break;
            entry = iterator.next();
        }

        System.out.println(chromaticChordProgression);
        System.out.println("-------------");

        List<Tonality<Chromatic>> tonalities = new ArrayList<>();
        tonalities.addAll(TonalityRetrieval.ET12.ALL_MAJOR_MODES);
        tonalities.addAll(TonalityRetrieval.ET12.ALL_MELODIC_MINOR);
        tonalities.addAll(TonalityRetrieval.ET12.ALL_HARMONIC_MINOR);

        for (int i = 0; i < tonalities.size(); i++) {
            Tonality<Chromatic> tonality = tonalities.get(i);
            ChromaticChord rootChord = ChromaticChord.from(tonality, DiatonicFunction.I);
            if (!tonality.getMainFunctionFrom(chromaticChordProgression.get(0)).equals(MainTonalFunction.TONIC) || !rootChord.containsAll(chromaticChordProgression.get(0))) {
                tonalities.remove(i);
                i--;
            }
        }

        for (Tonality<Chromatic> tonality : tonalities)
            System.out.println(tonality);

        System.out.println("-------------");

        List<Tonality<Chromatic>> possibleTonalities = TonalityRetrieval.fromChordProgression(chromaticChordProgression, tonalities);

        for (Tonality<Chromatic> tonality : possibleTonalities)
            System.out.println(tonality);
    }

    @SuppressWarnings("WeakerAccess")
    public void analise() {

    }
}
