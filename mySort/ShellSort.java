package mySort;


public class ShellSort {				//ϣ������
	public void shellSort(int[] arr) {
		for(int step = arr.length / 2;step > 0;step /= 2) {		//�������еĲ���
			for(int i = step;i < arr.length;i++) {						//�������еķ���
				for(int j = i - step;j >= 0;j -= step) {			//����ÿ���е�����
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
