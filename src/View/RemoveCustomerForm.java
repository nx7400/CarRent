package View;

import Controler.PersonControler;
import Model.Customer;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 02.06.2016.
 */
public class RemoveCustomerForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JComboBox comboBoxRemoveCustomer;
    private JButton buttonRemove;
    private JButton buttonCancel;
    private JFrame statusDialogWindow;

    private int IdCustomerToRemove = -1;


    PersonControler pc = new PersonControler();

    public RemoveCustomerForm(){

        super("Usun klienta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addDealersToComboBox(pc.getCustomersFromDataBase());

        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRemoveCustomer.addActionListener(this);


    }

    private void addDealersToComboBox(List<Customer> customerList ){

        for(Customer C : customerList)
            comboBoxRemoveCustomer.addItem(C.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonRemove){


            if(IdCustomerToRemove != -1) {

                if (pc.removeCustomerFromDataBase(IdCustomerToRemove)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane usuniecie klienta z bazy danych");

                } else {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy usuwaniu klienta z bazy danych (Sprawdź czy wszystkie faktury z wybranym klientem zostały usuniete)", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Nie wybrano klienta do usniecia", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveCustomer){
            IdCustomerToRemove = comboBoxRemoveCustomer.getSelectedIndex() + 1;
        }

    }
}
