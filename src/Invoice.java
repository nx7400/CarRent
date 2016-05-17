/**
 * Created by Michał on 03.03.2016.
 */
import java.util.List;

public class Invoice {

    public static int counter = 0;
    private int idInvoice;
    private int idCustomer;
    private int rentTime;
    private int totalCost;
    private List<Vehicle> rentVehiclesList;

    public Invoice() {

    }

    public Invoice(int idCustomer, int rentTime){

        DataBase B = new DataBase();

        counter++;
        this.idInvoice = B.getNumberofInvoice();
        this.idCustomer = idCustomer;
        this.rentTime = rentTime; // in days
        //dodawanie samochodu do listy.

    }


    public void coutTotalCost(){

    }


    public void addCarToInvoice(){ //dodawanie samochodu do istniejacej faktury.

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

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
