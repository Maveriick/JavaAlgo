/*
 * @author: Maverick
 */

public class LinkedList {
	public class Node {
		public Node(){
			info = 0;
			next = null;
		}
		
		public Node(Node next,int info){
			this.next = next;
			this.info = info;
		}
		
		public int info;
		public Node next;
	}
	
	//Constructor for the LinkedList Class
	public LinkedList(){
		head = tail = null;
	}

	//Add node to head
	public void addToHead(int value){
		if(head == null && tail == null){
			head = tail =  new Node(null,value);
		}
		else{
			Node temp = new Node(head,value);
			temp.next = head;
			head = temp;
		}
		length+=1;
	}
	
	//Add node to tail
	public void addToTail(int value){
		if(head == null && tail == null){
			tail = new Node(null,value);
			head = tail;
		}else{
			Node temp = new Node(null, value);
			tail.next = temp;
			tail = temp;
		}
		length+=1;
	}
	
	//Delete node at the head
	public void deleteFromHead(){
		if(length >= 1){
			Node temp = head;
			head = head.next;
			temp = null;
			length -=  1;
		}else{
			System.out.println("There is nothing in the list");
		}
	}
	
	
	//Delete Node at tail
	public void deleteFromTail(){
		if (head == tail){
			head = tail = null;
			length-=1;
		}else{
			Node temp = head;
			while(temp.next.next != null){
				temp = temp.next;
			}
			tail = temp;
			tail.next = null;
			length-=1;
		}
	}
	
	//Traverse linked list in order
	public void traverse(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.info + "->");
			temp = temp.next;
		}
	}
	
	public int getSize(){
		return length;
	}
	
	void swap(Node a,Node b){
		int temp = a.info;
		a.info = b.info;
		b.info = temp;
	}
	
	
	//Sort the linked list
	public void sortList(){
		Node tempOne;
		for(tempOne = head; tempOne!=null;tempOne=tempOne.next){
			Node min = tempOne;
			for(Node tempTwo = tempOne.next;tempTwo!=null;tempTwo = tempTwo.next ){
				if(tempTwo.info < min.info){
					min = tempTwo;
				}
			}
			if(min != tempOne){
				swap(min,tempOne);
			}
		}
	}
	
	//Insert node in sorted order
	public void insertSorted(int value){
		Node temp = head;
		while(temp.next.info < value){
			temp = temp.next;
		}
		Node toAdd = new Node(temp.next,value);
		temp.next = toAdd;
	}
	
	public void reverseList(){
		Node current = head;
		Node next;
		Node result = null;
		
		while(current!=null){
			next = current.next;
			current.next = result;
			result = current;
			current = next;
		}
		head = result;
	}
	
	public boolean hasLoop(){
		if(head == null){
			return false;
		}
		
		Node slow = head.next;
		if(slow == null){
			return false;
		}
		
		Node fast = slow.next;
		
		while(slow != null && fast!= null){
			if(slow == fast){
				return false;
			}
			slow = slow.next;
			fast = fast.next;
			
			if(fast!=null){
				fast = fast.next;
			}
		}
		
		return false;
		
	}
	
	Node head;
	Node tail;
	static int length;
	

}
