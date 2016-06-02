package Controler;

import Model.Customer;
import Model.DataBase;
import Model.Invoice;
import Model.Vehicle;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Michał on 20.05.2016.
 */
public class InvoiceControler {

    DataBase B = new DataBase();

    public InvoiceControler(){

    }



    public List<Invoice> getInvoiceFromDataBase(){

        return B.selectInvoice();

    }

    public Invoice getInvoiceById(int idSelected){

        Invoice searchInvoice = null;
        List<Invoice> invoiceList;
        invoiceList = B.selectInvoice();

        for(Invoice In: invoiceList){
            if(In.getIdInvoice()==idSelected)
                searchInvoice = In;
        }

        return searchInvoice;
    }

    public boolean removeInvoiceFromDataBase(int IdInvoiceToRemove){

        return (B.removeInvoice(IdInvoiceToRemove) && B.removeInvoice_Vehicle(IdInvoiceToRemove));
    }

    public void getInvoice_Vehicle(Invoice In){
        B.selectInvoice_Vehicle(In);
    }

    public int addVehicleAndCusomerToNewInvoice(Vehicle V, Customer C, int rentTime){

        Invoice In =  new Invoice(C.getIdCustomer());
        In.addCarToInvoice(V,rentTime);
        B.updateVehicleWhereId(V);

        addInvoiceToDataBase(In);

        return In.getIdInvoice();
    }

    public void addVehicleAndCusomerToExistingInvoice(Invoice In, Vehicle V, int rentTime){

        In.addCarToInvoice(V,rentTime);
        B.updateVehicleWhereId(V);

        addInvoiceToDataBase(In);

    }

    public void addInvoiceToDataBase(Invoice In){

        if(In.isAddToDataBase()){

        } else {
            B.insertInvoice(In);
            In.setAddToDataBase(true);
        }

        Set rentTimeOfVehicleSet = In.getRentTimeOfVehicleMap().entrySet();

        Iterator i = rentTimeOfVehicleSet.iterator();


        while(i.hasNext()){

            Map.Entry temp = (Map.Entry)i.next();

            B.insertInvoiceVehicle(In,(Vehicle)temp.getKey(), (Integer)temp.getValue());
        }

    }

}
