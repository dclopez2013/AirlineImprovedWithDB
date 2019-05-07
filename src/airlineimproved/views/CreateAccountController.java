/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.views;

import airlineimproved.database.databaseMain;
import airlineimproved.database.dbConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private Button submit;
    
    @FXML
    private CheckBox agree;
    
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
    
    @FXML
    private void createUser() throws IOException, SQLException{
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        String error="";
        
        
        if(agree.isSelected()){
        echo("check box Selected");
        String first = this.firstName.getText().trim();
        String last = this.lastName.getText().trim();
        String uEmail = this.email.getText().trim();
        String uEmail2 = this.emailConfirm.getText().trim();
        String username = this.userName.getText().trim();
        String passOne = this.password.getText().trim();
        String passTwo = this.passwordConfirm.getText().trim();
        
        
       if(!checkUsername(username)){
           
           
       
            if(passOne.contentEquals(passTwo)){

            databaseMain db = Main.getDBConnect();

            try {
                db.createUser(username, first, last, uEmail, passTwo);
            } catch (SQLException ex) {
                Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else{
                error = "Please ensure passwords match";

                alert.setTitle("Account Creation Error");
                alert.setContentText(error);
                alert.showAndWait();
            }
        }
       else{
           error = "Username: "+username+" already exists";
            
           alert.setTitle("Account Creation Error");
           alert.setContentText(error);
           alert.showAndWait();
           
           clearFields();
       }
       
       
        }
        else{
            error = "Please ensure you agree to terms and check the box if you agree";
            
            alert.setTitle("Account Creation Error");
            alert.setContentText(error);
            alert.showAndWait();
        }
       }
        
    
    
    @FXML
    private void clearFields(){
    
        this.firstName.clear();
        this.lastName.clear();
        this.email.clear();
        this.emailConfirm.clear();
        this.userName.clear();
        this.password.clear();
        this.passwordConfirm.clear();
    }
    
    
    public void echo(String s){
        System.out.println(s);
    }
    
    
    public boolean checkUsername(String username) throws SQLException{
        databaseMain db = Main.getDBConnect();
            
        return db.userExists(username);
    }
}
