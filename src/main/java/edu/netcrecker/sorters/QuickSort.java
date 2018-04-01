package edu.netcrecker.sorters;

import java.util.ArrayList;

/**
 * @author Tsytovtseva
 */
public class QuickSort extends Sort {

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        ArrayList<Integer> arr = (ArrayList<Integer>)array.clone();
        int startIndex = 0;
        int endIndex = arr.size() - 1;
        return doSort(arr,startIndex, endIndex);
    }

    private ArrayList<Integer> doSort(ArrayList<Integer> array, int start, int end) {
        if (start >= end)
            return array;
        int i = start,
                j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array.get(i) <= array.get(cur))) {
                i++;
            }
            while (j > cur && (array.get(cur) <= array.get(j))) {
                j--;
            }
            if (i < j) {
                swap(array,i,j);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(array,start, cur);
        doSort(array,cur+1, end);
        return array;
    }
}
