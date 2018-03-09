package crackingcodinginterview.chapter2;

public class HappyLinkedList {

	static class Node<T> {

		T element;
		Node<T> nextNode;


		public Node() {
			element = null;
			nextNode = null;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public T getElement() {
			return (T) this.element;
		}

		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}
		public Node<T> getNextNode() {
			return nextNode;
		}
	}

	static class SimpleLinkedList<T> {

		Node<T> head;
		Node<T> current;
		int lenght;

		public SimpleLinkedList() {
			head = null;
			current = null;
			lenght = 0;
		}

		public boolean isEmpty() {
			if(lenght == 0) {
				return true;
			}
			return false;
		}

		public void add(T element) {
			Node<T> node = new Node<T>();
			node.setElement(element);

			if(lenght == 0) {
				head = node;
				current = node;
				lenght = 1;
			}
			else {
				current.setNextNode(node);
				current = node;
				lenght ++;
			}
		}

		public boolean remove(int index) {
			if(index >= lenght || index < 0) {
				return false;
			}

			Node<T> position = head;
			for(int i = 0; i < index - 1; i++) {
				position = position.getNextNode();
			}
			Node<T> remove = position.getNextNode();
			if(current == remove) {
				current = position;
			}
			position.setNextNode(remove.getNextNode());
			remove = null;
			lenght --;
			return true;
		}


		public Node<T> getNode(int index) {
			if(index >= lenght || index < 0) {
				return null;
			}
			Node<T> position = head;
			for(int i = 0; i < index; i++) {
				position = position.getNextNode();
			}
			return position;
		}


		public int indexOfNext(int index, T currentContent) {
			Node<T> position = head;
			for(int i = 0; i < lenght; i ++) {
				if(i >= index && currentContent.equals(position.getElement())) {
					return i;
				}
				position = position.getNextNode();
			}
			return -1;
		}


		public String toString() {
			Node<T> position = head;
			StringBuilder sb = new StringBuilder();

			for(int i = 0; i < lenght; i++) {
				sb.append(" [").append(position.getElement()).append("] ");
				position = position.getNextNode();
			}
			return sb.toString().trim();
		}


		/**
		 * Solution for 2.1
		 * @param index
		 * @return
		 */
		public int removeDuplicates() {
			int removedCounter = 0;
			if(lenght <= 1) {
				return removedCounter;
			}

			Node<T> position = head;
			//O(n)
			for(int i = 0; i < lenght; i++) {
				T currentContent = position.getElement();

				//O(n)
				int ion = 0;
				do {
					ion = indexOfNext(i+1, currentContent);
					remove(ion);
					removedCounter ++;
				} 
				while (ion > 0);
				position = position.getNextNode();
			}
			return removedCounter;
		}


		/**
		 * Solution for 2.2
		 * @param index
		 * @return
		 */
		public SimpleLinkedList<T> getSublist(int index) {
			if(index >= lenght || index < 0) {
				return null;
			}
			SimpleLinkedList<T> nova = new SimpleLinkedList<>();
			Node<T> position = getNode(index);
			//O(n)
			for(int i = 0; index + i < lenght; i++) {
				nova.add(position.getElement());
				position = position.getNextNode();
			}
			return nova;
		}


		/**
		 * Solution for 2.3
		 * @param index
		 * @return
		 */
		public boolean remove(Node<T> node) {
			if(node == null || head == null) {
				return false;
			}

			if(node == head) {
				head = head.getNextNode();
				node = null;
				lenght --;
				return true;
			}

			//O(n)
			Node<T> prevPosition = head;
			Node<T> position = head.getNextNode();;
			do {
				if(position == node) {
					prevPosition.setNextNode(position.getNextNode());
					if(current == node) {
						current = prevPosition;
					}
					node = null;
					lenght --;
					return true;
				}
				prevPosition = prevPosition.getNextNode();
				position = position.getNextNode();
			}
			while(position != null);
			return false;
		}
	}

	public static void main(String[] args) {

		String[] informalTestingCases = { "A", "B", "C", "A", "A", "D", "T"};
		SimpleLinkedList<String> llist = new SimpleLinkedList<String>(); 
		for(String s : informalTestingCases) {
			llist.add(s);
		}
		System.out.println("Start: ");
		System.out.println(llist.toString());

		System.out.println("Add T: ");
		llist.add("T");
		System.out.println(llist.toString());

		System.out.println("Index of D from 2: ");
		int ion = llist.indexOfNext(2, "D");
		System.out.println(ion);

		System.out.println("Remove 2: ");
		llist.remove(2);
		System.out.println(llist.toString());

		//Solution for 2.1
		System.out.println("Remove duplicates: ");
		int deleted = llist.removeDuplicates();
		System.out.println(deleted);
		System.out.println(llist.toString());

		//Solution for 2.2
		System.out.println("Sublist 2: ");
		SimpleLinkedList<String> llist2 = llist.getSublist(2);
		System.out.println(llist2.toString());

		//Solution for 2.3
		System.out.println("Node 2: ");
		Node<String> node = llist.getNode(2);
		System.out.println(node.getElement());
		llist.remove(node);
		System.out.println(llist.toString());
	}

}
