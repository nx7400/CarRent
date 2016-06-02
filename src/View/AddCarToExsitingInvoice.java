package View;

import Controler.InvoiceControler;
import Controler.VehicleControler;
import Model.Invoice;
import Model.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michał on 02.06.2016.
 */
public class AddCarToExsitingInvoice extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton cancelButton;
    private JComboBox comboBoxInvoice;
    private JTextField textFieldNumberOfDays;
    private JComboBox comboBoxVehicle;
    private JButton buttonAdd;
    private JFrame statusDialogWindow;
    private JFrame dialogWindow;
    private JFrame wrongIdDialogWindow;

    private int idInvoiceSelected = -1;
    private int idVehicleSelected = -1;

    InvoiceControler ic = new InvoiceControler();
    VehicleControler vc = new VehicleControler();

    public AddCarToExsitingInvoice() {
        super("Dodaj pojazd do faktury");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        comboBoxVehicle.addActionListener(this);
        comboBoxInvoice.addActionListener(this);
        buttonAdd.addActionListener(this);
        cancelButton.addActionListener(this);

        addInvoiceToComboBox(ic.getInvoiceFromDataBase());
        addVehicleToComboBox(vc.getVehiclesFromDataBase());


    }

    private void addInvoiceToComboBox(List<Invoice> invoiceList ){

        for(Invoice In : invoiceList)
            comboBoxInvoice.addItem(In.toString());

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
                ic.addVehicleAndCusomerToExistingInvoice(ic.getInvoiceById(idInvoiceSelected), vc.getVehicleById(idVehicleSelected), numberOfDays);

                JOptionPane.showMessageDialog(statusDialogWindow,"Udane dodanie samochodu do faktury");

            } else {
                JOptionPane.showMessageDialog(statusDialogWindow, "Błędna wartość dni wypożyczenia !!! Podaj liczbe dni ","Błędna wartość", JOptionPane.ERROR_MESSAGE);

            }



        }

        if(source == cancelButton){
            dispose();
        }

        if(source == comboBoxInvoice){

            idInvoiceSelected = comboBoxInvoice.getSelectedIndex() + 1;
        }

        if(source == comboBoxVehicle){

            idVehicleSelected = comboBoxVehicle.getSelectedIndex() + 1;
        }

    }


}

