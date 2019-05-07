/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.views;

import airlineimproved.database.databaseMain;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dclop
 */
public class AdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    //CREATE USER TAB
    
    //BUTTONS
    @FXML
    private Button quit;
    
    @FXML
    private Button clear;
    
    @FXML
    private Button submit;
    
    
    //FIELDS
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField userName;
    @FXML
    private TextField email;

    
    @FXML
    private PasswordField pass1;
    @FXML
    private PasswordField pass2;
    
    
    
    //CREATE FLIGHT TAB
    
    
    //DELETE FLIGHT TAB
    
    //DELETE USER TAB
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    @FXML
    public void createUser() throws SQLException, IOException{
    
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        String error="";
        
           String first = this.firstName.getText().trim();
        String last = this.lastName.getText().trim();
        String uEmail = this.email.getText().trim();
        String username = this.userName.getText().trim();
        String passOne = this.pass1.getText().trim();
        String passTwo = this.pass2.getText().trim();
        
   
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
    
        public boolean checkUsername(String username) throws SQLException{
        databaseMain db = Main.getDBConnect();
            
        return db.userExists(username);
    }
        
        @FXML
        private void clearFields(){
    
        this.firstName.clear();
        this.lastName.clear();
        this.email.clear();
        this.userName.clear();
        this.pass1.clear();
        this.pass2.clear();
    }
    
}
