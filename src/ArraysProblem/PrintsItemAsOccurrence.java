package ArraysProblem;

import java.util.*;

/**
 * you Have given an array you need to print the array as the Occurrence or array
 *
 * Example Input
 * Input {1,1,2,3,4,5}
 * Output {3,4,5,1,1}
 *
 * Input {1,2,3,4,4,4,2,3,7,6,8,9,9,10,11};
 * Output [1, 6, 7, 8, 10, 11, 2, 2, 3, 3, 9, 9, 4, 4, 4]
 * */

public class PrintsItemAsOccurrence {

    public static void main(String[] args) {
        int arr[]={1,2,3,4,4,4,2,3,7,6,8,9,9,10,11};

        solution(arr);
    }

    private static void solution(int[] arr) {
        List<Pair> list=new ArrayList<>();
        List<Integer> listFinal=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                int value=map.get(arr[i])+1;
                map.put(arr[i],value);
            }else {
                map.put(arr[i],1);
            }
        }

        for(Integer key : map.keySet()){
            list.add(new Pair(key,map.get(key)));
        }

        Collections.sort(list,new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p1.getCount()-p2.getCount();
            }
        });

        System.out.println(list);

        for (int i = 0; i <list.size() ; i++) {
            getFinalList(list.get(i),listFinal);
        }

        System.out.println(listFinal);
    }

    private static List<Integer> getFinalList(Pair pair, List<Integer> listFinal) {
        for (int i = 0; i <pair.getCount() ; i++) {
            listFinal.add(pair.getValue());
        }
        return listFinal;
    }

}

class Pair{
    private int value;
    private int count;

    public Pair(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value=" + value +
                ", count=" + count +
                '}';
    }
}
