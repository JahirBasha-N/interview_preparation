package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        List<Integer> coinList = Arrays.stream(coins)
                .boxed()
                .toList();
        int currentMin = Integer.MAX_VALUE;
        int quo = 0;
        for (int coin : coins) {
            int rem = amount % coin;
            quo = amount / coin;
            if (rem != 0 && coinList.contains(rem)) {
                if (quo + rem < currentMin) {
                    currentMin = quo + rem;
                }
            } else if (rem == 0){
                if (quo < currentMin) {
                    currentMin = quo;
                }
            }
        }
        System.out.println(quo != 0 && currentMin == Integer.MAX_VALUE ? -1 : currentMin);
        // wrong answer

    }
}
