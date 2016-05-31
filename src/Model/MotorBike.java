package Model;

import java.util.*;

/**
 * Created by Michał on 03.03.2016.
 */
public class MotorBike extends Vehicle {

    public MotorBike(){

    }

    public MotorBike(String brand, String model, int idWorkShop, int idRental, double pricePerDay){

        DataBase B = new DataBase();
        counter++;
        this.idVehicle = B.getNumberofVehicles() + 1;
        this.brand = brand;
        this.model = model;
        this.idWorkShop = idWorkShop;
        this.idRental = idRental;
        this.pricePerDay = pricePerDay;
        this.itRent = 0;

        faultsList = new ArrayList<Fault>();
        inspectionsList = new ArrayList<Inspection>();
    }

    public MotorBike(int id, String brand, String model, int idWorkShop, int idRental, double pricePerDay, int itRent){

        counter++;
        this.idVehicle = id;
        this.brand = brand;
        this.model = model;
        this.idWorkShop = idWorkShop;
        this.idRental = idRental;
        this.pricePerDay = pricePerDay;
        this.itRent = itRent;

        faultsList = new ArrayList<Fault>();
        inspectionsList = new ArrayList<Inspection>();


    }



    @Override
    public String toString() {
        return null;
    }
}
