package es.danisales.datune.rhythm;

import es.danisales.datune.tempo.Duration;
import javafx.util.Pair;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class SequentialTimeEvents<C> implements TimeLayer<C> {
    private List<Pair<C, Long>> content;

    private double durationCache;

    private SequentialTimeEvents() {
        content = new ArrayList<>();
    }

    @SuppressWarnings("WeakerAccess")
    public static <C> SequentialTimeEvents<C> createEmpty(@SuppressWarnings("unused") Class<C> tClass) {
        return new SequentialTimeEvents<>();
    }

    public void add(C item, double duration) {
        long durationLong = doubleDuration2longDuration(duration);
        Pair<C, Long> pair = new Pair<>(item, durationLong);
        content.add(pair);

        clearDurationCache();
    }

    private long doubleDuration2longDuration(double duration) {
        return Math.round(duration / Duration.SIXTYFOURTH.getValue());
    }

    private double longDuration2doubleDuration(long duration) {
        return duration * Duration.SIXTYFOURTH.getValue();
    }

    public void add(@Nullable C item, Duration duration) {
        add(item, duration.getValue());
    }

    public @Nullable C get(double time) {
        checkArgument(time >= 0);

        Pair<C, Long> pair = getPair(time);
        if (pair == null)
            return null;
        else
            return pair.getKey();
    }

    private @Nullable Pair<C, Long> getPair(double time) {
        long timeLong = doubleDuration2longDuration(time);
        return getPair(timeLong);
    }

    private @Nullable Pair<C, Long> getPair(long time) {
        long t = 0;

        for (Pair<C, Long> c : content) {
            t += c.getValue();
            if (t > time)
                return c;
        }

        return null;
    }

    public boolean remove(double time) {
        Pair<C, Long> item = getPair(time);
        return content.remove(item);
    }

    public boolean removeKeepDuration(double time) {
        Pair<C, Long> item = getPair(time);
        if (item != null) {
            content.set(content.indexOf(item), new Pair<>(null, item.getValue()));
            return true;
        } else
            return false;
    }

    private void clearDurationCache() {
        durationCache = -1;
    }

    private void updateCache() {
        long longDuration = 0;
        for (Pair<C, Long> element : content)
            longDuration += element.getValue();

        durationCache = longDuration2doubleDuration(longDuration);
    }

    public double getLength() {
        if (durationCache < 0)
            updateCache();

        return durationCache;
    }
}
