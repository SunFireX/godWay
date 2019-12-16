package com.dyt.swm.godway.test.redis_LRU;

import java.util.HashMap;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/17 13:59
 */
public class LruCache<K,V> {

    class CacheNode {
        public CacheNode before;
        public Object key;
        public Object value;
        public CacheNode after;

        public CacheNode() {
        }
    }

    private HashMap<K, CacheNode> caches;
    private int maxCapacity;
    private int currentCacheSize;
    /**
     * 头结点, 头结点不参与淘汰,只是作为标识链表中的第一个节点
     */
    private CacheNode head;
    /**
     * 尾节点, 尾节点不参与淘汰, 只是作为标识链表中最后一个节点
     */
    private CacheNode tail;

    public LruCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        caches = new HashMap<>(maxCapacity);
        head = tail = new CacheNode();
        //对head 的after节点赋值, 防止后续操作出现空指针异常
        head.after = tail;
        // 对tail的before节点赋值, 防止后续操作出现空指针异常
        tail.before = head;
    }

    public void put(K k, V v) {
        CacheNode node = caches.get(k);
        if (node == null) {
            if (currentCacheSize >= maxCapacity) {
                // 淘汰尾部的元素
                caches.remove(tail.before.key);
                removeLast();
            }

            node = new CacheNode();
            node.key = k;

            currentCacheSize ++;
        }

        node.value = v;
        // LRU策略, 新插入的元素放置到队列头部
        moveToFirst(node);
        caches.put(k, node);
    }

    public void moveToFirst(CacheNode node) {
        CacheNode n = head.after;
        head.after = node;
        node.before = head;
        n.before = node;
        node.after = n;
    }

    public void removeLast() {
        CacheNode n = tail.before.before;
        n.after = tail;
        tail.before = n;
    }

    public Object get(K k) {
        CacheNode node = caches.get(k);
        if (node == null) {
            return null;
        }

        Object v = node.value;
        moveToFirst(node);
        return v;
    }

    public Object remove(K k) {
        CacheNode node = caches.get(k);
        if (node == null) {
            return null;
        }

        CacheNode pre = node.before;
        CacheNode next = node.after;
        pre.after = next;
        next.before = pre;

        caches.remove(k);

        currentCacheSize --;
        return node.value;
    }

}
