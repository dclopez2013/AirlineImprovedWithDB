/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.views;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author dclop
 */
public class Flight {
    
    
    

    /**
     * @return the flightNum
     */
    public String getNum() {
        return num;
    }

    /**
     * @param flightNum the flightNum to set
     */
    public void setFlightNum(String flightNum) {
        this.num = flightNum;
    }

    /**
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }

    /**
     * @param airline the airline to set
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the dest
     */
    public String getDest() {
        return dest;
    }

    /**
     * @param dest the dest to set
     */
    public void setDest(String dest) {
        this.dest = dest;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the departTime
     */
    public String getDepart() {
        return depart;
    }

    /**
     * @param departTime the departTime to set
     */
    public void setDepart(String departTime) {
        this.depart = departTime;
    }

    /**
     * @return the arrTime
     */
    public String getArrive() {
        return arrive;
    }

    /**
     * @param arrTime the arrTime to set
     */
    public void setArrTime(String arrTime) {
        this.arrive = arrTime;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the seats
     */
    public String getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(String seats) {
        this.seats = seats;
    }
    
    private String num;
    private String airline;
    private String origin;
    private String dest;
    private String date;
    private String depart;
    private String arrive;
    private String price;
    private String seats;
    
    public Flight(String f,String a, String o,String desti, String prices,String dep,String arr,String seat, String dat){
        this.num= f;
        this.airline =a;
        this.origin= o;
        this.dest = desti;
        this.date = dat;
        this.depart = dep;
        this.arrive= arr;
        this.price= prices;
        this.seats= seat;
    }
}
