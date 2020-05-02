package sortingAlgorithms;

public class BubbleSort {
	public void sort(int[]a){
		int n=a.length;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	
	public void recursivelySort(int[] arr){
		recursivelySort(arr,arr.length);
	}

	private void recursivelySort(int[] arr, int n) {
		if(n==1) return;
		
		for(int i=0;i<n-1;i++){
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		
		recursivelySort(arr,n-1);
		
	}
};
