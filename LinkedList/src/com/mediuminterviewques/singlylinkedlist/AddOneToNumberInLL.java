package com.mediuminterviewques.singlylinkedlist;

class NodeAddOne {
	int val;
	NodeAddOne next;

	NodeAddOne(int val) {
		this.val = val;
		this.next = null;
	}
}

public class AddOneToNumberInLL {
	// Solution 1 : By using Iterative approach
	private static NodeAddOne addOneIterative(NodeAddOne head) {
		if (head == null) {
			return head;
		}
		head = reverseList(head);
		int carry = 1;
		NodeAddOne current = head;
		while (current != null && carry > 0) {
			int sum = current.val + carry;
			current.val = sum % 10;
			carry = sum / 10;
			// If there's no next node and we still have a carry, append a new node
			if (current.next == null && carry > 0) {
				current.next = new NodeAddOne(carry);
				carry = 0;
			}
			current = current.next;
		}
		// Reverse the list back to restore original order
		head = reverseList(head);
		return head;
	}

	private static NodeAddOne reverseList(NodeAddOne head) {

		NodeAddOne prev = null;
		NodeAddOne current = head;

		while (current != null) {
			NodeAddOne nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		return prev;
	}

	// Time Complexity: O(n), Two reversals + one pass for addition.
	// Space Complexity: O(1), Iterative, no extra stack used.

	// Solution 2 : By using Recursion
	private static NodeAddOne addOneRecursive(NodeAddOne head) {
		if (head == null) {
			return head;
		}
		int carry = addOneInLL(head);
		// If carry remains after processing the head, create a new head node
		if (carry != 0) {
			NodeAddOne newHead = new NodeAddOne(carry);
			newHead.next = head;
			head = newHead;
		}

		return head;
	}

	private static int addOneInLL(NodeAddOne head) {
		// Base case: when reaching beyond last node, return carry = 1
		if (head == null)
			return 1;
		// Recurse to the end
		int carry = addOneInLL(head.next);
		int sum = head.val + carry;
		head.val = sum % 10;
		// Return new carry
		return sum / 10;

	}
	// Time Complexity: O(n), One pass for addition.
	// Space Complexity: O(n), Auxiliary stack space.

	private static void printList(NodeAddOne head) {
		if (head == null) {
			System.out.println("LinkedList is empty");
			return;
		}
		NodeAddOne temp = head;
		while (temp != null) {
			System.out.print(temp.val);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	public static void main(String[] args) {
		NodeAddOne head = new NodeAddOne(1);
		head.next = new NodeAddOne(9);
		head.next.next = new NodeAddOne(9);
		head.next.next.next = new NodeAddOne(9);
		System.out.print("Original Number: ");
		printList(head);
		// head = addOneIterative(head);
		head = addOneRecursive(head);
		System.out.print("After Adding One: ");
		printList(head);

	}
}
