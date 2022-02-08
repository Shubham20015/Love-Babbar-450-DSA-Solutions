package internship.linkedList;

public class DoublyLinkedList {
		
		Node head;
		
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
			node.prev = curr;
		}
		
		public void insertAt(int data,int pos) {
			Node addNode = new Node(data);
			
			if(pos == 0) {
				addNode.next = head;
				head.prev = addNode;
				head = addNode;
				return;
			}
			
			Node temp = head;
			for(int i=0;i<pos-1;i++) {
					temp = temp.next;
			}
			addNode.next = temp.next;
			addNode.prev = temp;
			temp.next = addNode;
		}
		
		public void delete(int pos) {
			
			if(pos == 0) {
				head = head.next;
				return;
			}
			
			Node temp = head;
			for(int i=0;i<pos-1;i++) {
					temp = temp.next;
			}
			temp.next = temp.next.next;
			temp.next.prev = null;
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
		
		public void reverse()
			{
			    if(head == null || head.next == null)
			        return;
			    
			    Node curr = head;
			    Node newNode = null;
			    while(curr != null){
			        newNode = curr.prev;
			        curr.prev = curr.next;
			        curr.next = newNode;
			        curr = curr.prev;
			    }
			    
			    head = newNode.prev;
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
