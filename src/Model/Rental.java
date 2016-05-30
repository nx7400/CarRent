package Model;

/**
 * Created by Michał on 03.03.2016.
 */
public class Rental extends Building {

    public Rental(){

    }

    public Rental(String city, String address){

        DataBase B = new DataBase();
        counter++;
        this.idBuilding = B.getNumberofRentals() + 1;
        this.city = city;
        this.address = address;
    }

    public Rental(int idBuilding, String city, String address){

        counter++;
        this.idBuilding = idBuilding;
        this.city = city;
        this.address = address;

    }

    public String toString(){

        String result = "Id: " + this.idBuilding + ", " + this.city + ", " + this.address;
        return result;
    }

}
