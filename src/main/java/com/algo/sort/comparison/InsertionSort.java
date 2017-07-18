package com.algo.sort.comparison;

/**
 * Created by tomar on 18/07/17.
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {6, 8, 1, 4, 5, 3, 7, 2};
        int sizeOfArray = array.length;

        Sort insertionSort = (a, size) -> {
            int i, j;
            int v;
            for (i = 2; i <= size - 1; i++) {
                v = a[i];
                j = i;

                while (j >= 1 && a[j - 1] > v) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = v;
            }

        };

        PrintArray printArray = (int[] a) -> {
            for (int element : a) {
                System.out.print(element + " , ");
            }
        };

        System.out.println("unsorted array");
        printArray.print(array);
        insertionSort.sort(array, sizeOfArray);
        System.out.println("\nunsorted array");
        printArray.print(array);

    }
}
