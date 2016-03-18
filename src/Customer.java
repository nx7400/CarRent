/**
 * Created by Michał on 03.03.2016.
 */

import java.util.ArrayList;

public class Customer extends Person {

    public static int id=0;
    private int idCustomer;
    private ArrayList<Invoice> invoicesList;

    public Customer(){

    }

    public Customer(String name, String lastName, String address, String email, String pesel, String phoneNumber){

        id++;
        this.idCustomer = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        // tworzenie listy faktur

    }

    public void addInvoiceToCustomer(){
        //dodawanie kolejnej faktur do listy faktur klienta
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
