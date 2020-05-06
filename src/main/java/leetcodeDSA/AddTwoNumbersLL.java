package leetcodeDSA;

// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
public class AddTwoNumbersLL {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class SolutionSmallNumbers {
        long createNumFromReversedLL(ListNode list) {
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
            long total = createNumFromReversedLL(l1) + createNumFromReversedLL(l2);
            ListNode totalLL = null;
            ListNode current = null;

            // return number in LL format by adding each place of number to a LL
            boolean flag = true;
            while (flag) {
                double lastPlace = total % 10;
                if (totalLL == null) {
                    totalLL = new ListNode((int) lastPlace);
                    current = totalLL;
                } else {
                    current.next = new ListNode((int) lastPlace);
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

    static class LCSolution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            // while either value isn't null
            while (p != null || q != null) {
                // if a value isn't null, set its value to variable, else set variable to 0
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;

                // add to sum list and traverse
                curr.next = new ListNode(sum % 10);
                curr = curr.next;

                // if a value isn't null, traverse to next
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            // edge case: carry carries over if last digits create one
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }
}
