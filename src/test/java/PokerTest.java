import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class PokerTest {

    @Test
    public void oneHandTest() {
        String givenHand = "4S 5S 7H 8D JC";
        Poker testPoker = new Poker(givenHand);
        assertTrue(testPoker.oneHand().equals(givenHand));
    }

    @Test
    public void highestCardWins() {
        String playerHand = "4S 5S 7H 8D 9C";
        Poker poker = new Poker(playerHand);
        assertTrue(poker.highestCardWins().equals("9"));
        String playerHand2 = "4S JS 7H 8D 9C";
        Poker poker2 = new Poker(playerHand2);
        assertEquals(poker2.highestCardWins(), "J");
    }

    @Test
    public void pairWins() {
        String playerHand = "4S 5S 5H 8D 9C";
        Poker poker = new Poker(playerHand);
        assertEquals(poker.pairWins(), "5");
        String playerHand2 = "4S JS JH 8D 9C";
        Poker poker2 = new Poker(playerHand2);
        assertEquals(poker2.pairWins(), "J");
    }

    @Test
    public void tripleWins() {
        String playerHand = "4S 5S 5H 5D 9C";
        Poker poker = new Poker(playerHand);
        assertEquals(poker.tripleWins(), "5");
        String playerHand2 = "4S JS JH 8D JC";
        Poker poker2 = new Poker(playerHand2);
        assertEquals(poker2.tripleWins(), "J");
    }

    @Test
    public void quadrupleWins() {
        String playerHand = "5S 5S 5H 5D 9C";
        Poker poker = new Poker(playerHand);
        assertEquals(poker.quadrupleWins(), "5");
        String playerHand2 = "5S JS JH JD JC";
        Poker poker2 = new Poker(playerHand2);
        assertEquals(poker2.quadrupleWins(), "J");
    }

    @Test
    public void twoPairWins() {
        String playerHand = "4S 5S 5H 3D 9C";
        Poker poker = new Poker(playerHand);
        assertEquals(poker.twoPairWins(), null);
        String playerHand2 = "4S JS JH 7D 7C";
        Poker poker2 = new Poker(playerHand2);
        assertEquals(poker2.twoPairWins().get(0), "7");
        assertEquals(poker2.twoPairWins().get(1), "J");
    }

    @Test
    public void fullHouseWins() {
        String playerHand = "5S 5S 5H 3D 6C";
        Poker poker = new Poker(playerHand);
        assertEquals(poker.twoPairWins(), null);
        String playerHand2 = "JS JS JH 7D 7C";
        Poker poker2 = new Poker(playerHand2);
        assertEquals(poker2.fullHouse().get(0), "7");
        assertEquals(poker2.fullHouse().get(1), "J");
    }
}