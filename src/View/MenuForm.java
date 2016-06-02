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
    private JButton buttonShowCustomers;
    private JButton buttonShowDealers;
    private JButton buttonShowMechanics;
    private JButton buttonShowRentals;
    private JButton buttonShowWorkShops;
    private JButton buttonShowVehicle;
    private JButton buttonAddAdmin;
    private JButton buttonShowAdmins;
    private JButton buttonRemoveInvoice;
    private JButton buttonRemoveAdmin;
    private JButton buttonShowVehicles;


    public MenuForm(){

        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);

        setContentPane(panel1);

        buttonAddAdmin.addActionListener(this);
        buttonAddCustomer.addActionListener(this);
        buttonAddDealer.addActionListener(this);
        buttonAddMechanic.addActionListener(this);
        buttonAddWorkShop.addActionListener(this);
        buttonAddRental.addActionListener(this);
        buttonAddVehicle.addActionListener(this);

        buttonRemoveCustomer.addActionListener(this);
        buttonRemoveDealer.addActionListener(this);
        buttonRemoveMechanic.addActionListener(this);
        buttonRemoveVehicle.addActionListener(this);
        buttonRemoveWorkShop.addActionListener(this);
        buttonRemoveRental.addActionListener(this);
        buttonRemoveInvoice.addActionListener(this);
        buttonRemoveAdmin.addActionListener(this);

        buttonShowAdmins.addActionListener(this);
        buttonShowCustomers.addActionListener(this);
        buttonShowDealers.addActionListener(this);
        buttonShowMechanics.addActionListener(this);
        buttonShowRentals.addActionListener(this);
        buttonShowWorkShops.addActionListener(this);
        buttonShowVehicle.addActionListener(this);

        buttonChangeToDealer.addActionListener(this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == buttonAddAdmin){
            AddAdminForm addAdmin = new AddAdminForm();
        }

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

        if(source == buttonRemoveCustomer){
            RemoveCustomerForm removeCustomer = new RemoveCustomerForm();
        }

        if(source == buttonRemoveDealer){
            RemoveDealerForm2 removeDealer = new RemoveDealerForm2();
        }

        if(source == buttonRemoveMechanic){
            RemoveMechnicFrom2 removeMechnic = new RemoveMechnicFrom2();
        }

        if(source == buttonRemoveVehicle){

            RemoveVehicleForm removeVehicle = new RemoveVehicleForm();
        }

        if (source == buttonRemoveWorkShop){

            RemoveWrokShopForm removeWrokShop = new RemoveWrokShopForm();
        }

        if(source == buttonRemoveRental){
            RemoveRentalForm removeRental = new RemoveRentalForm();
        }

        if(source == buttonRemoveInvoice){

            RemoveInvoiceForm removeInvoice = new RemoveInvoiceForm();
        }

        if(source == buttonRemoveAdmin){

            RemoveAdminForm removeAdmie = new RemoveAdminForm();
        }

        if(source == buttonChangeToDealer){

            DealerMenu dealerMenu = new DealerMenu();
        }

        if(source == buttonShowAdmins){
            ShowAdminsForm showAdmins = new ShowAdminsForm();
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
