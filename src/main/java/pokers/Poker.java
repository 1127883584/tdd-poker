package pokers;

public class Poker {
    private String str;
    private int color;

    public Poker(String str) {
        this.str = str;
    }

    public int formatToNumber(){
        return Integer.parseInt(this.str.charAt(0) + "");
    }
}
