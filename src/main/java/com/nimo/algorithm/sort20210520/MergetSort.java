package com.nimo.algorithm.sort20210520;

import java.util.Arrays;

/**
 * @title: MergetSort
 * @Author Chuf
 * @Date: 2021/5/24 7:45 下午
 * @Version 1.0
 */
public class MergetSort {
    public static void main(String[] args) {
        MergetSort mergetSort = new MergetSort();
        int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
        mergetSort.mergetSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergetSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergetSort(arr, left, mid);
        mergetSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        //创建一个空数组
        int[] tmp = new int[right - left + 1];

        //进行排序
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j++];
            } else {
                tmp[k++] = arr[i++];
            }
        }

        //判断哪个子集数组中有剩余的数据
        int start = i;
        int end = mid;
        if (j <= right) {
            start = j;
            end = right;
        }

        //将剩余的数据放到临时数组tmp
        while (start <= end) {
            tmp[k++] = arr[start++];
        }

        //将tmp中的数组拷贝到arr
        for (i = 0; i <= right - left; i++) {
            arr[left+i] = tmp[i];
        }
    }
}
