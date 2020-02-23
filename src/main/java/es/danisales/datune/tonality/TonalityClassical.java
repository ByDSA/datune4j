package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.DiatonicAlt;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkState;

public class TonalityClassical extends Tonality<DiatonicAlt> {
    public static final TonalityClassical C = new TonalityClassical(TonalityInnerImmutable.C);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical Db = new TonalityClassical(TonalityInnerImmutable.Db);
    public static final TonalityClassical D = new TonalityClassical(TonalityInnerImmutable.D);
    public static final TonalityClassical Eb = new TonalityClassical(TonalityInnerImmutable.Eb);
    public static final TonalityClassical E = new TonalityClassical(TonalityInnerImmutable.E);
    public static final TonalityClassical F = new TonalityClassical(TonalityInnerImmutable.F);
    public static final TonalityClassical FF = new TonalityClassical(TonalityInnerImmutable.FF);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical Gb = new TonalityClassical(TonalityInnerImmutable.Gb);
    public static final TonalityClassical G = new TonalityClassical(TonalityInnerImmutable.G);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical Ab = new TonalityClassical(TonalityInnerImmutable.Ab);
    public static final TonalityClassical A = new TonalityClassical(TonalityInnerImmutable.A);
    public static final TonalityClassical Bb = new TonalityClassical(TonalityInnerImmutable.Bb);
    public static final TonalityClassical B = new TonalityClassical(TonalityInnerImmutable.B);

    public static final TonalityClassical Cm = new TonalityClassical(TonalityInnerImmutable.Cm);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical CCm = new TonalityClassical(TonalityInnerImmutable.CCm);
    public static final TonalityClassical Dm = new TonalityClassical(TonalityInnerImmutable.Dm);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical DDm = new TonalityClassical(TonalityInnerImmutable.DDm);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical Ebm = new TonalityClassical(TonalityInnerImmutable.Ebm);
    public static final TonalityClassical Em = new TonalityClassical(TonalityInnerImmutable.Em);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical Fm = new TonalityClassical(TonalityInnerImmutable.Fm);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical FFm = new TonalityClassical(TonalityInnerImmutable.FFm);
    public static final TonalityClassical Gm = new TonalityClassical(TonalityInnerImmutable.Gm);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical GGm = new TonalityClassical(TonalityInnerImmutable.GGm);
    public static final TonalityClassical Am = new TonalityClassical(TonalityInnerImmutable.Am);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical Bbm = new TonalityClassical(TonalityInnerImmutable.Bbm);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityClassical Bm = new TonalityClassical(TonalityInnerImmutable.Bm);

    /**
     * END CONSTANT TONALITIES
     ******************************************************************************/

    protected TonalityClassical(TonalityInner<DiatonicAlt> tonalityInterface, boolean immutable) {
        super(tonalityInterface, immutable);
    }

    public TonalityClassical(TonalityInnerImmutable cm) {
        super(cm);
    }

    @Override
    public @NonNull List<TonalityClassical> getParallelModes() {
        List<TonalityClassical> ret = new ArrayList<>();

        for ( Scale scale : getScale().getModes() ) {
            TonalityClassical tonality = Tonality.from(getRoot(), scale);
            ret.add(tonality);
        }

        return ret;
    }

    int getDiatonicAlterationsNumber() {
        Objects.requireNonNull(getNotes());

        int ret = 0;
        for ( DiatonicAlt c : getNotes())
            ret += c.getUnsignedAlterations();

        return ret;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public TonalityClassical clone() {
        return from(getRoot(), getScale());
    }
}
