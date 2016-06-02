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
    public boolean removeCustomerFromDataBase(int IdCustomerToRemove){

        for(Invoice In: B.selectInvoice()){
            if(In.getIdCustomer()==IdCustomerToRemove)
                return false;
        }

        return B.removeCustomer(IdCustomerToRemove);
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

    public boolean removeDealerFromDataBase(int IdDealerToRemove){

        return B.removeDealer(IdDealerToRemove);
    }

    public boolean addMechanicToDataBase(Mechanic M){
        return B.insertMechanic(M);
    }

    public List<Employee> getMechanicFromDataBase(){
        return B.selectMechanic();
    }

    public boolean removeMechanicFromDataBase(int IdMechanicToRemove){

        return B.removeMechanic(IdMechanicToRemove);
    }

    public boolean addAdminToDataBase(Admin A){

        return B.insertAdmin(A);
    }

    public List<Employee> getAdminFromDataBase(){

        return B.selectAdmin();

    }

    public boolean removeAdminFromDataBase(int idAdminToRemove){

        if(idAdminToRemove == 1) return false;

        return B.removeCustomer(idAdminToRemove);
    }



}
