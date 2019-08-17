package pokers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerTest {

    @Test
    public void should_return_player1_win_when_player1_is_2H_3C_7H_8S_9H_and_player2_is_3H_5C_6H_7S_8H(){
        //Given
        List player1 = Arrays.asList(new Poker("2H"), new Poker("3C"), new Poker("7H"), new Poker("8S"), new Poker("9H"));
        List player2 = Arrays.asList(new Poker("3H"), new Poker("5C"), new Poker("6H"), new Poker("7S"), new Poker("8H"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player1, winner);
    }

    @Test
    public void should_return_player2_win_when_player1_is_2H_3C_6H_7S_9H_and_player2_is_3H_4D_5C_8S_9D(){
        //Given
        List player1 = Arrays.asList(new Poker("2H"), new Poker("3C"), new Poker("6H"), new Poker("7S"), new Poker("9H"));
        List player2 = Arrays.asList(new Poker("3H"), new Poker("4D"), new Poker("5C"), new Poker("8S"), new Poker("9D"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player2, winner);
    }

    @Test
    public void should_return_player1_win_when_player1_is_2H_3C_6H_7S_KH_and_player2_is_3H_4D_5C_8S_TD(){
        //Given
        List player1 = Arrays.asList(new Poker("2H"), new Poker("3C"), new Poker("6H"), new Poker("7S"), new Poker("KH"));
        List player2 = Arrays.asList(new Poker("3H"), new Poker("4D"), new Poker("5C"), new Poker("8S"), new Poker("TD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player1, winner);
    }

    @Test
    public void should_return_null_when_player1_is_2H_5C_7H_8S_AH_and_player2_is_2D_5D_7C_8C_AD(){
        //Given
        List player1 = Arrays.asList(new Poker("2H"), new Poker("5C"), new Poker("7H"), new Poker("8S"), new Poker("AH"));
        List player2 = Arrays.asList(new Poker("2D"), new Poker("5D"), new Poker("7C"), new Poker("8C"), new Poker("AD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(null, winner);
    }

    @Test
    public void should_return_player1_win_when_player1_is_2H_2C_7H_8S_TH_and_player2_is_2D_5D_7C_8C_AD(){
        //Given
        List player1 = Arrays.asList(new Poker("2H"), new Poker("2C"), new Poker("7H"), new Poker("8S"), new Poker("TH"));
        List player2 = Arrays.asList(new Poker("2D"), new Poker("5D"), new Poker("7C"), new Poker("8C"), new Poker("AD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player1, winner);
    }

    @Test
    public void should_return_player2_win_when_player1_is_2H_2C_7H_8S_AH_and_player2_is_5D_5C_7C_8C_TD(){
        //Given
        List player1 = Arrays.asList(new Poker("2H"), new Poker("2C"), new Poker("7H"), new Poker("8S"), new Poker("AH"));
        List player2 = Arrays.asList(new Poker("5D"), new Poker("5C"), new Poker("7C"), new Poker("8C"), new Poker("TD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player2, winner);
    }

    @Test
    public void should_return_player1_win_when_player1_is_5H_5S_7H_8S_AH_and_player2_is_5D_5C_7C_8C_TD(){
        //Given
        List player1 = Arrays.asList(new Poker("5H"), new Poker("5S"), new Poker("7H"), new Poker("8S"), new Poker("AH"));
        List player2 = Arrays.asList(new Poker("5D"), new Poker("5C"), new Poker("7C"), new Poker("8C"), new Poker("TD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player1, winner);
    }

    @Test
    public void should_return_player2_win_when_player1_is_9H_9C_7H_8S_AH_and_player2_is_7C_7S_5D_5C_TD(){
        //Given
        List player1 = Arrays.asList(new Poker("9H"), new Poker("9C"), new Poker("7H"), new Poker("8S"), new Poker("AH"));
        List player2 = Arrays.asList(new Poker("7C"), new Poker("7S"), new Poker("5D"), new Poker("5C"), new Poker("TD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player2, winner);
    }

    @Test
    public void should_return_player1_win_when_player1_is_2H_2C_9H_9S_5H_and_player2_is_7C_7S_5D_5C_TD(){
        //Given
        List player1 = Arrays.asList(new Poker("2H"), new Poker("2C"), new Poker("9H"), new Poker("9S"), new Poker("5H"));
        List player2 = Arrays.asList(new Poker("7C"), new Poker("7S"), new Poker("5D"), new Poker("5C"), new Poker("TD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player1, winner);
    }

    @Test
    public void should_return_player2_win_when_player1_is_2H_2C_9H_9S_AH_and_player2_is_7C_7S_7D_5C_TD(){
        //Given
        List player1 = Arrays.asList(new Poker("2H"), new Poker("2C"), new Poker("9H"), new Poker("9S"), new Poker("AH"));
        List player2 = Arrays.asList(new Poker("7C"), new Poker("7S"), new Poker("7D"), new Poker("5C"), new Poker("TD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player2, winner);
    }

    @Test
    public void should_return_player1_win_when_player1_is_3H_4C_5H_6S_7H_and_player2_is_7C_7S_7D_5C_TD(){
        //Given
        List player1 = Arrays.asList(new Poker("3H"), new Poker("4C"), new Poker("5H"), new Poker("6S"), new Poker("7H"));
        List player2 = Arrays.asList(new Poker("7C"), new Poker("7S"), new Poker("7D"), new Poker("5C"), new Poker("TD"));

        //When
        PokerHandler pokerHandler = new PokerHandler();
        List winner = pokerHandler.handle(player1, player2);

        //Then
        Assert.assertEquals(player1, winner);
    }
}
