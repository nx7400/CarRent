package View;

import Controler.PersonControler;
import Model.Customer;
import Model.DataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 21.04.2016.
 */
public class ShowCustomersForm extends JFrame {
    private JList listOfCustomers;
    private JButton buttonReturn;
    private JPanel panel1;
    private DefaultListModel listModel;

    PersonControler pc = new PersonControler();

    public ShowCustomersForm(){

        super("Lista klientow");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);


        List<Customer> cutomersList = pc.getCustomersFromDataBase();

        listModel = new DefaultListModel();

        for(int i = 0; i<cutomersList.size(); i++){

            listModel.addElement(cutomersList.get(i).toString());
        }


        listOfCustomers.setModel(listModel);

        listOfCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfCustomers.setSelectedIndex(0);
        listOfCustomers.setVisibleRowCount(5);
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
