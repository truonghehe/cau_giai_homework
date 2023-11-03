package self_balancing_tree;
public class Solution {
static class Node {
    int val;
    Node left;
    Node right;
    int ht;
}
    static int height(Node node) {
        return (node == null) ? 0 : node.ht;
    }
    static int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }
    static Node insert(Node root, int val) {
        if (root == null) {
            Node cur = new Node();
            cur.val = val;
            cur.ht = 1;
            return cur;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            // Duplicate vals are not allowed in AVL trees
            return root;
        }

        root.ht = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalanceFactor(root);

        // Left Heavy
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }
        // Right Heavy
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }
        // Left-Right Heavy
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right-Left Heavy
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
}
