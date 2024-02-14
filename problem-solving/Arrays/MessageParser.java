package Arrays;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageParser {

    public static void main(String[] args) {
        int N = 6;
        String[][] input = new String[][] {
                {"585", "*"},
                {"1", "*"},
                {"2", "a"},
                {"583", "*"},
                {"3", "*"},
                {"584", "w"}
        };
        parseMessage(N, input);
    }

    static void parseMessage(int length, String[][] input) {
        Map<Integer,String> map = new HashMap<>();
        int[] list = new int[length];

        for (int i=0 ; i < length ; i++){
            int index = Integer.parseInt(input[i][0]);
            String character = input[i][1];
            map.put(index, character);
            if (!character.isEmpty()) {
                list[i] = index;
            }
        }
        Arrays.sort(list);

        StringBuilder string = new StringBuilder();
        for (int i : list) {
            string.append(map.get(i));
        }
        matcher(string.toString());

    }

    static void matcher(String input) {

        String regex = "(?!_)[a-z]+|\\(\\*(?!_)[a-z]+\\*\\)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
