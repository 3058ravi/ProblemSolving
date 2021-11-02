package recursion;

public class KthSymbolInGrammer {
    public static void main(String[] args){
        System.out.println(kthSymbolInGrammer(4,5));
    }

    public static int kthSymbolInGrammer(int n, int k){
            if(n==1&& k==1)
                return 0;

            int mid=(int) Math.pow(2,n-1)/2;
            if(k<=mid)
                return kthSymbolInGrammer(n-1,k);
            else
                return kthSymbolInGrammer(n-1, k-mid)==0?1:0;
    }
}
