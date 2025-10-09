package com.easy.singlylinkedlist;

class ImplNode {
	ImplNode next;
	int data;

	ImplNode(int val) {
		this.data = val;
		this.next = null;

	}
}

class ImplLinkedList {
	SLLNode head = null;
	SLLNode tail = null;
	int size = 0;

	void insertAtEnd(int val) {

		SLLNode temp = new SLLNode(val);

		if (head == null) {
			head = temp;
		} else {
			tail.next = temp;
		}
		tail = temp;
		size += 1;
	}

	void insertAtBegin(int val) {

		SLLNode temp = new SLLNode(val);

		if (head == null) {
			head = temp;
			tail = temp;
		} else {
			temp.next = head;
			head = temp;
		}
		size += 1;
	}

	void insertAtIndex(int idx, int val) {

		SLLNode temp1 = new SLLNode(val);
		SLLNode temp2 = head;
		if (idx == getSize()) {
			insertAtEnd(val);
			return;
		} else if (idx == 0) {
			insertAtBegin(val);
			return;
		} else if (idx < 0 || idx > getSize()) {
			System.out.println("Wrong Index");
			return;
		}
		for (int i = 1; i <= idx - 1; i++) {

			temp2 = temp2.next;
		}

		temp1.next = temp2.next;
		temp2.next = temp1;
		size += 1;
	}
	public SLLNode deleteAtTail() {

		if (head == null || head.next == null) {
			return null;
		}
		SLLNode temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		size -= 1;
		return head;

	}
	
	void deleteAtIndex(int idx) {

		if (idx == 0) {
			head = head.next;
			return;
		}
		if (idx == size) {
			deleteAtTail();
			return;
		}
		SLLNode temp = head;
		for (int i = 1; i <= idx - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		tail = temp;
		size--;
	}

	int getElement(int idx) {
		if (idx < 0 || idx > getSize()) {
			System.out.println("Wrong Index");
			return -1;

		}
		SLLNode temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	void display() {

		SLLNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	int getSize() {
		int count = 0;
		SLLNode temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}

public class ImplementationOfSLL {

	public static void main(String[] args) {

		ImplLinkedList implLinkedList = new ImplLinkedList();
		implLinkedList.insertAtEnd(4);
		implLinkedList.insertAtEnd(6); // 4 -> 6
		implLinkedList.insertAtEnd(10); // 4 -> 6 -> 10
		implLinkedList.insertAtBegin(11); // 11 -> 4 -> 6 -> 10
		implLinkedList.insertAtIndex(3, 15);
		implLinkedList.display();
		System.out.println();
		System.out.println(implLinkedList.getSize());
		System.out.println(implLinkedList.getElement(3));
		System.out.println(implLinkedList.size);
		implLinkedList.deleteAtIndex(2);
		implLinkedList.display();
	}
}
