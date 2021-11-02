package bitManipulation;

import utils.CommonUtils;

public class FindTwoNonRepeatingElementsInRepeatingArray {
    public static void main(String[] args){
        int[] arr={1,2,5,2,1,10};
        CommonUtils.printArray(findTwoNonRepeatingElementsInRepeatingArray(arr));
    }

    public static int[] findTwoNonRepeatingElementsInRepeatingArray(int[] arr){
        int n= arr.length;
        int[] res = new int[2];
        int XOR=0, res1=0, res2=0;

        for(int i=0; i<n; i++){
            XOR= XOR^arr[i];
        }

        XOR = (XOR & -XOR);

        for(int i = 0; i<n;i++) {

            if((XOR & arr[i]) == 0) {

                res1 = (res1 ^ arr[i]);
            }
            else
                res2 = (res2 ^ arr[i]);
        }

        res[0] = res1<res2?res1:res2;
        res[1] = res1>res2?res1:res2;

        return res;
    }
}
