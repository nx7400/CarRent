import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public AddMechanicForm(){

        super("Dodaj Klienta");
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

        if (source == buttonConfirm) {

            String name = textFieldName.getText();
            String lastName = textFieldLastName.getText();
            String address = textFieldAdress.getText();
            String email = textFieldEmail.getText();
            String pesel = textFieldPesel.getText();
            String phoneNumber = textFieldPhoneNumber.getText();

            Mechanic M1 = new Mechanic(name, lastName, address, email, pesel, phoneNumber, 1); // dodac wybieranie warsztatu
        }

        if(source ==  buttonCancel){
            dispose();

        }
    }


}
