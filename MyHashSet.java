import java.util.LinkedList;

class MyHashSet {
    
    private LinkedList<Integer>[] BucketArray ;
    private int SetRange;
    
    @SuppressWarnings("unchecked")
    public MyHashSet() {
        this.SetRange = 1000;
        this.BucketArray =  new LinkedList[SetRange];
        for (int i = 0; i < SetRange; i++) {
            this.BucketArray[i] = new LinkedList<Integer>();
        }
    }
    
    public void add(int key) {
        
    }
    
    public void remove(int key) {
        
    }
    
    public boolean contains(int key) {
        return true;
    }


    public static void main(String[] args){
        MyHashSet mhs = new MyHashSet();
        System.out.println(mhs.BucketArray[1]);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */