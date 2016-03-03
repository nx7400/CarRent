/**
 * Created by Michał on 03.03.2016.
 */

import java.lang.String;

public class Fault {

    int idFault;
    String description;
    int cost;

    public Fault(){

    }

    public Fault(int idFault, String description, int cost){

        this.idFault = idFault;
        this.description = description;
        this.cost = cost;

    }

}
