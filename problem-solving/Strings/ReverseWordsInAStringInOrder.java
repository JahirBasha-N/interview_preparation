package Strings;

public class ReverseWordsInAStringInOrder {
    public static void main(String[] args) {
        String string = "abc    cde efg ";
        StringBuilder resultString = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == ' ') {
                stringBuilder.reverse();
                resultString.append(stringBuilder);
                stringBuilder = new StringBuilder();
                resultString.append(c);
            } else {
                stringBuilder.append(c);
            }
            if (i == string.length() - 1) {
                resultString.append(stringBuilder.reverse());
            }
        }
        System.out.println(resultString);
    }
}
