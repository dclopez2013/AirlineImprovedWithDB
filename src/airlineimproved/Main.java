/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author dclop
 */
public class Main extends Application {
    private Stage primaryStage;
    private static BorderPane mainLayout;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JavaFX Airline System");
        
        showMainView();
       
    }

    public void showMainView() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("mainView.fxml"));
        mainLayout = loader.load();     
        Scene scene = new Scene(mainLayout); 
        primaryStage.setScene(scene);
        primaryStage.show();
        showLogin();
        
    }
    
    public static void createAccount() throws IOException{
        System.out.println("creating account...");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("createAccount.fxml"));
        BorderPane create = loader.load();
        mainLayout.setCenter(create);
    
    }   
    public static void showLogin() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("login.fxml"));
        BorderPane login = loader.load();
        mainLayout.setCenter(login);
    }
    
    public static void goHome() throws IOException{
        showLogin();
    }
    
    public static void login(){
        System.out.println("logged in");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
