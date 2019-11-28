package es.danisales.datune;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.eventsequences.EventSequence;
import es.danisales.datune.eventsequences.Instrument;
import es.danisales.datune.eventsequences.MelodyDiatonic;
import es.danisales.datune.eventsequences.Track;
import es.danisales.datune.midi.*;
import es.danisales.datune.midi.Events.NoteOff;
import es.danisales.datune.midi.Events.NoteOn;
import es.danisales.datune.midi.Events.Volume;
import es.danisales.datune.midi.Progressions.Progression;
import es.danisales.datune.musical.ChordTransformations;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.pitch.ChordNamer;
import es.danisales.datune.songs.Power;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;

import javax.sound.midi.InvalidMidiDataException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

	public static Song esp() {
		Song song = new Song( "zxcv", 110 );

		Track	channel;
		Track	strings;
		Tonality tonality = song.getTonality();
		channel = new Track( 0, Instrument.get( 56 ) );
		strings = new Track( 1, Instrument.get( 48 ) );
		Progression p = new Progression( tonality, 5 );
		MelodyDiatonic m = new MelodyDiatonic( 6, tonality );

		for ( int i = 0; i < 1; i++ ) {
			DiatonicChordMidi diatonicChordMidi;
			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.V, -1 );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( 0 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.V, -1 );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( 0 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.VI7, -1 );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( 0 );

			diatonicChordMidi = p.add( ChromaticFunction.V7_V );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( 0 );

			diatonicChordMidi = p.add( DiatonicFunction.V );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( 0 );

			m.add( DiatonicDegree.I, Duration.V4 );
			m.add( DiatonicDegree.V, Duration.V4, -1 );

			m.add( DiatonicDegree.III, Duration.V4 );
			m.add( DiatonicDegree.I, Duration.V8 );
			m.add( DiatonicDegree.V, Duration.V8 );

			m.add( DiatonicDegree.IV, Duration.V8 );
			m.add( DiatonicDegree.III, Duration.V8 );
			m.add( DiatonicDegree.II, Duration.V8 );
			m.add( DiatonicDegree.I, Duration.V8 );

			m.add( DiatonicDegree.I, Duration.V8 );
			m.add( DiatonicDegree.VII, Duration.V8, -1 );
			m.add( DiatonicDegree.VI, Duration.V8, -1 );
			m.add( DiatonicDegree.V, Duration.V8, -1 );

			m.add( DiatonicDegree.I, Duration.V4 );
			m.add( DiatonicDegree.II, Duration.V4 );

			m.add( DiatonicDegree.III, Duration.V4 + Duration.V8 );
			m.add( DiatonicDegree.V, Duration.V8 );

			m.add( DiatonicDegree.IV, Duration.V8 );
			m.add( DiatonicDegree.III, Duration.V8 );
			m.add( DiatonicDegree.II, Duration.V8 );
			m.add( DiatonicDegree.I, Duration.V8 );

			m.add( DiatonicDegree.V, Duration.V2 );
		}

		for ( int i = 0; i < 1; i++ ) {
			DiatonicChordMidi diatonicChordMidi;

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.V, -1 );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( 0 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.V, -1 );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( 0 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.V, -1 );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( 0 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.V, -1 );
			diatonicChordMidi.setLength( Duration.V4 );
			diatonicChordMidi.inv( 0 );

			diatonicChordMidi = p.add( DiatonicFunction.I );
			diatonicChordMidi.setLength( Duration.V2 );
			diatonicChordMidi.inv( -1 );

			m.add( DiatonicDegree.V, Duration.V4 );
			m.add( DiatonicDegree.III, Duration.V8 + Duration.V16 );
			m.add( DiatonicDegree.V, Duration.V16 );

			m.add( DiatonicDegree.IV, Duration.V4 );
			m.add( DiatonicDegree.II, Duration.V8 + Duration.V16 );
			m.add( DiatonicDegree.IV, Duration.V16 );

			m.add( DiatonicDegree.III, Duration.V4 );
			m.add( DiatonicDegree.I, Duration.V8 + Duration.V16 );
			m.add( DiatonicDegree.III, Duration.V16 );

			m.add( DiatonicDegree.II, Duration.V8 );
			m.add( DiatonicDegree.V, Duration.V8, -1 );
			m.add( DiatonicDegree.VI, Duration.V8, -1 );
			m.add( DiatonicDegree.VII, Duration.V8, -1 );

			m.add( DiatonicDegree.I, Duration.V4 );
			m.add( DiatonicDegree.II, Duration.V4 );

			m.add( DiatonicDegree.III, Duration.V8 + Duration.V16 );
			m.add( DiatonicDegree.IV, Duration.V16 );
			m.add( DiatonicDegree.V, Duration.V8 );
			m.add( DiatonicDegree.IV, Duration.V8 );

			m.add( DiatonicDegree.III, Duration.V4 );
			m.add( DiatonicDegree.II, Duration.V4 );
			m.add( DiatonicDegree.I, Duration.V2 );
		}

		for ( int j = 0; j < 7; j++ ) {

			Scale scale = null;
			switch ( j ) {
				case 0:
					scale = Scale.LYDIAN;
					break; // IV
				case 1:
					scale = Scale.MAJOR;
					break; // I
				case 2:
					scale = Scale.MIXOLYDIAN;
					break; // V
				case 3:
					scale = Scale.DORIAN;
					break; // II
				case 4:
					scale = Scale.MINOR;
					break; // VI
				case 5:
					scale = Scale.PHRYGIAN;
					break; // III
				case 6:
					scale = Scale.LOCRIAN;
					break; // VII
			}

			tonality = Tonality.from( Chromatic.C, scale );
			Progression pp = ( (Progression) p.clone() ).setTonality( tonality );

			MelodyDiatonic mm2 = (MelodyDiatonic) ( (MelodyDiatonic) m.clone() )
					.setTonality( tonality );

			int l = mm2.getLength();

			strings.add( j * l, pp );
			channel.add( j * l, mm2 );
		}
		System.out.println( m );
		strings.setVolume( Volume.MAX );
		channel.setVolume( Volume.MAX );

		song.add( channel );
		song.add( strings );

		return song;
	}

	public static Song spec() {
		Song song = new Song( "spec", 128, Tonality.CCm );

		Track	channel;
		Track	strings;
		Tonality tonality = song.getTonality();

		channel = new Track( 0, Instrument.get( 82 ) );
		strings = new Track( 1, Instrument.get( 50 ) );
		Progression p = new Progression( tonality, 4 );
		MelodyDiatonic m = new MelodyDiatonic( 5, tonality );

		for ( int i = 0; i < 2; i++ ) {
			DiatonicChordMidi diatonicChordMidi;

			p.add( DiatonicFunction.I ).setLength( Duration.V1 );
			diatonicChordMidi = p.add( DiatonicFunction.VI );
			diatonicChordMidi.setLength( Duration.V1 );
			diatonicChordMidi.shiftOctave( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.III );
			diatonicChordMidi.setLength( Duration.V1 );
			diatonicChordMidi.inv( -1 );

			diatonicChordMidi = p.add( DiatonicFunction.VII );
			diatonicChordMidi.setLength( Duration.V1 );
			diatonicChordMidi.shiftOctave( -1 );

			m.add( DiatonicDegree.I, Duration.V8 );
			m.addSilence( Duration.V8 );
			m.add( DiatonicDegree.III, Duration.V8 );
			m.add( DiatonicDegree.V, Duration.V8 );
			m.add( DiatonicDegree.III, Duration.V8, 1 );
			m.addSilence( Duration.V8 );
			m.add( DiatonicDegree.II, Duration.V16, 1 );
			m.add( DiatonicDegree.I, Duration.V16, 1 );
			m.add( DiatonicDegree.VII, Duration.V16 );
			m.add( DiatonicDegree.I, Duration.V8, 1 );
			m.addSilence( Duration.V8 + Duration.V16 );

			m.add( DiatonicDegree.III, Duration.V16, 1 );
			m.addSilence( Duration.V16 );
			m.add( DiatonicDegree.I, Duration.V16, 1 );
			m.addSilence( Duration.V16 );
			m.add( DiatonicDegree.VI, Duration.V8 );
			m.addSilence( Duration.V8 + Duration.V4 );

			m.add( DiatonicDegree.V, Duration.V16 );
			m.addSilence( Duration.V16 * 3 );
			m.add( DiatonicDegree.V, Duration.V16 );
			m.addSilence( Duration.V16 );
			m.add( DiatonicDegree.IV, Duration.V16 );
			m.addSilence( Duration.V16 );
			m.add( DiatonicDegree.III, Duration.V16 );
			m.addSilence( Duration.V16 * 3 );
			m.add( DiatonicDegree.I, Duration.V16, 1 );
			m.add( DiatonicDegree.VI, Duration.V16 );
			m.add( DiatonicDegree.V, Duration.V16 );
			m.add( DiatonicDegree.III, Duration.V16 );

			m.add( DiatonicDegree.IV, Duration.V16 );
			m.addSilence( Duration.V16 * 3 );
			m.add( DiatonicDegree.IV, Duration.V16 );
			m.addSilence( Duration.V16 );
			m.add( DiatonicDegree.V, Duration.V16 );
			m.addSilence( Duration.V16 );
			m.add( DiatonicDegree.II, Duration.V8 );
			m.addSilence( i == 0 ? ( Duration.V8 * 3 ) : ( Duration.V8 * 2 ) );

			/*
			 *
			 * m.addAll(Degree.I, Duration.V4); m.addAll(Degree.V, Duration.V4, -1);
			 *
			 * m.addAll(Degree.III, Duration.V4); m.addAll(Degree.I, Duration.V8); m.addAll(Degree.V,
			 * Duration.V8);
			 *
			 * m.addAll(Degree.IV, Duration.V8); m.addAll(Degree.III, Duration.V8);
			 * m.addAll(Degree.II, Duration.V8); m.addAll(Degree.I, Duration.V8);
			 *
			 * m.addAll(Degree.I, Duration.V8); m.addAll(Degree.VII, Duration.V8, -1);
			 * m.addAll(Degree.VI, Duration.V8, -1); m.addAll(Degree.V, Duration.V8, -1);
			 *
			 * m.addAll(Degree.I, Duration.V4); m.addAll(Degree.II, Duration.V4);
			 *
			 * m.addAll(Degree.III, Duration.V4 + Duration.V8); m.addAll(Degree.V, Duration.V8);
			 *
			 * m.addAll(Degree.IV, Duration.V8); m.addAll(Degree.III, Duration.V8);
			 * m.addAll(Degree.II, Duration.V8); m.addAll(Degree.I, Duration.V8);
			 *
			 * m.addAll(Degree.V, Duration.V2);
			 */
		}

		m.add( DiatonicDegree.VII, Duration.V8, -1 );
		m.add( DiatonicDegree.I, Duration.V4 + Duration.V8 );

		m.show();

		strings.add( 0, p );
		channel.add( 0, m );

		strings.setVolume( Volume.MAX / 2 );
		channel.setVolume( Volume.MAX );

		song.add( channel );
		song.add( strings );

		return song;
	}

	public static Song test() {
		Song song = new Song( "spec", 128, Tonality.Am );

		Track	channel;
		Track	strings;
		Tonality tonality = song.getTonality();
		channel = new Track( 0, Instrument.get( 82 ) );
		strings = new Track( 1, Instrument.get( 50 ) );
		Progression p = new Progression( tonality, 4 );
		MelodyDiatonic m = new MelodyDiatonic( 5, tonality );

		for ( int i = 0; i < 1; i++ ) {
			/*
			 * p.addAll(ChordFunction.I).setLength(Duration.V1);
			 * p.addAll(ChordFunction.V).setLength(Duration.V1).inv(-2);
			 * p.addAll(ChordFunction.VI).setLength(Duration.V1).inv(-2);
			 * p.addAll(ChordFunction.IV).setLength(Duration.V1).inv(-1);
			 */
			p.add( DiatonicFunction.I ).setLength( Duration.V1 );
			DiatonicChordMidi dcm = p.add( DiatonicFunction.VI );
			dcm.setLength( Duration.V1 );
			dcm.inv( 1 );
			dcm.shiftOctave( -1 );

			dcm = p.add( DiatonicFunction.IV );
			dcm.setLength( Duration.V1 );
			dcm.inv( 2 );
			dcm.shiftOctave( -1 );

			dcm = p.add( DiatonicFunction.VII );
			dcm.setLength( Duration.V2 );
			dcm.shiftOctave( -1 );

			dcm = p.add( DiatonicFunction.VII );
			dcm.setLength( Duration.V2 );
			dcm.setMajorScale();
			dcm.shiftOctave( -1 );
		}

		SecureRandom sr = new SecureRandom();

		int next = Duration.V4;
		int max = p.getDuration();
		for ( int i = 0; i < max; i += next ) {
			int[] durs = new int[] {
					Duration.V8,
					Duration.V4
			};
			next = durs[sr.nextInt( durs.length )];
			next = Math.min( max - i, next );
			if ( sr.nextInt( 8 ) == 0 ) {
				m.addSilence( next );
				continue;
			}
			DiatonicChordMidi c = p.getChordAtTime( i );
			DiatonicMidi nd = c.get( sr.nextInt( c.size() * 2 ) ).clone();
			nd.setLength( next );
			nd.getPitch().shiftOctave(1);
			/*
			 * if (i % Duration.V1 >= 3*Duration.V4) nd.shiftPos(1);
			 */
			m.add( nd );
		}
		// m.show();

		strings.add( 0, p );
		channel.add( 0, m );

		strings.setVolume( Volume.MAX / 2 );
		channel.setVolume( Volume.MAX );

		song.add( channel );
		song.add( strings );

		return song;
	}

	public static Song digi2end() {
		Song song = new Song( "spec", 125, Tonality.Cm );

		Track	channel;
		Track	strings;

		Tonality tonality = song.getTonality();

		channel = new Track( 0, Instrument.get( 82 ) );
		strings = new Track( 1, Instrument.get( 48 ) );
		Progression p = new Progression( tonality, 5 );
		MelodyDiatonic m = new MelodyDiatonic( 5, tonality );

		for ( int i = 0; i < 1; i++ ) {
			DiatonicChordMidi c;
			c = p.add( DiatonicFunction.I );
			c.setLength( Duration.V4 * 3 );
			c.inv( 0 );
			c.shiftOctave( 0 );
			DiatonicMidi diatonicMidi =  c.get( 1 ).clone();
			diatonicMidi.getPitch().shiftOctave(1);
			c.add(diatonicMidi);

			c = p.add( DiatonicFunction.VII );
			c.setLength( Duration.V4 * 3 );
			c.inv( 2 );
			c.shiftOctave( -1 );

			c = p.add( DiatonicFunction.IV2 );
			c.setLength( (int) ( Duration.V4 * 3.25 ) );
			c.inv( 0 );

			c = p.add( DiatonicFunction.I );
			c.setLength( (int) ( Duration.V4 * 3.25 ) );
			c.inv( 1 );

			c = p.add( DiatonicFunction.I );
			c.setLength( Duration.V4 * 3 );
			c.inv( 0 );
			c.shiftOctave( 0 );

			c = p.add( DiatonicFunction.VII );
			c.setLength( Duration.V4 * 3 );
			c.inv( 2 );
			c.shiftOctave( -1 );

			DiatonicChordMidi c1 = p.add( DiatonicFunction.I7 );
			c1.setLength( Duration.V4 * 3 );
			c1.inv( 0 );
			c1.shiftOctave( 0 );
			c1.get(2).getPitch().shiftOctave(-1);
			DiatonicChordMidi c2 = p.add( DiatonicFunction.VII_THIRD );
			c2.setLength( Duration.V4 * 3 );
			c2.setMajorScale();
			c2.shiftOctave( -1 );
			DiatonicMidi diatonicMidi1 = c2.get( 0 ).clone();
			diatonicMidi1.getPitch().shiftOctave(1);
			c2.add( diatonicMidi1 );
			c2 = p.add( DiatonicFunction.I );
			c2.inv( -1 );
			c2.setLength( Duration.V1 );
		}

		// p.setArpegio(new ArpegioDesc(Duration.V1, Duration.V16));

		strings.add( 0, p );
		channel.add( 0, m );

		strings.setVolume( Volume.MAX / 2 );
		channel.setVolume( Volume.MAX );

		song.add( channel );
		song.add( strings );

		return song;
	}

	public static Song recogniseScale() throws InvalidMidiDataException, IOException {
		Sequence sq = Sequence.loadRaw(Paths.get( "readed.mid").toFile() ).toNotes();
		EventSequence es = sq.flatHarmony();
		Song song = new Song( "flat", 130 );

		Track t = new Track( 0, Instrument.ACOUSTIC_GRAND_PIANO );
		t.add( es );
		song.add( t );

		final int N = 4 * 2 * 2;
		final int offset = 0;
		java.util.List<ChromaticChordMidi> css = new ArrayList<>();
		for ( int i = 0; i < N; i++ ) {
			ChromaticChordMidi notes = EventSequence.whatNotesArePlaying(
					es, (int) ( Duration.V1 * ( i * 0.5 + offset ) + Duration.V16 )
			);
			ChordTransformations.removeHigherDuplicates(notes);
			css.add( notes );
		}

		java.util.List<ChromaticChord> cs = new ArrayList<>();
		for (ChromaticChordMidi ccm : css) {
			cs.add(
					ChromaticChord.builder()
							.fromChromaticMidi(ccm)
							.build()
			);
		}

		DiatonicChordMidiTransformations.showPossibleProgressionsMajorMinor(cs);

		return song;
	}

	static class F extends JFrame {
		JPanel panel;

		boolean sus24 = false;
		boolean modal = false;

		public void load(Tonality ton) {
			assert ton != null;
			panel.removeAll();
			panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
			JPanel[][] panels = new JPanel[7][6];
			JPanel[] panelF = new JPanel[7];
			JPanel labelPanel = new JPanel();
			labelPanel.setLayout( new GridLayout( 1, 5 ) );
			labelPanel.add( new JLabel() );
			panel.add( labelPanel );
			for ( int i = 0; i < panels.length; i++ ) {
				panelF[i] = new JPanel();
				DiatonicDegree diatonicDegree = DiatonicDegree.values()[i];
				panelF[i].add( new JLabel( ton.getNote( diatonicDegree ).toString() ) );
				panelF[i].setLayout( new GridLayout( 1, 5 ) );
				for ( int j = 0; j < panels[i].length; j++ ) {
					panels[i][j] = new JPanel();
					panelF[i].add( panels[i][j] );
					if ( i == 0 ) {
						labelPanel.add( new JLabel( Integer.toString( j + 2 ) ) );
					}
				}
				panel.add( panelF[i] );
			}

			AtomicReference<DiatonicChordMidi> lastPlayed = new AtomicReference<>( null );

			java.util.List<ChromaticChord> fs = new ArrayList<>();
			java.util.Set<ChromaticChord> cs = new HashSet<>();
			for (DiatonicFunction diatonicFunction : DiatonicFunction.values())
				cs.add(
						ChromaticChord.builder()
								.tonality(ton)
								.diatonicFunction(diatonicFunction)
								.build()
				);
			for (ChromaticFunction chromaticFunction : ChromaticFunction.values())
				cs.add(
						ChromaticChord.builder()
								.tonality(ton)
								.chromaticFunction(chromaticFunction)
								.build()
				);
			for ( ChromaticChord c1 : cs ) {
				System.out.println(c1);
				DiatonicChordMidi c = DiatonicChordMidi.builder()
						.from(c1, ton)
						.build();
				System.out.println( c.getFunction()  + " " + (c.getFunction() instanceof DiatonicFunction) + " " + c.metaTonality + " " + c.getTonality());
				assert c.getFunction() != null : c;
				if ( (c.getFunction() instanceof DiatonicFunction
						&& ( ( (DiatonicFunction) c.getFunction() ).isSus2()
						|| ( (DiatonicFunction) c.getFunction() ).isSus4() )
				) && !sus24 )
					continue;

				if (ton.isMajorOrMinor() && !c.getMetatonality().isMajorOrMinor() && !modal)
					continue;

				if (fs.contains( c1 ))
					continue;
				fs.add( c1 );


				JButton b = new JButton(
						c.toString() + ( c.getMetatonality() != ton ? " " + c.getMetatonality() : "" )
				);
				DiatonicDegree degree = c.getDegree();
				if ( c.getFunction() instanceof ChromaticFunction )
					switch ( (ChromaticFunction) c.getFunction() ) {
						case SUBV7:
							degree = DiatonicDegree.I;
							break;
						case V_II:
						case V7_II:
						case SUBV7_II:
							degree = DiatonicDegree.II;
							break;
						case V_III:
						case V7_III:
						case SUBV7_III:
							degree = DiatonicDegree.III;
							break;
						case V_IV:
						case V7_IV:
						case SUBV7_IV:
							degree = DiatonicDegree.IV;
							break;
						case V_V:
						case V7_V:
						case SUBV7_V:
							degree = DiatonicDegree.V;
							break;
						case V_VI:
						case V7_VI:
						case SUBV7_VI:
							degree = DiatonicDegree.VI;
							break;
					}
				assert degree != null : c + " " + c.getFunction();

				Integer d = degree.ordinal();

				panels[d][c.size() - 2].add( b );

				if ( !c.getTonality().equals( ton ) ) {
					if (ArrayUtils.contains(c.getFunction(), ChromaticFunction.TENSIONS))
						b.setForeground( Color.BLUE );
					else
						b.setForeground( Color.RED );
					b.setOpaque( true );
				}

				b.getModel().addChangeListener( new ChangeListener() {
					private boolean pressed = false; // holds the last pressed state fromIndex the button

					@Override
					public void stateChanged(ChangeEvent e) {
						ButtonModel model = (ButtonModel) e.getSource();

						// if the current state differs fromIndex the previous state
						if ( model.isPressed() != pressed ) {
							pressed = model.isPressed();
							if ( pressed ) {
								if ( lastPlayed.get() != null ) {
									ChordMidiTransformations.minimizeDistanceTo(c, lastPlayed.get());
								}

								lastPlayed.set( c );

								EventSequence es = new EventSequence();
								for ( DiatonicMidi n : c )
									es.add( 0, new NoteOn( n ) );
								es.play();
								System.out.println( "Press " + c + " " + ChordNamer.from(c) );
							} else {
								EventSequence es = new EventSequence();
								for ( DiatonicMidi n : c )
									es.add( 0, new NoteOff( n ) );
								es.play();
								// System.out.println("Release " + c);
							}
						}
					}
				} );
			}
			panel.revalidate();

			System.out.println( "Tonalidad cambiada a " + ton );
		}

		F() {
			try {
				javax.swing.UIManager
						.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
			} catch ( Exception ex ) {
			}

			panel = new JPanel();

			JPanel selectorPanel = new JPanel();

			JComboBox<Tonality> combo = new JComboBox<>();
			for ( Tonality t : Tonality.all() )
				combo.addItem( t );

			combo.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Tonality t = (Tonality) combo.getSelectedItem();
					load( t );
				}
			} );
			selectorPanel.add( combo );

			JCheckBox susBox = new JCheckBox( "sus2-4" );
			susBox.addItemListener( new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					sus24 = susBox.isSelected();
					Tonality t = (Tonality) combo.getSelectedItem();
					load( t );
				}
			} );
			selectorPanel.add( susBox );

			JCheckBox modalBox = new JCheckBox( "modal" );
			modalBox.addItemListener( new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					modal = modalBox.isSelected();
					Tonality t = (Tonality) combo.getSelectedItem();
					load( t );
				}
			} );
			selectorPanel.add( modalBox );

			JComboBox<Instrument> combo2 = new JComboBox<>();
			for ( Instrument t : Instrument.all() )
				combo2.addItem( t );

			combo2.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Instrument t = (Instrument) combo2.getSelectedItem();
					System.out.println( "Instrumento cambiado a " + t );
					Midi.setInstrument( t );
				}
			} );
			selectorPanel.add( combo2 );

			getContentPane().add( selectorPanel, BorderLayout.NORTH );

			getContentPane().add( panel, BorderLayout.CENTER );

			load( Tonality.C );

			setVisible( true );
			this.setResizable( true );
			this.setTitle( "aa" );
			setSize( 1450, 850 );
		}
	}

	public static void showOctaves(int[] array) {
		for ( int i : array )
			System.out.print( i / 12 + " " );
		System.out.println( "" );
	}

	public static ArrayList<int[]> getAllDispositionsSub(int[] array, boolean sub, int level, boolean first) {
		ArrayList<int[]> ret = new ArrayList<>();
		assert array.length > 0;

		if ( first && level == 0 )
			ret.add( array.clone() );

		while ( ( array.length > 1 && array[0] < array[1] || array.length == 1 )
				&& array[0] <= 127 ) {
			if ( !first )
				ret.add( array.clone() );

			if ( sub && array.length > 1 ) {
				// Copia acorde desde la segunda a la �ltima nota
				int[] subChord = new int[array.length - 1];
				for ( int i = 1; i < array.length; i++ )
					subChord[i - 1] = array[i];

				ArrayList<int[]> subChordCombinations = getAllDispositionsSub(
						subChord.clone(), true, level + 1, first
				);
				for ( int[] subChordcombination : subChordCombinations ) {
					// Forma array superChord = [array[0] + subChordcombination]
					int[] superChord = new int[array.length];
					superChord[0] = array[0];
					for ( int i = 0; i < subChordcombination.length; i++ )
						superChord[i + 1] = subChordcombination[i];

					// Combinaciones de 'n�mero' dentro del array superChord = ['n�mero' +
					// subChordcombination]
					ArrayList<int[]> superCombinations = getAllDispositionsSub(
							superChord.clone(), false, level, false
					);
					for ( int[] a : superCombinations )
						ret.add( a );
				}
			}

			array[0] += 12;
			first = false;
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		Power p = new Power();

		//Song p = null;// recogniseScale();

		/*
		 * EventSequence e = new EventSequence(); int t = 0; for(ChordFunc c :
		 * Tonality.C.getAllChords()) { System.out.println(c);
		 * c.setLength(Duration.V8); e.addAll(t++*Duration.V4, c); }
		 */

		/*
		 * int[] a1 = new int[] {0}; int[] a2 = new int[] {0, 7}; int[] a3 = new int[]
		 * {0, 4, 7}; int[] a4 = new int[] {0, 4, 7, 10}; int[] a3_2 = new int[] {4, 7,
		 * 12};
		 *
		 * int[] array = a4;
		 *
		 * ArrayList<int[]> ret = getAllDispositionsSub(array.clone(), true, 0, true);
		 * System.out.println(ret.size() + " combinaciones."); for(int[] a : ret)
		 * showOctaves(a);
		 *
		 *
		 * ChromaticChordMidi ccm = new ChromaticChordMidi(ChromaticChord.C5);
		 * ArrayList<ChromaticChordMidi> cs = ccm.getAllDispositionsWithInv();
		 * System.out.println(cs.size() + " combinaciones."); for (ChromaticChordMidi c
		 * : cs) { c.showNotesOctave(); } System.out.println("B-----------");
		 */
		/*
		 * ChromaticChord[] cs = ChromaticChord.C.getModalChords( Tonality.C ); for (
		 * ChromaticChord c : cs ) c.show();
		 */

		/*JFrame f = new F();

		for ( DiatonicFunction c : DiatonicFunction.ALL ) {
			DiatonicChordMidi chord = new DiatonicChordMidi( c, Tonality.C );
			// chord.show();
			// chord.showNotes();
		}*/


		for (DiatonicFunction f : DiatonicFunction.values() ) {
			System.out.println(f.name() + " " + ChromaticChord.builder().tonality(Tonality.C).diatonicFunction(f).build());
		}
		
/*
		ArrayList<CustomTonality> ts = new ArrayList<>();
		ts.addAll( new CustomTonality(Chromatic.C, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.CC, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.D, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.DD, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.E, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.F, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.FF, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.G, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.GG, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.A, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.AA, ScaleEnum.MINOR) );
		ts.addAll( new CustomTonality(Chromatic.B, ScaleEnum.MINOR) );

		StringBuilder sb = new StringBuilder();
		for (CustomTonality t : ts ) {
			sb.append( "case " + t + ": switch(f) {\n" );
			for (DiatonicFunction f : DiatonicFunction.values()) {
				ChromaticChord c = t.fromIndex(f);
				String cStr = c.toString();
				boolean cont = false;
				try {
					Class cl = ChromaticChord.class;
					Field field = cl.getField(cStr);
				} catch(Exception e) {
					cStr = "case " + f.name() + ": return " + c.javaNotes();
					cont = true;
				}

				cStr = cStr.replaceAll( "E#", "F" );
				cStr = cStr.replaceAll( "B#", "C" );
				cStr = cStr.replaceAll( "C#", "CC" );
				cStr = cStr.replaceAll( "D#", "DD" );
				cStr = cStr.replaceAll( "F#", "FF" );
				cStr = cStr.replaceAll( "G#", "GG" );
				cStr = cStr.replaceAll( "A#", "AA" );
				cStr = cStr.replaceAll( "\\(b2\\)", "b2" );
				cStr = cStr.replaceAll( "\\(b4\\)", "b4" );
				cStr = cStr.replaceAll( "\\(#4\\)", "a4" );
				cStr = cStr.replaceAll( "#4", "a4" );
				cStr = cStr.replaceAll( "#11", "a11" );
				cStr = cStr.replaceAll( "/", ".over( Chromatic." );
				if (cStr.containsPitch( ".over(" ))
					cStr += " )";
				if (!cont)
					sb.append( "case " + f.name() + ": return ChromaticChord." + cStr + ";\n"); // " + c.javaNotes());
				else
					sb.append( cStr + "\n" );
			}
			sb.append( "} break;\n" );
			System.out.println( "OK1" );
		}
		System.out.println( sb );
*/
		System.out.println( "OK" );

		// Midi.play(e);

		/*
		 * TestProgression p = generate(ChordFunction.I, Scale.FFm);
		 *
		 * p.progression.setArpegio(new ArpegioAscDesc(Duration.V1, Duration.V8));
		 *
		 * for(Chord c : p.progression.getChords()) c.show();
		 */

		/*
		 * TestProgression p = new TestProgression(Scale.Em, 4, 120, 90) { { Arpegio a =
		 * new ArpegioAsc(Duration.V1, Duration.V4_3); addAll(ChordFunction.I).show();
		 * addAll(ChordFunction.VI, -1).inv(1).show(); addAll(ChordFunction.IV,
		 * -1).setMajorScale().inv(2).show(); addAll(ChordFunction.VI, -1).inv(1).show();
		 * addAll(ChordFunction.I).show(); addAll(ChordFunction.VI, -1).inv(1).show();
		 * addAll(ChordFunction.VI, -1).setMajorScale().inv(1).show();
		 * addAll(ChordFunction.VII, -1).setLength(Duration.V2).inv(1).show(); Chord c =
		 * addAll(ChordFunction.VII, -1).setMajorScale().setLength(Duration.V2).show();
		 *
		 * progression.setArpegio(a);
		 *
		 * ArrayList<Chord> chords = Chord.whatIsIt(c); for(Chord cc : chords) if
		 * (cc.meta.type == ChordFunction.VII) cc.show(); } };
		 */

		// p.progression.setArpegio(new ArpegioAsc(Duration.V1, Duration.V128));

		/*
		 * for(Scale s : new Scale(Chromatic.GG, Mode.MAJOR).getSameNotesScale(true))
		 * s.showNotes();
		 */

		/*
		 * ArrayList<Note> notes = new ArrayList<Note>(); notes.addAll( new Note(Note.E) );
		 * notes.addAll( new Note(Note.GG) ); notes.addAll( (Note)new Note(Note.B) );
		 *
		 * ArrayList<Chord> chords = Chord.whatIsIt(notes);
		 * System.out.println("Encontrados " + chords.size() + " acordes!"); for(Chord
		 * cc : chords) System.out.println(cc);
		 */

		/*
		 * for(int i = 0; i < 12; i++) { for(int j = 0; j < 12; j++) { Scale scale1 =
		 * new Scale(i, Mode.LYDIAN); Scale scale2 = new Scale(j, Mode.LOCRIAN);
		 *
		 * ArrayList<Chord[]> chords = scale1.commonChords(scale2); for(Chord[] cs :
		 * chords) { if (cs[0].size() >= 4) continue; System.out.println(cs[0]);
		 * System.out.println(cs[1]); System.out.println("----"); } } }
		 *
		 * System.out.println("End!");
		 */

		/*
		 * Song p = new Song("zxcv") { Track channel; Track strings;
		 *
		 * @Override public void init() { sequence = new Sequence(90);
		 *
		 * channel = new Track(0, 0); strings = new Track(1, 48);
		 *
		 * Progression p = new Progression(scale, 4) { { addChord(Chord.I) .inv(-2)
		 * .setLength(Note.V1);
		 *
		 * addChord(Chord.III) .inv(-1) .setLength(Note.V1);
		 *
		 * addChord(Chord.VI) .setLength(Note.V1);
		 *
		 * addChord(Chord.V7_V) .setLength(Note.V1);
		 *
		 * addChord(Chord.IV) .setLength(Note.V1);
		 *
		 * addChord(Chord.I) .inv(-2) .setLength(Note.V1);
		 *
		 * addChord(Chord.V7_V) .setLength(Note.V1);
		 *
		 * addChord(Chord.IV) .setLength(Note.V2);
		 *
		 * addChord(Chord.V) .setLength(Note.V2); } }; p.setChordArpegio( new
		 * ArpegioV4() );
		 *
		 * channel.addAll(p); sequence.addAll(channel); } };
		 */

		/*
		 * Song p = new Song("zxcv") { Track channel; Track strings;
		 *
		 * @Override public void init() { sequence = new Sequence(120);
		 *
		 * channel = new Track(0, 40); strings = new Track(1, 48);
		 *
		 * Progression p = new Progression(scale, 5);
		 *
		 * p.addNote(4, -1).setLength(Note.V4);
		 *
		 * p.addNote(0).setLength(Note.V2); p.addNote(1).setLength(Note.V4D);
		 * p.addNote(2).setLength(Note.V16); p.addNote(3).setLength(Note.V16);
		 *
		 * p.addNote(2).setLength(Note.V2); p.addNote(4, -1).setLength(Note.V4D);
		 * p.addNote(4, -1).setLength(Note.V8);
		 *
		 * p.addNote(0).setLength(Note.V4D); p.addNote(1).setLength(Note.V8);
		 * p.addNote(2).setLength(Note.V8); p.addNote(4, -1).setLength(Note.V8);
		 * p.addNote(2).setLength(Note.V4_3); p.addNote(0).setLength(Note.V4_3);
		 * p.addNote(4).setLength(Note.V4_3);
		 *
		 * p.addNote(3).setLength(Note.V2D); p.addNote(4, -1).setLength(Note.V4);
		 *
		 *
		 * p.addNote(0).setLength(Note.V4D); p.addNote(1).setLength(Note.V8);
		 * p.addNote(2).setLength(Note.V8D); p.addNote(4,-1).setLength(Note.V16);
		 * p.addNote(4).setLength(Note.V8D); p.addNote(2).setLength(Note.V16);
		 *
		 * p.addNote(0, 1).setLength(Note.V2); p.addNote(0).setLength(Note.V4);
		 * p.addNote(2).setLength(Note.V4_3); p.addNote(1).setLength(Note.V4_3);
		 * p.addNote(0).setLength(Note.V4_3);
		 *
		 * p.addNote(4).setLength(Note.V4D); p.addNote(2).setLength(Note.V16);
		 * p.addNote(0).setLength(Note.V16);
		 *
		 * p.addNote(4,-1).setLength(Note.V4);
		 *
		 * p.addNote(4,-1).setLength(Note.V8D); p.addNote(4,-1).setLength(Note.V16);
		 *
		 * p.addNote(0).setLength(Note.V2D);
		 *
		 * Progression p2 = new Progression(scale, 5);
		 * p2.addChord(Chord.I).setLength(Note.V2);
		 * p2.addChord(Chord.V).inv(2).setLength(Note.V2);
		 *
		 * p2.addChord(Chord.I).inv(-1).setLength(Note.V2);
		 * p2.addChord(Chord.V).inv(1).setLength(Note.V2);
		 *
		 * p2.addChord(Chord.I).inv(-1).setLength(Note.V2);
		 * p2.addChord(Chord.III).setLength(Note.V2);
		 *
		 * p2.addChord(Chord.IV).setLength(Note.V1);
		 *
		 * p2.addChord(Chord.I).inv(-1).setLength(Note.V2);
		 * p2.addChord(Chord.III).setLength(Note.V2);
		 *
		 * p2.addChord(Chord.I).inv(-1).setLength(Note.V1);
		 *
		 * p2.addChord(Chord.V).inv(1).setLength(Note.V1);
		 *
		 * p2.addChord(Chord.I).inv(-1).setLength(Note.V1);
		 *
		 * //p2.setChordArpegio(new ArpegioAscDesc(Note.V2, Note.V8));
		 *
		 *
		 * for(int j = 0; j < 7; j++) { int[] tonality = null; switch(j) { case 0:
		 * tonality = Tonality.LYDIAN; break; // IV case 1: tonality = Tonality.MAJOR;
		 * break; // I case 2: tonality = Tonality.MIXOLYDIAN; break; // V case 3:
		 * tonality = Tonality.DORIAN; break; // II case 4: tonality = Tonality.MINOR;
		 * break; // VI case 5: tonality = Tonality.PHRYGIAN; break; // III case 6:
		 * tonality = Tonality.LOCRIAN; break; // VII } scale = new Scale(Note.E,
		 * tonality);
		 *
		 * Progression pp = ((Progression)p.duplicate()).setScale(scale);
		 *
		 * channel.addAll(j*pp.getDuration(), pp);
		 *
		 * Progression p2p = ((Progression)p2.duplicate()).setScale(scale);
		 *
		 * strings.addAll(Note.V4 + j*p2p.getDuration(), p2p); } strings.setVolume(100);
		 *
		 * sequence.addAll(channel); sequence.addAll(strings); } };
		 */

		if ( p != null ) {
			p.save();

			Midi.play( p.getAbsolutePath() );
		}
	}
}

