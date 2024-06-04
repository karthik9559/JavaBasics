package tests;

public class rider {
    public static void main(String[] args) {
        int ans = Integer.MAX_VALUE;
        int[] A = {1, 3, 2, 4, 5};
        int i = 0;
        int j = A.length - 1;
        while(i < j){
            ans = Math.min(ans, Math.abs(A[i]-A[j]));
            i++;
            j--;
        }
        System.out.println(ans);
    }
}
