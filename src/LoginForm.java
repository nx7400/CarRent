import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Michał on 10.03.2016.
 */
public class LoginForm extends JFrame {
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton buttonSignIn;
    private JPasswordField passwordField1;
    private JPanel logoPanel;
    private JRadioButton adminRadioButton;
    private JRadioButton dealerRadioButton;
    private JRadioButton mechanicRadioButton;
    private JFrame testLoginAndPasswordDialogWinodow;
    private boolean loginAndPasswordState;




    public LoginForm() {
        super("Zaloguj się");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(640, 480);
        setLocation(50, 50);
        setContentPane(mainPanel);

        DataBase B = new DataBase();

        //adminRadioButton.setMnemonic(KeyEvent.VK_C);

        ButtonGroup group = new ButtonGroup();
        group.add(adminRadioButton);
        group.add(dealerRadioButton);
        group.add(mechanicRadioButton);


        adminRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Employee> adminList = B.selectAdmin();
                loginAndPasswordTest(adminList);


            }
        });

        dealerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Employee> dealerList = B.selectDealer();
                loginAndPasswordTest(dealerList);


            }
        });


        mechanicRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Employee> mechanicList = B.selectMechanic();
                loginAndPasswordTest(mechanicList);




            }
        });


//        logoPanel = new LogoPanel();
//        add(logoPanel);
//        //pack();

    }


    public void loginAndPasswordTest(List<Employee> employeesList) {


        buttonSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getLogin = textField1.getText();
                String getPass = passwordField1.getText();



                for (Employee A : employeesList) {

                    if (A.login.equals(getLogin)) {

                        if (BCrypt.checkpw(getPass, A.password)) {
                            System.out.println("test pass good");
                            JOptionPane.showMessageDialog(testLoginAndPasswordDialogWinodow, "Udane logowanie");

                            if(A instanceof Admin){
                                MenuForm menu = new MenuForm();
                            }

                            if(A instanceof Dealer){
                                DealerMenu menu = new DealerMenu();
                            }

                            if(A instanceof Mechanic){
                                MechanicMenu menu = new MechanicMenu();
                            }
                            dispose();


                        } else {

                            System.out.println("test pass wrong");
                            //JOptionPane.showMessageDialog(testLoginAndPasswordDialogWinodow, "Logowanie nie powiodlo sie sprobuj ponownie");
                        }

                    }
                }

                //JOptionPane.showMessageDialog(testLoginAndPasswordDialogWinodow, "Logowanie nie powiodlo sie sprobuj ponownie");

            }

        });

    }
}