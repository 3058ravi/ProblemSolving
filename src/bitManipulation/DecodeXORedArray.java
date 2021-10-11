package bitManipulation;

import utils.CommonUtils;

public class DecodeXORedArray {
    public static void main(String[] args){
        int[] encoded ={1,2,3};
        int first=1;
        int[] arr=decodeXORedArray(encoded, first);
        CommonUtils.printArray(arr);
    }

    public static int[] decodeXORedArray(int[] encoded, int first){
        int[] ans= new int[encoded.length+1];
        ans[0]=first;
        for(int i=0; i<encoded.length; i++){
            ans[i+1]=ans[i]^encoded[i];
        }
        return ans;
    }
}
