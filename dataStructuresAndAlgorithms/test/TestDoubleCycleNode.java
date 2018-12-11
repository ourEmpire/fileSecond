package dataStructuresAndAlgorithms.test;

import dataStructuresAndAlgorithms.DoubleCycleNode;

public class TestDoubleCycleNode {
	public static void main(String[] args) {
		//创建节点
		DoubleCycleNode n1 = new DoubleCycleNode(1);
		DoubleCycleNode n2 = new DoubleCycleNode(2);
		DoubleCycleNode n3 = new DoubleCycleNode(3);
		//连接各节点
		n1.insertNode(n2);
		n2.insertNode(n3);
		//打印节点的数据
		System.out.println(n1.nextNode().getData());
		System.out.println(n1.getData());
		System.out.println(n1.beforeNode().getData());
		int deleteData = n1.deleteNode();
		System.out.println("delete data = " + deleteData);
		System.out.println(n1.nextNode().getData());
		System.out.println(n1.getData());
		System.out.println(n1.beforeNode().getData());
	}
}
