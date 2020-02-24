package es.danisales.datune.tonality;

import es.danisales.datune.degrees.octave.Chromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class TonalityModern extends Tonality<Chromatic> {
    public static final TonalityModern C = Tonality.from(Chromatic.C, Scale.MAJOR);
    public static final TonalityModern CC = Tonality.from(Chromatic.CC, Scale.MAJOR);
    public static final TonalityModern D = Tonality.from(Chromatic.D, Scale.MAJOR);
    public static final TonalityModern DD = Tonality.from(Chromatic.DD, Scale.MAJOR);
    public static final TonalityModern E = Tonality.from(Chromatic.E, Scale.MAJOR);
    public static final TonalityModern F = Tonality.from(Chromatic.F, Scale.MAJOR);
    public static final TonalityModern FF = Tonality.from(Chromatic.FF, Scale.MAJOR);
    public static final TonalityModern G = Tonality.from(Chromatic.G, Scale.MAJOR);
    public static final TonalityModern GG = Tonality.from(Chromatic.GG, Scale.MAJOR);
    public static final TonalityModern A = Tonality.from(Chromatic.A, Scale.MAJOR);
    public static final TonalityModern AA = Tonality.from(Chromatic.AA, Scale.MAJOR);
    public static final TonalityModern B = Tonality.from(Chromatic.B, Scale.MAJOR);

    public static final TonalityModern Cm = Tonality.from(Chromatic.C, Scale.MINOR);
    public static final TonalityModern CCm = Tonality.from(Chromatic.CC, Scale.MINOR);
    public static final TonalityModern Dm = Tonality.from(Chromatic.D, Scale.MINOR);
    public static final TonalityModern DDm = Tonality.from(Chromatic.DD, Scale.MINOR);
    public static final TonalityModern Em = Tonality.from(Chromatic.E, Scale.MINOR);
    public static final TonalityModern Fm = Tonality.from(Chromatic.F, Scale.MINOR);
    public static final TonalityModern FFm = Tonality.from(Chromatic.FF, Scale.MINOR);
    public static final TonalityModern Gm = Tonality.from(Chromatic.G, Scale.MINOR);
    public static final TonalityModern GGm = Tonality.from(Chromatic.GG, Scale.MINOR);
    public static final TonalityModern Am = Tonality.from(Chromatic.A, Scale.MINOR);
    @SuppressWarnings("WeakerAccess")
    public static final TonalityModern AAm = Tonality.from(Chromatic.AA, Scale.MINOR);
    public static final TonalityModern Bm = Tonality.from(Chromatic.B, Scale.MINOR);

    /**
     * END CONSTANT TONALITIES
     ******************************************************************************/

    TonalityModern(TonalityInner<Chromatic> tonalityInterface, boolean immutable) {
        super(tonalityInterface, immutable);
    }

    @Override
    public @NonNull List<TonalityModern> getParallelModes() {
        List<TonalityModern> ret = new ArrayList<>();

        for ( Scale scale : getScale().getModes() ) {
            TonalityModern tonality = Tonality.from(getRoot(), scale);
            ret.add(tonality);
        }

        return ret;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public TonalityModern clone() {
        return from(getRoot(), getScale());
    }
}
