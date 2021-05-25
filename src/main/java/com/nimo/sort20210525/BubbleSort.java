package com.nimo.sort20210525;

import java.util.Arrays;

/**
 * 冒泡
 * @title: BubbleSort
 * @Author Chuf
 * @Date: 2021/5/25 7:06 下午
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int arr[] = {3, 9, -1, 10, 20, 25, 2};
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
