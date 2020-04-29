package com.stu;

/**
 * Created by bingye on 2020/4/29
 */
public class MySort {


    /**
     * 冒泡排序
     * 复杂度 O(n) * O(n - i) 最差的是  O(n) * O(n) = O(n^2)  最好的其情况 O(n)
     *
     * @return
     */
    public static int[] bubbleSort(int[] array) {

        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }


    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {

        if (array.length == 0) {
            return array;
        }

        int current;

        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;

            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 3, 9, 6};

//        int[] ints = bubbleSort(array);
//        int[] ints = selectionSort(array);
        int[] ints = insertionSort(array);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
