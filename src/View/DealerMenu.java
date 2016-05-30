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
    private JButton buttonPrintInvoice;
    private JPanel panel1;

    public DealerMenu(){

        super("Menu Sprzedawcy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);

        setContentPane(panel1);

        buttonAddCustomer.addActionListener(this);
        buttonAddVehicleToCustomer.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonAddCustomer){
            AddCustomerForm addCustomer = new AddCustomerForm();
            dispose();
        }

        if(source == buttonAddVehicleToCustomer){
            Customer C = new Customer();
            AddVehicleToCustomer addVehicleToCustomer = new AddVehicleToCustomer(C);
        }

    }
}
