package matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class spiral {
    public static void main(String[] args){
        int a[][] = { { 1, 2, 3, 4 , 5},
                { 6, 7, 8,9,10 },
                { 11, 12,13,14,15 },
                {16,17,18,19,20 },
                {21,22,23,24,25}   };

        spiralOrder(a,0,0,5,5);

    }

    public static void spiralOrder(int[][] mat, int i, int j, int m, int n){

        if(i>=m||j>=n)
            return ;
       for(int p=j; p<n; p++)
           System.out.print(mat[i][p]+"->");
        for(int p=i+1; p<m; p++)
            System.out.print(mat[p][n-1]+"->");
        if(m-1!=i){
            for(int p=n-2; p>=j; p--)
                System.out.print(mat[m-1][p]+"->");
        }
        if(n-1!=j) {
            for (int p = m - 2; p >= i + 1; p--)
                System.out.print(mat[p][j] + "->");
        }
        spiralOrder(mat, i+1,j+1,m-1, n-1);
    }
}
