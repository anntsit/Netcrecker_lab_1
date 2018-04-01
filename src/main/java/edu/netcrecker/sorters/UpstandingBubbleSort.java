package edu.netcrecker.sorters;

import java.util.ArrayList;

/**
 * @author Tsytovtseva
 */
public class UpstandingBubbleSort extends BubbleSort {
    @Override
    protected boolean conditionToSwap(ArrayList<Integer> arr, int j) {
        return arr.get(j-1)>arr.get(j);
    }
}
