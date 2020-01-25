package es.danisales.datune.tonality;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import es.danisales.datune.degrees.octave.DiatonicAlt;
import es.danisales.datune.chords.diatonicalt.DiatonicAltRetrieval;
import es.danisales.datune.degrees.octave.CyclicDegree;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

enum TonalityInnerImmutable implements TonalityInner<DiatonicAlt> {
	C( DiatonicAlt.C, Scale.MAJOR ),
	D( DiatonicAlt.D, Scale.MAJOR ),
	E( DiatonicAlt.E, Scale.MAJOR ),
	F( DiatonicAlt.F, Scale.MAJOR ),
	G( DiatonicAlt.G, Scale.MAJOR ),
	A( DiatonicAlt.A, Scale.MAJOR ),
	B( DiatonicAlt.B, Scale.MAJOR ),
	Db( DiatonicAlt.Db, Scale.MAJOR ),
	Eb( DiatonicAlt.Eb, Scale.MAJOR ),
	FF( DiatonicAlt.FF, Scale.MAJOR ),
	Gb( DiatonicAlt.Gb, Scale.MAJOR ),
	Ab( DiatonicAlt.Ab, Scale.MAJOR ),
	Bb( DiatonicAlt.Bb, Scale.MAJOR ),

	Cm( DiatonicAlt.C, Scale.MINOR ),
	Dm( DiatonicAlt.D, Scale.MINOR ),
	Em( DiatonicAlt.E, Scale.MINOR ),
	Fm( DiatonicAlt.F, Scale.MINOR ),
	Gm( DiatonicAlt.G, Scale.MINOR ),
	Am( DiatonicAlt.A, Scale.MINOR ),
	Bm( DiatonicAlt.B, Scale.MINOR ),
	CCm( DiatonicAlt.CC, Scale.MINOR ),
	DDm( DiatonicAlt.DD, Scale.MINOR ),
	Ebm( DiatonicAlt.Eb, Scale.MINOR ),
	FFm( DiatonicAlt.FF, Scale.MINOR ),
	GGm( DiatonicAlt.GG, Scale.MINOR ),
	Bbm( DiatonicAlt.Bb, Scale.MINOR );

	private final DiatonicAlt root;
	private final Scale	scale;
	private final List<DiatonicAlt>	notes;

	private static final Table<DiatonicAlt, Scale, TonalityInnerImmutable> table = HashBasedTable.create();

	static {
		for (TonalityInnerImmutable tonalityEnum : values())
			table.put(tonalityEnum.root, tonalityEnum.scale, tonalityEnum);
	}

	static <C extends CyclicDegree> @Nullable TonalityInnerImmutable from(@NonNull C diatonicAlt, @NonNull Scale scale) {
		Objects.requireNonNull(diatonicAlt);
		Objects.requireNonNull(scale);

		return table.get(diatonicAlt, scale);
	}

    TonalityInnerImmutable(DiatonicAlt noteBase, Scale scale) {
		this.root = noteBase;
		this.scale = scale;

		notes = Collections.unmodifiableList( DiatonicAltRetrieval.listFrom(noteBase, scale) );
	}

	public @NonNull Scale getScale() {
		return scale;
	}

	public @NonNull DiatonicAlt getRoot() {
		return root;
	}

	@Override
	public @NonNull List<DiatonicAlt> getNotes() {
		return notes;
	}
}
