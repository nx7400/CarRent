/**
 * Created by Michał on 03.03.2016.
 */
import java.lang.String;

public abstract class Vehicle {

    int idVehicle;
    int idWorkShop;
    int idRental;
    String brand;
    String model;
    boolean itRent;
    Fault A;
    Inspection B;

    public abstract void show();
    public abstract void addVehicleFault();
    public abstract void addVehicleInspection();




}
