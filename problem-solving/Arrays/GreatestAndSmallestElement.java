package Arrays;

import java.util.Arrays;

public class GreatestAndSmallestElement {
    public static void main(String[] args) {
        int[] integers = new int[]{1, 5, 6, -2, 9};
        // first
        int smallestNum = integers[0];
        int greatestNum = integers[0];
        for (int integer : integers) {
            if (integer < smallestNum) {
                smallestNum = integer;
            }
            if (integer > greatestNum) {
                greatestNum = integer;
            }
        }
        System.out.println(smallestNum + " " + greatestNum);
        // second
        int maxNum = Arrays.stream(integers).max().getAsInt();
        int minNum = Arrays.stream(integers).min().getAsInt();
        System.out.println(maxNum + " " + minNum);
    }
}
