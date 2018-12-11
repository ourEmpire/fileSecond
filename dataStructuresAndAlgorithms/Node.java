package dataStructuresAndAlgorithms;

public class Node {				//创建一个节点
	private int data;					//记录当前节点的数据
	private Node next;					//记录下个节点的地址	
	
	public Node(int data) {				//为当前节点的数据赋值
		this.data = data;
	}
	
	public Node add(Node node) {	//追加节点
		Node currentNode = this; 			//设置当前节点
		while(true){		
			Node nextNode = currentNode.next; 	//设置下节点
			if(nextNode == null) {				//当前节点是最后一个节点
				break;
			}
			currentNode = nextNode;				//当前节点后移
		}
		currentNode.next = node;
		return this;
	}
	
	public Node nextNode() {		//查找下一个节点
		return this.next;
	}
	
	public int getData() {			//得到当前节点的数据
		return this.data;
	}
	
	public boolean isLast() {		//判断当前节点是否为最后一个节点
		return this.next == null;
	}
	
	public void insertNode(Node node) {		//插入一个节点
		Node current = this;				//设置当前节点
		node.next = current.next;			//保存当前节点的下个节点
		current.next = node;				//将当前节点的下个节点设置为要插入的节点
	}
	
	public int delete() {					//删除一个节点并返回删除节点的数据
		int deleteData = this.next.data;
		this.next = this.next.next; 		//让当前节点的下个节点等于下下个节点，即删除当前节点的下个节点
		return deleteData;
	}
	
	
}
