/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airliner;

import java.util.Calendar;
import java.util.Date;

/**
 * 航班类，包含航班号、飞行日期、飞行时间、出发地、目的地、飞机、座位表，座位表的行列数由飞机的行列数量决定，默认5行6列
 * @author TeamCodeHater
 */
public class Flight {
    private String flightNum;//航班号
    private Date flightDate;//MM/dd/yy
    private String timeOfDay;//morning,day,evening//self-define
    private Date departureTime;//hh:mm:ss
    private Date arrivalTime;//hh:mm:ss
    private String departureLoc;//出发地
    private String arrivalLoc;//目的地
    private Airplane airplane;//该航班对应的飞机
    private int[][] seats=new int[5][6];//座次表，默认5行6列；当设置了飞机airplane时，则会根据飞机的座位行数和列数确定，当某个顾客选定了座位，该位置设置为1表示已锁定，否则该位置为0表示空

    public Flight() {
        
    }
    
    public boolean book(int row,int col)//如果用户选定了该座位，将座次表对应的行列的值设置为1，表示已经锁定
    {
        if(seats[row][col]==0)//如果该座次值为0，表示尚未预订，将该座位预订并将值置为1，返回true
        {
            seats[row][col]=1;
            return true;
        }
        else//如果该座次值为1，表示已被预订，返回false
            return false;
    }
    
    public boolean cancelBook(int row,int col)//取消预订座位
    {
        if(seats[row][col]==1)//如果该座次值为1，表示已经被预订，将该座位取消预订并将值置为0，返回true
        {
            seats[row][col]=0;
            return true;
        }
        else//如果该座次值为0，表示未被预订，返回false
            return false;
    }

    public Flight(String flightNum, Date flightDate, String timeOfDay, String departureLoc, String arrivalLoc, Airplane airplane) {
        this.flightNum = flightNum;
        this.flightDate = flightDate;
        this.timeOfDay = timeOfDay;
        this.departureLoc = departureLoc;
        this.arrivalLoc = arrivalLoc;
        this.airplane = airplane;
        this.seats=new int[airplane.getSeatRows()][airplane.getSeatCols()];
    }

    public Flight(String flightNum,Date flightDate,String timeOfDay,String departureLoc,String arrivalLoc)
    {
        this.flightNum=flightNum;
        this.flightDate=flightDate;
        this.timeOfDay=timeOfDay;
        this.departureLoc=departureLoc;
        this.arrivalLoc=arrivalLoc;
        this.seats=new int[5][6];
    }

    public Flight(String flightNum, Date flightDate, String departureLoc, String arrivalLoc) {
        this.flightNum = flightNum;
        this.flightDate = flightDate;
        this.departureLoc = departureLoc;
        this.arrivalLoc = arrivalLoc;
        this.seats=new int[5][6];
    }
    
    //根据小时换算为timeOfDay
    public void setTimeOfDayByDetailedTime()
    {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(this.departureTime);
        int hour=c1.get(Calendar.HOUR_OF_DAY);
        if(hour>=5&&hour<=12)//早晨5：00-12：00
            this.timeOfDay="morning";
        else if(hour>12&&hour<19)//白天12:00-19:00
            this.timeOfDay="day";
        else//夜晚19:00-5:00
            this.timeOfDay="evening";
    }
    public String getFlightNum() {
        return flightNum;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    
    
    

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getTimeOfDay() {
        this.setTimeOfDayByDetailedTime();
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getDepartureLoc() {
        return departureLoc;
    }

    public void setDepartureLoc(String departureLoc) {
        this.departureLoc = departureLoc;
    }

    public String getArrivalLoc() {
        return arrivalLoc;
    }

    public void setArrivalLoc(String arrivalLoc) {
        this.arrivalLoc = arrivalLoc;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
        this.seats=new int[airplane.getSeatRows()][airplane.getSeatCols()];
    }

    public int[][] getSeats() {
        return seats;
    }

    public void setSeats(int[][] seats) {
        this.seats = seats;
    }
    
    @Override
    public String toString()
    {
        return this.flightNum;
    }
}
