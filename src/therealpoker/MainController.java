/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therealpoker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Moke
 */
public class MainController implements Initializable {

    public Deck d = new Deck();
    public Player[] p = new Player[9];
    public Table t = new Table();
    public Checking[] c = new Checking[9];
    public int raiseThisRound = 0;
    public int raiseTimeThisRound = 0;
    boolean[] player_ingame = new boolean[9]; //default false
    int player_turn = 0;
    boolean game_setup = false;
    int playeringame = 0;
    int bigBlind = 0;
    int smallBlind = 0;
    int underTheGun = 0;
    int round = 0; //round=0 zero card on table//round=1 three card on table//round=2 four card on table//round=3 five card on table
    public Card back = new Card(0, 0);
    boolean showCardP1_1 = false;
    boolean showCardP1_2 = false;
    boolean showCardP2_1 = false;
    boolean showCardP2_2 = false;
    boolean showCardP3_1 = false;
    boolean showCardP3_2 = false;
    boolean showCardP4_1 = false;
    boolean showCardP4_2 = false;
    boolean showCardP5_1 = false;
    boolean showCardP5_2 = false;
    boolean showCardP6_1 = false;
    boolean showCardP6_2 = false;
    boolean showCardP7_1 = false;
    boolean showCardP7_2 = false;
    boolean showCardP8_1 = false;
    boolean showCardP8_2 = false;

    @FXML
    private AnchorPane stupid_pane;
    @FXML
    private AnchorPane MainMenu;
    @FXML
    private Button btn_play;
    @FXML
    private Button btn_quit;
    @FXML
    private Button btn_fold;
    @FXML
    private TextField fill_raise;
    @FXML
    private Button btn_check;
    @FXML
    private AnchorPane Game;
    @FXML
    private ImageView player1;
    @FXML
    private ImageView player2;
    @FXML
    private ImageView player3;
    @FXML
    private ImageView player4;
    @FXML
    private ImageView player5;
    @FXML
    private ImageView player6;
    @FXML
    private ImageView player7;
    @FXML
    private ImageView player8;
    @FXML
    private ImageView dealer;
    @FXML
    private Button player1_sit_btn;
    @FXML
    private Button player2_sit_btn;
    @FXML
    private Button player3_sit_btn;
    @FXML
    private Button player4_sit_btn;
    @FXML
    private Button player5_sit_btn;
    @FXML
    private Button player6_sit_btn;
    @FXML
    private Button player7_sit_btn;
    @FXML
    private Button player8_sit_btn;
    @FXML
    private Button start_btn;
    @FXML
    private ImageView card_table_1;
    @FXML
    private ImageView card_table_2;
    @FXML
    private ImageView card_table_3;
    @FXML
    private ImageView card_table_4;
    @FXML
    private ImageView card_table_5;
    @FXML
    private ImageView card_p1_2;
    @FXML
    private ImageView card_p1_1;
    @FXML
    private ImageView card_p2_2;
    @FXML
    private ImageView card_p2_1;
    @FXML
    private ImageView card_p3_2;
    @FXML
    private ImageView card_p3_1;
    @FXML
    private ImageView card_p4_2;
    @FXML
    private ImageView card_p4_1;
    @FXML
    private ImageView card_p5_1;
    @FXML
    private ImageView card_p5_2;
    @FXML
    private ImageView card_p6_1;
    @FXML
    private ImageView card_p6_2;
    @FXML
    private ImageView card_p8_1;
    @FXML
    private ImageView card_p7_1;
    @FXML
    private ImageView card_p7_2;
    @FXML
    private ImageView card_p8_2;
    @FXML
    private ImageView point_p1_turn;
    @FXML
    private ImageView point_p2_turn;
    @FXML
    private ImageView point_p8_turn;
    @FXML
    private ImageView point_p3_turn;
    @FXML
    private ImageView point_p4_turn;
    @FXML
    private ImageView point_p7_turn;
    @FXML
    private ImageView point_p6_turn;
    @FXML
    private ImageView point_p5_turn;
    @FXML
    private Label money_p1;
    @FXML
    private Label money_p2;
    @FXML
    private Label money_p3;
    @FXML
    private Label money_p4;
    @FXML
    private Label money_p5;
    @FXML
    private Label money_p6;
    @FXML
    private Label money_p7;
    @FXML
    private Label money_p8;
    @FXML
    private Label pot;
    @FXML
    private Rectangle bg_p1;
    @FXML
    private Rectangle bg_p2;
    @FXML
    private Rectangle bg_p3;
    @FXML
    private Rectangle bg_p4;
    @FXML
    private Rectangle bg_p5;
    @FXML
    private Rectangle bg_p6;
    @FXML
    private Rectangle bg_p7;
    @FXML
    private Rectangle bg_p8;
    @FXML
    private Rectangle bg_pot;
    @FXML
    private Button btn_raise;
    @FXML
    private Label call_value;
    @FXML
    private ImageView backcard_p1_1;
    @FXML
    private ImageView backcard_p1_2;
    @FXML
    private ImageView backcard_p2_1;
    @FXML
    private ImageView backcard_p2_2;
    @FXML
    private ImageView backcard_p3_1;
    @FXML
    private ImageView backcard_p3_2;
    @FXML
    private ImageView backcard_p4_1;
    @FXML
    private ImageView backcard_p4_2;
    @FXML
    private ImageView backcard_p5_1;
    @FXML
    private ImageView backcard_p5_2;
    @FXML
    private ImageView backcard_p6_1;
    @FXML
    private ImageView backcard_p6_2;
    @FXML
    private ImageView backcard_p7_1;
    @FXML
    private ImageView backcard_p7_2;
    @FXML
    private ImageView backcard_p8_1;
    @FXML
    private ImageView backcard_p8_2;
    @FXML
    private Label pot_win;
    @FXML
    private ImageView p1_win;
    @FXML
    private ImageView p2_win;
    @FXML
    private ImageView p3_win;
    @FXML
    private ImageView p4_win;
    @FXML
    private ImageView p5_win;
    @FXML
    private ImageView p6_win;
    @FXML
    private ImageView p7_win;
    @FXML
    private ImageView p8_win;
    @FXML
    private AnchorPane Win;
    @FXML
    private Button continue_btn;
    @FXML
    private AnchorPane Video;
    @FXML
    private MediaView intro;
    private Media media;
    private MediaPlayer mediaPlayer;

