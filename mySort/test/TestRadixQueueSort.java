package mySort.test;

import java.util.Arrays;

import mySort.RadixQueueSort;

public class TestRadixQueueSort {
	public static void main(String[] args) {
		int[] arr = new int[] {13,34,46,58,52,2,3,46,85687,34,56,856,324,3};
		System.out.println(Arrays.toString(arr));
		RadixQueueSort rqs = new RadixQueueSort();
		rqs.radixQueueSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
