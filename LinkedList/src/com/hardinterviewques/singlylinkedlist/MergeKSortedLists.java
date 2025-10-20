package com.hardinterviewques.singlylinkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	// Constructor with both data and next node as parameters
	ListNode(int data, ListNode next1) {
		this.val = data;
		this.next = next1;
	}

	// Constructor with only data as a parameter, sets next to null
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}

}

public class MergeKSortedLists {

	private static void printLinkedList(ListNode listNode) {
		if (listNode == null) {
			return;
		}

		ListNode temp = listNode;
		while (temp != null) {
			// Print the data of the current node
			System.out.print(temp.val);
			if (temp.next != null) {
				System.out.print("->");
			}
			// Move to the next node
			temp = temp.next;
		}
		System.out.println();

	}
	// Solution 1 : Brute approach

	private static ListNode mergeKLists(ArrayList<ListNode> lists) {

		if (lists == null || lists.isEmpty()) {
			return null;
		}
		List<Integer> values = new ArrayList<>();
		for (ListNode node : lists) {
			while (node != null) {
				values.add(node.val);
				node = node.next;
			}
		}
		// Sort the ArrayList containing node values in ascending order
		Collections.sort(values);
		// Convert the sorted ArrayList back to a linked list and return its head
		return convertArrToLinkedList(values);
	}

	private static ListNode convertArrToLinkedList(List<Integer> values) {

		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;
		for (int val : values) {
			current.next = new ListNode(val);
			current = current.next;
		}

		return dummy.next;
	}
	// Time Complexity: O(K*N) + O((N*K) * log(N*K)) + O(N*K) where K is the number
	// of linked lists and N is the length of each linked list.
	// Space Complexity: O(N*K) + O(N*K) where K is the number of linked lists and N
	// is the length of each linked list.

	// Solution 2 : Better approach

	private static ListNode mergeKLL(List<ListNode> lists) {
		if (lists == null || lists.isEmpty()) {
			return null;
		}
		ListNode head = lists.get(0);

		for (int i = 1; i < lists.size(); i++) {
			// Merge the current 'head' linked
			// list with the next linked list
			head = mergeTwoSortedLinkedLists(head, lists.get(i));
		}
		return head;
	}

	private static ListNode mergeTwoSortedLinkedLists(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode dummyNode = new ListNode(-1);
		ListNode current = dummyNode;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				current = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				current = l2;
				l2 = l2.next;
			}
		}
		current.next = (l1 != null) ? l1 : l2;
		return dummyNode.next;
	}
	// Time = N + 2N + 3N + 4N + 5N + .... + kN
	// T = N (1 + 2 + 3 + 4 + ... + k)
	// Time complexity is O( N*k(k+1)/2) ~ O(N*k^2)
	// Space Complexity: O(1)

	// Solution 3: Optimal approach

	private static ListNode mergeKLinkedLists(List<ListNode> lists) {
		if (lists == null || lists.isEmpty()) {
			return null;
		}
		// Min-heap based on node values
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
		// Add the head of each non-null list to the heap
		for (ListNode node : lists) {
			if (node != null) {
				// minHeap.add(node);
				minHeap.offer(node);
			}
		}
		ListNode dummyNode = new ListNode(-1);
		ListNode current = dummyNode;

		while (!minHeap.isEmpty()) {
			ListNode smallest = minHeap.poll(); // minHeap.remove() // minHeap.peek()
			current.next = smallest;
			current = current.next;

			if (smallest.next != null) {
				minHeap.offer(smallest.next);
			}
		}

		// Return the merged linked list
		return dummyNode.next;
	}

	// Time Complexity : O(N log k), where N is the total number of nodes and k is
	// the number of
	// lists.
	// Space Complexity: O(k) for the heap.
	
	public static void main(String[] args) {

		// Create linked lists
		ListNode head1 = new ListNode(2, new ListNode(4, new ListNode(6)));
		ListNode head2 = new ListNode(1, new ListNode(5));
		ListNode head3 = new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(7))));
		ListNode head4 = new ListNode(8);
		// Populate the lists ArrayList
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head1);
		lists.add(head2);
		lists.add(head3);
		lists.add(head4);

		System.out.println("Original Linked Lists:");
		for (int i = 0; i < lists.size(); ++i) {
			System.out.print("List " + (i + 1) + ": ");
			printLinkedList(lists.get(i));
		}

		// Merge the linked lists
		// ListNode mergedList = mergeKLists(lists);

		// ListNode mergedList = mergeKLL(lists);

		ListNode mergedList = mergeKLinkedLists(lists);

		// Print the merged linked list
		System.out.print("Merged Linked List: ");
		printLinkedList(mergedList);
	}
}
