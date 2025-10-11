package com.mediuminterviewques.singlylinkedlist;

import java.util.ArrayList;
import java.util.Collections;

class SortNode {
	int data;
	SortNode next;

	public SortNode(int val) {
		this.data = val;
		this.next = null;
	}
}

public class SortALinkedList {

	private static void printList(SortNode head) {
		if (head == null) {
			return;
		}
		SortNode temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	private static SortNode sortALL(SortNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		SortNode temp = head;
		while (temp != null) {
			list.add(temp.data);
			temp = temp.next;
		}
		Collections.sort(list);
		temp = head;
		int i = 0;
		while (temp != null) {
			temp.data = list.get(i++);
			temp = temp.next;
		}
		return head;

	}

	// Time Complexity : O(n) + O(N *LogN) + o(n)
	// Space Complexity : O(n)
	private static SortNode sortLinkedList(SortNode head) {
		// Base case
		if (head == null || head.next == null) {
			return head;
		}
		// Find the middle of the list
		// using the findMiddle function
		SortNode middle = findMiddle(head);
		// Divide the list into two halves
		SortNode left = head;
		SortNode right = middle.next;
		middle.next = null;
		// Recursively sort the left and right halves
		left = sortLinkedList(left);
		right = sortLinkedList(right);
		// Merge the sorted halves
		return mergeTwoSortedLinkedLists(left, right);

	}

	private static SortNode mergeTwoSortedLinkedLists(SortNode left, SortNode right) {
		SortNode temp1 = left;
		SortNode temp2 = right;
		SortNode dummyHead = new SortNode(-1);
		SortNode current = dummyHead;
		while (temp1 != null && temp2 != null) {

			if (temp1.data <= temp2.data) {
				current.next = temp1;
				current = temp1;// advance current to temp1
				temp1 = temp1.next;
			} else {
				current.next = temp2;
				current = temp2;// advance current to temp2
				temp2 = temp2.next;
			}
		}

		if (temp1 != null) {
			current.next = temp1;
		} else {
			current.next = temp2;
		}
		return dummyHead.next;
	}

	private static SortNode findMiddle(SortNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		SortNode slow = head;
		SortNode fast = head.next;
		// Move the fast pointer twice
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// When the fast pointer reaches the end,
		// the slow pointer will be at the middle
		return slow;
	}

	// Time complexity : O(n log n) and Space complexity : O(log n) due to recursion
	// stack.
	public static void main(String[] args) {
		SortNode head = new SortNode(-1);
		head.next = new SortNode(5);
		head.next.next = new SortNode(3);
		head.next.next.next = new SortNode(4);
		head.next.next.next.next = new SortNode(0);
		head.next.next.next.next.next = new SortNode(-2);
		printList(head);
		// head = sortALL(head);
		head = sortLinkedList(head);
		printList(head);

	}
}
