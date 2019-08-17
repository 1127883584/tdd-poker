package pokers;

import java.util.HashMap;
import java.util.List;

public class Poker {
    private int number;
    private int color;
    private HashMap<String, Integer> hashMap = new HashMap<String, Integer>(){
        {
            put("T", 10);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
            put("A", 14);
        }
    };
    private HashMap<String, Integer> hashMapColor = new HashMap<String, Integer>(){
        {
            put("C", 1);
            put("D", 2);
            put("H", 3);
            put("S", 4);
        }
    };

    public Poker(String str) {
        this.number = hashMap.get(str.charAt(0) + "") == null ? Integer.parseInt(str.charAt(0) + "") : hashMap.get(str.charAt(0) + "");
        this.color = hashMapColor.get(str.charAt(1) + "");
    }

    public int getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}
