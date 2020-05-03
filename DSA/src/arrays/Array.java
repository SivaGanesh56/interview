package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

public class Array {
	
	// pair of array sum is equal to given sum  --> HashMap
	public boolean pairSum(int [] arr,int sum) {
		if(arr.length==0) return false;
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(hs.contains(sum-arr[i])) {
				return true;
			}else {
				hs.add(arr[i]);
			}
		}
		return false;
	}
	
	// Number Repeated odd num times  --> Xor
	public int OddNumber(int [] arr) {
		int res = 0;
		for(int i=0;i<arr.length;i++) {
			res^=arr[i];
		}
		return res;
	}
	
	// return Majority Element in array if exists otherwise -1  --> Morries Voting Algo
	public int majorityElement(int [] arr) {
		int count = 1;
		int index = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[index]) {
				count++;
			}else {
				count--;
			}
			if(count == 0) {
				count = 1;
				index = i;
			}
		}
		if(isMajority(arr, arr[index])) {
			return arr[index];
		}
		return -1;
	}
	 
	// Is given element is Majority or not???  --> count>n/2
	public boolean isMajority(int [] arr,int elem) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==elem) {
				count++;
			}
		}
		if(count>arr.length/2) {
			return true;
		}
		return false;
	}
	
	// Maximum contigous Sub Array --> Kadane's Algo (DP)
	public int maxSubArraySum(int [] arr) {
		int curr_max = arr[0];
		int final_max = arr[0];
		for(int i=1;i<arr.length;i++) {
			curr_max = Math.max(arr[i],curr_max+arr[i]);
			final_max = Math.max(curr_max,final_max);
		}
		return final_max;
	}
	
	// Merge Two Sorted Arrays  --> merging() in merge sort
	public int[] mergeArrays(int []a,int [] b) {
		int m = a.length;
		int n = b.length;
		int [] c = new int[m+n];
		int i=0;
		int j=0;
		int k=0;
		while(i<m && j<n) {
			if(a[i]<=b[j]) {
				c[k++] = a[i++];
			}else {
				c[k++] = b[j++];
			}
		}
		while(i<m) {
			c[k++] = a[i++];
		}
		while(j<n) {
			c[k++] = b[j++];
		}
		
		return c;	
	}
	
	//Merge an array of size n into another array of size m+n  
	public void mergeSizeArray(int[]a,int[]b) {
		moveEnd(a);
		int n = b.length;
		int m = a.length-n;
		// Holds a curr index
		int i=n;  
		// Holds b curr index
		int j=0;
		// Holds final Array curr index
		int k = 0;
		while(k<m+n) {
			if( (i<m+n &&a[i]<=b[j]) || j==n) {
				a[k++] = a[i++];
			}else {
				a[k++] = b[j++];
			}
		}
	}
	
	//Util fn : To move an arr to end of array
	private void moveEnd(int [] arr) {
		int j = arr.length-1;
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]!=-1) {
				arr[j--] = arr[i];
			}
		}
	}
	
	//Reversal algorithm for array rotation  --> Straight fwd
	public void ReverseByD(int [] arr,int d) {
		int [] temp = new int[d];
		for(int i=0;i<d;i++) {
			temp[i] = arr[i];
		}
		for(int i=0;i<arr.length-d;i++) {
			arr[i] = arr[i+d];
		}
		int j = 0;
		for(int i=arr.length-d;i<arr.length;i++) {
			arr[i] = temp[j++];
		}
	}
	
	//Leaders in an array --> Reverse Finding
	public void printLeaders(int[] arr) {
		int max = arr[arr.length-1];
		List<Integer> list = new ArrayList<>();
		list.add(max);
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]>max) {
				max =arr[i];
				list.add(max);
			}
		}
		Collections.reverse(list);
		for(Integer elem : list) {
			System.out.print(elem+" ");
		}
		System.out.println();
	}
	
	// Majority Element in sorted Array  --> comparing curr with n/2 elem in Array
	public boolean majoritySorted(int[] arr) {
		int n = arr.length/2;
		n = (n%2!=0)? n/2 :(n/2)+1;
		for(int i=0;i<n;i++) {
			if(arr[i]==arr[n+i]) {
				return true;
			}
		}
		return false;
	}
	
	// Segregate 1's and 0's in an Array --> Pivot Element finding based apporach in Quick Sort
	public void segregateArray(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		while(low<high) {
			while(arr[low]!=1) {
				low++;
			}
			while(arr[high]!=0) {
				high--;
			}
			if(low<high) {
				arr[low++] = 0;
				arr[high--] = 1;
			}
		}
	}
	
	//Find duplicates in Array
	public void findDuplicates(int[] arr) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(hs.contains(arr[i])) {
				System.out.print(arr[i]+" ");
			}else {
				hs.add(arr[i]);
			}
		}
	}
	
	//Find duplicates in Array --> Special case: 0<=element<size
	public void findDuplicatesSpl(int [] arr) {
		boolean flag = true;
		for(int i=0;i<arr.length;i++) {
			int curr = Math.abs(arr[i]);
			if(arr[curr]>=0) {
				arr[curr] = -arr[curr];
			}else {
				flag = false;
				System.out.print(curr+" ");
			}
		}
		if(flag) {
			System.out.println(-1);
		}
	}
	
	//Find the smallest missing number : Sorted Array --> Normal Linear Search
	public int missingSmall(int [] arr) {
		int min = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=min) {
				min++;
			}else {
				return min;
			}
		}
		return arr.length;
	}
	
	//Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
	public int MaxDiffIndex(int[] arr) {
		int i = 0;
		int j = arr.length-1;
		while(i<j) {
			if(arr[j]>arr[i]) {
				return j-i;
			}
			j--;
		}
		return -1;
	}
	
	//Find subarray with given sum
	public void subArraySum(int[] arr, int sum) {
		int start = 0;
		int curr = arr[0];
		for(int i=1;i<=arr.length;i++) {
			while(curr>sum && start<i-1) {
				curr=curr-arr[start];
				start++;
			}
			if(sum==curr) {
				int p = i-1;
				System.out.println("Array Found between "+ start +" And "+p);
				return;
			}
			if(i<arr.length) {
				curr+=arr[i];
			}
		}
		System.out.println("No Sub Array Found");
	}
	
	//Find the smallest positive number missing from an unsorted array
	public int missingPosNum(int[] arr) {
		if(arr.length==1 && arr[0]>1) {
			return 1;
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			hs.add(arr[i]);
		}
		for(int i=1;i<arr.length;i++) {
			if(!hs.contains(i)) {
				return i;
			}
		}
		return arr.length+1;
	}
	
	// Change Element By RightMost Leader
	public void changeByLeader(int[] a) {
		int max = -1;
		for(int i=a.length-1;i>=0;i--) {
			int temp = max;
			max = Math.max(max, a[i]);
			a[i] = temp;
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	// Longest Equal binary SubArray Length
	public int MaxBinarySubArray(int[] a) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		map.put(0,-1);
		int sum = 0;
		int len = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				sum-=1;
			}else {
				sum+=1;
			}
			if(map.containsKey(sum)) {
				len = Math.max(len,i-map.get(sum));
			}else {
				map.put(sum,i);
			}
		}
		return len;
	}
	
	// Find the two numbers with odd occurrences in an unsorted array
	public void oddOccurrrences(int [] a) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++) {
			if(map.containsKey(a[i])) {
				int val = map.get(a[i]);
				map.put(a[i],++val);
			}else {
				map.put(a[i],1);
			}
		}
		
		for(Entry<Integer,Integer> entry: map.entrySet()) {
			if(entry.getValue()%2!=0) {
				System.out.print(entry.getKey()+" ");
			}
		}
		
	}
	
	// Sort 0's 1's 2's in an Array
	public void sortElements(int[] a) {
		int low = 0;
		int high = a.length-1;
		int mid = 0;
		int temp = 0;
		while(mid<=high) {
			if(a[mid]==0) {
				temp= a[mid];
				a[mid] = a[low];
				a[low] = temp;
				low++;
				mid++;
			}
			else if(a[mid]==1) {
				mid++;
			}
			else if(a[mid]==2) {
				temp = a[mid];
				a[mid] = a[high];
				a[high] = temp;
				high--;
			}
		}
	}
	
	//Largest Rectangle in a Histogram -- BruteForce/Naive Apporach
	private int largestAreaBruteForce(int[] a) {
		int maxArea = 0;
		for(int i=0;i<a.length;i++) {
			int count = 0;
			int j = i;
			while(j>=0 && a[j]>=a[i]) {
				j--;
				count++;
			}
			j = i;
			while(j<a.length && a[j]>=a[i]) {
				j++;
				count++;
			}
			--count;
			int area = a[i]*count;
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}
	
	//Largest Rectangle in a Histogram
	public int largestArea(int[] hist) {
		Stack<Integer> st = new Stack<>();
		int maxArea = 0;
		int i = 0;
		while(i<hist.length) {
			if(st.isEmpty() || hist[st.peek()]<=hist[i]) {
				st.add(i);
				i++;
			}else {
				int curr = st.pop();
				int val = (st.isEmpty())? (i-1) : (i-1-st.peek());
				int area = hist[curr]* val;
				maxArea = Math.max(area, maxArea);
			}
		}
		while(!st.isEmpty()) {
			int curr = st.pop();
			int val = (st.isEmpty())? (i-1) : (i-1-st.peek());
			int area = hist[curr]* val;
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}
	
	
}




/*  Online Editor Routine Code
 * 
 * Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t!=0){
	        t--;
	        int n = sc.nextInt();
	        int [] a = new int[n];
	        for(int i=0;i<n;i++){
	            a[i] = sc.nextInt();
	        }
	    }
	       System.out.println(majorityElement(a));
	    }*/
