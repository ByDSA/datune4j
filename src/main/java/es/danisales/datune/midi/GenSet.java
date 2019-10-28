package es.danisales.datune.midi;

public class GenSet<E> {

    private Object[] a;

    public GenSet(int s) {
        a = new Object[s];
    }

    public E get(int i) {
        @SuppressWarnings("unchecked")
        final E e = (E) a[i];
        return e;
    }
    
    public void set(int i, E o) {
       a[i] = o;
    }
    
    @SuppressWarnings("unchecked")
	public E[] array() {
    	return (E[]) a;
    }
}
