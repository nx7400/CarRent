import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

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


    public AddDealerForm() {

        super("Dodaj Klienta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640, 480);
        setLocation(50, 50);
        setContentPane(panel1);


        DataBase B = new DataBase();
        List<Rental> rentalsList;
        rentalsList = B.selectRental();
        addRentalsToComboBox(rentalsList);

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

            int idRental = 1;

            if(idRentalSelected == -1){
                JOptionPane.showMessageDialog(wrongIdDialogWindow, "Nie wybrano id wypozyczlani !!!", "Error", JOptionPane.ERROR_MESSAGE); // alternatywnie prztpisywac domyslnie id == 1
            } else {
                idRental = idRentalSelected;
            }

            Dealer D = new Dealer(idRental, password, name, lastName, address, email, pesel, phoneNumber);

            DataBase B = new DataBase();

            if(B.insertDealer(D)){
                JOptionPane.showMessageDialog(statusDialogWindow,"Udane dodanie sprzedawcy do bazy danych");

            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy dodawaniu sprzedawcy do bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
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