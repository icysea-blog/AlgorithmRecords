package tree;

import utils.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftCopy = root.left, rightCopy = root.right;
        root.left = invertTree(rightCopy);
        root.right = invertTree(leftCopy);
        return root;
    }
}
