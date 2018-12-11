package dataStructuresAndAlgorithms.test;

import dataStructuresAndAlgorithms.DoubleCycleNode;

public class TestDoubleCycleNode {
	public static void main(String[] args) {
		//�����ڵ�
		DoubleCycleNode n1 = new DoubleCycleNode(1);
		DoubleCycleNode n2 = new DoubleCycleNode(2);
		DoubleCycleNode n3 = new DoubleCycleNode(3);
		//���Ӹ��ڵ�
		n1.insertNode(n2);
		n2.insertNode(n3);
		//��ӡ�ڵ������
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
