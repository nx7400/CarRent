package Model; /**
 * Created by Michał on 03.03.2016.
 */

import java.util.ArrayList;

public class Customer extends Person {

    public static int counter=0;
    private int idCustomer;
    private ArrayList<Invoice> invoicesList;

    public Customer(){

        DataBase B = new DataBase();
        counter++;
        this.idCustomer = B.getNumberofCustomers() + 1;

    }

    public Customer(String name, String lastName, String address, String email, String pesel, String phoneNumber){

        DataBase B = new DataBase();
        counter++;
        this.idCustomer = B.getNumberofCustomers() + 1;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        // tworzenie listy faktur

    }

    public Customer(int id, String name, String lastName, String address, String email, String pesel, String phoneNumber){

        counter++;
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

    public String toString(){
        String result = "Id: " + this.idCustomer + ", " + this.name + ", " + this.lastName + ", " + this. address + ", " + this.pesel;
        return result;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
