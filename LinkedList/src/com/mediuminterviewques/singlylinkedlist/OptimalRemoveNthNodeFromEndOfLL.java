package com.mediuminterviewques.singlylinkedlist;

class NodeNthLL {
	int data;
	NodeNthLL next;

	public NodeNthLL(int val) {
		this.data = val;
		this.next = null;
	}
}

public class OptimalRemoveNthNodeFromEndOfLL {
	NodeNthLL head = null;

	private NodeNthLL convertArray2LL(int[] arr) {
		head = new NodeNthLL(arr[0]);
		NodeNthLL mover = head;
		for (int i = 1; i < arr.length; i++) {
			NodeNthLL temp = new NodeNthLL(arr[i]);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}

	private void display(NodeNthLL head) {
		NodeNthLL temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	private NodeNthLL removeNthNodeFromLL(NodeNthLL head, int n) {

		NodeNthLL fast = head;
		NodeNthLL slow = head;
		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			head = head.next;
			return head;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 21, 36, 41, 65 };
		OptimalRemoveNthNodeFromEndOfLL endOfLL = new OptimalRemoveNthNodeFromEndOfLL();
		NodeNthLL head = endOfLL.convertArray2LL(arr);
		endOfLL.display(head);
		NodeNthLL nthNode = endOfLL.removeNthNodeFromLL(head, 3);
		endOfLL.display(nthNode);
	}
}
