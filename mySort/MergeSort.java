package mySort;

public class MergeSort {			//�鲢����
	public void mergeSort(int[] arr,int start,int end) {
		if(start >= end) return;				//�ݹ���������������еľͿ�ʼλ�ô��ڻ�С�ڽ���λ��ʱ
		int middle = (end + start) / 2;			//������ָ��������
		mergeSort(arr,start,middle);			//���Ϸָ���ߵ���
		mergeSort(arr,middle+1,end);			//���Ϸָ��ұߵ���
		merge(arr,start,middle,end);			//�ϲ�
	}
	private static void merge(int[] arr,int start,int middle,int end) { //�����������Ѿ����������ϲ�
		int[] newArr = new int[end - start + 1];	//����һ��������
		int i = start;								//middle���������±�
		int j = middle + 1;							//middle�ұ�������±�
		int index = 0;								//��������±�
		while(i <= middle && j <= end) {			//��ߵ��±겻��Խ��middle�ұߵ��±겻��Խ��end
													//������ߵĺ��ұߵ�˭С˭����������	
			if(arr[i] < arr[j]) {					//��ߵ���С
				newArr[index] = arr[i];
				i++;								//��ߵ��±����
				index++;							//�������±����
			}else {									//�ұߵ���С
				newArr[index] = arr[j];
				j++;								//�ұߵ��±����
				index++;							
			}
		}
		//��ʣ�����������������
		while(i <= middle) {						//������黹������
			newArr[index] = arr[i];	
			i++;
			index++;
		}
		while(j <= end) {							//�ұ߻�������
			newArr[index] = arr[j];
			j++;
			index++;
		}
		
		for(int k = 0;k < newArr.length;k++) {		//��newArr�������Ƶ�ԭ������
			arr[start+k] = newArr[k];
		}
	}
}
