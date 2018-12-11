package dataStructuresAndAlgorithms;

public class Node {				//����һ���ڵ�
	private int data;					//��¼��ǰ�ڵ������
	private Node next;					//��¼�¸��ڵ�ĵ�ַ	
	
	public Node(int data) {				//Ϊ��ǰ�ڵ�����ݸ�ֵ
		this.data = data;
	}
	
	public Node add(Node node) {	//׷�ӽڵ�
		Node currentNode = this; 			//���õ�ǰ�ڵ�
		while(true){		
			Node nextNode = currentNode.next; 	//�����½ڵ�
			if(nextNode == null) {				//��ǰ�ڵ������һ���ڵ�
				break;
			}
			currentNode = nextNode;				//��ǰ�ڵ����
		}
		currentNode.next = node;
		return this;
	}
	
	public Node nextNode() {		//������һ���ڵ�
		return this.next;
	}
	
	public int getData() {			//�õ���ǰ�ڵ������
		return this.data;
	}
	
	public boolean isLast() {		//�жϵ�ǰ�ڵ��Ƿ�Ϊ���һ���ڵ�
		return this.next == null;
	}
	
	public void insertNode(Node node) {		//����һ���ڵ�
		Node current = this;				//���õ�ǰ�ڵ�
		node.next = current.next;			//���浱ǰ�ڵ���¸��ڵ�
		current.next = node;				//����ǰ�ڵ���¸��ڵ�����ΪҪ����Ľڵ�
	}
	
	public int delete() {					//ɾ��һ���ڵ㲢����ɾ���ڵ������
		int deleteData = this.next.data;
		this.next = this.next.next; 		//�õ�ǰ�ڵ���¸��ڵ�������¸��ڵ㣬��ɾ����ǰ�ڵ���¸��ڵ�
		return deleteData;
	}
	
	
}
