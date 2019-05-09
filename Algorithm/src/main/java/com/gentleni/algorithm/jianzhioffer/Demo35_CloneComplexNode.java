package com.gentleni.algorithm.jianzhioffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by GentleNi
 * Date 2019/2/18.
 */
public class Demo35_CloneComplexNode {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        //每个节点后插入clone的节点
        RandomListNode curr = pHead;
        while (curr != null) {
            RandomListNode cloneNode = new RandomListNode(curr.label);
            cloneNode.next = curr.next;
            curr.next = cloneNode;
            curr = cloneNode.next;
        }

        //插入随机Node
        curr = pHead;
        while (curr != null) {
            RandomListNode clone = curr.next;
            if (curr.random != null) {
                clone.random = curr.random.next;
            }
            curr = clone.next;
        }

        //拆分
        curr = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (curr.next != null) {
            RandomListNode next = curr.next;
            curr.next = next.next;
            curr = next;
        }
        return pCloneHead;
    }



    //使用hashmap
    public RandomListNode Clone2(RandomListNode pHead)
    {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode p = pHead;
        RandomListNode q = new RandomListNode(-1);
        while(p!=null){
            RandomListNode t = new RandomListNode(p.label);
            map.put(p, t);
            p = p.next;
            q.next = t;
            q = t;
        }
        Set<Map.Entry<RandomListNode,RandomListNode>> set = map.entrySet();
        Iterator<Map.Entry<RandomListNode,RandomListNode>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<RandomListNode, RandomListNode> next = it.next();
            //next.getKey().random->原链表的random 根据这个key取出的value就是新链表的random
            next.getValue().random = map.get(next.getKey().random);
        }
        return map.get(pHead);
    }
}

 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}