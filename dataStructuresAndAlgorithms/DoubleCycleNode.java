package dataStructuresAndAlgorithms;

public class DoubleCycleNode {			//双向循环链表
	private int data;					//记录数据
	private DoubleCycleNode before = this;		//记录前一个节点
	private DoubleCycleNode next = this;		//记录下一个节点
	
	public DoubleCycleNode(int data) {
		this.data = data;
	}
	
	public void insertNode(DoubleCycleNode node) {		//插入节点
		DoubleCycleNode recortNext = this.next;			//记录当前节点的下个节点
		this.next = node;								//将当前节点的下个节点设置为要插入的节点
		node.before = this;								//将当前节点设置为要插入节点的上一个节点
		node.next = recortNext;							//将要插入的节点的下个节点设置为记录的当前节点的下个节点
		recortNext.before = node;						//将记录的当前节点的下个节点的上一个节点设置为要插入的节点
	}
	
	public int deleteNode() {							//删除当前节点的下个节点并返回删除节点的数据
		int deleteData = this.next.data;				//记录删除节点的数据
		this.next = this.next.next;						//将当前节点的下个节点设置为当前节点的下下个节点
		this.next.before = this; 						//将当下下个节点的上个节点设置为当前节点
		return deleteData;
	}
	public int getData() {								//获取当前节点的数据
		return this.data;
	}
	
	public DoubleCycleNode beforeNode() {			//当前节点的上个节点
		return this.before;
	}
	
	public DoubleCycleNode nextNode() {				//当前节点的下个节点
		return this.next;
	}
}
