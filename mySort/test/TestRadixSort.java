package mySort.test;

import java.util.Arrays;

import mySort.RadixSort;

public class TestRadixSort {
	public static void main(String[] args) {
		int[] arr = new int[] {1,65,34,7,7890,5,45,76,879,434};
		System.out.println(Arrays.toString(arr));
		RadixSort rs = new RadixSort();
		rs.radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
