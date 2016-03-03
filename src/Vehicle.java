/**
 * Created by Michał on 03.03.2016.
 */
import java.lang.String;

public abstract class Vehicle {

    protected int idVehicle;
    protected int idWorkShop;
    protected int idRental;
    protected String brand;
    protected String model;
    protected int pricePerDay;
    protected boolean itRent;
    protected Fault A; // to bedzie lista
    protected Inspection B; // to bedzie lista

    public abstract void show();
    public abstract void addVehicleFault();
    public abstract void addVehicleInspection();


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

    public boolean isItRent() {
        return itRent;
    }

    public void setItRent(boolean itRent) {
        this.itRent = itRent;
    }

    public Fault getA() {
        return A;
    }

    public void setA(Fault a) {
        A = a;
    }

    public Inspection getB() {
        return B;
    }

    public void setB(Inspection b) {
        B = b;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
