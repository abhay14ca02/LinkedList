package com.mediuminterviewques.singlylinkedlist;

import java.util.HashMap;

class DetectList {
	int data;
	DetectList next;

	public DetectList(int val) {
		this.data = val;
		this.next = null;
	}
}

public class DetectACycleInLL2 {
	DetectList head = null;

	// Brute Solution : By using Hashing technique
	private DetectList detectACycle(DetectList head) {

		if (head == null || head.next == null) {
			return null;
		}

		HashMap<DetectList, Integer> map = new HashMap<DetectList, Integer>();
		DetectList temp = head;
		while (temp != null) {
			if (map.containsKey(temp)) {
				return temp;
			}
			map.put(temp, 1);
			temp = temp.next;
		}
		return null;
	}

	// Time Complexity : O(n)
	// Space Complexity : O(n)

	private DetectList detectCycle(DetectList head) {
		if (head == null || head.next == null) {
			return null;
		}
		DetectList slow = head;
		DetectList fast = head;
		// Phase 1: Detect cycle
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				// Cycle detected
				slow = head;
				// Phase 2: Find start of cycle
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;// or fast
			}
		}
		return null; // No cycle
	}

	// Time Complexity : O(n)
	// Space Complexity : O(1)
	// The inner loop (while (temp != slow)) is not nested inside the cycle
	// detection loop — it's only entered once, after detecting a cycle. So, time
	// complexity is O(n)
	public static void main(String[] args) {
		// Create a sample linked list
		// with a loop for testing
		DetectList head = new DetectList(1);
		DetectList second = new DetectList(2);
		DetectList third = new DetectList(3);
		DetectList fourth = new DetectList(4);
		DetectList fifth = new DetectList(5);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		// Create a loop
		fifth.next = third;
		DetectACycleInLL2 ll2 = new DetectACycleInLL2();
		DetectList nodeDet = ll2.detectACycle(head);
		System.out.println(nodeDet);
		DetectList node = ll2.detectCycle(head);
		System.out.println(node);
	}
}
