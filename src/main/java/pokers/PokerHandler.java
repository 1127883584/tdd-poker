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
        Map<Integer, Long> mapFormatPlayer2 = formatPlayer2.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        int player1PairKey = 0;
        int player2PairKey = 0;
        int player1ThreeKey = 0;
        int player2ThreeKey = 0;
        Set setFormatPlayer1 = mapFormatPlayer1.keySet();
        Set setFormatPlayer2 = mapFormatPlayer2.keySet();


        // Two Pair or Three of a Kind
        if (mapFormatPlayer1.size() == 3) {
            for(Iterator iter = setFormatPlayer1.iterator(); iter.hasNext();)
            {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer1.get(key);
                if (value == 3) {
                    player1ThreeKey = key;
                }
                if (value == 2) {
                    player1PairKey = key;
                }
            }
        }

        if (mapFormatPlayer2.size() == 3) {
            for(Iterator iter = setFormatPlayer2.iterator(); iter.hasNext();)
            {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer2.get(key);
                if (value == 3) {
                    player2ThreeKey = key;
                }
                if (value == 2) {
                    player2PairKey = key;
                }
            }
        }

        if (player1ThreeKey > player2ThreeKey) {
            winner = player1;
        } else if (player1ThreeKey < player2ThreeKey) {
            winner = player2;
        }

        if(winner != null) {
            return winner;
        }

        if (player1PairKey > player2PairKey) {
            winner = player1;
        } else if (player1PairKey < player2PairKey) {
            winner = player2;
        }

        if(winner != null) {
            return winner;
        }


        // Pair
        if (mapFormatPlayer1.size() == 4) {
            for(Iterator iter = setFormatPlayer1.iterator(); iter.hasNext();)
            {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer1.get(key);
                if (value == 2) {
                    player1PairKey = key;
                    break;
                }
            }
        }

        if (mapFormatPlayer2.size() == 4) {
            for (Iterator iter = setFormatPlayer2.iterator(); iter.hasNext(); ) {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer2.get(key);
                if (value == 2) {
                    player2PairKey = key;
                    break;
                }
            }
        }

        if (player1PairKey > player2PairKey) {
            winner = player1;
        } else if (player1PairKey < player2PairKey) {
            winner = player2;
        }

        if(winner != null) {
            return winner;
        }


        // High Card
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
