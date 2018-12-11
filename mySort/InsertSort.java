package mySort;

public class InsertSort {				//直接插入排序
	public void insertSort(int[] arr) {
		for(int i = 1;i < arr.length;i++) {			//遍历所有数据
			if(arr[i] < arr[i-1]) {				//当第i个元素小于第i-1个元素
				int temp = arr[i];				//记录比前个元素小的那个数据
				int j;
				for(j = i;j > 0 && temp < arr[j-1];j--) {				//遍历i之前的数据
					arr[j] = arr[j-1];				//将j-1个数后移
				}
				arr[j] = temp;						//将
			}
		}
	}

}
