package bitManipulation;

public class SwapSpecificBitsInaInteger {
    public static void main(String[] args){
        System.out.println(swapSpecificBitsInInteger(47,1,5, 3));
    }

    public static int swapSpecificBitsInInteger(int n, int p, int q, int b){
    int x= (n>>p)^(n>>q);
     x= x & ((1<<b)-1);

     return n ^((x<<p)|(x<<q));
    }
}
