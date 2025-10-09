package com.mediuminterviewques.singlylinkedlist;

import java.util.HashSet;

class ListNode {

	int data;
	ListNode next;

	public ListNode(int val) {
		this.data = val;
		this.next = null;
	}
}

public class IntersectionOf2LinkedLists {

	ListNode head = null;

	private ListNode insertNodeAtTail(int val) {
		ListNode newNode = new ListNode(val);
		if (head == null) {
			head = newNode;
			return head;
		}

		ListNode temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = newNode;
		return head;
	}

	private void print(ListNode head) {

		ListNode temp = head;

		while (temp != null) {

			System.out.print(temp.data);
			if (temp.next != null) {

				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	// Solution 1: Brute-Force or naive approach
	private ListNode intersectionPresent(ListNode head1, ListNode head2) {

		while (head2 != null) {
			ListNode temp = head1;
			while (temp != null) {
				// if both nodes are same
				if (temp == head2)
					return head2;
				temp = temp.next;
			}
			head2 = head2.next;
		}
		// intersection is not present between the lists return null
		return null;
	}

	// Time complexity of this approach is O(n*n)
	// Space complexity is O(1)

	// Solution 2: Hashing

	private ListNode intersectionPoint(ListNode head1, ListNode head2) {
		HashSet<ListNode> hashSet = new HashSet<ListNode>();
		while (head1 != null) {
			hashSet.add(head1);
			head1 = head1.next;
		}
		while (head2 != null) {
			if (hashSet.contains(head2)) {
				return head2;
			}
			head2 = head2.next;
		}
		return null;
	}
	// Time Complexity: O(n+m),Iterating through list 1 first takes O(n), then
	// iterating through list 2 takes O(m).
	// Space Complexity: O(n), Storing list 1 node address in HashSet.

	// Solution 3: Difference in length
	// Find the lengths of both LinkedLists
	// Increment the bigger LinkedList by (length1 - length2) steps that is head1 =
	// head1.next, if length1 is bigger. And we can do same for head2=head2.next, if
	// length2 is bigger.

	public ListNode intersectionPointOfLL(ListNode head1, ListNode head2) {
		int length1 = 0;
		int length2 = 0;

		ListNode temp1 = head1;
		ListNode temp2 = head2;
		while (temp1 != null || temp2 != null) {
			if (temp1 != null) {
				length1 += 1;
				temp1 = temp1.next;
			}
			if (temp2 != null) {
				length2 += 1;
				temp2 = temp2.next;
			}
		}
		temp1 = head1;
		temp2 = head2;

		int diff = Math.abs(length1 - length2);
		if (length1 > length2) {
			for (int i = 0; i < diff; i++) {
				temp1 = temp1.next;
			}
		} else {
			for (int i = 0; i < diff; i++) {
				temp2 = temp2.next;
			}
		}

		// Traverse both lists together to find the intersection
		while (temp1 != null && temp2 != null) {
			if (temp1 == temp2) {
				return temp1;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return null;
	}
	// Time Complexity:
	// O(2max(length of list1,length of list2))+O(abs(length of list1-length of
	// list2))+O(min(length of list1,length of list2))
	// Space Complexity: O(1)

	// Solution 4: Optimal Solution
	// Take two dummy nodes for each list. Point each to the head of the lists.
	// Iterate over them. If anyone becomes null, point them to the head of the
	// opposite lists and continue iterating until they collide.

	private ListNode intersectionPointOfLinkedList(ListNode head1, ListNode head2) {

		ListNode temp1 = head1;
		ListNode temp2 = head2;

		while (temp1 != temp2) {
			temp1 = (temp1 != null) ? temp1.next : head2;
			temp2 = (temp2 != null) ? temp2.next : head1;
		}
		return temp1;
	}

	public static void main(String[] args) {
		// creation of both lists
		IntersectionOf2LinkedLists lists = new IntersectionOf2LinkedLists();
		ListNode head = null;
		head = lists.insertNodeAtTail(1);
		head = lists.insertNodeAtTail(3);
		head = lists.insertNodeAtTail(1);
		head = lists.insertNodeAtTail(2);
		head = lists.insertNodeAtTail(4);
		ListNode head1 = head;
		head = head.next.next.next;
		ListNode headSec = null;
		headSec = lists.insertNodeAtTail(3);
		ListNode head2 = headSec;
		headSec.next = head;
		// printing of the lists
		lists.print(head1);
		lists.print(head2);
		// checking if intersection is present
		// ListNode intersectNode = lists.intersectionPresent(head1, head2);

		// ListNode intersectNode = lists.intersectionPoint(head1, head2);

		// ListNode intersectNode = lists.intersectionPointOfLL(head1, head2);

		ListNode intersectNode = lists.intersectionPointOfLinkedList(head1, head2);

		if (intersectNode == null)
			System.out.println("No intersection\n");
		else
			System.out.println("The intersection point is " + intersectNode.data);
	}

}
