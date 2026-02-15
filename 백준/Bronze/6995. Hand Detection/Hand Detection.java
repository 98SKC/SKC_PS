import java.util.Scanner;

class Card {
    int value;
    String suit;

    public final static String[] suitNames = {
        "Elf", "Man", "Hobbit", "Ent", "Ork"
    };

    public Card(int valueIn, int suitIn) {
        if (valueIn < 1 || valueIn > 21) {
            throw new RuntimeException(
                "Illegal card value attempted." +
                " The acceptible range is 1 to 21.  You tried " + valueIn
            );
        }
        if (suitIn < 0 || suitIn > 4) {
            throw new RuntimeException(
                "Illegal suit attempted." +
                " The acceptible range is 0 to 4.  You tried " + suitIn
            );
        }

        this.suit = suitNames[suitIn];
        this.value = valueIn;
    }

    public int getValue() { return value; }

    public String getSuit() { return suit; }
}

public class Main {

    private static boolean detectSpread(Card[] handOfCards) {
        // Spread: 모든 (i<j) 쌍의 value 차이가 전부 서로 달라야 한다.
        boolean[] seen = new boolean[21]; // difference 0~20

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                int d = Math.abs(handOfCards[i].getValue() - handOfCards[j].getValue());
                if (seen[d]) return false;
                seen[d] = true;
            }
        }
        return true;
    }

    private static boolean detectRainbow(Card[] handOfCards) {
        // Rainbow: 5개의 suit가 각각 정확히 1장씩 있어야 한다.
        boolean[] used = new boolean[5];

        for (int i = 0; i < 5; i++) {
            String s = handOfCards[i].getSuit();
            int idx = -1;

            for (int k = 0; k < 5; k++) {
                if (Card.suitNames[k].equals(s)) {
                    idx = k;
                    break;
                }
            }

            if (idx == -1) return false; // 방어
            if (used[idx]) return false; // 중복 suit
            used[idx] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfTestCases = sc.nextInt();

        for (int testCase = 0; testCase < numOfTestCases; testCase++) {
            Card[] handOfCards = new Card[5];

            for (int card = 0; card < 5; card++) {
                int suit = sc.nextInt();
                int value = sc.nextInt();
                handOfCards[card] = new Card(value, suit);
            }

            if (detectSpread(handOfCards)) {
                System.out.print("Have a spread.          ");
            } else {
                System.out.print("Do not have a spread.   ");
            }

            if (detectRainbow(handOfCards)) {
                System.out.println("Have a rainbow.");
            } else {
                System.out.println("Do not have a rainbow.");
            }
        }

        sc.close();
    }
}
