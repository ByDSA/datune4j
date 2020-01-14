package es.danisales.datune.songs;

import es.danisales.datune.eventsequences.*;
import es.danisales.datune.function.ChromaticFunction;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.interval.IntervalDiatonic;
import es.danisales.datune.midi.ChordMidiTransformations;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.Duration;
import es.danisales.datune.midi.Progressions.Progression;
import es.danisales.datune.midi.arpegios.ArpeggioAsc;
import es.danisales.datune.midi.arpegios.ArpeggioDefault;
import es.danisales.datune.midi.arpegios.ArpeggioDesc;
import es.danisales.datune.midi.arpegios.ArpeggioPowerGuitars;
import es.danisales.datune.midi.binaries.Song;
import es.danisales.datune.midi.binaries.events.EventComplex;
import es.danisales.datune.midi.binaries.events.Pan;
import es.danisales.datune.midi.binaries.events.Volume;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.ChordTransformations;
import es.danisales.datune.tonality.Tonality;

import java.util.List;

public class Power extends Song {
	Track channelGuitars1;
	Track channelOrgan;
	Track channelPad;
	Track channelGuitars2;
	DrumsTrack drums;

	Progression startProgression;

	{
		startProgression = new Progression(tonality, 3) {
			{
				add(DiatonicFunction.VI);
				add(DiatonicFunction.IV).inv(1);
				add(DiatonicFunction.I).inv(2);
				add(DiatonicFunction.V);

                add(ChromaticFunction.VISUS4).inv(-1);
				add(DiatonicFunction.IV6);
                add(ChromaticFunction.ISUS4).inv(1);
				DiatonicChordMidi dc = add(ChromaticFunction.V_V);
				dc.inv(1);
				dc.setLength(Duration.L2);
				dc = add(DiatonicFunction.V7);
				dc.inv(-1);
				dc.setLength(Duration.L2);
			}
		};

		startProgression.setArpegio(new ArpeggioDefault());
	}

	public Power() throws PitchMidiException {
		super("power.mid", 130);
		tonality = Tonality.E;

		channelGuitars1 = createTrack(0, Instrument.get(30));
		channelGuitars2 = createTrack(1, Instrument.get(30));
		channelOrgan = createTrack(2, Instrument.get(62));
		channelPad = createTrack(3, Instrument.get(94));
		drums = createDrumsTrack();

		channelGuitars1.setVolume((int)(Volume.MAX/10.0*8));
		channelGuitars2.setVolume((int)(Volume.MAX/10.0*9));
		channelOrgan.setVolume((int)(Volume.MAX/5.0*3));
		channelPad.setVolume((int)(Volume.MAX/4.0*3));
		channelGuitars1.setPan((Pan.LEFT+Pan.MID)/2);
		channelGuitars2.setPan((Pan.RIGHT+Pan.MID)/2);
		channelPad.setPan((Pan.LEFT+Pan.MID*2)/3);
		channelOrgan.setPan(Pan.RIGHT);

		int seek = 0;

		seek += startPattern(seek);

		seek += bridge(seek, 0);

		channelOrgan.changeProgram(seek, Instrument.get(62));

		seek += a(seek);

		seek += bridge(seek, 1);

		seek += b(seek);

		seek += bridge(seek, 2);

		seek += Duration.L2;

		seek += chorus(seek);
	}

