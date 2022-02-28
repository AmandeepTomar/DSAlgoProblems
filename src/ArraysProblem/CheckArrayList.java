package ArraysProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class CheckArrayList {
    public static void main(String[] args) {
        try {
            List<Integer> list=new ArrayList<>();
           // list.add(null);
            list.add(1);

            System.out.println(list);

            List<String> strList=new ArrayList<>();
            strList.add(null);

            System.out.println(strList);

            List<Integer> list1=List.copyOf(list);
            list1.add(3);

            System.out.println(list1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
