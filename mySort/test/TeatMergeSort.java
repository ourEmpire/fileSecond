package mySort.test;

import java.util.Arrays;
import mySort.MergeSort;

public class TeatMergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] {3,1,2,7,9,4,2,6,5,1};
		System.out.println(Arrays.toString(arr));
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
