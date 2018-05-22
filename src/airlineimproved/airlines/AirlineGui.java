/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.airlines;

import javax.swing.JFrame;
import java.awt.*;
import static javafx.scene.paint.Color.GREY;
import javax.swing.*;
import javax.swing.JPanel;
/**
 *
 * @author epik
 */
class AirlineGui {
    private JFrame frame;
    private JPanel pannel;
    private static final int HEIGHT=200;
    private static final int WIDTH=350;
    private static final String title = "Airline Reservation System";
    public AirlineGui() {
       frame = new JFrame();
       frame.setSize(HEIGHT, WIDTH);
       frame.setTitle(title);
       frame.setBackground(Color.GRAY);
       frame.setVisible(true);
       
    }
    
}
