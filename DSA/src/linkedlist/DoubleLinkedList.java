package linkedlist;

public class DoubleLinkedList {
	
	Node head = null;
	
	private static class Node{
		int data;
		Node prev,next;
		public Node(int data,Node prev,Node next) {
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
	}
	
	public void add(int data){
		insertAtTail(data);
	}
	
	public void remove(){
		removeAtTail();
	}


	private void insertAtTail(int data) {
		if(head==null){
			head= new Node(data,null,null);
			return;
		}
		Node curr=head;
		Node prev=null;
		while(curr!=null){
			prev=curr;
			curr=curr.next;
		}
		prev.next=new Node(data,prev,null);
	}

	public void insertAtHead(int data) {
		if(head==null){
			head= new Node(data,null,null);
			return;
		}
		Node new_node = new Node(data,null,head);
		head.prev = new_node;
		head=new_node;
	}
	
	private void removeAtHead() {
		if(head==null) return;
		Node temp = head;
		head= head.next;
		if(head!=null){
			head.prev = null;
		}
		temp.data=-1;
		temp=null;
	}
	
	private void removeAtTail() {	
		if(head==null) return;
		Node curr=head;
		Node prev = null;
		while(curr.next!=null){
			prev=curr;
			curr=curr.next;
		}
		prev.next = null;
		curr.prev=null;
		curr.data=-1;
		curr=null;
	}
	
	public int length(){
		Node curr = head;
		int c=0;
		while(curr!=null){
			curr = curr.next;
			c++;
		}
		return c;
	}
	
	public boolean contains(int data){
		if(head==null) return false;
		Node curr=head;
		while(curr!=null){
			if(curr.data==data){
				return true;
			}
			curr=curr.next;
		}
		return false;
	}
	
	public void reverse(){
		 if(head==null) return;
		 Node previous = null;
		 Node current = head;
		 while(current!=null){
			 Node temp = current.next;
			 current.next = previous;
			 current.prev = temp;
			 previous  = current;
			 current   = temp;
		 }
		 head = previous;
	}
	
	public void reverseRec(){
		reverseRec(head);
	}
	
	private void reverseRec(Node node) {
		if(node.next==null){
			node.next = node.prev;
			node.prev = null;
			head = node;
			return;
		}
		reverseRec(node.next);
		Node temp = node.prev;
		node.prev = node.next;
		node.next = temp;
	}

	public void print(){
		Node curr = head;
		while(curr!=null){
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.println("null");
	}
	
}
