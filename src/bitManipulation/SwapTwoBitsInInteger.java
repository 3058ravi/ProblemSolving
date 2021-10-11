package bitManipulation;

public class SwapTwoBitsInInteger {
    public static void main(String[] args){
        int a=24, p=0,q=3;
        System.out.println(swapBitsInPair(a));
    }

    public static int swapTwoBitsInInteger(int a, int p, int q){
        int bit1= (a>>p)&1;
        int bit2= (a>>q)&1;
        int x= bit1^bit2;
        x=(x<<p)|(x<<q);
        return a^x;
    }

    static int swapBitsInPair( int x)
    {

        return ((x & 0b10101010) >> 1) |
                ((x & 0b01010101) << 1);
    }
}
