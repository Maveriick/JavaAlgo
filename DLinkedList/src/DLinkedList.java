
public class DLinkedList {
	public class DNode{
		public DNode(){
			this.info = 0;
			this.next = null;
			this.previous = null;
			
		}
	
		public DNode(int info,DNode previous,DNode next){
			this.info = info;
			this.previous = previous;
			this.next = next;
		}
	
		int info;
		DNode next;
		DNode previous;
	}
	
	public DLinkedList(){
		head = tail = null;
	}
	
	public void addToHead(int info){
		if(head == null && tail == null){
			head = tail = new DNode(info,null,null);
		}else{
			DNode temp = new DNode(info,null,head);
			head.previous = temp;
			head = temp;
		}
		size++;
	}
	
	public void addToTail(int info){
		if(head == null && tail == null){
			head = tail = new DNode(info,null,null);
		}else{
			DNode temp = new DNode(info,tail,null);
			tail.next = temp;
			tail = temp;
		}
		size++;
	}
	
	public void removeFromHead(){
		if(head == tail){
			head = tail = null;
		}else{
			DNode temp = head;
			head = head.next;
			temp = null;
			head.previous = null;
		}
		size--;
	}
	
	public void removeFromTail(){
		if(head == tail){
			head = tail = null;
		}else{
			DNode temp = tail;
			tail = tail.previous;
			tail.next = null;
			temp = null;
		}
		size--;
	}
	
	public int getSize(){
		
		return size;
	}
	
	public void traverse(){
		DNode temp = head;
		while(temp!=null){
			System.out.print(temp.info + "->");
			temp = temp.next;
		}
	}
	DNode head;
	DNode tail;
	static int size;
	
	
}
