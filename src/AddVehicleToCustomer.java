import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

    public AddVehicleToCustomer(Customer C) {
        super("Dodaj pojazd do klienta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        DataBase B = new DataBase();

        comboBoxVehicle.addActionListener(this);
        comboBoxCustomer.addActionListener(this);
        buttonAdd.addActionListener(this);
        cancelButton.addActionListener(this);

        List<Customer> customerList;
        customerList = B.selectCustomer();

        List<Vehicle> vehicleList;
        vehicleList = B.selectVehicle();

        addCustomersToComboBox(customerList);
        addVehicleToComboBox(vehicleList);


    }

    private void addCustomersToComboBox(List<Customer> customersList ){

        for(Customer C : customersList)
            comboBoxCustomer.addItem(C.toString());

    }

    private void addVehicleToComboBox(List<Vehicle> vehiclesList ){

        for(Vehicle V : vehiclesList)
            comboBoxVehicle.addItem(V.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonAdd){

        }

    }
}
