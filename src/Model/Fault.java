package Model; /**
 * Created by Michał on 03.03.2016.
 */

import java.lang.String;

public class Fault {

    public static int id = 0;
    private int idFault;
    private int idVehicle;
    private String description;
    private int cost;
    // bolean naprawiona lub nie ???

    public Fault(){

    }

    public Fault(int idVehicle, String description, int cost){

        id++;
        this.idFault = id;
        this.setIdVehicle(idVehicle);
        this.description = description;
        this.cost = cost;

    }

    public int getIdFault() {
        return idFault;
    }

    public void setIdFault(int idFault) {
        this.idFault = idFault;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }
}
