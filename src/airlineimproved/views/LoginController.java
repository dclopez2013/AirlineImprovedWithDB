/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.views;

import static airlineimproved.views.Main.main;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private TextField userName;
    
    @FXML
    private PasswordField pass;
    
    @FXML
    private Button loginAdmin;
    
    @FXML
    private Button cancel;
    
    @FXML
    private TextField userNameAdmin;
    
    @FXML
    private PasswordField passAdmin;
    
    
    @FXML
    public void gotoCreateAccount() throws IOException{
       main.createAccount();
    }
    
    
    @FXML
    public void adminClear(){
    
    }
    
    @FXML
    public void adminLogin() throws SQLException{
        Alert alert = new Alert(AlertType.ERROR);
        String errorType="Unable To Login";
        String content = "The credentials you provided were not able to be verified. Please Try Again";
        alert.setTitle(errorType);
        alert.setContentText(content);
        String uid = userNameAdmin.getText();
        String password = passAdmin.getText();

        if(Main.getDBConnect().validateUserAdmin(uid,password)){
            try {
                main.showAdmin();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            alert.showAndWait();
            
        }
    }
    
    
    @FXML
    public void login() throws IOException, SQLException{

        Alert alert = new Alert(AlertType.ERROR);
        String errorType="Unable To Login";
        String content = "The credentials you provided were not able to be verified. Please Try Again";
        alert.setTitle(errorType);
        alert.setContentText(content);
        String uid = userName.getText();
        String password = pass.getText();
        String temp = "Testing Login!";
        
       
        if(Main.getDBConnect().validateUser(uid,password)){
         main.login(uid);
            
        }
        else{
            alert.showAndWait();
            
        }
    }
 
    @FXML
    public void testLogin(){
        Alert alert = new Alert(AlertType.ERROR);
        String errorType="Unable To Login";
        String content = "The credentials you provided were not able to be verified. Please Try Again";
        alert.setTitle(errorType);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
