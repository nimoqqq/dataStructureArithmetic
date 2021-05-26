package com.nimo.dataStructures.array;

/**
 * 1）数组的插入、删除、按照下标随机访问操作
 *
 * @title: Array
 * @Author Chuf
 * @Date: 2021/5/19 4:38 下午
 * @Version 1.0
 */
public class Array {

    //定义整型数据data
    private int data[];
    //数组长度
    private int n;
    //实际个数
    private int count;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    //根据索引，查找数组中的元素并返回
    public int find(int index) {
        if (index > count || index < 0) return -1;
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (index > n || index < 0) {
            System.out.println("位置不合法");
            return false;
        }

        if (n == count) {
            System.out.println("没有可插入的位置");
            return false;
        }

        //位置合法
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index > count) return false;

        for (int i = index; i < count; i++) {
            data[i-1] = data[i];
        }
        count--;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
//        array.insert(3, 11);
        array.printAll();
    }
}
