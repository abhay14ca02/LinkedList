package com.easyinterviewques.singlylinkedlist;

//Given the head of a singly linked list, return the middle node of the linked list.
//If there are two middle nodes, return the second middle node.
//Input: head = [1,2,3,4,5]
//Explanation: The middle node of the list is node 3.
//Input: head = [1,2,3,4,5,6]
//Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
//Brute solution, First we will traverse the LinkedList and find length of LinkedList
class Node {
	int data;
	Node next;

	public Node(int val) {
		this.data = val;
		this.next = null;
	}
}

public class MiddleOfTheLinkedList {

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

	private void display(Node head) {
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

	// Brute solution, First we will traverse the LinkedList and find length of
	// LinkedList
	private Node findMiddleOfLinkedList(Node head) {
		// If the list is empty or has
		// only one element, return the head as it's the middle.
		if (head == null || head.next == null) {
			return head;
		}

		Node temp = head;
		int size = 0;
		while (temp != null) {
			size += 1;
			temp = temp.next;
		}
		// Calculate the position of the middle node.
		int mid = size / 2 + 1;
		temp = head;
		while (temp != null) {
			mid = mid - 1;
			// Check if the middle position is reached.
			if (mid == 0) {
				// break out of the loop to return temp
				break;
			}
			// Move temp ahead
			temp = temp.next;
		}
		return temp;
	}

	// Optimal solution, by using Tortoise & Hare method that is slow and fast
	// pointer
	// When LinkedList is of even length then we can have 2 elements as middle
	// either left or right one.
	// For even no. of nodes & left middle, we can put this condition -->
	// fast.next.next != null & fast.next != null
	// For even no. of nodes & right middle, we can put this condition --> fast.next
	// != null & fast != null
	private Node findMiddleOfLL(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private Node findLeftMiddleOfLL(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {

		int[] arr = { 10, 15, 21, 36, 41, 65, 75, 90 };
		MiddleOfTheLinkedList linkedList = new MiddleOfTheLinkedList();
		Node head = linkedList.convertArray2LL(arr);
		linkedList.display(head);
		Node middle = linkedList.findMiddleOfLinkedList(head);
		System.out.println(middle.data);
		Node midNode = linkedList.findMiddleOfLL(head);
		System.out.println(midNode.data);
		Node leftNode = linkedList.findLeftMiddleOfLL(head);
		System.out.println(leftNode.data);
	}
}
