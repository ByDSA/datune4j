package es.danisales.datune.midi;

import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.lang.ChordNotation;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.musical.DiatonicChordCommon;
import es.danisales.datune.pitch.PitchDiatonic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.utils.MathUtils;
import es.danisales.utils.OrdinalNumbers;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public final class DiatonicChordMidi extends ChordMidi<DiatonicMidi, IntervalDiatonic, PitchDiatonicMidi> implements PitchDiatonic, DiatonicChordCommon<DiatonicMidi> {
    protected Tonality tonality;
    private DiatonicChordMidiInfo info;
    boolean building;

    public static DiatonicChordMidiBuilder builder() {
        return new DiatonicChordMidiBuilder();
    }

    protected DiatonicChordMidi() {
        info = new DiatonicChordMidiInfo(this);
        building = true;
    }

    public void add(@NonNull ChromaticMidi chromaticMidi) throws TonalityException {
        Objects.requireNonNull(chromaticMidi);
        Objects.requireNonNull(tonality);

        DiatonicMidi diatonicMidi = DiatonicMidi.builder()
                .from(chromaticMidi, tonality)
                .build();
        add(diatonicMidi);
    }

    public boolean addAll(@NonNull Iterable<ChromaticMidi> chromaticMidis) throws AddedException, TonalityException {
        for (ChromaticMidi chromaticMidi : chromaticMidis) {
            add(chromaticMidi);
        }

        return true;
    }

    public void setTonality(@NonNull Tonality tonality) {
        this.tonality = Objects.requireNonNull(tonality);

        for ( DiatonicMidi n : this )
            n.getPitch().setTonality(tonality);

        onMutation();
    }

    public void setScaleAsMinor() {
        Tonality newTonality = Tonality.from(tonality.getRoot(), Scale.MINOR);
        setTonality(newTonality);
    }

    public void setScaleAsMajor() {
        Tonality newTonality = Tonality.from(tonality.getRoot(), Scale.MAJOR);
        setTonality( newTonality );
    }

    @Override
    public boolean add(@NonNull DiatonicMidi n) throws AddedException {
        super.add( n );

        setArpegioIfNull();

        return true;
    }

    @Override
    protected void onMutation() {
        if (building)
            return;
        info.update();
    }

    public void addInterval(@NonNull IntervalDiatonic interval) throws AddedException {
        Objects.requireNonNull(interval);

        DiatonicDegree rootDegree = (DiatonicDegree) getRoot().getPitch().getDegree();
        DiatonicDegree targetDegree = DiatonicDegree.add(rootDegree, interval);
        add(targetDegree);
    }

    public void add(@NonNull DiatonicDegree diatonicDegree) throws AddedException {
        PitchDiatonicMidi lastDiatonicPitch = get(size() - 1).pitch;
        PitchDiatonicMidi newDiatonicPitch = lastDiatonicPitch.clone();
        newDiatonicPitch.setDegree(diatonicDegree);
        if (lastDiatonicPitch.getDegree().ordinal() > newDiatonicPitch.getDegree().ordinal())
            newDiatonicPitch.shiftOctave(1);

        DiatonicMidi ns = DiatonicMidi.builder()
                .pitch(newDiatonicPitch)
                .build();
        add( ns );
        setRootIndex(0);
    }

    public Tonality getTonality() {
        return tonality;
    }

    // todo
    @Override
    public void shift(IntervalDiatonic interval) {

        onMutation();
    }

    // todo
    @Override
    public void shiftNegative(IntervalDiatonic interval) {


        onMutation();
    }

    @Override
    public @NonNull DiatonicMidi getCyclic(int noteNumber) {
        DiatonicMidi n;

        int num = MathUtils.rotativeTrim(noteNumber, size());
        n = get(num);

        if (noteNumber >= size()) {
            int octaves = noteNumber / size();
            int index = octaves * IntervalDiatonic.OCTAVE.ordinal();
            n.getPitch().shift(index);
        } else if (noteNumber < 0) {
            int octaves = noteNumber / size() - 1;
            int index = -octaves * IntervalDiatonic.OCTAVE.ordinal();
            n.getPitch().shift(index);
        } else
            n = get(num).clone();

        return n;
    }

    public @NonNull DiatonicChordMidiInfo getInfo() {
        return info;
    }

    @Override
    public void inv() {
        super.inv();
        get(size() - 1).getPitch().shiftOctave(1);
    }


    @Override
    public void inv(int n) {
        building = true;
        super.inv(n);
        building = false;
        info.update();
    }

    @Override
    public String toString() {
        if (size() == 0)
            return ChordNotation.EMPTY_CHORD;
        else if (size() == 1)
            return get(0).toString();
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(info.getChromaticChord().toString())
                    .append(" (");
            if (info.getChromaticChord().getInversionNumber() > 0) {
                stringBuilder
                        .append(OrdinalNumbers.getStringFrom(info.getChromaticChord().getInversionNumber()))
                        .append(" inv, ");
            }

            stringBuilder.append(info.getFunction())
                    .append(", ")
                    .append(tonality)
                    .append(", oct ")
                    .append(getOctave())
                    .append(")");

            return stringBuilder.toString();
        }
    }

    @Override
    public @NonNull DiatonicChordMidi clone() {
        DiatonicChordMidi diatonicChordMidi = (DiatonicChordMidi) commonClone(new DiatonicChordMidi());
        diatonicChordMidi.tonality = tonality.clone();
        diatonicChordMidi.rootIndex = getRootIndex();
        diatonicChordMidi.info = info == null ? null : info.clone();
        diatonicChordMidi.building = false;
        diatonicChordMidi.onMutation();

        return diatonicChordMidi;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DiatonicChordMidi))
            return false;

        DiatonicChordMidi dcm = (DiatonicChordMidi) o;

        return super.equals(dcm)
                && tonality.equals(dcm.tonality);
    }

    // todo

    /*
    @Override
    public int hashCode() {
        return 47 * ( super.hashCode() + );
    }*/
}
