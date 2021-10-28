package matrix;

public class MatrixRowWithMaxNumberof1 {

    public static void main(String[] args){
        int arr[][] = {{0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}};

        System.out.println(findRowWithMax1(arr, arr.length, arr[0].length));
    }

    public static int findRowWithMax1(int[][] mat, int m, int n){
        int i=0, j=n-1, ans=-1;
        while(i<m && j>=0){
            if(mat[i][j]==1) {
                ans = i;
                j--;
                if(j<0)
                    break;
            }
            if(mat[i][j]==0){
                i++;
            }
        }
        return ans;
    }
}
