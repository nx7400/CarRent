/**
 * Created by Michał on 03.03.2016.
 */
public class WorkShop extends Building{

    public WorkShop(){

    }

    public WorkShop(String city, String address){

        id++;
        this.idBuilding = id;
        this.city = city;
        this.address = address;
    }
}
