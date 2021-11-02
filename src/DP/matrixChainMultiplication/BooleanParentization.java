package DP.matrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

public class BooleanParentization {
    public static void main(String[] args){
        String s="T|F&T^F";
        int n=s.length();
        Map<String, Integer> dp= new HashMap<>();
        System.out.println(booleanParentization(s, 0,n-1, true,dp));
    }
    public static int booleanParentization(String s, int i, int j, boolean isTrue, Map<String, Integer> dp){
        int ans=0;
        if(i>j)
            return 0;
        if(i==j){
            if(isTrue)
                return s.charAt(i)=='T'?1:0;
            else
                return s.charAt(i)=='F'?1:0;
        }

        String temp= i+" "+j+" "+isTrue;
        if(dp.containsKey(temp))
            return dp.get(temp);

        for(int k=i+1; k<=j-1; k=k+2 ){
            int lt=booleanParentization(s, i,k-1,true,dp);
            int lf=booleanParentization(s, i,k-1,false,dp);
            int rt=booleanParentization(s, k+1,j,true,dp);
            int rf=booleanParentization(s, k+1,j,false,dp);


            if(s.charAt(k)=='&'){
                if(isTrue)
                    ans=ans+ lt*rt;
                else
                    ans=ans+ lf*rf+lt*rf+lf*rt;
            }else  if(s.charAt(k)=='|'){
                if(isTrue)
                    ans=ans+ lt*rt+lt*rf+lf*rt;
                else
                    ans=ans+ lf*rf;
            }else if(s.charAt(k)=='^'){
                if(isTrue)
                    ans=ans+ lt*rf+lf*rt;
                else
                    ans=ans+ lt*rt+lf*rf;
            }
        }

        dp.put(temp, ans);
        return ans;
    }
}
