/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

import Business.Airliner.Airliner;
import Business.Airliner.Flight;
import java.util.ArrayList;

/**
 * 航空公司列表，包含多个航空公司
 * @author TeamCodeHater
 */
public class AirlinerDirectory {
    private ArrayList<Airliner> airlinerList=new ArrayList<Airliner>();//航空公司列表
    
    public AirlinerDirectory() {
    }
    
    public AirlinerDirectory(ArrayList<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }
    

    public ArrayList<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(ArrayList<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }
    
    public boolean addAirliner(Airliner airliner)
    {
        for(Airliner a:this.airlinerList)
        {
            if(a.getAirlinerName().equals(airliner.getAirlinerName()))
            {
                return false;
            }
        }
        this.airlinerList.add(airliner);
        return true;
    }
    
    public boolean exist(Airliner airliner)
    {
        for(Airliner a:this.airlinerList)
        {
            if(a.getAirlinerName().equals(airliner.getAirlinerName()))
            {
                return true;
            }
        }
        return false;
    }
    public Flight getFlightByNum(String num)
    {
        Flight res=null;
        for(Airliner a:this.airlinerList)
        {
            for(Flight f:a.getSchedule().getFlights())
            {
                if(f.getFlightNum().equals(num))
                {
                    res=f;
                    break;
                }
                
            }
        }
        return res;
    }
    
}
