/**
 * Created by Michał on 03.03.2016.
 */
public class Inspection {

    public static int id = 0;
    private int idInspection;
    private int idVehicle;
    private String description;
    // boolean wazny lub nie ???

    public Inspection(){

    }

    public Inspection(int idVehicle, String description){

        id++;
        this.idInspection = id;
        this.idVehicle = idVehicle;
        this.description = description;
    }

    public int getIdInspection() {
        return idInspection;
    }

    public void setIdInspection(int idInspection) {
        this.idInspection = idInspection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
