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

        LoginForm L = new LoginForm();



    }
}
