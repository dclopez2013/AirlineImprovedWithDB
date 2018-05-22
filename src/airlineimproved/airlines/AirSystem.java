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
    class AirSystem {
     private static DeltaAirlines Delta;
     private static UnitedAirlines United;
     private static SouthWestAirlines SouthWest;
     private static ConcordiaAirlines Concordia;
     private static RyanairAirlines RyanAir;
     
    AirSystem() {
        Delta = new DeltaAirlines(255);
         United = new UnitedAirlines();
         SouthWest= new SouthWestAirlines();
         Concordia = new ConcordiaAirlines();
         RyanAir = new RyanairAirlines();
         
         String tmpCrew[]={"Tim the Pilot","John the Co-Pilot","Jane the flight attendant"};
         Delta.setFlight("USA", "Mexico",tmpCrew, 2,0);
         
    }
}
