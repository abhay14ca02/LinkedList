package com.easyinterviewques.singlylinkedlist;

import java.util.Stack;

class ListNode {
	int data;
	ListNode next;

	ListNode(int val) {
		this.data = val;
		this.next = null;
	}
}

public class ReverseLinkedList {
	ListNode head = null;

	private ListNode insertNode(int val) {

		ListNode newNode = new ListNode(val);
		if (head == null) {
			head = newNode;
			return head;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return head;
	}

	private void display(ListNode head) {
		if (head == null) {
			return;
		}
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

	private ListNode reverseLL(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode temp = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		// Reset the temporary pointer
		// to the head of the linked list
		temp = head;
		// Step 2: Pop values from the stack
		// and update the linked list
		while (temp != null) {
			// Set the current node's data
			// to the value at the top of the stack
			temp.data = stack.pop();
			// Move to the next node
			// in the linked list
			temp = temp.next;
		}
		// Return the new head of
		// the reversed linked list
		return head;
	}

	// Time Complexity: O(2N)
	// Space Complexity: O(N)
	// Approach 2: Reverse Links in place (Iterative)
	private ListNode reverseLinkedList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode current = head;
		ListNode prev = null;
		while (current != null) {
			ListNode front = current.next;
			current.next = prev;
			prev = current;
			current = front;
		}
		return prev;
	}
	// Time Complexity: O(n)
	// Space Complexity: O(1)

	private ListNode reverseLLRecursively(ListNode head) {

		if(head == null || head.next == null){
            return head;
        }
		
		ListNode newHead = reverseLLRecursively(head.next); // call
		ListNode front = head.next;
		front.next = head; // Interchange connections
		head.next = null;
		return newHead;
	}
	// Time Complexity: O(n)
    // Space Complexity: O(n) for call stack
	public static void main(String[] args) {

		ListNode head = null;
		ReverseLinkedList list = new ReverseLinkedList();
		head = list.insertNode(1);
		head = list.insertNode(5);
		head = list.insertNode(7);
		head = list.insertNode(9);
		head = list.insertNode(11);
		list.display(head);
		// head = list.reverseLL(head);
		// head = list.reverseLinkedList(head);
		head = list.reverseLLRecursively(head);
		list.display(head);

	}
}
