import java.util.*;

/**
 * Created by Michał on 03.03.2016.
 */
public class Car extends Vehicle {

    public Car() {

    }

    public Car(String brand, String model, int idWorkShop, int idRental, int pricePerDay) {

        this.idVehicle = id + 1;
        this.brand = brand;
        this.model = model;
        this.idWorkShop = idWorkShop;
        this.idRental = idRental;
        this.pricePerDay = pricePerDay;
        this.itRent = false;

        faultsList = new ArrayList<Fault>();
        inspectionsList = new ArrayList<Inspection>();


    }


    @Override
    public String toString() {
        return null;
    }
}
