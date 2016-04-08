import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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

    public void closeConnection(){
        try{
            conn.close();
        } catch (SQLException e){
            System.err.println("Problem z zamkieciem polaczenia");
            e.printStackTrace();
        }
    }


    public boolean insertCustomer(Customer C){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Customer VALUES (NULL,?,?,?,?,?,?)");
            prepStat.setString(1,C.name);
            prepStat.setString(2,C.lastName);
            prepStat.setString(3,C.address);
            prepStat.setString(4,C.email);
            prepStat.setString(5,C.pesel);
            prepStat.setString(6,C.phoneNumber);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu klienta");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertAdmin(Admin A){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Admin VALUES (NULL,?,?,?,?,?,?,?,?)");
            prepStat.setString(1,A.login);
            prepStat.setString(2,A.password);
            prepStat.setString(3,A.name);
            prepStat.setString(4,A.lastName);
            prepStat.setString(5,A.address);
            prepStat.setString(6,A.email);
            prepStat.setString(7,A.pesel);
            prepStat.setString(8,A.phoneNumber);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu admina");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertDealer(Dealer D){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Dealer VALUES (NULL,?,?,?,?,?,?,?,?,?)");
            prepStat.setString(1,D.login);
            prepStat.setString(2,D.password);
            prepStat.setString(3,D.name);
            prepStat.setString(4,D.lastName);
            prepStat.setString(5,D.address);
            prepStat.setString(6,D.email);
            prepStat.setString(7,D.pesel);
            prepStat.setString(8,D.phoneNumber);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu sprzedawcy");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertMechanic(Mechanic M){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Mechanic VALUES (NULL,?,?,?,?,?,?,?,?,?)");
            prepStat.setString(1,M.login);
            prepStat.setString(2,M.password);
            prepStat.setString(3,M.name);
            prepStat.setString(4,M.lastName);
            prepStat.setString(5,M.address);
            prepStat.setString(6,M.email);
            prepStat.setString(7,M.pesel);
            prepStat.setString(8,M.phoneNumber);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu mechanika");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertWorkShop(WorkShop W){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO WorkShop VALUES (NULL,?,?)");
            prepStat.setString(1,W.city);
            prepStat.setString(2,W.address);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu warsztatu");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertRental(Rental R){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Rental VALUES (NULL,?,?)");
            prepStat.setString(1,R.city);
            prepStat.setString(2,R.address);
            prepStat.execute();
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu wypozyczalni");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertVehicle(Vehicle V){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Vehicle VALUES (NULL,?,?,?,?,?,?)");
            prepStat.setString(1,V.brand);
            prepStat.setString(2,V.model);
            prepStat.setInt(3,V.idWorkShop);
            prepStat.setInt(4,V.idRental);
            prepStat.setDouble(5,V.pricePerDay);
            prepStat.setInt(6,V.itRent);
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu pojazdu");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertFault(Fault F){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Fault VALUES (NULL,?,?,?)");
            prepStat.setInt(1,F.getIdVehicle());
            prepStat.setString(2,F.getDescription());
            prepStat.setDouble(3,F.getCost());
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu usterki");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertInspection(Inspection I){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Inspection VALUES (NULL,?,?)");
            prepStat.setInt(1,I.getIdVehicle());
            prepStat.setString(2,I.getDescription());
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu przegladu");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertInvoice(Invoice In){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Invoice VALUES (NULL,?,?)");
            prepStat.setInt(1,In.getIdCustomer());
            prepStat.setInt(2,In.getRentTime());
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu faktury");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertInvoiceVehicle(Invoice In, Vehicle V){

        try{
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Invoice_Vehicle VALUES (?,?)");
            prepStat.setInt(1,In.getIdInvoice());
            prepStat.setInt(2,V.getIdVehicle());
        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu faktura - pojazd");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Admin> selectAdmin(){

        List<Admin> adminList = new LinkedList<Admin>();

        try{
            ResultSet result = stat.executeQuery("SELECT * FROM Admin");
            int idAdmin;
            String login, password, name, lastName, address, email, pesel, phonenumber;
            while(result.next()){
                idAdmin = result.getInt("IDAdmin");
                login = result.getString("Login");
                password = result.getString("Password");
                name = result.getString("Name");
                lastName = result.getString("LastName");
                address = result.getString("Address");
                email = result.getString("Email");
                pesel = result.getString("Pesel");
                phonenumber = result.getString("PhoneNumber");
                adminList.add(new Admin(idAdmin,login,password,name,lastName,address,email,pesel,phonenumber));

            }
        } catch (SQLException e){
            System.err.println("Blad przy wczytawaniu Adminow");
            e.printStackTrace();
            return null;

        }

        System.out.println("Poprawne wczatanie adminow");
        return adminList;
    }

    public int getNumberofDealer(){
        int numberOfDealer = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDDealer, COUNT(IDDealer) AS NumberOfDealer FROM Dealer");

            while(result.next()){
                numberOfDealer = result.getInt("NumberOfDealer");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby sprzedawcow");
            e.printStackTrace();
        }

        return numberOfDealer;

    }


}
