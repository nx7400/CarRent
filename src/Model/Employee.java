package Model;

import org.mindrot.jbcrypt.BCrypt;

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

    public void createLogin(){

        this.login = this.name.substring(0,3)+this.lastName.substring(0,3)+this.idEmployee;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
