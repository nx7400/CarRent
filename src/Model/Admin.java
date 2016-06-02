package Model;

/**
 * Created by Michał on 03.03.2016.
 */


public class Admin extends Employee {

    public Admin(){

    }

    public Admin(int id, String password, String name, String lastName, String address, String email, String pesel, String phoneNumber){

        DataBase B = new DataBase();
        Employee.counter++;
        this.idEmployee = B.getNumberofAdmins() + 1;
        this.login = Employee.createLogin(name, lastName,idEmployee);
        this.password = Employee.hashPassword(password);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
    }

    public Admin(int id, String login, String password, String name, String lastName, String address, String email, String pesel, String phoneNumber){

        Employee.counter++;
        this.idEmployee = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        String result = "Id: " + this.idEmployee + " login: " + this.login + ", " + this.name + ", " + this.lastName;
        return result;
    }


}
