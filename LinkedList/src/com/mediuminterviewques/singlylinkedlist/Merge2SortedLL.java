package com.mediuminterviewques.singlylinkedlist;

import java.util.ArrayList;

class SortedNode {
	int data;
	SortedNode next;

	SortedNode(int val) {
		this.data = val;
		this.next = null;
	}
}

public class Merge2SortedLL {

	private static void printLL(SortedNode head) {

		if (head == null) {
			return;
		}
		SortedNode temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	// Solution 1 : Brute approach
	// Time Complexity : O(N1 + N2) + O(N)
	// Space Complexity : O(N)+O(N)
	private static SortedNode merge2SortedLists(SortedNode head1, SortedNode head2) {

		if (head2 == null) {
			return head1;
		}
		if (head1 == null) {
			return head2;
		}

		SortedNode temp1 = head1;
		SortedNode temp2 = head2;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (temp1 != null && temp2 != null) {

			if (temp1.data <= temp2.data) {
				list.add(temp1.data);
				temp1 = temp1.next;
			} else {
				list.add(temp2.data);
				temp2 = temp2.next;
			}
		}

		while (temp1 != null) {
			list.add(temp1.data);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			list.add(temp2.data);
			temp2 = temp2.next;
		}

		// creating a new list with sorted values
		SortedNode newNode = new SortedNode(list.get(0));
		SortedNode mover = newNode;
		for (int i = 1; i < list.size(); i++) {
			SortedNode temp = new SortedNode(list.get(i));
			mover.next = temp;
			mover = temp; // mover = mover.next; (This can be written also)
		}
		return newNode;

	}

	// Solution 2 : Better approach
	private static SortedNode merge2SortedLinkedList(SortedNode head1, SortedNode head2) {

		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		SortedNode temp1 = head1;
		SortedNode temp2 = head2;
		SortedNode newNode = new SortedNode(-100);
		SortedNode dummy = newNode;
		// iterate through both linked lists
		while (temp1 != null && temp2 != null) {
			// add the smaller node to the merged list
			if (temp1.data <= temp2.data) {
				dummy.next = temp1;
				temp1 = temp1.next;
			} else {
				dummy.next = temp2;
				temp2 = temp2.next;
			}

			dummy = dummy.next;
		}
		// if any list is left, append it to
		// the merged list
		if (temp1 != null) {
			dummy.next = temp1;
		} else {
			dummy.next = temp2;
		}
		// return the merged list starting from
		// the next of newNode node
		return newNode.next;
	}

	// Time Complexity : O(N1 + N2)
	// Space Complexity : O(N)

	// Solution 3 : Optimal approach
	private static SortedNode mergeTwoSortedLists(SortedNode head1, SortedNode head2) {

		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		SortedNode temp1 = head1;
		SortedNode temp2 = head2;
		SortedNode dummyHead = new SortedNode(-1);
		SortedNode current = dummyHead;
		while (temp1 != null && temp2 != null) {
			if (temp1.data <= temp2.data) {
				current.next = temp1;
				current = temp1;
				temp1 = temp1.next;

			} else {
				current.next = temp2;
				current = temp2;
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

	// Time Complexity : O(N1 + N2)
	// Space Complexity : O(N)
	public static void main(String[] args) {

		SortedNode head1 = new SortedNode(1);
		head1.next = new SortedNode(3);
		head1.next.next = new SortedNode(4);
		head1.next.next.next = new SortedNode(5);
		head1.next.next.next.next = new SortedNode(8);
		printLL(head1);
		SortedNode head2 = new SortedNode(2);
		head2.next = new SortedNode(6);
		head2.next.next = new SortedNode(7);
		head2.next.next.next = new SortedNode(9);
		head2.next.next.next.next = new SortedNode(11);
		printLL(head2);
		// SortedNode result = merge2SortedLists(head1, head2);
		// printLL(result);
		// SortedNode mergedLists = merge2SortedLinkedList(head1, head2);
		// printLL(mergedLists);
		SortedNode res = mergeTwoSortedLists(head1, head2);
		printLL(res);
	}
}
