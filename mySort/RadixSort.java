package mySort;


public class RadixSort {			//��������
	public void radixSort(int[] arr) {
		int max = arr[0];					//����������������
		for(int i = 0;i < arr.length;i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();	//����������м�λ
		
		for(int i = 0,count = 10;i < maxLength;i++,count *= 10) {		//�ظ��������maxLength��		
			int[][] temp = new int[10][arr.length];						//����һ����ʱ��������������
			int[] counts = new int[10];									//����һ�������¼temp[]���������ݵĸ���
			for(int j = 0;j < arr.length;j++) {							//���������е�������
				int ys = arr[j] % count / (count / 10);				//�õ��������ÿ��λ������
				temp[ys][counts[ys]] = arr[j];						//��arr�����еĵ�j������ʱ������temp�ĵ�ys��һά����ĵ�count[ys]
				counts[ys]++;										//��¼temp[]��������ݸ�����1
			}
			int index = 0;		//��¼arr����洢���ݵĸ���
			for(int j = 0;j < 10;j++) {							//����ȡ������temp�е�����
				for(int k = 0;k < counts[j];k++) {							//����temp[]����Ԫ�ؾ�ȡ����
					arr[index] = temp[j][k];					
					index++;
				}
				counts[j] = 0;									//ȡ�����ݽ�counts��0
			}
		}
	}
}
