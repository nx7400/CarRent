import javax.xml.crypto.Data;
import java.util.*;

/**
 * Created by Michał on 03.03.2016.
 */
public class Car extends Vehicle {

    public Car() {

    }

    public Car(String brand, String model, int idWorkShop, int idRental, double pricePerDay) {

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

    public Car(int id, String brand, String model, int idWorkShop, int idRental, double pricePerDay, int itRent) {

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
        String result = "Id: " + this.idVehicle + ", " + this.brand + ", " + this.model + ", " + this.pricePerDay + ", " + this.itRent;
        return result;
    }
}
