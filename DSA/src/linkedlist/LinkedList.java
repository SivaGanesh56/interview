package linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedList<T> {
	
	private class Node{
		T data;
		Node next;
		public Node(T data,Node next) {
			this.data=data;
			this.next=next;
		}
	}
	
	Node head=null;
	
	public void add(T data){
		 insertAtEnd(data);
	}

	public void insertAtStart(T data) {
		Node node = new Node(data,null);
		if(head==null){
			head=node;
		}
		else{
		node.next=head;
		head=node;
		}
	}
	
	public void insertAtEnd(T data){
		Node node = new Node(data,null);
		if(head==null){
			head=node;
		}
		else{
			Node temp1=head;
			Node temp2=null;
			while(temp1!=null){
				temp2=temp1;
				temp1=temp1.next;
			}
			temp2.next=node;
		}
	}
	
	public void remove(T data){
		if(head==null) return;
		if(head.data==data){
			removeAtHead();
		}
		Node temp1=head;
		Node temp2=null;
		while(temp1!=null && temp1.data!=data){
			temp2=temp1;
			temp1=temp1.next;
		}
		if(temp1==null) return;
		temp2.next=temp1.next;
		temp1.data=null;
		temp1=null;
	}
	
	public int removeAtHead() {
		if(head==null) return -1;
		Node temp=head;
		head=head.next;
		temp.data=null;
		temp=null;
		return 1;
	}
	
	public int removeAtTail(){
		if(head==null) return -1;
		if(head.next==null) return removeAtHead();
		Node temp1=head;
		Node temp2=null;
		while(temp1.next!=null){
			temp2=temp1;
			temp1=temp1.next;
		}
		temp2.next=null;
		temp1.data=null;
		temp1=null;
		return 1;
	}
	
	public void delete(){
		head=null; // --> This is enough to delete Auto garbage collection will take care of rest
//		Node curr=head;
//		while(curr!=null){
//			Node temp= curr.next;
//			curr.data=null;
//			curr.next=null;
//			curr=temp;
//		}
	}
	
	public void reverse(){
		if(head==null) return;
		Node curr=head;
		Node prev=null;
		while(curr!=null){
			Node temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		head=prev;
	}

	public void print(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	
	/*
	 * 
	 * Helper functions
	 * 
	 */
	
	 /*
	  * Get Nth Node
	  * @param n
	  */

	   public T getNthNode(int n){
		   Node temp=head;
		   int count=0;
		   while(temp!=null){
			   if(count==n){
				   return temp.data;
			   }
			   count++;
			   temp=temp.next;
		   }
		   return null;
	   }

	 /*
	  * Middle Node of LinkedList
	  */
	   
	  public T middle(){
		  if(head==null) return null;
		  Node temp1=head;
		  Node temp2=head;
		  while(temp1!=null && temp1.next!=null){
			  temp2=temp2.next;
			  temp1=temp1.next.next;
		  }
		  return temp2.data;
	  }
	
	  /*
	   * Length of LinekdList
	   */
	  public int length(){
		  return length(head);
	  }
	  
	  private  int length(Node head){
	        Node temp=head;
	        int count=0;
	        while(temp!=null){
	            count++;
	            temp=temp.next;
	        }
	        return count;
	    }
	  
	  /*
	   * Get Nth Node from Last
	   */
	   public  T getNthFromLast(Node head, int n)
	    {
	    	if(length(head)<n) return null;
	    	Node fast=head;
	    	Node slow=head;
	    	while(n>0){
	    	    fast=fast.next;
	    	    n--;
	    	}
	    	while(fast!=null){
	    	    fast=fast.next;
	    	    slow=slow.next;
	    	}
	    	return slow.data;
	    }
	   
	   /*
	    * Print elements in LinkedList Recursively
	    */
	   public void PrintRec(){
		   PrintRec(head);
	   }

	   private void PrintRec(Node node) {
		if(node==null) {System.out.print("null");return;}
		System.out.print(node.data+"->");
		PrintRec(node.next);
	}
	
	/*
	 * print elements reverse 
	 */
	 public void printReverse(){
		 printReverse(head);
	 }

	private void printReverse(Node node) {
		if(node==null) return;
		printReverse(node.next);
		System.out.print(node.data+"->");
	}
	
	/*
	 * Reverse a LinkedList Using Recursion
	 */
	public void reverseRec(){
		reverseRec(head);
	}

	private void reverseRec(Node node) {
		if(node.next==null){
			head=node;
			return;
		}
		reverseRec(node.next);
		Node temp = node.next;
		temp.next=node;
		node.next=null;
	}
	
	/*
	 * Detect a Loop in a LinkedList
	 */
	public boolean detectLoop(){
		return detectLoop(head);
	}
	
	public boolean detectLoop(Node head) {
        if(head==null) return false;
        Node slow=head;
        Node fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
	/*
	 * Detect and remove an loop
	 */
      private Node detectLoopRe(Node head){
        if(head==null) return null;
        Node slow=head;
        Node fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return slow;
            }
        }
        return null;
    }

    @SuppressWarnings("unused")
	private void removeTheLoop(Node head)
    {
        if(head==null) return ;
        Node res = detectLoopRe(head);
        if(res==null) return;
        Node curr=head;
        Node prev=null;
        while(res!=curr){
            prev=res;
            res=res.next;
            curr=curr.next;
        }
        prev.next=null;
    }
    
    /*
     * Plaindorme or not
     */
    
	public boolean isPalindrome() {
		return isPalindrome(head);
	}
    
    public boolean isPalindrome(Node head) 
    {
        if(head==null) return true;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        slow=reversed(slow);
        fast=head;
        while(slow!=null){
            if(fast.data!=slow.data){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    } 
    
    @SuppressWarnings("unused")
	private Node reversed(Node slow){
        Node curr=slow;
        Node prev=null;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    
    /*
     * Insert into sorted LinkedList
     */
    public void sortedInsert(T key){
    	sortedInsert(head,key);
    }
    
    private void sortedInsert(Node head, T key) {
        if(head==null) return ;
        Node node = new Node(key,null);
        int value=(Integer)key;
        if(value<=(Integer)head.data){
        	 insertAtStart(key);
        }
        Node temp= head;
        while(temp.next!=null){
            if(value>=(Integer)temp.data && value < (Integer)temp.next.data){
                node.next=temp.next;
                temp.next=node;
                return;
            }
            temp=temp.next;
        }
        temp.next=node;
        return;
    }
    
    /*
     * Clone LinkedList with Random pointers
     * 
     *  Node copyList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        //Make map
        Node curr = head;
        while(curr!=null){
            map.put(curr,new Node(curr.data));
            curr=curr.next;
        }
        //Make connections
        curr=head;
        while(curr!=null){
            Node res = map.get(curr);
            res.next=map.get(curr.next);
            res.arb=map.get(curr.arb);
            curr=curr.next;
        }
        return map.get(head);
    }
     * 
     */
    
    /*
     * Intersection Point of two LinkedLists
     * @Access Level : Private
     */
	@SuppressWarnings("unused")
	private T intersectPoint(Node headA, Node headB) 
	{
	    int n1=length(headA);
	    int n2=length(headB);
	    int d =Math.abs(n1-n2);
	    Node trav1 =(n1>n2)?headA:headB;
	    Node trav2 =(n1<=n2)?headA:headB;
	    int c=0;
	    while(c!=d){
	        trav1=trav1.next;
	        c++;
	    }
	    while(trav1!=null && trav2!=null){
	        if(trav1==trav2){
	            return trav1.data;
	        }
	        trav1=trav1.next;
	        trav2=trav2.next;
	    }
	    return null;
	}
	
	/*
	 * Remove duplicates from sorted LL
	 */
	
	public void removeDuplicatesSorted() {
		removeDuplicatesSorted(head);
	}
		
   private void removeDuplicatesSorted(Node root)
    {
		Node curr=root;
		while(curr!=null && curr.next!=null){
		    if(curr.data==curr.next.data){
		        Node temp=curr.next.next;
		        curr.next=null;
		        if(temp==null){
		            curr.next=null;
		            return;
		        }
		        curr.next=temp;
		    }
		    if(curr.data!=curr.next.data){
		        curr=curr.next;
		    }
		}
		return;
    }
   /*
    * Remove duplicates from an unsorted Array
    */
   public void removeDuplicatesUnsorted(){
	   removeDuplicatesUnsorted(head);
   }
   
   private void removeDuplicatesUnsorted(Node head) 
   {
       HashSet<T>set = new HashSet<T>();
       Node curr=head;
       Node prev=null;
       while(curr!=null){
           T curr_val=curr.data;
           if(set.contains(curr_val)){
               prev.next=curr.next;
           }
           else{
               prev=curr;
               set.add(curr.data);
           }
           curr=curr.next;
       }
       return;
   }
   
   /*
    * Bubble sort
    */
   
   public void bubbleSort(){
	   Node curr1=head;
	   while(curr1.next!=null){
		   Node curr2=curr1.next;
		   while(curr2!=null){
			  if( (Integer)curr1.data>(Integer)curr2.data ){   // Use compareTo method for comparing generic types in java8 or above
				  T temp = curr1.data;
				  curr1.data=curr2.data;
				  curr2.data=temp;
			  }
			  curr2=curr2.next;
		   }
		   curr1=curr1.next;
	   }
   }
	
   /*
    * To check whether given data is present or not
    */
   public boolean contains(T data){
	   Node curr = head;
	   while(curr!=null){
		   if(curr.data.equals(data)){
			   return true;
		   }
		   curr=curr.next;
	   }
	   return false;
   }
   
   /*
    * Search Nodes
    */
   private List<Node> searchNode(T data){
	   Node prev=null;
	   Node curr=head;
	   while(curr!=null && !curr.data.equals(data)){
		   prev=curr;
		   curr=curr.next;
	   }
	   List<Node>list = new ArrayList<Node>();
	   list.add(prev);
	   list.add(curr);
	   return list;
   }
   
   /*
    *  Swap Two Links Without Swapping data
    */
   
   public void swap(T x,T y){
	   if(contains(x) && contains(y)){
		   List<Node>res1=searchNode(x);
		   List<Node>res2=searchNode(y);
		   Node prevx=res1.get(0);
		   Node px=res1.get(1);
		   Node prevy=res2.get(0);
		   Node py=res2.get(1);
		   Node temp = py.next;
		   py.next=px.next;
		   px.next=temp; 
		   if(prevx==null){
			   head=py;
			   prevy.next=px;
		   }
		   if(prevy==null){
			   head=px;
			   prevx.next=py;
		   }
		   if(prevx!=null && prevy!=null){
			   prevx.next=py;
			   prevy.next=px;
		   }
	   }
	   else{
		   System.out.println("Elements Not Found");
	   }
   }
   
   public void mergeSort(){
	   head=mergeSort(head);
   }

   private Node mergeSort(Node node) {
	if(node==null || node.next==null) return node;
	Node middle= getMiddle(node);
	Node nextOfMiddle = middle.next;
	middle.next=null;
	Node left = mergeSort(node);
	Node right= mergeSort(nextOfMiddle);
	return merge(left,right);
}

   private Node merge(Node slow, Node fast) {
	Node res=null;
	if(slow==null){
		return fast;
	}else if(fast==null){
		return slow;
	}
	if((Integer)slow.data<=(Integer)fast.data){
		res=slow;
		res.next=merge(slow.next,fast);
	}else{
		res=fast;
		res.next=merge(slow,fast.next);
	}
	return res;
}

   private Node getMiddle(Node node) {
	if(node==null) return node;
	Node slow=node;
	Node fast=node;
	while(fast.next!=null && fast.next.next!=null){
		slow=slow.next;
		fast=fast.next.next;
	}
	return slow;
}
   
   public void reverseByGroup(int k){
	  head = reverseByGroup(head,k);
   }
   
   private Node reverseByGroup(Node node, int k)
   {
       if(node==null || k==0) return node;
       Node prev=null;
       Node temp = null;
       Node curr = node;
       int i = 0;
       while(curr!=null && i<k){
    	   temp = curr.next;
    	   curr.next = prev;
    	   prev = curr;
    	   curr = temp;
    	   i++;
       }
       if(temp!=null){
    	   node.next = reverseByGroup(temp,k);
       }
       return prev;
   }
   
   public void rightRotate(int k){
	   head = rightRotateImpl(head,k);
   }
   
   private Node rightRotateImpl(Node head, int k) 
   { 
       if(head==null) return head;
       while(k!=0){
       Node curr = head;
       Node prev = null;
       while(curr!=null && curr.next!=null){
           prev = curr;
           curr = curr.next;
       }
       curr.next = head;
       head  = curr;
       prev.next = null;
       k--;
       }
       return head;
   }
   
 }
