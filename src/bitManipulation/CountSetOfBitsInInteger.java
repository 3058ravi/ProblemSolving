package bitManipulation;

public class CountSetOfBitsInInteger {

    /*
    sol:
     */

    public static void main(String[] args) {
        System.out.println(CountSetOfBitsInNumber(156));
        System.out.println(countBits(156));
    }

    static int CountSetOfBitsInNumber(int n) {
        int count = 0;
        String bin = "";
        while (n >= 1) {
            if (n % 2 == 1) {
                bin = "1" + bin;
                count++;
            } else {
                bin = 0 + bin;
            }
            n = n / 2;
        }
        return count;

    }

    public static int countBits(int n) {
        int count=0;
        while(n!=0){
            n=n& (n-1);
            count++;
        }
        return count;
    }

}
