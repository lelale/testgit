

public class BSTree {
    TreeNode root = null;

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }





    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node = root;
        if (node == null){
            node = new TreeNode(val);
            return node;
        }

        while(node != null){
            if(val == node.val) {
                break;
            }
            
            if(val > node.val){
                TreeNode fat = node;
                node = node.right;
                if(node == null){
                    node = new TreeNode(val);
                    fat.right = node;
                    break;
                }
            }

            if(val < node.val){
                if(node.left == null){
                    node.left = new TreeNode(val);
                    break;
                }
                node = node.left;
            }
        }
        return root;//node or root? what should I return 
    }


    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if (root == null) {
    //         return new TreeNode(val);
    //     }

    //     if (val > root.val) {
    //         root.right = insertIntoBST(root.right, val);
    //     } else if (val == root.val) {
    //         return root;
    //     } else {
    //         root.left = insertIntoBST(root.left, val);
    //     }

    //     return root;
    // }

    


    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }



    public static void main(String[] args) {
        BSTree tree = new BSTree();

        tree.root = tree.insertIntoBST(tree.root, 5);
   

        tree.insertIntoBST(tree.root, 2);
        tree.insertIntoBST(tree.root, 7);
        tree.insertIntoBST(tree.root, 1);
        tree.insertIntoBST(tree.root, 3);
        tree.insertIntoBST(tree.root, 6);
        tree.insertIntoBST(tree.root, 8);

        tree.printTree(tree.root);
    }
}




