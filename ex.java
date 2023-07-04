class Tree{
    private Node root;
    class Node {
    	int value;
    	Node left;
    	Node right;
    	Color color;
    	enum Color {
    		BLACK, RED
    		}
}


public void insert(int value) {
    if (root == null) {
        root = new Node();
        root.value = value;
        root.color = Color.BLACK;
    } else {
        insert(root, value);
        root = balance(root);
    }
}

private void insert(Node node, int value) {
    if (node.value != value) {
        if (node.value < value) {
            if (node.right == null) {
                node.right = new Node();
                node.right.value = value;
                node.right.color = Color.RED;
            } else {
                insert(node.right, value);
            }
        } else {
            if (node.left == null) {
                node.left = new Node();
                node.left.value = value;
                node.left.color = Color.RED;
            } else {
                insert(node.left, value);
            }
        }
    }
}



private boolean isRed(Node node) {
    if (node == null) {
        return false;
    }
    return node.color == Color.RED;
}

private Node rotateLeft(Node node) {
    Node temp = node.right;
    node.right = temp.left;
    temp.left = node;
    temp.color = node.color;
    node.color = Color.RED;
    return temp;
}

private Node balance(Node node) {
    if (isRed(node.right) && !isRed(node.left)) {
        node = rotateLeft(node);
    }
    return node;
}


public static void main(String[] args) {
    Tree tree = new Tree();
    for (int i = 1; i <= 5; i++) {
        tree.insert(i);
    	}
	}
}