	private EventComplex startMelody() throws PitchMidiException {
		List<DiatonicChordMidi> chords = ChordMidiTransformations.shiftOctaveList(ChordTransformations.duplicateList(startProgression.getChords()), 2);

		MelodyByChords l = new MelodyByChords(chords);

		for(int i = 0; i < 8; i++) {
			if (i == 3) {
				l.add(i*Duration.L1 + 0, 2, Duration.L4);
				l.add(i*Duration.L1 + Duration.L4, 1, Duration.L4);
				l.add(i*Duration.L1 + Duration.L2, 0, Duration.L8);
				l.add(i*Duration.L1 + Duration.L2 + Duration.L8, 1, Duration.L8);
				l.add(i*Duration.L1 + Duration.L2 + Duration.L4, 2, Duration.L8);
				l.add(i*Duration.L1 + Duration.L2 + Duration.L4 + Duration.L8, 1, Duration.L8);
			} else if (i == 5) {
				l.add(i*Duration.L1 + 0, 4, Duration.L4);
				l.add(i*Duration.L1 + Duration.L4, 5, Duration.L4);
				l.add(i*Duration.L1 + Duration.L2, 4, Duration.L8);
				l.add(i*Duration.L1 + Duration.L2 + Duration.L8, 2, Duration.L8);
				l.add(i*Duration.L1 + Duration.L2 + Duration.L4, 4, Duration.L8);
				l.add(i*Duration.L1 + Duration.L2 + Duration.L4 + Duration.L8, 3, Duration.L8);
			} else if (i == 6) {
				l.add(i*Duration.L1 + 0, 3, Duration.L4 +Duration.L8);
				l.add(i*Duration.L1 + Duration.L4 +Duration.L8, 2, Duration.L8);
				DiatonicMidi dm = l.add(i * Duration.L1 + Duration.L2, 1, Duration.L2_3);
				dm.getPitch().shift(IntervalDiatonic.SECOND);
				l.add(i*Duration.L1 + Duration.L2 +Duration.L2_3, 2, Duration.L2_3);
				l.add(i*Duration.L1 + Duration.L2 +2*Duration.L2_3, 3, Duration.L2_3);
			} else if (i == 7) {
				l.add(i*Duration.L1 + 0, 2, 2*Duration.L4_3);
				l.add(i*Duration.L1 + 2*Duration.L4_3, 3, Duration.L4_3);
				l.add(i*Duration.L1 + Duration.L4, 4, Duration.L4_3);
				l.add(i*Duration.L1 + Duration.L4 + Duration.L4_3, 3, Duration.L4_3);
				l.add(i*Duration.L1 + Duration.L4 + 2*Duration.L4_3, 2, Duration.L4_3);

				l.add(i*Duration.L1 + Duration.L2 + 0, 0, Duration.L2_3);
				l.add(i*Duration.L1 + Duration.L2 + Duration.L2_3, 1, Duration.L2_3);
				l.add(i*Duration.L1 + Duration.L2 + 2*Duration.L2_3, 2, Duration.L2_3);
			} else {
				int s = 0;
				if (i == 1)
					s = 1;
				else if (i == 2)
					s = 2;
				if (i == 4)
					s = 1;

				l.add(i*Duration.L1 + 0, 					2+s, Duration.L4 +Duration.L8);
				l.add(i*Duration.L1 + Duration.L4 +Duration.L8, 		1+s, Duration.L8);
				l.add(i*Duration.L1 + Duration.L2, 				0+s, Duration.L2_3);
				l.add(i*Duration.L1 + Duration.L2 +Duration.L2_3, 	1+s, Duration.L2_3);
				l.add(i*Duration.L1 + Duration.L2 +2*Duration.L2_3, 	2+s, Duration.L2_3);
			}
		}

		return l;
	}

	private Progression chorusGuitarsProgression() {
		return new Progression(tonality, 3) {
			{
				add(DiatonicFunction.VI).inv(-2);
				add(DiatonicFunction.IV, 1).inv(1);
				add(DiatonicFunction.I, 1).inv(0);
				add(DiatonicFunction.V).inv(-1);

				add(DiatonicFunction.VI).inv(-1);
				add(DiatonicFunction.IV, 1).inv(0);
				add(DiatonicFunction.I, 1).inv(-1);
				add(DiatonicFunction.V).inv(-2);
			}
		};
	}

	private Progression startOrganProgression() throws PitchMidiException {
		return startProgression.clone()
				.setArpegio(new ArpeggioDesc(Duration.L1, Duration.L4_3))
				.setArpegio(new int[]{2, 3, 4, 6}, new ArpeggioAsc(Duration.L1, Duration.L4_3))
				.setArpegio(new int[]{4}, new ArpeggioDesc(Duration.L1, Duration.L4_3))
				.setArpegio(new int[]{5, 6}, new ArpeggioAsc(Duration.L1, Duration.L4_3))
				.setArpegio(new int[]{7, 8}, new ArpeggioAsc(Duration.L1, Duration.L8))
				.shiftOctave(3);
	}

	Progression startPad() throws PitchMidiException {
		return startProgression.clone().shiftOctave(1);
	}

	Progression chorusPad() throws PitchMidiException {
		return chorusGuitarsProgression().clone().shiftOctave(1);
	}

