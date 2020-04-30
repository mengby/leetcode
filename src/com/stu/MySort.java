package com.stu;

import java.util.Arrays;

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


//    public static int[] shellSort(int[] array) {
//        int len = array.length;
//        int temp , gap = len/2;
//
//        while (gap > 0) {
//            for (int i = 0; i < len; i++) {
//                temp = array[i];
//                int  preIndex = i - gap;
//                while (preIndex >= 0 && array[preIndex] > temp) {
//                    array[preIndex + gap] = array[preIndex];
//                    preIndex -= gap;
//                }
//                array[preIndex + gap] = temp;
//            }
//
//            gap /= 2;
//        }
//
//        return array;
//    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 3, 9, 6};

//        int[] ints = bubbleSort(array);
//        int[] ints = selectionSort(array);
//        int[] ints = insertionSort(array);
//        int[] ints = mergeSort(array);¬

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                int temp = array[j];
                if (array[j] < array[j - 1]) {
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
