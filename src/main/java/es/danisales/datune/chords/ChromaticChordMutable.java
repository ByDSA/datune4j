package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.interval.IntervalChromatic;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;
import java.util.Comparator;

class ChromaticChordMutable
		extends ChordMutableNonMidi<Chromatic, IntervalChromatic>
		implements PitchChromaticChord<Chromatic>, ChromaticChordInterface {

	private ChromaticChordInfo info;
	private boolean building;

	public static @NonNull ChromaticChordMutable from(@NonNull Collection<Chromatic> chord) {
		ChromaticChordMutable chromaticChordMutable = new ChromaticChordMutable();

		chromaticChordMutable.addAll(chord);
		chromaticChordMutable.onMutation();

		return chromaticChordMutable;
	}

	public static @NonNull ChromaticChordMutable from(@NonNull ChromaticChordImmutable chord) {
		ChromaticChordMutable chromaticChordMutable = new ChromaticChordMutable();

		chromaticChordMutable.addAll(chord);
		chromaticChordMutable.setRootIndex(chord.getRootIndex());
		chromaticChordMutable.building = false;
		chromaticChordMutable.onMutation();

		return chromaticChordMutable;
	}

	ChromaticChordMutable() {
		super();
		building = true;
	}

	@Override
	public void sort(Comparator<? super Chromatic> comparator) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void onMutation() {
		if (building)
			return;
		info = ChromaticChordInfo.from(this);
	}

	@Override
	public ChromaticChordMutable clone() {
		ChromaticChordMutable customChromaticChord = ChromaticChordMutable.from(this);
		customChromaticChord.rootIndex = rootIndex;
		customChromaticChord.info = info == null ? null : info.clone(); // es null cuando está actualizando info.function
		return customChromaticChord;
	}

	@Override
	public void shift(@NonNull IntervalChromatic intervalChromatic) {
		for (int i = 0; i < size(); i++)
			set(i, get(i).getShifted(intervalChromatic));

		onMutation();
	}

	@Override
	public void shiftNegative(@NonNull IntervalChromatic intervalChromatic) {
		for (int i = 0; i < size(); i++)
			set(i, get(i).getShiftedNegative(intervalChromatic));

		onMutation();
	}

	@Override
	public @NonNull ChromaticChordInfo getInfo() {
		return info;
	}
}
