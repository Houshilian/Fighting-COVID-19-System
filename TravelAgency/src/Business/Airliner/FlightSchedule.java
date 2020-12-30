/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airliner;

import Business.Airliner.Flight;
import java.util.ArrayList;
import java.util.Date;

/**
 * 航班表类，包含多个航班
 * @author TeamCodeHater
 */
public class FlightSchedule {
    private ArrayList<Flight> flights=new ArrayList<Flight>();//航班组成的列表

    public FlightSchedule() {
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    public Flight newFlight()
    {
        Flight f=new Flight();
        this.flights.add(f);
        return f;
    }
}
