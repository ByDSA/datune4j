package es.danisales.datune.tonality;

import es.danisales.datune.chords.DiatonicAlt;
import es.danisales.datune.chords.DiatonicAltRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class TonalityInnerMutable implements TonalityInner {
	private DiatonicAlt root;
	private Scale scale;
	private List<DiatonicAlt> notes;

	TonalityInnerMutable(DiatonicAlt noteBase, Scale scale) {
		this.root = noteBase;
		this.scale = scale;

		updateNotes();
	}

	private void updateNotes() {
		notes = DiatonicAltRetrieval.listFrom(root, scale);
		Objects.requireNonNull(notes);
	}

	void setScale(@NonNull Scale scale) {
		this.scale = scale;

		updateNotes();
	}

	void setRoot(@NonNull DiatonicAlt root) {
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
