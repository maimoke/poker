/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therealpoker;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Moke
 */
public class Checking {

    public double score1;
    public double score2;
    public double score3;
    public double score4;
    public double score5;
    public double score6;
    public double score;
    ArrayList<Card> checkingCard = new ArrayList<Card>();

    Checking(Player p, Table t) {
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
        score5 = 0;
        score6 = 0;
        checkingCard.add(p.cardOnHand.get(0));
        checkingCard.add(p.cardOnHand.get(1));
        checkingCard.add(t.card.get(0));
        checkingCard.add(t.card.get(1));
        checkingCard.add(t.card.get(2));
        checkingCard.add(t.card.get(3));
        checkingCard.add(t.card.get(4));
        suitSort();
        score = checkRoyal();
        if (score == 0) {
            score = checkStraightFlush();
        }
        volumeSort();
        if (score == 0) {
            score = checkFourOfKind();
        }
        if (score == 0) {
            score = checkFullHouse();
        }
        suitSort();
        if (score == 0) {
            score = checkFlush();
        }
        volumeSort();
        if (score == 0) {
            score = checkStraight();
        }
        if (score == 0) {
            score = checkThreeOfKind();
        }
        if (score == 0) {
            score = checkTwoPair();
        }
        if (score == 0) {
            score = checkPair();
        }
        if (score == 0) {
            score = checkHighCard();
        }
    }

    public Checking() {
    }

    public double checkRoyal() {
        boolean pass = true;
        for (int suitItr = 1; suitItr <= 4; suitItr++) {
            int startPosItr = 0;
            while (checkingCard.get(startPosItr).getSuit() != suitItr && startPosItr < 6) {
                startPosItr++;
            }
            if (startPosItr > 3) {
                continue;
            }
            pass = true;
            int volumeItr = 14;
            for (int posItr = startPosItr; posItr < startPosItr + 5 && posItr < 7; posItr++) {
                if (checkingCard.get(posItr).getVolume() != volumeItr || checkingCard.get(posItr).getSuit() != suitItr) {
                    pass = false;
                }
                if (posItr + 1 > 7) {
                    pass = false;
                }
                volumeItr--;
            }
            if (pass) {
                score1 = 10;
            }
        }
        return score1 * 100000000;
    }

    public double checkStraightFlush() {
        for (int suitItr = 1; suitItr <= 4; suitItr++) {
            for (int startVolumeItr = 13; startVolumeItr > 4; startVolumeItr--) {
                boolean pass = true;
                for (int volumeItr = startVolumeItr; volumeItr > startVolumeItr - 5; volumeItr--) {
                    boolean found = false;
                    for (int posItr = 0; posItr < 7; posItr++) {
                        if (checkingCard.get(posItr).getVolume() == volumeItr && checkingCard.get(posItr).getSuit() == suitItr) {
                            found = true;
                        } else if (volumeItr < 2) {
                            if (checkingCard.get(posItr).getVolume() == volumeItr + 13 && checkingCard.get(posItr).getSuit() == suitItr) {
                                found = true;
                            }
                        }
                    }
                    if (found) {
                        continue;
                    } else {
                        pass = false;
                        break;
                    }
                }
                if (pass) {
                    score1 = 9;
                }
            }
        }
        return score1 * 100000000;
    }

    public double checkFourOfKind() {
        for (int startPosItr = 0; startPosItr < 4; startPosItr++) {
            boolean pass = true;
            for (int posItr = startPosItr + 1; posItr < startPosItr + 4; posItr++) {
                if (checkingCard.get(posItr).getVolume() != checkingCard.get(startPosItr).getVolume()) {
                    pass = false;
                }
            }
            if (pass) {
                score1 = 8;
                score2 = checkingCard.get(startPosItr).getVolume();
            }
        }

        return score1 * 100000000 + score2 * 1000000;
    }

    public double checkFullHouse() {

        for (int startPosItr = 0; startPosItr < 5; startPosItr++) {
            boolean pass = true;
            for (int posItr = startPosItr + 1; posItr < startPosItr + 3; posItr++) {
                if (checkingCard.get(posItr).getVolume() != checkingCard.get(startPosItr).getVolume()) {
                    pass = false;
                }
            }
            if (pass) {
                if (checkingCard.get(startPosItr).getVolume() > score2) {
                    score2 = checkingCard.get(startPosItr).getVolume();
                }
            }
        }

        for (int startPosItr = 0; startPosItr < 6; startPosItr++) {
            boolean pass = true;
            if (checkingCard.get(startPosItr).getVolume() == score2) {
                continue;
            }
            for (int posItr = startPosItr + 1; posItr < startPosItr + 2; posItr++) {
                if (checkingCard.get(posItr).getVolume() != checkingCard.get(startPosItr).getVolume()) {
                    pass = false;
                }
            }
            if (pass) {
                score3 = checkingCard.get(startPosItr).getVolume();
            }
        }

        if (score2 > 0 && score3 > 0) {
            score1 = 7;
        } else {
            score1 = 0;
            score2 = 0;
            score3 = 0;
        }

        return score1 * 100000000 + score2 * 1000000 + score3 * 10000;
    }

