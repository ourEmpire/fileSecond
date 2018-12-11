package mySort.test;
import java.util.Arrays;

import mySort.QuickSort;

public class TestQuickSort {
	public static void main(String[] args) {
		int[] arr = new int[] {32,42,45,22,45,6,3,1,787,45,0,7};
		System.out.println(Arrays.toString(arr));
		QuickSort qs = new QuickSort();
		qs.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
