package backtracking;

public class CookieDistribution {
        int ans=Integer.MAX_VALUE;
        public int distributeCookies(int[] cookies, int k) {
            int[] res=new int[k];
            distributeCookies(cookies,k, 0,res);
            return ans;
        }

        public void distributeCookies(int[] cookies,int k, int start,int[] res){
            if(start == cookies.length){
                int max=0;
                for(int c: res){
                    max=Math.max(max,c);
                }
                ans= Math.min(ans, max);
                return;
            }
            for(int i=0; i<k; i++){
                res[i] +=cookies[start];
                distributeCookies(cookies, k,start+1, res);
                res[i] -=cookies[start];
            }

        }

        public static void main(String[] args){
            int[] cookies = {8,15,10,20,8};
            int k = 2;
            CookieDistribution cd = new CookieDistribution();
            cd.distributeCookies(cookies,k);
        }
}
