/**
 * Created by Michał on 03.03.2016.
 */
public class Rental extends Building {

    public Rental(){

    }

    public Rental(String city, String address){

        id++;
        this.idBuilding = id;
        this.city = city;
        this.address =address;
    }

}
