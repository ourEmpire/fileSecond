/*
 * use for stack
 */
package dataStructuresAndAlgorithms;

import java.lang.RuntimeException;

public class MyStack {			
	//�ҵĵײ����������洢����
	int[] stack;
	public MyStack() {
		stack = new int[0];
	}
	
	public void add(int element) {			//������ѹ��ջ��
		int[] newStack = new int[stack.length+1];
		for(int i = 0;i < stack.length;i++) {
			newStack[i] = stack[i];
		}
		newStack[stack.length] = element;	//��Ԫ��element�ŵ���ջ��
		stack = newStack;					//����ջ���Ƹ�ԭջ
	}
	
	public int pop() throws RuntimeException{			//ȡ��ջ��Ԫ��
		int element;
		if(stack.length == 0) {	//ջΪ��
			throw new RuntimeException("ջΪ�գ�");
		}
		int[] newStack = new int[stack.length-1];
		for(int i = 0;i < newStack.length;i++) {		//ɾ�����һ��Ԫ��
			newStack[i] = stack[i];
		}
		element = stack[stack.length-1];
		stack = newStack;
		return element;
	}
	
	public int peek() {									//�鿴ջ��Ԫ��
		return stack[stack.length-1];
	}
	
	public boolean isEmpty() {							//�ж�ջ�Ƿ�Ϊ��
		return stack.length == 0;
	}
}
