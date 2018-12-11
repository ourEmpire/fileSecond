package mySort;

public class QuickSort {				//快速排序	数据递增排列
	public void quickSort(int[] arr,int start,int end) {
		if(start >= end) return;				//当最后只剩一个数时结束递归
		int standard = arr[start];   			//标准数
		int left = start;						//记录左边的数相当于一个向右移的指针
		int right = end;						//记录右边的数相当于一个向左移的指针	
		while(left < right) {					//将数据分成小于标准数和大于标准数的两部分
			while(left < right && arr[right] >= standard) {	//当右边的数大于等于标准数时right左移
				right--;
			}
			arr[left] = arr[right];							//当右边的数小于标准数时将右边的数赋值给左边的数
			while(left < right && arr[left] <= standard) {	//当左边的数小于等于标准数时left右移
				left++;
			}
			arr[right] = arr[left]; 						//当左边的数大于标准数时将左边的数赋值给右边的数
		}
		arr[left] = standard;								//当left == right 时将标准数插入数组中		
		quickSort(arr,start,left);							//递归排小于标准数的部分
		quickSort(arr,right+1,end);							//递归排大于标准数的部分
	}
}