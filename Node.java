import java.lang.StringBuilder;

public class Node implements NodeFunctions {
	private final int key;
	private Node parent;
	private Node left;
	private Node right;
	private int count;

	public Node(int key) {
		this.key = key;
		parent = null;
		left = null;
		right = null;
		count = 0;
	}

	public int getKey() {
		return key;
	}

	public Node getParent() {
		return parent;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setLeft(Node n) {
		this.left = n;
	}

	public void setRight(Node n) {
		this.right = n;
	}

	public void setParent(Node n) {
		this.parent = n;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		sb.append(this.key + ",");
		if (this.parent != null) {
			sb.append(this.parent.key);
		}
		sb.append(",");
		if (this.left != null) {
			sb.append(this.left.getKey());
		}
		sb.append(",");
		if (this.right != null) {
			sb.append(this.right.getKey());
		}
		sb.append(",");
		sb.append(this.count + ")");
		return sb.toString();
	}

	public boolean equals(Object o) {
		return false;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
