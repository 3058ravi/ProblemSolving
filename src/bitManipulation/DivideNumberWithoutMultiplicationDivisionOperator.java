package bitManipulation;

public class DivideNumberWithoutMultiplicationDivisionOperator {
    public static void main(String[] args){
        int divident=43, divisor=-8;
        int sign =((divident<0)^(divisor<0))?-1:1;
        System.out.println(sign* divideNumberWithoutMultiplicationDivisionOperator(Math.abs(divident), Math.abs(divisor)));
    }
    public static int divideNumberWithoutMultiplicationDivisionOperator(int divident, int divisor){
        if(divident<divisor) return 0;
        int sum=divisor;
        int multiple=1;
        while(sum+sum<=divident){
            sum=sum+sum;
            multiple=multiple+multiple;
        }

        return multiple+ divideNumberWithoutMultiplicationDivisionOperator(divident-sum,divisor);
    }
}
