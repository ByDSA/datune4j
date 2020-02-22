package es.danisales.datune.timelayer;

import es.danisales.datastructures.Pair;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.tonality.Tonality;

import java.util.List;

public class MainFunctionLayer extends SequentialTimeEvents<List<TonalLayer.Node>, DurableEvent<List<TonalLayer.Node>, MusicalTime>, MusicalTime> {
    public static class Node extends Pair<Tonality<Chromatic>, MainTonalFunction> {
        private Node(Tonality<Chromatic> key, MainTonalFunction value) {
            super(key, value);
        }

        public static MainFunctionLayer.Node from(Tonality<Chromatic> tonality, MainTonalFunction mainTonalFunction) {
            return new MainFunctionLayer.Node(tonality, mainTonalFunction);
        }
    }
}
