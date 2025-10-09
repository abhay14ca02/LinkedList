package com.easy.singlylinkedlist;

class SLLNode {
	int data;
	SLLNode next;

	SLLNode(int val) {
		this.data = val;
		this.next = null;
	}
}

class LinkedListNode {
	SLLNode head = null;
	int size = 0;

	public SLLNode convertArray2LL(int[] arr) {
		head = new SLLNode(arr[0]);
		size += 1;
		SLLNode mover = head;
		for (int i = 1; i < arr.length; i++) {
			SLLNode temp = new SLLNode(arr[i]);
			mover.next = temp;
			mover = temp;
			size += 1;
		}
		return head;
	}

	public void display() {
		SLLNode temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print("-> ");
			}
			temp = temp.next;
		}
		System.out.println();
	}

	public int getLengthOfLL() {
		SLLNode temp = head;
		int count = 0;
		while (temp != null) {

			temp = temp.next;
			count += 1;
		}

		return count;
	}

	public SLLNode deleteAtHead() {

		if (head == null) {
			return null;
		}
		head = head.next;
		size -= 1;
		return head;

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

	public void deleteValue(int val) {
		if (head == null) {
			return;
		}
		if (head.next == null || head.data == val) {
			head = head.next;
			size -= 1;
			return;
		}
		SLLNode temp = head;
		SLLNode prev = null;
		while (temp != null) {
			if (temp.data == val) {
				prev.next = temp.next;
				break;
			}
			prev = temp;
			temp = temp.next;
			size -= 1;
		}
	}

	public void deletAtIndex(int idx) {
		if (head == null) {
			return;
		}
		if (idx < -1 || idx > size) {
			System.out.println("Wrong index");
			return;
		}
		if (head.next == null) {
			head = head.next;
			size -= 1;
			return;
		}
		if (idx == 0) {
			head = head.next;
			size -= 1;
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
		size -= 1;
	}

	public int searchNode(int target) {

		if (head == null) {
			return -1;
		}
		SLLNode temp = head;
		while (temp != null) {
			if (temp.data == target) {
				return 1;
			}
			temp = temp.next;
		}

		return -1;
	}

	public void insertAtHead(int val) {
		SLLNode temp = new SLLNode(val);
		if (head == null) {
			head = temp;
			size += 1;
			return;
		}
		temp.next = head;
		head = temp;
		size += 1;

	}

	public void insertAtTail(int val) {
		SLLNode temp = new SLLNode(val);
		if (head == null) {
			head = temp;
			size += 1;
			return;
		}
		SLLNode mover = head;
		while (mover.next != null) {
			mover = mover.next;
		}
		mover.next = temp;
		size += 1;
	}

	public void insertAtIndex(int idx, int val) {

		if (idx < -1 || idx > size) {
			System.out.println("Wrong index");
			return;
		}
		SLLNode temp = new SLLNode(val);
		if (head == null) {
			head = temp;
			size += 1;
			return;
		}
		if (idx == size) {
			insertAtTail(val);
			return;
		}
		if (idx == 0) {
			insertAtHead(val);
			return;
		}
		SLLNode mover = head;
		for (int i = 1; i <= idx - 1; i++) {
			mover = mover.next;
		}
		temp.next = mover.next;
		mover.next = temp;
		size += 1;
	}

	public void insertBeforeValue(int ele, int val) {
		SLLNode temp = new SLLNode(ele);
		boolean found = false;
		if (head == null) {
			System.out.println("Node is empty");
			return;
		}
		if (head.data == val) {
			temp.next = head;
			head = temp;
			size += 1;
			return;
		}
		SLLNode mover = head;
		while (mover.next != null) {
			if (mover.next.data == val) {
				temp.next = mover.next;
				mover.next = temp;
				size += 1;
				found = true;
				break;
			}
			mover = mover.next;
		}

		if (found == false) {
			System.out.println("Value can not be found");
		}
	}
}

public class ConvertArrayToLL {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 67 };
		LinkedListNode ll = new LinkedListNode();
		SLLNode head = ll.convertArray2LL(arr);
		System.out.println(head);
		ll.display();
		System.out.println(ll.getLengthOfLL());
		// ll.deleteAtHead();
		// ll.deleteAtTail();
		// ll.deletAtIndex(4);
		// ll.deleteValue(67);
		// System.out.println(ll.searchNode(30));
		// ll.insertAtHead(11);
		// ll.insertAtTail(77);
		// ll.insertAtIndex(1, 35);
		ll.insertBeforeValue(21, 40);
		ll.display();
		System.out.println(ll.size);

	}
}
