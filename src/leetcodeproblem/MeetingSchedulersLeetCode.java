package leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

public class MeetingSchedulersLeetCode {

    public static void main(String[] args) {
        int[][] slots1 = new int[][]{{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = new int[][]{{0, 15}, {60, 70}};
        int duration = 8;
        List<Integer> list = minAvailableDuration(slots1, slots2, duration);
        System.out.println(list);
    }

    private static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int i = 0,
                j = 0,
                m = slots1.length,
                n = slots2.length,
                start = Integer.MIN_VALUE,
                end = Integer.MIN_VALUE;
        while (i<m && j<n){
            start = Math.max(slots1[i][0],slots2[j][0]);
            end = Math.min(slots1[i][1],slots2[j][1]);
            if(start-end>=duration){
                return List.of(start,start+duration);
            }else if(slots1[i][1]<slots2[j][1]){
                i++;
            }else {
                j++;
            }
        }
        return new ArrayList<>();
    }

}
