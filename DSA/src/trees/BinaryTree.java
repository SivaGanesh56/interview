package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;



public class BinaryTree {
	
	Node root;
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	/*
	 * Add new Node to tree
	 */
	public void add(int data){
		if(root==null){
			root = new Node(data);
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			
			//check for left side  --> If it is null insert otherwise add to queue
			if(temp.left==null){
				temp.left = new Node(data);
				return;
			}else{
				queue.add(temp.left);
			}
			
			//check for right side  --> If it is null insert otherwise add to queue
			if(temp.right==null){
				temp.right = new Node(data);
				return;
			}else{
				queue.add(temp.right);
			}
		}
	}
	
	//Search a Node and return boolean value
	public boolean contains(int data){
		return containsImpl(root,data);
	}
	
	private boolean containsImpl(Node root,int data) {
		if(root==null) return false;
		if(root.data==data) return true;
		return containsImpl(root.left, data) || containsImpl(root.right, data);
	}
	
	//Searches a Node if exists delete it
	public void remove(int data){
		if(!contains(data) || root ==null){
			System.out.println("Element Not Found!!!!!!1");
			return;
		}
		Node rightNode = getRightNode();
		Node target = getNode(root,data);
		target.data = rightNode.data;
		deleteImpl(rightNode);
	}
	
	//Helper Function --> Delete Given Node
	private void deleteImpl(Node node){
		if(root==null) return;
		if(root == node) {
			root = null;
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp  = q.poll();
			if(temp.left!=null){
				if(temp.left == node){
					temp.left = null;
					return;
				}else{
					q.add(temp.left);
				}
			}
			if(temp.right!=null){
				if(temp.right==node){
					temp.right = null;
					return;
				}else{
					q.add(root.right);
				}
			}
		}
	}
	
	//Helper Function ---> Get Last Most Right Node from Tree
	private Node getRightNode(){
		if(root==null) return null;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp   = null;
		while(!q.isEmpty()){
			temp = q.poll();
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
		}
		return temp;
	}
	
    //Helper Function ---> get Node from given data
	private Node getNode(Node root, int n){
		if(root==null) return null;
		
		if(root.data==n){
			return root;
		}else{
		Node found = getNode(root.left,n);
		if(found==null){
		found = getNode(root.right,n);
		}
		return found;
		}
	}
	
	/*
	 * Traversals using recursion  --> DFS
	 */

	// Preorder
	public void preOrder(){
		preOrderImpl(root);
		System.out.println();
	}

	private void preOrderImpl(Node root) {
		if(root==null) return;
		System.out.print(root.data+" ");
		preOrderImpl(root.left);
		preOrderImpl(root.right);
	}
	
	//Inorder
	public void inOrder(){
		inOrderImpl(root);
		System.out.println();
	}

	private void inOrderImpl(Node root) {
		if(root==null) return;
		inOrderImpl(root.left);
		System.out.print(root.data+" ");
		inOrderImpl(root.right);
	}
	
	//PostOrder
	public void postOrder(){
		PostOrderImpl(root);
		System.out.println();
	}

	private void PostOrderImpl(Node root) {
		if(root==null) return;
		PostOrderImpl(root.left);
		PostOrderImpl(root.right);
		System.out.print(root.data+" ");
	}
	
	/*
	 * Traversal  -> DFS
	 */
	
