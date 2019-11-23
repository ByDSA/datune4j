package es.danisales.datune.songs;

import es.danisales.datune.diatonic.ChromaticFunction;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.eventsequences.*;
import es.danisales.datune.midi.Arpegios.ArpegioAsc;
import es.danisales.datune.midi.Arpegios.ArpegioDefault;
import es.danisales.datune.midi.Arpegios.ArpegioDesc;
import es.danisales.datune.midi.Arpegios.ArpegioPowerGuitars;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicMidi;
import es.danisales.datune.midi.Duration;
import es.danisales.datune.midi.Events.EventComplex;
import es.danisales.datune.midi.Events.Pan;
import es.danisales.datune.midi.Events.Volume;
import es.danisales.datune.midi.Progressions.Progression;
import es.danisales.datune.midi.Song;
import es.danisales.datune.tonality.Tonality;

import java.util.ArrayList;

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

				add(DiatonicFunction.VI4).inv(-1);
				add(DiatonicFunction.IV6);
				add(DiatonicFunction.I4).inv(1);
				DiatonicChordMidi dc = add(ChromaticFunction.V_V);
				dc.inv(1);
				dc.setLength(Duration.V2);
				dc = add(DiatonicFunction.V7);
				dc.inv(-1);
				dc.setLength(Duration.V2);
			}
		};

		startProgression.setArpegio(new ArpegioDefault());
	}

	public Power() {
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

		seek += Duration.V2;

		seek += chorus(seek);
	}

	EventComplex startMelody() {
		ArrayList<DiatonicChordMidi> chords = DiatonicChordMidi.shiftOctave( DiatonicChordMidi.duplicate( startProgression.getChords() ), 2);

		MelodyByChords l = new MelodyByChords(chords);

		for(int i = 0; i < 8; i++) {
			if (i == 3) {
				l.add(i*Duration.V1 + 0, 2, Duration.V4);
				l.add(i*Duration.V1 + Duration.V4, 1, Duration.V4);
				l.add(i*Duration.V1 + Duration.V2, 0, Duration.V8);
				l.add(i*Duration.V1 + Duration.V2 + Duration.V8, 1, Duration.V8);
				l.add(i*Duration.V1 + Duration.V2 + Duration.V4, 2, Duration.V8);
				l.add(i*Duration.V1 + Duration.V2 + Duration.V4 + Duration.V8, 1, Duration.V8);
			} else if (i == 5) {
				l.add(i*Duration.V1 + 0, 4, Duration.V4);
				l.add(i*Duration.V1 + Duration.V4, 5, Duration.V4);
				l.add(i*Duration.V1 + Duration.V2, 4, Duration.V8);
				l.add(i*Duration.V1 + Duration.V2 + Duration.V8, 2, Duration.V8);
				l.add(i*Duration.V1 + Duration.V2 + Duration.V4, 4, Duration.V8);
				l.add(i*Duration.V1 + Duration.V2 + Duration.V4 + Duration.V8, 3, Duration.V8);
			} else if (i == 6) {
				l.add(i*Duration.V1 + 0, 3, Duration.V4+Duration.V8);
				l.add(i*Duration.V1 + Duration.V4+Duration.V8, 2, Duration.V8);
                DiatonicMidi dm = l.add(i * Duration.V1 + Duration.V2, 1, Duration.V2_3);
                dm.getPitch().shift(IntervalDiatonic.SECOND);
				l.add(i*Duration.V1 + Duration.V2+Duration.V2_3, 2, Duration.V2_3);
				l.add(i*Duration.V1 + Duration.V2+2*Duration.V2_3, 3, Duration.V2_3);
			} else if (i == 7) {
				l.add(i*Duration.V1 + 0, 2, 2*Duration.V4_3);
				l.add(i*Duration.V1 + 2*Duration.V4_3, 3, Duration.V4_3);
				l.add(i*Duration.V1 + Duration.V4, 4, Duration.V4_3);
				l.add(i*Duration.V1 + Duration.V4 + Duration.V4_3, 3, Duration.V4_3);
				l.add(i*Duration.V1 + Duration.V4 + 2*Duration.V4_3, 2, Duration.V4_3);

				l.add(i*Duration.V1 + Duration.V2 + 0, 0, Duration.V2_3);
				l.add(i*Duration.V1 + Duration.V2 + Duration.V2_3, 1, Duration.V2_3);
				l.add(i*Duration.V1 + Duration.V2 + 2*Duration.V2_3, 2, Duration.V2_3);
			} else {
				int s = 0;
				if (i == 1)
					s = 1;
				else if (i == 2)
					s = 2;
				if (i == 4)
					s = 1;

				l.add(i*Duration.V1 + 0, 					2+s, Duration.V4+Duration.V8);
				l.add(i*Duration.V1 + Duration.V4+Duration.V8, 		1+s, Duration.V8);
				l.add(i*Duration.V1 + Duration.V2, 				0+s, Duration.V2_3);
				l.add(i*Duration.V1 + Duration.V2+Duration.V2_3, 	1+s, Duration.V2_3);
				l.add(i*Duration.V1 + Duration.V2+2*Duration.V2_3, 	2+s, Duration.V2_3);
			}
		}

		return l;
	}

	Progression chorusGuitarsProgression() {
		Progression l = new Progression(tonality, 3) {
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

		return l;
	}

	Progression startOrganProgression() {
		Progression p = ((Progression)startProgression.clone())
				.setArpegio(new ArpegioDesc(Duration.V1, Duration.V4_3))
				.setArpegio(new int[]{2, 3, 4, 6}, new ArpegioAsc(Duration.V1, Duration.V4_3))
				.setArpegio(new int[]{4}, new ArpegioDesc(Duration.V1, Duration.V4_3))
				.setArpegio(new int[]{5, 6}, new ArpegioAsc(Duration.V1, Duration.V4_3))
				.setArpegio(new int[]{7, 8}, new ArpegioAsc(Duration.V1, Duration.V8))
				.shiftOctave(3);

		return p;
	}

	Progression startPad() {
		return ((Progression)startProgression.clone()).shiftOctave(1);
	}

	Progression chorusPad() {
		return ((Progression)chorusGuitarsProgression().clone()).shiftOctave(1);
	}

	int startPattern(int seek) {
		channelGuitars2.add(seek, startProgression);

		channelGuitars1.add(seek, startMelody());

		channelOrgan.add(seek, startOrganProgression());

		channelPad.add(seek, startPad());

		for(int i = Duration.V2; i <= Duration.V1*7; i+= Duration.V2)
			if (i != Duration.V2 + Duration.V1*3)
				drums.add(seek + i, 						Drums.BASS_DRUM1);

		for(int i = 0; i <= Duration.V1*8; i+= Duration.V1)
			drums.add(seek + i, 							Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*4-Duration.V2 - Duration.V4, 		Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*4-Duration.V2, 				Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*4-Duration.V4-Duration.V8, 		Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*4-Duration.V4, 				Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*4-Duration.V8, 				Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*8-Duration.V2-Duration.V2_3*2, 	Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*8-Duration.V2-Duration.V2_3, 		Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*8-Duration.V2, 				Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*8-Duration.V2+Duration.V2_3, 		Drums.ACOUSTIC_SNARE);
		drums.add(seek + Duration.V1*8-Duration.V2+Duration.V2_3*2, 	Drums.ACOUSTIC_SNARE);

		return startPad().getDuration();
	}

	int chorus(int seek) {

		Progression chorusGuitars = chorusGuitarsProgression();
		channelGuitars2.add(seek, chorusGuitars);

		//channelGuitars1.addSemi(seek, startProgression());

		//channelOrgan.addSemi(seek, startOrganProgression());

		channelPad.add(seek, chorusPad());

		drums.add(seek, Drums.POWER);

		return startPad().getDuration();

	}

	int bridge(int seek, int n) {
		Progression cad = new Progression(tonality, 3) {
			{
				DiatonicChordMidi c1, c2;
				if (n == 2)
					c1 = add(DiatonicFunction.VI, -1);
				else
					c1 = add(DiatonicFunction.VI, -1);
				c1.setLength(Duration.V1*2);
				c1.setArpegio(new ArpegioPowerGuitars());

				if (n == 2)
					c2 = add(DiatonicFunction.V, -1);
				else
					c2 = add(DiatonicFunction.V, -1);
				c2.setLength(Duration.V1*2);
				c2.setArpegio(new ArpegioDefault(Duration.V1*2));
			}
		};

		if (n == 2)
			for(int i = 0; i < cad.getChords().size(); i++) {
				DiatonicChordMidi c = (DiatonicChordMidi) cad.getChords().get(i);
				if (i == 0) {
					c.addInterval(IntervalDiatonic.NINTH);
					//c.addInterval(IntervalDiatonic.SIXTH);
					//c.addInterval(IntervalDiatonic.SEVENTH);
					System.out.println(c);
				} else {
					//c.addInterval(IntervalDiatonic.TENTH);
					c.addInterval(IntervalDiatonic.SEVENTH);
				}

			}

		Progression cad_pad = (Progression)cad.clone();
		cad_pad.setArpegio(new ArpegioDefault(Duration.V1*2))
		.shiftOctave(2);
		channelPad.add(seek, cad_pad);

		MelodyByChords guitar1 = new MelodyByChords(cad.getChords());
		guitar1.shiftOctave(1);

		switch(n) {
			case 0:
				for(int i = 0; i < 4; i++) {
					guitar1.add(i*Duration.V1 + 0, 1, Duration.V4-Duration.V16);
					guitar1.add(i*Duration.V1 + 0, 3, Duration.V4-Duration.V16);
					guitar1.add(i*Duration.V1 + Duration.V4, 2, Duration.V8);
					guitar1.add(i*Duration.V1 + Duration.V4, 4, Duration.V8);
					guitar1.add(i*Duration.V1 + Duration.V4 + Duration.V8, 1, Duration.V4);
					guitar1.add(i*Duration.V1 + Duration.V4 + Duration.V8, 3, Duration.V4);
					guitar1.add(i*Duration.V1 + Duration.V4*2 + Duration.V8, 0, Duration.V4);
					guitar1.add(i*Duration.V1 + Duration.V4*2 + Duration.V8, 2, Duration.V4);
				}
				break;

			case 1:
				for(int i = 0; i < 4; i++) {
					guitar1.add(i*Duration.V1 + 0, 0, Duration.V4-Duration.V16);
					guitar1.add(i*Duration.V1 + 0, 1, Duration.V4-Duration.V16);
					guitar1.add(i*Duration.V1 + Duration.V4, 1, Duration.V8);
					guitar1.add(i*Duration.V1 + Duration.V4, 2, Duration.V8);
					guitar1.add(i*Duration.V1 + Duration.V4 + Duration.V8, 2, Duration.V4);
					guitar1.add(i*Duration.V1 + Duration.V4 + Duration.V8, 3, Duration.V4);
					guitar1.add(i*Duration.V1 + Duration.V4*2 + Duration.V8, 3, Duration.V4);
					guitar1.add(i*Duration.V1 + Duration.V4*2 + Duration.V8, 4, Duration.V4);
				}
				break;
			case 2:
				for(int i = 0; i < 4; i++) {
					guitar1.add(i*Duration.V1 + 0, 3, Duration.V4-Duration.V16);
					guitar1.add(i*Duration.V1 + 0, 4, Duration.V4-Duration.V16);
					guitar1.add(i*Duration.V1 + Duration.V4, 2, Duration.V8);
					guitar1.add(i*Duration.V1 + Duration.V4, 3, Duration.V8);
					guitar1.add(i*Duration.V1 + Duration.V4 + Duration.V8, 1, Duration.V8);
					guitar1.add(i*Duration.V1 + Duration.V4 + Duration.V8, 2, Duration.V8);
					guitar1.add(i*Duration.V1 + Duration.V2 + Duration.V8, 0, Duration.V4);
					guitar1.add(i*Duration.V1 + Duration.V2 + Duration.V8, 1, Duration.V4);
				}
				break;
		}

		channelGuitars1.add(seek, guitar1);

		channelGuitars2.add(seek, cad);

		for(int i = 0; i < cad.getDuration(); i+= Drums.POWER.getLength())
			drums.add(seek+ i, Drums.POWER);

		return cad.getDuration();
	}

	int a(int seek) {
		Progression cad = new Progression(tonality, 4) {
			{
				DiatonicChordMidi dcm = add(DiatonicFunction.I);
				dcm.inv(1);
				dcm.setLength(Duration.V1);
				add(DiatonicFunction.IV).setLength(Duration.V2);
				add(DiatonicFunction.V).setLength(Duration.V2);
				add(DiatonicFunction.VI).setLength(Duration.V1);
				dcm = add(DiatonicFunction.V);
				dcm.inv(-1);
				dcm.setLength(Duration.V1);

				add(DiatonicFunction.I).setLength(Duration.V1);

				dcm = add(DiatonicFunction.IV);
				dcm.inv(-1);
				dcm.setLength(Duration.V2);

				dcm = add(DiatonicFunction.V);
				dcm.inv(-1);
				dcm.setLength(Duration.V2);

				dcm = add(DiatonicFunction.VI);
				dcm.inv(-1);
				dcm.setLength(Duration.V1);

				dcm = add(DiatonicFunction.VII);
				dcm.inv(-1);
				dcm.setLength(Duration.V1);
			}
		};

		channelPad.add(seek, cad);

		Progression arp = ((Progression)cad.clone()).shiftOctave(2);

		arp.setArpegio(new ArpegioDesc(Duration.V4, Duration.V4_3));
		channelOrgan.add(seek, arp);
		/*
		for(int i = 0; i < cad.getNodes().size()-1; i++) {
			Chord ch = cad.getChord(i);
			ch.addSemi(Interval.OCTAVE)
			.addSemi(Interval.TENTH)
			.inv(2)
			.setArpegio(new ArpegioDefault());

		}*/

		for(int i = 0; i < cad.getDuration() / 2; i+= Duration.V4) {
			if ((i + Duration.V4) % Duration.V1 == 0) {
				drums.add(seek + i, 						Drums.ACOUSTIC_SNARE);
				drums.add(seek + i, 						Drums.SPLASH_CYMBAL);
			} else
				drums.add(seek + i, 						Drums.BASS_DRUM1);
			if ((i + Duration.V4) % (Duration.V1*4) == 0)
				drums.add(seek + i + Duration.V8, 						Drums.BASS_DRUM1);

			if ((i % (Duration.V1) == 0 || i == Duration.V1 + Duration.V2) && (i + Duration.V4) % Duration.V1 != 0) {
				drums.add(seek + i, 						Drums.CRASH_CYMBAL2);
				drums.add(seek + i, 						Drums.CRASH_CYMBAL1);
			} else if (i == cad.getDuration() / 2 - Duration.V4)
				drums.add(seek + i, 						Drums.CHINESE_CYMBAL);
			else
				drums.add(seek + i, 						Drums.RIDE_CYMBAL2);


		}

		for(int i = cad.getDuration() / 2; i < cad.getDuration(); i+= Duration.V2) {
			drums.add(seek + i, 						Drums.BASS_DRUM1);
			drums.add(seek + i + Duration.V16*3, 						Drums.BASS_DRUM1);

			if (i % (Duration.V1) == 0 || (i == Duration.V1 + Duration.V2)) {
				drums.add(seek + i, 						Drums.CRASH_CYMBAL2);
				drums.add(seek + i, 						Drums.CRASH_CYMBAL1);
			} else
				drums.add(seek + i, 						Drums.RIDE_CYMBAL2);
			drums.add(seek + i + Duration.V4, 						Drums.RIDE_CYMBAL1);
			drums.add(seek + i + Duration.V4, 						Drums.ACOUSTIC_SNARE);
			if (i % Duration.V1 == 0)
				drums.add(seek + i + Duration.V4 + Duration.V8, 						Drums.ACOUSTIC_SNARE);
		}

		return cad.getDuration();
	}

	int b(int seek) {
		Progression cad = new Progression(tonality, 5) {
			{
				add(DiatonicFunction.VI,-1).setLength(Duration.V1);
				add(DiatonicFunction.V).setLength(Duration.V2);
				add(DiatonicFunction.IV).setLength(Duration.V2);
				add(DiatonicFunction.III).setLength(Duration.V1);
				add(DiatonicFunction.IV).setLength(Duration.V1);

				add(DiatonicFunction.VI,-1).setLength(Duration.V1);
				add(DiatonicFunction.V).setLength(Duration.V1);
				add(DiatonicFunction.IV).setLength(Duration.V2);
				add(DiatonicFunction.III).setLength(Duration.V2);
				add(DiatonicFunction.VII,-1).setLength(Duration.V1);
			}
		};

		channelPad.add(seek, cad);

		for(int i = 0; i < cad.getChords().size(); i++) {
			DiatonicChordMidi c = (DiatonicChordMidi) cad.getChords().get(i);

			//c.addSemi(Interval.OCTAVE).addSemi(Interval.TENTH);

			c.setArpegio( new ArpegioDefault() );

			switch(i) {
				case 0: c.inv(2); break;
				case 1: c.inv(2); c.shiftOctave(-1); break;
				case 2: c.inv(1); c.shiftOctave(-1); break;
				case 3: c.inv(2); c.shiftOctave(-1); break;
				case 4: c.inv(2); c.shiftOctave(-1); break;
				case 5: c.inv(0); break;
				case 6: c.inv(1); c.shiftOctave(-1); break;
				case 7: c.shiftOctave(-1); break;
				case 8: c.shiftOctave(-1); break;
				case 9: c.inv(0); break;
			}
		}

		Progression arp = ((Progression)cad.clone()).shiftOctave(1);
		arp.setArpegio(new ArpegioDesc(Duration.V4, Duration.V4_3));
		channelOrgan.add(seek, arp);

		for(int i = 0; i < cad.getDuration(); i+= Duration.V1) {
			drums.add(seek + i, 						Drums.BASS_DRUM1);
			if (i >= cad.getDuration()/2)
				drums.add(seek + i + Duration.V4, 						Drums.BASS_DRUM1);
			drums.add(seek + i + Duration.V2-Duration.V8, 						Drums.BASS_DRUM1);
			drums.add(seek + i + Duration.V2, 						Drums.ACOUSTIC_SNARE);
			drums.add(seek + i + Duration.V2+Duration.V8, 						Drums.BASS_DRUM1);
			if (i >= cad.getDuration()/4*3)
				drums.add(seek + i + Duration.V2+Duration.V4, 						Drums.BASS_DRUM1);
			if (i >= cad.getDuration()/8*7)
				drums.add(seek + i + Duration.V2+Duration.V4+Duration.V8, 						Drums.BASS_DRUM1);
		}

		return cad.getDuration();
	}
}
