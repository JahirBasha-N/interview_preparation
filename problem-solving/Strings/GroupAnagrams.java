package Strings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int charSum = 0;
            for (int i = 0; i < str.length(); i++) {
              int askVal = str.charAt(i);
              charSum += askVal;
            }
            if (map.containsKey(charSum)) {
                List<String> strings = new ArrayList<>(map.get(charSum));
                strings.add(str);
                map.put(charSum, strings);
            } else {
                map.put(charSum, Collections.singletonList(str));
            }
        }
        System.out.println(map.values().stream().toList());
    }
}
