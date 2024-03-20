package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        for (int i = 0; i + s1.length() < s2.length(); i++) {
            String temp = s2.substring(i, i + s1.length());
            char[] charArray = temp.toCharArray();
            Arrays.sort(charArray);
            String string = Arrays.toString(charArray);
            char[] charArray1 = s1.toCharArray();
            Arrays.sort(charArray1);
            String string1 = Arrays.toString(charArray1);
            System.out.println(string.equals(string1));
        }
    }
}
