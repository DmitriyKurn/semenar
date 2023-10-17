class LLRBTree {

    boolean RED = true;
    boolean BLACK = false;

    Node root;
    class Node {
        Node left, right;
        int value;

        boolean color;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;

            color = RED;
        }
    }

    Node rotateLeft(Node subNode) {
        System.out.printf("left\n");
        Node child = subNode.right;
        Node childLeft = child.left;

        child.left = subNode;
        subNode.right = childLeft;

        return child;
    }

    Node rotateRight(Node subNode) {
        System.out.printf("right\n");
        Node child = subNode.left;
        Node childRight = child.right;

        child.right = subNode;
        subNode.left = childRight;

        return child;
    }

    boolean isRed(Node subNode) {
        if (subNode == null) {
            return false;
        }
        return (subNode.color == RED);
    }

    void swapColors(Node leftNode, Node rightNode) {
        boolean temp = leftNode.color;
        leftNode.color = rightNode.color;
        rightNode.color = temp;
    }

    void insert(int value) {
        root = insert(root, value);
        root.color = BLACK;
    }

    Node insert(Node subNode, int value) {
        if (subNode == null) {
            return this.root = new Node(value);
        }

        if (value < subNode.value) {
            subNode.left = insert(subNode.left, value);
        } else if (value > subNode.value) {
            subNode.right = insert(subNode.right, value);
        } else {
            return subNode;
        }

        if (isRed(subNode.right) && !isRed(subNode.left)) {
            subNode = rotateLeft(subNode);
            swapColors(subNode, subNode.left);
        }

        if (isRed(subNode.left) && isRed(subNode.left.left)) {
            subNode = rotateRight(subNode);
            swapColors(subNode, subNode.right);
        }

        if (isRed(subNode.left) && isRed(subNode.right)) {
            subNode.color = !subNode.color;
            subNode.left.color = BLACK;
            subNode.right.color = BLACK;
        }

        return subNode;
    }

    // Вывод дерева
    void traverse(Node subNode) {
        if (subNode != null) {
            traverse(subNode.left);
            System.out.print(subNode.value + " ");
            traverse(subNode.right);
        }
    }
}

class Main {
    static void main(String args[]) {
        boolean RED = true;
        boolean BLACK = false;

        LLRBTree tree = new LLRBTree();

        tree.insert(20);
        
        assert tree.root != null;
        assert tree.root.value == 20;
        assert tree.root.color == BLACK;

        tree.insert(10);
        
        assert tree.root != null;
        assert tree.root.value == 20;
        assert tree.root.left.value == 10;
        assert tree.root.color == BLACK;
        assert tree.root.left.color == RED;

        assert tree.root.right == null;
        assert tree.root.left.right == null;
        assert tree.root.left.left == null;
        
        tree.insert(30);
        
        assert tree.root != null;
        assert tree.root.value == 20;
        assert tree.root.left.value == 10;
        assert tree.root.right.value == 30;
        assert tree.root.color == BLACK;
        assert tree.root.left.color == BLACK;
        assert tree.root.right.color == BLACK;

        assert tree.root.left.left == null;
        assert tree.root.left.right == null;
        assert tree.root.right.left == null;
        assert tree.root.right.right == null;
        
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        tree.traverse(tree.root);

    }
}
    

