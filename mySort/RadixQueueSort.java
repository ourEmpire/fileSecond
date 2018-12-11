package mySort;

import dataStructuresAndAlgorithms.MyQueue;

public class RadixQueueSort {		//��������Ķ���ʵ��
	public void radixQueueSort(int[] arr) {
		//�ҵ�ԭ������������
		int max = arr[0];
		for(int i = 0;i < arr.length;i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();	//����������ж���λ
		for(int i = 0,count = 10;i < maxLength;i++,count *= 10) {		//Ҫ����maxLength�β���
			MyQueue[] temp = new MyQueue[10]; 	//����10������
			for(int j = 0;j < temp.length;j++) {//��ʼ������10������
				temp[j] = new MyQueue();
			}
			for(int k = 0;k < arr.length;k++) {				//�������������е�Ԫ��
			int ys = arr[k] % count / (count / 10);			//�õ�����arr�ĵ�i��Ԫ�صĸ�λ�ϵ���
			temp[ys].add(arr[k]);							//��ԭ�����Ԫ�طŵ���Ӧ�ĵ�ys��������
			}
			int index = 0;								//��¼ԭ������Ԫ�صĸ���
			for(int j = 0;j < 10;j++) {					//�������еĶ���
				while(!temp[j].isEmpty()) {				//�������е�������ԭ����
					arr[index] = temp[j].pop();
					index++;
				}
			}
		}
		
	}
}
