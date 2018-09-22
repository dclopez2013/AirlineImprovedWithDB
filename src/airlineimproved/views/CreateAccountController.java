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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private Button clearText;
    
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField userName;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField emailConfirm;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private PasswordField passwordConfirm;
    
    @FXML
    private void goHome() throws IOException{
        Main.goHome();
    }
}
