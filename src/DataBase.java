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
            prepStat.setInt(1,D.getIdRental());
            prepStat.setString(2,D.login);
            prepStat.setString(3,D.password);
            prepStat.setString(4,D.name);
            prepStat.setString(5,D.lastName);
            prepStat.setString(6,D.address);
            prepStat.setString(7,D.email);
            prepStat.setString(8,D.pesel);
            prepStat.setString(9,D.phoneNumber);
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
            prepStat.setInt(1,M.getIdWorkShop());
            prepStat.setString(2,M.login);
            prepStat.setString(3,M.password);
            prepStat.setString(4,M.name);
            prepStat.setString(5,M.lastName);
            prepStat.setString(6,M.address);
            prepStat.setString(7,M.email);
            prepStat.setString(8,M.pesel);
            prepStat.setString(9,M.phoneNumber);
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

    public List<Employee> selectAdmin(){

        List<Employee> adminList = new LinkedList<Employee>();

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
                adminList.add(new Admin(idAdmin, login, password, name, lastName, address, email, pesel, phonenumber));

            }
        } catch (SQLException e){
            System.err.println("Blad przy wczytawaniu Adminow");
            e.printStackTrace();
            return null;

        }

        System.out.println("Poprawne wczatanie adminow");
        return adminList;
    }

    public List<Employee> selectMechanic(){

        List<Employee> mechanicList = new LinkedList<Employee>();

        try{
            ResultSet result = stat.executeQuery("SELECT * FROM Mechanic");
            int idMechanic, idWorkShop;
            String login, password, name, lastName, address, email, pesel, phonenumber;
            while(result.next()){
                idMechanic = result.getInt("IDMechanic");
                idWorkShop = result.getInt("IDWorkShop");
                login = result.getString("Login");
                password = result.getString("Password");
                name = result.getString("Name");
                lastName = result.getString("LastName");
                address = result.getString("Address");
                email = result.getString("Email");
                pesel = result.getString("Pesel");
                phonenumber = result.getString("PhoneNumber");
                mechanicList.add(new Mechanic(idMechanic, login, password, name, lastName, address, email, pesel, phonenumber, idWorkShop));

            }
        } catch (SQLException e){
            System.err.println("Blad przy wczytawaniu Adminow");
            e.printStackTrace();
            return null;

        }

        System.out.println("Poprawne wczatanie mechanikow");
        return mechanicList;
    }

    public List<Employee> selectDealer(){

        List<Employee> dealerList = new LinkedList<Employee>();

        try{
            ResultSet result = stat.executeQuery("SELECT * FROM Dealer");
            int idAdmin, idRental;
            String login, password, name, lastName, address, email, pesel, phonenumber;
            while(result.next()){
                idAdmin = result.getInt("IDDealer");
                idRental = result.getInt("IDRental");
                login = result.getString("Login");
                password = result.getString("Password");
                name = result.getString("Name");
                lastName = result.getString("LastName");
                address = result.getString("Address");
                email = result.getString("Email");
                pesel = result.getString("Pesel");
                phonenumber = result.getString("PhoneNumber");
                dealerList.add(new Dealer(idAdmin, login, password, name, lastName, address, email, pesel, phonenumber, idRental));

            }
        } catch (SQLException e){
            System.err.println("Blad przy wczytawaniu Adminow");
            e.printStackTrace();
            return null;

        }

        System.out.println("Poprawne wczatanie adminow");
        return dealerList;
    }


    public int getNumberofDealers(){
        int numberOfDealers = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDDealer, COUNT(IDDealer) AS NumberOfDealers FROM Dealer");

            while(result.next()){
                numberOfDealers = result.getInt("NumberOfDealers");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby sprzedawcow");
            e.printStackTrace();
        }

        return numberOfDealers;

    }

    public int getNumberofAdmins(){
        int numberOfAdmins = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDAdmin, COUNT(IDAdmin) AS NumberOfAdmins FROM Admin");

            while(result.next()){
                numberOfAdmins = result.getInt("NumberOfAdmins");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby adminow");
            e.printStackTrace();
        }

        return numberOfAdmins;

    }

    public int getNumberofMechanics(){
        int numberOfMechanics = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDMechanic, COUNT(IDMechanic) AS NumberOfMechanics FROM Mechanic");

            while(result.next()){
                numberOfMechanics = result.getInt("NumberOfMechanics");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby mechanikow");
            e.printStackTrace();
        }

        return numberOfMechanics;

    }


}
