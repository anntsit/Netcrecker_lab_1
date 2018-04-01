package edu.netcrecker.sorters;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Tsytovtseva
 */
public class ArraySort extends Sort {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        ArrayList<Integer> arr = (ArrayList<Integer>)array.clone();
        Collections.sort(arr);
        return arr;
    }
}