/*
 * int octave = 5;
 *
 * Sequence seq = new Sequence(180); Track c = new Track(0, 50); Track c2 = new
 * Track(1, 2); Track c3 = new Track(2, 10); Track c4 = new Track(3, 61);
 *
 * seq.addAll(c); c.setVolume(Volume.MAX); seq.addAll(c2); c2.setVolume(Volume.MAX);
 * c3.setPan((Pan.LEFT*2+Pan.MID)/3); seq.addAll(c3);
 * c3.setPan((Pan.RIGHT*2+Pan.MID)/3); seq.addAll(c4); int end = 7; for(int i = 0;
 * i < end; i++) { if (Note.D+i == 12) octave++;
 *
 * Scale s = new Scale(Note.D+i, Tonality.MAJOR); c.setScale(8*i*Note.V1, s);
 * Progression l = new Pachelbel(s, octave-1, Pachelbel.NORMAL);
 * c.addAll(8*i*Note.V1, l); if (i == end-1) c.addFunction(8*i*Note.V1,
 * Volume.class, new LinealFunction(Volume.MAX, Volume.MIN), Note.V1*8); if (i >
 * 1 && i < end-2) { Progression ll;
 *
 * if (i == 2) { c4.addFunction(8*i*Note.V1, Pan.class, new
 * CosFunction(Note.V1*2, Note.V1*8), Note.V1*8); c4.addFunction(8*i*Note.V1,
 * Volume.class, new LinealFunction(Volume.MAX/2, Volume.MAX), Note.V1*8); ll =
 * new Pachelbel(s, octave-1, Pachelbel.NORMAL); } else { ll = new Pachelbel(s,
 * octave+1, Pachelbel.NORMAL); c4.addFunction(8*i*Note.V1, Pan.class, new
 * CosFunction(Note.V1, Note.V1*8), Note.V1*8); }
 *
 * ll.setChordArpegio(new ArpegioV2_3(3)); c4.addAll(8*i*Note.V1, ll); }
 *
 *
 * if (i > 0 && i < end-1) { Progression l2 = new Pachelbel(s, octave,
 * Pachelbel.ARPEGIO); c2.addAll(8*i*Note.V1, l2); }
 *
 * if (i > 1 && i < end-3) { Progression l3 = new Pachelbel(s, octave+2,
 * Pachelbel.NORMAL); l3.setChordArpegio(new ArpegioAscDescV8(3, 8));
 * c3.addAll(8*i*Note.V1, l3); } }
 */

