package easy;

import java.util.Stack;

public class ValidParenthese {

    public static boolean isValid(String s) {
        if(s.length()==0 || s.length()%2!=0){
            return false;
        }

        //放左邊括號的
        Stack<Character> left = new Stack<>();
        //放右邊括號的
        Stack<Character> right = new Stack<>();

        //便歷&檢查
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='('||ch=='{'||ch=='['){

                left.push(ch);
            }else if(ch==')'||ch=='}'||ch==']'){
                //

                //if(left.peek()==ch){
                if(left.size()>0 && bracketsCheck(left.peek(),ch)){
                   left.pop();
                }else{
                   right.push(ch);
                }

            }else{
                System.out.println("input error");
            }
        }
        //把存在裡面的左括號又括號確認
        while(right.size()>0 && left.size()>0){
            //if(right.peek()==left.peek()){
            if(bracketsCheck(right.peek(),left.peek())){
                right.pop();
                left.pop();
            }else{
                break;
            }
        }
//        System.out.println("leftSize"+left.size());
//        System.out.println("rightSize"+right.size());


        if (right.size()==0 && left.size()==0){
            return true;
        }

        return false;
    }

    public static boolean bracketsCheck(char a,char b){
        switch (a){
            case '(':
                if(b == ')'){
                    return true;
                }
                break;
            case '[':
                if(b == ']'){
                    return true;
                }
                break;
            case '{':
                if(b == '}'){
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }


    public static void main(String[] args) {

        // "))","}(",")){{"
        String s = "{{([])}}";
        System.out.println(isValid(s));
    }
}
