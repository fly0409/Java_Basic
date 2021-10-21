package easy;

import java.util.LinkedList;

public class LongestPrefix {

    public static String longestCommonPrefix(String[] strs) {
        //建立一個buffer存char
        LinkedList<Character> ans = new LinkedList<Character>();
        //把第一個整個char存在此buffer裡
        //如果第二個字串前面有相同的，就紀錄

        if(strs.length==1){//處理input陣列只有一個的情況
            return strs[0];
        }

        for (int i = 0; i < strs.length; i++) {
                if(i==0&&strs[i].length()>0){continue;}

                if(strs[i].length()==0){//處理首字串為空的情況
                    ans=null;
                    break;
                }
                for (int j = 0; j <strs[i].length() ; j++) {

                    //先從前兩個挑出相同的prefix
                    if(i==1&&j<strs[i-1].length()){//避免第二個字串超過第一個字串
                        char ch;
                        if((ch=strs[i-1].charAt(j))==strs[i].charAt(j)){
                            ans.add(ch);
                        }else{
                            break;
                        }
                    }else{
                        //如果後續字串有不符合的就扣掉
                        if(j<ans.size() &&j<strs[i].length()&& strs[i].charAt(j)!=ans.get(j)){
                            int length = ans.size();
                            for (int k = j; k < length; k++) {
                                ans.remove(j);
                            }

                        }
                    }
                }
                if(ans.size()==0){
                    break;//若ans為空直接跳出
                }
        }

        StringBuilder result=new StringBuilder();
        if(ans!=null){
            for (int i = 0; i < ans.size(); i++) {
                result.append(ans.get(i));
            }
        }



        return result.toString();
    }

    public static String betterSolution(String[] strs){
        if(strs.length==0 || strs[0].length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        //把第一個字串抓出來,把第n個char 跟所有str的第n個比,
        int count = 0;

        for(char a : strs[0].toCharArray()){
            for (int i = 1; i < strs.length; i++) {
                //處理字串長度問題
                if(count>=strs[i].length() || a!=strs[i].charAt(count)) {//只要有一個不符合就return
                    return sb.toString();
                }
            }
            //都符合的話就放進去stringBuilder裡面
            sb.append(a);
            count++;
        }
        return sb.toString();


    }

    public static void main(String[] args) {
        String[] strs = {"aba","abab","ab",""};
        String res = betterSolution(strs);
        System.out.println("@"+res);
    }

}

