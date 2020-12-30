/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Airliner;

/**
 *
 * @author xingx
 */
public class Airliner {

    private String airlinerName;//航空公司名称
    private String address;//航空公司地址
     private FlightSchedule schedule=new FlightSchedule();//航班表
    private Fleet fleet=new Fleet();//飞机组成的机组
    /**
     * @param args the command line arguments
     */
  public Airliner() {
    }

    
    public Airliner(String airlinerName, String address) {
        this.airlinerName = airlinerName;
        this.address = address;
    } 
    
public int getTotalFlightsPerDay()//每天的航班总数
    {
        return this.schedule.getFlights().size();
    }

    public FlightSchedule getSchedule() {
        return schedule;
    }
    public void setSchedule(FlightSchedule schedule) {
        this.schedule = schedule;
    }
       public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }
    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

@Override
    public String toString()
    {
        return this.airlinerName;
    }   
    
    
}
