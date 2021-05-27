package com.nimo.algorithm.sort20210527;

import java.util.Arrays;

/**
 * @title: SelectSort
 * @Author Chuf
 * @Date: 2021/5/27 5:34 下午
 * @Version 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int arr[] = {3, 9, -1, 10, 20, 25, 2};
        selectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
