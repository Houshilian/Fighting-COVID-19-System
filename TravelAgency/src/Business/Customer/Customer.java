/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Customer;

import java.util.ArrayList;
import java.util.Date;

/**
 * 顾客类，包含名字、护照号码、预定的航班号及预订信息列表
 * @author TeamCodeHater
 */
public class Customer {
    private String firstName;//顾客姓
    private String lastName;//顾客名
    private Date dateOfBirth;//顾客出生日期
    private String passportNum;//顾客护照号码
    private Date passportExpirationDate;//顾客护照过期时间
    private String nationality;//顾客国籍
    private String email;
    private ArrayList<Reservation> reservedList=new ArrayList<Reservation>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, Date dateOfBirth, String passportNum, Date passportExpirationDate, String nationality,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passportNum = passportNum;
        this.passportExpirationDate = passportExpirationDate;
        this.nationality = nationality;
    this.email=email;
    }
    
       public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getPassportExpirationDate() {
        return passportExpirationDate;
    }

    public void setPassportExpirationDate(Date passportExpirationDate) {
        this.passportExpirationDate = passportExpirationDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public ArrayList<Reservation> getReservedList() {
        return reservedList;
    }

    public boolean removeReservation(Reservation res)
    {
        Reservation toBeDelete=null;
        for(Reservation v:reservedList)
        {
            if(v.getFlightNo().equals(res.getFlightNo())&&v.getRow()==res.getRow()&&v.getCol()==res.getCol())
            {
                toBeDelete=v;
            }
        }
        if(toBeDelete==null)
            return false;
        else
        {
            this.reservedList.remove(toBeDelete);
            return true;
        }
    }
    public void setReservedList(ArrayList<Reservation> reservedList) {
        this.reservedList = reservedList;
    }

    public boolean newReservation(String flightNo,int row,int col)
    {
        for(Reservation v:reservedList)
        {
            if(v.getFlightNo().equals(flightNo)&&v.getRow()==row&&v.getCol()==col)
                return false;//已经预定对应航班及座位
        }
        reservedList.add(new Reservation(flightNo,row,col));//不存在相同航班及座位时，添加新的预订信息
        return true;
    }
    public boolean reservedThisFlight(Reservation res)
    {
        for(Reservation r:this.reservedList)
        {
            if(r.getFlightNo().equals(res.getFlightNo()))
                return true;
        }
        return false;
    }

    @Override
    public String toString()//java 有一个顶级父类， toString（）
    {
        return this.firstName+" "+this.lastName;
    }
    
    
}
