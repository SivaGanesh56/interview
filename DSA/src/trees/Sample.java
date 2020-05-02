package trees;

public class Sample {
	
	public static void main(String[] args) {
		int[]arr={6,5,8,9,3,10,15,12,16};
		quicksort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public  static void quicksort(int[]arr,int low,int high){
		if(low<high){
			int p=partition(arr, low, high);
			quicksort(arr, low, p);
			quicksort(arr,p+1,high);
		}
	}
	
	public static int partition(int[] arr,int low,int high){
		int pivot=arr[low];
		int i,j;
		i=low;
		j=high;
		while(i<j){
			
			do{
				i++;
			}while(arr[i]<=pivot);
			
			do{
				j--;
			}while(arr[j]>pivot);
			
			if(i<j){
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[low];
		arr[low]=arr[j];
		arr[j]=temp;
		return j;
	}
	
	
}
