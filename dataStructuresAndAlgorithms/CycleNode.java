package dataStructuresAndAlgorithms;

public class CycleNode {		//循环链表

	private int data;					//记录当前节点的数据
	private CycleNode next = this;					//记录下个节点的地址	
	
	public CycleNode(int data) {				//为当前节点的数据赋值
		this.data = data;
	}
	
	
	public CycleNode nextNode() {		//查找下一个节点
		return this.next;
	}
	
	public int getData() {			//得到当前节点的数据
		return this.data;
	}
	
	public void insertNode(CycleNode node) {		//插入一个节点
		CycleNode current = this;				//设置当前节点
		node.next = current.next;			//保存当前节点的下个节点
		current.next = node;				//将当前节点的下个节点设置为要插入的节点
	}
	
	public int delete() {					//删除一个节点并返回删除节点的数据
		int deleteData = this.next.data;
		this.next = this.next.next; 		//让当前节点的下个节点等于下下个节点，即删除当前节点的下个节点
		return deleteData;
	}
}