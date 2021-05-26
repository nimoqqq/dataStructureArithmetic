package com.nimo.algorithm.sort20210508;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20, 25, 2};
//        shellSort1(arr);
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 依次比较相邻元素的值，若发现逆序则交换，使较大的元素逐渐往后移
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        boolean change = false;
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length - i - 1; i1++) {
                if (arr[i1] > arr[i1 + 1]) {
                    int item = arr[i1];
                    arr[i1] = arr[i1 + 1];
                    arr[i1 + 1] = item;

                    change = true;
                }
            }
            if (!change) {
                return;
            }
            change = false;
        }
    }

    /**
     * 选择排序
     * 依次从集合中找出最小的值，进行排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int item = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = item;
        }
    }

    /**
     * 插入排序
     * 插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int insertIndex = 0;
        int insertVal = 0;
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1;
            insertVal = arr[i];
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    /**
     * 希尔排序-交换法
     * 插入排序法的一种，希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含 的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int item = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        item = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = item;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序-位移法
     * 交换法的一种改进，比较晚大小之后，继续循环比较，知道不满足条件之后，退出；
     * 然后交换数据
     *
     * @param arr
     */
    public static void shellSort1(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int item = arr[i];
                int j = i;
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && item < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = item;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            if(l<r){
                arr[l++] = arr[r];
            }

            while (l < r && arr[l] <= pivot) {
                l++;
            }

            if(l<r){
                arr[r--] = arr[l];
            }

            arr[l] = pivot;

            quickSort(arr,left,l-1);
            quickSort(arr,l+1,right);
        }
    }


}
