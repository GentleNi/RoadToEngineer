package com.gentleni.jianzhioffer;

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
}
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}