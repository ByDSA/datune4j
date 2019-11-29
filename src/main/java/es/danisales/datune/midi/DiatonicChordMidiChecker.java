package es.danisales.datune.midi;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.RelativeDegree;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.transformations.ChordChecker;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;
import java.util.List;

public class DiatonicChordMidiChecker {
    private DiatonicChordMidiChecker() {
    }

    public static boolean isTonic(DiatonicChordMidi diatonicChordMidi) {
        DiatonicDegree diatonicDegree = diatonicChordMidi.getRoot().getPitch().getDegree();
        switch (diatonicDegree) {
            case I:
            case III:
            case VI:
                return true;
            default:
                return false;
        }
    }

    public static boolean isSubdominant(DiatonicChordMidi diatonicChordMidi) {
        for (DiatonicMidi n : diatonicChordMidi)
            if (n.getPitch().getDegree() == DiatonicDegree.IV)
                return true;
        return false;
    }

    public boolean isDominant(DiatonicChordMidi diatonicChordMidi) {
        DiatonicDegree diatonicDegree = diatonicChordMidi.getRoot().getPitch().getDegree();
        switch (diatonicDegree) {
            case V:
            case VII:
                return true;
            default:
                return false;
        }
    }

    public static boolean contains(List<DiatonicChordMidi> chords, boolean sameOctave, boolean sameTonality, DiatonicChordMidi c) {
        for (DiatonicChordMidi ccc : chords) {
            if (sameTonality && isSameChordNotesAndTonality(ccc, sameOctave, c)
                    || !sameTonality && ChordChecker.hasSameNotesOrder(ccc, sameOctave, c))
                return true;
        }

        return false;
    }

    public static boolean isSameChordNotesAndTonality(DiatonicChordMidi notes1, boolean sameOctave, DiatonicChordMidi notes) {
        return ChordChecker.hasSameNotesOrder(notes1, sameOctave, notes) && notes1.tonality.equals(notes.tonality);
    }


    public static ArrayList<ChromaticMidi> commonNotes(DiatonicChordMidi self, DiatonicChordMidi c) {
        return commonNotes(self, c, false);
    }

    public static ArrayList<ChromaticMidi> commonNotes(DiatonicChordMidi self, DiatonicChordMidi c, boolean sameOctave) {
        ArrayList<ChromaticMidi> ret = new ArrayList<>();

        for (DiatonicMidi nscale1 : self) {
            ChromaticMidi n1 = ChromaticMidi.from(nscale1);
            for (DiatonicMidi nscale2 : c) {
                ChromaticMidi n2 = ChromaticMidi.from(nscale2);

                if (n1.pitch.getMidiCode() == n2.pitch.getMidiCode())
                    ret.add(n2);
                else {
                    Chromatic chromaticn1 = Chromatic.from(n1);
                    Chromatic chromaticn2 = Chromatic.from(n2);
                    if (sameOctave && chromaticn1 == chromaticn2)
                        ret.add(n2);
                }
            }
        }

        return ret;
    }


