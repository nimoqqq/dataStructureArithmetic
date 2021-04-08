package com.nimo.tree;

/**
 * @program: dataStructureArithmetic
 * @ClassName: ArrBinaryTreeDemo
 * @description: 顺序存储二叉树
 * @author: chuf
 * @create: 2021-04-07 10:31
 **/
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder();
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重构
    public void preOrder() {
        int index = 0;
        preOrder(index);
    }

    //重构
    public void midOrder() {
        int index = 0;
        midOrder(index);
    }

    //重构
    public void postOrder() {
        int index = 0;
        postOrder(index);
    }

    //前序遍历
    private void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        System.out.println(arr[index]);

        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //中序遍历
    private void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        if (2 * index + 1 < arr.length) {
            midOrder(2 * index + 1);
        }

        System.out.println(arr[index]);

        if (2 * index + 2 < arr.length) {
            midOrder(2 * index + 2);
        }
    }

    //后序
    private void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        if (2 * index + 1 < arr.length) {
            postOrder(2 * index + 1);
        }

        if (2 * index + 2 < arr.length) {
            postOrder(2 * index + 2);
        }

        System.out.println(arr[index]);
    }
}
