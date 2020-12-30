/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airliner;

/**
 * 飞机类，包含机型、座位排数和列数
 *
 * @author TeamCodeHater
 */
public class Airplane {
    private String airplaneID;//飞机ID
    private String manufacturer;//飞机的制造商，如Boeing、Airbus
    private String modelNumber;//飞机的机型，如747、320
    private int seatRows;//座位排数
    private int seatCols;//座位列数

    public Airplane() {

    }

    public Airplane(String airplaneID, String manufacturer, String modelNumber, int seatRows, int seatCols) {
        this.airplaneID = airplaneID;
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
        this.seatRows = seatRows;
        this.seatCols = seatCols;
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(String airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(int seatRows) {
        this.seatRows = seatRows;
    }

    public int getSeatCols() {
        return seatCols;
    }

    public void setSeatCols(int seatCols) {
        this.seatCols = seatCols;
    }

    @Override
    public String toString()
    {
        return this.airplaneID;
    }
}
