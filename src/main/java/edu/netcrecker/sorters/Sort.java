package edu.netcrecker.sorters;

import java.util.ArrayList;

/**
 * @author Tsytovtseva
 */
public abstract class Sort {
    public abstract ArrayList<Integer> sort(ArrayList<Integer> arr);
    protected void swap(ArrayList<Integer> arr, int i, int j){
        arr.set(i,arr.get(i)+arr.get(j));
        arr.set(j,arr.get(i)-arr.get(j));
        arr.set(i, arr.get(i)-arr.get(j));
    }


}
