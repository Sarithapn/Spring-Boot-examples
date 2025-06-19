package ADT;

class Node {

	String value;
	Node next;

	public Node(String value) {
		this.value = value;
		this.next = null;
	}
}

public class LinkedList {

	Node head;

	// add
	void add(String value) {
		Node newNode = new Node(value);

		if (head == null) {
			head = newNode;

		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}

	}
	// delete
	 public void deleteNode(String key) {
	        Node current = head;
	        Node prev = null;

	        // If the key is at head
	        if (current != null && current.value == key) {
	            head = current.next;
	            return;
	        }

	        // Search for the key
	        while (current != null && current.value != key) {
	            prev = current;
	            current = current.next;
	        }

	        // Key not found
	        if (current == null) {
	            return;
	        }

	        // Key found, unlink the node
	        prev.next = current.next;
	    }

	// display
	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.value + "\n ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		LinkedList l = new LinkedList();
		l.add("apple");
		l.add("ball");
		l.add("cat");
		l.add("dog");
		l.display();
		l.deleteNode("cat");
		l.display();

	}

}
