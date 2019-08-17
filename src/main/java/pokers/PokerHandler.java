package pokers;

import java.util.*;

public class PokerHandler {
    public List<Poker> handle(List<Poker> player1, List<Poker> player2) {
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

        for(int i = 0; i < 5; i ++) {
            if (formatPlayer1.get(i) > formatPlayer2.get(i)) {
                return player1;
            } else if (formatPlayer1.get(i) < formatPlayer2.get(i)){
                return player2;
            }
        }

        return null;
    }
}
