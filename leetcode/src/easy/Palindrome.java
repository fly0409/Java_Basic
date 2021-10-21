package easy;

public class Palindrome {

    public static boolean isPalindrome2(int x) {
        String snum = Integer.toString(x);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < snum.length(); i++) {
            sb.append(snum.charAt(snum.length()-i-1));
        }
        return snum.equals(sb.toString());
    }

    public static boolean isPalindrome(int x) {
       if(x<0 || (x%10==0)&&x!=0) {
           return false;
       }
       int flip = 0;//慢慢翻轉的值初始化
       int lsd = 0;//最後一位
        //ex x=121
       while(x>flip){           //121 >0   =>12>1
            lsd = x % 10;       //lsd = 1  =>lsd=2
            flip = flip*10+lsd; //flip = 1 =>flip = 12
            x/=10;              //x = 12   =>x = 1
       }
       return x==flip || x==flip/10; //x==12/10
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(10101));
    }
}
