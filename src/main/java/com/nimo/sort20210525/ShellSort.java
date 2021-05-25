package com.nimo.sort20210525;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @title: ShellSort
 * @Author Chuf
 * @Date: 2021/5/25 7:58 下午
 * @Version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int arr[] = {3, 9, -1, 10, 20, 25, 2, 342, 54, 6};
        shellSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void shellSort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j + gap] < arr[j]) {
                        int temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
