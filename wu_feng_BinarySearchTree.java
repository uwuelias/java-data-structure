public class wu_feng_BinarySearchTree implements BinarySearchTreeFunctions {
	private Node root;

	public wu_feng_BinarySearchTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insertNode(Node z) {
		Node duplicateTest = getNode(root, z.getKey());

		if (duplicateTest != null) {
			duplicateTest.setCount(duplicateTest.getCount() + 1);
			return;
		}

		Node tempParent = null;
		Node currentNode = root;

		while (currentNode != null) {
			tempParent = currentNode;
			if (z.getKey() < currentNode.getKey()) {
				currentNode = currentNode.getLeft();
			} else {
				currentNode = currentNode.getRight();
			}
		}

		z.setParent(tempParent);
		if (tempParent == null) {
			setRoot(z); // Tree was empty
		} else if (z.getKey() < tempParent.getKey()) {
			tempParent.setLeft(z);
		} else {
			tempParent.setRight(z);
		}

		z.setCount(1);
	}

	public void updateNode(Node z) {
	}

	public void preOrderWalk(Node x) {
		if (x != null) {
			System.out.println(x.toString());
			preOrderWalk(x.getLeft());
			preOrderWalk(x.getRight());
		}
	}

	public void preOrderWalk(Node x, java.util.ArrayList<String> list) {
		if (x != null) {
			list.add(x.toString());
			preOrderWalk(x.getLeft(), list);
			preOrderWalk(x.getRight(), list);
		}
	}

	public void preOrderWalk(Node x, String id, java.util.ArrayList<String> result) {
		if (x != null) {
			System.out.println(x.toString() + " " + id);
			result.add(x.getKey() + " " + id);
			preOrderWalk(x.getLeft(), "0" + id, result);
			preOrderWalk(x.getRight(), "1" + id, result);
		}
	}

	public void inOrderWalk(Node x) {
		if (x != null) {
			inOrderWalk(x.getLeft());
			System.out.println(x.toString());
			inOrderWalk(x.getRight());
		}
	}

	public void inOrderWalk(Node x, java.util.ArrayList<String> list) {
		if (x != null) {
			inOrderWalk(x.getLeft(), list);
			list.add(x.toString());
			inOrderWalk(x.getRight(), list);
		}
	}

	public void postOrderWalk(Node x) {
		if (x != null) {
			postOrderWalk(x.getLeft());
			postOrderWalk(x.getRight());
			System.out.println(x.toString());
		}
	}

	public void postOrderWalk(Node x, java.util.ArrayList<String> list) {
		if (x != null) {
			postOrderWalk(x.getLeft(), list);
			postOrderWalk(x.getRight(), list);
			list.add(x.toString());
		}
	}

	public Node getMax(Node x) {
		while (x != null && x.getRight() != null) {
			x = x.getRight();
		}
		return x;
	}

	public Node getMin(Node x) {
		while (x != null && x.getLeft() != null) {
			x = x.getLeft();
		}
		return x;
	}

	public Node getSuccessor(Node x) {
		if (x == null) {
			return null;
		}

		if (x.getRight() != null) {
			return getMin(x.getRight());
		}

		Node parent = x.getParent();
		while (parent != null && x == parent.getRight()) {
			x = parent;
			parent = parent.getParent();
		}

		return parent;
	}

	public Node getPredecessor(Node x) {
		if (x == null) {
			return null;
		}

		if (x.getLeft() != null) {
			return getMax(x.getLeft());
		}

		Node parent = x.getParent();
		while (parent != null && x == parent.getLeft()) {
			x = parent;
			parent = parent.getParent();
		}

		return parent;
	}

	public Node getNode(Node x, int key) {
		if (x == null || x.getKey() == key) {
			return x;
		}

		if (key < x.getKey()) {
			return getNode(x.getLeft(), key);
		} else {
			return getNode(x.getRight(), key);
		}
	}

	public int getHeight(Node x) {
		if (x == null) {
			return -1;
		}

		int leftHeight = getHeight(x.getLeft());
		int rightHeight = getHeight(x.getRight());

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public void shiftNode(Node u, Node v) {
		if (u.getParent() == null) {
			setRoot(v);
		} else {
			if (u == u.getParent().getLeft()) {
				u.getParent().setLeft(v);
			} else {
				u.getParent().setRight(v);
			}
		}

		if (v != null) {
			v.setParent(u.getParent());
		}
	}

	public void deleteNode(Node z) {
		if (z.getCount() > 1) {
			z.setCount(z.getCount() - 1);
			return;
		}

		if (z.getLeft() == null) {
			shiftNode(z, z.getRight());
		} else if (z.getRight() == null) {
			shiftNode(z, z.getLeft());
		} else {
			Node successor = getSuccessor(z);
			if (successor.getParent() != z) {
				shiftNode(successor, successor.getRight());
				successor.setRight(z.getRight());
				successor.getRight().setParent(successor);
			}
			shiftNode(z, successor);
			successor.setLeft(z.getLeft());
			successor.getLeft().setParent(successor);
		}
	}
}
