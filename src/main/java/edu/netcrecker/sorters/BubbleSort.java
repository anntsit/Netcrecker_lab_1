package edu.netcrecker.sorters;

import java.util.ArrayList;

/**
 * @author Tsytovtseva
 */
public abstract class BubbleSort extends Sort {

    protected abstract boolean conditionToSwap(ArrayList<Integer> arr, int b);

    public final ArrayList<Integer> sort(ArrayList<Integer> array) {
        ArrayList<Integer> arr = (ArrayList<Integer>)array.clone();
        int n = arr.size();
        for(int i=0; i < n ; i++){
            for(int j=1; j < (n-i); j++){
                if(conditionToSwap(arr, j)){
                    swap(arr, j-1, j);
                }
            }
        }
        return arr;
    }
}
