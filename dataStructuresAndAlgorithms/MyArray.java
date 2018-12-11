/*
 * use for array
 */

package dataStructuresAndAlgorithms;

import java.lang.RuntimeException;
import java.util.Arrays;

public class MyArray {			
	private int[] arr;
	public MyArray() {
		arr = new int[0];
	}
	
	
	public void show() {						//查看数组中的元素
		System.out.println(Arrays.toString(arr));
	}
	
	public void add(int element) {				//倒叙插入元素
		int[] newArr = new int[arr.length+1];	//创建一个新组
		for(int i = 0;i < arr.length;i++) {		//将原数组复制到新数组中
			newArr[i] = arr[i];
		}
		newArr[arr.length] = element;			//将要插入的元素放到新数组的最后一个
		arr = newArr; 							//将新数组复制给原数组		
	}				
	
	public void deleteElement(int index) throws RuntimeException{		//删除第index个元素
		int[] newArr = new int[arr.length-1];
		if(index < 0 || index > newArr.length) {	//判断下标是否越界
			throw new RuntimeException("下标越界！");
		}
		for(int i = 0;i < newArr.length;i++) {
			if(i < index) {							//在原数组第index之前的元素直接复制给新数组
				newArr[i] = arr[i];
			}else {									//跳过第index个元素
				newArr[i] = arr[i+1];
			}
		}
		arr = newArr;
	}
	
	public void insertElement(int index,int element) throws RuntimeException{ //将元素element插入到第index个位置
		int[] newArr = new int[arr.length+1];
		if(index < 0 || index > arr.length) {
			throw new RuntimeException("下标越界！");
		}
		for(int i = 0;i < arr.length;i++) {		//将原数组复制给新数组，空出第index个位置
			if(i < index) {
				newArr[i] = arr[i];
			}else {
				newArr[i+1] = arr[i];
			}
		}
		newArr[index] = element;				//将element放入新数组的第index个位置
		arr = newArr;
	}
	
	public int getLength() {					//返回数组长度
		return arr.length;
	}
	
	public int lineSearch(int element) {			//线性查找元素element，如果查到返回它的位置，没查到返回-1
		for(int i = 0;i < arr.length;i++) {
			if(arr[i] == element) return i;
		}
		return -1;
	}
	//二分查找数组必须是有序的，此二分查找按降序排列的
	public int binarySearch(int element) {		//二分查找元素element，如果查到返回它的位置，没查到返回-1
		int start = 0;
		int end = arr.length - 1;
		int index;
		while(true) {
			index = (start + end) / 2;
			if(start >= end) return -1;			//没找到元素element
			if(arr[index] == element) return index;	//元素element在第index位置
			if(arr[index] < element) {
				end = index - 1;				//元素element可能在index的后面
			}else {
				start = index + 1;				//元素element科能在index的前面
			}
		}
	}
}
