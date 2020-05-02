package linkedlist;

import linkedlist.SLLtoBST.LNode;
import linkedlist.SLLtoBST.TNode;

public class DLLtoBST {
	
	LNode head;
	class LNode{
		int data;
		LNode prev;  //left
		LNode next; // right;
		public LNode(int data,LNode prev,LNode next) {
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
	}
	
	TNode root;
	
	class TNode{
		int data;
		TNode left;
		TNode right;
		public TNode(int data,TNode left,TNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public void addL(int data){
		if(head==null){
			head = new LNode(data, null, null);
			return;
		}
		LNode new_node = new LNode(data,null,head);
		head = new_node;
	}
	
	public void printL(){
		LNode curr = head;
		while(curr!=null){
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.println("null");
	}
	
	public void printT(){
		printT(root);
		System.out.println("null");
	}
	
	private void printT(TNode root) {
		if(root==null) return;
		printT(root.left);
		System.out.print(root.data+"->");
		printT(root.right);
	}

	public void conversion(){
		root = conversion(head,null);
	}

	private TNode conversion(LNode head, LNode tail) {
		if(head==tail) return null;
		LNode slow = head;
		LNode fast = head.next;
		while(fast!=tail && fast.next!=tail){
			slow = slow.next;
			fast = fast.next.next;
		}
		TNode root = new TNode(slow.data,conversion(head,slow),conversion(slow.next,tail));
		return root;
	}

}
