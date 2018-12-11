package mySort;

public class MergeSort {			//归并排序
	public void mergeSort(int[] arr,int start,int end) {
		if(start >= end) return;				//递归结束条件，当排列的就开始位置大于或小于结束位置时
		int middle = (end + start) / 2;			//将数组分割成两部分
		mergeSort(arr,start,middle);			//不断分割左边的数
		mergeSort(arr,middle+1,end);			//不断分割右边的数
		merge(arr,start,middle,end);			//合并
	}
	private static void merge(int[] arr,int start,int middle,int end) { //将左右两边已经有序的数组合并
		int[] newArr = new int[end - start + 1];	//创建一个新数组
		int i = start;								//middle左边数组的下标
		int j = middle + 1;							//middle右边数组的下标
		int index = 0;								//新数组的下标
		while(i <= middle && j <= end) {			//左边的下标不能越过middle右边得下标不能越过end
													//并且左边的和右边的谁小谁放入新数组	
			if(arr[i] < arr[j]) {					//左边的数小
				newArr[index] = arr[i];
				i++;								//左边的下标后移
				index++;							//新数组下标后移
			}else {									//右边的数小
				newArr[index] = arr[j];
				j++;								//右边的下标后移
				index++;							
			}
		}
		//将剩余的数放入新数组中
		while(i <= middle) {						//左边数组还有数字
			newArr[index] = arr[i];	
			i++;
			index++;
		}
		while(j <= end) {							//右边还有数字
			newArr[index] = arr[j];
			j++;
			index++;
		}
		
		for(int k = 0;k < newArr.length;k++) {		//将newArr的数复制到原数组中
			arr[start+k] = newArr[k];
		}
	}
}
