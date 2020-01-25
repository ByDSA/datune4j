package es.danisales.datune.tonality;

import es.danisales.datune.chords.diatonicalt.DiatonicAltRetrieval;
import es.danisales.datune.degrees.octave.CyclicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class TonalityInnerMutable<C extends CyclicDegree> implements TonalityInner<C> {
	private C root;
	private Scale scale;
	private List<C> notes;

	TonalityInnerMutable(C noteBase, Scale scale) {
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

	void setRoot(@NonNull C root) {
		this.root = root;

		updateNotes();
	}

	public @NonNull Scale getScale() {
		return scale;
	}

	public @NonNull C getRoot() {
		return root;
	}

	@Override
	public @NonNull List<C> getNotes() {
		return Collections.unmodifiableList(notes);
	}
}
