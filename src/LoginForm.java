import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Michał on 10.03.2016.
 */
public class LoginForm extends JFrame{
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton buttonSignIn;
    private JPasswordField passwordField1;
    private JPanel logoPanel;
    private JFrame dialogWinodow;


    public LoginForm(){
        super("Zaloguj się");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(mainPanel);
        logoPanel = new LogoPanel();
        add(logoPanel);
        //pack();




    }

    public void loginAndPasswordTest(Employee testedEmployee){

        buttonSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getLogin = textField1.getText();
                String getPass = passwordField1.getText();

                if(BCrypt.checkpw(getPass,testedEmployee.password) && getLogin.equals(testedEmployee.login)){
                    System.out.println("test pass good");
                    JOptionPane.showMessageDialog(dialogWinodow,"Udane logowanie");
                    MenuForm menu = new MenuForm();
                    dispose();

                }
                else {
                    System.out.println("test pass wrong");
                    JOptionPane.showMessageDialog(dialogWinodow,"Logowanie nie powiodlo sie sprobuj ponownie");

                }


            }
        });

    }



}
