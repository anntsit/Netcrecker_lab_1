package edu.netcrecker.sorters;

import edu.netcrecker.fillers.Generic;
import org.junit.*;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class SortingTest {
    private ArrayList<Integer> originalArray, expectedArray, actualArray, arrayToOperate;

    @Before
    public void init() {
        int capacity = 50;
        originalArray = Generic.arrayRandom(capacity);
        expectedArray = new ArrayList<>(capacity);
        arrayToOperate = new ArrayList<>(capacity);
    }

    public void fillArrays() {
        Collections.copy(originalArray, expectedArray);
        Collections.copy(originalArray, arrayToOperate);
    }


    @Test
    public void arraySortTest() {
        ArraySort arrSort = new ArraySort();
        fillArrays();
        Collections.sort(expectedArray);
        actualArray = arrSort.sort(arrayToOperate);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void exchangeSortSort() {
        ExchangeSort exSort = new ExchangeSort();
        fillArrays();
        Collections.sort(expectedArray);
        actualArray = exSort.sort(arrayToOperate);

        assertEquals(expectedArray, actualArray);
    }
    @Test
    public void minimumSortSort() {
        MinimumSort minSort = new MinimumSort();
        fillArrays();
        Collections.sort(expectedArray);
        actualArray = minSort.sort(arrayToOperate);

        assertEquals(expectedArray, actualArray);
    }
    @Test
    public void quickSortSort() {
        QuickSort qSort = new QuickSort();
        fillArrays();
        Collections.sort(expectedArray);
        actualArray = qSort.sort(arrayToOperate);

        assertEquals(expectedArray, actualArray);
    }
    @Test
    public void upstandingBubbleSortSort() {
        UpstandingBubbleSort upSort = new UpstandingBubbleSort();
        fillArrays();
        Collections.sort(expectedArray);
        actualArray = upSort.sort(arrayToOperate);

        assertEquals(expectedArray, actualArray);
    }
    @Test
    public void descendingBubbleSort() {
        DescendingBubbleSort destSort = new DescendingBubbleSort();
        fillArrays();
        Collections.sort(expectedArray);
        actualArray = destSort.sort(arrayToOperate);

        assertEquals(expectedArray, actualArray);
    }
}