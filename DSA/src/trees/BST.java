package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BST<T extends Comparable<T>> {   // Data in BST must be comparable
	
	private int nodeCount=0;
	
	private Node root = null;
	
	private class Node{
		T data;
		Node left;
		Node right;	
		
	public Node(Node left,Node right,T ele) {
		this.left=left;
		this.right=right;
		this.data=ele;
	}	
   }
	
   public boolean isEmpty(){
	   return size()==0;
   }
   
   public int size(){
	   return nodeCount;
   }
   
   public boolean add(T elem){
	   if(contains(elem)){
		   return false;
	   }
	   root=add(root,elem);
	   nodeCount++;
	   return true;
   }
   
   private Node add(Node node,T elem){
	   if(node==null){
		    node= new Node(null,null,elem);
	   }
	   else{
	   if(elem.compareTo(node.data)<0){
		   node.left=add(node.left,elem);
	   }
	   else{
		   node.right=add(node.right,elem);
	   }
	   }
	   return node;
   }
   
   public boolean remove(T elem){
	   if(contains(elem)){
		   root=remove(root,elem);
		   nodeCount--;
		   return true;
	   }
	   return false;
   }
   
   public Node remove(Node node,T elem){
	   if(node==null) return null;
	   
	   int cmp=elem.compareTo(node.data);
	   
	    /// These will dig into that element		
	   if(cmp<0){
		   node.left=remove(node.left,elem);
	   }														
	   else if(cmp>0){
		   node.right=remove(node.right,elem);
	   }
	   else{
		  ///  It will remove element which has  3 cases
		   
		  // case-1: There is only left right subtree
		  
		  if(node.left==null){
			  Node rightChild = node.right;
			  node.data=null;
			  node=null;
			  return rightChild;
		  }
		  
		  // case-2: There is only left sub tree
		  
		  if(node.right==null){
			  Node leftChild =node.left;
			  node.data=null;
			  node=null;
			  return leftChild;
		  }
		  
		  // case-3: Both sub trees present  ---> Largest node in LST(digRight) or Smallest node in RST(digLeft)
		  else{
			  //Smallest node in RST(digLeft)
			  
			  Node tmp = digLeft(node.right);
			  node.data=tmp.data;
			  node.right  =  remove(node.right,tmp.data);
			  
			  /*
			   * or Largest node in LST(digRight)
			   * Node tmp = digRight(node.left);
			   * node.data = tmp.data;
			   * node.left = remove(node.left,tmp.data);
			   */
		  }
	   }
	return node;  
   }
   
   
   private Node digLeft(Node node){
	   Node cur=node;
	   while(cur.left!=null){
		   cur=cur.left;
	   }
	   return cur;
   }
   
   @SuppressWarnings("unused")
   private Node digRight(Node node){
	   Node cur = node;
	   while(cur.right!=null){
		   cur=cur.right;
	   }
	   return cur;
   }
   
   
   public boolean contains(T elem){
	   return contains(root,elem);
   }
   
   private boolean contains(Node node,T elem){
	   // Value Not Found case
	   if(node==null){
		   return false;
	   }
	   
	   int cmp = elem.compareTo(node.data);
	   if(cmp<0){
		   return contains(node.left,elem);
	   } 
	   else if(cmp>0){
		   return contains(node.right,elem);
	   }
	   else{
		   return true;
	   }
	   
   }
   
   public int height(){
	   return height(root);
   }
   
   private int height(Node node) {
	   if(node==null) return 0;
	   return Math.max(height(node.left),height(node.right))+1;
   }
   
   public void traverse(int order){
	   switch(order){
	   case 1:  preOrder(root); return;
	   case 2:  inOrder(root); return;
	   case 3:  postOrder(root); return;
	   case 4:  levelOrder(root); return;
	   default: return;
	   
	   }
   }
   
   private void preOrder(Node node){
	   if(node==null) return;
	   System.out.print(node.data+" ");
	   preOrder(node.left);
	   preOrder(node.right);
   }
   
   private void inOrder(Node node){
	   if(node==null) return;
	   inOrder(node.left);
	   System.out.print(node.data+" ");
	   inOrder(node.right);
   }
   
   private void postOrder(Node node){
	   if(node==null) return;
	   postOrder(node.left);
	   postOrder(node.right);
	   System.out.print(node.data+" ");
   }
	
   private void levelOrder(Node node){
	   if(node==null) return;
	   Queue<Node>queue= new LinkedList<Node>();
	   queue.add(node);
	   while(!queue.isEmpty()){
		   Node cur = queue.poll();
		   System.out.print(cur.data+" ");
		   if(cur.left!=null){
		   queue.add(cur.left);
		   }
		   if(cur.right!=null){
		   queue.add(cur.right);
		   }
	   }
	   System.out.println();
   }
   
   public void delete(){
//	   delete(root);
	   root = null;
   }
   
   
   private void delete(Node root) {
	   if(root==null)return;
	   delete(root.left);
	   delete(root.right);
	   root.data=null;
	   root = null;
	}
   
   /*
    * 
    * Helper Functions which may help sometimes
    * 
    */

	/*
     * Sum of All Nodes
     */
    public int sumOfNodes(){
    	return sumOfNodes(root);
    }
    
    private int sumOfNodes(Node node){
    	if(node==null) return 0;
    	return (Integer)node.data+sumOfNodes(node.left)+sumOfNodes(node.right);
    }
    
    public int getDifferenceEvenOddlevels(){
    	return getDifferenceEvenOddlevels(root);
    }

	private int getDifferenceEvenOddlevels(Node node) {
		if(node==null) return 0;
		return (Integer)node.data-getDifferenceEvenOddlevels(node.left)-getDifferenceEvenOddlevels(node.right);
	}
	
	public int getNoOfNodes(){
		return getNoOfNodes(root);
	}

	private int getNoOfNodes(Node node) {
		if(node==null){
			return 0;
		}
		return getNoOfNodes(node.left)+getNoOfNodes(node.right)+1;
	}
    
	/*
	 * Mirror of an tree
	 */
	public void mirror(){
		root = mirror(root);
	}

	private Node mirror(Node root) {
		if(root==null) return root;
		Node temp = mirror(root.left);
		root.left = mirror(root.right);
		root.right = temp;
		return root;
	}
   
	public void printPath(){
		if(root==null) return;
		int [] arr = new int[height()+1];
		printPathImpl(root,arr,0);
	}

	private void printPathImpl(Node root,int[]arr,int index) {
		if(root==null) return;
		// add Data
		arr[index]=(Integer)root.data;
		if(root.left==null && root.right==null){
			printArray(arr,index);
		}
		printPathImpl(root.left,arr,index+1);
		printPathImpl(root.right,arr,index+1);
	}

	private void printArray(int[] arr,int index) {
		for(int i=0;i<=index;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	/*
	 * get Node from given data
	 */
	public Node getNode(Node root, T n){
		if(root==null) return null;
		
		if(root.data.compareTo(n)==0){
			return root;
		}else{
		Node found = getNode(root.left,n);
		if(found==null){
		found = getNode(root.right,n);
		}
		return found;
		}
	}
	
	
	//Lowest common Ancestor of BST
	public T lca(T n1,T n2){
		if(contains(n1) && contains(n2)){
		return lcaImpl(root,n1,n2);
		}
		System.out.println("Elements Not Found");
		return null;
	}
	
	private T lcaImpl(Node root, T n1, T n2) {
		if(root==null) return null;
		
		if(root.data.compareTo(n1)>0 && root.data.compareTo(n2)>0){
			return lcaImpl(root.left,n1,n2);
		}
		
		if(root.data.compareTo(n1)<0 && root.data.compareTo(n2)<0){
			return lcaImpl(root.right,n1,n2);
		}
		return root.data;
	}
	
	//Ancestors of given Node
	public void ancestors(T n){
		if(contains(n)){
			List<T> list = new ArrayList<T>();
			ancestorsImpl(root,n,list);
			for(T ele : list){
				System.out.print(ele+" ");
			}
			return;
		}
		System.out.println("Node Not Found!!!!!!!!!!!");
	}
	
	private List<T> ancestorsImpl(Node root, T n,List<T> list) {
		if(root==null) return list;
		
		list.add(root.data);
		
		if(root.data.compareTo(n)==0){
			return list;
		}
		
		if(root.data.compareTo(n)>0){
			ancestorsImpl(root.left,n,list);
		}
		
		if(root.data.compareTo(n)<0){
			ancestorsImpl(root.right,n,list);
		}
		return list;
	}	
	
	// Kth Smallest Element in BST
	 public int KthSmallestElement(int k) 
	    {
	        int[] nums = new int[2];
	        nums[1] = -1;
	        inOrderSpl(root,nums,k);
	        return nums[1];
	    }
	    
	 private void inOrderSpl(Node root,int[] nums,int k){
	        if(root==null) return;
	        inOrderSpl(root.left,nums,k);
	        if(++nums[0]==k){
	            nums[1] = (int) root.data;
	            return;
	        }
	        inOrderSpl(root.right,nums,k);
	}
	
    // kth Largest Element in BST
	public void kthLargest(int k){
	        int[] nums = new int[2];
	        nums[1] = -1;
	        ReverseInOrder(root,nums,k);
	        System.out.println(nums[1]);
	}
	    
	private void ReverseInOrder(Node root,int[]nums,int k){
	        if(root==null) return;
	        ReverseInOrder(root.right,nums,k);
	        if(++nums[0]==k){
	            nums[1] = (int) root.data;
	            return;
	        }
	        ReverseInOrder(root.left,nums,k);
	}
	
}





	/*
	 * construct binary tree from inorder and preorder
	
    private Node buildTree(int[] preorder, int[] inorder) {
        return bulidTreeImpl(0,0,inorder.length-1,preorder,inorder);
    }
    
    private Node bulidTreeImpl(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
        
        if(preStart>preorder.length-1 || inStart>inEnd) return null;
        
       Node root = new Node(null,null,preorder[preStart]);
       
        int inIndex = 0;
        for(int i=inStart;i<inEnd;i++){
            if(root.data.compareTo(inorder[i])==0){
                inIndex = i;
                 break;
            }
        }
        
        root.left =NodeImpl(preStart+1,inStart,inIndex-1,preorder,inorder);
        root.right =NodeImpl(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);
        
        return root;
      }
      
      */
	
	
	
	/*
	 * construct BT from postorder and inorder
	 * 
	 * 
	 *     Node buildTree(int in[], int post[], int n) {
      return  buildTreeImpl(post.length-1,0,in.length-1,in,post);
    }
    
    Node buildTreeImpl(int ps,int is,int ie,int[] in,int [] post){
        if(ps<0 || is>ie) return null;
        
        Node root = new Node(post[ps]);
        
        int k=0;
        for(int i=is;i<=ie;i++){
            if(in[i]==root.data){
                k=i;
                break;
            }
        }
        
        root.left = buildTreeImpl(ps+(k-ie)-1,is,k-1,in,post);
        root.right = buildTreeImpl(ps-1,k+1,ie,in,post);
        
        return root;
    }
	 */
	
	/*
	 * 
	 * Construct BT from inorder and levelorder
	 * 
	 *     Node buildTree(int inord[], int level[])
    {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<level.length;i++){
            map.put(level[i],i);
        }
        return buildTreeImpl(0,inord.length-1,inord,map);
    }
    
    Node buildTreeImpl(int is,int ie,int[] in,Map<Integer,Integer>map) {
        if(is>ie) return null;
        
        
        int j =is;
        
        for(int i=is;i<=ie;i++){
            if(map.get(in[i]) < map.get(in[j]) ){
                j=i;
            }
        }
        
        Node root = new Node(in[j]);
        
        root.left = buildTreeImpl(is,j-1,in,map);
        root.right = buildTreeImpl(j+1,ie,in,map);
        
        
        return root;
        
            }
	 * 
	 */
   
	
	/*
	 * 
	 * Construct BT from preorder and postorder
	 * 
	 * 
	 * public TreeNode constructFromPrePostImpl(int pIndex,int start,int end,int[] pre,HashMap<Integer,Integer>map){
       
        if(start>end) return null;
        
        TreeNode root = new TreeNode(pre[pIndex++]);
        
       // System.out.println(pIndex);
        
        //Last Element in the root
        if(pIndex==pre.length){
            return root;
        }
        
        int j = map.get(pre[pIndex]);
        
        if(start<=j && j+1<=end-1){
            root.left = constructFromPrePostImpl(pIndex,start,j,pre,map);
            root.right = constructFromPrePostImpl(pIndex,j+1,end-1,pre,map);
        }
        
        
        return root;
	 */
























