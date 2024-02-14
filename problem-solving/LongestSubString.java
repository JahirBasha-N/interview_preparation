import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        String input = "abcbbcad"; // output longest substring abc
        char[] charArray = input.toCharArray();
        int len = input.length();
        int maxLen = 0;
        int currentLength = 0;
        int startIndex = 0;
        Map<Character, Integer> charVsIndex = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = charArray[i];
            if (charVsIndex.containsKey(c)) {
                startIndex = charVsIndex.get(c) + 1;
                currentLength = currentLength - (i - startIndex);
            }
            currentLength++;
            if (currentLength > maxLen) {
                maxLen = currentLength;
            }
            charVsIndex.put(c, i);
            System.out.println(charVsIndex + " " + currentLength);
        }
        System.out.println(maxLen);
    }
}
