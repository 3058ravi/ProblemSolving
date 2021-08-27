package backtracking;

public class AllPermutationOfString {

    public static void main(String[] args){
        String test= "ABCDE";
        int length= test.length()-1;
        permute(test,0,length);
    }

    public static void permute(String str, int left, int right){
        if(left==right)
            System.out.println(str);
        else{
            for(int i=left; i<=right; i++){
                str=swap(str,left,i);
                permute(str,left+1,right);
                str=swap(str,left,i);
            }
        }

    }

    public static String swap(String str, int i, int j){
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
