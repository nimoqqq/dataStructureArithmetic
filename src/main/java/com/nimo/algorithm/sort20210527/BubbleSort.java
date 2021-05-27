package com.nimo.algorithm.sort20210527;

import java.util.Arrays;

/**
 * @title: BubbleSort
 * @Author Chuf
 * @Date: 2021/5/27 5:07 下午
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20, 25, 2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.buddleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void buddleSort(int[] arr) {
        boolean falg = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    falg = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!falg) {
                return;
            }
            falg = false;
        }
    }
}
