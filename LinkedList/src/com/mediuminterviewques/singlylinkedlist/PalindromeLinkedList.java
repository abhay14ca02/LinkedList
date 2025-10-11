package com.mediuminterviewques.singlylinkedlist;

import java.util.Stack;

class PalindromeNode {
	int data;
	PalindromeNode next;

	PalindromeNode(int val) {
		this.data = val;
		this.next = null;
	}
}

public class PalindromeLinkedList {

	PalindromeNode head = null;

	private static void printLinkedList(PalindromeNode head) {
		PalindromeNode temp = head;
		while (temp != null) {

			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}

	}

	// Brute approach
	private static boolean isPalindrome(PalindromeNode head) {

		// Check if the linked list is
		// empty or has only one node
		if (head == null || head.next == null) {
			// It's a palindrome by definition
			return true;
		}

		Stack<Integer> stack = new Stack<Integer>();
		PalindromeNode temp = head;
		while (temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			if (temp.data != stack.peek()) {
				return false;
			}
			stack.pop();
			temp = temp.next;
		}
		return true;

	}
	// Time Complexity : O(n)
	// Space Complexity : O(n)

	// Optimal Solution - By using Tortoise & Hare method to find the left middle
	// element, then reverse half of the list from middle element
	private static boolean isPalindromeLL(PalindromeNode head) {

		// Check if the linked list is
		// empty or has only one node
		if (head == null || head.next == null) {
			// It's a palindrome by definition
			return true;
		}
		// Initialize two pointers, slow and fast,
		// to find the middle of the linked list
		PalindromeNode slow = head;
		PalindromeNode fast = head;
		// Traverse the linked list to find the
		// middle using slow and fast pointers
		while (fast.next != null && fast.next.next != null) {
			// Move slow pointer one step at a time
			slow = slow.next;
			// Move fast pointer two steps at a time
			fast = fast.next.next;
		}
		// Reverse the second half of the
		// linked list starting from the middle
		PalindromeNode newHead = reverseLinkedList(slow.next);
		// Pointer to the first half
		PalindromeNode first = head;
		// Pointer to the reversed second half
		PalindromeNode second = newHead;
		while (second != null) {
			// Compare data values of
			// nodes from both halves
			// If values do not match, the
			// list is not a palindrome
			if (first.data != second.data) {
				// Reverse the second half back
				// to its original state
				reverseLinkedList(newHead);
				// Not a palindrome
				return false;
			}
			// Move the first pointer
			first = first.next;
			// Move the second pointer
			second = second.next;
		}
		// Reverse the second half back
		// to its original state
		reverseLinkedList(newHead);
		// The linked list is a palindrome
		return true;
	}

	// Time Complexity : O(n)
	// Space Complexity : O(n) it can be O(1), if we don't use recursive reversal
	private static PalindromeNode reverseLinkedList(PalindromeNode head) {
		// Check if the list is empty or has only one node
		if (head == null || head.next == null) {
			// No change is needed;
			// return the current head
			return head;
		}
		// Recursive step: Reverse the remaining
		// part of the list and get the new head
		PalindromeNode newHead = reverseLinkedList(head.next);
		// Store the next node in 'front'
		// to reverse the link
		PalindromeNode front = head.next;
		// Update the 'next' pointer of 'front' to
		// point to the current head, effectively
		// reversing the link direction
		front.next = head;
		// Set the 'next' pointer of the
		// current head to 'null' to
		// break the original link
		head.next = null;
		// Return the new head obtained
		// from the recursion
		return newHead;
	}

	public static void main(String[] args) {

		// Create a linked list with
		// values 1, 2, 3, 2, and 1 (12321, a Palindrome)
		PalindromeNode head = new PalindromeNode(1);
		head.next = new PalindromeNode(2);
		head.next.next = new PalindromeNode(3);
		head.next.next.next = new PalindromeNode(2);
		head.next.next.next.next = new PalindromeNode(1);
		// Print the original linked list
		System.out.print("Original Linked List: ");
		printLinkedList(head);
		boolean val = isPalindrome(head);
		System.out.println();
		System.out.println(val);
		boolean val2 = isPalindromeLL(head);

	}
}
