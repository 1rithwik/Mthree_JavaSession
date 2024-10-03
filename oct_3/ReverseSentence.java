package oct_3;

import java.util.*;

public class ReverseSentence {
    static void fun1(String s) {
        char[] arr = s.toCharArray();
        String ans = "", currString = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                ans = ans + currString + " ";
                currString = "";
            } else {
                currString = arr[i] + currString;
            }
        }
        ans = ans + currString;
        System.out.println(ans);
    }

    static void fun2(String s) {
        Stack<String> st = new Stack<>();
        String[] s1 = s.split(" ");
        for (String str1 : s1) {
            st.push(str1);
        }
        String ans = "";
        while (!st.isEmpty()) {
            ans = ans + st.pop() + " ";
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String str = "this is not the right time to do";
        fun1(str);
        fun2(str);
    }
}
