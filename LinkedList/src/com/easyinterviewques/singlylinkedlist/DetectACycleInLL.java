package com.easyinterviewques.singlylinkedlist;

import java.util.HashMap;

class ListNode1 {
	int data;
	ListNode1 next;

	ListNode1(int val) {
		this.data = val;
		this.next = null;
	}
}

public class DetectACycleInLL {
	private boolean detectLoop(ListNode1 head) {

		ListNode1 temp = head;
		HashMap<ListNode1, Integer> mapList = new HashMap<ListNode1, Integer>();
		while (temp != null) {

			if (mapList.containsKey(temp)) {
				return true;
			}
			mapList.put(temp, 1);
			temp = temp.next;
		}
		return false;
	}
	// Time Complexity : O(n)
	// Space Complexity : O(n)

	// We can optimize this further by using Tortoise and Hare method, where we use
	// slow and fast pointer concepts.
	// Where slow moves 1 step and fast moves 2 steps.
	private boolean detectLoopInLL(ListNode1 head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode1 slow = head;
		ListNode1 fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;

	}
	// Time Complexity : O(n)
	// Space Complexity : O(1)

	public static void main(String[] args) {

		// Create a sample linked list
		// with a loop for testing
		ListNode1 head = new ListNode1(1);
		ListNode1 second = new ListNode1(2);
		ListNode1 third = new ListNode1(3);
		ListNode1 fourth = new ListNode1(4);
		ListNode1 fifth = new ListNode1(5);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		// Create a loop
		fifth.next = third;
		DetectACycleInLL aCycleInLL = new DetectACycleInLL();
		if (aCycleInLL.detectLoopInLL(head)) {
			System.out.println("Loop detected in the linked list.");
		} else {
			System.out.println("No loop detected in the linked list.");
		}

	}
}
