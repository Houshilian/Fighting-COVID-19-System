/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Customer;

/**
 *
 * @author TeamCodeHater
 */
public class Reservation {
     private String flightNo;
    private int row;
    private int col;
    public Reservation() {
    }

    public Reservation(String flightNo, int row, int col) {
        this.flightNo = flightNo;
        this.row = row;
        this.col = col;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    @Override
    public String toString()
    {
        return this.flightNo;
    }
    
}
