/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Airliner;
import Business.Airliner.Airplane;
import java.util.ArrayList;
/**
 *
 * @author TeamCodeHater
 */
public class Fleet {
    private ArrayList<Airplane> airplanes=new ArrayList<Airplane>();//每个fleet包含多架飞机
    public Fleet() {
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(ArrayList<Airplane> airplanes) {
        this.airplanes = airplanes;
    }
    
    public Airplane newAirplane()
    {
        Airplane newplane=new Airplane();
        this.airplanes.add(newplane);
        return newplane;
    }
    public boolean exist(Airplane air)
    {
        for(Airplane a:this.airplanes)
        {
            if(a.getAirplaneID().equals(air.getAirplaneID()))
                return true;
        }
        return false;
    }
}
