package es.danisales.datune.pathfinding;

import es.danisales.datune.eventsequences.Instrument;
import es.danisales.datune.eventsequences.Track;
import es.danisales.datune.midi.ChordMidi;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.DurationMidi;
import es.danisales.datune.midi.binaries.Midi;
import es.danisales.datune.midi.binaries.Song;
import es.danisales.datune.midi.binaries.events.Volume;
import es.danisales.datune.chords.ChromaticChord;
import es.danisales.datune.pitch.ProgressionChromaticChordMidi;
import es.danisales.datune.tonality.Tonality;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class Main {
	static Map map;

	public static void main(String[] args) {
		ProgressionChromaticChordMidi pcm = new ProgressionChromaticChordMidi(
				ChromaticChord.C,
				ChromaticChord.Em,
				ChromaticChord.F,
				ChromaticChord.B,
				ChromaticChord.Am,
				ChromaticChord.D,
				ChromaticChord.G,
				ChromaticChord.Bdim,
				ChromaticChord.C
		);

		PathProgression<ChromaticChordMidi> p2 = new PathProgression( pcm );
		List<NodeProgression> nodes = p2.aStar();
		for ( int i = 0; i < nodes.size(); i++ ) {
			NodeProgression n = nodes.get( i );
			pcm.set( i, (ChromaticChordMidi)n.object );
			System.out.println(n.object);
		}

		Song p = new Song( "azsxdc", 120, Tonality.FFm );
		Track strings = new Track( 0, Instrument.get( 48 ) );
		int l2 = 0;
		for ( int i = 0; i < pcm.size(); i++ ) {
			ChordMidi c = pcm.get( i );
            int l;
			if ( i <= 2 || i == 5 || true ) {
				l = DurationMidi.L1;
			} else {
				l = DurationMidi.L2;
			}

			c.setLength( l );
			strings.add( l2, c );
			l2 += l;

		}
		strings.setVolume( Volume.MAX );
		p.add( strings );

		if ( p != null ) {
			p.save();

			try {
				Midi.play( p.getName() );
			} catch ( MidiUnavailableException | IOException | InvalidMidiDataException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}