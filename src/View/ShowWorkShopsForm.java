package View;

import Controler.BuildingControler;
import Model.Building;
import Model.DataBase;
import Model.WorkShop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 21.04.2016.
 */
public class ShowWorkShopsForm extends JFrame {
    private JPanel panel1;
    private JList listOfWorkShops;
    private JButton buttonReturn;
    private DefaultListModel listModel;

    BuildingControler bc = new BuildingControler();

    public ShowWorkShopsForm(){


        super("Lista warsztatów");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);



        List<WorkShop> workShopsList = bc.getWorkShopFromDataBase();


        listModel = new DefaultListModel();

        for(int i = 0; i<workShopsList.size(); i++){

            listModel.addElement(workShopsList.get(i).toString());
        }


        listOfWorkShops.setModel(listModel);

        listOfWorkShops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfWorkShops.setSelectedIndex(0);
        listOfWorkShops.setVisibleRowCount(5);
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
