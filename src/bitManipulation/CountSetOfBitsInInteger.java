package bitManipulation;

public class CountSetOfBitsInInteger {

    /*
    sol:
     */

    public static void main(String[] args) {
        System.out.println(setBits(156));
    }

    static int setBits(int n) {
        int count = 0;
        String bin="";
        while (n >= 1) {
            if (n % 2 == 1) {
                bin="1"+bin;
                count++;
            }else{
                bin=0+bin;
            }
            n = n / 2;
        }
        return count;

    }

}
