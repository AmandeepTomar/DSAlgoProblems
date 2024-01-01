package javainterviewquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 *
 *
 *
 */
public class HashMapQuestions {

    public static void main(String[] args) {
        Map<Currency,Double> map=new HashMap<>();
        map.put(new Currency("US"),1.1);
        map.put(new Currency(null),1.2);
        map.put(null,1.4);


     //  assert map.get(new Currency("US"))==1.1;

        System.out.println(map.get(new Currency("US"))); // 1.1
        System.out.println(map.get(new Currency(null))); // null as key  // 1.2

        System.out.println(map.get(null)); // null  1.4

    }
}


class Currency{
    private String currencyCode;

    public Currency(String currencyCode){
        this.currencyCode=currencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
      //  System.out.println(currencyCode+" --- "+currency.currencyCode);
        return Objects.equals(currencyCode, currency.currencyCode);
    }

    @Override
    public int hashCode() {
        int hashCode=Objects.hash(currencyCode);
       // System.out.println(hashCode);
        return hashCode;
    }
}

/***
 *
 * HashMap has put(key), get(Key), containValue(Key),remove(K),Size(), there are the methods of hashmap.
 * Internal working of hashmap.
 * Hashmap represents the hash table data structure.
 * Hash table using the hashing technique that means when we put something it will will calculate the hashcode of key and find the index of bucket where it will store and after that it will put the key and value in a linked list data structure at the buket index. If there is no linked listed at the bucket index then it will created new linked list and add. Else it will add in the end.
 * Default size of hashmap bucket is 16. That is in power of 2 that is 2 pow 1 , 2 pow 2 …. So on.
 * Size is in 2 ki pow because of better collision manegenegt. As we know int range is - 2 pow 31 to 2 pow 31 -1. So it wlll not be 2  pow 31.
 * What is collision:
 * When we calculate the hastable index and that will be the same for different key then the collision occurred. We will then traverse the linked list and add in the end.
 * -  Loafactore
 * - its the point where we increase the size of hashtable.
 * - Tree threshold
 * - it is introduces in JAVA 8. When the collision occurred som many times on the same index of hash table and the size of linked list increased by 8. Then we will convert them in BBT(Balanced binary tree). Because it will maintain the complexity by o(1) that is constant.
 * Which data structure is used to implement the hashMap.
 *  Arrays , LinkedList and Balanced Binary tree.
 * Is HashMap Threadsafe in java
 * No its not , to use thread safe hashmap we need to use the ConcurrentHashMap added in java 5.
 * How do you remove a mapping while iterating over hashMap in java.
 * Use remove() of iterator.
 * Iterator itr = map.enterySet().iterator()
 * While(ite.hasNext()){
 * Map.Entry current = itr.next()
 * if(current.getKey().equals(“matching”)){
 * itr.remove()
 * }}.
 *
 * size() that return a int value that has a limit , so the the size of hashmap increased by int limit then it will be failed. To resolved this a new method is introduced in JAVA 8 mappingCount()  this one return long
 * Capacity : - how many entries hashTable can have.
 * Size:- entries currently present.
 *
 * Difference between ConcurrentHashMap  and HashTable?
 * Both are used in thread safe environment , to perform the thread safe operations in Multithreaded environment on Map.
 * ConcurrenthadhMap is more fast and perform better.
 * HashTable -> lock complete object
 * CoucurrentHashMap -> lock some part of object. Just like synchronized method and synchronized block.
 * Does Hashtable allows null key and value ?
 * No, Hashtable does not allow to store null key or null value.
 * Any attempt to store null key or value throws runtimeException (NullPointerException) in java.
 * If we are using an object as a Key for hashMap then it should be immutable objects as key, else we will get null values for the key. We should use the equals and hascode method with immutable class.
 * */
