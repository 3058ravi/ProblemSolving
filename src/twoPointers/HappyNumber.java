package twoPointers;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(findHappyNumber(23));
    }

    public static boolean findHappyNumber(int a) {
        int slow = a, fast = a;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static int findSquareSum(int a) {
        System.out.println("a="+a);
        int res = 0;
        while (a > 0) {
            int x = a % 10;
            res += x * x;
            a = a / 10;
        }
        System.out.println("res="+res);
        return res;
    }
}
