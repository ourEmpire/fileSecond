/*
 * use for array
 */

package dataStructuresAndAlgorithms;

import java.lang.RuntimeException;
import java.util.Arrays;

public class MyArray {			
	private int[] arr;
	public MyArray() {
		arr = new int[0];
	}
	
	
	public void show() {						//�鿴�����е�Ԫ��
		System.out.println(Arrays.toString(arr));
	}
	
	public void add(int element) {				//�������Ԫ��
		int[] newArr = new int[arr.length+1];	//����һ������
		for(int i = 0;i < arr.length;i++) {		//��ԭ���鸴�Ƶ���������
			newArr[i] = arr[i];
		}
		newArr[arr.length] = element;			//��Ҫ�����Ԫ�طŵ�����������һ��
		arr = newArr; 							//�������鸴�Ƹ�ԭ����		
	}				
	
	public void deleteElement(int index) throws RuntimeException{		//ɾ����index��Ԫ��
		int[] newArr = new int[arr.length-1];
		if(index < 0 || index > newArr.length) {	//�ж��±��Ƿ�Խ��
			throw new RuntimeException("�±�Խ�磡");
		}
		for(int i = 0;i < newArr.length;i++) {
			if(i < index) {							//��ԭ�����index֮ǰ��Ԫ��ֱ�Ӹ��Ƹ�������
				newArr[i] = arr[i];
			}else {									//������index��Ԫ��
				newArr[i] = arr[i+1];
			}
		}
		arr = newArr;
	}
	
	public void insertElement(int index,int element) throws RuntimeException{ //��Ԫ��element���뵽��index��λ��
		int[] newArr = new int[arr.length+1];
		if(index < 0 || index > arr.length) {
			throw new RuntimeException("�±�Խ�磡");
		}
		for(int i = 0;i < arr.length;i++) {		//��ԭ���鸴�Ƹ������飬�ճ���index��λ��
			if(i < index) {
				newArr[i] = arr[i];
			}else {
				newArr[i+1] = arr[i];
			}
		}
		newArr[index] = element;				//��element����������ĵ�index��λ��
		arr = newArr;
	}
	
	public int getLength() {					//�������鳤��
		return arr.length;
	}
	
	public int lineSearch(int element) {			//���Բ���Ԫ��element������鵽��������λ�ã�û�鵽����-1
		for(int i = 0;i < arr.length;i++) {
			if(arr[i] == element) return i;
		}
		return -1;
	}
	//���ֲ����������������ģ��˶��ֲ��Ұ��������е�
	public int binarySearch(int element) {		//���ֲ���Ԫ��element������鵽��������λ�ã�û�鵽����-1
		int start = 0;
		int end = arr.length - 1;
		int index;
		while(true) {
			index = (start + end) / 2;
			if(start >= end) return -1;			//û�ҵ�Ԫ��element
			if(arr[index] == element) return index;	//Ԫ��element�ڵ�indexλ��
			if(arr[index] < element) {
				end = index - 1;				//Ԫ��element������index�ĺ���
			}else {
				start = index + 1;				//Ԫ��element������index��ǰ��
			}
		}
	}
}
