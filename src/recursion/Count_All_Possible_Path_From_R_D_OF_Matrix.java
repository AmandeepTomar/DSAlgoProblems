package recursion;

public class Count_All_Possible_Path_From_R_D_OF_Matrix {
    private static int Ro = 3;
    private static int Co=3;
    public static void main(String[] args) {
        int r =3;
        int c =3;
        int ways = ways(r-1,c-1); // answer = 6.
        System.out.println(" No of ways are "+ways);

        int waysNew = waysWhenWeStartFrom0(0,0);
        System.out.println("Ways from 0,0 index "+waysNew);

    }

    private static int ways(int r,int c){
        if (r==0 || c==0) return 1;
       return ways(r-1,c)+ways(r,c-1);
    }

    private static int waysWhenWeStartFrom0(int row,int column){
        if (row==Ro-1 || column ==Co-1){
            return 1;
        }
       return waysWhenWeStartFrom0(row+1,column) + waysWhenWeStartFrom0(row,column+1);
    }
}
