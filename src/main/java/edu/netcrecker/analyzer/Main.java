package edu.netcrecker.analyzer;


import edu.netcrecker.fillers.Generic;
import edu.netcrecker.sorters.DescendingBubbleSort;
import edu.netcrecker.sorters.UpstandingBubbleSort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> arr = Generic.arrayRandom(20);
        System.out.println(arr);
        UpstandingBubbleSort sorterH = new UpstandingBubbleSort();
        DescendingBubbleSort sorterL = new DescendingBubbleSort();
        System.out.println(sorterH.sort(arr));
        System.out.println(sorterL.sort(arr));
        System.out.println(arr);
    }
}
