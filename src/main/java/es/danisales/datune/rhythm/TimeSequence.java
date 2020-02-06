package es.danisales.datune.rhythm;

import es.danisales.datune.tempo.Time;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TimeSequence<O, C extends DurableEvent<O, T>, T extends Time<T>>
        implements TimeLayer<List<O>, T> {
    private TreeMap<Integer, List<C>> cells;
    private final T cellSize;

    TimeSequence(T cellSize) {
        this.cellSize = cellSize;
        cells = new TreeMap<>();
    }

    private int getCellIndex(@NonNull T time) {
        return time.getDiv(cellSize);
    }

    private List<C> getCellFromTime(T time) {
        int index = getCellIndex(time);
        return getCellFromIndex(index);
    }

    private List<C> getCellFromIndex(int index) {
        return cells.computeIfAbsent(index, k -> new ArrayList<>());
    }

    public void add(C durableEvent) {
        int posCell = getCellIndex(durableEvent.getIni());
        int endCell = getCellIndex(durableEvent.getEnd());

        for (int i = posCell; i <= endCell; i++) {
            List<C> cell = getCellFromIndex(i);

            cell.add(durableEvent);
        }
    }

    @SuppressWarnings("unused")
    public List<C> getEvents(T time) {
        List<C> ret = new ArrayList<>();

        List<C> cell = getCellFromTime(time);
        for (C musicalEvent : cell) {
            if (time.isBetween(musicalEvent.getIni(), musicalEvent.getEnd()))
                ret.add(musicalEvent);
        }

        return ret;
    }

    public List<O> get(T time) {
        List<O> ret = new ArrayList<>();

        List<C> cell = getCellFromTime(time);
        for (C musicalEvent : cell) {
            if (time.isBetween(musicalEvent.getIni(), musicalEvent.getEnd()))
                ret.add(musicalEvent.getNote());
        }

        return ret;
    }

    @Override
    public T getLength() {
        List<C> lastCell = cells.lastEntry().getValue();
        T max = lastCell.get(0).getEnd();
        for (int i = 1; i < lastCell.size(); i++) {
            C c = lastCell.get(i);
            if (c.getEnd().compareTo(max) > 0)
                max = c.getEnd();
        }
        return max;
    }

    @Override
    public void remove(T time) {
        List<C> cell = getCellFromTime(time);
        for (C c : cell) {
            if (time.isBetween(c.getIni(), c.getEnd()))
                cell.remove(c);
        }
    }
}
