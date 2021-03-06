package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał on 09.03.2016.
 */
public class MenuForm extends JFrame implements ActionListener{
    private JPanel panel1;
    private JButton buttonAddCustomer;
    private JButton buttonAddDealer;
    private JButton buttonAddMechanic;
    private JPanel panel2;
    private JLabel menuLabel;
    private JTabbedPane tabbedPaneAdd;
    private JButton buttonAddWorkShop;
    private JButton buttonRemoveCustomer;
    private JButton buttonRemoveDealer;
    private JButton buttonRemoveMechanic;
    private JButton buttonRemoveWorkShop;
    private JButton buttonAddVehicle;
    private JButton buttonAddRental;
    private JButton buttonRemoveRental;
    private JButton buttonRemoveVehicle;
    private JButton buttonChangeToDealer;
    private JButton buttonChangeToMechanic;
    private JButton buttonShowCustomers;
    private JButton buttonShowDealers;
    private JButton buttonShowMechanics;
    private JButton buttonShowRentals;
    private JButton buttonShowWorkShops;
    private JButton buttonShowVehicles;


    public MenuForm(){

        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);

        setContentPane(panel1);

        buttonAddCustomer.addActionListener(this);
        buttonAddDealer.addActionListener(this);
        buttonAddMechanic.addActionListener(this);
        buttonAddWorkShop.addActionListener(this);
        buttonAddRental.addActionListener(this);
        buttonAddVehicle.addActionListener(this);

        buttonRemoveDealer.addActionListener(this);
        buttonRemoveMechanic.addActionListener(this);

        buttonShowCustomers.addActionListener(this);
        buttonShowDealers.addActionListener(this);
        buttonShowMechanics.addActionListener(this);
        buttonShowRentals.addActionListener(this);
        buttonShowWorkShops.addActionListener(this);

        buttonChangeToDealer.addActionListener(this);
        buttonChangeToMechanic.addActionListener(this);





    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == buttonAddCustomer) {
            AddCustomerForm addCustomer = new AddCustomerForm();
        }

        if(source == buttonAddDealer) {
            AddDealerForm addDealer = new AddDealerForm();
        }

        if(source == buttonAddMechanic) {
            AddMechanicForm addMechanic = new AddMechanicForm();
        }

        if(source == buttonAddWorkShop) {
            AddWorkShopForm addWorkShop = new AddWorkShopForm();
        }

        if(source == buttonAddRental) {
            AddRentalForm addRental = new AddRentalForm();
        }

        if(source == buttonAddVehicle) {
            AddVehicleForm addVehicle = new AddVehicleForm();
        }

        if(source == buttonRemoveDealer){
            RemoveDealerForm2 removeDealer = new RemoveDealerForm2();
        }

        if(source == buttonRemoveMechanic){
            RemoveMechnicFrom2 removeMechnic = new RemoveMechnicFrom2();
        }

        if(source == buttonChangeToDealer){

            DealerMenu dealerMenu = new DealerMenu();
        }

        if(source == buttonChangeToMechanic){
            MechanicMenu mechanicMenu = new MechanicMenu();
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


    }
}
