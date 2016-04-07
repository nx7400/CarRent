import java.sql.*;
import org.sqlite.JDBC;

/**
 * Created by Michał on 07.04.2016.
 */
public class DataBase {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:C:/Users/Michał/Desktop/DataBase/CarRent.db";

    private Connection conn;
    private Statement stat;

    public DataBase(){

        try {
            Class.forName(DataBase.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Blad sterownika JDBC");
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e){
            System.err.println("Blad przy otwieraniu polaczenia");
            e.printStackTrace();
        }

    }

    private String createLogin(String name, String lastName){
        String login1 = name.substring(0,2);
        String login2 = lastName.substring(0,2);

        return login1+login2;
    }

    public boolean insertCustomer(String name, String lastName, String address, String email, String pesel, String phoneNumber ){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Customer VALUES (NULL,?,?,?,?,?,?)");
            prepStat.setString(1,name);
            prepStat.setString(2,lastName);
            prepStat.setString(3,address);
            prepStat.setString(4,email);
            prepStat.setString(5,pesel);
            prepStat.setString(6,phoneNumber);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu klienta");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertAdmin(String password, String name, String lastName, String address, String email, String pesel, String phoneNumber ){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Admin VALUES (NULL,?,?,?,?,?,?,?,?)");
            prepStat.setString(1,createLogin(name,lastName));
            prepStat.setString(2,password);
            prepStat.setString(3,name);
            prepStat.setString(4,lastName);
            prepStat.setString(5,address);
            prepStat.setString(6,email);
            prepStat.setString(7,pesel);
            prepStat.setString(8,phoneNumber);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu admina");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertDealer(String password, String name, String lastName, String address, String email, String pesel, String phoneNumber ){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Dealer VALUES (NULL,?,?,?,?,?,?,?,?,?)");
            prepStat.setString(1,createLogin(name,lastName));
            prepStat.setString(2,password);
            prepStat.setString(3,name);
            prepStat.setString(4,lastName);
            prepStat.setString(5,address);
            prepStat.setString(6,email);
            prepStat.setString(7,pesel);
            prepStat.setString(8,phoneNumber);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu sprzedawcy");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertMechanic(String password, String name, String lastName, String address, String email, String pesel, String phoneNumber ){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Mechanic VALUES (NULL,?,?,?,?,?,?,?,?,?)");
            prepStat.setString(1,createLogin(name,lastName));
            prepStat.setString(2,password);
            prepStat.setString(3,name);
            prepStat.setString(4,lastName);
            prepStat.setString(5,address);
            prepStat.setString(6,email);
            prepStat.setString(7,pesel);
            prepStat.setString(8,phoneNumber);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu mechanika");
            e.printStackTrace();
            return false;
        }

        return true;
    }


}
