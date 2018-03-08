package crackingcodinginterview.chapter2;

public class SumWithLinkedList {

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

	static class IntegerLinkedList {

		Node<Integer> head = null;

		public void add(Integer element) {
			Node<Integer> node = new Node<>();
			node.setElement(element);

			if(head == null) {
				head = node;
			}
			else {
				Node<Integer> current = head;
				while(current.getNextNode() != null) {
					current = current.getNextNode();
				}
				current.setNextNode(node);
			}
		}		
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node<Integer> current = head;
			
			if(current == null) {
				return "~";
			}
			do {
				sb.append(" [").append(current.getElement()).append("] ");
				current = current.getNextNode();
			}
			while(current != null);
			return sb.toString().trim();
		}
		
	}
	
	public static IntegerLinkedList sum(IntegerLinkedList list1, IntegerLinkedList list2) {
		IntegerLinkedList result = new IntegerLinkedList();
		
		if(list1 == null || list2 == null) {
			return null;
		}
		
		Node<Integer> n1 = list1.head;
		Node<Integer> n2 = list2.head;

		
		int carryOver = 0;
		while(n1 != null || n2 != null) {
			
			if(n1 == null) {
				int value = n2.getElement().intValue() + carryOver;
				carryOver = value / 10;
				result.add(value % 10);
				n2 = n2.getNextNode();
			}
			else if(n2 == null) {
				int value = n1.getElement().intValue() + carryOver;
				carryOver = value / 10;
				result.add(value % 10);
				n1 = n1.getNextNode();
			}
			else {
				int value = n1.getElement().intValue() + n2.getElement().intValue() + carryOver;
				carryOver = value / 10;
				
				result.add(value % 10);
				n1 = n1.getNextNode();
				n2 = n2.getNextNode();
			}
		}

		if(carryOver != 0) {
			result.add(carryOver);
		}
		
		return result;
	}
	

	public static void main(String[] args) {

		// All these are NOT in reverse order
		String[][] informalTestingCases = { {"8", "8"}, {"1", "10"}, {"513", "592"}, {"123456", "9"}, {"9", "123456"}, 
											{"123456789", "987654321"}, {"0", "44"}, {"0", "0"}, 
											//weird cases for empty contents
											{"", ""},  {"", "1"},  {"1", ""} };
		
		for(String[] test : informalTestingCases) {
			Integer digit1 = test[0].equals("") ? 0 : Integer.valueOf(test[0]);
			Integer digit2 = test[1].equals("") ? 0 : Integer.valueOf(test[1]);
			StringBuilder sbDigit1 = test[0].equals("") ? new StringBuilder() : new StringBuilder(test[0]);
			StringBuilder sbDigit2 = test[1].equals("") ? new StringBuilder() : new StringBuilder(test[1]);
			StringBuilder sbResult = new StringBuilder();
			sbResult.append((digit1 + digit2));
			String reversed1 = sbDigit1.reverse().toString();
			String reversed2 = sbDigit2.reverse().toString();
			
			System.out.println("---------------------------------------------------");
			System.out.println(reversed1 + " + \n" + reversed2 + " = \n" + sbResult.reverse());
			System.out.println();

			IntegerLinkedList list1 = new IntegerLinkedList();
			for(int i = 0; i < reversed1.length(); i++) {
				list1.add(Integer.valueOf(String.valueOf(reversed1.charAt(i))));
			}
			System.out.println(list1.toString());
			
			IntegerLinkedList list2 = new IntegerLinkedList();
			for(int i = 0; i < reversed2.length(); i++) {
				list2.add(Integer.valueOf(String.valueOf(reversed2.charAt(i))));
			}
			System.out.println(list2.toString());
			
			IntegerLinkedList result = sum(list1, list2);  
			System.out.println(result.toString());
		}
	}

}
