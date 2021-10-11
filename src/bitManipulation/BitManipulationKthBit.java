package bitManipulation;

public class BitManipulationKthBit {
    public static void main(String[] args) {
        System.out.println("6 after turning off 2nd bit is: "+turnOffKthBit(6,2));
        System.out.println("6 after turning on 1st bit is: "+turnOnKthBit(6, 1));
        System.out.println(checkIfKthBitIsSet(6,1));
        System.out.println("6 after toggling 2nd bit is: "+toggleKthBit(6,2));
    }

    public static int turnOffKthBit(int n,int k){
        return n & ~(1<<(k-1));
    }

    public static int turnOnKthBit(int n,int k){
        return n | (1<<(k-1));
    }

    public static boolean checkIfKthBitIsSet(int n,int k){
        return (n & (1<<(k-1)))>0;
    }

    public static int toggleKthBit(int n,int k){
        return n ^ (1<<(k-1));
    }
}
