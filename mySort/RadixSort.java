package mySort;


public class RadixSort {			//基数排序
	public void radixSort(int[] arr) {
		int max = arr[0];					//查找数组中最大的数
		for(int i = 0;i < arr.length;i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();	//计算最大数有几位
		
		for(int i = 0,count = 10;i < maxLength;i++,count *= 10) {		//重复排序操作maxLength次		
			int[][] temp = new int[10][arr.length];						//创建一个临时数组来储存数据
			int[] counts = new int[10];									//创建一个数组记录temp[]数组中数据的个数
			for(int j = 0;j < arr.length;j++) {							//遍历数组中的所有数
				int ys = arr[j] % count / (count / 10);				//得到个数组的每个位数的数
				temp[ys][counts[ys]] = arr[j];						//将arr数组中的第j个数据时储存在temp的第ys个一维数组的第count[ys]
				counts[ys]++;										//记录temp[]数组的数据个数加1
			}
			int index = 0;		//记录arr数组存储数据的个数
			for(int j = 0;j < 10;j++) {							//挨个取出数组temp中的数据
				for(int k = 0;k < counts[j];k++) {							//数组temp[]中有元素就取出来
					arr[index] = temp[j][k];					
					index++;
				}
				counts[j] = 0;									//取完数据将counts置0
			}
		}
	}
}
