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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void play(ActionEvent event) {
        System.out.println("sawasdeekrub thansamachick");
        
    }

    @FXML
    private void quit(ActionEvent event) {
    }
}
