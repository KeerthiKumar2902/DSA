/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: Empty input array
        if (lists == null || lists.length == 0) return null;

        // Create a Min-Heap of ListNodes. 
        // We tell it to compare the nodes based on their integer 'val'.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Step 1: Add the first node of every list into the Min-Heap
        for (ListNode head : lists) {
            // Check for null because a list in the array might be empty!
            if (head != null) { 
                minHeap.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Step 2 & 3: Pop the smallest and push its next node
        while (!minHeap.isEmpty()) {
            // Get the smallest node available across all lists
            ListNode smallestNode = minHeap.poll();
            
            // Re-wire our result list to point to this existing node
            current.next = smallestNode;
            current = current.next; // Move our pointer forward

            // If the node we just popped has a next node, put it into the heap!
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }

        return dummy.next;
    }
}