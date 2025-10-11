package com.mediuminterviewques.singlylinkedlist;

import java.util.ArrayList;

class OENode {
	int data;
	OENode next;

	public OENode(int val) {
		this.data = val;
		this.next = null;
	}
}

public class OddEvenInLinkedList {

	static OENode head = null;
	static int size = 0;

	private static OENode insertNode(int val) {
		OENode temp = new OENode(val);
		if (head == null) {
			head = temp;
			size++;
			return head;
		}
		OENode mover = head;
		while (mover.next != null) {
			mover = mover.next;
		}
		mover.next = temp;
		size++;
		return head;
	}

	private static void printLL(OENode head) {
		if (head == null) {
			return;
		}
		OENode temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	// Solution 1 : Brute Approach
	private static OENode segregateOddEven(OENode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();

		// Collect odd-indexed data
		OENode temp = head;
		while (temp != null && temp.next != null) {
			list.add(temp.data);
			temp = temp.next.next;
		}
		if (temp != null) {
			list.add(temp.data);
		}
		// Collect even-indexed data
		temp = head.next;
		while (temp != null && temp.next != null) {
			list.add(temp.data);
			temp = temp.next.next;
		}

		if (temp != null) {
			list.add(temp.data);
		}

		temp = head;
		int i = 0;
		while (temp != null) {
			temp.data = list.get(i++);
			temp = temp.next;
		}
		return head;
	}
	// Time Complexity : O(n)
	// Space Complexity : O(n)

	// Solution 2 : Optimal Approach
	private static OENode segregateOddEvenLL(OENode head) {
		if (head == null || head.next == null) {
			return head;
		}
		OENode odd = head;
		OENode even = head.next;
		OENode evenHead = head.next;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			odd = odd.next;

			even.next = even.next.next;
			even = even.next;
		}
		odd.next = evenHead; // Append even list after odd list
		return head;

	}

	// Time Complexity : O(n)
	// Space Complexity : O(1)
	public static void main(String[] args) {

		OENode head = insertNode(1);
		head = insertNode(2);
		head = insertNode(3);
		head = insertNode(4);
		head = insertNode(5);
		printLL(head);
		// segregateOddEven(head);
		// printLL(head);
		OENode result = segregateOddEvenLL(head);
		printLL(result);

	}
}
