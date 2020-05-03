package linkedlist;

public class Node {
	public String item;
	public Node link;

	//constructors
	public Node() {
		link = null;
		item = "";
	}

	public Node(String newItem) {
		setItem(newItem);
		link = null;
	}

	public Node(String newItem, Node linkValue) {
		setItem(newItem);
		link = linkValue;
	}

	//getters & setters
	public void setItem(String newItem) {
		item = newItem;
	}

	public void setLink(Node newLink) {
		link = newLink;
	}

	public String getItem() {
		return item;
	}

	public Node getLink() {
		return link;
	}
}