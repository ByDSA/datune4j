package es.danisales.datune.function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class SecondaryDominant extends CompoundFunction {
    public static final SecondaryDominant V_II = new SecondaryDominant("V/II", II, V);
    public static final SecondaryDominant V_III = new SecondaryDominant("V/III", III, V);
    public static final SecondaryDominant V_IV = new SecondaryDominant("V/IV", IV, V);
    public static final SecondaryDominant V_V = new SecondaryDominant("V/V", V, V);
    public static final SecondaryDominant V_VI = new SecondaryDominant("V/VI", VI, V);

    public static final SecondaryDominant V7_II = new SecondaryDominant("V7/II", II, V7);
    public static final SecondaryDominant V7_III = new SecondaryDominant("V7/III", III, V7);
    public static final SecondaryDominant V7_IV = new SecondaryDominant("V7/IV", IV, V7);
    public static final SecondaryDominant V7_V = new SecondaryDominant("V/7V", V, V7);
    public static final SecondaryDominant V7_VI = new SecondaryDominant("V7/VI", VI, V7);

    public static final SecondaryDominant SUBV7 = new SecondaryDominant("SUBV7/I", I, bII7);
    public static final SecondaryDominant SUBV7_II = new SecondaryDominant("SUBV7/II", II, bII7);
    public static final SecondaryDominant SUBV7_III = new SecondaryDominant("SUBV7/III", III, bII7);
    public static final SecondaryDominant SUBV7_IV = new SecondaryDominant("SUBV7/IV", IV, bII7);
    public static final SecondaryDominant SUBV7_V = new SecondaryDominant("SUBV7/V", V, bII7);
    public static final SecondaryDominant SUBV7_VI = new SecondaryDominant("SUBV7/VI", VI, bII7);

    private static final List<SecondaryDominant> SECONDARY_DOMINANT_FUNCTIONS = new ImmutableList.Builder<SecondaryDominant>()
            .add(V_II, V_III, V_IV, V_V, V_VI)
            .add(V7_II, V7_III, V7_IV, V7_V, V7_VI)
            .add(SUBV7_II, SUBV7_III, SUBV7_IV, SUBV7_V, SUBV7_VI)

            .build();

    private static final Map<SecondaryDominant, String> defaultStringValues = ImmutableMap.<SecondaryDominant, String>builder()
            .put(V_II, "V/II")
            .put(V_III, "V/III")
            .put(V_IV, "V/IV")
            .put(V_V, "V/V")
            .put(V_VI, "V/VI")

            .put(V7_II, "V7/II")
            .put(V7_III, "V7/III")
            .put(V7_IV, "V7/IV")
            .put(V7_V, "V7/V")
            .put(V7_VI, "V7/VI")

            .put(SUBV7_II, "SUBV7/II")
            .put(SUBV7_III, "SUBV7/III")
            .put(SUBV7_IV, "SUBV7/IV")
            .put(SUBV7_V, "SUBV7/V")
            .put(SUBV7_VI, "SUBV7/VI")

            .build();

    private SecondaryDominant(String str, @NonNull ChromaticDegreeFunction... array) {
        super(str, array);
    }

    public static List<SecondaryDominant> values() {
        return SECONDARY_DOMINANT_FUNCTIONS;
    }

    @Override
    public String toString() {
        checkNotNull(defaultStringValues);

        String str = defaultStringValues.get(this);
        if (str != null)
            return str;

        return getChromaticDegree() + " " + getChromaticChordPattern();
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof SecondaryDominant) )
            return false;

        SecondaryDominant secondaryDominant = (SecondaryDominant)o;

        return super.equals(secondaryDominant);
    }
}
