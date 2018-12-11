package dataStructuresAndAlgorithms.test;

import dataStructuresAndAlgorithms.Node;

public class NodeTest {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.add(n2);
		n1.add(n3).add(new Node(4));
		System.out.println(n1.nextNode().nextNode().getData());
		System.out.println(n1.nextNode().nextNode().isLast());
		n1.nextNode().insertNode(new Node(10));		//��n2�����һ���ڵ�
		System.out.println(n1.nextNode().nextNode().getData());//��ӡ����Ԫ�ص�����
		int count = n1.nextNode().delete();
		System.out.println("delete data = " + count);
		System.out.println(n1.nextNode().nextNode().getData());
		
	}
}
