package leetcodeDSA;

// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
public class AddTwoNumbersLL {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        long createIntFromReversedLL(ListNode list) {
            // take current node being looked at, multiply it by 10 to the power of i, and add it to sum
            // return sum
            ListNode current = list;
            int i = 0;
            long sum = 0;
            while (current != null) {
                sum += current.val * Math.pow(10, i);
                current = current.next;
                i++;
            }
            return sum;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long total = createIntFromReversedLL(l1) + createIntFromReversedLL(l2);
            ListNode totalLL = null;
            ListNode current = null;

            // return number in LL format by adding each place of number to a LL
            boolean flag = true;
            while (flag) {
                double lastPlace = total % 10;
                System.out.println((int) lastPlace);
                if (totalLL == null) {
                    totalLL = new ListNode((int) lastPlace);
                    current = totalLL;
                } else {
                    ListNode newNode = new ListNode((int) lastPlace);
                    current.next = newNode;
                    current = current.next;
                }
                if (total % 10 == total) {
                    flag = false;
                }
                total = total / 10;
            }
            return totalLL;
        }
    }
}
