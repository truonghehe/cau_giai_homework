package is_this_a_binary_tree;

public class Solution {
    class Node {
        int data;
        Node left;
        Node right;
    }
    boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE );
    }

    private boolean check(Node x, int minValue, int maxValue) {
        if (x == null) return true;
        if (x.data <= minValue || x.data >= maxValue) {
            return false;
        }
        boolean leftIsValid = check(x.left, minValue, x.data);
        boolean rightIsValid = check(x.right, x.data, maxValue);

        return leftIsValid && rightIsValid;
    }

}
