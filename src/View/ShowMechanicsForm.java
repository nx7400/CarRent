package View;

import Controler.PersonControler;
import Model.DataBase;
import Model.Employee;
import Model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 21.04.2016.
 */
public class ShowMechanicsForm extends JFrame{
    private JPanel panel1;
    private JList listOfDealers;
    private JButton buttonReturn;
    private DefaultListModel listModel;

    PersonControler pc = new PersonControler();


    public ShowMechanicsForm() {
        super("Lista klientow");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640, 480);
        setLocation(50, 50);


        List<Employee> mechanicsList = pc.getMechanicFromDataBase();


        listModel = new DefaultListModel();

        for (int i = 0; i < mechanicsList.size(); i++) {

            listModel.addElement(mechanicsList.get(i).toString());
        }


        listOfDealers.setModel(listModel);

        listOfDealers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfDealers.setSelectedIndex(0);
        listOfDealers.setVisibleRowCount(5);
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
