package easy;

public class MergeLinkedList {

    public static void main(String[] args) {
        ListNode l1_1= new ListNode(1);
        ListNode l1_2= new ListNode(2);
        ListNode l1_3= new ListNode(4);
        l1_1.next=l1_2;
        l1_2.next=l1_3;

        ListNode l2_1= new ListNode(1);
        ListNode l2_2= new ListNode(3);
        ListNode l2_3= new ListNode(4);
        l2_1.next=l2_2;
        l2_2.next=l2_3;

        mergeTwoLists(l1_1,l2_1);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode();
        ListNode head =ans;
        ans.val=999;

        //處理list為空的狀況
        if(l1==null||l2==null){
            if(l1!=null){
                ans=l1;
                return ans;
            }else if (l2 !=null){
                ans = l2;
                return ans;
            }else{ ans = null;}
        };

        while (true){
            if(l1==null){
                ans.next=l2;
                break;
            }
            if(l2==null){
                ans.next=l1;
                break;
            }

            if(l1.val<=l2.val){
                ans.next = l1;
                ans=ans.next;
                l1=l1.next;
            }else{
                ans.next = l2;
                ans=ans.next;
                l2=l2.next;
            }

        }
        if(ans.val!=99){
            head=head.next;
        }

//        while (head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }


        return head;

          //簡化的版本
//        ListNode prehead = new ListNode();
//        ListNode prev = prehead;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else {
//                prev.next = l2;
//                l2 = l2.next;
//            }
//            prev = prev.next;
//        }
//        prev.next = l1 == null ? l2 : l1;
//        return prehead.next;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;
    }
}

