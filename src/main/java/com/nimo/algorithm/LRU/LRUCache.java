package com.nimo.algorithm.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: LRUCache
 * @Author Chuf
 * @Date: 2021/5/26 7:45 下午
 * @Version 1.0
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 */
public class LRUCache {

    class DlinkedNode {
        int key;
        int value;
        public DlinkedNode prev;
        public DlinkedNode next;

        public DlinkedNode() {
        }

        public DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size;
    public int capacity;
    public DlinkedNode head, tail;
    public Map<Integer, DlinkedNode> cache = new HashMap<Integer, DlinkedNode>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    //获取节点 value
    public int get(int key) {
        DlinkedNode dlinkedNode = cache.get(key);
        if (dlinkedNode == null) {
            return -1;
        }
        moveToHead(dlinkedNode);
        return dlinkedNode.value;
    }

    //添加节点
    public void put(int key, int value) {
        DlinkedNode dlinkedNode = cache.get(key);
        if (dlinkedNode == null) {
            DlinkedNode node = new DlinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DlinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }else {
            dlinkedNode.value = value;
            addToHead(dlinkedNode);
        }
    }

    //将node节点更新到头部
    public void moveToHead(DlinkedNode dlinkedNode) {
        removeNode(dlinkedNode);
        addToHead(dlinkedNode);
    }

    //删除节点
    public void removeNode(DlinkedNode dlinkedNode) {
        dlinkedNode.prev.next = dlinkedNode.next;
        dlinkedNode.next.prev = dlinkedNode.prev;
    }

    //移动节点到链表头部
    public void addToHead(DlinkedNode dlinkedNode) {
        dlinkedNode.prev = head;
        dlinkedNode.next = head.next;
        head.next.prev = dlinkedNode;
        head.next = dlinkedNode;
    }

    //删除头节点
    private DlinkedNode removeTail() {
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3);
        lRUCache.get(2);
        System.out.println(lRUCache);
    }
}
