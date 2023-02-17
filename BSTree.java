

public class BSTree {
    TreeNode root = null;

    // return the target node
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

    //return the largest number of the left tree
    public int predecessor(TreeNode root, int val){
        TreeNode pre = root.left;
        int preVal = pre.val;
        while (pre != null){
            preVal = pre.val;
            pre = pre.right;
        }
        return preVal;
    }

    //return the smallest number of the right tree
    public int successor(TreeNode root, int val){
        TreeNode suc = root.right;
        int sucVal = suc.val;
        while (suc != null){
            sucVal = suc.val;
            suc = suc.left;
        }
        return sucVal;
    }
    
    // It deletes the node of a given value of a BSTree
    // It takes with the root of the tree and the vlaue as input, and it returns the root of the updated tree
    /**
     * @param root
     * @param val
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int val){
        TreeNode delete = root;
        TreeNode father = null;
        if (root == null){
            return null;
        }

        // find the node to delete and its father node
        while(delete != null && delete.val != val){
            father = delete;
            if(val > delete.val){
                delete = delete.right;
            }
            else{
                delete = delete.left;
            }
        }

     

        // delete leaf node
        if(delete.left == null && delete.right == null){
            if (father == null){
                return null;
            }
            else {
                if(father.val > val){
                    father.left = null;
                    return root;
                }
                else if(father.val < val){
                    father.right = null;
                    return root;
                }
            }
        }
        else if(delete.left == null){
            TreeNode right = delete.right;
            delete.val = right.val;
            delete.left = right.left; 
            delete.right = right.right;
        }
        else if (delete.right == null){
            TreeNode left = delete.left;
            delete.val = left.val;
            delete.left = left.left; 
            delete.right = left.right;
        }
        else{
            int suc = successor(root, val);
            deleteNode(root, suc);
            delete.val = suc;

            
        }
        return root;

    }


    // public TreeNode deleteNode(TreeNode root, int val) {
    //     if (root == null) {
    //         return null;
    //     }
    
    //     // find the node to delete and its father node
    //     TreeNode delete = root;
    //     TreeNode father = null;
    //     while (delete != null && delete.val != val) {
    //         father = delete;
    //         if (val < delete.val) {
    //             delete = delete.left;
    //         } else {
    //             delete = delete.right;
    //         }
    //     }
    
    //     // the node to be deleted is not found
    //     if (delete == null) {
    //         return root;
    //     }
    
    //     // delete node has both left and right children
    //     if (delete.left != null && delete.right != null) {
    //         TreeNode successor = delete.right;
    //         TreeNode successorFather = delete;
    //         while (successor.left != null) {
    //             successorFather = successor;
    //             successor = successor.left;
    //         }
    //         delete.val = successor.val;
    //         delete = successor;
    //         father = successorFather;
    //     }
    
    //     // delete node has at most one child
    //     TreeNode child = null;
    //     if (delete.left != null) {
    //         child = delete.left;
    //     } else if (delete.right != null) {
    //         child = delete.right;
    //     }
    
    //     if (father == null) {
    //         // the node to delete is the root node
    //         root = child;
    //     } else if (delete == father.left) {
    //         father.left = child;
    //     } else {
    //         father.right = child;
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

        tree.root = tree.insertIntoBST(tree.root, 51);
        tree.insertIntoBST(tree.root, 24);
        tree.insertIntoBST(tree.root, 97);
        tree.insertIntoBST(tree.root, 17);
        tree.insertIntoBST(tree.root, 35);
        tree.insertIntoBST(tree.root, 66);
        tree.insertIntoBST(tree.root,29);
        tree.insertIntoBST(tree.root, 53);
        tree.insertIntoBST(tree.root, 78);
        tree.insertIntoBST(tree.root, 31);
        tree.insertIntoBST(tree.root, 32);
        tree.insertIntoBST(tree.root,52 );
        tree.insertIntoBST(tree.root, 57);
        tree.insertIntoBST(tree.root, 71);
        tree.insertIntoBST(tree.root, 86);
        tree.insertIntoBST(tree.root, 85);

        tree.deleteNode(tree.root,51);

        tree.printTree(tree.root);
    }
}




