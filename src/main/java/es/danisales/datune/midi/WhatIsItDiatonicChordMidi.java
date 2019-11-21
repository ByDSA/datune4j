package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.WhatIsIt;
import es.danisales.datune.pitch.ChordCommon;

import java.util.List;

public class WhatIsItDiatonicChordMidi {
    private WhatIsItDiatonicChordMidi() {
    }

    public static void  updateWhatIsIt(DiatonicChordMidi diatonicChordMidi) {
        /* WhatIsIt.updateWhatIsIt( diatonicChordMidi,
                (List<ChromaticChord> chords, ChordCommon<?> self) -> {
                    diatonicChordMidi.updateFunctionIfNull();
                    ChromaticChord ret = ChromaticChord.createEmpty();
                    if ( diatonicChordMidi.function instanceof DiatonicFunction)
                        ret.addAll( ChromaticChord.from(diatonicChordMidi.tonality, (DiatonicFunction) diatonicChordMidi.function ) );
                    else
                        ret.addAll( ChromaticChord.from(diatonicChordMidi.tonality, (ChromaticFunction) diatonicChordMidi.function ) );

                    assert diatonicChordMidi.size() == ret.size();

                    if ( diatonicChordMidi.getRootPos() != 0 ) {
                        ret = ret.duplicate();
                        ret.inv(ret.size() - diatonicChordMidi.getRootPos());
                    }

                    //assert ret.meta.str != null : " " + ( function instanceof DiatonicFunction );

                    return ret;
                }
        );*/
    }
}
