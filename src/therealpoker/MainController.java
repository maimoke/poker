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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Moke
 */
public class MainController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MainMenu.setVisible(true);
        Game.setVisible(false);
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
    }

    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);
    }
}
