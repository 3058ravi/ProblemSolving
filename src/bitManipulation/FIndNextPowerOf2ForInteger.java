package bitManipulation;

public class FIndNextPowerOf2ForInteger {

    public static void main(String[] args){
        System.out.println(findNextPowerOfTwo(64));
    }

    public static int findNextPowerOfTwo(int a){
        int k=2;
        a=a-1;
        while((a>>=1)!=0){
            k=k<<1;
        }
        return k;
    }
}
