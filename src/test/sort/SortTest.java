package test.sort;

import sort.*;

import java.util.Arrays;

/**
 * @author HuanJu
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2,123,551,6526,14};
//        BubbleSort.sort(arr);
//        SelectSort.sort(arr);
//        InsertSort.sort(arr);
//        ShellSort.sort(arr);
//        MergeSort.sort(arr);
//        QuickSort.sort(arr);
        HeadSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
