/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.airlines;

import java.util.ArrayList;

/**
 *
 * @author epik
 */
class ConcordiaAirlines extends Airlines{

    private Flight flight;

    @Override
    void setSeats(int seatIndex, int[] seats, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    int[] getSeats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String[] filmsAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String[] mealsAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setFlight(String start, String End, String Crew[], int flightTime,int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    Flight getFlight() {
        return this.flight;
    }

    
   
    class Flight{
        ArrayList Places = new ArrayList();
        String Countries[]={"USA","Canada","Mexico","Germany","Italy","Spain","Russia","Australia","England"};
        String Cities[];
        String States[];
        String Crew[];
        String Start;
        String End;
        
        int flightTime;
        
        public Flight(String start, String End, String Crew[], int flightTime){
         this.Start = start;
         this.End = End;
         this.Crew = Crew;
         this.flightTime=flightTime;
         }
    }
    
}
