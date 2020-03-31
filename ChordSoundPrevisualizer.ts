import { ChromaticChord } from './ChromaticChord';
import * as Tone from 'tone';
import { Chromatic } from './Chromatic';
import { ChromaticUtils } from './ChromaticUtils';
import { Utils } from './Utils';

export abstract class ChordSoundPrevisualizer {
    public static NORMAL = new (class NormalChordSoundPrevisualizer extends ChordSoundPrevisualizer {
        protected updatePart() {
            var playArray = [];

            playArray.push({ time: 0, note: this.toneNotesArray, dur: '2n' });

            this.part = new Tone.Part(function (time, event) {
                console.log("part " + event.note + " " + event.dur + " " + time)
                ChordSoundPrevisualizer.polySynth.triggerAttackRelease(event.note, event.dur, time)
            }, playArray);
            this.part.start(0);
            Tone.Transport.loopEnd = 3 * Tone.Time('4n');
            Tone.Transport.loop = true
        }
    })();

    public static ROOT3_TENSIONS = new (class NormalChordSoundPrevisualizer extends ChordSoundPrevisualizer {
        protected updatePart() {
            let length = (this.toneNotesArray.length * 2) * Tone.Time('8n');

            var playArray = [];

            playArray.push({ time: 0, note: this.getRoot(), dur: length, "velocity": 0.5 });

            let i = 0;
            for (let noteStr of this.toneNotesArray) {
                let octave = +noteStr.substr(noteStr.length - 1);

                noteStr = noteStr.substring(0, noteStr.length - 1) + octave;
                playArray.push({ time: { '8n': 1 + i }, note: noteStr, dur: '8n' });
                if (i < this.toneNotesArray.length - 1)
                    playArray.push({ time: { '8n': 1 + this.toneNotesArray.length * 2 - i - 2 }, note: noteStr, dur: '8n' });
                i++;
            }

            this.part = new Tone.Part(function (time, event) {
                console.log("part " + event.note + " " + event.dur + " " + time)
                ChordSoundPrevisualizer.polySynth.triggerAttackRelease(event.note, event.dur, time, event.velocity)
            }, playArray);
            this.part.start(0);
            Tone.Transport.loopEnd = length + Tone.Time('8n');
            Tone.Transport.loop = true
        }

        private getRoot(): string[] {
            let root = [];
            let i = 0;
            for (let noteStr of this.toneNotesArray) {
                if (i % 2 == 0 && root.length < 3) {
                    let octave = +noteStr.substr(noteStr.length - 1);
                    octave--;
                    noteStr = noteStr.substring(0, noteStr.length - 1) + octave;
                    root.push(noteStr);
                }
                i++;
            }

            return root;
        }



        public stop(chromaticChord: ChromaticChord) {
            super.stop(chromaticChord);

            ChordSoundPrevisualizer.polySynth.triggerRelease(this.getRoot());
        }
    })();

    public static ROOT4_TENSIONS = new (class NormalChordSoundPrevisualizer extends ChordSoundPrevisualizer {
        protected updatePart() {
            let length = (this.toneNotesArray.length * 2) * Tone.Time('8n');

            var playArray = [];

            playArray.push({ time: 0, note: this.getRoot(), dur: length, velocity: 0.5 });

            let i = 0;
            for (let noteStr of this.toneNotesArray) {
                let octave = +noteStr.substr(noteStr.length - 1);

                noteStr = noteStr.substring(0, noteStr.length - 1) + octave;
                playArray.push({ time: { '8n': 1 + i }, note: noteStr, dur: '8n' });
                if (i < this.toneNotesArray.length - 1)
                    playArray.push({ time: { '8n': 1 + this.toneNotesArray.length * 2 - i - 2 }, note: noteStr, dur: '8n' });
                i++;
            }

            this.part = new Tone.Part(function (time, event) {
                console.log("part " + event.note + " " + event.dur + " " + time)
                ChordSoundPrevisualizer.polySynth.triggerAttackRelease(event.note, event.dur, time, event.velocity)
            }, playArray);
            this.part.start(0);
            Tone.Transport.loopEnd = length + Tone.Time('8n');
            Tone.Transport.loop = true
        }

        private getRoot(): string[] {
            let root = [];
            let i = 0;
            for (let noteStr of this.toneNotesArray) {
                if (i % 2 == 0 && root.length < 4) {
                    let octave = +noteStr.substr(noteStr.length - 1);
                    octave--;
                    noteStr = noteStr.substring(0, noteStr.length - 1) + octave;
                    root.push(noteStr);
                }
                i++;
            }

            return root;
        }

        public stop(chromaticChord: ChromaticChord) {
            super.stop(chromaticChord);

            ChordSoundPrevisualizer.polySynth.triggerRelease(this.getRoot());
        }
    })();

