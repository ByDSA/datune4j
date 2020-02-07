package es.danisales.datune.rhythm;

import es.danisales.datastructures.Pair;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class TonalLayer extends SequentialTimeEvents<List<TonalLayer.Node>, DurableEvent<List<TonalLayer.Node>, MusicalTime>, MusicalTime> {
    static class Node extends Pair<Tonality<Chromatic>, HarmonicFunction> {
        private Node(Tonality<Chromatic> key, HarmonicFunction value) {
            super(key, value);
        }

        public static Node from(Tonality<Chromatic> tonality, HarmonicFunction harmonicFunction) {
            return new Node(tonality, harmonicFunction);
        }
    }

    private TonalLayer() {
    }

    public static @NonNull TonalLayer create() {
        return new TonalLayer();
    }
}
