package mySort;

public class BubbleSort {					//ð������  ���ݵ�������
	public void bubbleSort(int[] arr) {
		for(int i = 0;i < arr.length - 1;i++) {		//Ҫ��arr.length-1��
			for(int j = 0;j < arr.length - 1 - i;j++) {//�����ݽ��бȽ�
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