    private void daengYellAtYou() {
        Video.setVisible(true);
        mediaPlayer.play();
    }

    @FXML
    private void daengPlsStop(MouseEvent event) {
        mediaPlayer.stop();
        Video.setVisible(false);
    }

    public void winVisible() {
        for (int i = 1; i < 9; i++) {
            if (!player_ingame[i]) {
                switch (i) {
                    case 1:
                        p1_win.setVisible(false);
                        break;
                    case 2:
                        p2_win.setVisible(false);
                        break;
                    case 3:
                        p3_win.setVisible(false);
                        break;
                    case 4:
                        p4_win.setVisible(false);
                        break;
                    case 5:
                        p5_win.setVisible(false);
                        break;
                    case 6:
                        p6_win.setVisible(false);
                        break;
                    case 7:
                        p7_win.setVisible(false);
                        break;
                    case 8:
                        p8_win.setVisible(false);
                        break;
                }
            }
        }
    }

    public void showCard(ImageView view, Card c) {
        int type = c.getSuit();
        int num = c.getVolume();
        System.out.println(type + "  " + num);
        Image imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/FourOfSpade.png"));
        if (type == 4) {
            if (num == 2) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/TwoOfSpade.png"));
            } else if (num == 3) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/ThreeOfSpade.png"));
            } else if (num == 4) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/FourOfSpade.png"));
            } else if (num == 5) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/FiveOfSpade.png"));
            } else if (num == 6) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/SixOfSpade.png"));
            } else if (num == 7) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/SevenOfSpade.png"));
            } else if (num == 8) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/EightOfSpade.png"));
            } else if (num == 9) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/NineOfSpade.png"));
            } else if (num == 10) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/TenOfSpade.png"));
            } else if (num == 11) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/JackOfSpade.png"));
            } else if (num == 12) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/QueenOfSpade.png"));
            } else if (num == 13) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/KingOfSpade.png"));
            } else if (num == 14) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/AceOfSpade.png"));
            }
        } else if (type == 3) {
            if (num == 2) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/TwoOfHeart.png"));
            } else if (num == 3) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/ThreeOfHeart.png"));
            } else if (num == 4) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/FourOfHeart.png"));
            } else if (num == 5) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/FiveOfHeart.png"));
            } else if (num == 6) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/SixOfHeart.png"));
            } else if (num == 7) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/SevenOfHeart.png"));
            } else if (num == 8) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/EightOfHeart.png"));
            } else if (num == 9) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/NineOfHeart.png"));
            } else if (num == 10) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/TenOfHeart.png"));
            } else if (num == 11) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/JackOfHeart.png"));
            } else if (num == 12) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/QueenOfHeart.png"));
            } else if (num == 13) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/KingOfHeart.png"));
            } else if (num == 14) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Heart/AceOfHeart.png"));
            }
        } else if (type == 2) {
            if (num == 2) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/TwoOfDiamond.png"));
            } else if (num == 3) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/ThreeOfDiamond.png"));
            } else if (num == 4) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/FourOfDiamond.png"));
            } else if (num == 5) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/FiveOfDiamond.png"));
            } else if (num == 6) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/SixOfDiamond.png"));
            } else if (num == 7) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/SevenOfDiamond.png"));
            } else if (num == 8) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/EightOfDiamond.png"));
            } else if (num == 9) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/NineOfDiamond.png"));
            } else if (num == 10) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/TenOfDiamond.png"));
            } else if (num == 11) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/JackOfDiamond.png"));
            } else if (num == 12) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/QueenOfDiamond.png"));
            } else if (num == 13) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/KingOfDiamond.png"));
            } else if (num == 14) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Diamond/AceOfDiamond.png"));
            }
        } else if (type == 1) {
            if (num == 2) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/TwoOfClub.png"));
            } else if (num == 3) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/ThreeOfClub.png"));
            } else if (num == 4) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/FourOfClub.png"));
            } else if (num == 5) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/FiveOfClub.png"));
            } else if (num == 6) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/SixOfClub.png"));
            } else if (num == 7) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/SevenOfClub.png"));
            } else if (num == 8) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/EightOfClub.png"));
            } else if (num == 9) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/NineOfClub.png"));
            } else if (num == 10) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/TenOfClub.png"));
            } else if (num == 11) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/JackOfClub.png"));
            } else if (num == 12) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/QueenOfClub.png"));
            } else if (num == 13) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/KingOfClub.png"));
            } else if (num == 14) {
                imaged = new Image(getClass().getResourceAsStream("รวมไพ่/Club/AceOfClub.png"));
            }
        } else {
            imaged = new Image(getClass().getResourceAsStream("รวมไพ่/behide.png"));
        }
        view.setImage(imaged);

    }

    public void checkRound() {
        //check if all player betThisRound=raiseThisRound
        int check = 0;
        for (int i = 0; i < 9; i++) {
            if (player_ingame[i]) {
                if (p[i].isFold() || (p[i].getBetThisRound() == raiseThisRound && p[i].isCheck())) {
                    check++;
                }
            }
        }
        if (playeringame == check) {
            raiseThisRound = 0;
            for (int i = 0; i < 9; i++) {
                if (player_ingame[i]) {
                    p[i].turnEndResetBet();
                    p[i].setCheck(false);
                }
            }
            raiseTimeThisRound = 0;
            fill_raise.setVisible(true);
            btn_raise.setVisible(true);
            round++;
            if (round == 1) {
                t.draw(d.draw());
                t.draw(d.draw());
                t.draw(d.draw());
                showCard(card_table_1, t.getCard(0));
                showCard(card_table_2, t.getCard(1));
                showCard(card_table_3, t.getCard(2));
                card_table_1.setVisible(true);
                card_table_2.setVisible(true);
                card_table_3.setVisible(true);
            } else if (round == 2) {
                t.draw(d.draw());
                showCard(card_table_4, t.getCard(3));
                card_table_4.setVisible(true);
            } else if (round == 3) {
                t.draw(d.draw());
                showCard(card_table_5, t.getCard(4));
                card_table_5.setVisible(true);
            } else {
                //calculate winner
                System.out.println("round end");
                int winnerAmount = 0;
                long highestScore = 0;
                boolean[] win = new boolean[9];
                for (int i = 0; i < 9; i++) {
                    if (player_ingame[i] && !p[i].isFold()) {
                        c[i] = new Checking(p[i], t);
                        if (c[i].getScore() > highestScore) {
                            highestScore = c[i].getScore();
                            winnerAmount = 1;
                            for (int j = 0; j < 9; j++) {
                                win[j] = false;
                            }
                            win[i] = true;
                        } else if (c[i].getScore() == highestScore) {
                            win[i] = true;
                        }

                    }
                }
                pot_win.setText(Integer.toString(t.getPot()));
                Win.setVisible(true);
                for (int i = 1; i < 9; i++) {
                    if (win[i]) {
                        switch (i) {
                            case 1:
                                p1_win.setOpacity(1);
                                break;
                            case 2:
                                p2_win.setOpacity(1);
                                break;
                            case 3:
                                p3_win.setOpacity(1);
                                break;
                            case 4:
                                p4_win.setOpacity(1);
                                break;
                            case 5:
                                p5_win.setOpacity(1);
                                break;
                            case 6:
                                p6_win.setOpacity(1);
                                break;
                            case 7:
                                p7_win.setOpacity(1);
                                break;
                            case 8:
                                p8_win.setOpacity(1);
                                break;
                        }
                    }
                }

                //reward winner
                for (int i = 0; i < 9; i++) {
                    if (player_ingame[i]) {
                        if (win[i]) {
                            p[i].reward(t.getPot() / winnerAmount);
                        }
                        p[i].reset();
                    }
                }
                resetToNextRound();
                //next Round
                startGameDraw();
                turn_indicator();
                call_value.setText(Integer.toString(raiseThisRound - p[player_turn].getBetThisRound()));
            }
        }

    }

    public void resetToNextRound() {
        //reset
        t.reset();
        d.reset();
        player_turn = smallBlind;
        player_turn = findNextPlayer();
        smallBlind = player_turn;
        player_turn = findNextPlayer();
        bigBlind = player_turn;
        player_turn = findNextPlayer();
        underTheGun = player_turn;
        System.out.println("smallBlind = " + smallBlind);
        System.out.println("bigBlind = " + bigBlind);
        System.out.println("underTheGun = " + underTheGun);
        round = 0;
        raiseThisRound = t.bet(p[bigBlind].firstTurnRaise(10000));
        t.bet(p[smallBlind].call(5000));
        updateMoney();
        //ui reset
        card_table_1.setVisible(false);
        card_table_2.setVisible(false);
        card_table_3.setVisible(false);
        card_table_4.setVisible(false);
        card_table_5.setVisible(false);
        player1.setOpacity(1);
        player2.setOpacity(1);
        player3.setOpacity(1);
        player4.setOpacity(1);
        player5.setOpacity(1);
        player6.setOpacity(1);
        player7.setOpacity(1);
        player8.setOpacity(1);

    }

    public int findNextPlayer() {
        for (int i = player_turn - 1; i >= 0; i--) {
            if (i == 0) {
                i = 8;
            }
            if (player_ingame[i] && !p[i].isFold()) {
                return i;
            }
        }
        return 0;
    }

    public boolean checkFold() {
        int check = 0;
        for (int i = 1; i < 9; i++) {
            if (player_ingame[i] && p[i].isFold()) {
                check++;
            }
        }
        System.out.println("check " + check);
        int winner = 0;
        if (check == playeringame - 1) {
            raiseThisRound = 0;
            for (int i = 1; i < 9; i++) {
                if (player_ingame[i]) {
                    if (!p[i].isFold()) {
                        p[i].reward(t.getPot());
                        winner = i;
                    }
                    p[i].reset();
                }
            }
            pot_win.setText(Integer.toString(t.getPot()));
            Win.setVisible(true);
            switch (winner) {
                case 1:
                    p1_win.setOpacity(1);
                    break;
                case 2:
                    p2_win.setOpacity(1);
                    break;
                case 3:
                    p3_win.setOpacity(1);
                    break;
                case 4:
                    p4_win.setOpacity(1);
                    break;
                case 5:
                    p5_win.setOpacity(1);
                    break;
                case 6:
                    p6_win.setOpacity(1);
                    break;
                case 7:
                    p7_win.setOpacity(1);
                    break;
                case 8:
                    p8_win.setOpacity(1);
                    break;
            }
            resetToNextRound();
            startGameDraw();
            call_value.setText(Integer.toString(raiseThisRound - p[player_turn].getBetThisRound()));
            turn_indicator();
            return true;
        }
        return false;
    }

    public void showBack(int p) {
        switch (p) {
            case 1:
                backcard_p1_1.setVisible(true);
                backcard_p1_2.setVisible(true);
                break;
            case 2:
                backcard_p2_1.setVisible(true);
                backcard_p2_2.setVisible(true);
                break;
            case 3:
                backcard_p3_1.setVisible(true);
                backcard_p3_2.setVisible(true);
                break;
            case 4:
                backcard_p4_1.setVisible(true);
                backcard_p4_2.setVisible(true);
                break;
            case 5:
                backcard_p5_1.setVisible(true);
                backcard_p5_2.setVisible(true);
                break;
            case 6:
                backcard_p6_1.setVisible(true);
                backcard_p6_2.setVisible(true);
                break;
            case 7:
                backcard_p7_1.setVisible(true);
                backcard_p7_2.setVisible(true);
                break;
            case 8:
                backcard_p8_1.setVisible(true);
                backcard_p8_2.setVisible(true);
                break;
        }
    }

    public void updateMoney() {
        if (player_ingame[1]) {
            money_p1.setText(String.valueOf(p[1].getCredit()));
        }
        if (player_ingame[2]) {
            money_p2.setText(String.valueOf(p[2].getCredit()));
        }
        if (player_ingame[3]) {
            money_p3.setText(String.valueOf(p[3].getCredit()));
        }
        if (player_ingame[4]) {
            money_p4.setText(String.valueOf(p[4].getCredit()));
        }
        if (player_ingame[5]) {
            money_p5.setText(String.valueOf(p[5].getCredit()));
        }
        if (player_ingame[6]) {
            money_p6.setText(String.valueOf(p[6].getCredit()));
        }
        if (player_ingame[7]) {
            money_p7.setText(String.valueOf(p[7].getCredit()));
        }
        if (player_ingame[8]) {
            money_p8.setText(String.valueOf(p[8].getCredit()));
        }
        pot.setText(String.valueOf(t.getPot()));
    }

    public void setMoneyVisible() {
        if (player_ingame[1]) {
            money_p1.setVisible(true);
            bg_p1.setVisible(true);
        } else {
            money_p1.setVisible(false);
            bg_p1.setVisible(false);
        }
        if (player_ingame[2]) {
            money_p2.setVisible(true);
            bg_p2.setVisible(true);
        } else {
            money_p2.setVisible(false);
            bg_p2.setVisible(false);
        }
        if (player_ingame[3]) {
            money_p3.setVisible(true);
            bg_p3.setVisible(true);
        } else {
            money_p3.setVisible(false);
            bg_p3.setVisible(false);
        }
        if (player_ingame[4]) {
            money_p4.setVisible(true);
            bg_p4.setVisible(true);
        } else {
            money_p4.setVisible(false);
            bg_p4.setVisible(false);
        }
        if (player_ingame[5]) {
            money_p5.setVisible(true);
            bg_p5.setVisible(true);
        } else {
            money_p5.setVisible(false);
            bg_p5.setVisible(false);
        }
        if (player_ingame[6]) {
            money_p6.setVisible(true);
            bg_p6.setVisible(true);
        } else {
            money_p6.setVisible(false);
            bg_p6.setVisible(false);
        }
        if (player_ingame[7]) {
            money_p7.setVisible(true);
            bg_p7.setVisible(true);
        } else {
            money_p7.setVisible(false);
            bg_p7.setVisible(false);
        }
        if (player_ingame[8]) {
            money_p8.setVisible(true);
            bg_p8.setVisible(true);
        } else {
            money_p8.setVisible(false);
            bg_p8.setVisible(false);
        }

    }

    public void update() {
    }

    public void role_assign() {
        int temp = (int) (Math.random() * 69 * playeringame);
        for (int playerItr = 1; temp > 0; playerItr++) {
            if (playerItr == 9) {
                playerItr = 1;
            }
            if (player_ingame[playerItr]) {
                smallBlind = playerItr;
            }
            temp--;
        }
        for (int playerItr = smallBlind - 1; bigBlind == 0; playerItr--) {
            if (playerItr == 0) {
                playerItr = 8;
            }
            if (player_ingame[playerItr]) {
                bigBlind = playerItr;
            }
        }
        for (int playerItr = bigBlind - 1; underTheGun == 0; playerItr--) {
            if (playerItr == 0) {
                playerItr = 8;
            }
            if (player_ingame[playerItr]) {
                underTheGun = playerItr;
            }
        }
    }

    public void turn_indicator() {
        if (player_turn == 1) {
            point_p1_turn.setVisible(true);
            point_p2_turn.setVisible(false);
            point_p3_turn.setVisible(false);
            point_p4_turn.setVisible(false);
            point_p5_turn.setVisible(false);
            point_p6_turn.setVisible(false);
            point_p7_turn.setVisible(false);
            point_p8_turn.setVisible(false);
        } else if (player_turn == 2) {
            point_p1_turn.setVisible(false);
            point_p2_turn.setVisible(true);
            point_p3_turn.setVisible(false);
            point_p4_turn.setVisible(false);
            point_p5_turn.setVisible(false);
            point_p6_turn.setVisible(false);
            point_p7_turn.setVisible(false);
            point_p8_turn.setVisible(false);
        } else if (player_turn == 3) {
            point_p1_turn.setVisible(false);
            point_p2_turn.setVisible(false);
            point_p3_turn.setVisible(true);
            point_p4_turn.setVisible(false);
            point_p5_turn.setVisible(false);
            point_p6_turn.setVisible(false);
            point_p7_turn.setVisible(false);
            point_p8_turn.setVisible(false);
        } else if (player_turn == 4) {
            point_p1_turn.setVisible(false);
            point_p2_turn.setVisible(false);
            point_p3_turn.setVisible(false);
            point_p4_turn.setVisible(true);
            point_p5_turn.setVisible(false);
            point_p6_turn.setVisible(false);
            point_p7_turn.setVisible(false);
            point_p8_turn.setVisible(false);
        } else if (player_turn == 5) {
            point_p1_turn.setVisible(false);
            point_p2_turn.setVisible(false);
            point_p3_turn.setVisible(false);
            point_p4_turn.setVisible(false);
            point_p5_turn.setVisible(true);
            point_p6_turn.setVisible(false);
            point_p7_turn.setVisible(false);
            point_p8_turn.setVisible(false);
        } else if (player_turn == 6) {
            point_p1_turn.setVisible(false);
            point_p2_turn.setVisible(false);
            point_p3_turn.setVisible(false);
            point_p4_turn.setVisible(false);
            point_p5_turn.setVisible(false);
            point_p6_turn.setVisible(true);
            point_p7_turn.setVisible(false);
            point_p8_turn.setVisible(false);
        } else if (player_turn == 7) {
            point_p1_turn.setVisible(false);
            point_p2_turn.setVisible(false);
            point_p3_turn.setVisible(false);
            point_p4_turn.setVisible(false);
            point_p5_turn.setVisible(false);
            point_p6_turn.setVisible(false);
            point_p7_turn.setVisible(true);
            point_p8_turn.setVisible(false);
        } else if (player_turn == 8) {
            point_p1_turn.setVisible(false);
            point_p2_turn.setVisible(false);
            point_p3_turn.setVisible(false);
            point_p4_turn.setVisible(false);
            point_p5_turn.setVisible(false);
            point_p6_turn.setVisible(false);
            point_p7_turn.setVisible(false);
            point_p8_turn.setVisible(true);
        }
    }

    public void setCardVisible() {
        if (player_ingame[1]) {
            card_p1_1.setVisible(true);
            card_p1_2.setVisible(true);
            backcard_p1_1.setVisible(true);
            backcard_p1_2.setVisible(true);
        } else {
            card_p1_1.setVisible(false);
            card_p1_2.setVisible(false);
            backcard_p1_1.setVisible(false);
            backcard_p1_2.setVisible(false);
        }
        if (player_ingame[2]) {
            card_p2_1.setVisible(true);
            card_p2_2.setVisible(true);
            backcard_p2_1.setVisible(true);
            backcard_p2_2.setVisible(true);
        } else {
            card_p2_1.setVisible(false);
            card_p2_2.setVisible(false);
            backcard_p2_1.setVisible(false);
            backcard_p2_2.setVisible(false);
        }
        if (player_ingame[3]) {
            card_p3_1.setVisible(true);
            card_p3_2.setVisible(true);
            backcard_p3_1.setVisible(true);
            backcard_p3_2.setVisible(true);
        } else {
            card_p3_1.setVisible(false);
            card_p3_2.setVisible(false);
            backcard_p3_1.setVisible(false);
            backcard_p3_2.setVisible(false);
        }
        if (player_ingame[4]) {
            card_p4_1.setVisible(true);
            card_p4_2.setVisible(true);
            backcard_p4_1.setVisible(true);
            backcard_p4_2.setVisible(true);
        } else {
            card_p4_1.setVisible(false);
            card_p4_2.setVisible(false);
            backcard_p4_1.setVisible(false);
            backcard_p4_2.setVisible(false);
        }
        if (player_ingame[5]) {
            card_p5_1.setVisible(true);
            card_p5_2.setVisible(true);
            backcard_p5_1.setVisible(true);
            backcard_p5_2.setVisible(true);
        } else {
            card_p5_1.setVisible(false);
            card_p5_2.setVisible(false);
            backcard_p5_1.setVisible(false);
            backcard_p5_2.setVisible(false);
        }
        if (player_ingame[6]) {
            card_p6_1.setVisible(true);
            card_p6_2.setVisible(true);
            backcard_p6_1.setVisible(true);
            backcard_p6_2.setVisible(true);
        } else {
            card_p6_1.setVisible(false);
            card_p6_2.setVisible(false);
            backcard_p6_1.setVisible(false);
            backcard_p6_2.setVisible(false);
        }
        if (player_ingame[7]) {
            card_p7_1.setVisible(true);
            card_p7_2.setVisible(true);
            backcard_p7_1.setVisible(true);
            backcard_p7_2.setVisible(true);
        } else {
            card_p7_1.setVisible(false);
            card_p7_2.setVisible(false);
            backcard_p7_1.setVisible(false);
            backcard_p7_2.setVisible(false);
        }
        if (player_ingame[8]) {
            card_p8_1.setVisible(true);
            card_p8_2.setVisible(true);
            backcard_p8_1.setVisible(true);
            backcard_p8_2.setVisible(true);
        } else {
            card_p8_1.setVisible(false);
            card_p8_2.setVisible(false);
            backcard_p8_1.setVisible(false);
            backcard_p8_2.setVisible(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        media = new Media(getClass().getResource("Prof_Daeng.mp4").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        intro.setMediaPlayer(mediaPlayer);

        MainMenu.setVisible(true);
        Game.setVisible(false);
        Win.setVisible(false);
        Video.setVisible(false);
        stupid_pane.setCursor(Cursor.DEFAULT);
    }

    @FXML
    private void play(ActionEvent event) {
        System.out.println("sawasdeekrub thansamachick");
        MainMenu.setVisible(false);
        Game.setVisible(true);

        //gameplay hide button+textfield
        btn_fold.setVisible(false);
        fill_raise.setVisible(false);
        btn_raise.setVisible(false);
        btn_check.setVisible(false);

        //player
        player1.setVisible(false);
        player2.setVisible(false);
        player3.setVisible(false);
        player4.setVisible(false);
        player5.setVisible(false);
        player6.setVisible(false);
        player7.setVisible(false);
        player8.setVisible(false);
        dealer.setVisible(false);

        //btn
        player1_sit_btn.setVisible(true);
        player2_sit_btn.setVisible(true);
        player3_sit_btn.setVisible(true);
        player4_sit_btn.setVisible(true);
        player5_sit_btn.setVisible(true);
        player6_sit_btn.setVisible(true);
        player7_sit_btn.setVisible(true);
        player8_sit_btn.setVisible(true);
        game_setup = true;
        //point
        point_p1_turn.setVisible(false);
        point_p2_turn.setVisible(false);
        point_p3_turn.setVisible(false);
        point_p4_turn.setVisible(false);
        point_p5_turn.setVisible(false);
        point_p6_turn.setVisible(false);
        point_p7_turn.setVisible(false);
        point_p8_turn.setVisible(false);
        //card
        setCardVisible();
        //money
        bg_p1.setVisible(false);
        money_p1.setVisible(false);
        bg_p2.setVisible(false);
        money_p2.setVisible(false);
        bg_p3.setVisible(false);
        money_p3.setVisible(false);
        bg_p4.setVisible(false);
        money_p4.setVisible(false);
        bg_p5.setVisible(false);
        money_p5.setVisible(false);
        bg_p6.setVisible(false);
        money_p6.setVisible(false);
        bg_p7.setVisible(false);
        money_p7.setVisible(false);
        bg_p8.setVisible(false);
        money_p8.setVisible(false);
        pot.setVisible(false);
        bg_pot.setVisible(false);
        //win
        p1_win.setOpacity(0.3);
        p2_win.setOpacity(0.3);
        p3_win.setOpacity(0.3);
        p4_win.setOpacity(0.3);
        p5_win.setOpacity(0.3);
        p6_win.setOpacity(0.3);
        p7_win.setOpacity(0.3);
        p8_win.setOpacity(0.3);
    }

    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void player1_sit(ActionEvent event) {
        if (game_setup) {
            player1_sit_btn.setVisible(false);
            player1.setVisible(true);
            player_ingame[1] = true;
        }
    }

    @FXML
    private void player2_sit(ActionEvent event) {
        if (game_setup) {
            player2_sit_btn.setVisible(false);
            player2.setVisible(true);
            player_ingame[2] = true;
        }
    }

    @FXML
    private void player3_sit(ActionEvent event) {
        if (game_setup) {
            player3_sit_btn.setVisible(false);
            player3.setVisible(true);
            player_ingame[3] = true;
        }
    }

    @FXML
    private void player4_sit(ActionEvent event) {
        if (game_setup) {
            player4_sit_btn.setVisible(false);
            player4.setVisible(true);
            player_ingame[4] = true;
        }
    }

    @FXML
    private void player5_sit(ActionEvent event) {
        if (game_setup) {
            player5_sit_btn.setVisible(false);
            player5.setVisible(true);
            player_ingame[5] = true;
        }
    }

    @FXML
    private void player6_sit(ActionEvent event) {
        if (game_setup) {
            player6_sit_btn.setVisible(false);
            player6.setVisible(true);
            player_ingame[6] = true;
        }
    }

    @FXML
    private void player7_sit(ActionEvent event) {
        if (game_setup) {
            player7_sit_btn.setVisible(false);
            player7.setVisible(true);
            player_ingame[7] = true;
        }
    }

    @FXML
    private void player8_sit(ActionEvent event) {
        if (game_setup) {
            player8_sit_btn.setVisible(false);
            player8.setVisible(true);
            player_ingame[8] = true;
        }
    }

    @FXML
    private void player1_remove(MouseEvent event) {
        if (game_setup) {
            player1.setVisible(false);
            player1_sit_btn.setVisible(true);
            player_ingame[1] = false;
        }
    }

    @FXML
    private void player2_remove(MouseEvent event) {
        if (game_setup) {
            player2.setVisible(false);
            player2_sit_btn.setVisible(true);
            player_ingame[2] = false;
        }
    }

    @FXML
    private void player3_remove(MouseEvent event) {
        if (game_setup) {
            player3.setVisible(false);
            player3_sit_btn.setVisible(true);
            player_ingame[3] = false;
        }
    }

    @FXML
    private void player4_remove(MouseEvent event) {
        if (game_setup) {
            player4.setVisible(false);
            player4_sit_btn.setVisible(true);
            player_ingame[4] = false;
        }
    }

    @FXML
    private void player5_remove(MouseEvent event) {
        if (game_setup) {
            player5.setVisible(false);
            player5_sit_btn.setVisible(true);
            player_ingame[5] = false;
        }
    }

    @FXML
    private void player6_remove(MouseEvent event) {
        if (game_setup) {
            player6.setVisible(false);
            player6_sit_btn.setVisible(true);
            player_ingame[6] = false;
        }
    }

    @FXML
    private void player7_remove(MouseEvent event) {
        if (game_setup) {
            player7.setVisible(false);
            player7_sit_btn.setVisible(true);
            player_ingame[7] = false;
        }
    }

    @FXML
    private void player8_remove(MouseEvent event) {
        if (game_setup) {
            player8.setVisible(false);
            player8_sit_btn.setVisible(true);
            player_ingame[8] = false;
        }
    }

    public void startGameDraw() {
        for (int start_drawItr = 1; start_drawItr <= 2; start_drawItr++) {
            for (int playerItr = 0; playerItr < 9; playerItr++) {
                if (player_ingame[playerItr]) {
                    p[playerItr].draw(d.draw()); //draw 2 per player
                }
            }
        }
        for (int i = 1; i < 9; i++) {
            if (player_ingame[i]) {
                if (i == 1) {
                    showCard(card_p1_1, p[1].getCard(0));
                    showCard(card_p1_2, p[1].getCard(1));
                }
                if (i == 2) {
                    showCard(card_p2_1, p[2].getCard(0));
                    showCard(card_p2_2, p[2].getCard(1));
                }
                if (i == 3) {
                    showCard(card_p3_1, p[3].getCard(0));
                    showCard(card_p3_2, p[3].getCard(1));
                }
                if (i == 4) {
                    showCard(card_p4_1, p[4].getCard(0));
                    showCard(card_p4_2, p[4].getCard(1));
                }
                if (i == 5) {
                    showCard(card_p5_1, p[5].getCard(0));
                    showCard(card_p5_2, p[5].getCard(1));
                }
                if (i == 6) {
                    showCard(card_p6_1, p[6].getCard(0));
                    showCard(card_p6_2, p[6].getCard(1));
                }
                if (i == 7) {
                    showCard(card_p7_1, p[7].getCard(0));
                    showCard(card_p7_2, p[7].getCard(1));
                }
                if (i == 8) {
                    showCard(card_p8_1, p[8].getCard(0));
                    showCard(card_p8_2, p[8].getCard(1));
                }
            }
        }

        d.discard();//discard top deck
    }

    //gamestart
    @FXML
    private void start(ActionEvent event) {
        Card testCardzz = new Card(2, 1);
        showCard(card_table_1, testCardzz);
        playeringame = 0;
        for (int i = 0; i < 9; i++) {
            if (player_ingame[i] == true) {
                playeringame++;
            }
        }
        if (playeringame > 1) {
            game_setup = false;
            start_btn.setVisible(false);
            player1_sit_btn.setVisible(false);
            player2_sit_btn.setVisible(false);
            player3_sit_btn.setVisible(false);
            player4_sit_btn.setVisible(false);
            player5_sit_btn.setVisible(false);
            player6_sit_btn.setVisible(false);
            player7_sit_btn.setVisible(false);
            player8_sit_btn.setVisible(false);
            for (int playerItr = 0; playerItr < 9; playerItr++) {
                if (player_ingame[playerItr]) {
                    p[playerItr] = new Player(1000000); //give player credit
                }

            }
            startGameDraw();
            setCardVisible();
        }
        winVisible();
        role_assign();
        player_turn = underTheGun;
        turn_indicator();
        System.out.println("smallBlind = " + smallBlind);
        System.out.println("bigBlind = " + bigBlind);
        System.out.println("underTheGun = " + underTheGun);
        setMoneyVisible();
        btn_fold.setVisible(true);
        btn_check.setVisible(true);
        btn_raise.setVisible(true);
        fill_raise.setVisible(true);
        pot.setVisible(true);
        bg_pot.setVisible(true);
        raiseThisRound = t.bet(p[bigBlind].firstTurnRaise(10000));
        t.bet(p[smallBlind].call(5000));
        updateMoney();
        call_value.setText(Integer.toString(raiseThisRound - p[player_turn].getBetThisRound()));
    }

    @FXML
    private void view_card_p1_2(MouseEvent event) {
        if (player_turn == 1) {
            backcard_p1_2.setVisible(false);
        }
    }

    @FXML
    private void view_card_p1_1(MouseEvent event) {
        if (player_turn == 1) {
            backcard_p1_1.setVisible(false);
        }
    }

    @FXML
    private void view_card_p2_2(MouseEvent event) {
        if (player_turn == 2) {
            backcard_p2_2.setVisible(false);
        }
    }

    @FXML
    private void view_card_p2_1(MouseEvent event) {
        if (player_turn == 2) {
            backcard_p2_1.setVisible(false);
        }
    }

    @FXML
    private void view_card_p3_2(MouseEvent event) {
        if (player_turn == 3) {
            backcard_p3_2.setVisible(false);
        }
    }

    @FXML
    private void view_card_p3_1(MouseEvent event) {
        if (player_turn == 3) {
            backcard_p3_1.setVisible(false);
        }
    }

    @FXML
    private void view_card_p4_2(MouseEvent event) {
        if (player_turn == 4) {
            backcard_p4_2.setVisible(false);
        }
    }

    @FXML
    private void view_card_p4_1(MouseEvent event) {
        if (player_turn == 4) {
            backcard_p4_1.setVisible(false);
        }
    }

    @FXML
    private void view_card_p5_1(MouseEvent event) {
        if (player_turn == 5) {
            backcard_p5_1.setVisible(false);
        }
    }

    @FXML
    private void view_card_p5_2(MouseEvent event) {
        if (player_turn == 5) {
            backcard_p5_2.setVisible(false);
        }
    }

    @FXML
    private void view_card_p6_1(MouseEvent event) {
        if (player_turn == 6) {
            backcard_p6_1.setVisible(false);
        }
    }

    @FXML
    private void view_card_p6_2(MouseEvent event) {
        if (player_turn == 6) {
            backcard_p6_2.setVisible(false);
        }
    }

    @FXML
    private void view_card_p8_1(MouseEvent event) {
        if (player_turn == 8) {
            backcard_p8_1.setVisible(false);
        }
    }

    @FXML
    private void view_card_p7_1(MouseEvent event) {
        if (player_turn == 7) {
            backcard_p7_1.setVisible(false);
        }
    }

    @FXML
    private void view_card_p7_2(MouseEvent event) {
        if (player_turn == 7) {
            backcard_p7_2.setVisible(false);
        }
    }

    @FXML
    private void view_card_p8_2(MouseEvent event) {
        if (player_turn == 8) {
            backcard_p8_2.setVisible(false);
        }
    }

    @FXML
    private void fold(ActionEvent event) {
        p[player_turn].fold();
        switch (player_turn) {
            case 1:
                player1.setOpacity(0.5);
                break;
            case 2:
                player2.setOpacity(0.5);
                break;
            case 3:
                player3.setOpacity(0.5);
                break;
            case 4:
                player4.setOpacity(0.5);
                break;
            case 5:
                player5.setOpacity(0.5);
                break;
            case 6:
                player6.setOpacity(0.5);
                break;
            case 7:
                player7.setOpacity(0.5);
                break;
            case 8:
                player8.setOpacity(0.5);
                break;
        }
        showBack(player_turn);
        if (checkFold()) {
        } else {
            player_turn = findNextPlayer();
            call_value.setText(Integer.toString(raiseThisRound - p[player_turn].getBetThisRound()));
            checkRound();
            turn_indicator();
            updateMoney();
        }
    }

    @FXML
    private void call(ActionEvent event) {
        t.bet(p[player_turn].call(raiseThisRound - p[player_turn].getBetThisRound()));
        showBack(player_turn);
        checkFold();
        player_turn = findNextPlayer();
        call_value.setText(Integer.toString(raiseThisRound - p[player_turn].getBetThisRound()));
        checkRound();
        turn_indicator();
        updateMoney();
    }

    @FXML
    private void raise(ActionEvent event) throws IOException{
        try {
            if (Integer.parseInt(fill_raise.getText()) > 0) {
                raiseTimeThisRound++;
                if (raiseTimeThisRound == 3) {
                    btn_raise.setVisible(false);
                    fill_raise.setVisible(false);
                }
                t.bet(p[player_turn].call(raiseThisRound - p[player_turn].getBetThisRound()));
                raiseThisRound += t.bet(p[player_turn].raise(Integer.parseInt(fill_raise.getText())));
                showBack(player_turn);
                checkFold();
                player_turn = findNextPlayer();
                call_value.setText(Integer.toString(raiseThisRound - p[player_turn].getBetThisRound()));
                fill_raise.setText("");
                checkRound();
                turn_indicator();
                updateMoney();
            }
            else if (Integer.parseInt(fill_raise.getText()) <= 0){
                daengYellAtYou();
            }
        } 
        catch(Exception e)  {
            daengYellAtYou();
        }
    }

    @FXML
    private void hide_card_p1_2(MouseEvent event) {
        backcard_p1_2.setVisible(true);
    }

    @FXML
    private void hide_card_p1_1(MouseEvent event) {
        backcard_p1_1.setVisible(true);
    }

    @FXML
    private void hide_card_p2_2(MouseEvent event) {
        backcard_p2_2.setVisible(true);
    }

    @FXML
    private void hide_card_p2_1(MouseEvent event) {
        backcard_p2_1.setVisible(true);
    }

    @FXML
    private void hide_card_p3_2(MouseEvent event) {
        backcard_p3_2.setVisible(true);
    }

    @FXML
    private void hide_card_p3_1(MouseEvent event) {
        backcard_p3_1.setVisible(true);
    }

    @FXML
    private void hide_card_p4_2(MouseEvent event) {
        backcard_p4_2.setVisible(true);
    }

    @FXML
    private void hide_card_p4_1(MouseEvent event) {
        backcard_p4_1.setVisible(true);
    }

    @FXML
    private void hide_card_p5_1(MouseEvent event) {
        backcard_p5_1.setVisible(true);
    }

    @FXML
    private void hide_card_p5_2(MouseEvent event) {
        backcard_p5_2.setVisible(true);
    }

    @FXML
    private void hide_card_p6_1(MouseEvent event) {
        backcard_p6_1.setVisible(true);
    }

    @FXML
    private void hide_card_p6_2(MouseEvent event) {
        backcard_p6_2.setVisible(true);
    }

    @FXML
    private void hide_card_p8_1(MouseEvent event) {
        backcard_p8_1.setVisible(true);
    }

    @FXML
    private void hide_card_p7_1(MouseEvent event) {
        backcard_p7_1.setVisible(true);
    }

    @FXML
    private void hide_card_p7_2(MouseEvent event) {
        backcard_p7_2.setVisible(true);
    }

    @FXML
    private void hide_card_p8_2(MouseEvent event) {
        backcard_p8_2.setVisible(true);
    }

    @FXML
    private void continueToNextRound(ActionEvent event) {
        Win.setVisible(false);
        p1_win.setOpacity(0.3);
        p2_win.setOpacity(0.3);
        p3_win.setOpacity(0.3);
        p4_win.setOpacity(0.3);
        p5_win.setOpacity(0.3);
        p6_win.setOpacity(0.3);
        p7_win.setOpacity(0.3);
        p8_win.setOpacity(0.3);
    }

}
