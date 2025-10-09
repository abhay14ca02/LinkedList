package com.mediuminterviewques.singlylinkedlist;

class NodeNth {
	int data;
	NodeNth next;

	NodeNth(int val) {
		this.data = val;
		this.next = null;
	}
}

public class BruteRemoveNthNodeFromEndOfLinkedList {

	NodeNth head = null;

	private NodeNth convertArray2LL(int[] arr) {
		head = new NodeNth(arr[0]);
		NodeNth mover = head;
		for (int i = 1; i < arr.length; i++) {
			NodeNth temp = new NodeNth(arr[i]);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}

	private void display(NodeNth head) {
		NodeNth temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	private NodeNth removeNthNodeFromLL(NodeNth head, int n) {
		NodeNth temp = head;
		int size = 0;
		while (temp != null) {
			size += 1;
			temp = temp.next;
		}

		// Check if value of N is not more than length of the linked list
		if (size < n) {
			return null;
		}
		if (size == n) {
			head = head.next;
			return head;
		}
		// Calculate nth Node
		int m = size - n + 1;
		temp = head;
		for (int i = 1; i < m - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return temp;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 21, 36, 41, 55 };

		BruteRemoveNthNodeFromEndOfLinkedList linkedList = new BruteRemoveNthNodeFromEndOfLinkedList();

		NodeNth head = linkedList.convertArray2LL(arr);
		linkedList.display(head);
		NodeNth nthNode = linkedList.removeNthNodeFromLL(head, 6);
		linkedList.display(nthNode);
		System.out.println(nthNode.data);

	}
}
