package es.danisales.datune.rhythm;

public interface TimeLayer<C> {
    C get(double time);
    double getLength();
}
