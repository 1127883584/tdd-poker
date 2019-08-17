package pokers;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PokerHandler {

    private List<Integer> levelPlayer1;
    private List<Integer> levelPlayer2;
    private List<BiFunction> utilList;

    public PokerHandler(){
        Integer levelArray1[] = new Integer[8];
        Integer levelArray2[] = new Integer[8];
        Arrays.fill(levelArray1, 0);
        Arrays.fill(levelArray2, 0);
        levelPlayer1 = Arrays.asList(levelArray1);
        levelPlayer2 = Arrays.asList(levelArray2);
        utilList = Arrays.asList(getStraightFlushKey, getFourOfKindKey, getFullHouseKey, getFlushKey, getStraightKey, getThreeOfAKindKey, getTwoPairKey, getPairKey);
    }


    public List<Poker> handle(List<Poker> player1, List<Poker> player2) {
        List<Poker> winner = null;

        List<Integer> formatPlayer1 = new ArrayList<>();
        List<Integer> formatPlayer2 = new ArrayList<>();

        HashMap<List<Integer>, List<Poker>> hashMap = new HashMap<>();

        hashMap.put(formatPlayer1, player1);
        hashMap.put(formatPlayer2, player2);

        for(int i = 0; i < 5; i ++) {
            formatPlayer1.add(player1.get(i).getNumber());
            formatPlayer2.add(player2.get(i).getNumber());
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

        for(int i = 0; i < utilList.size(); i ++) {
            levelPlayer1.set(i, Integer.parseInt((utilList.get(i).apply(formatPlayer1, player1)).toString()));
            levelPlayer2.set(i, Integer.parseInt((utilList.get(i).apply(formatPlayer2, player2)).toString()));
            if (levelPlayer1.get(i) > levelPlayer2.get(i)) {
                winner = player1;
            } else if (levelPlayer1.get(i) < levelPlayer2.get(i)) {
                winner = player2;
            }
            if(winner != null) {
                return winner;
            }
        }

        // High Card
        return getHighCard(formatPlayer1, formatPlayer2, player1, player2);
    }

    // Straight flush
    BiFunction<List<Integer>, List<Poker>, Integer> getStraightFlushKey = (formatPlayer, player) -> {
        if (isContinusList(formatPlayer) && isFlushList(player)) {
            return formatPlayer.get(0);
        }
        return 0;
    };

    // Four of kind
    BiFunction<List<Integer>, List<Poker>, Integer> getFourOfKindKey = (formatPlayer, player) -> {
        Map<Integer, Long> mapFormatPlayer = formatPlayer.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        Set setFormatPlayer = mapFormatPlayer.keySet();
        if (mapFormatPlayer.size() == 2) {
            for(Iterator iter = setFormatPlayer.iterator(); iter.hasNext();)
            {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer.get(key);
                if (value == 4) {
                    return key;
                }
            }
        }
        return 0;
    };

    // Full House
    BiFunction<List<Integer>, List<Poker>, Integer> getFullHouseKey = (formatPlayer, player) -> {
        Map<Integer, Long> mapFormatPlayer = formatPlayer.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        Set setFormatPlayer = mapFormatPlayer.keySet();
        if (mapFormatPlayer.size() == 2) {
            for(Iterator iter = setFormatPlayer.iterator(); iter.hasNext();)
            {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer.get(key);
                if (value == 3) {
                    return key;
                }
            }
        }
        return 0;
    };

    // Flush
    BiFunction<List<Integer>, List<Poker>, Integer> getFlushKey = (formatPlayer, player) -> {
        if (isFlushList(player)) {
            return formatPlayer.get(0);
        }
        return 0;
    };

    // Straight
    BiFunction<List<Integer>, List<Poker>, Integer> getStraightKey = (formatPlayer, player) -> {
        if (isContinusList(formatPlayer)) {
            return formatPlayer.get(0);
        }
        return 0;
    };

    // Three Of A Kind
    BiFunction<List<Integer>, List<Poker>, Integer> getThreeOfAKindKey = (formatPlayer, player) -> {
        Map<Integer, Long> mapFormatPlayer = formatPlayer.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        Set setFormatPlayer = mapFormatPlayer.keySet();
        if (mapFormatPlayer.size() == 3) {
            for(Iterator iter = setFormatPlayer.iterator(); iter.hasNext();)
            {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer.get(key);
                if (value == 3) {
                    return key;
                }
            }
        }
        return 0;
    };

    // Two Pair
    BiFunction<List<Integer>, List<Poker>, Integer> getTwoPairKey = (formatPlayer, player) -> {
        int maxKey = 0;
        Map<Integer, Long> mapFormatPlayer = formatPlayer.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        Set setFormatPlayer = mapFormatPlayer.keySet();
        if (mapFormatPlayer.size() == 3) {
            for(Iterator iter = setFormatPlayer.iterator(); iter.hasNext();)
            {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer.get(key);
                if (value == 2) {
                    maxKey = key;
                }
            }
        }
        return maxKey;
    };

    // Pair
    BiFunction<List<Integer>, List<Poker>, Integer> getPairKey = (formatPlayer, player) -> {
        int maxKey = 0;
        Map<Integer, Long> mapFormatPlayer = formatPlayer.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        Set setFormatPlayer = mapFormatPlayer.keySet();
        if (mapFormatPlayer.size() == 4) {
            for(Iterator iter = setFormatPlayer.iterator(); iter.hasNext();)
            {
                int key = Integer.parseInt(iter.next().toString());
                long value = mapFormatPlayer.get(key);
                if (value == 2) {
                    maxKey = key;
                }
            }
        }
        return maxKey;
    };

    // High Card
    private List<Poker> getHighCard(List<Integer> formatPlayer1, List<Integer> formatPlayer2, List<Poker> player1, List<Poker> player2) {
        for(int i = 0; i < 5; i ++) {
            if (formatPlayer1.get(i) > formatPlayer2.get(i)) {
                return player1;
            } else if (formatPlayer1.get(i) < formatPlayer2.get(i)){
                return player2;
            }
        }
        return null;
    }

    static boolean isContinusList(List<Integer> list) {
        Integer[] a= new Integer[list.size()];
        list.toArray(a);
        int min = a[0];
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] < min && a[i] !=0 ) {
                min = a[i];
            }
            if(a[i] > max && a[i] != 0) {
                max = a[i];
            }
        }

        if((max - min) <= a.length-1 ) {
            return true;
        }
        return false;
    }

    static boolean isFlushList(List<Poker> player) {
        int color = player.get(0).getColor();
        for (int i = 1; i < player.size(); i ++) {
            if (color != player.get(i).getColor()) {
                return false;
            }
        }
        return true;
    }
}
