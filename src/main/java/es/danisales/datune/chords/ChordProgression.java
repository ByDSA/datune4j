package es.danisales.datune.chords;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.degrees.octave.CyclicDegree;

import java.util.ArrayList;

public class ChordProgression<C extends CyclicDegree>
        extends ListProxy<Chord<C>> {
    private ChordProgression() {
        super(new ArrayList<>());
    }

    public static <C extends CyclicDegree> ChordProgression<C> create() {
        return new ChordProgression<>();
    }
}
