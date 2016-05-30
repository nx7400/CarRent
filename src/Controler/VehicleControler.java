package Controler;


import Model.DataBase;
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

        List<Vehicle> vehicleList;
        return vehicleList = B.selectVehicle();
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
