package ADT;

public class Binarytree {
    private Node root;

    public Binarytree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return value < root.value
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
    }
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }
    private static class Node {
        int value;
        Node left, right;

        Node(int item) {
            value = item;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        Binarytree tree = new Binarytree();
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(14);
        tree.insert(4);
        tree.insert(7);

        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.println();

        System.out.print("BFS traversal: ");
        //tree.bfs();
        System.out.println();
    }

}
