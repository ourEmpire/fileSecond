package dataStructuresAndAlgorithms;

import java.lang.RuntimeException;
import java.util.Arrays;

public class MyQueue {
	private int[] queue;
	
	public MyQueue() {
		queue = new int[0];
	}
	
	public void add(int element) {			//��Ԫ��ѹ�����
		int[] newQueue = new int[queue.length+1];
		for(int i = 0;i < queue.length;i++) {
			newQueue[i] = queue[i]; 
		}
		newQueue[queue.length] = element;
		queue = newQueue;
	}
	
	public int pop() throws RuntimeException {			//���Ӳ���element����
		if(queue.length == 0) {
			throw new RuntimeException("the queue is empty!");
		}
		int element = queue[0];
		int[] newQueue = new int[queue.length-1];
		for(int i = 0;i < newQueue.length;i++) {
			newQueue[i] = queue[i+1];
		}
		queue = newQueue;
		return element;
	}
	
	public void show() {									//�鿴���е�Ԫ��
		System.out.println(Arrays.toString(queue));
	}

	
	public Boolean isEmpty() {								//�鿴���Ƿ�Ϊ��
		return queue.length == 0;
	}
}
