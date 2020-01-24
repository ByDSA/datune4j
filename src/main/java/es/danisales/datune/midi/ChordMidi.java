package es.danisales.datune.midi;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.midi.arpegios.Arpeggio;
import es.danisales.datune.midi.arpegios.ArpeggioDefault;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.midi.pitch.PitchOctaveMidiEditable;
import es.danisales.datune.pitch.PitchOctave;
import es.danisales.utils.HashingUtils;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

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
            chromaticChordMidi.add((NoteMidi) n.clone());

        if (arpegio != null)
            chromaticChordMidi.arpegio = arpegio.clone();
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

    protected Arpeggio arpegio;
    protected int		length;

    void assign(@NonNull ChordMidi c) {
        Objects.requireNonNull(c);
        clear();
        this.addAll(c);
        arpegio = c.arpegio;
        length = c.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public EventSequence getEvents() {
        EventSequence es = new EventSequence();

        Arpeggio aNodes;
        if ( arpegio == null )
            this.setArpeggio(new ArpeggioDefault());
        int arpDuration = arpegio.getLength();

        if ( length != 0 && length > arpDuration ) {
            aNodes = arpegio.clone();
            int newArpDuration = arpDuration;

            while ( length > newArpDuration ) {
                int currentLoop = newArpDuration;
                for (Arpeggio.Node n : arpegio.getNodes()) {
                    aNodes.add( currentLoop + n.time, n.note, n.length );
                }
                newArpDuration += arpDuration;
            }
        } else
            aNodes = arpegio;

        for (Arpeggio.Node node : aNodes.getNodes()) {
            if ( length != 0 && node.time > length || node.note < 0 )
                continue;

            NoteMidi n = get( node.note ).clone();

            if ( length != 0 )
                n.setLength( Math.min( node.time + node.length, length ) - node.time );
            else
                n.setLength( node.length );
            es.add( node.time, n );
        }
        return es;
    }

    private int getMaxNoteLength() {
        int max = length;
        for ( NoteMidi n : this )
            max = Math.max( max, n.getLength() );

        return max;
    }

    public @Nullable Arpeggio getArpeggio() {
        return arpegio;
    }

    public void setArpeggio(@NonNull Arpeggio a) {
        Objects.requireNonNull(a);

        arpegio = a.clone();
        arpegio.setChord( this );
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
        if (arpegio == null)
            return getMaxNoteLength();
        else
            return arpegio.getLength();
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

    void setArpeggioIfNull() {
        if (arpegio == null)
            setArpeggio(new ArpeggioDefault());
    }

    @Override
    public boolean equals(Object o) {
        if ( !( o instanceof ChordMidi ) )
            return false;

        ChordMidi cm = (ChordMidi) o;

        if ( arpegio == null && cm.arpegio != null || cm.arpegio == null && arpegio != null )
            return false;

        return super.equals(cm) && (arpegio == null || arpegio.equals(cm.arpegio)) && length == cm.length;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + HashingUtils.from(arpegio, length);
    }
}
