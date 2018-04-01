package edu.netcrecker.sorters;

import java.util.ArrayList;

public class ExchangeSort extends Sort {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        ArrayList<Integer> arr = (ArrayList<Integer>)array.clone();
        int  key;
        for (int i = 1; i < arr.size(); i++)
        {
            key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key)
            {
                arr.set((j+1), arr.get(j));
                j = j-1;
            }
            arr.set((j+1), key);
        }
        return arr;
    }
}
