package sortingAlgorithms;

public class SelectionSort {
	public void sort(int[] arr){
		int n = arr.length;
		for(int i=0;i<n-1;i++){
			int min=i;
			int j = i+1;
			while(j<n){
				if(arr[j]<arr[min]){
					min=j;
				}
				j++;
			}
			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
	}

}
