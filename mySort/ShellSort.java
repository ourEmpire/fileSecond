package mySort;


public class ShellSort {				//希尔排序
	public void shellSort(int[] arr) {
		for(int step = arr.length / 2;step > 0;step /= 2) {		//遍历所有的步长
			for(int i = step;i < arr.length;i++) {						//遍历所有的分组
				for(int j = i - step;j >= 0;j -= step) {			//遍历每组中的数据
					if(arr[j] > arr[j + step]) {
						int temp = arr[j];
						arr[j] = arr[j+step];
						arr[j+step] = temp;
						}		
				}
			}
			
		}
	}
}
