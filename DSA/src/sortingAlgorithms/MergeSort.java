package sortingAlgorithms;

public class MergeSort {
	
	public void sort(int[] arr){
		int n=arr.length;
		mergesort(arr,0,n-1);
	}
	
	private void mergesort(int[] arr, int low, int high) {
		if(low<high){
			int mid = low+(high-low)/2;
			mergesort(arr, low, mid);
			mergesort(arr, mid+1, high);
			merge(arr,low,mid,high);
		}
	}

	private static void merge(int[]arr,int low,int mid,int high){
		int n1=mid-low+1;
		int n2=high-mid;
		
		int []a= new int[n1];
		int []b= new int[n2];
		
		for(int i=0;i<n1;i++){
			a[i]=arr[low+i];
		}
		for(int i=0;i<n2;i++){
			b[i]=arr[mid+1+i];
		}
		
		int i=0,j=0,k=low;
		
		while(i<n1 && j<n2){
			if(a[i]<b[j]){
				arr[k++]=a[i++];
			}
			else{
				arr[k++]=b[j++];
			}
		}
		while(i<n1){
			arr[k++]=a[i++];
		}
		while(j<n2){
			arr[k++]=b[j++];
		}
	}
}
