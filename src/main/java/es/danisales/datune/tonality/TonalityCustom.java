package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.*;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

class TonalityCustom implements TonalityInterface {
	private DiatonicAlt root;
	private Scale scale;

	/** Temp */
	private List<DiatonicAlt> notes;

	public TonalityCustom(DiatonicAlt noteBase, Scale scale) {
		this.root = noteBase;
		this.scale = scale;

		updateNotes();
	}

	@Override
	public TonalityCustom clone() {
		return new TonalityCustom( root, scale );
	}

	private void updateNotes() {
		notes = DiatonicAltRetrieval.listFrom(root, scale);
		Objects.requireNonNull(notes);
	}


	public static TonalityCustom createFromChord(DiatonicChordMidi c, Tonality base) throws TonalityException {
		assert base != null;
		if ( base.size() != 7 )
			throw new RuntimeException( "No tiene 7 notas la escala" );

		DiatonicAlt[] notesChord = new DiatonicAlt[c.size()];
		for ( int i = 0; i < c.size(); i++ ) {
			notesChord[i] = c.get(i).getDiatonicAlt();
		}

		int posChordCorrector = 7 - c.get( 0 ).getDegree().ordinal();

		// Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
		Integer posBaseCorrector = ( Diatonic.from( notesChord[0] ).ordinal()
				- Diatonic.from( base.getRoot() ).ordinal() + 7 ) % 7;
		if ( posBaseCorrector == null ) {
			DiatonicAlt chromatic = c.get(0).getDiatonicAlt();
			throw new TonalityException(chromatic, base);
		}

		List<DiatonicAlt> tonalityNotes = new ArrayList<>();
		for ( int i = 0; i < 7; i++ ) {
			DiatonicDegree diatonicDegree = DiatonicDegree.values()[( posBaseCorrector + i ) % DiatonicDegree.values().length];

			boolean notFound = true;
			for ( int j = 0; j < notesChord.length; j++ ) {
				int index = (c.get(j).getDegree().ordinal() + posChordCorrector) % base.getScale().size();
				if (index == i) {
					tonalityNotes.add(notesChord[j]);
					notFound = false;
					break;
				}
			}

			if ( notFound )
				tonalityNotes.add( base.getNote( diatonicDegree ) );
		}

		return new TonalityCustom( notesChord[0], Scale.from( tonalityNotes ) );
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof TonalityInterface) )
			return false;

		TonalityInterface tonality = (TonalityInterface)o;

		return getNotes().equals( tonality.getNotes() );
	}

	@Override
	public int hashCode() {
		return notes.hashCode();
	}

	public TonalityCustom getRelativeScaleChromatic(int semitonesAdded) {
		ScaleDistance distanceScale = ScaleDistance.from(semitonesAdded);
		int semitones = distanceScale.getSemitones();
		DiatonicAlt shiftedRoot = root.addSemi( semitones );
		return new TonalityCustom( shiftedRoot, getScale() );
	}

	public void setScale(@NonNull Scale scale) {
		this.scale = scale;

		updateNotes();
	}

	public void setRoot(@NonNull DiatonicAlt root) {
		this.root = root;

		updateNotes();
	}

	public @NonNull Scale getScale() {
		return scale;
	}

	public @NonNull DiatonicAlt getRoot() {
		return root;
	}

	@Override
	public @NonNull List<DiatonicAlt> getNotes() {
		return Collections.unmodifiableList(notes);
	}
}
