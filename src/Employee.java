import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Michał on 03.03.2016.
 */
public abstract class Employee extends Preson {

    protected int idEmployee;
    protected String login;
    protected String password;

    void loadLoginAndPassword(){

        File pw = new File("pw.txt");
        try {
            Scanner read = new Scanner(pw);
            this.login = read.nextLine();
            this.password = read.nextLine();

        }
        catch (FileNotFoundException e){
            System.out.println("Nie znaleziono pliku");
        }


    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
}
