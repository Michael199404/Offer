package subject18;
/*
* 删除链表中的重复结点
*
* 思路：
* 1.头结点后可能有与头结点相同的结点，也就是说，头结点也可能有重复
* 2.所以，我们应该在头结点前再建立一个新的结点，使这个结点指向头结点
* 3.
* */
public class Solution2 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next ==null)
            return pHead;

        ListNode pre = null;//当前结点的前一个结点
        ListNode p = pHead;//当前结点

        while(p != null){
            boolean needDelete = false;
            //如果发现重复结点
            if(p.next != null && p.val == p.next.val)
                needDelete = true;

            if(!needDelete){//如果当前结点不重复
                pre = p;
                p = p.next;
            }else{//如果发现当前结点重复
                // 1.让p走到不重复的那个结点的位置上
                int val = p.val;
                ListNode toBeDel = p;
                while(toBeDel != null && toBeDel.val == val){
                    toBeDel = toBeDel.next;
                }

                //2. 下面的代码用来将pre和p连接起来，这样就删除掉了重复的结点
                //如果发现头结点重复，因为此时toBeDel走到了第一个不重复的位置，所以使头指针为toBeDel
                if(pre == null){
                    pHead = toBeDel;
                }else{//如果pre不为null说明不是头结点重复了，就让pre与toBeDel相连
                    pre.next = toBeDel;
                }

                p = toBeDel;
            }
        }
        return pHead;
    }
}
