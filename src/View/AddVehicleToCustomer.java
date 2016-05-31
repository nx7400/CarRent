package View;


import Controler.InvoiceControler;
import Controler.PersonControler;
import Controler.VehicleControler;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michał on 18.03.2016.
 */
public class AddVehicleToCustomer extends JFrame implements ActionListener {
    private JComboBox comboBoxVehicle;
    private JPanel panel1;
    private JComboBox comboBoxCustomer;
    private JTextField textFieldNumberOfDays;
    private JButton buttonAdd;
    private JButton cancelButton;
    private JFrame statusDialogWindow;
    private JFrame dialogWindow;

    private int idCustomerSelected = -1;
    private int idVehicleSelected = -1;

    PersonControler pc = new PersonControler();
    VehicleControler vc = new VehicleControler();

    public AddVehicleToCustomer(Customer C) {
        super("Dodaj pojazd do klienta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        comboBoxVehicle.addActionListener(this);
        comboBoxCustomer.addActionListener(this);
        buttonAdd.addActionListener(this);
        cancelButton.addActionListener(this);

        addCustomersToComboBox(pc.getCustomersFromDataBase());
        addVehicleToComboBox(vc.getVehiclesFromDataBase());


    }

    private void addCustomersToComboBox(List<Customer> customersList ){

        for(Customer C : customersList)
            comboBoxCustomer.addItem(C.toString());

    }

    private void addVehicleToComboBox(List<Vehicle> vehiclesList ){

        for(Vehicle V : vehiclesList)
        if(V.getItRent()==0)
            comboBoxVehicle.addItem(V.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonAdd){

            InvoiceControler ic = new InvoiceControler();
            String rentTime = textFieldNumberOfDays.getText();
            Pattern rentTimePattern = Pattern.compile("[1-9][0-9]*");
            Matcher rentTimeMatcher = rentTimePattern.matcher(rentTime);

            if(rentTimeMatcher.matches()){
                Integer numberOfDays = Integer.parseInt(rentTime);
                ic.addVehicleAndCusomerToInvoice(vc.getVehicleById(idVehicleSelected), pc.getCustomerById(idCustomerSelected), numberOfDays);


            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędna wartość dni wypożyczenia !!! Podaj liczbe dni ","Błędna wartość", JOptionPane.ERROR_MESSAGE);

            }


        }

        if(source == cancelButton){
            dispose();
        }

        if(source == comboBoxCustomer){

            idCustomerSelected = comboBoxCustomer.getSelectedIndex() + 1;
        }

        if(source == comboBoxVehicle){

            idVehicleSelected = comboBoxVehicle.getSelectedIndex() + 1;
        }

    }
}
