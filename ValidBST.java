import java.util.*;

public class ValidBST {
    private TreeNode root;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
    // Function to insert nodes in level order
    private TreeNode insertLevelOrder(int[] arr, TreeNode root,
                                 int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }
    // Function to print tree nodes in InOrder fashion
    private void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        ValidBST t2 = new ValidBST();
        int[] arr = { 4,2, 5,1,3 };

        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        t2.inOrder(t2.root);

        boolean isValidBST = isValidBST(t2.root);
        System.out.println(isValidBST);
    }
}
