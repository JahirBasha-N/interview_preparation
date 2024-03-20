package BackTracking;

public class LexicographicalIncreasingCharacter {
    public static void main(String[] args) {
        int n = 7;
//        StringBuilder result = new StringBuilder();
//        long l2 = System.currentTimeMillis();
//        backTrack(n, 0, 0, result, 0);
//        long l3 = System.currentTimeMillis();
//        System.out.println(result + " time " + (l3 - l2));
//        long l = System.currentTimeMillis();
//        String string = generateSmallestString(n);
//        long l1 = System.currentTimeMillis();
//        System.out.println(string + " time " + (l1 - l));
        System.out.println(method3(n));
    }

    private static String method3(int n) {
        StringBuilder ans = new StringBuilder();
        if(n%2 == 0){
            int j=1;
            while(j<n){
                ans.append('a');
                j++;
            }
            ans.append('c');
        }
        else {
            int j = 1;
            while (j < n) {
                ans.append('a');
                j++;
            }
            ans.append('b');
        }
        return ans.toString();
    }
    private static boolean backTrack(int n, int index, int sum, StringBuilder result, int iteration) {
        if (iteration == n && sum % 2 == 0) return true;
        if (index == n || iteration == n || result.length() == n) {
            return false;
        }
        char c = (char) (index + (int) 'a');
        sum += index + 1;
        result.append(c);
        if (backTrack(n, index, sum, result, iteration + 1)) return true;
        sum -= index + 1;
        result.deleteCharAt(result.length() - 1);
        iteration -= 1;
        return backTrack(n, index + 1, sum, result, iteration + 1);
    }
    private static String generateSmallestString(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(sb, n, 0, 0);
        return sb.toString();
    }

    private static boolean backtrack(StringBuilder sb, int n, int sum, int index) {
        if (index == n) {
            return sum % 2 == 0;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int value = ch - 'a' + 1;
            sb.append(ch);
            sum += value;

            if (backtrack(sb, n, sum, index + 1)) {
                return true;
            }

            // Backtrack
            sb.deleteCharAt(sb.length() - 1);
            sum -= value;
        }

        return false;
    }
}
