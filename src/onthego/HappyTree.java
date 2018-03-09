package onthego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HappyTree {
	
	static class Node<T> {

		T element;
		Node<T> left;
		Node<T> right;


		public Node() {
			element = null;
			left = null;
			right = null;
		}

		public Node(T element) {
			this.element = element;
		}

		public T getElement() {
			return (T) this.element;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}
		
		public Node<T> getLeft() {
			return left;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}
		
		public Node<T> getRight() {
			return right;
		}
	}
	
	static class NotSelfBalancedBinaryTree<T extends Comparable<T>> {

		Node<T> head;
		int size;
		
		public NotSelfBalancedBinaryTree () {
			head = null;
			size = 0;
		}
		
		public void add(T value) {
			Node<T> node = new Node<>(value);
			if(head == null) {
				head = node;
				size ++;
				return;
			}
			
			Node<T> current = head; 
			while(current != null) {
				int comparison = value.compareTo(current.getElement());
				if(comparison > 0 && current.getRight() == null) {
					current.setRight(node);
					current = null;
					size ++;
				}
				else if(comparison > 0) {
					current = current.getRight();
				}
				else if(comparison < 0 && current.getLeft() == null) {
					current.setLeft(node);
					current = null;
					size ++;
				}
				else if(comparison < 0) {
					current = current.getLeft();
				}
			}
		}
		
		
		public Node<T> find(T value) {
			Node<T> current = head; 
			while(current != null) {
				int comparison = value.compareTo(current.getElement());
				if(comparison > 0) {
					current = current.getRight();
				}
				else if(comparison < 0) {
					current = current.getLeft();
				}
				else {
					return current;
				}
			}
			return null;
		}
		
		public Queue<Node<T>> findPathTo(T value) {
			Queue<Node<T>> queue = new LinkedList<>();
			Node<T> current = head; 
			while(current != null) {
				queue.add(current);
				int comparison = value.compareTo(current.getElement());
				if(comparison > 0) {
					current = current.getRight();
				}
				else if(comparison < 0) {
					current = current.getLeft();
				}
				else {
					return queue;
				}
			}
			return null;
		}
		
		public T findLeastCommonAncestor(T n1, T n2) {
			Queue<Node<T>> q1 = findPathTo(n1);
			Queue<Node<T>> q2 = findPathTo(n2);
			T ancestor = null;
			while(q1.size() > 0 && q2.size() > 0) {
				Node<T> node1 = q1.poll();
				Node<T> node2 = q2.poll();
				if(node1 == node2) {
					ancestor = node1.getElement();
				}
			}
			return ancestor;
		}
		
		
		public void traverseDepthPreOrder() {
			traverseDepthPreOrder(head);
		}
		
		public void traverseDepthPreOrder(Node<T> node) {
			if(node == null) {
				return;
			}
			System.out.print(node.getElement().toString() + " ");
			traverseDepthPreOrder(node.getLeft());
			traverseDepthPreOrder(node.getRight());
		}
		

		public void traverseDepthInOrder() {
			traverseDepthInOrder(head);
		}
		
		public void traverseDepthInOrder(Node<T> node) {
			if(node == null) {
				return;
			}
			traverseDepthInOrder(node.getLeft());
			System.out.print(node.getElement().toString() + " ");
			traverseDepthInOrder(node.getRight());
		}
		

		public void traverseDepthPostOrder() {
			traverseDepthPostOrder(head);
		}
		
		public void traverseDepthPostOrder(Node<T> node) {
			if(node == null) {
				return;
			}
			traverseDepthPostOrder(node.getLeft());
			traverseDepthPostOrder(node.getRight());
			System.out.print(node.getElement().toString() + " ");
		}

		
		public void traverseBreadth() {
			List<Node<T>> headList = new ArrayList<>();
			headList.add(head);
			traverseBreadth(headList);
		}
		
		public void traverseBreadth(List<Node<T>> floor) {

			List<Node<T>> nextFloor = new ArrayList<>();
			for(Node<T> node : floor) {
				if(node != null) {
					System.out.print(node.getElement().toString() + " ");
					nextFloor.add(node.getLeft());
					nextFloor.add(node.getRight());
				}
			}
			if(!nextFloor.isEmpty()) {
				traverseBreadth(nextFloor);
			}
		}
		

		public boolean isBalancedSerachTree() {
			if(head == null) {
				return false;
			}
			return isBalancedSerachTree(null, head, null);
		}
		
		public boolean isBalancedSerachTree(T min, Node<T> node, T max) {
			boolean definition;
			if(node == null) {
				return false;
			}
			if(min == null && max == null && node != null && node.getElement() != null) {
				definition = true;
			}
			else if(min == null && node.getElement().compareTo(max) == -1) {
				definition = true;
			}
			else if(max == null && node.getElement().compareTo(min) == 1) {
				definition = true;
			}
			else if(node.getElement().compareTo(min) == 1 && node.getElement().compareTo(max) == -1) {
				definition = true;
			}
			else {
				return false;
			}
			
			if(node.getLeft() != null)
				definition &= isBalancedSerachTree(min, node.getLeft(), node.getElement());
			if(node.getRight() != null && definition == true)
				definition &= isBalancedSerachTree(node.getElement(), node.getRight(), max);
			
			return definition;
		}
	}
	
	
	public static void main(String[] args) {
		Integer[] informalTestingCases = { 60, 41, 74, 16, 53, 65, 70, 63, 55, 46, 25, 42, 62, 64 };
		NotSelfBalancedBinaryTree<Integer> tree = new NotSelfBalancedBinaryTree<>();
		for(Integer n : informalTestingCases) {
			tree.add(n);
		}

		System.out.println("Least Common Ancestor of 64 & 42:");
		Integer ansestor = tree.findLeastCommonAncestor(64, 42);
		System.out.println(ansestor);

		System.out.println("Least Common Ancestor of 55 & 42:");
		ansestor = tree.findLeastCommonAncestor(55, 42);
		System.out.println(ansestor);

		System.out.println("Least Common Ancestor of 63 & 63:");
		ansestor = tree.findLeastCommonAncestor(63, 63);
		System.out.println(ansestor);
		
		System.out.println("Traverse depth pre-order:");
		tree.traverseDepthPreOrder();
		System.out.println();
		
		System.out.println("Traverse depth in-order:");
		tree.traverseDepthInOrder();
		System.out.println();
		
		System.out.println("Traverse depth in-order:");
		tree.traverseDepthInOrder();
		System.out.println();
		
		System.out.println("Traverse breadth:");
		tree.traverseBreadth();
		System.out.println();
		
		System.out.println("Is BST:");
		boolean isit = tree.isBalancedSerachTree();
		System.out.println(isit);
		System.out.println();
	}
	
}
