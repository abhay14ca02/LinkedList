package com.easy.singlylinkedlist;

class NodeRSLL {

	SLLNode next;
	int data;

	NodeRSLL(int val) {

		this.data = val;
		this.next = null;
	}

	// Tail Recursion
	static void displayLinkedList(SLLNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		displayLinkedList(head.next);

	}

	static int size = 0;

	static int getSize(SLLNode head) {
		if (head == null) {
			return size;
		}
		size++;
		getSize(head.next);
		return size;

	}

	// Head Recursion
	static void displayReverse(SLLNode head) {
		if (head == null) {
			return;
		}
		displayReverse(head.next);
		System.out.print(head.data + " ");

	}

	static int len = 0;
	static int getLen(SLLNode head) {
		if (head == null) {
			return len;
		}
		getLen(head.next);
		len++;
		return len;

	}
}

public class BasicSLLRecursiveDisplay {

	public static void main(String[] args) {
		SLLNode n1 = new SLLNode(10); // Head Node
		SLLNode n2 = new SLLNode(5);
		SLLNode n3 = new SLLNode(3);
		SLLNode n4 = new SLLNode(11);
		SLLNode n5 = new SLLNode(15);
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
		NodeRSLL.displayLinkedList(n1);
		System.out.println();
		System.out.println(NodeRSLL.getSize(n1));
		NodeRSLL.displayReverse(n1);
		System.out.println();
		System.out.println(NodeRSLL.getLen(n1));
	}
}
