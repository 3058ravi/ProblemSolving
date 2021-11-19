package String;

import utils.CommonUtils;

import java.util.Arrays;

public class NextGreaterNumber {
    public static void main(String[] args){

        char digits[] = { '2','1','8','7','6','5' };
        int n = digits.length;
        findNext(digits, n);
    }

    public static void findNext(char[] digits, int n){
        int i;
        for( i=n-1; i>0; i--){
            if(digits[i]>digits[i-1])
                break;
        }
            swap(digits, i - 1, n-1);
        Arrays.sort(digits,i,n);

        System.out.println(String.valueOf(digits));
    }

    public static void swap(char[] digits, int i, int j){
        char temp=digits[i];
        digits[i]=digits[j];
        digits[j]=temp;
    }
}
