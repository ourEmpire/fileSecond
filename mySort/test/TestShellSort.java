package mySort.test;

import java.util.Arrays;

import mySort.ShellSort;

public class TestShellSort {
	public static void main(String[] args) {
		int[] arr = new int[] {32,43,5,4,23,65,1,34,5,47,0};
		System.out.println(Arrays.toString(arr));
		ShellSort ss = new ShellSort();
		ss.shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