    public double checkFlush() {

        for (int startPosItr = 0; startPosItr < 3; startPosItr++) {
            boolean pass = true;
            for (int posItr = startPosItr + 1; posItr < startPosItr + 5; posItr++) {
                if (checkingCard.get(posItr).getSuit() != checkingCard.get(startPosItr).getSuit()) {
                    pass = false;
                }
            }
            if (pass) {
                score1 = 6;
                score2 = checkingCard.get(startPosItr).getSuit();
            }
        }

        return score1 * 100000000 + score2 * 1000000;
    }

    public double checkStraight() {
        for (int startVolumeItr = 14; startVolumeItr > 4; startVolumeItr--) {
            boolean pass = true;
            for (int volumeItr = startVolumeItr; volumeItr > startVolumeItr - 5; volumeItr--) {
                boolean found = false;
                for (int posItr = 0; posItr < 7; posItr++) {
                    if (checkingCard.get(posItr).getVolume() == volumeItr) {
                        found = true;
                    } else if (volumeItr < 2) {
                        if (checkingCard.get(posItr).getVolume() == volumeItr + 13) {
                            found = true;
                        }
                    }
                }
                if (found) {
                    continue;
                } else {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                score1 = 5;
                if (startVolumeItr > score2) {
                    score2 = startVolumeItr;
                }
            }
        }
        return score1 * 100000000 + score2 * 1000000;
    }

    public double checkThreeOfKind() {
        for (int startPosItr = 0; startPosItr < 5; startPosItr++) {
            boolean pass = true;
            for (int posItr = startPosItr + 1; posItr < startPosItr + 3; posItr++) {
                if (checkingCard.get(posItr).getVolume() != checkingCard.get(startPosItr).getVolume()) {
                    pass = false;
                }
            }
            if (pass) {
                score1 = 4;
                score2 = checkingCard.get(startPosItr).getVolume();
            }
        }
        if (score1 == 4) {
            for (int posItr = 0; posItr < 7; posItr++) {
                if (checkingCard.get(posItr).getVolume() > score3 && checkingCard.get(posItr).getVolume() != score2) {
                    score3 = checkingCard.get(posItr).getVolume();
                }
            }
            for (int posItr = 0; posItr < 7; posItr++) {
                if (checkingCard.get(posItr).getVolume() > score4 && checkingCard.get(posItr).getVolume() != score2 && checkingCard.get(posItr).getVolume() != score3) {
                    score4 = checkingCard.get(posItr).getVolume();
                }
            }
        }
        return score1 * 100000000 + score2 * 1000000 + score3 * 10000 + score4 * 100;
    }

    public double checkTwoPair() {

        for (int startPosItr = 0; startPosItr < 6; startPosItr++) {
            boolean pass = true;
            for (int posItr = startPosItr + 1; posItr < startPosItr + 2; posItr++) {
                if (checkingCard.get(posItr).getVolume() != checkingCard.get(startPosItr).getVolume()) {
                    pass = false;
                }
            }
            if (pass) {
                if (checkingCard.get(startPosItr).getVolume() > score2) {
                    score2 = checkingCard.get(startPosItr).getVolume();
                }
            }
        }

        for (int startPosItr = 0; startPosItr < 6; startPosItr++) {
            if (checkingCard.get(startPosItr).getVolume() == score2) {
                continue;
            }
            boolean pass = true;
            for (int posItr = startPosItr + 1; posItr < startPosItr + 2; posItr++) {
                if (checkingCard.get(posItr).getVolume() != checkingCard.get(startPosItr).getVolume()) {
                    pass = false;
                }
            }
            if (pass) {
                if (checkingCard.get(startPosItr).getVolume() > score3) {
                    score3 = checkingCard.get(startPosItr).getVolume();
                }
            }
        }
        if (score2 > 0 && score3 > 0) {
            score1 = 3;
        } else {
            score1 = 0;
            score2 = 0;
            score3 = 0;
        }

        if (score1 == 3) {
            for (int posItr = 0; posItr < 7; posItr++) {
                if (checkingCard.get(posItr).getVolume() > score4 && checkingCard.get(posItr).getVolume() != score2 && checkingCard.get(posItr).getVolume() != score3) {
                    score4 = checkingCard.get(posItr).getVolume();
                }
            }
        }

        return score1 * 100000000 + score2 * 1000000 + score3 * 10000 + score4 * 100;
    }

    public double checkPair() {

        for (int startPosItr = 0; startPosItr < 6; startPosItr++) {
            boolean pass = true;
            for (int posItr = startPosItr + 1; posItr < startPosItr + 2; posItr++) {
                if (checkingCard.get(posItr).getVolume() != checkingCard.get(startPosItr).getVolume()) {
                    pass = false;
                }
            }
            if (pass) {
                score1 = 2;
                score2 = checkingCard.get(startPosItr).getVolume();
            }
        }

        if (score1 == 2) {
            for (int posItr = 0; posItr < 7; posItr++) {
                if (checkingCard.get(posItr).getVolume() > score3 && checkingCard.get(posItr).getVolume() != score2) {
                    score3 = checkingCard.get(posItr).getVolume();
                }
            }
            for (int posItr = 0; posItr < 7; posItr++) {
                if (checkingCard.get(posItr).getVolume() > score4 && checkingCard.get(posItr).getVolume() != score2 && checkingCard.get(posItr).getVolume() != score3) {
                    score4 = checkingCard.get(posItr).getVolume();
                }
            }
            for (int posItr = 0; posItr < 7; posItr++) {
                if (checkingCard.get(posItr).getVolume() > score5 && checkingCard.get(posItr).getVolume() != score2 && checkingCard.get(posItr).getVolume() != score3 && checkingCard.get(posItr).getVolume() != score4) {
                    score5 = checkingCard.get(posItr).getVolume();
                }
            }
        }
        return score1 * 100000000 + score2 * 1000000 + score3 * 10000 + score4 * 100 + score5;
    }

    public double checkHighCard() {
        score1 = 1;
        for (int posItr = 0; posItr < 7; posItr++) {
            if (checkingCard.get(posItr).getVolume() > score2) {
                score2 = checkingCard.get(posItr).getVolume();
            }
        }
        for (int posItr = 0; posItr < 7; posItr++) {
            if (checkingCard.get(posItr).getVolume() > score3 && checkingCard.get(posItr).getVolume() != score2) {
                score3 = checkingCard.get(posItr).getVolume();
            }
        }
        for (int posItr = 0; posItr < 7; posItr++) {
            if (checkingCard.get(posItr).getVolume() > score4 && checkingCard.get(posItr).getVolume() != score2 && checkingCard.get(posItr).getVolume() != score3) {
                score4 = checkingCard.get(posItr).getVolume();
            }
        }
        for (int posItr = 0; posItr < 7; posItr++) {
            if (checkingCard.get(posItr).getVolume() > score5 && checkingCard.get(posItr).getVolume() != score2 && checkingCard.get(posItr).getVolume() != score3 && checkingCard.get(posItr).getVolume() != score4) {
                score5 = checkingCard.get(posItr).getVolume();
            }
        }
        for (int posItr = 0; posItr < 7; posItr++) {
            if (checkingCard.get(posItr).getVolume() > score6 && checkingCard.get(posItr).getVolume() != score2 && checkingCard.get(posItr).getVolume() != score3 && checkingCard.get(posItr).getVolume() != score4&& checkingCard.get(posItr).getVolume() != score5) {
                score6 = checkingCard.get(posItr).getVolume();
            }
        }
        return score1 * 100000000 + score2 * 1000000 + score3 * 10000 + score4 * 100 + score5 +0.01*score6;
    }

    public long getScore() {
        return (long)(score*100);
    }

    public void volumeSort() {
        for (int j = 0; j < checkingCard.size() - 1; j++) {
            for (int i = 0; i < checkingCard.size() - j - 1; i++) {
                if (checkingCard.get(i).getVolume() < checkingCard.get(i + 1).getVolume()) {
                    Collections.swap(checkingCard, i, i + 1);
                } else if (checkingCard.get(i).getVolume() == checkingCard.get(i + 1).getVolume()) {
                    if (checkingCard.get(i).getSuit() < checkingCard.get(i + 1).getSuit()) {
                        Collections.swap(checkingCard, i, i + 1);
                    }
                }
            }
        }
    }

    public void suitSort() {
        for (int j = 0; j < checkingCard.size() - 1; j++) {
            for (int i = 0; i < checkingCard.size() - j - 1; i++) {
                if (checkingCard.get(i).getSuit() < checkingCard.get(i + 1).getSuit()) {
                    Collections.swap(checkingCard, i, i + 1);
                } else if (checkingCard.get(i).getSuit() == checkingCard.get(i + 1).getSuit()) {
                    if (checkingCard.get(i).getVolume() < checkingCard.get(i + 1).getVolume()) {
                        Collections.swap(checkingCard, i, i + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        Player p1 = new Player(100);
        Table t = new Table();
        for (int i = 0; i < 2; i++) {
            p1.draw(d.draw());
        }
        for (int i = 0; i < 5; i++) {
            t.draw(d.draw());
        }
        Checking c1 = new Checking(p1, t);
        System.out.println("player1");
        for (int i = 0; i < 7; i++) {
            System.out.println(c1.checkingCard.get(i).getName());
        }

        System.out.println(c1.getScore());
    }
}
