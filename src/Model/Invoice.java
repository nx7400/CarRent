package Model; /**
 * Created by Michał on 03.03.2016.
 */
import Controler.PersonControler;

import java.util.*;

public class Invoice {

    public static int counter = 0;
    private int idInvoice;
    private int idCustomer;
    private int totalCost;
    private boolean addToDataBase;

    private HashMap<Vehicle,Integer> rentTimeOfVehicleMap = new HashMap<>();



    public Invoice() {

    }

    public Invoice(int idCustomer){

        DataBase B = new DataBase();

        counter++;
        this.idInvoice = B.getNumberofInvoice() + 1;
        this.idCustomer = idCustomer;
        this.addToDataBase = false;


    }

    public Invoice(int idInvoice, int idCustomer, boolean addToDataBase){

        counter++;
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.addToDataBase = addToDataBase;

    }


    public double coutTotalCost(){

        Set rentTimeOfVehicleSet = this.getRentTimeOfVehicleMap().entrySet();
        Iterator i = rentTimeOfVehicleSet.iterator();

        double totalCost = 0.0;

        while(i.hasNext()){

            Map.Entry temp = (Map.Entry)i.next();

            Vehicle V = (Vehicle)temp.getKey();
            Integer rentTime = (Integer)temp.getValue();

            totalCost += V.getPricePerDay()*rentTime;
        }

        return totalCost;
    }


    public void addCarToInvoice(Vehicle V, Integer rentTime){

        this.rentTimeOfVehicleMap.put(V, rentTime);

    }

    @Override
    public String toString() {

        PersonControler pc = new PersonControler();

        return "Id FV: " + this.idInvoice + " na nazwisko: "+pc.getCustomerById(this.idCustomer).getLastName();
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }


    public HashMap<Vehicle, Integer> getRentTimeOfVehicleMap() {
        return rentTimeOfVehicleMap;
    }

    public void setRentTimeOfVehicleMap(HashMap<Vehicle, Integer> rentTimeOfVehicleMap) {
        this.rentTimeOfVehicleMap = rentTimeOfVehicleMap;
    }

    public boolean isAddToDataBase() {
        return addToDataBase;
    }

    public void setAddToDataBase(boolean addToDataBase) {
        this.addToDataBase = addToDataBase;
    }
}
