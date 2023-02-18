import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;
  
    /** Initialize your data structure here. */
    //***alert should be modified */
    public MyHashSet() {
      this.keyRange = 769;
      this.bucketArray = new Bucket[this.keyRange];
      for (int i = 0; i < this.keyRange; ++i)
        this.bucketArray[i] = new Bucket();
    }
  
    // ***should be modified
    // ****alert
    protected int _hash(int key) {
      return key % this.keyRange;
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
      // LinkdedList<String> InputList = new LinkedList[String]{"MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"
    //  String[] commands = {"MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"};
    //cmmands remove first operation, nums should remove the first null number, officialResult should remove the first result
    String[] commands = {"contains","remove","add","add","contains","remove","contains","contains","add","add","add","add","remove","add","add","add","add","add","add","add","add","add","add","contains","add","contains","add","add","contains","add","add","remove","add","add","add","add","add","contains","add","add","add","remove","contains","add","contains","add","add","add","add","add","contains","remove","remove","add","remove","contains","add","remove","add","add","add","add","contains","contains","add","remove","remove","remove","remove","add","add","contains","add","add","remove","add","add","add","add","add","add","add","add","remove","add","remove","remove","add","remove","add","remove","add","add","add","remove","remove","remove","add","contains","add"};
     int[][] nums = {{72},{91},{48},{41},{96},{87},{48},{49},{84},{82},{24},{7},{56},{87},{81},{55},{19},{40},{68},{23},{80},{53},{76},{93},{95},{95},{67},{31},
     {80},{62},{73},{97},{33},{28},{62},{81},{57},{40},{11},{89},{28},{97},{86},{20},{5},{77},{52},{57},{88},{20},{48},{42},{86},{49},{62},{53},{43},{98},{32},{15},
     {42},{50},{19},{32},{67},{84},{60},{8},{85},{43},{59},{65},{40},{81},{55},{56},{54},{59},{78},{53},{0},{24},{7},{53},{33},{69},{86},{7},{1},{16},{58},{61},{34},
     {53},{84},{21},{58},{25},{45},{3}};
     Object[] officalResult = {false,null,null,null,false,null,true,false,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,false,null,true,null,null,true,null,null,null,null,null,null,null,null,true,null,null,null,null,false,null,false,null,null,null,null,null,true,null,null,null,null,true,null,null,null,null,null,null,true,true,null,null,null,null,null,null,null,false,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,false,null};
     List<Integer> numsArray = new ArrayList<>();
     for(int[] row : nums){
      for(int num: row){
        numsArray.add(num);
      }
     }
      //  System.out.println(numsArray.size() == commands.length);
    //  System.out.println(numsArray.size());
    //  System.out.println(commands.length);
    Object[] result = new Object[100];

     for(int i = 0; i< numsArray.size(); i++){
        String op = commands[i];
        int val = numsArray.get(i);
        System.out.println("step"+i);
        System.out.println(commands[i]);
        System.out.println(numsArray.get(i));
        switch(op){
          case "add":
            result[i] = null;
            mhs.add(val);
            break;
          case "remove":
          result[i] = null;
           mhs.remove(val);
           break;
          case "contains":
          result[i] = mhs.contains(val);
          break;
        }
      System.out.println("myresult"+result[i]);
      System.out.println("officialresult"+officalResult[i]);
      if(result[i]!= null && officalResult[i]!= null && (result[i].toString() != officalResult[i].toString())){
      System.out.println("*******notmatch"+result[i]);

      }
        mhs.PrintBucket();

     }

    //  System.out.println(numsArray.size() == result.length);
    //  System.out.println(numsArray.size());
    //  System.out.println(result.length);
    //  System.out.println(officalResult.length);

     for(int i = 0; i< numsArray.size(); i++){
        System.out.print(result[i]+" ");
     }
     for(int i = 0; i< numsArray.size(); i++){
      if(result[i]!= null && officalResult[i]!= null && (result[i].toString() != officalResult[i].toString())){
        System.out.println(i);
        System.out.println(commands[i]);
        System.out.println(numsArray.get(i));
        System.out.println("---notmatch----");
      }
     }

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
        // if delete val is not exist, delete is null
        while(delete != null && delete.val != val){
            father = delete;
            if(val > delete.val){
                delete = delete.right;
            }
            else{
                delete = delete.left;
            }
        }

        // delete val is not exist'
        // alert everything is wrongly disappear
        if(delete == null){
          return root;
        }

        // delete leaf node
        // before refering to delete.left, we should make sure delete is null
        if(delete!= null && delete.left == null && delete.right == null){
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
          int suc = successor(delete);
          delete.right = deleteNode(delete.right, suc);
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