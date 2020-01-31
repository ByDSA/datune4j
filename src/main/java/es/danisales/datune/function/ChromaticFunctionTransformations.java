package es.danisales.datune.function;

import es.danisales.datune.degrees.octave.Diatonic;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ChromaticFunctionTransformations {
    private ChromaticFunctionTransformations() {
    }

    public static @Nullable ChromaticFunction shift(ChromaticFunction chromaticFunction, int i) {
        i = MathUtils.rotativeTrim(i, Diatonic.NUMBER);
        switch (chromaticFunction) {
            case I:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.II;
                    case 2: return ChromaticFunction.III;
                    case 3: return ChromaticFunction.IV;
                    case 4: return ChromaticFunction.V;
                    case 5: return ChromaticFunction.VI;
                    case 6: return ChromaticFunction.VII;
                }
            case II:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.III;
                    case 2: return ChromaticFunction.IV;
                    case 3: return ChromaticFunction.V;
                    case 4: return ChromaticFunction.VI;
                    case 5: return ChromaticFunction.VII;
                    case 6: return ChromaticFunction.I;
                }
            case III:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.IV;
                    case 2: return ChromaticFunction.V;
                    case 3: return ChromaticFunction.VI;
                    case 4: return ChromaticFunction.VII;
                    case 5: return ChromaticFunction.I;
                    case 6: return ChromaticFunction.II;
                }
            case IV:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.V;
                    case 2: return ChromaticFunction.VI;
                    case 3: return ChromaticFunction.VII;
                    case 4: return ChromaticFunction.I;
                    case 5: return ChromaticFunction.II;
                    case 6: return ChromaticFunction.III;
                }
            case V:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.VI;
                    case 2: return ChromaticFunction.VII;
                    case 3: return ChromaticFunction.I;
                    case 4: return ChromaticFunction.II;
                    case 5: return ChromaticFunction.III;
                    case 6: return ChromaticFunction.IV;
                }
            case VI:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.VII;
                    case 2: return ChromaticFunction.I;
                    case 3: return ChromaticFunction.II;
                    case 4: return ChromaticFunction.III;
                    case 5: return ChromaticFunction.IV;
                    case 6: return ChromaticFunction.V;
                }
            case VII:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.I;
                    case 2: return ChromaticFunction.II;
                    case 3: return ChromaticFunction.III;
                    case 4: return ChromaticFunction.IV;
                    case 5: return ChromaticFunction.V;
                    case 6: return ChromaticFunction.VI;
                }
            case i:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.ii;
                    case 2: return ChromaticFunction.iii;
                    case 3: return ChromaticFunction.iv;
                    case 4: return ChromaticFunction.v;
                    case 5: return ChromaticFunction.vi;
                    case 6: return ChromaticFunction.vii;
                }
            case ii:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.iii;
                    case 2: return ChromaticFunction.iv;
                    case 3: return ChromaticFunction.v;
                    case 4: return ChromaticFunction.vi;
                    case 5: return ChromaticFunction.vii;
                    case 6: return ChromaticFunction.i;
                }
            case iii:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.iv;
                    case 2: return ChromaticFunction.v;
                    case 3: return ChromaticFunction.vi;
                    case 4: return ChromaticFunction.vii;
                    case 5: return ChromaticFunction.i;
                    case 6: return ChromaticFunction.ii;
                }
            case iv:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.v;
                    case 2: return ChromaticFunction.vi;
                    case 3: return ChromaticFunction.vii;
                    case 4: return ChromaticFunction.i;
                    case 5: return ChromaticFunction.ii;
                    case 6: return ChromaticFunction.iii;
                }
            case v:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.vi;
                    case 2: return ChromaticFunction.vii;
                    case 3: return ChromaticFunction.i;
                    case 4: return ChromaticFunction.ii;
                    case 5: return ChromaticFunction.iii;
                    case 6: return ChromaticFunction.iv;
                }
            case vi:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.vii;
                    case 2: return ChromaticFunction.i;
                    case 3: return ChromaticFunction.ii;
                    case 4: return ChromaticFunction.iii;
                    case 5: return ChromaticFunction.iv;
                    case 6: return ChromaticFunction.v;
                }
            case vii:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.i;
                    case 2: return ChromaticFunction.ii;
                    case 3: return ChromaticFunction.iii;
                    case 4: return ChromaticFunction.iv;
                    case 5: return ChromaticFunction.v;
                    case 6: return ChromaticFunction.vi;
                }
            case I0:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.II0;
                    case 2: return ChromaticFunction.III0;
                    case 3: return ChromaticFunction.IV0;
                    case 4: return ChromaticFunction.V0;
                    case 5: return ChromaticFunction.VI0;
                    case 6: return ChromaticFunction.VII0;
                }
            case II0:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.III0;
                    case 2: return ChromaticFunction.IV0;
                    case 3: return ChromaticFunction.V0;
                    case 4: return ChromaticFunction.VI0;
                    case 5: return ChromaticFunction.VII0;
                    case 6: return ChromaticFunction.I0;
                }
            case III0:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.IV0;
                    case 2: return ChromaticFunction.V0;
                    case 3: return ChromaticFunction.VI0;
                    case 4: return ChromaticFunction.VII0;
                    case 5: return ChromaticFunction.I0;
                    case 6: return ChromaticFunction.II0;
                }
            case IV0:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.V0;
                    case 2: return ChromaticFunction.VI0;
                    case 3: return ChromaticFunction.VII0;
                    case 4: return ChromaticFunction.I0;
                    case 5: return ChromaticFunction.II0;
                    case 6: return ChromaticFunction.III0;
                }
            case V0:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.VI0;
                    case 2: return ChromaticFunction.VII0;
                    case 3: return ChromaticFunction.I0;
                    case 4: return ChromaticFunction.II0;
                    case 5: return ChromaticFunction.III0;
                    case 6: return ChromaticFunction.IV0;
                }
            case VI0:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.VII0;
                    case 2: return ChromaticFunction.I0;
                    case 3: return ChromaticFunction.II0;
                    case 4: return ChromaticFunction.III0;
                    case 5: return ChromaticFunction.IV0;
                    case 6: return ChromaticFunction.V0;
                }
            case VII0:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.I0;
                    case 2: return ChromaticFunction.II0;
                    case 3: return ChromaticFunction.III0;
                    case 4: return ChromaticFunction.IV0;
                    case 5: return ChromaticFunction.V0;
                    case 6: return ChromaticFunction.VI0;
                }
            case I5:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.II5;
                    case 2: return ChromaticFunction.III5;
                    case 3: return ChromaticFunction.IV5;
                    case 4: return ChromaticFunction.V5;
                    case 5: return ChromaticFunction.VI5;
                    case 6: return ChromaticFunction.VII5;
                }
            case II5:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.III5;
                    case 2: return ChromaticFunction.IV5;
                    case 3: return ChromaticFunction.V5;
                    case 4: return ChromaticFunction.VI5;
                    case 5: return ChromaticFunction.VII5;
                    case 6: return ChromaticFunction.I5;
                }
            case III5:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.IV5;
                    case 2: return ChromaticFunction.V5;
                    case 3: return ChromaticFunction.VI5;
                    case 4: return ChromaticFunction.VII5;
                    case 5: return ChromaticFunction.I5;
                    case 6: return ChromaticFunction.II5;
                }
            case IV5:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.V5;
                    case 2: return ChromaticFunction.VI5;
                    case 3: return ChromaticFunction.VII5;
                    case 4: return ChromaticFunction.I5;
                    case 5: return ChromaticFunction.II5;
                    case 6: return ChromaticFunction.III5;
                }
            case V5:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.VI5;
                    case 2: return ChromaticFunction.VII5;
                    case 3: return ChromaticFunction.I5;
                    case 4: return ChromaticFunction.II5;
                    case 5: return ChromaticFunction.III5;
                    case 6: return ChromaticFunction.IV5;
                }
            case VI5:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.VII5;
                    case 2: return ChromaticFunction.I5;
                    case 3: return ChromaticFunction.II5;
                    case 4: return ChromaticFunction.III5;
                    case 5: return ChromaticFunction.IV5;
                    case 6: return ChromaticFunction.V5;
                }
            case VII5:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.I5;
                    case 2: return ChromaticFunction.II5;
                    case 3: return ChromaticFunction.III5;
                    case 4: return ChromaticFunction.IV5;
                    case 5: return ChromaticFunction.V5;
                    case 6: return ChromaticFunction.VI5;
                }
            case ISUS4:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.IISUS4;
                    case 2: return ChromaticFunction.bIIISUS4;
                    case 3: return ChromaticFunction.IVSUS4;
                    case 4: return ChromaticFunction.VSUS4;
                    case 5: return ChromaticFunction.VISUS4;
                    case 6: return ChromaticFunction.bVIISUS4;
                }
            case IISUS4:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.bIIISUS4;
                    case 2: return ChromaticFunction.IVSUS4;
                    case 3: return ChromaticFunction.VSUS4;
                    case 4: return ChromaticFunction.VISUS4;
                    case 5: return ChromaticFunction.bVIISUS4;
                    case 6: return ChromaticFunction.ISUS4;
                }
            case bIIISUS4:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.IVSUS4;
                    case 2: return ChromaticFunction.VSUS4;
                    case 3: return ChromaticFunction.VISUS4;
                    case 4: return ChromaticFunction.bVIISUS4;
                    case 5: return ChromaticFunction.ISUS4;
                    case 6: return ChromaticFunction.IISUS4;
                }
            case IVSUS4:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.VSUS4;
                    case 2: return ChromaticFunction.VISUS4;
                    case 3: return ChromaticFunction.bVIISUS4;
                    case 4: return ChromaticFunction.ISUS4;
                    case 5: return ChromaticFunction.IISUS4;
                    case 6: return ChromaticFunction.bIIISUS4;
                }
            case VSUS4:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.VISUS4;
                    case 2: return ChromaticFunction.bVIISUS4;
                    case 3: return ChromaticFunction.ISUS4;
                    case 4: return ChromaticFunction.IISUS4;
                    case 5: return ChromaticFunction.bIIISUS4;
                    case 6: return ChromaticFunction.IVSUS4;
                }
            case VISUS4:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.bVIISUS4;
                    case 2: return ChromaticFunction.ISUS4;
                    case 3: return ChromaticFunction.IISUS4;
                    case 4: return ChromaticFunction.bIIISUS4;
                    case 5: return ChromaticFunction.IVSUS4;
                    case 6: return ChromaticFunction.VSUS4;
                }
            case bVIISUS4:
                switch (i) {
                    default:
                    case 0: return chromaticFunction;
                    case 1: return ChromaticFunction.ISUS4;
                    case 2: return ChromaticFunction.IISUS4;
                    case 3: return ChromaticFunction.bIIISUS4;
                    case 4: return ChromaticFunction.IVSUS4;
                    case 5: return ChromaticFunction.VSUS4;
                    case 6: return ChromaticFunction.VISUS4;
                }
        }

        return null;
    }
}
