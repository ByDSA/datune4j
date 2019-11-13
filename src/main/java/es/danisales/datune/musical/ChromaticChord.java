package es.danisales.datune.musical;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.pitch.ChordCommon;
import es.danisales.datune.pitch.ChordMutableInterface;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.function.BiFunction;

public final class ChromaticChord extends NormalChordCommon<Chromatic> implements ChordCommon<Chromatic> {
    public static @NonNull ChromaticChord from(@NonNull Iterable<? extends PitchChromaticSingle> chromaticChord) {
        ChromaticChord ret = new ChromaticChord();
        ret.innerChord = ChromaticChordAdapter.from(chromaticChord);
        return ret;
    }

    public static @NonNull ChromaticChord from(@NonNull ChromaticFunction f) {
        ChromaticChord ret = new ChromaticChord();
        ret.innerChord = ChromaticChordAdapter.from(f);
        return ret;
    }

    private ChromaticChord() {
        super();
    }

    @Override
    protected final void turnIntoEnumIfPossible() {
        ChromaticChordEnum chromaticChordEnum = ChromaticChordEnum.from(innerChord);
        if (chromaticChordEnum != null)
            innerChord = chromaticChordEnum;
    }

    @Override
    protected final void turnInnerIntoCustom() {
        innerChord = CustomChromaticChord.from(innerChord);
    }

    @Override
    protected final boolean isEnum() {
        return innerChord instanceof ChromaticChordEnum;
    }

    @Override
    protected final boolean isCustom() {
        return innerChord instanceof CustomChromaticChord;
    }

    @Override
    protected final ChordMutableInterface<Chromatic> castCustom(ChordCommon<Chromatic> chord) {
        return (CustomChromaticChord)innerChord;
    }

    @Override
    protected final ChromaticChord create() {
        return new ChromaticChord();
    }

    @Override
    protected final ChordCommon<Chromatic> createInnerFrom(ChordCommon<Chromatic> chord) {
        return ChromaticChordAdapter.from(chord);
    }

    private ChromaticChord(ChromaticChordInterface chromaticChordInterface) {
        super(chromaticChordInterface);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final List<ChromaticChord> getAllInversions() {
        return (List<ChromaticChord>)super.getAllInversions();
    }

    @Override
    public final ChromaticChord duplicate() {
        return (ChromaticChord)super.duplicate();
    }

    @Override
    public Boolean updateWhatIsIt(BiFunction<List<CustomChromaticChord>, ChordCommon<?>, CustomChromaticChord> fSelectChord) {
        return null;
    }

    @Override
    public Boolean updateWhatIsItIfNeeded() {
        return null;
    }
}
