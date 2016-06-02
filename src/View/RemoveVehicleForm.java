package View;

import Controler.VehicleControler;
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
    private JFrame statusDialogWindow;

    VehicleControler vc = new VehicleControler();

    private int IdVehicleToRemove = -1;

    public RemoveVehicleForm(){

        super("Usun pojazd");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addVehicleToComboBox(vc.getVehiclesFromDataBase());

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

            if(IdVehicleToRemove != -1) {

                if (vc.removeVehicleFromDataBase(IdVehicleToRemove)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane usuniecie pojazdu z bazy danych");

                } else {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy usuwaniu pojazdu z bazy danych (Sprawdź czy wszystkie faktury z wybranym pojazdem zostały usuniete)", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Nie wybrano klienta do usniecia", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveVehicle){
            IdVehicleToRemove = comboBoxRemoveVehicle.getSelectedIndex() + 1;
        }

    }
}
