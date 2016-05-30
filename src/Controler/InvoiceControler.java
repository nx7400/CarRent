package Controler;

import Model.Customer;
import Model.DataBase;
import Model.Invoice;
import Model.Vehicle;

import java.util.List;

/**
 * Created by Michał on 20.05.2016.
 */
public class InvoiceControler {

    DataBase B = new DataBase();

    public InvoiceControler(){

    }

    public void addVehicleAndCusomerToInvoice(Vehicle V, Customer C, int rentTime){

        Invoice In =  new Invoice(C.getIdCustomer(),rentTime);
        In.addCarToInvoice(V);

        addInvoiceToDataBase(In);
    }

    public void addInvoiceToDataBase(Invoice In){

        if(In.isAddToDataBase()){

        } else {
            B.insertInvoice(In);
            In.setAddToDataBase(true);
        }

        for(Vehicle V : In.getRentVehiclesList() ){
            B.insertInvoiceVehicle(In,V);
        }

    }

}
