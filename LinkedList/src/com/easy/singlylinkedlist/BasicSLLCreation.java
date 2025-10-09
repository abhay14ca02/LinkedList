package com.easy.singlylinkedlist;

class Node {

	Node next;
	int data;

	Node(int val) {

		this.data = val;
		this.next = null;
	}

	static void displayLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;

		}

	}

	// When only head is given
	static void insertAtEnd(Node head, int val) {
		Node t = new Node(val);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = t;
	}

	static int getLLSize(Node head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
		return size;

	}
}

public class BasicSLLCreation {

	public static void main(String[] args) {
		Node n1 = new Node(10); // Head Node
		Node n2 = new Node(5);
		Node n3 = new Node(3);
		Node n4 = new Node(11);
		Node n5 = new Node(15);
		n1.next = n2; // 10 -> 5
		// n1.next.next = n3;
		// n1.next.next.next = n4;
		n2.next = n3; // 10 -> 5 -> 3
		n3.next = n4; // 10 -> 5 -> 3 -> 11
		n4.next = n5; // 10 -> 5 -> 3 -> 11 -> 15
		System.out.println(n1.data);
		System.out.println(n1.next.data);
		// System.out.println(n2.next.data);
		System.out.println(n1.next.next.data);
		// System.out.println(n3.next.data);
		System.out.println(n1.next.next.next.data);
		// System.out.println(n4.next.data);
		System.out.println(n1.next.next.next.next.data);
		Node.displayLinkedList(n1);
		System.out.println();
		Node.insertAtEnd(n1, 21); // 10 -> 5 -> 3 -> 11 -> 15 -> 21
		System.out.println("Size of LL = " + Node.getLLSize(n1));
		Node.displayLinkedList(n1);

	}

}
