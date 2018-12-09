package pathfinding;

import diatonic.Tonality;
import eventsequences.Instrument;
import eventsequences.Track;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import midi.Duration;
import midi.Events.Volume;
import midi.Midi;
import midi.Sequence;
import midi.Song;
import pitch.ChordMidi;
import pitch.ChromaticChord;
import pitch.ChromaticChordMidi;
import pitch.ProgressionChromaticChordMidi;

class Main {
	static Map map;

	public static void main(String[] args) {
		/*
		 * int w = 10; int h = 10;
		 * 
		 * map = new Map(w, h);
		 * 
		 * for (int i = 0; i < 9; i++) map.addWall(4, i); PathSpace p = new
		 * PathSpace(map, new PVector(0, 0), new PVector(8, 2)); ArrayList<NodeMap> a =
		 * p.aStar(); for (NodeMap n : a) System.out.println(n);
		 */

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
		ArrayList<NodeProgression> nodes = p2.aStar();
		for ( int i = 0; i < nodes.size(); i++ ) {
			NodeProgression n = nodes.get( i );
			pcm.set( i, (ChromaticChordMidi)n.object );
			n.object.showNotes();
		}

		Song p = new Song( "azsxdc", 120, Tonality.FFm );
		Track strings = new Track( 0, Instrument.get( 48 ) );
		int l2 = 0;
		for ( int i = 0; i < pcm.size(); i++ ) {
			ChordMidi c = pcm.get( i );
			int l = 0;
			if ( i <= 2 || i == 5 || true ) {
				l = Duration.V1;
			} else {
				l = Duration.V2;
			}

			c.setDuration( l );
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