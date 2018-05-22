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

class DeltaAirlines extends Airlines{
    private final int numOfSeats;
    protected int seats[];
    private String films[];
    private String meals[];
    private String crew[];
    private final int maxFlights=100;
    private Flight flight[];
    
    public DeltaAirlines(int numSeats){
        this.numOfSeats = numSeats;
        this.seats= new int[numSeats];
        this.flight= new Flight[maxFlights];
        initSeats();
    }
    
    private void initSeats(){
        for(int x = 0; x <seats.length;x++){
            seats[x]=0;
        }
    }

    @Override
    void setSeats(int seatIndex, int[] seats,int value) {
        seats[seatIndex] = value;
    }

    @Override
    int[] getSeats() {
        return this.seats;
    }

    @Override
    String[] filmsAvailable() {
        return films;
    }

    @Override
    String[] mealsAvailable() {
        return meals;
    }

    @Override
    void setFlight(String start, String End, String Crew[], int flightTime,int i) {
       this.flight[i]= new Flight(start,End,Crew,4);
    }

    
    Flight getFlight(int i) {
        return flight[i];
    }
    void genFlights(){
        
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
        
        
        
        public void displayFlight(){
        System.out.println("This flight consists of a departure from "+this.Start +" and an arrival at "+this.End
        +"\n. The flight will take "+this.flightTime+" hours."+"\n"+"Youre crew will be :"+this.Crew[0]+", "+this.Crew[1]+", "+this.Crew[2]);
    }
    }
}
