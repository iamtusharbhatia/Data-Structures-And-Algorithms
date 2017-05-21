package LinkedList;

public class ReverseLinkListIterative {

	Node head;
	static class Node{
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	//Function to reverse a linked list
	void reverse(){
		if(head == null || head.next == null){
			return;
		}

		Node curr = head;
		Node prev = null;
		Node temp = null;

		while(curr != null){	
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head = prev;
	}

	//Function to print the linked list
	void printll(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println("");
	}


	public static void main(String[] args) {

		ReverseLinkListIterative obj = new ReverseLinkListIterative();
		obj.head = new Node(10);
		Node n1 = new Node(20);
		Node n2 = new Node(30);
		Node n3 = new Node(40);
		Node n4 = new Node(50);

		obj.head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		obj.printll();
		obj.reverse();
		obj.printll();
	}
}