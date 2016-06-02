package Controler;


import Model.Car;
import Model.DataBase;
import Model.Invoice;
import Model.Vehicle;

import java.util.List;

/**
 * Created by Michał on 17.05.2016.
 */
public class VehicleControler {

    DataBase B = new DataBase();

    public VehicleControler(){

    }

    public boolean addVehicleToDataBase(Vehicle V){

        return B.insertVehicle(V);
    }

    public List<Vehicle> getVehiclesFromDataBase(){

       return B.selectVehicle();
    }

    public boolean removeVehicleFromDataBase(int IdVehicleToRemove){

        for(Integer I: B.checkInvoice_Vehicle()){
            if(I==IdVehicleToRemove)
                return false;
        }

        return B.removeVehicle(IdVehicleToRemove);
    }

    public Vehicle getVehicleById(int idSelected){

        Vehicle searchVehicle = null;
        List<Vehicle> vehicleList;
        vehicleList = B.selectVehicle();

        for(Vehicle V: vehicleList){
            if(V.getIdVehicle()==idSelected)
                searchVehicle = V;
        }

        return searchVehicle;
    }


}
