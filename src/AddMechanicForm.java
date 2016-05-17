import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

    public AddMechanicForm(){

        super("Dodaj Klienta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        DataBase B = new DataBase();
        List<WorkShop> workShopsList;
        workShopsList = B.selectWorkShop();

        addWorkShopsToComboBox(workShopsList);

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

            int idWorkShop = 1;

            if(idWorkShopSelected == -1){
                JOptionPane.showMessageDialog(wrongIdDialogWindow, "Nie wybrano id wypozyczlani !!!", "Error", JOptionPane.ERROR_MESSAGE); // alternatywnie prztpisywac domyslnie id == 1
            } else {
                idWorkShop = idWorkShopSelected;
            }

            Mechanic M = new Mechanic(1, password, name, lastName, address, email, pesel, phoneNumber); //dodac wybor wypozyczlani
            DataBase B = new DataBase();

            if(B.insertMechanic(M)){
                JOptionPane.showMessageDialog(statusDialogWindow,"Udane dodanie mechanika do bazy danych");

            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy dodawaniu mechanika do bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
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
