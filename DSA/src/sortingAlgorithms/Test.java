package sortingAlgorithms;

public class Test {
	public static void main(String[] args) {
		int[]arr={6,5,8,9,3,10,15,12,16,1,33,131};
		//{4,5,1,3,2};
		//QuickSort quicksort = new QuickSort();
		//quicksort.sort(arr,0,arr.length-1);
//		BubbleSort bubbleSort = new  BubbleSort();
////		bubbleSort.sort(arr);
//		bubbleSort.recursivelySort(arr);
//		SelectionSort selectionSort = new SelectionSort();
//		selectionSort.sort(arr);
//		InsertionSort insertionSort = new InsertionSort();
//		insertionSort.sort(arr);
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
