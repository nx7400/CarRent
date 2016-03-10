/**
 * Created by Michał on 03.03.2016.
 */

import java.util.ArrayList;
import java.util.List;

public class Customer extends Preson {

    public static int id=0;
    private int idCustomer;
    private ArrayList<Invoice> invoicesList;

    public Customer(){

    }

    public Customer(String name, String lastName, String address, String email, String pesel, String phoneNumber){

        this.idCustomer = id+1;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;

    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
