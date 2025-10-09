package com.mediuminterviewques.singlylinkedlist;

import java.util.HashMap;

class NodeLength {
	int data;
	NodeLength next;

	NodeLength(int val) {
		this.data = val;
		this.next = null;
	}
}

public class LengthOfLoopLinkedList {

	NodeLength head = null;

	private int findLengthOfLoop(NodeLength head) {
		if (head == null || head.next == null) {
			return 0;
		}
		NodeLength temp = head;
		int count = 0;
		HashMap<NodeLength, Integer> map = new HashMap<NodeLength, Integer>();
		while (temp != null) {
			if (map.containsKey(temp)) {
				int val = map.get(temp);
				return count - val;
			}
			map.put(temp, count);
			temp = temp.next;
			count++;
		}
		return 0;
	}
	// Time Complexity : O(n)
	// Space Complexity : O(n)

	// Optimal Solution by using Tortoise & Hare method
	private int findLengthOfLoopInLL(NodeLength head) {

		if (head == null || head.next == null) {
			return 0;
		}
		NodeLength slow = head;
		NodeLength fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// Cycle detected
			if (slow == fast) {
				return findLength(slow, fast);
			}
		}
		return 0;
	}

	private int findLength(NodeLength slow, NodeLength fast) {
		// count to keep track of
		// nodes encountered in loop
		int count = 1;
		// move fast by one step
		fast = fast.next;
		// traverse fast till it
		// reaches back to slow
		while (slow != fast) {

			// at each node increase
			// count by 1 and move fast
			// forward by one step
			count++;
			fast = fast.next;
		}
		// loop terminates when fast reaches
		// slow again and the count is returned
		return count;
	}

	// Time Complexity : O(n)
	// Space Complexity : O(1)
	public static void main(String[] args) {

		// Create a sample linked list
		// with a loop for testing
		NodeLength head = new NodeLength(1);
		NodeLength second = new NodeLength(2);
		NodeLength third = new NodeLength(3);
		NodeLength fourth = new NodeLength(4);
		NodeLength fifth = new NodeLength(5);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		// Create a loop
		fifth.next = second;
		LengthOfLoopLinkedList ll = new LengthOfLoopLinkedList();
		int length = ll.findLengthOfLoop(head);
		System.out.println(length);
		int lengthOfLoop = ll.findLengthOfLoopInLL(head);
		System.out.println(lengthOfLoop);

	}
}
