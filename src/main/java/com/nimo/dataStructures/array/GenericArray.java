package com.nimo.dataStructures.array;

/**
 * @title: GenericArray
 * @Author Chuf
 * @Date: 2021/5/19 5:23 下午
 * @Version 1.0
 */
public class GenericArray<T> {
    private T[] data;

    private int size;


    // 根据传入容量，构造Array
    public GenericArray(int capacity) {
        T[] data = (T[]) new Object[capacity];
        size = 0;
    }


    //无参构造
    public GenericArray() {
        T[] data = (T[]) new Object[10];
        size = 0;
    }

    //获取数组容量
    public int getCapacity() {
        int length = data.length;
        return length;
    }

    //获取当前元素个数
    public int getSize() {
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //修改 index 位置的元素
    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    //获取对应 index 位置的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    //查看数组是否包含元素e
    public boolean contain(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //获取对应元素的下标，未找到返回 -1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素 e
    public void add(int index, T e) {
        checkIndexForAdd(index);
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    //向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }


    //删除 index 位置的元素，并返回
    public T remove(int index) {
        checkIndex(index);
        T datum = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        //缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return datum;
    }

    //删除第一个元素
    public T removeFirst(int index) {
        return remove(index);
    }

    //删除末尾元素
    public T removeLast(int index) {
        return remove(index);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }
}
