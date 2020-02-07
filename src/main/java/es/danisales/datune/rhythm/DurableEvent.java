package es.danisales.datune.rhythm;

import es.danisales.datune.tempo.Time;

public class DurableEvent<O, T extends Time> {
    private T ini;
    private T end;
    private O note;

    @SuppressWarnings("unchecked")
    private DurableEvent(T ini, O note, T length) {
        this.ini = (T)ini.clone();
        this.note = note;
        this.end = (T)ini.clone();
        end.add(length);
    }

    public static <O, T extends Time> DurableEvent<O, T> from(T ini, O note, T length) {
        return new DurableEvent<>(ini, note, length);
    }

    @SuppressWarnings("WeakerAccess")
    public T getIni() {
        return ini;
    }

    public T getEnd() {
        return end;
    }

    public O getNote() {
        return note;
    }

    public void setNote(O note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "[" + ini + ", " + end + "]: " + note;
    }
}
