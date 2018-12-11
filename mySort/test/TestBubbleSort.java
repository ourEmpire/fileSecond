package mySort.test;

import java.util.Arrays;
import mySort.BubbleSort;

public class TestBubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[] {32,1,42,54,57,687,86,54,3,8};
		System.out.println(Arrays.toString(arr));
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
