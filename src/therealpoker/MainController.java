package therealpoker;

import java.io.File;
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
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;

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

    private Media media;
    private Media buttonSound;
    private MediaPlayer soundEffect;
    private MediaPlayer mediaPlayer;

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
    @FXML
    private AnchorPane TheOne;
    @FXML
    private ImageView the_one_bg;
    @FXML
    private ImageView p_the_one;
    @FXML
    private Button play_again_btn;
    @FXML
    private Button to_mainmenu_btn;
    @FXML
    private ImageView fail_p1;
    @FXML
    private ImageView fail_p2;
    @FXML
    private ImageView fail_p3;
    @FXML
    private ImageView fail_p4;
    @FXML
    private ImageView fail_p5;
    @FXML
    private ImageView fail_p6;
    @FXML
    private ImageView fail_p7;
    @FXML
    private ImageView fail_p8;
    @FXML
    private MediaView btn_sound;

    String path;
    File file;

    private void soundEffect(String type) {

        if (type.contains("press") || type.contains("quit")) {
            path = "Sound/btn_press.mp3";
        } else if (type.contains("call") || type.contains("raise")) {
            path = "Sound/call_raise.mp3";
        } else if (type.contains("fold")) {
            path = "Sound/Painful_Scream.mp3";
        } else if (type.contains("win")) {
            path = "Sound/win_round.mp3";
        }
        buttonSound = new Media(getClass().getResource(path).toExternalForm());
        soundEffect = new MediaPlayer(buttonSound);
        btn_sound.setMediaPlayer(soundEffect);
        soundEffect.play();

    }

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
        p1_win.setVisible(true);
        p2_win.setVisible(true);
        p3_win.setVisible(true);
        p4_win.setVisible(true);
        p5_win.setVisible(true);
        p6_win.setVisible(true);
        p7_win.setVisible(true);
        p8_win.setVisible(true);

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

    public void bankruptCheck() {
        for (int i = 1; i < 9; i++) {
            if (player_ingame[i]) {
                if (p[i].getCredit() == 0) {
                    p[i].setBankrupt(true);
                    switch (i) {
                        case 1:
                            fail_p1.setVisible(true);
                            break;
                        case 2:
                            fail_p2.setVisible(true);
                            break;
                        case 3:
                            fail_p3.setVisible(true);
                            break;
                        case 4:
                            fail_p4.setVisible(true);
                            break;
                        case 5:
                            fail_p5.setVisible(true);
                            break;
                        case 6:
                            fail_p6.setVisible(true);
                            break;
                        case 7:
                            fail_p7.setVisible(true);
                            break;
                        case 8:
                            fail_p8.setVisible(true);
                            break;
                    }

                }
            }
            setCardVisible();

        }
    }

    public void checkLastOne() {
        int i;
        int lastOne = 0;
        int bankruptAmount = 0;
        for (i = 1; i < 9; i++) {
            if (player_ingame[i]) {
                if (p[i].isBankrupt()) {
                    bankruptAmount++;
                } else {
                    lastOne = i;
                }
            }
        }
        if (bankruptAmount == playeringame - 1) {
            //lastManStandingPane
            TheOne.setVisible(true);
            soundEffect("win");
            Image imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/FourOfSpade.png"));
            switch (lastOne) {
                case 1:
                    imaged = new Image(getClass().getResourceAsStream("??????????????????/Player/player1.png"));
                    break;
                case 2:
                    imaged = new Image(getClass().getResourceAsStream("??????????????????/Player/player2.png"));
                    break;
                case 3:
                    imaged = new Image(getClass().getResourceAsStream("??????????????????/Player/player3.png"));
                    break;
                case 4:
                    imaged = new Image(getClass().getResourceAsStream("??????????????????/Player/player4.png"));
                    break;
                case 5:
                    imaged = new Image(getClass().getResourceAsStream("??????????????????/Player/player5.png"));
                    break;
                case 6:
                    imaged = new Image(getClass().getResourceAsStream("??????????????????/Player/player6.png"));
                    break;
                case 7:
                    imaged = new Image(getClass().getResourceAsStream("??????????????????/Player/player7.png"));
                    break;
                case 8:
                    imaged = new Image(getClass().getResourceAsStream("??????????????????/Player/player8.png"));
                    break;
            }
            p_the_one.setImage(imaged);
            for (int j = 1; j < 9; j++) {
                if (player_ingame[j]) {
                    p[j].setBankrupt(false);
                }
            }
        }

    }

    public void showCard(ImageView view, Card c) {
        int type = c.getSuit();
        int num = c.getVolume();
        System.out.println(type + "  " + num);
        Image imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/FourOfSpade.png"));
        if (type == 4) {
            if (num == 2) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/TwoOfSpade.png"));
            } else if (num == 3) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/ThreeOfSpade.png"));
            } else if (num == 4) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/FourOfSpade.png"));
            } else if (num == 5) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/FiveOfSpade.png"));
            } else if (num == 6) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/SixOfSpade.png"));
            } else if (num == 7) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/SevenOfSpade.png"));
            } else if (num == 8) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/EightOfSpade.png"));
            } else if (num == 9) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/NineOfSpade.png"));
            } else if (num == 10) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/TenOfSpade.png"));
            } else if (num == 11) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/JackOfSpade.png"));
            } else if (num == 12) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/QueenOfSpade.png"));
            } else if (num == 13) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/KingOfSpade.png"));
            } else if (num == 14) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Spade/AceOfSpade.png"));
            }
        } else if (type == 3) {
            if (num == 2) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/TwoOfHeart.png"));
            } else if (num == 3) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/ThreeOfHeart.png"));
            } else if (num == 4) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/FourOfHeart.png"));
            } else if (num == 5) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/FiveOfHeart.png"));
            } else if (num == 6) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/SixOfHeart.png"));
            } else if (num == 7) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/SevenOfHeart.png"));
            } else if (num == 8) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/EightOfHeart.png"));
            } else if (num == 9) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/NineOfHeart.png"));
            } else if (num == 10) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/TenOfHeart.png"));
            } else if (num == 11) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/JackOfHeart.png"));
            } else if (num == 12) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/QueenOfHeart.png"));
            } else if (num == 13) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/KingOfHeart.png"));
            } else if (num == 14) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Heart/AceOfHeart.png"));
            }
        } else if (type == 2) {
            if (num == 2) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/TwoOfDiamond.png"));
            } else if (num == 3) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/ThreeOfDiamond.png"));
            } else if (num == 4) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/FourOfDiamond.png"));
            } else if (num == 5) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/FiveOfDiamond.png"));
            } else if (num == 6) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/SixOfDiamond.png"));
            } else if (num == 7) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/SevenOfDiamond.png"));
            } else if (num == 8) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/EightOfDiamond.png"));
            } else if (num == 9) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/NineOfDiamond.png"));
            } else if (num == 10) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/TenOfDiamond.png"));
            } else if (num == 11) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/JackOfDiamond.png"));
            } else if (num == 12) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/QueenOfDiamond.png"));
            } else if (num == 13) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/KingOfDiamond.png"));
            } else if (num == 14) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Diamond/AceOfDiamond.png"));
            }
        } else if (type == 1) {
            if (num == 2) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/TwoOfClub.png"));
            } else if (num == 3) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/ThreeOfClub.png"));
            } else if (num == 4) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/FourOfClub.png"));
            } else if (num == 5) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/FiveOfClub.png"));
            } else if (num == 6) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/SixOfClub.png"));
            } else if (num == 7) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/SevenOfClub.png"));
            } else if (num == 8) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/EightOfClub.png"));
            } else if (num == 9) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/NineOfClub.png"));
            } else if (num == 10) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/TenOfClub.png"));
            } else if (num == 11) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/JackOfClub.png"));
            } else if (num == 12) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/QueenOfClub.png"));
            } else if (num == 13) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/KingOfClub.png"));
            } else if (num == 14) {
                imaged = new Image(getClass().getResourceAsStream("??????????????????/Club/AceOfClub.png"));
            }
        } else {
            imaged = new Image(getClass().getResourceAsStream("??????????????????/behide.png"));
        }
        view.setImage(imaged);

    }

    public void checkRound() {
        //check if all player betThisRound=raiseThisRound
        int check = 0;
        for (int i = 1; i < 9; i++) {
            if (player_ingame[i]) {
                if (p[i].isFold() || (p[i].getBetThisRound() == raiseThisRound && p[i].isCheck()) || p[i].isAllIn() || p[i].isBankrupt()) {
                    check++;
                }
            }
        }
        if (playeringame == check) {
            raiseThisRound = 0;
            for (int i = 1; i < 9; i++) {
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
                for (int i = 1; i < 9; i++) {
                    if (player_ingame[i] && !p[i].isFold() && !p[i].isBankrupt()) {
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
                bankruptCheck();
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
            if (player_ingame[i]) {
                if (!p[i].isFold() && !p[i].isBankrupt()) {
                    return i;
                }
            }
        }
        return 0;
    }

    public boolean checkFold() {
        int check = 0;
        for (int i = 1; i < 9; i++) {
            if (player_ingame[i] && (p[i].isFold() || p[i].isBankrupt())) {
                check++;
            }
        }
        System.out.println("check " + check);
        int winner = 0;
        if (check == playeringame - 1) {
            raiseThisRound = 0;
            for (int i = 1; i < 9; i++) {
                if (player_ingame[i]) {
                    if (!p[i].isFold() && !p[i].isBankrupt()) {
                        p[i].reward(t.getPot());
                        winner = i;
                    }
                    p[i].reset();
                }
            }
            pot_win.setText(Integer.toString(t.getPot()));
            Win.setVisible(true);
            soundEffect("win");
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
            bankruptCheck();
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
        smallBlind = 0;
        bigBlind = 0;
        underTheGun = 0;
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
        if (player_ingame[1] && !p[1].isBankrupt()) {
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
        if (player_ingame[2] && !p[2].isBankrupt()) {
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
        if (player_ingame[3] && !p[3].isBankrupt()) {
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
        if (player_ingame[4] && !p[4].isBankrupt()) {
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
        if (player_ingame[5] && !p[5].isBankrupt()) {
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
        if (player_ingame[6] && !p[6].isBankrupt()) {
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
        if (player_ingame[7] && !p[7].isBankrupt()) {
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
        if (player_ingame[8] && !p[8].isBankrupt()) {
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
        TheOne.setVisible(false);
        stupid_pane.setCursor(Cursor.DEFAULT);
    }

    @FXML
    private void play(ActionEvent event) {
        soundEffect("press");
        playeringame = 0;
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
        for (int i = 1; i < 9; i++) {
            player_ingame[i] = false;
        }

        //btn
        start_btn.setVisible(true);
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
        //
        fail_p1.setVisible(false);
        fail_p2.setVisible(false);
        fail_p3.setVisible(false);
        fail_p4.setVisible(false);
        fail_p5.setVisible(false);
        fail_p6.setVisible(false);
        fail_p7.setVisible(false);
        fail_p8.setVisible(false);
        //card
        card_p1_1.setVisible(false);
        card_p1_2.setVisible(false);
        card_p2_1.setVisible(false);
        card_p2_2.setVisible(false);
        card_p3_1.setVisible(false);
        card_p3_2.setVisible(false);
        card_p4_1.setVisible(false);
        card_p4_2.setVisible(false);
        card_p5_1.setVisible(false);
        card_p5_2.setVisible(false);
        card_p6_1.setVisible(false);
        card_p6_2.setVisible(false);
        card_p7_1.setVisible(false);
        card_p7_2.setVisible(false);
        card_p8_1.setVisible(false);
        card_p8_2.setVisible(false);
        backcard_p1_1.setVisible(false);
        backcard_p1_2.setVisible(false);
        backcard_p2_1.setVisible(false);
        backcard_p2_2.setVisible(false);
        backcard_p3_1.setVisible(false);
        backcard_p3_2.setVisible(false);
        backcard_p4_1.setVisible(false);
        backcard_p4_2.setVisible(false);
        backcard_p5_1.setVisible(false);
        backcard_p5_2.setVisible(false);
        backcard_p6_1.setVisible(false);
        backcard_p6_2.setVisible(false);
        backcard_p7_1.setVisible(false);
        backcard_p7_2.setVisible(false);
        backcard_p8_1.setVisible(false);
        backcard_p8_2.setVisible(false);

        //checkMoney
        call_value.setVisible(false);

    }

    @FXML
    private void quit(ActionEvent event) {
        soundEffect("press");
        System.exit(0);
    }

    @FXML
    private void player1_sit(ActionEvent event) {
        if (game_setup) {
            soundEffect("press");
            player1_sit_btn.setVisible(false);
            player1.setVisible(true);
            player_ingame[1] = true;
        }
    }

    @FXML
    private void player2_sit(ActionEvent event) {
        if (game_setup) {
            soundEffect("press");
            player2_sit_btn.setVisible(false);
            player2.setVisible(true);
            player_ingame[2] = true;
        }
    }

    @FXML
    private void player3_sit(ActionEvent event) {
        if (game_setup) {
            soundEffect("press");
            player3_sit_btn.setVisible(false);
            player3.setVisible(true);
            player_ingame[3] = true;
        }
    }

    @FXML
    private void player4_sit(ActionEvent event) {
        if (game_setup) {
            soundEffect("press");
            player4_sit_btn.setVisible(false);
            player4.setVisible(true);
            player_ingame[4] = true;
        }
    }

    @FXML
    private void player5_sit(ActionEvent event) {
        if (game_setup) {
            soundEffect("press");
            player5_sit_btn.setVisible(false);
            player5.setVisible(true);
            player_ingame[5] = true;
        }
    }

    @FXML
    private void player6_sit(ActionEvent event) {
        if (game_setup) {
            soundEffect("press");
            player6_sit_btn.setVisible(false);
            player6.setVisible(true);
            player_ingame[6] = true;
        }
    }

    @FXML
    private void player7_sit(ActionEvent event) {
        if (game_setup) {
            soundEffect("press");
            player7_sit_btn.setVisible(false);
            player7.setVisible(true);
            player_ingame[7] = true;
        }
    }

    @FXML
    private void player8_sit(ActionEvent event) {
        if (game_setup) {
            soundEffect("press");
            player8_sit_btn.setVisible(false);
            player8.setVisible(true);
            player_ingame[8] = true;
        }
    }

    @FXML
    private void player1_remove(MouseEvent event) {
        if (game_setup) {
            soundEffect("press");
            player1.setVisible(false);
            player1_sit_btn.setVisible(true);
            player_ingame[1] = false;
        }
    }

    @FXML
    private void player2_remove(MouseEvent event) {
        if (game_setup) {
            soundEffect("press");
            player2.setVisible(false);
            player2_sit_btn.setVisible(true);
            player_ingame[2] = false;
        }
    }

    @FXML
    private void player3_remove(MouseEvent event) {
        if (game_setup) {
            soundEffect("press");
            player3.setVisible(false);
            player3_sit_btn.setVisible(true);
            player_ingame[3] = false;
        }
    }

    @FXML
    private void player4_remove(MouseEvent event) {
        if (game_setup) {
            soundEffect("press");
            player4.setVisible(false);
            player4_sit_btn.setVisible(true);
            player_ingame[4] = false;
        }
    }

    @FXML
    private void player5_remove(MouseEvent event) {
        if (game_setup) {
            soundEffect("press");
            player5.setVisible(false);
            player5_sit_btn.setVisible(true);
            player_ingame[5] = false;
        }
    }

    @FXML
    private void player6_remove(MouseEvent event) {
        if (game_setup) {
            soundEffect("press");
            player6.setVisible(false);
            player6_sit_btn.setVisible(true);
            player_ingame[6] = false;
        }
    }

    @FXML
    private void player7_remove(MouseEvent event) {
        if (game_setup) {
            soundEffect("press");
            player7.setVisible(false);
            player7_sit_btn.setVisible(true);
            player_ingame[7] = false;
        }
    }

    @FXML
    private void player8_remove(MouseEvent event) {
        if (game_setup) {
            soundEffect("press");
            player8.setVisible(false);
            player8_sit_btn.setVisible(true);
            player_ingame[8] = false;
        }
    }

    public void startGameDraw() {
        for (int start_drawItr = 1; start_drawItr <= 2; start_drawItr++) {
            for (int playerItr = 1; playerItr < 9; playerItr++) {
                if (player_ingame[playerItr] && !p[playerItr].isBankrupt()) {
                    p[playerItr].draw(d.draw()); //draw 2 per player
                }
            }
        }
        for (int i = 1; i < 9; i++) {
            if (player_ingame[i] && !p[i].isBankrupt()) {
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
        soundEffect("press");
        Card testCardzz = new Card(2, 1);
        t.reset();
        d.reset();
        showCard(card_table_1, testCardzz);
        playeringame = 0;
        for (int i = 1; i < 9; i++) {
            if (player_ingame[i] == true) {
                playeringame++;
                System.out.println("p" + i);
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
            for (int playerItr = 1; playerItr < 9; playerItr++) {
                if (player_ingame[playerItr]) {
                    p[playerItr] = new Player(1000000); //give player credit
                }

            }
            startGameDraw();
            setCardVisible();
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
            call_value.setVisible(true);
            call_value.setText(Integer.toString(raiseThisRound - p[player_turn].getBetThisRound()));
        }
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
        soundEffect("fold");
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
        soundEffect("call");
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
    private void raise(ActionEvent event) throws IOException {
        try {
            if (Integer.parseInt(fill_raise.getText()) > 0) {
                soundEffect("raise");
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
            } else if (Integer.parseInt(fill_raise.getText()) <= 0) {
                daengYellAtYou();
            }
        } catch (Exception e) {
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
        checkLastOne();
    }

    @FXML
    private void PlayAgainBtn(ActionEvent event) {
        soundEffect("press");
        playeringame = 0;
        System.out.println("sawasdeekrub thansamachick");
        MainMenu.setVisible(false);
        TheOne.setVisible(false);
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
        for (int i = 1; i < 9; i++) {
            player_ingame[i] = false;
        }

        //btn
        start_btn.setVisible(true);
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
        //
        fail_p1.setVisible(false);
        fail_p2.setVisible(false);
        fail_p3.setVisible(false);
        fail_p4.setVisible(false);
        fail_p5.setVisible(false);
        fail_p6.setVisible(false);
        fail_p7.setVisible(false);
        fail_p8.setVisible(false);
        //card
        card_p1_1.setVisible(false);
        card_p1_2.setVisible(false);
        card_p2_1.setVisible(false);
        card_p2_2.setVisible(false);
        card_p3_1.setVisible(false);
        card_p3_2.setVisible(false);
        card_p4_1.setVisible(false);
        card_p4_2.setVisible(false);
        card_p5_1.setVisible(false);
        card_p5_2.setVisible(false);
        card_p6_1.setVisible(false);
        card_p6_2.setVisible(false);
        card_p7_1.setVisible(false);
        card_p7_2.setVisible(false);
        card_p8_1.setVisible(false);
        card_p8_2.setVisible(false);
        backcard_p1_1.setVisible(false);
        backcard_p1_2.setVisible(false);
        backcard_p2_1.setVisible(false);
        backcard_p2_2.setVisible(false);
        backcard_p3_1.setVisible(false);
        backcard_p3_2.setVisible(false);
        backcard_p4_1.setVisible(false);
        backcard_p4_2.setVisible(false);
        backcard_p5_1.setVisible(false);
        backcard_p5_2.setVisible(false);
        backcard_p6_1.setVisible(false);
        backcard_p6_2.setVisible(false);
        backcard_p7_1.setVisible(false);
        backcard_p7_2.setVisible(false);
        backcard_p8_1.setVisible(false);
        backcard_p8_2.setVisible(false);

        //checkMoney
        call_value.setVisible(false);

    }

    @FXML
    private void MainMenuBtn(ActionEvent event) {
        soundEffect("press");
        MainMenu.setVisible(true);
        Game.setVisible(false);
        Win.setVisible(false);
        Video.setVisible(false);
        TheOne.setVisible(false);
    }

}
