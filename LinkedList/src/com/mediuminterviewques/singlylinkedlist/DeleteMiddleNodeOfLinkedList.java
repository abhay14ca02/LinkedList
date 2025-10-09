package com.mediuminterviewques.singlylinkedlist;

class DelNode {
	int data;
	DelNode next;

	DelNode(int val) {
		this.data = val;
		this.next = null;
	}
}

public class DeleteMiddleNodeOfLinkedList {

	DelNode head = null;

	private DelNode insertNode(int val) {
		DelNode temp = new DelNode(val);
		if (head == null) {
			head = temp;
			return head;
		}
		DelNode mover = head;
		while (mover.next != null) {
			mover = mover.next;
		}
		mover.next = temp;
		return head;
	}

	private void display(DelNode head) {

		DelNode temp = head;

		while (temp != null) {

			System.out.print(temp.data);
			if (temp.next != null) {

				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	// Brute approach, first find the length of LL by using traversal algorithm.
	private void deleteMiddleNodeOfLL(DelNode head) {
		DelNode temp = head;
		int size = 0;
		while (temp != null) {
			size += 1;
			temp = temp.next;

		}
		int mid = size / 2; // Need to calculate mid / 2 before actual (mid + 1)/2 as we need to delete
							// middle node.
							// So, we can stop traversal before middle node and then we can delete middle
							// node by this way temp.next = temp.next.next;
		temp = head;
		for (int i = 1; i <= mid - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;

	}

	// Optimal approach - By using Tortoise and Hair method. We will use slow & fast
	// pointer approach, we move fast pointer by 2 steps that is fast =
	// fast.next.next and slow pointer by one steps that is slow=slow.next. We want
	// to delete middle node of LL. So at the starting point, we will move fast
	// pointer by 2 steps.
	private void deleteMiddleOfLinkedList(DelNode head) {

		DelNode slow = head;
		DelNode fast = head;
		fast = fast.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
	}

	public static void main(String[] args) {

		DeleteMiddleNodeOfLinkedList delList = new DeleteMiddleNodeOfLinkedList();
		DelNode head = null;
		head = delList.insertNode(1);
		head = delList.insertNode(3);
		head = delList.insertNode(7);
		head = delList.insertNode(10);
		head = delList.insertNode(15);
		delList.display(head);
		delList.deleteMiddleNodeOfLL(head);
		delList.deleteMiddleOfLinkedList(head);
		delList.display(head);
	}
}
