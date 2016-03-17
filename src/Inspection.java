/**
 * Created by Michał on 03.03.2016.
 */
public class Inspection {

    private int idInspection;
    private String description;
    // boolean wazny lub nie ???

    public Inspection(){

    }

    public Inspection(int idInspection, String description){

        this.idInspection = idInspection;
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
