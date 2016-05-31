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
public class ShowVehicleForm extends JFrame {
    private JPanel panel1;
    private JList listOfVehicle;
    private JButton buttonReturn;
    private DefaultListModel listModel;

    VehicleControler vc = new VehicleControler();

    public ShowVehicleForm(){

        super("Lista klientow");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);


        List<Vehicle> vehicleList = vc.getVehiclesFromDataBase();


        listModel = new DefaultListModel();

        for(int i = 0; i<vehicleList.size(); i++){

            listModel.addElement(vehicleList.get(i).toString());
        }


        listOfVehicle.setModel(listModel);

        listOfVehicle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfVehicle.setSelectedIndex(0);
        listOfVehicle.setVisibleRowCount(5);
        //JScrollPane listScrollPane = new JScrollPane(list1);
        //list1.updateUI();

        setContentPane(panel1);

        buttonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
