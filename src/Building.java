/**
 * Created by Michał on 03.03.2016.
 */
import java.util.List;

public abstract class Building {

    public static int id=0;
    protected int idBuilding;
    protected String city;
    protected String address;
    protected List<Vehicle> vehiclesList;

    public void addVehicle(Vehicle N){
        //dodawanie pojazdu do listy zarówno w wypozyczalni jak i warsztacie (czy to powinny byc osobne funkcje ?)
    }


    public int getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(int idBuilding) {
        this.idBuilding = idBuilding;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