	int startPattern(int seek) throws PitchMidiException {
		channelGuitars2.add(seek, startProgression);

		channelGuitars1.add(seek, startMelody());

		channelOrgan.add(seek, startOrganProgression());

		channelPad.add(seek, startPad());

		for(int i = Duration.L2; i <= Duration.L1 *7; i+= Duration.L2)
			if (i != Duration.L2 + Duration.L1 *3)
				drums.add(seek + i, 						Drums.BASS_DRUM1);

		for(int i = 0; i <= Duration.L1 *8; i+= Duration.L1)
			drums.add(seek + i, 							Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *4-Duration.L2 - Duration.L4, 		Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *4-Duration.L2, 				Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *4-Duration.L4 -Duration.L8, 		Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *4-Duration.L4, 				Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *4-Duration.L8, 				Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *8-Duration.L2 -Duration.L2_3 *2, 	Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *8-Duration.L2 -Duration.L2_3, 		Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *8-Duration.L2, 				Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *8-Duration.L2 +Duration.L2_3, 		Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.L1 *8-Duration.L2 +Duration.L2_3 *2, 	Drums.ACOUSTIC_SNARE);

		return startPad().getDuration();
	}

	int chorus(int seek) throws PitchMidiException {

		Progression chorusGuitars = chorusGuitarsProgression();
		channelGuitars2.add(seek, chorusGuitars);

		//channelGuitars1.getWithSemiAdded(seek, startProgression());

		//channelOrgan.getWithSemiAdded(seek, startOrganProgression());

		channelPad.add(seek, chorusPad());

		drums.add(seek, DrumsSequence.POWER);

		return startPad().getDuration();

	}

	int bridge(int seek, int n) throws PitchMidiException {
		Progression cad = new Progression(tonality, 3) {
			{
				DiatonicChordMidi c1, c2;
				if (n == 2)
					c1 = add(DiatonicFunction.VI, -1);
				else
					c1 = add(DiatonicFunction.VI, -1);
				c1.setLength(Duration.L1 *2);
				c1.setArpeggio(new ArpeggioPowerGuitars());

				if (n == 2)
					c2 = add(DiatonicFunction.V, -1);
				else
					c2 = add(DiatonicFunction.V, -1);
				c2.setLength(Duration.L1 *2);
				c2.setArpeggio(new ArpeggioDefault(Duration.L1 * 2));
			}
		};

		if (n == 2)
			for(int i = 0; i < cad.getChords().size(); i++) {
				DiatonicChordMidi c = (DiatonicChordMidi) cad.getChords().get(i);
				if (i == 0) {
					c.addInterval(IntervalDiatonic.NINTH);
					//c.addInterval(IntervalDiatonic.C_SIXTH);
					//c.addInterval(IntervalDiatonic.C_SEVENTH);
					System.out.println(c);
				} else {
					//c.addInterval(IntervalDiatonic.TENTH);
					c.addInterval(IntervalDiatonic.SEVENTH);
				}

			}

        Progression cad_pad = cad.clone();
		cad_pad.setArpegio(new ArpeggioDefault(Duration.L1 * 2))
				.shiftOctave(2);
		channelPad.add(seek, cad_pad);

		MelodyByChords guitar1 = new MelodyByChords(cad.getChords());
		guitar1.shiftOctave(1);

		switch(n) {
			case 0:
				for(int i = 0; i < 4; i++) {
					guitar1.add(i*Duration.L1 + 0, 1, Duration.L4 -Duration.L16);
					guitar1.add(i*Duration.L1 + 0, 3, Duration.L4 -Duration.L16);
					guitar1.add(i*Duration.L1 + Duration.L4, 2, Duration.L8);
					guitar1.add(i*Duration.L1 + Duration.L4, 4, Duration.L8);
					guitar1.add(i*Duration.L1 + Duration.L4 + Duration.L8, 1, Duration.L4);
					guitar1.add(i*Duration.L1 + Duration.L4 + Duration.L8, 3, Duration.L4);
					guitar1.add(i*Duration.L1 + Duration.L4 *2 + Duration.L8, 0, Duration.L4);
					guitar1.add(i*Duration.L1 + Duration.L4 *2 + Duration.L8, 2, Duration.L4);
				}
				break;

			case 1:
				for(int i = 0; i < 4; i++) {
					guitar1.add(i*Duration.L1 + 0, 0, Duration.L4 -Duration.L16);
					guitar1.add(i*Duration.L1 + 0, 1, Duration.L4 -Duration.L16);
					guitar1.add(i*Duration.L1 + Duration.L4, 1, Duration.L8);
					guitar1.add(i*Duration.L1 + Duration.L4, 2, Duration.L8);
					guitar1.add(i*Duration.L1 + Duration.L4 + Duration.L8, 2, Duration.L4);
					guitar1.add(i*Duration.L1 + Duration.L4 + Duration.L8, 3, Duration.L4);
					guitar1.add(i*Duration.L1 + Duration.L4 *2 + Duration.L8, 3, Duration.L4);
					guitar1.add(i*Duration.L1 + Duration.L4 *2 + Duration.L8, 4, Duration.L4);
				}
				break;
			case 2:
				for(int i = 0; i < 4; i++) {
					guitar1.add(i*Duration.L1 + 0, 3, Duration.L4 -Duration.L16);
					guitar1.add(i*Duration.L1 + 0, 4, Duration.L4 -Duration.L16);
					guitar1.add(i*Duration.L1 + Duration.L4, 2, Duration.L8);
					guitar1.add(i*Duration.L1 + Duration.L4, 3, Duration.L8);
					guitar1.add(i*Duration.L1 + Duration.L4 + Duration.L8, 1, Duration.L8);
					guitar1.add(i*Duration.L1 + Duration.L4 + Duration.L8, 2, Duration.L8);
					guitar1.add(i*Duration.L1 + Duration.L2 + Duration.L8, 0, Duration.L4);
					guitar1.add(i*Duration.L1 + Duration.L2 + Duration.L8, 1, Duration.L4);
				}
				break;
		}

		channelGuitars1.add(seek, guitar1);

		channelGuitars2.add(seek, cad);

		for (int i = 0; i < cad.getDuration(); i += DrumsSequence.POWER.getLength())
			drums.add(seek + i, DrumsSequence.POWER);

		return cad.getDuration();
	}