/*
 * Scale s = new Scale(Note.D, Tonality.MAJOR); Progression l = new
 * Progression(s, 5) { { addAll(Chord.I); addAll(Chord.vi); addAll(Chord.iii);
 * addAll(Chord.V); addAll(Chord.I);
 *
 * setChordArpegio(new ArpegioV2_3(3)); setChordArpegio(4, new
 * ArpegioDefault(3)); } }; c.addAll(0, l);
 */
/*
 * int octave = 5; int note = Note.A;
 *
 * Sequence seq = new Sequence(120); Track c = new Track(0, 50); Track c2 = new
 * Track(2, 62); Track c3 = new Track(1, 19); c3.setVolume(Volume.MAX);
 * c.setPan((Pan.LEFT*3+Pan.MID)/4); c3.setPan((Pan.RIGHT*3+Pan.MID)/4);
 * seq.addAll(c); seq.addAll(c2); seq.addAll(c3); Scale s = new Scale(note,
 * Tonality.MINOR); for(int i = 0; i < 4; i++) { Progression l = new
 * Progression(s, octave-1) { { // F# G# A B C# D E F# G# A# B C# D# F
 * addAll(Chord.I); // F# A C# I III V
 *
 * addAll(Chord.VI).inv(2); // F# A D I-III-VI VI 2� inv
 *
 * addAll(Chord.IV).inv(); // F# B D I IV VI IV 1� inv
 *
 * addAll(Chord.VII, -1).setLength(Note.V2); // E G# B VII II IV VII
 *
 * addAll(Chord.VII, -1, s.getMajor()).setLength(Note.V2); // F G# B 3�m 5�� } };
 * c.addAll(Note.V1*4*i, l);
 *
 * c2.setScale(s); int pre = Note.V1*4*i + Note.V4 + Note.V8; c2.addAll(pre, new
 * NoteScale(4, octave, s, Note.V16)); c2.addAll(pre + Note.V16, new NoteScale(3,
 * octave, s, Note.V16)); c2.addAll(pre + Note.V8, new NoteScale(4, octave, s,
 * Note.V4)); c2.addAll(pre + Note.V8 + Note.V4, new NoteScale(0, octave, s,
 * Note.V4));
 *
 * c2.addAll(pre + Note.V1, new NoteScale(5, octave, s, Note.V16)); c2.addAll(pre +
 * Note.V1 + Note.V16, new NoteScale(4, octave, s, Note.V16)); c2.addAll(pre +
 * Note.V1 + Note.V8, new NoteScale(5, octave, s, Note.V8)); c2.addAll(pre +
 * Note.V1 + Note.V8*2, new NoteScale(4, octave, s, Note.V8)); c2.addAll(pre +
 * Note.V1 + Note.V8*3, new NoteScale(3, octave, s, Note.V4+Note.V8));
 *
 * c2.addAll(pre + Note.V1*2, new NoteScale(5, octave, s, Note.V16)); c2.addAll(pre +
 * Note.V1*2 + Note.V16, new NoteScale(4, octave, s, Note.V16)); c2.addAll(pre +
 * Note.V1*2 + Note.V8, new NoteScale(5, octave, s, Note.V4)); c2.addAll(pre +
 * Note.V1*2 + Note.V8 + Note.V4, new NoteScale(0, octave, s, Note.V4));
 *
 * c2.addAll(pre + Note.V1*3, new NoteScale(3, octave, s, Note.V16)); c2.addAll(pre +
 * Note.V1*3 + Note.V16, new NoteScale(2, octave, s, Note.V16)); c2.addAll(pre +
 * Note.V1*3 + Note.V8, new NoteScale(3, octave, s, Note.V8)); c2.addAll(pre +
 * Note.V1*3 + Note.V8 + Note.V8, new NoteScale(2, octave, s, Note.V8));
 * c2.addAll(pre + Note.V1*3 + Note.V8 + Note.V8*2, new NoteScale(1, octave, s,
 * Note.V8)); c2.addAll(pre + Note.V1*3 + Note.V8 + Note.V8*3, new NoteScale(3,
 * octave, s, Note.V8)); c2.addAll(pre + Note.V1*3 + Note.V8 + Note.V8*4, new
 * NoteScale(2, octave, s, Note.V4));
 *
 * Progression l2 = new Progression(s, octave-1) { { // F# G# A B C# D E F# G#
 * A# B C# D# F addAll(Chord.I); // F# A C# I III V
 *
 * addAll(Chord.VI) .inv(2); // F# A D I-III-VI VI 2� inv
 *
 * addAll(Chord.IV) .inv(); // F# B D I IV VI IV 1� inv
 *
 * addAll(Chord.VII, -1) .setLength(Note.V2); // E G# B VII II IV VII
 *
 * addAll(Chord.VII, -1, s.getMajor()) .setLength(Note.V2); // F G# B 3�m 5��
 *
 * setChordArpegio(new ArpegioAscDesc(3, Note.V1, Note.V16)); setChordArpegio(3,
 * new ArpegioAscDesc(3, Note.V1, Note.V16)); setChordArpegio(4, new
 * ArpegioAscDesc(3, Note.V1, Note.V16));
 *
 * } }; c3.addAll(Note.V1*4*i, l2);
 *
 *
 *
 * }
 */

