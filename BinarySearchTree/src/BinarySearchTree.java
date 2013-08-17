import java.util.*;

public class BinarySearchTree {
	public class Node{
		public Node(){
			info = (Integer) null;
			left = right = null;
		}
		public Node(int info,Node left,Node right){
			this.info = info;
			this.left = left;
			this.right = right;
		}
		int info;
		Node left;
		Node right;
	}
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void addNode(int value){
		Node temp = root,prev = null;
		while(temp!=null){
			prev = temp;
			if(temp.info < value){
				temp = temp.right;
			}else{
				temp = temp.left;
			}
		}
		if(root == null){
			root = new Node(value,null,null);
		}else if(prev.info < value){
			prev.right = new Node(value,null,null);
		}else{
			prev.left = new Node(value,null,null);
		}
	}
	
	public void deleteNode(int value){
		
	}
	
	public void inOrder(){
		rInOrder(root);
	}
	
	public void rInOrder(Node root){
		if(root!=null){
			rInOrder(root.left);
			visit(root);
			rInOrder(root.right);
		}
	}
	
	public void preOrder(){
		rPreOrder(root);
	}
	
	public void rPreOrder(Node root){
		if(root!=null){
			visit(root);
			rPreOrder(root.left);
			rPreOrder(root.right);
		}
	}
	
	public void postOrder(){
		rPostOrder(root);
	}
	
	public void rPostOrder(Node root){
		if(root!=null){
			rPostOrder(root.left);
			rPostOrder(root.right);
			visit(root);
		}
	}
	
	public boolean search(int value){
		while(root!=null){
			if(root.info == value){
				return true;
			}else if(root.info < value){
				root = root.right;
			}else{
				root = root.left;
			}
		}
		return false;
	}
	
	public void iterInOrder(){
		Stack<Node> travStack = new Stack<Node>();
		Node temp = root;
		boolean done = false;
		while(!done){
			if(temp!=null){
				travStack.push(temp);
				temp = temp.left;
			}else{
				if(travStack.empty()){
					done = true;
				}else{
					temp = travStack.peek();
					travStack.pop();
					visit(temp);
					temp = temp.right;
				}
				
			}
		}
	}
	
	public void iterPostOrder(){
		Stack<Node> travStack = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();
		travStack.push(root);
		while(!travStack.empty()){
			Node temp = travStack.peek();
			output.push(temp);
			travStack.pop();
			if(temp.left!=null){
				travStack.push(temp.left);
			}
			if(temp.right!=null){
				travStack.push(temp.right);
			}
		}
		while(!output.empty()){
			Node curr = output.peek();
			visit(curr);
			output.pop();
		}
	}
	
	public void iterPreOrder(){
		Node temp = root;
		Stack<Node> traversalStack = new Stack<Node>();
		traversalStack.push(temp);
		while(!traversalStack.empty()){
			Node myNode = traversalStack.pop();
			visit(myNode);
			if(myNode.right!=null){
				traversalStack.push(myNode.right);
			}
			
			if(myNode.left!=null){
				traversalStack.push(myNode.left);
			}
		}
	}
	
	public void visit(Node toVisit){
		System.out.println(toVisit.info);
	}
	
	Node root;
	public static void main(String args[]){
		BinarySearchTree myTree = new BinarySearchTree();
		myTree.addNode(37);
		myTree.addNode(13);
		myTree.addNode(18);
		myTree.addNode(100);
		myTree.addNode(50);
		myTree.iterPreOrder();
	}
	
}

