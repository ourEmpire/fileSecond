package mySort.test;
import java.util.Arrays;

import mySort.InsertSort;
public class TestInsertSort {
	public static void main(String[] args) {
		int[] arr = new int[] {2,12,43,6,4,8,53,87,42};
		System.out.println(Arrays.toString(arr));
		InsertSort is = new InsertSort();
		is.insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