/*
 * for(int i = 0; i < 4; i++) { Progression l = new Progression(s, octave) { {
 * addAll(Chord.I);
 *
 * addAll(Chord.IV).inv(1);
 *
 * addAll(Chord.VII).inv(2);
 *
 * addAll(Chord.III).inv(1);
 *
 * addAll(Chord.VI).inv(2);
 *
 * addAll(Chord.II).inv(1);
 *
 * addAll(Chord.V, 0) .inv(2) .setLength(Note.V2);
 *
 * addAll(Chord.VII, 0, s.getMajor()) .inv(2) .setLength(Note.V2);
 *
 * addAll(Chord.I, 1) .inv(2);
 *
 * setChordArpegio(new ArpegioAscDesc(3, Note.V1, Note.V16)); } };
 * c.addAll(Note.V1*8*i, l); }
 */

/*
 * Progression l = new Progression(s, octave) { { int[] primary = new
 * int[]{Chord.I, Chord.IV, Chord.V}; int[] secondary = new int[]{Chord.II,
 * Chord.III, Chord.VI};
 *
 * addAll(primary[0]); for (int i = 0; i < 10; i++) { int rnd = new
 * SecureRandom().nextInt(primary.size); addAll(primary[rnd]); rnd = new
 * SecureRandom().nextInt(secondary.size); addAll(secondary[rnd]); rnd = new
 * SecureRandom().nextInt(primary.size); addAll(primary[rnd]);
 * addAll(Chord.VII).inv(2); }
 *
 * setChordArpegio(new ArpegioAscDesc(3, Note.V1, Note.V16)); } }; c.addAll(0, l);
 */

/*
 * addAll(Chord.I);
 *
 * addAll(Chord.V).inv(2);
 *
 * addAll(Chord.VI).inv(2);
 *
 * addAll(Chord.IV).inv(1);
 *
 * addAll(Chord.I).inv(1);
 *
 * addAll(Chord.IV).inv(2);
 *
 * addAll(Chord.VI).inv(2);
 *
 * addAll(Chord.V).inv(2);
 */

// setChordArpegio(new ArpegioAscDesc(3, Note.V1, Note.V8));
