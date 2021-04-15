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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Moke
 */
public class MainController implements Initializable {

    boolean[] player_ingame = new boolean[9]; //default false
    int player_turn = 0;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MainMenu.setVisible(true);
        Game.setVisible(false);
        stupid_pane.setCursor(Cursor.CROSSHAIR);
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
    }

    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void player1_sit(ActionEvent event) {
        player1_sit_btn.setVisible(false);
        player1.setVisible(true);
        player_ingame[1] = true;
    }

    @FXML
    private void player2_sit(ActionEvent event) {
        player2_sit_btn.setVisible(false);
        player2.setVisible(true);
        player_ingame[2] = true;
    }

    @FXML
    private void player3_sit(ActionEvent event) {
        player3_sit_btn.setVisible(false);
        player3.setVisible(true);
        player_ingame[3] = true;
    }

    @FXML
    private void player4_sit(ActionEvent event) {
        player4_sit_btn.setVisible(false);
        player4.setVisible(true);
        player_ingame[4] = true;
    }

    @FXML
    private void player5_sit(ActionEvent event) {
        player5_sit_btn.setVisible(false);
        player5.setVisible(true);
        player_ingame[5] = true;
    }

    @FXML
    private void player6_sit(ActionEvent event) {
        player6_sit_btn.setVisible(false);
        player6.setVisible(true);
        player_ingame[6] = true;
    }

    @FXML
    private void player7_sit(ActionEvent event) {
        player7_sit_btn.setVisible(false);
        player7.setVisible(true);
        player_ingame[7] = true;
    }

    @FXML
    private void player8_sit(ActionEvent event) {
        player8_sit_btn.setVisible(false);
        player8.setVisible(true);
        player_ingame[8] = true;
    }

    @FXML
    private void player1_remove(MouseEvent event) {
        player1.setVisible(false);
        player1_sit_btn.setVisible(true);
        player_ingame[1] = false;
    }

    @FXML
    private void player2_remove(MouseEvent event) {
        player2.setVisible(false);
        player2_sit_btn.setVisible(true);
        player_ingame[2] = false;
    }

    @FXML
    private void player3_remove(MouseEvent event) {
        player3.setVisible(false);
        player3_sit_btn.setVisible(true);
        player_ingame[3] = false;
    }

    @FXML
    private void player4_remove(MouseEvent event) {
        player4.setVisible(false);
        player4_sit_btn.setVisible(true);
        player_ingame[4] = false;
    }

    @FXML
    private void player5_remove(MouseEvent event) {
        player5.setVisible(false);
        player5_sit_btn.setVisible(true);
        player_ingame[5] = false;
    }

    @FXML
    private void player6_remove(MouseEvent event) {
        player6.setVisible(false);
        player6_sit_btn.setVisible(true);
        player_ingame[6] = false;
    }

    @FXML
    private void player7_remove(MouseEvent event) {
        player7.setVisible(false);
        player7_sit_btn.setVisible(true);
        player_ingame[7] = false;
    }

    @FXML
    private void player8_remove(MouseEvent event) {
        player8.setVisible(false);
        player8_sit_btn.setVisible(true);
        player_ingame[8] = false;
    }

    //gamestart
    @FXML
    private void start(ActionEvent event) {
        start_btn.setVisible(false);
        player1_sit_btn.setVisible(false);
        player2_sit_btn.setVisible(false);
        player3_sit_btn.setVisible(false);
        player4_sit_btn.setVisible(false);
        player5_sit_btn.setVisible(false);
        player6_sit_btn.setVisible(false);
        player7_sit_btn.setVisible(false);
        player8_sit_btn.setVisible(false);
        Deck d = new Deck();
        Player[] p = new Player[9];
        for (int playerItr = 0; playerItr < 9; playerItr++) {
            if (player_ingame[playerItr]) {
                p[playerItr] = new Player(1000000); //give player credit
            }

        }
        Table t = new Table();
        for (int start_drawItr = 1; start_drawItr <= 2; start_drawItr++) {
            for (int playerItr = 0; playerItr < 9; playerItr++) {
                if (player_ingame[playerItr]) {
                    p[playerItr].draw(d.draw()); //draw 2 per player
                }
            }
        }

        d.discard();//discard top deck
        for (int i=1;i<9;i++)
        {
            if (player_ingame[i]==true)
            {
                player_turn=i;
                break;
            }
        }
    }

}
