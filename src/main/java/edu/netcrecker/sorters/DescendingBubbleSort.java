package edu.netcrecker.sorters;

import java.util.ArrayList;

/**
 * @author Tsytovtseva
 */
public class DescendingBubbleSort extends BubbleSort{

    @Override
    protected boolean conditionToSwap(ArrayList<Integer> arr, int j) {
        return arr.get(j-1)<arr.get(j);
    }
}
