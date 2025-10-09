package com.easyinterviewques.singlylinkedlist;

// Delete Node in a Linked List
// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]
public class DeleteNodeInALinkedList {

	int data;
	DeleteNodeInALinkedList next;
	public DeleteNodeInALinkedList(int val) {
		this.data=val;
		this.next=null;
		
	}
	public void deleteNode(DeleteNodeInALinkedList node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
	
}
