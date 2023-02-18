
class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;
  
    /** Initialize your data structure here. */
    public MyHashSet() {
      this.keyRange = 769;
      this.bucketArray = new Bucket[this.keyRange];
      for (int i = 0; i < this.keyRange; ++i)
        this.bucketArray[i] = new Bucket();
    }
  
    protected int _hash(int key) {
      return (key % this.keyRange);
    }
  
    public void add(int key) {
      int bucketIndex = this._hash(key);
      this.bucketArray[bucketIndex].insert(key);
    }
  
    public void remove(int key) {
      int bucketIndex = this._hash(key);
      this.bucketArray[bucketIndex].delete(key);
    }
  
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
      int bucketIndex = this._hash(key);
      return this.bucketArray[bucketIndex].exists(key);
    }


    public  void PrintBucket(){
      for(Bucket b : bucketArray) {
        if (b.size()!=0){
          b.inorderTraversal();
          System.out.println("-");
        }
      }
      System.out.println("-------");
  }


  }
  
  
  class Bucket {
    private BSTree tree;
  
    public Bucket() {
      tree = new BSTree();
    }
    
    int size(){
      if (this.tree.height(this.tree.root) == 0){
        return 0;
      }
      else{
        return 1;
      }
    }

    public void insert(Integer key) {
      this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
    }
  
    public void delete(Integer key) {
      this.tree.root = this.tree.deleteNode(this.tree.root, key);
    }
  
    public boolean exists(Integer key) {
      TreeNode node = this.tree.searchBST(this.tree.root, key);
      return (node != null);
    }

      public void inorderTraversal() {
        this.tree.inorderTraversal(this.tree.root);
      }
  }
  
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  
    TreeNode(int x) {
      val = x;
    }

    public static void main(String[] args){
      MyHashSet mhs = new MyHashSet();
        mhs.add(20);
        mhs.PrintBucket();
        mhs.remove(20);
        mhs.PrintBucket();
        mhs.add(50);
        mhs.add(50);
        mhs.add(50);
        mhs.remove(50);
        mhs.contains(50);  
    }
  }
  
  class BSTree {
    TreeNode root = null;

    public int height(TreeNode root){
      if (root == null){
        return 0;
      }
      else{
        return 1;
      }
    }
  
    public TreeNode searchBST(TreeNode root, int val) {
      if (root == null || val == root.val)
        return root;
  
      return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
  
    public TreeNode insertIntoBST(TreeNode root, int val) {
      if (root == null)
        return new TreeNode(val);
  
      if (val > root.val)
        // insert into the right subtree
        root.right = insertIntoBST(root.right, val);
      else if (val == root.val)
        // skip the insertion
        return root;
      else
        // insert into the left subtree
        root.left = insertIntoBST(root.left, val);
      return root;
    }
  
    /*
     * One step right and then always left
     */
    public int successor(TreeNode root) {
      root = root.right;
      while (root.left != null)
        root = root.left;
      return root.val;
    }
  
    /*
     * One step left and then always right
     */
    public int predecessor(TreeNode root) {
      root = root.left;
      while (root.right != null)
        root = root.right;
      return root.val;
    }


    public void inorderTraversal(TreeNode root) {
      if (root == null) {
          return ;
      }
      inorderTraversal(root.left);
      System.out.println(root.val);
      inorderTraversal(root.right);
  }
  
    public TreeNode deleteNode(TreeNode root, int val) {
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
            int suc = successor(root);
            deleteNode(root, suc);
            delete.val = suc;

            
        }
        return root;
    }
  }
  
  /**
   * Your MyHashSet object will be instantiated and called as such:
   * MyHashSet obj = new MyHashSet();
   * obj.add(key);
   * obj.remove(key);
   * boolean param_3 = obj.contains(key);
   */