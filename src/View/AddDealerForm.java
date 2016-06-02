package View;

import Controler.BuildingControler;
import Controler.PersonControler;
import Model.Building;
import Model.DataBase;
import Model.Dealer;
import Model.Rental;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michał on 11.03.2016.
 */
public class AddDealerForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textFieldName;
    private JTextField textFieldLastName;
    private JTextField textFieldAdress;
    private JTextField textFieldEmail;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldPesel;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    private JPasswordField passwordField;
    private JComboBox comboBoxRental;
    private JFrame statusDialogWindow;
    private JFrame wrongIdDialogWindow;

    private int idRentalSelected = -1;

    BuildingControler bc = new BuildingControler();


    public AddDealerForm() {

        super("Dodaj Sprzedawce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640, 480);
        setLocation(50, 50);
        setContentPane(panel1);

        addRentalsToComboBox(bc.getRentalFromDataBase());

        buttonConfirm.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRental.addActionListener(this);


    }

    private void addRentalsToComboBox(List<Rental> rentalList){

        for(Rental R : rentalList)
            comboBoxRental.addItem(R.toString());

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == buttonConfirm) {

            String name = textFieldName.getText();
            String lastName = textFieldLastName.getText();
            String password = passwordField.getText();
            String address = textFieldAdress.getText();
            String email = textFieldEmail.getText();
            String pesel = textFieldPesel.getText();
            String phoneNumber = textFieldPhoneNumber.getText();

            Dealer D1 = new Dealer();

            Pattern nameAndLastNamePattern = Pattern.compile("[A-Z]([a-z])+");
            Matcher nameMatcher  = nameAndLastNamePattern.matcher(name);
            Matcher lastNameMatcher = nameAndLastNamePattern.matcher(lastName);

            if(nameMatcher.matches() && lastNameMatcher.matches()){
                D1.setName(name);
                D1.setLastName(lastName);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Imie i nazwisko może zawierać tylko litery !!!","Błędne imie lub nazwisko", JOptionPane.ERROR_MESSAGE);
            }

            Pattern addressPattern = Pattern.compile("[A-Z]([a-z])+\\s[A-Z]([a-z])+\\s([1-9])+");
            Matcher addressMatcher = addressPattern.matcher(address);

            if(addressMatcher.matches()){
                D1.setAddress(address);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny adres !!! Prawidłowa forma: miasto ulica nr","Błędny adres", JOptionPane.ERROR_MESSAGE);

            }

            Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher emailMatcher = emailPattern.matcher(email);

            if(emailMatcher.matches()){
                D1.setEmail(email);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny adres email !!!","Błędny adres email", JOptionPane.ERROR_MESSAGE);

            }

            Pattern peselPattern = Pattern.compile("[0-9]{11}");
            Matcher peselMatcher = peselPattern.matcher(pesel);

            if(peselMatcher.matches()){
                D1.setPesel(pesel);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny pesel !!! Nr pesel musi skłądać się z 11 cyfr","Błędny pesel", JOptionPane.ERROR_MESSAGE);
            }

            Pattern phoneNumberPattern = Pattern.compile("\\+[0-9]{2}[0-9]{9}");
            Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);

            if(phoneNumberMatcher.matches()){
                D1.setPhoneNumber(phoneNumber);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny numer telefonu  !!! Nr telefonu musi składać się z numeru kierunkowego oraz 9 cyfr włąściwego numeru telfonu","Błędny numer telefonu", JOptionPane.ERROR_MESSAGE);

            }



            if(idRentalSelected == -1){
                JOptionPane.showMessageDialog(wrongIdDialogWindow, "Nie wybrano id wypozyczlani !!!", "Error", JOptionPane.ERROR_MESSAGE); // alternatywnie prztpisywac domyslnie id == 1
            } else {
                D1.setIdRental(idRentalSelected);
            }

            D1.setPassword(password);
            D1.createLogin();

            if(nameMatcher.matches() && lastNameMatcher.matches() && addressMatcher.matches() && emailMatcher.matches() && peselMatcher.matches() && phoneNumberMatcher.matches() ){

                PersonControler pc = new PersonControler();

                if(pc.addDealerToDataBase(D1)){

                    JOptionPane.showMessageDialog(statusDialogWindow,"Udane dodanie sprzedawcy do bazy danych");

                } else {
                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy dodawaniu sprzedawcy do bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }


        }

        if (source == comboBoxRental){
            idRentalSelected = comboBoxRental.getSelectedIndex() + 1;

        }

        if (source == buttonCancel){
            dispose();
        }

    }

}