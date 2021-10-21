package easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class RomanToInt {

    public static int romanToInt(String s) {

        LinkedList<Integer> quene = new LinkedList<Integer>();
        //利用quene來保存一連串的數字
        //從最右邊開始看,如果下一個>或=就+,下一個<就減
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);//從最右邊的開始放
            switch (temp){
                case('I') : quene.add(1);
                    break;
                case('V') : quene.add(5);
                    break;
                case('X') : quene.add(10);
                    break;
                case('L') : quene.add(50);
                    break;
                case('C') : quene.add(100);
                    break;
                case('D') : quene.add(500);
                    break;
                case('M') : quene.add(1000);
                    break;
            }
        }

        int ans = 0;
        int temp = 0;
        for (int i = quene.size()-1; i >=0 ; i--) {
            temp = quene.get(i);
           if(i==quene.size()-1){
               ans+=temp;
               continue;
           }else{
               if(quene.get(i+1)>temp){
                   ans-=temp;
               }else{
                   ans+=temp;
               }
           }


//               //表示沒有前一個
//                if(quene.get(i+1)<temp){
//                    ans += temp;
//                }else{
//                    ans -=temp;
//                }
//           }else {
//                if (quene.get(i-1)< temp){
//                    ans = temp -quene.get(i-1);
//                }else{
//                    ans = temp +quene.get(i-1);
//                }
//           }
            System.out.println("@"+ans);
        }


        Iterator<Integer> it = quene.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("ans "+ans);

        return ans;
    }

    public static void main(String[] args) {
        romanToInt("MCMXCIV");
    }
}
