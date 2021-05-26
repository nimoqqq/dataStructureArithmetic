package com.nimo.algorithm.sort20210520;

import java.util.Arrays;

/**
 * @title: BubbleSort
 * @Author Chuf
 * @Date: 2021/5/20 2:52 下午
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
        boolean falg = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //
                    falg = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(falg){
               return;
            }
            falg = true;
        }

    }
}
