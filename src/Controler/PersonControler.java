package Controler;

import Model.*;

import java.util.List;

/**
 * Created by Michał on 17.05.2016.
 */
public class PersonControler {

    DataBase B = new DataBase();

    public PersonControler() {
    }

    public boolean addCustomerToDataBase(Customer C){

        return B.insertCustomer(C);
    }

    public List<Customer> getCustomersFromDataBase(){

        return B.selectCustomer();

    }

    public Customer getCustomerById(int idSelected){

        Customer searchCustomer = null;
        List<Customer> customerList;
        customerList = B.selectCustomer();

        for(Customer C: customerList){
            if(C.getIdCustomer()==idSelected)
                searchCustomer = C;
        }

        return searchCustomer;
    }

    public boolean addDealerToDataBase(Dealer D){

        return B.insertDealer(D);
    }

    public List<Employee> getDealersFromDataBase(){

        return B.selectDealer();
    }



}
