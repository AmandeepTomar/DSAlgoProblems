package HackerrankProblems;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JumpingCloudProblem {

    public static void main(String[] args) {
        Integer array[]=new Integer[]{0,0,1,0,0,1,0};
        System.out.println(jumpingOnClouds(Arrays.asList(array)));
    }

    public static int jumpingOnClouds(List<Integer>  c) {
        // Write your code here
        System.out.println(c.size());
        int count=-1;
        for(int i=0;i<c.size();i++,count++){
            if(i+2<c.size() && c.get(i+2)==0){
                i++;
            }
        }
        return count;

    }

}
