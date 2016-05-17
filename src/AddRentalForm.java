import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał on 18.03.2016.
 */
public class AddRentalForm extends JFrame implements ActionListener{
    private JPanel panel1;
    private JTextField textFieldCity;
    private JTextField textFieldaddress;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    private JFrame statusDialogWindow;

    public AddRentalForm(){

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

            Rental R = new Rental(city,address);

            DataBase B = new DataBase();

            if(B.insertRental(R)){
                JOptionPane.showMessageDialog(statusDialogWindow,"Udane dodanie warsztatu do bazy danych");

            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy dodawaniu warsztatu do bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if(source == buttonCancel){
            dispose();
        }

    }
}
