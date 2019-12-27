package es.danisales.datune.rhythm;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class EucledianRhythmCalculator {
    private final int onNotes;
    private final int totalNotes;

    private List<List<Integer>> groups;
    private int lastIndexOfGroups;
    private int count;

    private EucledianRhythmCalculator(int onNotes, int totalNotes) {
        this.onNotes = onNotes;
        this.totalNotes = totalNotes;
    }

    public static RhythmPattern calculate(int onNotes, int totalNotes) {
        EucledianRhythmCalculator eucledianRythmCalculator
                = new EucledianRhythmCalculator(onNotes, totalNotes);
        eucledianRythmCalculator.initialize();
        eucledianRythmCalculator.process();

        return eucledianRythmCalculator.getRythm();
    }

    private void initialize() {
        groups = new ArrayList<>();
        for (int i = 0; i < totalNotes; i++) {
            boolean b = i < onNotes;
            List<Integer> group = new ArrayList<>();
            group.add(b ? 1 : 0);
            groups.add(group);
        }
    }

    private void process() {
        updateLastIndexOfGroups();
        while (lastIndexOfGroups > 0) {
            count = calculateCount();
            if (count < 0)
                break;
            updateGroups();

            updateLastIndexOfGroups();
        }
    }

    private void updateGroups() {
        List<List<Integer>> newGroups = new ArrayList<>();

        addPairedGroupsTo(newGroups);
        addUnpairedGroupsTo(newGroups);

        groups = newGroups;
    }

    private void addPairedGroupsTo(List<List<Integer>> newGroups) {
        for (int i = 0; i < count; i++) {
            List<Integer> group = groups.get(i);
            group.addAll(groups.get(lastIndexOfGroups - i));
            newGroups.add(group);
        }
    }

    private void addUnpairedGroupsTo(List<List<Integer>> newGroups) {
        newGroups.addAll(groups.subList(count, groups.size() - count));
    }

    private int calculateCount() {
        int start = calculateStartIndex();
        if (start == lastIndexOfGroups)
            return -1;

        int end = calculateEndIndex();
        if (end == 0)
            return -1;

        return Math.min(start, lastIndexOfGroups - end);
    }

    private int calculateStartIndex() {
        int start = 0;
        List<Integer> first = groups.get(0);
        while (start < lastIndexOfGroups && first.equals(groups.get(start)))
            start++;

        return start;
    }

    private int calculateEndIndex() {
        int end = lastIndexOfGroups;
        List<Integer> last = groups.get(lastIndexOfGroups);
        while (end > 0 && last.equals(groups.get(end)))
            end--;

        return end;
    }

    private void updateLastIndexOfGroups() {
        lastIndexOfGroups = groups.size() - 1;
    }

    private RhythmPattern getRythm() {
        List<Integer> ret = concatenateGroups(groups);

        int[] a = ret2Array(ret);

        RhythmPattern retRythm = RhythmPattern.fromInt(a);

        if (onNotes == totalNotes - 1)
            retRythm = retRythm.getReversed();

        return retRythm;
    }

    private static List<Integer> concatenateGroups(List<List<Integer>> groups) {
        List<Integer> ret = new ArrayList<>();
        for (List<Integer> integerList : groups) {
            ret.addAll(integerList);
        }

        return ret;
    }

    private static int[] ret2Array(List<Integer> ret) {
        int[] a = new int[ret.size()];
        for (int i = 0; i < a.length; i++)
            a[i] = ret.get(i);

        return a;
    }
}