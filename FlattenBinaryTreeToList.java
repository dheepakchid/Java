public class FlattenBinaryTreeToList {
    private TreeNode root;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Function to insert nodes in level order
    private static TreeNode insertLevelOrder(int[] arr, TreeNode root,
                                 int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode tempNode = new TreeNode(arr[i]);
            root = tempNode;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }
    private static void flatten(TreeNode root) {
        if(root == null) return;
        while(root != null){
            if(root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode pre = predecessor(root.left);
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }

    private static TreeNode predecessor(TreeNode root){
        if(root.right == null) return root;

        return predecessor(root.right);
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
    public static void main(String args[])
    {
        FlattenBinaryTreeToList t2 = new FlattenBinaryTreeToList();
        int arr[] = { 1, 2, 5, 3, 4, 7, 6};
        t2.root = insertLevelOrder(arr, t2.root, 0);
        t2.inOrder(t2.root);
        flatten(t2.root);
        System.out.println("\n After flattening:");
        t2.inOrder(t2.root);
    }
}
