package dataStructuresAndAlgorithms;

public class DoubleCycleNode {			//˫��ѭ������
	private int data;					//��¼����
	private DoubleCycleNode before = this;		//��¼ǰһ���ڵ�
	private DoubleCycleNode next = this;		//��¼��һ���ڵ�
	
	public DoubleCycleNode(int data) {
		this.data = data;
	}
	
	public void insertNode(DoubleCycleNode node) {		//����ڵ�
		DoubleCycleNode recortNext = this.next;			//��¼��ǰ�ڵ���¸��ڵ�
		this.next = node;								//����ǰ�ڵ���¸��ڵ�����ΪҪ����Ľڵ�
		node.before = this;								//����ǰ�ڵ�����ΪҪ����ڵ����һ���ڵ�
		node.next = recortNext;							//��Ҫ����Ľڵ���¸��ڵ�����Ϊ��¼�ĵ�ǰ�ڵ���¸��ڵ�
		recortNext.before = node;						//����¼�ĵ�ǰ�ڵ���¸��ڵ����һ���ڵ�����ΪҪ����Ľڵ�
	}
	
	public int deleteNode() {							//ɾ����ǰ�ڵ���¸��ڵ㲢����ɾ���ڵ������
		int deleteData = this.next.data;				//��¼ɾ���ڵ������
		this.next = this.next.next;						//����ǰ�ڵ���¸��ڵ�����Ϊ��ǰ�ڵ�����¸��ڵ�
		this.next.before = this; 						//�������¸��ڵ���ϸ��ڵ�����Ϊ��ǰ�ڵ�
		return deleteData;
	}
	public int getData() {								//��ȡ��ǰ�ڵ������
		return this.data;
	}
	
	public DoubleCycleNode beforeNode() {			//��ǰ�ڵ���ϸ��ڵ�
		return this.before;
	}
	
	public DoubleCycleNode nextNode() {				//��ǰ�ڵ���¸��ڵ�
		return this.next;
	}
}
