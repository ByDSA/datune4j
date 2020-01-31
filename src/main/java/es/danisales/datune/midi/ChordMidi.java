package es.danisales.datune.midi;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.midi.pitch.PitchOctaveMidiEditable;
import es.danisales.datune.pitch.PitchOctave;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class ChordMidi
        extends ListProxy<NoteMidi>
        implements Durable, Velocitiable, PitchOctaveMidiEditable, PitchOctave, EventComplex {

    public ChordMidi(List<NoteMidi> listAdapter) {
        super(listAdapter);
    }

    public ChordMidi() {
        this(new ArrayList<>());
    }

    public static ChromaticChordMidiBuilder builder() {
        return new ChromaticChordMidiBuilder();
    }

    public void compact() {
        for (int i = 1; i < this.size(); i++) {
            int distFromPrevious = DistanceCalculator.calculateDistanceInSemitones(get(i - 1), get(i));
            if (distFromPrevious > IntervalChromatic.PERFECT_OCTAVE.getSemitones()) {
                try {
                    get(i).getPitch().shiftOctave(
                            -distFromPrevious / IntervalChromatic.PERFECT_OCTAVE.getSemitones()
                    );
                } catch (PitchMidiException e) {
                    NeverHappensException.msg("Si antes era válido, la versión compactada lo seguirá siendo siempre");
                }
            }
        }
    }

    @Override
    public @NonNull ChordMidi clone() {
        ChordMidi chromaticChordMidi = new ChordMidi();
        for (NoteMidi n : this)
            chromaticChordMidi.add(n.clone());

        chromaticChordMidi.length = length;
        return chromaticChordMidi;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (NoteMidi chromaticMidi : this)
            stringBuilder.append(chromaticMidi.toString()).append("\n");

        return stringBuilder.toString();
    }

    protected int		length;

    void assign(@NonNull ChordMidi c) {
        Objects.requireNonNull(c);
        clear();
        this.addAll(c);
        length = c.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public EventSequence getEvents() {
        EventSequence es = new EventSequence();

        for (NoteMidi noteMidi : this)
            es.add(0, noteMidi);
        return es;
    }

    private int getMaxNoteLength() {
        int max = length;
        for ( NoteMidi n : this )
            max = Math.max( max, n.getLength() );

        return max;
    }

    @SuppressWarnings("WeakerAccess")
    public boolean containsPitch(@NonNull Object o) {
        if (!(o instanceof NoteMidi))
            return false;

        NoteMidi nIn = (NoteMidi) o;
        int nInCode = nIn.pitch.getMidiCode();
        for (NoteMidi note : this)
            if (note.pitch.getMidiCode() == nInCode)
                return true;

        return false;
    }

    @SuppressWarnings("WeakerAccess")
    public boolean containsPitchAll(@NonNull Collection<NoteMidi> c) {
        for (NoteMidi note : c)
            if (!containsPitch(note))
                return false;

        return true;
    }

    @Override
    public boolean add(@NonNull NoteMidi n) throws AddedException {
        n = Objects.requireNonNull(n);
        if (!containsPitch(n)) {
            super.add(n);
            sortByPitch();
        } else
            throw new AddedException(n, this);

        return true;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends NoteMidi> collection) {
        boolean ret = super.addAll(collection);
        sortByPitch();
        return ret;
    }

    @Override
    public boolean addAll(int index, @NonNull Collection<? extends NoteMidi> collection) {
        boolean ret = super.addAll(index, collection);
        sortByPitch();
        return ret;
    }

    @Override
    public void add(int n, @NonNull NoteMidi chromaticMidi) throws AddedException {
        super.add(n, Objects.requireNonNull(chromaticMidi));
        sortByPitch();
    }

    @SuppressWarnings("unchecked")
    private void sortByPitch() {
        this.sort(
                Comparator.comparing(NoteMidi::getPitch)
        );
    }

    @Override
    public void setVelocity(int v) {
        for (NoteMidi n : this) {
            int vel = (int) Math.round(n.getVelocity() * v / 100.0);

            if (vel < 0)
                vel = 0;
            else if (vel > 128)
                vel = 128;

            n.setVelocity(vel);
        }
    }

    @Override
    public int getVelocity() {
        return getMaxNoteVelocity();
    }

    private int getMaxNoteVelocity() {
        int max = -1;
        for (NoteMidi n : this)
            max = Math.max(max, n.getVelocity());

        return max;
    }

    @Override
    public void setLength(int d) {
        length = d;
    }

    @Override
    public int getLength() {
        return getMaxNoteLength();
    }

    @Override
    public void shiftOctave(int octaveShift) throws PitchMidiException {
        for (NoteMidi n : this) {
            n.getPitch().shiftOctave(octaveShift);
        }
    }

    @Override
    public void setOctave(int newOctave) throws PitchMidiException {
        int diff = newOctave - getOctave();
        shiftOctave( diff );
    }

    @Override
    public int getOctave() {
        return get(0).getPitch().getOctave();
    }

    @Override
    public boolean equals(Object o) {
        if ( !( o instanceof ChordMidi ) )
            return false;

        ChordMidi cm = (ChordMidi) o;


        return super.equals(cm) && length == cm.length;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Integer.hashCode(length);
    }
}
