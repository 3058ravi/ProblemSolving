package DP.tabulation;

public class AssemblyLineSchedulingProblem {
    public static void main(String[] args) {
        int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};

        System.out.println(carAssembly(a, t, e, x));

    }

    public static int carAssembly(int[][] a, int[][] t, int[] e, int[] x) {
        int n = a[0].length;
        int[] l1 = new int[n];
        int[] l2= new int[n];

        l1[0]=e[0]+a[0][0];
        l2[0]=e[1]+a[1][0];

        for(int i =1; i<n; i++){
            l1[i]= Math.min(l1[i-1]+a[0][i],l2[i-1]+t[1][i]+a[0][i]);
            l2[i]= Math.min(l2[i-1]+a[1][i],l1[i-1]+t[0][i]+a[1][i]);
        }

        l1[n-1]+=x[0];
        l2[n-1]+=x[1];

        return Math.min(l1[n-1], l2[n-1]);

    }
}
