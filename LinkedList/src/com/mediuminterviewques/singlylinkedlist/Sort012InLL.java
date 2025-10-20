package com.mediuminterviewques.singlylinkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node012 {
	int val;
	Node012 next;

	Node012(int val) {
		this.val = val;
		this.next = null;
	}
}

public class Sort012InLL {
	private static void printList(Node012 head) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node012 temp = head;
		while (temp != null) {
			System.out.print(temp.val);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	// Solution 1 : Using an Extra Array
	private static Node012 segregate(Node012 head) {

		if (head == null || head.next == null) {
			return head;
		}
		Node012 temp = head;
		List<Integer> list = new ArrayList<Integer>();
		while (temp != null) {
			list.add(temp.val);
			temp = temp.next;
		}
		Collections.sort(list);
		Node012 dummy = new Node012(-1);
		Node012 current = dummy;
		for (int i = 0; i < list.size(); i++) {
			Node012 t = new Node012(list.get(i));
			current.next = t;
			current = t;
		}
		return dummy.next;
	}

	// Time Complexity : O(N) + O(NLogN) + O(N)
	// Space Complexity : O(n)

	// Solution 2 : Using Count of 0s, 1s and 2s
	private static Node012 segregateLL(Node012 head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node012 temp = head;
		int cntZero = 0;
		int cntOne = 0;
		int cntTwo = 0;
		while (temp != null) {
			if (temp.val == 0) {
				cntZero++;
			} else if (temp.val == 1) {
				cntOne++;
			} else {
				cntTwo++;
			}
			temp = temp.next;
		}
		temp = head;
		while (cntZero-- > 0) {
			temp.val = 0;
			temp = temp.next;
		}
		// Then add all the 1s
		while (cntOne-- > 0) {
			temp.val = 1;
			temp = temp.next;
		}

		// Finally add all the 2s
		while (cntTwo-- > 0) {
			temp.val = 2;
			temp = temp.next;
		}

		return head;
	}
	// Time Complexity : O(2N)
	// Space Complexity : O(1)

	// Solution 3 : Using Dutch National Flag Algorithm
	private static Node012 segregateList(Node012 head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node012 zeroHead = new Node012(-1);
		Node012 oneHead = new Node012(-1);
		Node012 twoHead = new Node012(-1);
		Node012 zero = zeroHead;
		Node012 one = oneHead;
		Node012 two = twoHead;
		Node012 temp = head;
		while (temp != null) {
			if (temp.val == 0) {
				zero.next = temp;
				zero = temp;
			} else if (temp.val == 1) {
				one.next = temp;
				one = temp;
			} else {
				two.next = temp;
				two = temp;
			}
			temp = temp.next;
		}
		zero.next = (oneHead.next) != null ? (oneHead.next) : (twoHead.next);
		one.next = (twoHead.next);
		two.next = null;
		return zeroHead.next;
	}

	// Time Complexity : O(N)
	// Space Complexity : O(1)
	public static void main(String[] args) {
		Node012 head = new Node012(1);
		head.next = new Node012(2);
		head.next.next = new Node012(0);
		head.next.next.next = new Node012(2);
		head.next.next.next.next = new Node012(0);
		head.next.next.next.next.next = new Node012(1);
		head.next.next.next.next.next.next = new Node012(2);
		head.next.next.next.next.next.next.next = new Node012(1);
		printList(head);
		// head = segregate(head);
		// head = segregateLL(head);
		head = segregateList(head);
		printList(head);

	}
}