	int a(int seek) throws PitchMidiException {
		Progression cad = new Progression(tonality, 4) {
			{
				DiatonicChordMidi dcm = add(DiatonicFunction.I);
				dcm.inv(1);
				dcm.setLength(Duration.L1);
				add(DiatonicFunction.IV).setLength(Duration.L2);
				add(DiatonicFunction.V).setLength(Duration.L2);
				add(DiatonicFunction.VI).setLength(Duration.L1);
				dcm = add(DiatonicFunction.V);
				dcm.inv(-1);
				dcm.setLength(Duration.L1);

				add(DiatonicFunction.I).setLength(Duration.L1);

				dcm = add(DiatonicFunction.IV);
				dcm.inv(-1);
				dcm.setLength(Duration.L2);

				dcm = add(DiatonicFunction.V);
				dcm.inv(-1);
				dcm.setLength(Duration.L2);

				dcm = add(DiatonicFunction.VI);
				dcm.inv(-1);
				dcm.setLength(Duration.L1);

				dcm = add(DiatonicFunction.VII);
				dcm.inv(-1);
				dcm.setLength(Duration.L1);
			}
		};

		channelPad.add(seek, cad);

        Progression arp = cad.clone().shiftOctave(2);

		arp.setArpegio(new ArpeggioDesc(Duration.L4, Duration.L4_3));
		channelOrgan.add(seek, arp);
		/*
		for(int i = 0; i < cad.getNodes().size()-1; i++) {
			Chord ch = cad.getChord(i);
			ch.getWithSemiAdded(Interval.OCTAVE)
			.getWithSemiAdded(Interval.TENTH)
			.inv(2)
			.setArpeggio(new ArpegioDefault());

		}*/

		for(int i = 0; i < cad.getDuration() / 2; i+= Duration.L4) {
			if ((i + Duration.L4) % Duration.L1 == 0) {
				drums.add(seek + i, 						Drums.ACOUSTIC_SNARE);
				drums.add(seek + i, 						Drums.SPLASH_CYMBAL);
			} else
				drums.add(seek + i, 						Drums.BASS_DRUM1);
			if ((i + Duration.L4) % (Duration.L1 *4) == 0)
				drums.add(seek + i + Duration.L8, 						Drums.BASS_DRUM1);

			if ((i % (Duration.L1) == 0 || i == Duration.L1 + Duration.L2) && (i + Duration.L4) % Duration.L1 != 0) {
				drums.add(seek + i, 						Drums.CRASH_CYMBAL2);
				drums.add(seek + i, 						Drums.CRASH_CYMBAL1);
			} else if (i == cad.getDuration() / 2 - Duration.L4)
				drums.add(seek + i, 						Drums.CHINESE_CYMBAL);
			else
				drums.add(seek + i, 						Drums.RIDE_CYMBAL2);


		}

		for(int i = cad.getDuration() / 2; i < cad.getDuration(); i+= Duration.L2) {
			drums.add(seek + i, 						Drums.BASS_DRUM1);
			drums.add(seek + i + Duration.L16 *3, 						Drums.BASS_DRUM1);

			if (i % (Duration.L1) == 0 || (i == Duration.L1 + Duration.L2)) {
				drums.add(seek + i, 						Drums.CRASH_CYMBAL2);
				drums.add(seek + i, 						Drums.CRASH_CYMBAL1);
			} else
				drums.add(seek + i, 						Drums.RIDE_CYMBAL2);
			drums.add(seek + i + Duration.L4, 						Drums.RIDE_CYMBAL1);
			drums.add(seek + i + Duration.L4, 						Drums.ACOUSTIC_SNARE);
			if (i % Duration.L1 == 0)
				drums.add(seek + i + Duration.L4 + Duration.L8, 						Drums.ACOUSTIC_SNARE);
		}

		return cad.getDuration();
	}

