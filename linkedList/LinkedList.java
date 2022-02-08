package internship.linkedList;

class Node{
	int data;
	Node next;
	Node prev;
	
	Node(int data){
		this.data = data;
	}
}

public class LinkedList {
	
	Node head;
	Node head1;
	Node head2;
	
	public void insert(int data) {
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			return ;
		}
		
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = node;
	}
	
	public void insertAt(int data,int pos) {
		Node addNode = new Node(data);
		
		if(pos == 0) {
			addNode.next = head;
			head = addNode;
			return;
		}
		
		Node prev = head;
		for(int i=0;i<pos-1;i++) {
				prev = prev.next;
		}
		addNode.next = prev.next;
		prev.next = addNode;
	}
	
	public void delete(int pos) {
		
		if(pos == 0) {
			head = head.next;
			return;
		}
		
		Node prev = head;
		for(int i=0;i<pos-1;i++) {
				prev = prev.next;
		}
		prev.next = prev.next.next;
	}
	
	public void printList(Node node)
    {
        Node temp = node;
        if(node != null)
        {
			do{
           System.out.print(temp.data+" ");
           temp = temp.next;
			}while (temp != node);
        }  
        System.out.println();
    }
	
	public void reverse() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public void show() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
