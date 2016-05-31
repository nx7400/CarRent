package Controler;


import Model.DataBase;
import Model.Rental;
import Model.WorkShop;

import java.util.List;

/**
 * Created by Michał on 17.05.2016.
 */
public class BuildingControler {

    DataBase B = new DataBase();

    public BuildingControler(){

    }

    public boolean addWorkShopToDataBase(WorkShop W){

        return B.insertWorkShop(W);
    }

    public List<WorkShop> getWorkShopFromDataBase(){

        return B.selectWorkShop();

    }

    public boolean removeWorkShopFormDataBase(int IdWorkShopToRemove){

        return B.removeWorkShop(IdWorkShopToRemove);
    }

    public boolean addRentalToDataBase(Rental R){

        return B.insertRental(R);
    }

    public List<Rental> getRentalFromDataBase(){

        return B.selectRental();
    }

    public boolean removeRentalFromDataBase(int IdRentalToRemove){

        return B.removeRental(IdRentalToRemove);
    }
}

