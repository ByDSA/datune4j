package es.danisales.datune.rhythm;

import es.danisales.datastructures.ListProxy;
import es.danisales.datune.tempo.MusicalTime;
import es.danisales.datune.voicing.AbsolutePitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VoicesGroup<C extends AbsolutePitch> extends ListProxy<Voice<C>> {
    private VoicesGroup(List<Voice<C>> list) {
        super(list);
    }

    public static <C extends AbsolutePitch> VoicesGroup<C> from(Voice<C>... voices) {
        return new VoicesGroup<>( Arrays.asList(voices) );
    }

    public List<C> get(MusicalTime time) {
        List<C> ret = new ArrayList<>();
        for (Voice<C> voice : this) {
            C note = voice.get(time);
            if (note != null)
                ret.add(note);
        }

        return ret;
    }
}
