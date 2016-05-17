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

///////////////////////////////INSERT_BLOCK///////////////////////////////////////////////////////////////////////

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
            PreparedStatement prepStat = conn.prepareStatement("INSERT INTO Vehicle VALUES (NULL,?,?,?,?,?,?,?)");
            prepStat.setString(1,V.brand);
            prepStat.setString(2,V.model);
            prepStat.setInt(3,V.idWorkShop);
            prepStat.setInt(4,V.idRental);
            prepStat.setDouble(5,V.pricePerDay);
            prepStat.setInt(6,V.itRent);
            if(V instanceof Car){
                prepStat.setString(7,"Samochod");
            } else{
                prepStat.setString(7,"Motocykl");
            }
            System.out.println("Wstawiono pojazd");
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

//////////////////////////////SELECT_BLOCK////////////////////////////////////////////////////////////////////////////

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


    public List<Customer> selectCustomer(){

        List<Customer> customerList = new LinkedList<Customer>();

        try{
            ResultSet result = stat.executeQuery("SELECT * FROM Customer");
            int idCustomer;
            String name, lastName, address, email, pesel, phonenumber;
            while(result.next()){
                idCustomer = result.getInt("IDCustomer");
                name = result.getString("Name");
                lastName = result.getString("LastName");
                address = result.getString("Address");
                email = result.getString("Email");
                pesel = result.getString("Pesel");
                phonenumber = result.getString("PhoneNumber");
                customerList.add(new Customer(idCustomer, name, lastName, address, email, pesel, phonenumber));

            }
        } catch (SQLException e){
            System.err.println("Blad przy wczytawaniu Klientow");
            e.printStackTrace();
            return null;

        }

        System.out.println("Poprawne wczatanie klientow");
        return customerList;
    }

    public List<Rental> selectRental(){

        List<Rental> rentalList = new LinkedList<Rental>();

        try{
            ResultSet result = stat.executeQuery("SELECT * FROM Rental");
            int idBuilding;
            String city, address;
            while(result.next()){
                idBuilding = result.getInt("IDRental");
                city = result.getString("City");
                address = result.getString("Address");

                rentalList.add(new Rental(idBuilding, city, address));

            }
        } catch (SQLException e){
            System.err.println("Blad przy wczytawaniu wypozyczalni");
            e.printStackTrace();
            return null;

        }

        System.out.println("Poprawne wczatanie wypozyczalni");
        return rentalList;
    }

    public List<WorkShop> selectWorkShop(){

        List<WorkShop> workShopList = new LinkedList<WorkShop>();

        try{
            ResultSet result = stat.executeQuery("SELECT * FROM WorkShop");
            int idBuilding;
            String city, address;
            while(result.next()){
                idBuilding = result.getInt("IDWorkShop");
                city = result.getString("City");
                address = result.getString("Address");

                workShopList.add(new WorkShop(idBuilding, city, address));

            }
        } catch (SQLException e){
            System.err.println("Blad przy wczytawaniu wypozyczalni");
            e.printStackTrace();
            return null;

        }

        System.out.println("Poprawne wczatanie wypozyczalni");
        return workShopList;
    }

    public List<Vehicle> selectVehicle(){

        List<Vehicle> vehicleList = new LinkedList<Vehicle>();

        try{
            ResultSet result = stat.executeQuery("SELECT * FROM Vehicle");
            int idVehicle, idWorkShop, idRental, itRent;
            double pricePerDay;
            String brand, model, type;
            while(result.next()){
                idVehicle = result.getInt("IDVehicle");
                idRental = result.getInt("IDRental");
                idWorkShop = result.getInt("IDWorkShop");
                itRent = result.getInt("ItRent");
                pricePerDay = result.getDouble("PricePerDay");
                brand = result.getString("Brand");
                model = result.getString("Model");
                type = result.getString("Type");
                if(type.equals("Car"))
                    vehicleList.add(new Car(idVehicle, brand, model, idWorkShop, idRental, pricePerDay, itRent));
                if(type.equals("MotorBike"))
                    vehicleList.add(new MotorBike(idVehicle, brand, model, idWorkShop, idRental, pricePerDay, itRent));

            }
        } catch (SQLException e){
            System.err.println("Blad przy wczytawaniu Klientow");
            e.printStackTrace();
            return null;

        }

        System.out.println("Poprawne wczatanie klientow");
        return vehicleList;
    }

///////////////////////NUMBER_OF_BLOCK/////////////////////////////////////////////////////////////////////////////////

    public int getNumberofCustomers(){
        int numberOfCustomers = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDCustomer, COUNT(IDCustomer) AS NumberOfCustomers FROM Customer");

            while(result.next()){ // te wszystkie while to wywalenia ! po co ja je wogole tu wstawilem ?!
                numberOfCustomers = result.getInt("NumberOfCustomers");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby klientow");
            e.printStackTrace();
        }

        return numberOfCustomers;

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

    public int getNumberofRentals(){
        int numberOfRentals = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDRental, COUNT(IDRental) AS NumberOfRentals FROM Rental");

            while(result.next()){
                numberOfRentals = result.getInt("NumberOfRentals");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby wypozyczalni");
            e.printStackTrace();
        }

        return numberOfRentals;

    }

    public int getNumberofWorsShops(){
        int numberOfWorkShops = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDWorkShop, COUNT(IDWorkShop) AS NumberOfWorkShops FROM WorkShop");

            while(result.next()){
                numberOfWorkShops = result.getInt("NumberOfWorkShops");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby warszatow");
            e.printStackTrace();
        }

        return numberOfWorkShops;

    }

    public int getNumberofVehicles(){
        int numberOfVehicles = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDVehicle, COUNT(IDVehicle) AS NumberOfVehicles FROM Vehicle");

            while(result.next()){
                numberOfVehicles = result.getInt("NumberOfVehicles");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby pojazdow");
            e.printStackTrace();
        }

        return numberOfVehicles;

    }

    public int getNumberofInvoice(){
        int numberOfInvoice = 0;

        try{
            ResultSet result = stat.executeQuery("SELECT IDInvoice, COUNT(IDInvoice) AS NumberOfInvoice FROM Invoice");

            while(result.next()){
                numberOfInvoice = result.getInt("NumberOfVehicles");
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu liczby pojazdow");
            e.printStackTrace();
        }

        return numberOfInvoice;

    }

    public boolean removeDealer(int id){

        try{
            PreparedStatement prepStat = conn.prepareStatement("DELETE FROM Dealer WHERE IDDealer = ?");
            prepStat.setInt(1,id);
            prepStat.execute();

        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu usterki");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean removeMechanic(int id){

        try{
            PreparedStatement prepStat = conn.prepareStatement("DELETE FROM Mechanic WHERE IDMechanic = ?");
            prepStat.setInt(1,id);
            prepStat.execute();

        } catch (SQLException e){
            System.err.println("Blad przy wstawianiu usterki");
            e.printStackTrace();
            return false;
        }

        return true;
    }



}
