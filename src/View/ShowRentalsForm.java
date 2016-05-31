package View;

import Controler.BuildingControler;
import Model.DataBase;
import Model.Rental;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 21.04.2016.
 */
public class ShowRentalsForm extends JFrame {
    private JPanel panel1;
    private JList listOfRentals;
    private JButton buttonReturn;
    private DefaultListModel listModel;

    BuildingControler bc = new BuildingControler();

    public ShowRentalsForm() {

        super("Lista wypożyczalni");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);


        List<Rental> rentalsList = bc.getRentalFromDataBase();


        listModel = new DefaultListModel();

        for(int i = 0; i<rentalsList.size(); i++){

            listModel.addElement(rentalsList.get(i).toString());
        }


        listOfRentals.setModel(listModel);

        listOfRentals.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfRentals.setSelectedIndex(0);
        listOfRentals.setVisibleRowCount(5);
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
