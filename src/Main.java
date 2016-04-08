/**
 * Created by Michał on 09.03.2016.
 */

import org.mindrot.jbcrypt.BCrypt;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            System.err.println();
        }

        DataBase B = new DataBase();
        B.insertAdmin(new Admin(1,"rent","michal","koko","sadasdsa","misia","sdsaad","dsadsn"));

        Customer C = new Customer("Grazyna","Waleczna","Krakow Urzednicza 2","grazyna94@gmail.com","94110912121","987456098");

        if(B.insertCustomer(C)){
            System.out.println("Udane wlozenie klienta");
        } else{
            System.out.println("Blad przy wkladaniu klienta");
        }


        List<Admin> adminList = B.selectAdmin();

        LoginForm L = new LoginForm();
        L.loginAndPasswordTest(adminList);



    }
}