    public static BASS_ARP = new (class NormalChordSoundPrevisualizer extends ChordSoundPrevisualizer {
        protected updatePart() {
            var playArray = [];

            let length = Tone.Time('4n') + (this.toneNotesArray.length * 2 - 1) * Tone.Time('8n');

            playArray.push({ time: 0, note: this.getRootBass(), dur: length, velocity: 0.75 });
            playArray.push({ time: 0, note: this.toneNotesArray.slice(1), dur: '4n' });
            let i = 0;
            for (let noteStr of this.toneNotesArray) {
                playArray.push({ time: { '4n': 1, '8n': i }, note: noteStr, dur: '8n' });
                if (i < this.toneNotesArray.length - 1)
                    playArray.push({ time: { '4n': 1, '8n': this.toneNotesArray.length * 2 - i - 2 }, note: noteStr, dur: '8n' });
                i++;
            }

            this.part = new Tone.Part(function (time, event) {
                console.log("part " + event.note + " " + event.dur + " " + time)
                ChordSoundPrevisualizer.polySynth.triggerAttackRelease(event.note, event.dur, time)
            }, playArray);
            this.part.start(0);
            Tone.Transport.loopEnd = length + Tone.Time('8n');
            Tone.Transport.loop = true;
        }

        private getRootBass(): string {
            let bass = Utils.cloneString(this.toneNotesArray[0]);
            let octaveBass = +bass.substring(bass.length - 1);
            octaveBass--;
            bass = bass.substring(0, bass.length - 1) + octaveBass;

            return bass;
        }

        public stop(chromaticChord: ChromaticChord) {
            super.stop(chromaticChord);

            ChordSoundPrevisualizer.polySynth.triggerRelease(this.getRootBass());
        }
    });

    public static ARPEGGIO = new (class NormalChordSoundPrevisualizer extends ChordSoundPrevisualizer {
        protected updatePart() {
            var playArray = [];

            let i = 0;
            for (let noteStr of this.toneNotesArray) {
                playArray.push({ time: { '8n': i }, note: noteStr, dur: '8n' });
                if (i < this.toneNotesArray.length - 1)
                    playArray.push({ time: { '8n': this.toneNotesArray.length * 2 - i - 2 }, note: noteStr, dur: '8n' });
                i++;
            }

            this.part = new Tone.Part(function (time, event) {
                ChordSoundPrevisualizer.polySynth.triggerAttackRelease(event.note, event.dur, time)
            }, playArray);
            this.part.start(0);
            Tone.Transport.loopEnd = (2 * this.toneNotesArray.length - 2) * Tone.Time('8n');
            Tone.Transport.loop = true
        }
    })();

    public static INSTRUMENT_SAW = new Tone.PolySynth(10, Tone.Synth, {
        oscillator: {
            type: 'sawtooth8'
        },
        envelope: {
            attack: 0.005,
            decay: 0.1,
            sustain: 0.3,
            release: 0.001
        }
    }).toMaster();

    private static polySynth = ChordSoundPrevisualizer.INSTRUMENT_SAW;

    private toneNotesArray: String[];
    protected part;

    public play(chord: ChromaticChord): void {
        this.calculateToneNotesArray(chord);
        console.log("mouseDown " + this.toneNotesArray);

        Tone.Transport.cancel();
        this.updatePart();

        Tone.Transport.start();
    }

    protected abstract updatePart(): void;

    public stop(chord: ChromaticChord) {
        console.log("mouseUp " + this.toneNotesArray);
        Tone.Transport.stop();
        ChordSoundPrevisualizer.polySynth.triggerRelease(this.toneNotesArray);
    }

    protected calculateToneNotesArray(chord: ChromaticChord, options = {
        octaveInitial: 4,
        octaveShift: [
            0
        ]
    }): void {
        this.toneNotesArray = [];

        let lastChromatic: Chromatic;
        let octaveShift = 0, octaveInitial = options.octaveInitial;
        let notes = chord.getNotes();

        let i = 0;
        for (let chromatic of notes) {
            let str = ChromaticUtils.toString(chromatic);
            if (lastChromatic != null && chromatic < lastChromatic)
                octaveShift++;
            if (options.octaveShift[i] !== undefined)
                octaveShift += options.octaveShift[i];
            lastChromatic = chromatic;
            this.toneNotesArray.push(str + (octaveInitial + octaveShift));
            i++;
        };
    }
}