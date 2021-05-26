package com.nimo.dataStructures.tree;

/**
 * @program: dataStructureArithmetic
 * @ClassName: BinaryTreeDemo
 * @description: 二叉树
 * @author: chuf
 * @create: 2021-04-03 11:34
 **/
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree();
        //创建需要的节点
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        root.postOrder();
//        root.delHeroNode(3);
//        root.preOrder();
    }
}

//定义二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前根节点为空");
        }
    }

    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("当前根节点为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
            ;
        } else {
            System.out.println("当前根节点为空");
        }
    }

    public void delHeroNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
                return;
            } else {
                root.delHeroNode(no);
            }
        } else {
            System.out.println("当前根节点为空");
        }
    }
}


//定义二叉树节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);

        //递归左子树
        if (this.left != null) {
            this.left.preOrder();
        }

        //递归右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.midOrder();
        }

        System.out.println(this);

        //递归右子树
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.postOrder();
        }

        //递归右子树
        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    //删除节点
    public void delHeroNode(int no) {
        //删除左子树节点
        if (this.left != null && this.left.getNo() == no) {
            if(this.left.getLeft() != null){
                this.left = this.left.getLeft();
            }else if(this.left.getLeft() == null && this.left.getRight() != null){
                this.left = this.left.getRight();
            }else {
                this.left = null;
            }
            return;
        }
        //删除右子树节点
        if (this.right != null && this.right.getNo() == no) {
            if(this.right.getLeft() != null){
                this.right = this.right.getLeft();
            }else if(this.right.getLeft() == null && this.right.getRight() != null){
                this.right = this.right.getRight();
            }else {
                this.right = null;
            }
            return;
        }
        //向左递归遍历
        if (this.left != null) {
            this.left.delHeroNode(no);
        }

        //向右递归遍历
        if (this.right != null) {
            this.right.delHeroNode(no);
        }
    }
}
