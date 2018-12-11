package mySort.test;

import java.util.Arrays;
import mySort.SelectionSort;

public class TeatSelectionSort {
	public static void main(String[] args) {
		int[] arr = new int[] {4,2,1,6,7,9,8,0,4,2,1,3};
		System.out.println(Arrays.toString(arr));
		SelectionSort ss = new SelectionSort();
		ss.seletionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
