package bitManipulation;

public class SquareOfNumberWithoutMultiplication_pow_divide {
    public static void main(String[] args){


        System.out.println( squareOfNumberWithoutMultiplication_pow_divide(Math.abs(-9)));
    }

    public static int squareOfNumberWithoutMultiplication_pow_divide(int n){
        if(n==0)
            return 0;
        int x=n>>1;
        if(n%2!=0)
            return ((squareOfNumberWithoutMultiplication_pow_divide(x)<<2)+ (x<<2)+1);
        else
            return (squareOfNumberWithoutMultiplication_pow_divide(x)<<2);

    }
}
