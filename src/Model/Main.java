package Model;

/**
 * Created by Michał on 09.03.2016.
 */

import View.LoginForm;
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

        DataBase B = new DataBase();
        B.insertInvoice(new Invoice(1,2)); // TODO why insertInvoie and insertInvoiceVehicle don't work properly??
        B.insertInvoiceVehicle(new Invoice(1, 2), new Car("Ford", "Fiesta", 1, 1, 200));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            System.err.println();
        }

        LoginForm L = new LoginForm();



    }
}
