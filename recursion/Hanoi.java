package recursion;

public class Hanoi {			//��ŵ������
	public static void main(String[] args) {
		hanoi(3,'A','B','C');
	}
	/*
	 * n��ʾ�ж��ٸ�����
	 * from��ʾ��ʼ������
	 * in��ʾҪ����������
	 * to��ʾҪ�Ƶ�������
	 * 
	 */
	public static void hanoi(int n,char from,char in,char to) {			
		if(n == 1) {			//��ֻ��һ������ʱ
			System.out.println("�ѵ�"+n+"�����Ӵ�"+from+"�Ƶ�"+to);
		}else {					//����nΪ���ٶ����������֣�����Ŀ���һ������+��ײ�
			
			hanoi(n-1,from,to,in);		//���ϲ��ֵ������ƶ���Ҫ����������
			System.out.println("�ѵ�"+n+"�����Ӵ�"+from+"�Ƶ�"+to);		
			hanoi(n-1,in,from,to);		//���ϲ��ֵ����Ӵӽ����������ƶ���Ҫ�Ƶ�������
		}
	}
}
