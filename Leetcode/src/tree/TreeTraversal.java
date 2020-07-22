package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    /**
     *  前序遍历
     */
    List<Integer> preOrderList = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return preOrderList;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrderList.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void preOrderIteratively(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 1、根结点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 2、弹栈
            TreeNode node = stack.pop();
            preOrderList.add(node.val);
            // 3、右孩子压入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            // 4、左孩子入栈。前序遍历：中左右。栈：后进先出。
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    List<Integer> inOrderList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return inOrderList;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }

    private void inOrderIteratively(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 中序：左中右
            // 遍历左子树，将根结点入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 取右孩子入栈
            root = stack.peek().right;
            inOrderList.add(stack.peek().val);
            stack.pop();
        }
    }

    /**
     * 后序遍历
     */
    List<Integer> postorderList = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return postorderList;
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        postorderList.add(node.val);
    }

    private void postOrderIteratively1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                postorderList.add(0, root.val);
                root = root.right;
            }
            root = stack.pop().left;
        }
    }

    private void postOrderIteratively2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node.val);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            postorderList.add(stack2.pop());
        }
    }



}
