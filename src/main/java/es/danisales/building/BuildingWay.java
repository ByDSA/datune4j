package es.danisales.building;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface BuildingWay<T> {
    boolean isReadyToBuild();

    <E extends Exception> @NonNull T build() throws E, BuildingException;
}
