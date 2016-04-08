import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Michał on 03.03.2016.
 */
public abstract class Employee extends Person {

    public static int counter = 0;
    protected int idEmployee;
    protected String login;
    protected String password;

    protected static String createLogin(String name, String lastName, int idEmployee){
        String login1 = name.substring(0,3);
        String login2 = lastName.substring(0,3);

        return login1+login2+idEmployee;
    }

    protected static String hashPassword(String password){

        String hashed = BCrypt.hashpw(password,BCrypt.gensalt());
        return hashed;
    }


    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
}
