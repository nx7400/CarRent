/**
 * Created by Michał on 03.03.2016.
 */
public class Mechanic extends Employee {

    private int idWorkShop;

    public Mechanic(){

    }

    public Mechanic(int idWorkShop, String password, String name, String lastName, String address, String email, String pesel, String phoneNumber){

        DataBase B = new DataBase();
        counter++;
        this.idEmployee = B.getNumberofMechanics() + 1;
        this.login = createLogin(name, lastName,idEmployee);
        this.password = hashPassword(password);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.idWorkShop = idWorkShop;
    }
    public Mechanic(int id, String login, String password, String name, String lastName, String address, String email, String pesel, String phoneNumber, int idWorkShop){

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
        this.idWorkShop = idWorkShop;
    }

    public int getIdWorkShop() {
        return idWorkShop;
    }

    public void setIdWorkShop(int idWorkShop) {
        this.idWorkShop = idWorkShop;
    }
}
