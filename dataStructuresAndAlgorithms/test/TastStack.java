package dataStructuresAndAlgorithms.test;

import dataStructuresAndAlgorithms.MyStack;

public class TastStack {
	public static void main(String[] args) {
		MyStack ms = new MyStack();
		ms.add(1);
		System.out.println(ms.peek());
		
		ms.add(2);
		ms.add(3);
		ms.add(4);
		ms.pop();
		System.out.println("弹出的元素为："+ms.pop());
		System.out.println(ms.isEmpty());
		
	}
}
