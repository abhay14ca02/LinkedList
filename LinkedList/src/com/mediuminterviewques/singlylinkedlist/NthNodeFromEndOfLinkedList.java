package com.mediuminterviewques.singlylinkedlist;

// nth node formula, we can take from A.P.
// We calculate nth term in A.P. like this : (m-n+1), where m = total term and n = given term
// nth node = (m-n+1) that is m = size of the LinkedList and n = given index
class Node {
	int data;
	Node next;

	Node(int val) {
		this.data = val;
		this.next = null;
	}
}

public class NthNodeFromEndOfLinkedList {

	Node head = null;

	private Node convertArray2LL(int[] arr) {
		head = new Node(arr[0]);
		Node mover = head;
		for (int i = 1; i < arr.length; i++) {
			Node temp = new Node(arr[i]);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}

	private void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();

	}

	// Brute approach, we we use 2 traversals/passes

	private Node getNthNodeFromEnd(Node head, int n) {
		Node temp = head;
		int size = 0;
		while (temp != null) {
			size += 1;
			temp = temp.next;
		}

		// Check if value of N is not more than length of the linked list
		if (size < n) {
			return null;
		}

		int nthNode = (size - n + 1);
		// nthNode from start
		temp = head;
		for (int i = 1; i <= nthNode - 1; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// We can optimize this further by using TortoiseHare method, i.e; by using Fast
	// and Slow pointer concept

	private Node getNthNode(Node head, int n) {
		Node slow = head;
		Node fast = head;

		for (int i = 1; i <= n; i++) {

			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 21, 36, 41, 55 };

		NthNodeFromEndOfLinkedList linkedList = new NthNodeFromEndOfLinkedList();

		Node head = linkedList.convertArray2LL(arr);
		Node resNode = linkedList.getNthNodeFromEnd(head, 5);
		Node node = linkedList.getNthNode(head, 4);
		System.out.println(resNode.data);
		linkedList.display();
		System.out.println(node.data);
	}
}
// Time Complexity : O(n)
// Space Complexity : O(1)