/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

import Business.Customer.Customer;
import java.util.ArrayList;

/**
 * 顾客列表类，该旅行社的全部顾客
 * @author TeamCodeHater
 */
public class CustomerDirectory {
    private ArrayList<Customer> customers=new ArrayList<Customer>();

    public CustomerDirectory() {
    }
    
    public CustomerDirectory(ArrayList<Customer> customers)
    {
        this.customers=customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    
    public boolean addCustomer(Customer cust)
    {
        for(Customer c:customers)
        {
            if(c.getFirstName().equals(cust.getFirstName())&&c.getLastName().equals(cust.getLastName()))
                return false;
        }
        this.customers.add(cust);
        return true;
    }
    
    public boolean exist(String name,String passportNum)
    {
        for(Customer cust:this.customers)
        {
            if(name.equals(cust.getFirstName()+" "+cust.getLastName())&&passportNum.equals(cust.getPassportNum()))
                return true;
        }
        return false;
    }
    
    public Customer getCustomer(String name,String passportNum)
    {
        for(Customer cust:this.customers)
        {
            if(name.equals(cust.getFirstName()+" "+cust.getLastName())&&passportNum.equals(cust.getPassportNum()))
                return cust;
        }
        return null;
    }
    
    public Customer getCustomer(String name)
    {
        for(Customer cust:this.customers)
        {
            if(name.equals(cust.getFirstName()+" "+cust.getLastName()))
                return cust;
        }
        return null;
    }
}
