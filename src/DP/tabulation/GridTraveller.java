package DP.tabulation;

import java.util.Arrays;

public class GridTraveller {
    public static void main(String[] args){
        System.out.println(gridTraveller(4,4));
    }

    public static int gridTraveller(int m, int n){
        int arr[][] = new int[m+1][n+1];
        Arrays.fill(arr[0],0);
        arr[1][1]=1;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                int curr= arr[i][j];
                if(i+1<=m)
                    arr[i+1][j]+=curr;
                if(j+1<=n)
                    arr[i][j+1] +=curr;
            }
        }
        return arr[m][n];
    }
}
