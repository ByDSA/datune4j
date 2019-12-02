package es.danisales.datune.musical;

import es.danisales.datune.absolutedegree.Chromatic;
import es.danisales.datune.interval.IntervalChromatic;
import es.danisales.datune.pitch.ChordMutable;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

class ChromaticChordMutable
		extends ChordMutable<Chromatic, IntervalChromatic>
		implements PitchChromaticChord<Chromatic>, ChromaticChordInterface {

	private ChromaticChordInfo info;
	boolean building;

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
		super(new ArrayList<>());
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
	public void shift(IntervalChromatic interval) {
// todo
		onMutation();
	}

	@Override
	public void shiftNegative(IntervalChromatic interval) {
// todo
		onMutation();
	}

	@Override
	public @NonNull ChromaticChordInfo getInfo() {
		return info;
	}
}
