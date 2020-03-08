package es.danisales.datune.timelayer;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.SecondaryDominant;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.tonality.TonalityModern;
import es.danisales.datune.tonality.TonalityRetrieval;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class TonalLayerCalculator {
    private RhythmLayer rhythmLayer;
    private ChordsLayer chordsLayer;

    private TonalLayerCalculator() {
    }

    public static TonalLayerCalculator create() {
        return new TonalLayerCalculator();
    }

    public void setRhythmLayer(RhythmLayer rhythmLayer) {
        this.rhythmLayer = rhythmLayer;
    }

    public void setChordsLayer(ChordsLayer chordsLayer) {
        this.chordsLayer = chordsLayer;
    }

    private DurableEvent<ChromaticChord, MusicalTime> eventCursor;
    private MusicalTime firstCompassTime;
    private Iterator<Map.Entry<MusicalTime, DurableEvent<ChromaticChord, MusicalTime>>> iterator;
    private List<ChromaticChord> chromaticChordProgression;
    private List<DurableEvent<ChromaticChord, MusicalTime>> entryList;
    private List<TonalityModern> possibleTonalities;

    private void calculateFirstCompass() {
        firstCompassTime = rhythmLayer.getFirstCompassTime();
        System.out.println("First Compass Time: " + firstCompassTime);
    }

    private void generateChordProgression() {
        entryList = new ArrayList<>();
        chromaticChordProgression = new ArrayList<>();
        MusicalTime nextCompassTime = rhythmLayer.getNextCompassTime(rhythmLayer.getFirstCompassTime());
        System.out.println("Next Compass Time: " + nextCompassTime);
        for (MusicalTime iTime = firstCompassTime.clone(); iTime.compareTo(nextCompassTime) < 0; iTime = eventCursor.getIni()) {
            chromaticChordProgression.add(eventCursor.getNote());
            entryList.add(eventCursor);
            if (!iterator.hasNext())
                break;
            eventCursor = iterator.next().getValue();
        }

        System.out.println("Chord Progression: " + chromaticChordProgression);
    }

    private void calculateFirstCompassIterator() {
        iterator = chordsLayer.iterator(firstCompassTime);

        if (!iterator.hasNext())
            throw new RuntimeException();
    }

    private void initializePossibleTonalities() {
        possibleTonalities = new ArrayList<>();
        possibleTonalities.addAll(TonalityRetrieval.ALL_MAJOR_MODES);
        possibleTonalities.addAll(TonalityRetrieval.ALL_MELODIC_MINOR);
        possibleTonalities.addAll(TonalityRetrieval.ALL_HARMONIC_MINOR);
    }

    private void showPossibleTonalities() {
        for (TonalityModern tonality : possibleTonalities)
            System.out.println(tonality);
    }

    private void discardTonalitiesFromFirstChord() {
        HarmonicFunction rootFunction = DiatonicFunction.I7;

        for (int i = 0; i < possibleTonalities.size(); i++) {
            TonalityModern tonality = possibleTonalities.get(i);
            ChromaticChord rootChord = tonality.getChord(rootFunction);

            checkNotNull(rootChord);

            if (!chromaticChordProgression.get(0).contains(tonality.getRoot())
                    || !rootChord.containsAll(chromaticChordProgression.get(0))
                    || !tonality.getMainFunctionFrom(chromaticChordProgression.get(0)).equals(MainTonalFunction.TONIC)
            ) {
                possibleTonalities.remove(i);
                i--;
            }
        }

        System.out.println("------------\nTonalities after discardTonalitiesFromFirstChord:");
        showPossibleTonalities();
    }

    private void calculatePossibleTonalitiesFromProgression() {
        possibleTonalities = TonalityRetrieval.fromChordProgression(chromaticChordProgression, possibleTonalities, false);

        System.out.println("------------\nTonalities after calculatePossibleTonalitiesFromProgression:");
        showPossibleTonalities();
    }

    private TonalLayer generateTonalLayer() {
        TonalLayer tonalLayer = TonalLayer.create();
        for (DurableEvent<ChromaticChord, MusicalTime> entry1 : entryList) {
            List<TonalLayer.Node> l = new ArrayList<>();
            MusicalTime length = entry1.getEnd().clone().sub(entry1.getIni());
            DurableEvent<List<TonalLayer.Node>, MusicalTime> durableEvent = DurableEvent.from(entry1.getIni(), l, length);
            tonalLayer.add(durableEvent);

            for (TonalityModern tonality : possibleTonalities) {
                Set<HarmonicFunction> harmonicFunctionSet = tonality.getFunctionsFrom(entry1.getNote());
                HarmonicFunction harmonicFunction = harmonicFunctionSelector(harmonicFunctionSet);
                TonalLayer.Node node = TonalLayer.Node.from(tonality, harmonicFunction);
                l.add(node);
            }
        }

        return tonalLayer;
    }

    private HarmonicFunction harmonicFunctionSelector(Set<HarmonicFunction> harmonicFunctionSet) {
        HarmonicFunction ret = null;
        for (HarmonicFunction harmonicFunction : harmonicFunctionSet) {
            if (ret == null
                    || (harmonicFunction instanceof DiatonicFunction && !(ret instanceof DiatonicFunction))
                    || (harmonicFunction instanceof SecondaryDominant && !(ret instanceof SecondaryDominant) && !(ret instanceof DiatonicFunction))
            )
                ret = harmonicFunction;
        }

        return ret;
    }

    public TonalLayer generate() {
        calculateFirstCompass();

        calculateFirstCompassIterator();

        eventCursor = chordsLayer.getEvent(firstCompassTime);

        generateChordProgression();

        initializePossibleTonalities();

        if (possibleTonalities.size() > 0)
            discardTonalitiesFromFirstChord();

        if (possibleTonalities.size() > 0)
            calculatePossibleTonalitiesFromProgression();

        return generateTonalLayer();
    }
}
