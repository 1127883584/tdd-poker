package pokers;

import java.util.*;
import java.util.stream.Collectors;

public class PokerHandler {
    public List<Poker> handle(List<Poker> player1, List<Poker> player2) {
        List<Poker> winner = null;

        List<Integer> formatPlayer1 = new ArrayList<>();
        List<Integer> formatPlayer2 = new ArrayList<>();

        HashMap<List<Integer>, List<Poker>> hashMap = new HashMap<>();

        hashMap.put(formatPlayer1, player1);
        hashMap.put(formatPlayer2, player2);

        for(int i = 0; i < 5; i ++) {
            formatPlayer1.add(player1.get(i).formatToNumber());
            formatPlayer2.add(player2.get(i).formatToNumber());
        }
        Collections.sort(formatPlayer1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Collections.sort(formatPlayer2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });


        Map<Integer, Long> mapFormatPlayer1 = formatPlayer1.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        Map<Integer, Long> mapFormatPlayer2 = formatPlayer1.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));

        for (Long v : mapFormatPlayer1.values()) {
            if (v > 1) {
                winner = player1;
                break;
            }
        }

        for (Long v : mapFormatPlayer2.values()) {
            if (v > 1 && winner == null) {
                winner = player2;
                break;
            }
        }

        if(winner != null) {
            return winner;
        }

        for(int i = 0; i < 5; i ++) {
            if (formatPlayer1.get(i) > formatPlayer2.get(i)) {
                return player1;
            } else if (formatPlayer1.get(i) < formatPlayer2.get(i)){
                return player2;
            }
        }

        return winner;
    }
}
