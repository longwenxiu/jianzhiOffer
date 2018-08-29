//01快慢指针法
//在相遇时，让一个指针在相遇点出发，另一个指针在链表首部出发，然后两个指针一次走一步，当它们相遇时，就是环的入口处。
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null || p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            while(p1 == p2){
                p2 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if(p1 == p2)
                    return p1;
            }
        }
        return null;
    }
}
//02断链法(修改了链表)
public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null|| pHead.next==null) return null;
        ListNode fast=pHead.next;
        ListNode slow=pHead;
        while(fast!=null){
            slow.next=null;
            slow=fast;
            fast=fast.next;
        }
        return slow;
    }
