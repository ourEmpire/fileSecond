package mySort;

public class QuickSort {				//��������	���ݵ�������
	public void quickSort(int[] arr,int start,int end) {
		if(start >= end) return;				//�����ֻʣһ����ʱ�����ݹ�
		int standard = arr[start];   			//��׼��
		int left = start;						//��¼��ߵ����൱��һ�������Ƶ�ָ��
		int right = end;						//��¼�ұߵ����൱��һ�������Ƶ�ָ��	
		while(left < right) {					//�����ݷֳ�С�ڱ�׼���ʹ��ڱ�׼����������
			while(left < right && arr[right] >= standard) {	//���ұߵ������ڵ��ڱ�׼��ʱright����
				right--;
			}
			arr[left] = arr[right];							//���ұߵ���С�ڱ�׼��ʱ���ұߵ�����ֵ����ߵ���
			while(left < right && arr[left] <= standard) {	//����ߵ���С�ڵ��ڱ�׼��ʱleft����
				left++;
			}
			arr[right] = arr[left]; 						//����ߵ������ڱ�׼��ʱ����ߵ�����ֵ���ұߵ���
		}
		arr[left] = standard;								//��left == right ʱ����׼������������		
		quickSort(arr,start,left);							//�ݹ���С�ڱ�׼���Ĳ���
		quickSort(arr,right+1,end);							//�ݹ��Ŵ��ڱ�׼���Ĳ���
	}
}