    public List integerNotationFromRoot(DiatonicChordMidi self) {
        List<IntervalChromatic> distancesAbsolute = null;

        if (self.size() > 0) {
            try {
                distancesAbsolute = new ArrayList<>();

                for (int i = 1; i < self.size(); i++) {
                    DiatonicMidi n1 = self.get(0);
                    DiatonicMidi n2 = self.get(i);
                    IntervalChromatic d = n1.distTo(n2);
                    distancesAbsolute.set(i - 1, d);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return distancesAbsolute;
    }

    public static DiatonicChordMidi relative(DiatonicChordMidi self, DiatonicFunction diatonicFunction) {
        RelativeDegree relativeDegree = self.get(0).getPitch().getDegree();
        if (!(relativeDegree instanceof DiatonicDegree))
            return null;
        Tonality tonality = self.tonality.getRelativeScaleDiatonic((DiatonicDegree) relativeDegree);

        return DiatonicChordMidi.builder()
                .from(diatonicFunction, tonality)
                .octave(self.getOctave())
                .build();
    }

    public static DiatonicMidi getFromBase(DiatonicChordMidi self, int note) {
        DiatonicChordMidi ns;

        DiatonicChordMidi c = self.clone();
        int inversion = self.getInversionNumber();
        if (inversion > 0)
            c.inv(-inversion);
        ns = c;

        // Quitar notas duplicadas (en diferente octava)
        for (int i = 0; i < ns.size(); i++)
            for (int j = i + 1; j < ns.size(); j++) {
                if (ns.get(i).getPitch().getDegree() == ns.get(j).getPitch().getDegree()) {
                    ns.remove(j);
                    j--;
                }
            }

        return ns.getCyclic(note);
    }

/*
    public static boolean isOmitByInterval(DiatonicChordMidi diatonicChordMidi, IntervalDiatonic i) {
        if (diatonicChordMidi.function == null)
            return false;

        switch (i) {
            case THIRD:
                switch ((DiatonicFunction) diatonicChordMidi.function) {
                    case I7_O3:
                    case II7_O3:
                    case III7_O3:
                    case IV7_O3:
                    case V7_O3:
                    case VI7_O3:
                    case VII7_O3:
                    case I9_O3_O7:
                    case II9_O3_O7:
                    case III9_O3_O7:
                    case IV9_O3_O7:
                    case V9_O3_O7:
                    case VI9_O3_O7:
                    case VII9_O3_O7:
                        return true;
                }
                break;
            case FIFTH:
                switch ((DiatonicFunction) diatonicChordMidi.function) {
                    case I_THIRD:
                    case II_THIRD:
                    case III_THIRD:
                    case IV_THIRD:
                    case V_THIRD:
                    case VI_THIRD:
                    case VII_THIRD:
                    case I_SECOND:
                    case II_SECOND:
                    case III_SECOND:
                    case IV_SECOND:
                    case V_SECOND:
                    case VI_SECOND:
                    case VII_SECOND:
                    case I_FOURTH:
                    case II_FOURTH:
                    case III_FOURTH:
                    case IV_FOURTH:
                    case V_FOURTH:
                    case VI_FOURTH:
                    case VII_FOURTH:
                    case I6_O5:
                    case II6_O5:
                    case III6_O5:
                    case IV6_O5:
                    case V6_O5:
                    case VI6_O5:
                    case VII6_O5:
                    case I7_O5:
                    case II7_O5:
                    case III7_O5:
                    case IV7_O5:
                    case V7_O5:
                    case VI7_O5:
                    case VII7_O5:
                        return true;
                }
                break;
            case ELEVENTH:
                break;
            case FIFTEENTH:
                break;
            case FOURTEENTH:
                break;
            case FOURTH:
                break;
            case NINTH:
                break;
            case OCTAVE:
                break;
            case SECOND:
                break;
            case SEVENTH:
                switch ((DiatonicFunction) diatonicChordMidi.function) {
                    case I9_O7:
                    case II9_O7:
                    case III9_O7:
                    case IV9_O7:
                    case V9_O7:
                    case VI9_O7:
                    case VII9_O7:
                    case I9_O3_O7:
                    case II9_O3_O7:
                    case III9_O3_O7:
                    case IV9_O3_O7:
                    case V9_O3_O7:
                    case VI9_O3_O7:
                    case VII9_O3_O7:
                        return true;
                }
                break;
            case SIXTH:
                break;
            case TENTH:
                break;
            case THIRTEENTH:
                break;
            case TWELFTH:
                break;
            case UNISON:
                break;
        }

        return false;
    }
*/

/*
    public static boolean hasByType(DiatonicChordMidi diatonicChordMidi, IntervalDiatonic i) {
        if (diatonicChordMidi.function instanceof DiatonicFunction)
            switch (i) {
                case SECOND:
                    switch ((DiatonicFunction) diatonicChordMidi.function) {
                        case I2:
                        case II2:
                        case III2:
                        case IV2:
                        case V2:
                        case VI2:
                        case VII2:
                        case I_SECOND:
                        case II_SECOND:
                        case III_SECOND:
                        case IV_SECOND:
                        case V_SECOND:
                        case VI_SECOND:
                        case VII_SECOND:
                            return true;
                    }
                    break;
                case THIRD:
                    return !(hasByType(diatonicChordMidi, IntervalDiatonic.SECOND)
                            || hasByType(diatonicChordMidi, IntervalDiatonic.FOURTH))
                            && !isOmitByInterval(diatonicChordMidi, IntervalDiatonic.THIRD);
                case FOURTH:
                    switch ((DiatonicFunction) diatonicChordMidi.function) {
                        case I4:
                        case II4:
                        case III4:
                        case IV4:
                        case V4:
                        case VI4:
                        case VII4:
                        case I_FOURTH:
                        case II_FOURTH:
                        case III_FOURTH:
                        case IV_FOURTH:
                        case V_FOURTH:
                        case VI_FOURTH:
                        case VII_FOURTH:
                            return true;
                    }
                    break;
                case FIFTH:
                    return !isOmitByInterval(diatonicChordMidi, IntervalDiatonic.FIFTH);
                case SIXTH:
                    switch ((DiatonicFunction) diatonicChordMidi.function) {
                        case I6:
                        case II6:
                        case III6:
                        case IV6:
                        case V6:
                        case VI6:
                        case VII6:
                        case I6_O5:
                        case II6_O5:
                        case III6_O5:
                        case IV6_O5:
                        case V6_O5:
                        case VI6_O5:
                        case VII6_O5:
                            return true;
                    }
                    break;
                case SEVENTH:
                    switch ((DiatonicFunction) diatonicChordMidi.function) {
                        case I7:
                        case II7:
                        case III7:
                        case IV7:
                        case V7:
                        case VI7:
                        case VII7:

                        case I7_O5:
                        case II7_O5:
                        case III7_O5:
                        case IV7_O5:
                        case V7_O5:
                        case VI7_O5:
                        case VII7_O5:
                        case I7_O3:
                        case II7_O3:
                        case III7_O3:
                        case IV7_O3:
                        case V7_O3:
                        case VI7_O3:
                        case VII7_O3:

                        case I9:
                        case II9:
                        case III9:
                        case IV9:
                        case V9:
                        case VI9:
                        case VII9:
                        case I11:
                        case II11:
                        case III11:
                        case IV11:
                        case V11:
                        case VI11:
                        case VII11:
                            return true;
                    }
                    break;
                case NINTH:
                    switch ((DiatonicFunction) diatonicChordMidi.function) {
                        case I9:
                        case II9:
                        case III9:
                        case IV9:
                        case V9:
                        case VI9:
                        case VII9:
                        case I9_O7:
                        case II9_O7:
                        case III9_O7:
                        case IV9_O7:
                        case V9_O7:
                        case VI9_O7:
                        case VII9_O7:
                        case I9_O3_O7:
                        case II9_O3_O7:
                        case III9_O3_O7:
                        case IV9_O3_O7:
                        case V9_O3_O7:
                        case VI9_O3_O7:
                        case VII9_O3_O7:
                        case I11:
                        case II11:
                        case III11:
                        case IV11:
                        case V11:
                        case VI11:
                        case VII11:
                            return true;
                    }
                case ELEVENTH:
                    switch ((DiatonicFunction) diatonicChordMidi.function) {
                        case I11:
                        case II11:
                        case III11:
                        case IV11:
                        case V11:
                        case VI11:
                        case VII11:
                            return true;
                    }
                case THIRTEENTH:
                    switch ((DiatonicFunction) diatonicChordMidi.function) {
                        case I13:
                        case II13:
                        case III13:
                        case IV13:
                        case V13:
                        case VI13:
                        case VII13:
                            return true;
                    }
            }
        else
            throw new RuntimeException(diatonicChordMidi.function + " " + diatonicChordMidi.metaTonality);

        return false;
    }
    */
}
