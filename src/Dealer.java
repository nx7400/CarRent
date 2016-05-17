/**
 * Created by Michał on 03.03.2016.
 */
public class Dealer extends Employee {

    private int idRental;

    public Dealer(){

    }

    public Dealer(int idRental, String password, String name, String lastName, String address, String email, String pesel, String phoneNumber){

        DataBase B = new DataBase();
        counter++;
        this.idEmployee = B.getNumberofDealers() + 1; // czy takie ustawianie id jest potrzebne ??? skoro i tak bede pobierac liste pracownikow z bazy danych ?
        this.login = createLogin(name, lastName,idEmployee);
        this.password = hashPassword(password);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.setIdRental(idRental);
    }

    public Dealer(int id, String login, String password, String name, String lastName, String address, String email, String pesel, String phoneNumber, int idRental){

        counter++;
        this.idEmployee = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.setIdRental(idRental);
    }

    public String toString(){
        String result = "Id: " + this.idEmployee + " login:" + this.login + ", " + this.name + ", " + this.lastName;
        return result;
    }

    public int getIdRental() {
        return idRental;
    }

    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }
}
