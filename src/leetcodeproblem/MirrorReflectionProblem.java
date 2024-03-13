package leetcodeproblem;
/***
 * 858. Mirror Reflection
 * Medium
 * Topics
 * Companies
 * There is a special square room with mirrors on each of the four walls. Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
 *
 * The square room has walls of length p and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
 *
 * Given the two integers p and q, return the number of the receptor that the ray meets first.
 *
 * The test cases are guaranteed so that the ray will meet a receptor eventually.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = 2, q = 1
 * Output: 2
 * Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
 * */
public class MirrorReflectionProblem {

    public static void main(String[] args) {
        int p = 10;
        int q = 4;
        int res =mirrorReflection(p,q);
        System.out.println(res);

    }


    // cases p = 2 q = 1 => 2
    // case p = 1 q = 1 => 1
    // case p 3 q=2 => 0
    private static int mirrorReflection(int p, int q) {
        while((p & 1) == 0 && (q&1)==0){
            p = p/2;
            q = q/2;
        }
        if ((p&1)==0) return 2;
        if ((q&1)==0) return 0;
        return 1;
    }
}
