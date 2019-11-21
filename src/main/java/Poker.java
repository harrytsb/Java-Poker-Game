import java.util.*;

public class Poker {

    private String hand;
    private List<String> cardValues = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    private String[] handAsArray;
    private Map<String, Integer> cardCounter = new HashMap<>();

    public Poker(String hand) {
        this.hand = hand;
        this.handAsArray = hand.split(" ");
        for(String card: handAsArray) {
            String cardValue = card.split("")[0];
            int cardCount = cardCounter.getOrDefault(cardValue, 0);
            this.cardCounter.put(cardValue, cardCount + 1);
        }
        System.out.println(cardCounter);
    }

    public String oneHand() {
        return hand;
    }

    public String highestCardWins() {
        String[] individualCards = hand.split(" ");
        int index = 0;
        for (int i = 0; i < individualCards.length ; i++) {
            String rank = individualCards[i].split("")[0];
            int rankIndex = cardValues.indexOf(rank);
            if (rankIndex > index) index = rankIndex;
        }
        return cardValues.get(index);
    }

    boolean pairPresent = false;

    public String pairWins() {
        for (Map.Entry<String, Integer> cardValue: this.cardCounter.entrySet()) {
            if (cardValue.getValue() == 2) {
                return cardValue.getKey();
            }
        }
        return null;
    }

    public String tripleWins() {
        for (Map.Entry<String, Integer> cardValue: this.cardCounter.entrySet()) {
            if (cardValue.getValue() == 3) {
                return cardValue.getKey();
            }
        }
        return null;
    }

    public String quadrupleWins() {
        for (Map.Entry<String, Integer> cardValue: this.cardCounter.entrySet()) {
            if (cardValue.getValue() == 4) {
                return cardValue.getKey();
            }
        }
        return null;
    }

    public void checkIfMultiples() {

    }

    public List<String> twoPairWins() {
        int numOfPairs = 0;
        List<String> pairs = new ArrayList<>();
        for (Map.Entry<String, Integer> cardValue: this.cardCounter.entrySet()) {
            if (cardValue.getValue() == 2) {
                pairs.add(cardValue.getKey());
                numOfPairs++;
            }
        }
        if (numOfPairs == 2) {
            return pairs;
        } else {
            return null;
        }
    }

    public List<String> fullHouse() {
        List<String> fullHouseCards = new ArrayList<>();
        if (pairWins() != null && tripleWins() != null) {
            fullHouseCards.add(pairWins());
            fullHouseCards.add(tripleWins());
            return fullHouseCards;
        } else {
            return null;
        }
    }



//    public boolean determineIfPair() {
//        for (String pairs : pairMap.keySet()) {
//            Map<String, Integer> mapOfKeysSoFar = new HashMap<String, Integer>();
//            mapOfKeysSoFar.put()
//            System.out.println(pairs);
//        }
//    }

//    ArrayList<String> SUITS = new ArrayList<String>();
//    ArrayList<String> RANKS = new ArrayList<String>();


//    String[] SUITS = {
//            "Clubs", "Diamonds", "Hearts", "Spades"
//    };
//
//    String[] RANKS = {
//            "2", "3", "4", "5", "6", "7", "8", "9", "10",
//            "Jack", "Queen", "King", "Ace"
//    };
//
//    // initialize deck
//    public int numberOfCards = SUITS.length * RANKS.length;
//    public String[] deck = new String[numberOfCards];
//
//    public String[] initialiseDeck() {
//        for (int i = 0; i < RANKS.length; i++) {
//            for (int j = 0; j < SUITS.length; j++) {
//                deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
//            }
//        }
////        return new String[] {"hello, song, sing"};
//        return deck;
//    }
//
//    // shuffle
//    public String[] shuffleDeck() {
//        for (int i = 0; i < numberOfCards; i++) {
//            int randomCard = i + (int) (Math.random() * (numberOfCards - i));
//            String temp = deck[randomCard];
//            deck[randomCard] = deck[i];
//            deck[i] = temp;
//        }
//        return deck;
//    }
//
//    // print shuffled deck
//    public void printShuffledDeck() {
//        for (int i = 0; i < numberOfCards; i++) {
//            System.out.println(deck[i]);
//        }
//    }
//
//    public Poker(String[] SUITS, String[] RANKS, int numberOfCards, String[] deck) {
//        this.SUITS = SUITS;
//        this.RANKS = RANKS;
//        this.numberOfCards = numberOfCards;
//        this.deck = deck;
//    }
}
