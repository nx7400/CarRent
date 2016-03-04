/**
 * Created by Michał on 03.03.2016.
 */
public class Mechanic extends Employee {

    private int idWorkShop;

    public Mechanic(){

    }

    public Mechanic(String name, String lastName, String address, String email, int pesel, String phoneNumber, int idWorkShop){

        this.idEmployee = id+1;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.idWorkShop = idWorkShop;
    }

    public int getIdWorkShop() {
        return idWorkShop;
    }

    public void setIdWorkShop(int idWorkShop) {
        this.idWorkShop = idWorkShop;
    }
}
