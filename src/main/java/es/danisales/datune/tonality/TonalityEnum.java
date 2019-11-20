package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.DiatonicAltRetrieval;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

enum TonalityEnum implements TonalityInterface {
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

	static @Nullable TonalityInterface of(@NonNull DiatonicAlt diatonicAlt, @NonNull Scale scale) {
		Objects.requireNonNull(diatonicAlt);
		Objects.requireNonNull(scale);

		for (TonalityEnum tonalityEnum : values())
			if (tonalityEnum.getScale().equals(scale) && diatonicAlt.equals(tonalityEnum.getRoot()))
				return tonalityEnum;

		return null;
	}

	TonalityEnum(DiatonicAlt noteBase, Scale scale) {
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
