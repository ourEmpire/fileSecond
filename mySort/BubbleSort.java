package mySort;

public class BubbleSort {					//冒泡排序  数据递增排列
	public void bubbleSort(int[] arr) {
		for(int i = 0;i < arr.length - 1;i++) {		//要排arr.length-1轮
			for(int j = 0;j < arr.length - 1 - i;j++) {//对数据进行比较
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
