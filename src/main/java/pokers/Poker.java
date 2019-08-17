package pokers;

import java.util.HashMap;
import java.util.List;

public class Poker {
    private String str;
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

    public Poker(String str) {
        this.str = str;
    }

    public int formatToNumber(){
        return hashMap.get(this.str.charAt(0) + "") == null ? Integer.parseInt(this.str.charAt(0) + "") : hashMap.get(this.str.charAt(0) + "");
    }
}
