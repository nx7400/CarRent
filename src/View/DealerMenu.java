package View;

import Model.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał on 17.03.2016.
 */
public class DealerMenu extends JFrame implements ActionListener {
    private JButton buttonAddCustomer;
    private JButton buttonAddVehicleToCustomer;
    private JButton buttonAddVehicleToExsistingInvoice;
    private JPanel panel1;
    private JButton buttonShowInvoice;
    private JTabbedPane tabbedPane1;
    private JButton buttonShowCustomers;
    private JButton buttonShowDealers;
    private JButton buttonShowMechanics;
    private JButton buttonShowRentals;
    private JButton buttonShowWorkShops;
    private JButton buttonShowVehicle;

    public DealerMenu(){

        super("Menu Sprzedawcy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);

        setContentPane(panel1);

        buttonAddCustomer.addActionListener(this);
        buttonAddVehicleToCustomer.addActionListener(this);
        buttonAddVehicleToExsistingInvoice.addActionListener(this);
        buttonShowInvoice.addActionListener(this);

        buttonShowCustomers.addActionListener(this);
        buttonShowDealers.addActionListener(this);
        buttonShowMechanics.addActionListener(this);
        buttonShowRentals.addActionListener(this);
        buttonShowWorkShops.addActionListener(this);
        buttonShowVehicle.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonAddCustomer){
            AddCustomerForm addCustomer = new AddCustomerForm();
            dispose();
        }

        if(source == buttonAddVehicleToCustomer){
            AddVehicleToCustomer addVehicleToCustomer = new AddVehicleToCustomer();
        }

        if(source == buttonAddVehicleToExsistingInvoice){

            AddCarToExsitingInvoice addCarToExsitingInvoice = new AddCarToExsitingInvoice();
        }

        if(source == buttonShowInvoice){
            ShowInvoiceForm showInvoice = new ShowInvoiceForm();
        }

        if(source == buttonShowCustomers){
            ShowCustomersForm showCustomers = new ShowCustomersForm();
        }

        if(source == buttonShowDealers){
            ShowDealersForm showDealers = new ShowDealersForm();
        }

        if(source == buttonShowMechanics){
            ShowMechanicsForm showMechanics = new ShowMechanicsForm();
        }

        if(source == buttonShowRentals){
            ShowRentalsForm showRentals = new ShowRentalsForm();
        }

        if(source == buttonShowWorkShops){
            ShowWorkShopsForm showWorkShops = new ShowWorkShopsForm();
        }

        if(source == buttonShowVehicle){
            ShowVehicleForm showVehicle = new ShowVehicleForm();
        }


    }
}
