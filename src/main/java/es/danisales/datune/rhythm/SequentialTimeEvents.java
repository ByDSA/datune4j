package es.danisales.datune.rhythm;

import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.tempo.Time;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public class SequentialTimeEvents<O, C extends DurableEvent<O, T>, T extends Time<T>>
        implements TimeLayer<O, T>, Iterable<Map.Entry<T,C>> {
    private TreeMap<T, C> content;

    SequentialTimeEvents() {
        content = new TreeMap<>();
    }

    public static <O, C extends DurableEvent<O, T>, T extends Time<T>> SequentialTimeEvents<O, C, T> create() {
        return new SequentialTimeEvents<>();
    }

    public void add(C durableEvent) {
        content.put(durableEvent.getIni(), durableEvent);
    }

    @Override
    @Nullable
    public O get(T time) {
        T length = getLength();
        if (length == null)
            return null;

        if (time.compareTo(length) >= 0)
            return null;

        Map.Entry<T, C> entry = content.floorEntry(time);
        if (entry == null)
            return null;

        C durableEvent = entry.getValue();
        if (time.isBetween(durableEvent.getIni(), durableEvent.getEnd()))
            return durableEvent.getNote();
        return null;
    }

    @SuppressWarnings("unused")
    @Nullable
    public C getEvent(T time) {
        return content.floorEntry(time).getValue();
    }

    @Override
    @Nullable
    public T getLength() {
        if (content.size() == 0)
            return null;
        return content.lastEntry().getValue().getEnd();
    }

    @Override
    public void remove(T time) {
        content.remove(content.floorKey(time));
    }

    @SuppressWarnings("WeakerAccess")
    public void removeAndShift(T time) {
        T floorKey = content.floorKey(time);
        T nextKey = content.higherKey(floorKey);
        content.remove(floorKey);

        T difference = nextKey.clone().sub(floorKey);

        while (nextKey != null) {
            C nextKeyContent = content.get(nextKey);
            nextKeyContent.getIni().sub(difference); // Misma referencia que la key, se cambia automáticamente la key
            nextKeyContent.getEnd().sub(difference);

            nextKey = content.higherKey(nextKey);
        }
    }

    public List<O> toList() {
        List<O> ret = new ArrayList<>();
        for (Map.Entry<T, C> entry : content.entrySet())
            ret.add(entry.getValue().getNote());

        return ret;
    }

    @Override
    @NonNull
    public Iterator<Map.Entry<T, C>> iterator() {
        return content.entrySet().iterator();
    }

    @NonNull
    public Iterator<Map.Entry<T, C>> iterator(T time) {
        Iterator<Map.Entry<T, C>> iterator = iterator();

        Map.Entry<T, C> entry;
        while (iterator.hasNext()) {
            entry = iterator.next();
            if (entry.getKey().compareTo(time) >= 0)
                break;
        }

        return iterator;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        content.forEach((T key, C value) -> stringBuilder.append(value).append("\n"));

        return stringBuilder.toString();
    }
}
