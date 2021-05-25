package com.nimo.sort20210525;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @title: InsertSort
 * @Author Chuf
 * @Date: 2021/5/25 7:13 下午
 * @Version 1.0
 */
public class InsertSort {

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int arr[] = {3, 9, -1, 30, 10, 20, 25, 2};
        insertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }
}
