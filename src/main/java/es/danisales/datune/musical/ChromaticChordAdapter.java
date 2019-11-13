package es.danisales.datune.musical;

import es.danisales.datastructures.EnumTreeSet;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.PitchChromaticSingle;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class ChromaticChordAdapter {
    private ChromaticChordAdapter() {
    }

    public static <T extends PitchChromaticSingle> ChromaticChordEnum from(Iterable<T> chord) {
        List<Chromatic> notes = new ArrayList<>();
        for (T t : chord) {
            Chromatic chromatic = ChromaticAdapter.from(t);
            notes.add(chromatic);
        }
        EnumTreeSet<Chromatic, ChromaticChordEnum> node = ChromaticChordEnum.chordTree.getNode( notes );
        if (node == null)
            return null;
        EnumSet<ChromaticChordEnum> content = node.getContent();
        if ( content.size() != 1 )
            return null;

        return content.iterator().next();
    }

    public static ChromaticChordInterface from(ChromaticFunction f) {
        return null; // todo
    }
}
