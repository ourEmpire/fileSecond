package mySort;

public class SelectionSort {		//ѡ������
	public void seletionSort(int[] arr) {
		for(int i = 0;i < arr.length;i++) {			//�������е�����
			int index = i;							//��¼��i�����ݵ�λ��
			for(int j = i;j < arr.length;j++) {		//����i�Ժ����������
				if(arr[index] > arr[j]) {			//�������ݱ�arr[index]Сʱ��¼�������λ��
					index = j;
				}
			}
			if(index != i) {						//��index��=iʱ˵����i��������С�ģ��������ݣ�С����ǰ��
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
		
	}

}
