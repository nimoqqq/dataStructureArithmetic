package com.nimo.sort20210525;

import com.nimo.sort20210520.MergetSort;

import java.util.Arrays;

/**
 * 合并排序
 *
 * @title: MergeSort
 * @Author Chuf
 * @Date: 2021/5/25 8:06 下午
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergetSort = new MergeSort();
        int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
        mergetSort.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr,int left,int right){
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;//定位临时数组索引

        //定义临时数组
        int[] tmp = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j++];
            } else {
                tmp[k++] = arr[i++];
            }
        }

        //判断哪个子集合有剩余
        int start = i;
        int end = mid;
        if (j <= right) {
            start = j;
            end = right;
        }

        //将子集合中剩余的数据放到tmp
        while (start <= end) {
            tmp[k++] = arr[start++];
        }

        //将tmp 拷贝到 arr
        for (i = 0; i <= right-left; i++) {
            arr[left+i] = tmp[i];
        }
    }
}
