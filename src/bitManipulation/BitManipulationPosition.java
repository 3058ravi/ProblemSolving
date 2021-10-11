package bitManipulation;

public class BitManipulationPosition {

    public static void main(String[] args) {
        System.out.println(checkIfANumberPowerOf2(16));
        System.out.println(findPositionOfRightMostSetOfBit(20));
        System.out.println(findPositionOfOnlySetBitInNumber(16));
//        swapTwoNumberWithoutUsingThirdVariable(5, 6);
    }

    public static boolean checkIfANumberPowerOf2(int n){
        return (n&(n-1))==0;
    }

    public static int findPositionOfRightMostSetOfBit(int n){
        if((n&1) != 0)
            return 1;
        n= (n&(n-1))^n;
        int count=0;
        while(n!=0){
            n=n>>1;
            count++;
        }
        return count;
    }

    public static int findPositionOfOnlySetBitInNumber(int n){
        if((n&(n-1))!=0){
            System.out.println("Invalid input");
            return Integer.MIN_VALUE;
        }
            return (int)(Math.log(n)/Math.log(2))+1;
    }
}
