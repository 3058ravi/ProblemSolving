package bitManipulation;

public class BitsNeedToFlipForIntegerAToB {

    public static void main(String[] args) {
        System.out.println(findNumberOfBitsToBeFlipped(65, 80));
    }

    public static int findNumberOfBitsToBeFlipped(int a, int b) {
        int x = a ^ b;
        return Integer.bitCount(x);

    }
}
