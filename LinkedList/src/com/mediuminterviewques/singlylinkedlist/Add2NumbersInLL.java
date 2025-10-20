package com.mediuminterviewques.singlylinkedlist;

class NodeAdd2 {
	int data;
	NodeAdd2 next;

	NodeAdd2(int val) {
		this.data = val;
		this.next = null;
	}
}

public class Add2NumbersInLL {

	private static void printList(NodeAdd2 sum) {

		if (sum == null) {
			System.out.println("LinkedList is empty");
			return;
		}
		NodeAdd2 temp = sum;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();
	}

	private static NodeAdd2 reverseList(NodeAdd2 head) {

		NodeAdd2 prev = null;
		NodeAdd2 current = head;

		while (current != null) {
			NodeAdd2 nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		return prev;
	}

	private static NodeAdd2 addTwoLists(NodeAdd2 num1, NodeAdd2 num2) {

		if (num1 == null) {
			return num2;
		}
		if (num2 == null) {
			return num1;
		}

		NodeAdd2 dummy = new NodeAdd2(-1);
		NodeAdd2 current = dummy;
		NodeAdd2 temp1 = num1;
		NodeAdd2 temp2 = num2;
		int carry = 0;
		while (temp1 != null || temp2 != null || carry > 0) {
			int sum = carry;
			if (temp1 != null) {
				sum += temp1.data;
				temp1 = temp1.next;
			}
			if (temp2 != null) {
				sum += temp2.data;
				temp2 = temp2.next;
			}
			NodeAdd2 node = new NodeAdd2(sum % 10);
			current.next = node;
			carry = sum / 10;
			current = current.next;
		}
		return dummy.next;

	}

	// Time Complexity: O(max(m, n)) — where m and n are lengths of the two lists.
	// Space Complexity: O(1) auxiliary (excluding result list).

	public static void main(String[] args) {
		NodeAdd2 num1 = new NodeAdd2(1);
		num1.next = new NodeAdd2(2);
		num1.next.next = new NodeAdd2(3);

		NodeAdd2 num2 = new NodeAdd2(9);
		num2.next = new NodeAdd2(9);
		num2.next.next = new NodeAdd2(9);

		NodeAdd2 sum = addTwoLists(num1, num2);
		printList(sum);
	}
}
