package es.danisales.datune.midi;

public class WhatIsItDiatonicChordMidi {
    private WhatIsItDiatonicChordMidi() {
    }

    public static void  updateWhatIsIt(DiatonicChordMidi diatonicChordMidi) {
        /* WhatIsIt.updateWhatIsIt( diatonicChordMidi,
                (List<ChromaticChord> chords, ChordCommon<?> self) -> {
                    diatonicChordMidi.updateFunctionIfNull();
                    ChromaticChord ret = ChromaticChord.createEmpty();
                    if ( diatonicChordMidi.function instanceof DiatonicFunction)
                        ret.addAll( ChromaticChord.fromFirst(diatonicChordMidi.tonality, (DiatonicFunction) diatonicChordMidi.function ) );
                    else
                        ret.addAll( ChromaticChord.fromFirst(diatonicChordMidi.tonality, (ChromaticFunction) diatonicChordMidi.function ) );

                    assert diatonicChordMidi.size() == ret.size();

                    if ( diatonicChordMidi.getRootIndex() != 0 ) {
                        ret = ret.duplicate();
                        ret.inv(ret.size() - diatonicChordMidi.getRootIndex());
                    }

                    //assert ret.meta.str != null : " " + ( function instanceof DiatonicFunction );

                    return ret;
                }
        );*/
    }
}
