package mySort;

import dataStructuresAndAlgorithms.MyQueue;

public class RadixQueueSort {		//基数排序的队列实现
	public void radixQueueSort(int[] arr) {
		//找到原数组中最大的数
		int max = arr[0];
		for(int i = 0;i < arr.length;i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();	//计算最大数有多少位
		for(int i = 0,count = 10;i < maxLength;i++,count *= 10) {		//要进行maxLength次操作
			MyQueue[] temp = new MyQueue[10]; 	//创建10个队列
			for(int j = 0;j < temp.length;j++) {//初始化这是10个队列
				temp[j] = new MyQueue();
			}
			for(int k = 0;k < arr.length;k++) {				//遍历数组中所有的元素
			int ys = arr[k] % count / (count / 10);			//得到数组arr的第i个元素的各位上的数
			temp[ys].add(arr[k]);							//将原数组的元素放到对应的第ys个队列中
			}
			int index = 0;								//记录原数组中元素的个数
			for(int j = 0;j < 10;j++) {					//遍历所有的队列
				while(!temp[j].isEmpty()) {				//将队列中的数赋给原数组
					arr[index] = temp[j].pop();
					index++;
				}
			}
		}
		
	}
}
