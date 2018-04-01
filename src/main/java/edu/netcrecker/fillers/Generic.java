package edu.netcrecker.fillers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Tsytovtseva
 */
public class Generic {
    @Fillers
    public static ArrayList<Integer> arrayLowtoHigh(int lenght){
        ArrayList<Integer> arr = arrayRandom(lenght);
        Collections.sort(arr);
        return arr;
    }
    @Fillers
    public static ArrayList<Integer> arrayRandom(int lenght){
        ArrayList<Integer> arr = new ArrayList<>();
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < lenght; i++){
            arr.add(rand.nextInt(20));
        }
        return arr;
    }
    @Fillers
    public static ArrayList<Integer> arrayLowtoHighPlusOne(int lenght){
        ArrayList<Integer> arr = arrayLowtoHigh(lenght-1);
        Random rand = new Random(System.currentTimeMillis());
        arr.add(rand.nextInt(20));
        return arr;
    }
    @Fillers
    public static ArrayList<Integer> arrayHighToLow(int lenght){
        ArrayList<Integer> arr = arrayLowtoHigh(lenght);
        Collections.reverse(arr);
        return arr;
    }
}
