package dataStructuresAndAlgorithms;

public class CycleNode {		//ѭ������

	private int data;					//��¼��ǰ�ڵ������
	private CycleNode next = this;					//��¼�¸��ڵ�ĵ�ַ	
	
	public CycleNode(int data) {				//Ϊ��ǰ�ڵ�����ݸ�ֵ
		this.data = data;
	}
	
	
	public CycleNode nextNode() {		//������һ���ڵ�
		return this.next;
	}
	
	public int getData() {			//�õ���ǰ�ڵ������
		return this.data;
	}
	
	public void insertNode(CycleNode node) {		//����һ���ڵ�
		CycleNode current = this;				//���õ�ǰ�ڵ�
		node.next = current.next;			//���浱ǰ�ڵ���¸��ڵ�
		current.next = node;				//����ǰ�ڵ���¸��ڵ�����ΪҪ����Ľڵ�
	}
	
	public int delete() {					//ɾ��һ���ڵ㲢����ɾ���ڵ������
		int deleteData = this.next.data;
		this.next = this.next.next; 		//�õ�ǰ�ڵ���¸��ڵ�������¸��ڵ㣬��ɾ����ǰ�ڵ���¸��ڵ�
		return deleteData;
	}
}