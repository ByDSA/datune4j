package es.danisales.datune.degrees;

public interface CyclicDegree extends OrderedDegree {
    @Override
    CyclicDegree getNext();
    @Override
    CyclicDegree getPrevious();
    @Override
    CyclicDegree getShifted(int i);
}
