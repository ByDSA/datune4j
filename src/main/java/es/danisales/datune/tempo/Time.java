package es.danisales.datune.tempo;

import org.checkerframework.checker.nullness.qual.NonNull;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

public interface Time<T extends Time>
		extends Comparable<T> {
	T add(@NonNull T time);

	T sub(@NonNull T time);

	int getDiv(@NonNull T cellSize);
	T mult(int n);

	boolean isBetween(T a, T b);

	T clone();
}
