/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.airlines;


/**
 *
 * @author epik
 */
abstract class Airlines{         
    
     abstract void setSeats(int seatIndex,int seats[],int value);
     
     abstract int[] getSeats();
     
     abstract String[] filmsAvailable();
     
     abstract String[] mealsAvailable();
     
     abstract void setFlight(String start, String End, String Crew[], int flightTime,int i);
     

}