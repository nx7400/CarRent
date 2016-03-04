/**
 * Created by Michał on 03.03.2016.
 */
public class Car extends Vehicle {

    public Car(){

    }

    public Car(String brand, String model, int idWorkShop, int idRental, int pricePerDay){

        this.idVehicle = id+1;
        this.brand = brand;
        this.model = model;
        this.idWorkShop = idWorkShop;
        this.idRental = idRental;
        this.pricePerDay = pricePerDay;
        this.itRent = false;

    }

    @Override
    public void show() {

    }

    @Override
    public void addVehicleFault() {
// tutaj bedzie dodawanie usterki do listy (czy ta funkcja nie powinna byc w Vehicle ?)
    }

    @Override
    public void addVehicleInspection() {
// tutaj bedzie dodawanie przegladu do listy (czy ta funkcja nie powinna byc w Vehicle ?)
    }
}
