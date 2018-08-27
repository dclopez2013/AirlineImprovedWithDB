/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author dclop
 */
public class CreateAccountController{

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button home;
    
    
    @FXML
    private void goHome() throws IOException{
        Main.goHome();
    }
}
