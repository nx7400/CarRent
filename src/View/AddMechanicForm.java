package View;

import Controler.BuildingControler;
import Controler.PersonControler;
import Model.Mechanic;
import Model.WorkShop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michał on 11.03.2016.
 */
public class AddMechanicForm extends JFrame implements ActionListener {
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
    private JComboBox comboBoxWrokShop;
    private JFrame statusDialogWindow;
    private JFrame wrongIdDialogWindow;

    private int idWorkShopSelected = -1;

    BuildingControler bc = new BuildingControler();

    public AddMechanicForm(){

        super("Dodaj Klienta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addWorkShopsToComboBox(bc.getWorkShopFromDataBase());

        buttonConfirm.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxWrokShop.addActionListener(this);

    }

    private void addWorkShopsToComboBox(List<WorkShop> workShopList){

        for(WorkShop W : workShopList)
            comboBoxWrokShop.addItem(W.toString());

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

            Mechanic M1 = new Mechanic();


            Pattern nameAndLastNamePattern = Pattern.compile("[A-Z]([a-z])+");
            Matcher nameMatcher  = nameAndLastNamePattern.matcher(name);
            Matcher lastNameMatcher = nameAndLastNamePattern.matcher(lastName);

            if(nameMatcher.matches() && lastNameMatcher.matches()){
                M1.setName(name);
                M1.setLastName(lastName);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Imie i nazwisko może zawierać tylko litery !!!","Błędne imie lub nazwisko", JOptionPane.ERROR_MESSAGE);
            }

            Pattern addressPattern = Pattern.compile("[A-Z]([a-z])+\\s[A-Z]([a-z])+\\s([1-9])+");
            Matcher addressMatcher = addressPattern.matcher(address);

            if(addressMatcher.matches()){
                M1.setAddress(address);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny adres !!! Prawidłowa forma: miasto ulica nr","Błędny adres", JOptionPane.ERROR_MESSAGE);

            }

            Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher emailMatcher = emailPattern.matcher(email);

            if(emailMatcher.matches()){
                M1.setEmail(email);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny adres email !!!","Błędny adres email", JOptionPane.ERROR_MESSAGE);

            }

            Pattern peselPattern = Pattern.compile("[0-9]{11}");
            Matcher peselMatcher = peselPattern.matcher(pesel);

            if(peselMatcher.matches()){
                M1.setPesel(pesel);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny pesel !!! Nr pesel musi skłądać się z 11 cyfr","Błędny pesel", JOptionPane.ERROR_MESSAGE);
            }

            Pattern phoneNumberPattern = Pattern.compile("\\+[0-9]{2}[0-9]{9}");
            Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);

            if(phoneNumberMatcher.matches()){
                M1.setPhoneNumber(phoneNumber);
            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędny numer telefonu  !!! Nr telefonu musi składać się z numeru kierunkowego oraz 9 cyfr włąściwego numeru telfonu","Błędny numer telefonu", JOptionPane.ERROR_MESSAGE);

            }


            if(idWorkShopSelected == -1){
                JOptionPane.showMessageDialog(wrongIdDialogWindow, "Nie wybrano id wypozyczlani !!!", "Error", JOptionPane.ERROR_MESSAGE); // alternatywnie prztpisywac domyslnie id == 1
            } else {

                M1.setIdWorkShop(idWorkShopSelected);
            }

            M1.setPassword(password);
            M1.createLogin();

            if(nameMatcher.matches() && lastNameMatcher.matches() && addressMatcher.matches() && emailMatcher.matches() && peselMatcher.matches() && phoneNumberMatcher.matches() ){

                PersonControler pc = new PersonControler();

                if(pc.addMechanicToDataBase(M1)){

                    JOptionPane.showMessageDialog(statusDialogWindow,"Udane dodanie sprzedawcy do bazy danych");

                } else {
                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy dodawaniu sprzedawcy do bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

        if(source == comboBoxWrokShop) {

            idWorkShopSelected = comboBoxWrokShop.getSelectedIndex() + 1;
        }

        if(source ==  buttonCancel) {

            dispose();

        }
    }


}
