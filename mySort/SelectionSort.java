package mySort;

public class SelectionSort {		//选择排序
	public void seletionSort(int[] arr) {
		for(int i = 0;i < arr.length;i++) {			//遍历所有的数据
			int index = i;							//记录第i个数据的位置
			for(int j = i;j < arr.length;j++) {		//遍历i以后的所有数据
				if(arr[index] > arr[j]) {			//当有数据比arr[index]小时记录这个数的位置
					index = j;
				}
			}
			if(index != i) {						//当index！=i时说明第i个不是最小的，交换数据，小的数前移
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
		
	}

}
