package es.danisales.datune.timelayer;

import es.danisales.datune.tempo.Time;

public interface TimeLayer<C, T extends Time<T>> {
    C get(T time);
    T getLength();

    void remove(T time);
}
