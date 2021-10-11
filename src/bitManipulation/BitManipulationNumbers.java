package bitManipulation;

public class BitManipulationNumbers {

    public static void main(String[] args) {
        System.out.println(checkIntegerisOddOrEven(6));
        System.out.println(checkTwoIntegersAreOppositeSign(-6, -5));
        System.out.println(addOneToInteger(5));
        swapTwoNumberWithoutUsingThirdVariable(5, 6);
    }

    public static boolean checkIntegerisOddOrEven(int n) {
        return (n & 1) != 0;
    }

    public static boolean checkTwoIntegersAreOppositeSign(int a, int b) {
        return (a ^ b) < 0;
    }

    public static int addOneToInteger(int a) {
        return -~(a);
    }

    public static void swapTwoNumberWithoutUsingThirdVariable(int a, int b) {
        System.out.println("Before Swap - a: " + a + " and b: " + b);
        if (a != b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        System.out.println("After Swap - a: "+a + " and b: " + b);
    }
}
