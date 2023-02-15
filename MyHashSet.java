import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;





class MyHashSet {
    
    private static LinkedList<Integer>[] BucketArray ;
    private int SetRange;
    
    @SuppressWarnings("unchecked")
    public MyHashSet() {
        this.SetRange = 5;
        BucketArray =  new LinkedList[SetRange];
        for (int i = 0; i < SetRange; i++) {
            BucketArray[i] = new LinkedList<Integer>();
        }
    }

    public static void PrintBucket(){
        for(LinkedList<Integer> b : BucketArray) {
            Iterator<Integer> it = b.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
        System.out.println("----");

    }

    protected int _hash(int key) {
        return (key % this.SetRange);
    }

    public void add(int key) {
        int pos = this._hash(key);
        if (!BucketArray[pos].contains(key)) {
            BucketArray[pos].add(key);
        }
    }
    
    public void remove(int key) {
        int pos = this._hash(key);
        System.out.println(pos);
        System.out.println(key);
        System.out.println(BucketArray[pos].size());
        
        if(!BucketArray[pos].isEmpty() && BucketArray[pos].contains(key)){
            BucketArray[pos].remove(key);
            // BucketArray[pos].remove(Integer.valueOf(key));
        }
        
    }
    
    public boolean contains(int key) {
        int pos = this._hash(key);
        return (BucketArray[pos].contains(key));
    }


    public static void main(String[] args){
        MyHashSet mhs = new MyHashSet();
        mhs.add(20);
        PrintBucket();
        mhs.remove(20);
        PrintBucket();
        mhs.add(50);
        mhs.add(50);
        mhs.add(50);
        mhs.remove(50);
        mhs.contains(50);      
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */