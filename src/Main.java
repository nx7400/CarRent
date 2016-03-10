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

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        Admin admin1 = new Admin("Michal","Paszkowski","Krakow","michaszek17@op.pl","94092313775","+4809292932");
        Employee testedEmployee = admin1;

        LoginForm L = new LoginForm();
        L.loginAndPasswordTest(testedEmployee);









    }
}
