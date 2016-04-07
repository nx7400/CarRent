/**
 * Created by Michał on 09.03.2016.
 */

import org.mindrot.jbcrypt.BCrypt;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        Admin admin1 = new Admin("Michal","Paszkowski","Krakow","michaszek17@op.pl","94092313775","+4809292932");
        Employee testedEmployee = admin1;

        DataBase B = new DataBase();

        if(B.insertCustomer("Grazyna","Waleczna","Krakow Urzednicza 2","grazyna94@gmail.com","94110912121","987456098")){
            System.out.println("Udane wlozenie klienta");
        } else{
            System.out.println("Blad przy wkladaniu klienta");
        }


        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e){
            System.err.println();
        }

        LoginForm L = new LoginForm();
        L.loginAndPasswordTest(testedEmployee);



    }
}
