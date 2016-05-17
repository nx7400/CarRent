/**
 * Created by Michał on 03.03.2016.
 */
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    public static int counter = 0;
    protected int idVehicle;
    protected int idWorkShop;
    protected int idRental;
    protected String brand;
    protected String model;
    protected double pricePerDay;
    protected int itRent;
    protected ArrayList<Fault> faultsList;
    protected ArrayList<Inspection> inspectionsList;
    //pole bool czy jest aktywny (przeglad i brak usterek)


    public abstract String toString();

    public void addVehicleFault(){


    }

    public void addVehicleInspection(){

        Inspection C = new Inspection(12,"test");
    }


    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdWorkShop() {
        return idWorkShop;
    }

    public void setIdWorkShop(int idWorkShop) {
        this.idWorkShop = idWorkShop;
    }

    public int getIdRental() {
        return idRental;
    }

    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int isItRent() {
        return itRent;
    }

    public void setItRent(int itRent) {
        this.itRent = itRent;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
