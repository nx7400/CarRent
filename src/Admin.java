/**
 * Created by Michał on 03.03.2016.
 */
import java.util.Scanner;

public class Admin extends Employee {

    public Admin(){

    }

    public Admin(String name, String lastName, String address, String email, int pesel, String phoneNumber){

        this.idEmployee = id+1;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
    }

    void addVehicle(){

        Scanner in = new Scanner(System.in);
        System.out.println("Tworzenie nowego samochodu");

        //odebranie informacji od administratora
        //wybranie warszatu
        //wybranie wypozyczalni
        //podanie danych

    }

    void addDealer(){

        //towrzenie nowego pracownika
    }

    void addWorkShop(){

        Scanner in = new Scanner(System.in);
        System.out.println("Dodawanie nowego warsztatu");
        System.out.println("Podaj miasto");
        String city = in.nextLine();
        System.out.println("Poadaj adres");
        String address = in.nextLine();

        WorkShop A = new WorkShop(city,address);

    }
}
