package es.danisales.datune.midi;

import es.danisales.datune.diatonic.IntervalChromatic;
import es.danisales.datune.diatonic.Quality;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;

public class ChromaticChordMidi extends ChordMidi<ChromaticMidi, IntervalChromatic, PitchChromaticMidi>
		implements PitchChromaticChord<ChromaticMidi> {

    public static ChromaticChordMidiBuilder builder() {
        return new ChromaticChordMidiBuilder();
    }

	public static ChromaticChordMidi newEmpty() {
		return new ChromaticChordMidi();
	}

    public static @NonNull ChromaticChordMidi from(@NonNull Chromatic... chromatics) {
        return ChromaticChordMidiAdapter.fromChromatics(chromatics);
	}

	public static @NonNull ChromaticChordMidi from(@NonNull ChromaticMidi... ns) {
		ChromaticChordMidi ccm = new ChromaticChordMidi();
		ccm.addAll( Arrays.asList(ns) );

		return ccm;
	}

    public static ChromaticChordMidi from(@NonNull PitchChromaticSingle... ns) {
        Chromatic[] chromatics = new Chromatic[ns.length];
        for (int i = 0; i < ns.length; i++) {
            chromatics[i] = Chromatic.from(ns[i]);
        }

        return from(chromatics);
    }

    public static <N extends PitchChromaticSingle> ChromaticChordMidi from(Iterable<N> iterable) {
        return ChromaticChordMidiAdapter.from(iterable);
    }

    public static @NonNull ChromaticChordMidi from(@NonNull DiatonicChordMidi diatonicChordMidi) {
        return ChromaticChordMidiAdapter.fromDiatonicChordMidi(diatonicChordMidi);
    }

    protected ChromaticChordMidi() {
    }

	public void compact() {
		for ( int i = 1; i < this.size(); i++ ) {
            int distFromPrevious = this.get(i - 1).distTo(this.get(i));
            if (distFromPrevious > IntervalChromatic.PERFECT_OCTAVE.getSemitones())
                get(i).getPitch().shiftOctave(
                        -distFromPrevious / IntervalChromatic.PERFECT_OCTAVE.getSemitones()
                );
        }
	}

	@Override
	@NonNull
	public Quality getQuality() {
		return meta.getQuality();
	}

	@Override
    public ChromaticChordMidi newChord() {
		return new ChromaticChordMidi();
	}

	@Override
	public void shift(IntervalChromatic intervalChromatic) {
		for (ChromaticMidi chromaticMidi : this)
			chromaticMidi.getPitch().shift(intervalChromatic);
	}

	@Override
	public void shiftNegative(IntervalChromatic intervalChromatic) {
		for (ChromaticMidi chromaticMidi : this)
			chromaticMidi.getPitch().shiftNegative(intervalChromatic);
	}

    @Override
    public @NonNull ChromaticChordMidi clone() {
        ChromaticChordMidi c = new ChromaticChordMidi();

        for (ChromaticMidi n : this)
            c.add(n.clone());

        if (arpegio != null)
            c.arpegio = arpegio.clone();
        c.length = length;

        return c;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ChromaticMidi chromaticMidi : this)
            stringBuilder.append(chromaticMidi.toString()).append("\n");

        return stringBuilder.toString();
	}
}
