/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

import Business.Airliner.Flight;
import Business.Airliner.Airliner;
import Business.Airliner.Airplane;
import java.util.ArrayList;
import java.util.Date;

/**
 * 旅行社类，包含航空公司列表、
 * @author TeamCodeHater
 */
public class TravelAgency {
    private AirlinerDirectory airlinerDir=new AirlinerDirectory();//航空公司目录
    private CustomerDirectory customerDir=new CustomerDirectory();//顾客目录
    
    public TravelAgency()
    {
        
    }
    
    //通过航空公司名称搜索航空公司信息
    public Airliner searchAirlineByName(String airlinerName)
    {
        Airliner result=null;//搜索结果为空，表示无匹配的航空公司名称
        for(Airliner airliner:airlinerDir.getAirlinerList())
        {
            if(airliner.getAirlinerName().equals(airlinerName))
                result=airliner;//寻找名称匹配的航空公司
        }
        return result;
    }
    
    //通过preferred time of day、出发地、目的地、日期等搜索该航空公司包含的全部的航班中合适的航班列表
    public ArrayList<Flight> searchFlight(String timeOfDay,String departureLoc,String arrivalLoc,Date date)
    {
        ArrayList<Flight> result=new ArrayList<Flight>();
        for(Airliner airliner:airlinerDir.getAirlinerList())//搜索所有航空公司
        {
            for(Flight f:airliner.getSchedule().getFlights())//搜索每一家航空公司的航班排表
            {
                if(f.getTimeOfDay().equals(timeOfDay)&&f.getDepartureLoc().equals(departureLoc)&&f.getArrivalLoc().equals(arrivalLoc)&&f.getFlightDate().equals(date))
                {
                    result.add(f);
                }
            }
        }
        
        return result;
    }
    
    //通过preferred time of day、出发地、目的地搜索该航空公司包含的全部的航班中合适的航班列表
    public ArrayList<Flight> searchFlightByPreferredTimeAndLoc(String timeOfDay,String departureLoc,String arrivalLoc)
    {
        ArrayList<Flight> result=new ArrayList<Flight>();
        for(Airliner airliner:airlinerDir.getAirlinerList())//搜索所有航空公司
        {
            for(Flight f:airliner.getSchedule().getFlights())//搜索每一家航空公司的航班排表
            {
                if(f.getTimeOfDay().equals(timeOfDay)&&f.getDepartureLoc().equals(departureLoc)&&f.getArrivalLoc().equals(arrivalLoc))
                {
                    result.add(f);
                }
            }
        }
        
        return result;
    }

    public AirlinerDirectory getAirlinerDir() {
        return airlinerDir;
    }

    public void setAirlinerDir(AirlinerDirectory airlinerDir) {
        this.airlinerDir = airlinerDir;
    }

    public CustomerDirectory getCustomerDir() {
        return customerDir;
    }

    public void setCustomerDir(CustomerDirectory customerDir) {
        this.customerDir = customerDir;
    }
    public String getAirlinerNameByFlight(Flight f)
    {
        String res="";
        for(Airliner airliner:this.airlinerDir.getAirlinerList())
        {
            for(Flight flight:airliner.getSchedule().getFlights())
            {
                if(flight.equals(f))
                    res=airliner.getAirlinerName();
            }
        }
        return res;
    }
    public boolean isFlightExist(String flightNo)
    {
        for(Airliner a:this.airlinerDir.getAirlinerList())
        {
            for(Flight f:a.getSchedule().getFlights())
            {
                if(f.getFlightNum().equals(flightNo))
                    return true;
            }
        }
        return false;
    }
     public Flight searchFlightByNum(String flightNo)
    {
        Flight res=null;
        for(Airliner a:this.airlinerDir.getAirlinerList())
        {
            for(Flight f:a.getSchedule().getFlights())
            {
                if(f.getFlightNum().equals(flightNo))
                    return f;
            }
        }
        return res;
    }
    public boolean isAirplaneExist(String airplaneNo)
    {
        for(Airliner a:this.airlinerDir.getAirlinerList())
        {
            for(Airplane p:a.getFleet().getAirplanes())
            {
                if(p.getAirplaneID().equals(airplaneNo))
                    return true;
            }
            
        }
        return false;
    }
    
}
