/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therealpoker;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    boolean[] player_ingame = new boolean[9]; //default false
    int player_turn = 0;
    boolean game_setup = false;
    int playeringame = 0;
    int bigBlind = 0;
    int smallBlind = 0;
    int underTheGun = 0;
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
    private Button btn_call;
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

    /**
     * Initializes the controller class.
     */
    public void showCard(ImageView view, Card c) {
        int type = c.getSuit();
        int num = c.getVolume();
        Image image = new Image("");
        if (type == 1) {
            switch (num) {
                case 2:
                    image = new Image("Club/TwooOfClub.png");
                    break;
                case 3:
                    image = new Image("");
                    break;
                case 4:
                    image = new Image("");
                    break;
                case 5:
                    image = new Image("");
                    break;
                case 6:
                    image = new Image("");
                    break;
                case 7:
                    image = new Image("");
                    break;
                case 8:
                    image = new Image("");
                    break;
                case 9:
                    image = new Image("");
                    break;
                case 10:
                    image = new Image("");
                    break;
                case 11:
                    image = new Image("");
                    break;
                case 12:
                    image = new Image("");
                    break;
                case 13:
                    image = new Image("");
                    break;
                case 14:
                    image = new Image("");
                    break;
            }

            view.setImage(image);
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
        } else {
            card_p1_1.setVisible(false);
            card_p1_2.setVisible(false);
        }
        if (player_ingame[2]) {
            card_p2_1.setVisible(true);
            card_p2_2.setVisible(true);
        } else {
            card_p2_1.setVisible(false);
            card_p2_2.setVisible(false);
        }
        if (player_ingame[3]) {
            card_p3_1.setVisible(true);
            card_p3_2.setVisible(true);
        } else {
            card_p3_1.setVisible(false);
            card_p3_2.setVisible(false);
        }
        if (player_ingame[4]) {
            card_p4_1.setVisible(true);
            card_p4_2.setVisible(true);
        } else {
            card_p4_1.setVisible(false);
            card_p4_2.setVisible(false);
        }
        if (player_ingame[5]) {
            card_p5_1.setVisible(true);
            card_p5_2.setVisible(true);
        } else {
            card_p5_1.setVisible(false);
            card_p5_2.setVisible(false);
        }
        if (player_ingame[6]) {
            card_p6_1.setVisible(true);
            card_p6_2.setVisible(true);
        } else {
            card_p6_1.setVisible(false);
            card_p6_2.setVisible(false);
        }
        if (player_ingame[7]) {
            card_p7_1.setVisible(true);
            card_p7_2.setVisible(true);
        } else {
            card_p7_1.setVisible(false);
            card_p7_2.setVisible(false);
        }
        if (player_ingame[8]) {
            card_p8_1.setVisible(true);
            card_p8_2.setVisible(true);
        } else {
            card_p8_1.setVisible(false);
            card_p8_2.setVisible(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MainMenu.setVisible(true);
        Game.setVisible(false);
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
        btn_check.setVisible(false);
        btn_call.setVisible(false);

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

    //gamestart
    @FXML
    private void start(ActionEvent event) {
        Image table1 = new Image(getClass().getResourceAsStream("รวมไพ่/Spade/TwoOfSpade.png"));
        card_table_1.setImage(table1);
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
            for (int start_drawItr = 1; start_drawItr <= 2; start_drawItr++) {
                for (int playerItr = 0; playerItr < 9; playerItr++) {
                    if (player_ingame[playerItr]) {
                        p[playerItr].draw(d.draw()); //draw 2 per player
                    }
                }
            }

            d.discard();//discard top deck
            setCardVisible();
        }

        role_assign();
        player_turn = underTheGun;
        turn_indicator();
        System.out.println("smallBlind = " + smallBlind);
        System.out.println("bigBlind = " + bigBlind);
        System.out.println("underTheGun = " + underTheGun);
        setMoneyVisible();
        updateMoney();
        Card testCard = new Card(2,1);
        
        
       // showCard(card_table_1,testCard); 
        

        
        
    }

      
   
    
    
}
