package View;

import Controler.BuildingControler;
import Model.DataBase;
import Model.WorkShop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michał on 11.03.2016.
 */
public class AddWorkShopForm extends JFrame implements ActionListener {
    private JTextField textFieldCity;
    private JTextField textFieldaddress;
    private JPanel panel1;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    private JFrame statusDialogWindow;

    public AddWorkShopForm(){
        super("Dodaj Warsztat");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        buttonConfirm.addActionListener(this);
        buttonCancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonConfirm){

            String city = textFieldCity.getText();
            String address = textFieldaddress.getText();

            WorkShop W = new WorkShop();


            Pattern cityPattern = Pattern.compile("[A-Z]([a-z])+");
            Matcher cityMatcher = cityPattern.matcher(city);

            if(cityMatcher.matches()){

                W.setCity(city);
            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Błędna nazwa miasta !!! Prawidłowa nazwa miasta zaczyna sie z dużej litery i zawiera tylko litery","Błędny adres", JOptionPane.ERROR_MESSAGE);
            }

            Pattern addressPattern = Pattern.compile("[A-Z]([a-z])+\\s([1-9])+");
            Matcher addressMatcher = addressPattern.matcher(address);

            if(addressMatcher.matches()){
                W.setAddress(address);
            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny adres !!! Prawidłowa forma: Ulica nr","Błędny adres", JOptionPane.ERROR_MESSAGE);
            }

            if(cityMatcher.matches() && addressMatcher.matches()){

                BuildingControler bc = new BuildingControler();

                if(bc.addWorkShopToDataBase(W)){
                    JOptionPane.showMessageDialog(statusDialogWindow,"Udane dodanie warsztatu do bazy danych");

                } else {
                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy dodawaniu warsztatu do bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

        if(source == buttonCancel){
            dispose();
        }

    }
}
