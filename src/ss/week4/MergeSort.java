package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /**
     * Sort the given list with mergeSort
     * @param list to be sorrted
     * @return the sorted map
     */
    public static <E extends Comparable<E>> List<E> mergesort(List<E> list) {
        List<E> l = new ArrayList<>();
        List<E> r = new ArrayList<>();
        int middle;
        if (list.size()<=1) {
            return list;
        }
        else {
            middle = list.size()/2;
            for (int i = 0; i < middle; i++) {
                l.add(list.get(i));
            }
            for (int j = middle; j < list.size(); j++) {
                r.add(list.get(j));
            }
            l = mergesort(l);
            r = mergesort(r);
            merge(l,r,list);
        }
        return list;
    }
    /**
     * Merges the given partial lists
     * @param l, r, list left and right partial lists and the original list.
     */
    public static <E extends Comparable<E>> void merge (List<E> l, List<E> r, List<E> list) {
        int lI = 0;
        int rI = 0;
        int listI = 0;
        while (lI<l.size()&&rI<r.size()) {
            if (l.get(lI).compareTo(r.get(rI))<0) {
                list.set(listI, l.get(lI));
                lI++;
            }
            else {
                list.set(listI, r.get(rI));
                rI++;
            }
            listI++;
        }
        // add remaining elements
        while (lI<l.size()) {
            list.set(listI, l.get(lI));
            listI++;
            lI++;
        }
        while (rI<r.size()) {
            list.set(listI,r.get(rI));
            listI++;
            rI++;
        }
    }
}
