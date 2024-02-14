package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Countthecharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine(); int N = sc.nextInt();
        HashMap<Character, Integer> charIntMap = new HashMap<>();
        int count = 0;
        char[] charArray = S.toCharArray();
        char prev = charArray[0];
        charIntMap.put(prev, 1);
        for (int i = 1; i < charArray.length; i++) {
            char c = charArray[i];
            if (prev == c) continue;
            int val = charIntMap.containsKey(c) ? charIntMap.get(c) + 1 : 1;
            charIntMap.put(c, val);
            prev = c;
        }
        for (Integer value : charIntMap.values()) {
            if (value == N) {
                count++;
            }
        }
        System.out.println(count);
    }
}
