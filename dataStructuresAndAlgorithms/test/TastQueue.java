package dataStructuresAndAlgorithms.test;

import dataStructuresAndAlgorithms.MyQueue;

public class TastQueue {
	public static void main(String[] args) {
		MyQueue mq = new MyQueue();
		mq.add(9);
		mq.add(8);
		mq.add(7);
		mq.add(6);
		mq.show();
		mq.pop();
		mq.show();
	}
}
