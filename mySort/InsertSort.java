package mySort;

public class InsertSort {				//ֱ�Ӳ�������
	public void insertSort(int[] arr) {
		for(int i = 1;i < arr.length;i++) {			//������������
			if(arr[i] < arr[i-1]) {				//����i��Ԫ��С�ڵ�i-1��Ԫ��
				int temp = arr[i];				//��¼��ǰ��Ԫ��С���Ǹ�����
				int j;
				for(j = i;j > 0 && temp < arr[j-1];j--) {				//����i֮ǰ������
					arr[j] = arr[j-1];				//��j-1��������
				}
				arr[j] = temp;						//��
			}
		}
	}

}
