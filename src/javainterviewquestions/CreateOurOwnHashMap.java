package javainterviewquestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateOurOwnHashMap {
    public static class MyHashMap<K, V> {
        private class MHMNode {
            K key;
            V value;

            MHMNode(K Key, V value) {
                this.key = Key;
                this.value = value;
            }
        }

        private int size;

        private int DEFAULT_SIZE = 4;
        private LinkedList<MHMNode> buckets[];

        MyHashMap() {
            initBuckets(DEFAULT_SIZE);
            size = 0;
        }

        private void initBuckets(int default_size) {
            buckets = new LinkedList[default_size];
            for (int bi = 0; bi < default_size; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int bi = hashFun(key);
            int di = getIndexWithInBucket(key, bi);

            if (di != -1) {
                MHMNode node = buckets[bi].get(di);
                node.value = value;
            } else {
                // insert
                MHMNode node = new MHMNode(key, value);
                buckets[bi].add(node);
                size++;
            }

            double lamda = size * 1.0 / buckets.length;
            if (lamda > 2.0) {
                rehash();
            }
        }

        private void rehash() {
            LinkedList<MHMNode> [] oldBuckets = buckets;
            initBuckets(DEFAULT_SIZE*2);
            size=0;
            for (int i = 0;i<oldBuckets.length;i++){
                for (MHMNode node : oldBuckets[i]){
                    put(node.key,node.value);
                }
            }
        }


        public V get(K key) {
            int bi = hashFun(key);
            int di = getIndexWithInBucket(key, bi);
            MHMNode node = buckets[bi].get(di);
            return node.value;
        }

        public boolean containsKey(K key) {
            int bi = hashFun(key);
            int di = getIndexWithInBucket(key, bi);

            if (di != -1) return true;
            return false;
        }

        public MHMNode remove(K key){
            int bi = hashFun(key);
            int di = getIndexWithInBucket(key,bi);

            if (di!=-1) {
               MHMNode node = buckets[bi].remove(di);
                size--;
                return node;
            }else
                return null;
        }

        public ArrayList<K> keySet() throws Exception{
            ArrayList<K> keys = new ArrayList<>();
            for (int bi =0 ; bi<buckets.length;bi++){
               for(MHMNode node : buckets[bi]){
                   keys.add(node.key);
               }
            }
            return keys;
        }


        private int hashFun(K key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        private int getIndexWithInBucket(K key, int bi) {
            int di = 0;
            for (MHMNode node : buckets[bi]) {
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }
            return -1;
        }

    }


    public static void main(String[] args) throws Exception {

        MyHashMap<Integer,String> map = new MyHashMap<>();
        boolean key  = map.containsKey(1);
        System.out.println(key);
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");

        for (Integer keys : map.keySet()){
            System.out.print(keys);
        }
        System.out.println();

       String  value =  map.get(2);
        System.out.println(value);

        map.remove(2);

        System.out.println("is 2 key removed "+map.containsKey(2));
    }

}