	int b(int seek) throws PitchMidiException {
		Progression cad = new Progression(tonality, 5) {
			{
				add(DiatonicFunction.VI,-1).setLength(Duration.L1);
				add(DiatonicFunction.V).setLength(Duration.L2);
				add(DiatonicFunction.IV).setLength(Duration.L2);
				add(DiatonicFunction.III).setLength(Duration.L1);
				add(DiatonicFunction.IV).setLength(Duration.L1);

				add(DiatonicFunction.VI,-1).setLength(Duration.L1);
				add(DiatonicFunction.V).setLength(Duration.L1);
				add(DiatonicFunction.IV).setLength(Duration.L2);
				add(DiatonicFunction.III).setLength(Duration.L2);
				add(DiatonicFunction.VII,-1).setLength(Duration.L1);
			}
		};

		channelPad.add(seek, cad);

		for(int i = 0; i < cad.getChords().size(); i++) {
			DiatonicChordMidi c = (DiatonicChordMidi) cad.getChords().get(i);

			//c.getWithSemiAdded(Interval.OCTAVE).getWithSemiAdded(Interval.TENTH);

			c.setArpeggio(new ArpeggioDefault());

			try {
				switch (i) {
					case 0:
						c.inv(2);
						break;
					case 1:
						c.inv(2);
						c.shiftOctave(-1);
						break;
					case 2:
						c.inv(1);
						c.shiftOctave(-1);
						break;
					case 3:
						c.inv(2);
						c.shiftOctave(-1);
						break;
					case 4:
						c.inv(2);
						c.shiftOctave(-1);
						break;
					case 5:
						c.inv(0);
						break;
					case 6:
						c.inv(1);
						c.shiftOctave(-1);
						break;
					case 7:
						c.shiftOctave(-1);
						break;
					case 8:
						c.shiftOctave(-1);
						break;
					case 9:
						c.inv(0);
						break;
				}
			} catch (PitchMidiException e) {

			}
		}

		Progression arp = cad.clone().shiftOctave(1);
		arp.setArpegio(new ArpeggioDesc(Duration.L4, Duration.L4_3));
		channelOrgan.add(seek, arp);

		for(int i = 0; i < cad.getDuration(); i+= Duration.L1) {
			drums.add(seek + i, 						Drums.BASS_DRUM1);
			if (i >= cad.getDuration()/2)
				drums.add(seek + i + Duration.L4, 						Drums.BASS_DRUM1);
			drums.add(seek + i + Duration.L2 -Duration.L8, 						Drums.BASS_DRUM1);
			drums.add(seek + i + Duration.L2, 						Drums.ACOUSTIC_SNARE);
			drums.add(seek + i + Duration.L2 +Duration.L8, 						Drums.BASS_DRUM1);
			if (i >= cad.getDuration()/4*3)
				drums.add(seek + i + Duration.L2 +Duration.L4, 						Drums.BASS_DRUM1);
			if (i >= cad.getDuration()/8*7)
				drums.add(seek + i + Duration.L2 +Duration.L4 +Duration.L8, 						Drums.BASS_DRUM1);
		}

		return cad.getDuration();
	}
}
