package linkedlist;

public class SLLtoBST {
	
	//Tree
	TNode root;
	
	class TNode{
		int data;
		TNode left;
		TNode right;
		public TNode(int data,TNode left,TNode right){
			this.data = data;
			this.left = left;
			this.right= right;
		}
	}
	
	// LinkedList
	
	LNode head;
	
	class LNode{
		int data;
		LNode next;
		public LNode(int data,LNode next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public void addL(int data){
		if(head==null){
			head= new LNode(data, null);
			return;
		}
		LNode new_node = new LNode(data, head);
		head = new_node;
	}
	
	public void conversion(){
		root = conversion(head,null);
		Lprint();
		Tprint();
	}

	private TNode conversion(LNode head, LNode tail) {
		if(head==tail) return null;
		LNode slow = head;
		LNode fast = head.next;
		while(fast!=tail && fast.next!=tail){
			slow=slow.next;
			fast=fast.next.next;
		}
		TNode root = new TNode(slow.data, conversion(head, slow), conversion(slow.next,tail));
		return root;
	}
	
	public void Lprint(){
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.println("null");
	}
	
	public void Tprint(){
		preOrder(root);
		System.out.println("null");
	}

	private void preOrder(TNode root) {
		if(root==null) return;
		preOrder(root.left);
		System.out.print(root.data+"->");
		preOrder(root.right);
	}
	
}
