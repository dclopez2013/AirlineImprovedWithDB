/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.views;

import static airlineimproved.views.Main.main;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author dclop
 */
public class LoginController{
    
    private Main main;
    
    @FXML
    private Button login;
    
    @FXML
    private Button createAccount;
    
    @FXML
    public void gotoCreateAccount() throws IOException{
       main.createAccount();
    }
    
    @FXML
    public void login() throws IOException{
        main.login();
    }
 
    
}
