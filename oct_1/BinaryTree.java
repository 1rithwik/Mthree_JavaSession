package oct_1;

import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    public boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        if (key > root.key) {
            return searchRec(root.right, key);
        } else {
            return searchRec(root.left, key);
        }
    }

    // Depth First Search
    public static void dfs(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.key);
        dfs(root.left);
        dfs(root.right);
    }

    // Breadth First Search
    public static void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.key);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void delete(int key) {
        root = deleteRec(root, key);
        System.out.println("Node deleted");
    }

    public Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = maxValue(root.left);
            root.left = deleteRec(root.left, root.key);
        }
        return root;
    }

    public int maxValue(Node root) {
        if (root.right == null) {
            return root.key;
        }
        return maxValue(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(10);
        tree.insert(4);
        tree.insert(7);
        tree.insert(1);
        tree.inorder();
        dfs(tree.root);
        System.out.println(tree.search(10));
        System.out.println(tree.search(2));
        tree.delete(3);
        // tree.inorder();
        bfs(tree.root);
    }
}
