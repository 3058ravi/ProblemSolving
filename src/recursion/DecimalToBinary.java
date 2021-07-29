package recursion;

public class DecimalToBinary {
    public static void main(String[] args){
        int x= 99;
       System.out.println( decimalToBinary(x,""));
    }

    public static String decimalToBinary(int x, String result){
        if(x==0){
            return result;
        }
        result=x%2+result;
        return decimalToBinary(x/2,result);
    }
}
