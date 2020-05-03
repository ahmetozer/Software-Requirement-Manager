package tree;

public class treeNode {

	private int key; 
	treeNode leftChild, rightChild;
	String url;
	
	treeNode(int key, String url, treeNode leftChild, treeNode rightChild) {
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.url = url;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
