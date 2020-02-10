package es.danisales.datune.timelayer;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.function.MainTonalFunction;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityRetrieval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    private List<Tonality<Chromatic>> possibleTonalities;

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
        possibleTonalities.addAll(TonalityRetrieval.ET12.ALL_MAJOR_MODES);
        possibleTonalities.addAll(TonalityRetrieval.ET12.ALL_MELODIC_MINOR);
        possibleTonalities.addAll(TonalityRetrieval.ET12.ALL_HARMONIC_MINOR);
    }

    private void showPossibleTonalities() {
        for (Tonality<Chromatic> tonality : possibleTonalities)
            System.out.println(tonality);
    }

    private void discardTonalitiesFromFirstChord() {
        ChromaticFunction rootFunction = DiatonicFunction.I7;

        for (int i = 0; i < possibleTonalities.size(); i++) {
            Tonality<Chromatic> tonality = possibleTonalities.get(i);
            ChromaticChord rootChord = ChromaticChord.from(tonality, rootFunction);
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
        possibleTonalities = TonalityRetrieval.fromChordProgression(chromaticChordProgression, possibleTonalities);

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

            for (Tonality<Chromatic> tonality : possibleTonalities) {
                TonalLayer.Node node = TonalLayer.Node.from(tonality, tonality.getFunctionFrom(entry1.getNote()));
                l.add(node);
            }
        }

        return tonalLayer;
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
