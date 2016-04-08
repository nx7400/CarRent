/**
 * Created by Michał on 03.03.2016.
 */
public class Dealer extends Employee {

    private int idRental;

    public Dealer(){

    }

    public Dealer(int id, String password, String name, String lastName, String address, String email, String pesel, String phoneNumber, int idRental){

        counter++;
        this.idEmployee = id;
        this.login = createLogin(name, lastName);
        this.password = hashPassword(password);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.setIdRental(idRental);
    }

    public int getIdRental() {
        return idRental;
    }

    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }
}
