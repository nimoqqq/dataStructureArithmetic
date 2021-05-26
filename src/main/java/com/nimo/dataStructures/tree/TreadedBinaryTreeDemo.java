package com.nimo.dataStructures.tree;

/**
 * @program: dataStructureArithmetic
 * @ClassName: TreadedBinaryTreeDemo
 * @description: 线索化二叉树
 * @author: chuf
 * @create: 2021-04-07 16:50
 **/
public class TreadedBinaryTreeDemo {
    public static void main(String[] args) {
        TreadedHeroNode root = new TreadedHeroNode(1, "tom");
        TreadedHeroNode node2 = new TreadedHeroNode(3, "jack");
        TreadedHeroNode node3 = new TreadedHeroNode(6, "smith");
        TreadedHeroNode node4 = new TreadedHeroNode(8, "mary");
        TreadedHeroNode node5 = new TreadedHeroNode(10, "king");
        TreadedHeroNode node6 = new TreadedHeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        TreadedBinaryTree treadedBinaryTree = new TreadedBinaryTree();
        treadedBinaryTree.setRoot(root);
        treadedBinaryTree.threadedPostNodes();
        TreadedHeroNode leftNode = node5.getLeft();
        TreadedHeroNode rightNode = node5.getRight();
        System.out.println("10 号结点的前驱结点是 =" + leftNode);
        System.out.println("10 号结点的后继结点是=" + rightNode);
    }
}

class TreadedBinaryTree {
    private TreadedHeroNode root;

    public void setRoot(TreadedHeroNode root) {
        this.root = root;
    }

    //定义前驱节点
    private TreadedHeroNode preNode;

    public void threadedMidNodes() {
        threadedMidNodes(root);
    }

    public void threadedPreNodes() {
        threadedPreNodes(root);
    }

    public void threadedPostNodes(){
        threadedPostNodes(root);
    }

    //对二叉树进行中序线索化的方法
    private void threadedMidNodes(TreadedHeroNode node) {
        if (node == null) {
            return;
        }
        //先线索化左子树
        threadedMidNodes(node.getLeft());
        //先线索化前驱节点
        if (node.getLeft() == null) {
            //指向前驱节点
            node.setLeft(preNode);
            //改变状态
            node.setLeftType(1);
        }
        //线索化后继节点
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(node);
            preNode.setRightType(1);
        }

        preNode = node;

        //线索化右子树
        threadedMidNodes(node.getRight());
    }

    //对二叉树进行前序线索化的方法
    private void threadedPreNodes(TreadedHeroNode node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            node.setLeft(preNode);
            node.setLeftType(1);
        }

        //右子树节点线索化
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(node);
            preNode.setRightType(1);
        }

        preNode = node;


        if(node.getLeftType() == 0){
            //左子树节点线索化
            threadedPreNodes(node.getLeft());
        }
        if(node.getRightType() == 0){
            //线索化右子树
            threadedPreNodes(node.getRight());
        }
    }

    private void threadedPostNodes(TreadedHeroNode node){
        if(node == null){
            return;
        }

        if(node.getLeftType() == 0){
            //左子树节点线索化
            threadedPostNodes(node.getLeft());
        }

        if(node.getRightType() == 0){
            //线索化右子树
            threadedPostNodes(node.getRight());
        }

        if(node.getLeft() == null){
            node.setLeft(preNode);
            node.setLeftType(1);
        }

        if(preNode != null && preNode.getRight() == null){
            preNode.setRight(node);
            preNode.setRightType(1);
        }

        preNode = node;
    }
}


class TreadedHeroNode {
    private int no;
    private String name;
    private TreadedHeroNode left;
    private TreadedHeroNode right;

    //定义线索化 左/右节点状态
    private int leftType;
    private int rightType;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreadedHeroNode getLeft() {
        return left;
    }

    public void setLeft(TreadedHeroNode left) {
        this.left = left;
    }

    public TreadedHeroNode getRight() {
        return right;
    }

    public void setRight(TreadedHeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public TreadedHeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreadedHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}