	// 1.LevelOrder --> Using Queue
	public void levelOrder(){
		if(root==null) return;
		Queue<Node>q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
		}
		System.out.println();
	}
	
	// 2.Level Order --> Using Level wise Printing
	public void levelOrder1(){
		if(root==null) return;
		int h = height();
		for(int i=1;i<=h;i++){
			printLevel(root,i);
			System.out.println();
		}
	}

	// Level Wise Printing
	private void printLevel(Node root, int level) {
		if(root==null) return;
		if(level==1){
			System.out.print(root.data+" ");
		}
		if(level>1){
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
	
	/*
	 * Traversals using iterative  -> BFS
	 */
	
	//1.InOrder
	public void inOrderItr(){
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(true){
			if(node!=null){
				stack.add(node);
				node = node.left;
			}else{
				if(stack.isEmpty()) break;
				node = stack.pop();
				System.out.print(node.data+" ");
				node  = node.right;
			}
		}
		System.out.println();
	}
	
	//2.PreOrder
	public void preOrderItr(){
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(true){
			if(node!=null){
				System.out.print(node.data+" ");
				stack.add(node);
				node=node.left;
			}else{
				if(stack.isEmpty()) break;
				node = stack.pop().right;
			}
		}
	}
	
	//3.PostOrder
	public void postOrderItr(){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.add(root);
		while(!s1.isEmpty()){
			Node curr = s1.pop();
			s2.add(curr);
			if(curr.left!=null){
				s1.add(curr.left);
			}
			if(curr.right!=null){
				s1.add(curr.right);
			}
		}
		
		while(!s2.isEmpty()){
			System.out.print(s2.pop().data+" ");
		}
	}
	
	/*
	 * Additional Functions
	 */
	
	// Height of Tree
	public int height(){
		return heightImpl(root);
	}
	
	private int heightImpl(Node root){
		if(root==null) return 0;
		return Math.max(heightImpl(root.left),heightImpl(root.right))+1;
	}
	
	// Get No of Nodes
	public int getNodes(){
		return getNodesImpl(root);
	}
	
	private int getNodesImpl(Node root){
		if(root==null) return 0;
		return getNodesImpl(root.left) + getNodesImpl(root.right)+1;
	}
	
	// Is Empty()
	public boolean isEmpty(){
		return getNodes()==0;
	}
	
	//Ancestors of given Node
	public void ancestors(int n){
		if(contains(n)){
			List<Integer> list = new ArrayList<Integer>();
			ancestorsImpl(root,n,list);
			for(Integer ele : list){
				System.out.print(ele+" ");
			}
			return;
		}
		System.out.println("Node Not Found!!!!!!!!!!!");
	}
	
	private boolean ancestorsImpl(Node root, int n,List<Integer> list) {
		if(root==null) return false;
		
		if(root.data==n){
			list.add(n);
			return true;
		}
		
		if(ancestorsImpl(root.left,n,list) || ancestorsImpl(root.right,n,list)){
			list.add(root.data);
			return true;
		}
		return false;
	}
	
	
	//Lowest common Ancestor of BST
	public int lca(int n1,int n2){
		if(contains(n1) && contains(n2)){
		Node node1 = getNode(root, n1);
		Node node2 = getNode(root,n2);
		return lcaImpl(root,node1,node2).data;
		}
		System.out.println("Elements Not Found");
		return -1;
	}
	
	
	//Recursive Effcient Solution for BT --> O(n)
	private Node lcaImpl(Node root,Node n1,Node n2){
		if(root==null) return null;
		
		if(root==n1 || root ==n2){
			return root;
		}
		
		Node left = lcaImpl(root.left, n1, n2);
		Node right = lcaImpl(root.right, n1, n2);
		
		if(left!=null && right!=null) return root;
		if(left==null && right ==null) return null;
		
		return left!=null?left:right;
		
	}
	
	// Brute Force Apporach --> O(n*n)
	@SuppressWarnings("unused")
	private int lcaImpl2(Node root, int n1,int n2){
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		ancestorsImpl(root, n1, list1);
		ancestorsImpl(root, n2, list2);
		
		int ind = list1.size()<list2.size()? list1.size()-1:list2.size()-1;
		
		Collections.reverse(list1);
		Collections.reverse(list2);
		
		int i=0;
		int prev = list1.get(0);
		int curr = list1.get(0);
		
		while(i<=ind){
			if(list1.get(ind)!=list2.get(ind)){
				break;
			}
			prev = curr;
			curr = list1.get(ind);
			i++;
		}
		
		return prev;
	}
	
	// Print every possbile path
	public void printPath(){
		if(root==null) return;
		int [] arr = new int[height()+1];
		printPathImpl(root,arr,0);
	}

	private void printPathImpl(Node root,int[]arr,int index) {
		if(root==null) return;
		// add Data
		arr[index]=root.data;
		if(root.left==null && root.right==null){
			printArray(arr,index);
		}
		printPathImpl(root.left,arr,index+1);
		printPathImpl(root.right,arr,index+1);
	}
	
	// Prints path
	private void printArray(int[] arr,int index) {
		for(int i=0;i<=index;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
    //Mirror of an tree
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
	
	// Root to leaf sum is equal to given Number?? and print its path
	public void rootToLeaf(int n){
		if(root==null) return;
		List<Integer>list = new ArrayList<Integer>();
		if(rootToLeafImpl(root,n,list)){
			for(Integer elem : list){
				System.out.print(elem+" ");
			}
			return;
		}
		System.out.println("No Such Path exists!!!!!");
	}

	private boolean rootToLeafImpl(Node root, int sum, List<Integer> list) {
		if(root==null) return false;
		if(root.left==null && root.right==null){
			if(root.data==sum){
				list.add(root.data);
				return true;
			}else{
				return false;
			}
		}
		if(rootToLeafImpl(root.left, sum-root.data, list)){
			list.add(root.data);
			return true;
		}
		if(rootToLeafImpl(root.right, sum-root.data, list)){
			list.add(root.data);
			return true;
		}
		return false;
	}
	
	// To check BT is BST or not??
	public boolean isBst(){
		if(root==null) return true;
		return isBstImpl(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private boolean isBstImpl(Node root, int min, int max) {
		if(root==null) return true;
		if(root.data<min || root.data>max){
			return false;
		}
		return isBstImpl(root.left,min,root.data) && isBstImpl(root.right,root.data,max);
	}
	
	// Spiral Printing of Tree
	public void spiralPrint(){
		if(root==null) return;
		Stack<Node>s1 = new Stack<Node>();
		Stack<Node>s2 = new Stack<Node>();
		s1.add(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				Node res = s1.pop();
				System.out.print(res.data+" ");
				if(res.left!=null){
					s2.add(res.left);
				}
				if(res.right!=null){
					s2.add(res.right);
				}
			}
			
			while(!s2.isEmpty()){
				Node res = s2.pop();
				System.out.print(res.data+" ");
				if(res.right!=null){
					s1.add(res.right);
				}
				if(res.left!=null){
					s1.add(res.left);
				}
			}
		}
	}
	
	// Count Leaf Nodes
	public int leafNodes(){
		return leafNodesImpl(root);
	}

	private int leafNodesImpl(Node root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null){
			return 1;
		}
		return leafNodesImpl(root.left)+leafNodesImpl(root.right);
	}
	
	public int diameter(){
		return diameterImpl(root);
	}

	private int diameterImpl(Node root) {
		if(root==null) return 0;
		int lheight = heightImpl(root.left);
		int rheight = heightImpl(root.right);
		return Math.max(lheight+rheight+1,Math.max(diameterImpl(root.left),diameterImpl(root.right)));
	}
	
	public int maxSumPath(){
		if(root==null) return 0;
		List<Integer> list = new ArrayList<Integer>();
		maxSumPathImpl(root,0,list);
		return Collections.max(list);
	}

	private void maxSumPathImpl(Node root, int sum, List<Integer> list) {
		if(root==null) return;
		
		if(root.left==null && root.right==null){
			sum+=root.data;
			list.add(sum);
			return;
		}
		maxSumPathImpl(root.left,sum+root.data,list);
		maxSumPathImpl(root.right,sum+root.data,list);
	}
	
	//Reverse Level Order Printing
	public void reversePrint(){
		reversePrintImpl(root);
	}
	
	private void reversePrintImpl(Node root){
	    if(root==null) return;
	    int h = heightImpl(root);
	    for(int i=h;i>=1;i--){
	        printLevel(root,i);
	    }
	}
	
	// Height of BT iteratively
	public int heightItr(){
		if(root==null) return 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int h = 0;
		while(true){
			int n = q.size();
			if(n==0){
				return h;
			}
			h++;
			while(n>0){
				Node temp = q.poll();
				if(temp.left!=null){
					q.add(temp.left);
				}
				if(temp.right!=null){
					q.add(temp.right);
				}
				n--;
			}
		}
	}
	
	
	// Print Nodes at K distance from given root
	// Make HashMap
	public void printKDis(int nodeData, int k){
		if(root==null) return;
		Node start = getNode(root, nodeData);
		if(start==null) return;
		Map<Node,Node> map = new HashMap<>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		// Make Parents
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left!=null) {
				q.add(temp.left);
				map.put(temp.left,temp);
			}
			if(temp.right!=null) {
				q.add(temp.right);
				map.put(temp.right,temp);
			}
		}
		
	  // Implemenatation for method
		int c = 0;
		List<Node> list = new ArrayList<Node>();
		list.add(start);
		q.add(start);
		while(c!=k && !q.isEmpty()) {
			if(c==k) break;
			c++;
			int n = q.size();
			if(n==0) break;
			while(n>0) {
				Node temp = q.poll();
				if(temp.left!=null && !list.contains(temp.left)) {
					list.add(temp.left);
					q.add(temp.left);
				}
				if(temp.right!=null && !list.contains(temp.right)) {
					list.add(temp.right);
					q.add(temp.right);
				}
				Node res = map.get(temp);
				if(res!=null && !list.contains(res)) {
					list.add(res);
					q.add(res);
				}
				n--;
			}
		}
		System.out.print("Nodes At given "+k+" level are : ");
		for(Node node : q) {
			System.out.print(node.data+" ");
		}
	}
	
	// Print Between Levels
	public void printBtwLevels(int low,int high) {
		if(root==null) return;
		int h = height();
		for(int i =low;i<=h && i<=high;i++) {
			printLevel(root, i);
			System.out.println();
		}
	}
	
	// Serialize binary Tree
	public String serialize() {
		return serializeImpl(root);
	}

	private String serializeImpl(Node root) {
		if(root==null) return "X";
		return root.data+","+serializeImpl(root.left)+","+serializeImpl(root.right);
	}
	
	// Deserialize Binary Tree
	public void deserialize(String string) {
		Queue<String> q = new LinkedList<String>();
		q.addAll(Arrays.asList(string.split(",")));
		root = deserializeHelper(q);
		//levelOrder();
	}

	private Node deserializeHelper(Queue<String> q) {
		if(q.isEmpty()) return null;
		String curr =  q.poll();
		if(curr.equalsIgnoreCase("X")) return null;
		Node node = new Node(Integer.valueOf(curr));
		node.left = deserializeHelper(q);
		node.right = deserializeHelper(q);
		return node;
	}
	
	// Check Bt is Symmetric or not??
    public  boolean isSymmetric(Node root) {
        return root==null || check(root.left,root.right);
    }
    
    private static boolean check(Node leftSub,Node rightSub){
        if(leftSub==null && rightSub==null) return true;
        if(leftSub==null || rightSub==null) return false;
        return leftSub.data==rightSub.data && check(leftSub.left,rightSub.right) &&
                                    check(leftSub.right,rightSub.left);
    }
	
	
	
}
