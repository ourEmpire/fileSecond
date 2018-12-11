/*
 * use for stack
 */
package dataStructuresAndAlgorithms;

import java.lang.RuntimeException;

public class MyStack {			
	//找的底部用数组来存储数据
	int[] stack;
	public MyStack() {
		stack = new int[0];
	}
	
	public void add(int element) {			//将数据压入栈中
		int[] newStack = new int[stack.length+1];
		for(int i = 0;i < stack.length;i++) {
			newStack[i] = stack[i];
		}
		newStack[stack.length] = element;	//将元素element放到新栈中
		stack = newStack;					//将新栈复制给原栈
	}
	
	public int pop() throws RuntimeException{			//取出栈顶元素
		int element;
		if(stack.length == 0) {	//栈为空
			throw new RuntimeException("栈为空！");
		}
		int[] newStack = new int[stack.length-1];
		for(int i = 0;i < newStack.length;i++) {		//删除最后一个元素
			newStack[i] = stack[i];
		}
		element = stack[stack.length-1];
		stack = newStack;
		return element;
	}
	
	public int peek() {									//查看栈顶元素
		return stack[stack.length-1];
	}
	
	public boolean isEmpty() {							//判断栈是否为空
		return stack.length == 0;
	}
}
