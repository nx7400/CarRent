package View;

import Model.DataBase;
import Model.Employee;
import Model.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 31.05.2016.
 */
public class RemoveVehicleForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JComboBox comboBoxRemoveVehicle;
    private JButton buttonRemove;
    private JButton buttonCancel;

    private int removeVehicleId;

    public RemoveVehicleForm(){

        super("Usun pojazd");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        DataBase B = new DataBase();

        List<Vehicle> vehicleList = B.selectVehicle();

        addVehicleToComboBox(vehicleList);

        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRemoveVehicle.addActionListener(this);




    }

    private void addVehicleToComboBox(List<Vehicle> vehicleList ){

        for(Vehicle V : vehicleList)
            comboBoxRemoveVehicle.addItem(V.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonRemove){

            DataBase B = new DataBase();

            if(B.removeVehicle(removeVehicleId)){
                System.out.println("Poprawne usuniecie pojazdu");
            } else{
                System.out.println("Blad przy usuwaniu pojazdu");
            }



        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveVehicle){
            removeVehicleId = comboBoxRemoveVehicle.getSelectedIndex() + 1;
        }

    }
}
