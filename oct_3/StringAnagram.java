package oct_3;

public class StringAnagram {
    static void fun1(String s1, String s2) {
        char[] arr = new char[26];
        if (s1.length() != s2.length()) {
            System.out.println("Not anagram");
            return;
        }
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']--;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (arr[i] != 0)
                System.out.println("Not anagram");
        }
        System.out.println("it is anagram");
    }

    public static void main(String[] args) {
        String s1 = "bye";
        String s2 = "hello";
        fun1(s1, s2);
    }
}
