/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.views;

import airlineimproved.database.databaseMain;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dclop
 */
public class MainAppController implements Initializable {

    /**
     FXML Values
     */
    
    @FXML
    private ComboBox airlineBox;
    
    @FXML
    private ComboBox departBox;
    
    @FXML
    private ComboBox destBox;
    
    @FXML
    private DatePicker datePicked;
    
    @FXML
    private Button search;
    
    @FXML
    private Button clear;
    
    @FXML
    private Button selectFlight;
    
    @FXML
    private TableView<Flight> table;
    
    @FXML
    private TableColumn<Flight,String> col_num;
    
    @FXML
    private TableColumn<Flight,String> col_seats;
    
    @FXML
    private TableColumn<Flight,String> col_airline;
    
    @FXML
    private TableColumn<Flight,String> col_origin;
    
    @FXML
    private TableColumn<Flight,String> col_dest;
    
    @FXML
    private TableColumn<Flight,String> col_date;
    
    @FXML
    private TableColumn<Flight,String> col_dep;
    
    @FXML
    private TableColumn<Flight,String> col_arr;
    
    @FXML
    private TableColumn<Flight,String> col_price;
    
    
    
    
    ObservableList<String> airOptions = 
    FXCollections.observableArrayList(
        "United Airlines",
        "America Airlines",
        "Lufthansa Airlines",
        "Southwest Airlines",
        "RyanAir Airlines"
    );
    
    ObservableList<String> departOptions = 
    FXCollections.observableArrayList(
        "Seatle Tacoma",
        "Denver",
        "Dallas/Fort Worth",
        "O'Hare Internationl",
        "John F Kennedy JFK",
        "Los Angeles LAX",
        "Hartsfield-Jacson Atlanta",
        "San Franciso",
        "McCarran Las Vegas",
        "Phoexniv Sky Haror ITL",
        "George Bush Inter",
        "Charolette/Douglas",
        "Miami",
        "Orlanda",
        "Newark Liberty",
        "Minneapolis/St. Paul",
        "Detroit Metropolitan",
        "Philadelphia International",
        "Logan International",
        "LaGardia",
        "Baltimore-Washington",
        "Washington-Dulles",
        "Salt Lake City",
        "Midway Int",
        "Munich"
    );
    
    ObservableList<String> destOptions = 
    FXCollections.observableArrayList(
        "Seatle Tacoma",
        "Denver",
        "Dallas/Fort Worth",
        "O'Hare Internationl",
        "John F Kennedy JFK",
        "Los Angeles LAX",
        "Hartsfield-Jacson Atlanta",
        "San Franciso",
        "McCarran Las Vegas",
        "Phoexniv Sky Haror ITL",
        "George Bush Inter",
        "Charolette/Douglas",
        "Miami",
        "Orlando",
        "Newark Liberty",
        "Minneapolis/St. Paul",
        "Detroit Metropolitan",
        "Philadelphia International",
        "Logan International",
        "LaGardia",
        "Baltimore-Washington",
        "Washington-Dulles",
        "Salt Lake City",
        "Midway Int",
        "Munich"
    );
    
    ObservableList<Flight> flights = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        airlineBox.setItems(airOptions);
        departBox.setItems(departOptions);
        destBox.setItems(destOptions);
        
        databaseMain db = Main.getDBConnect();
        
        Connection conn = db.getConn();
        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from flights");
            
            while(rs.next()){              
                String name = rs.getString("AIRLINE");
                String origin = rs.getString("ORIGIN");
                String dest = rs.getString("DEST");
                String price = rs.getString("PRICE");
                String dep = rs.getString("DEPARTTIME");
                String arr = rs.getString("ARRIVETIME");
                String flt = rs.getString("FNUM");
                String seats = rs.getString("SEATS");
                String date = rs.getString("DATES");
                
                System.out.println("name "+name);
                System.out.println("origin "+origin);
                System.out.println("dest "+dest);
                System.out.println("price "+price);
                System.out.println("dep "+dep);
                System.out.println("arr "+arr);
                System.out.println("flt "+flt);
                System.out.println("seats "+seats);
                System.out.println("dte "+date);
                
                 flights.add(new Flight(flt,name,origin,dest,price,dep,arr,seats,date));
                
             //  / System.out.println("airline "+name+"/ origin "+origin+"/ destination "+dest+"/ price "
                 //       +price+"/ depTime "+dep+"/ arrTime "+arr+"/ flt "+flt+"/ seats "+seats+"/ dtes"+date);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        flights.forEach((item) -> {
            System.out.println("flight # "+item.getNum());
            System.out.println("air # "+item.getAirline());
            System.out.println("origin # "+item.getOrigin());
            System.out.println("dest # "+item.getDest());
            System.out.println("date # "+item.getDate());
            System.out.println("time # "+item.getDepart());
            System.out.println("arrive # "+item.getArrive());
            System.out.println("price # "+item.getPrice());
            System.out.println("seats # "+item.getSeats());
        });
 
        col_airline.setCellValueFactory(new PropertyValueFactory<>("airline"));
        col_origin.setCellValueFactory(new PropertyValueFactory<>("origin"));
        col_dest.setCellValueFactory(new PropertyValueFactory<>("dest"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_num.setCellValueFactory(new PropertyValueFactory<>("num"));
        col_dep.setCellValueFactory(new PropertyValueFactory<>("depart"));
        col_arr.setCellValueFactory(new PropertyValueFactory<>("arrive"));



        table.setItems(flights);
    }    
    
}
