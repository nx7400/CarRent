package View;

import Controler.PersonControler;
import Model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 02.06.2016.
 */
public class ShowAdminsForm extends JFrame {
    private JPanel panel1;
    private JList listOfAdmins;
    private JButton buttonReturn;
    private DefaultListModel listModel;

    PersonControler pc = new PersonControler();

    public ShowAdminsForm(){

        super("Lista Administratorów");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);


        List<Employee> adminsList = pc.getAdminFromDataBase();



        listModel = new DefaultListModel();

        for(int i = 0; i<adminsList.size(); i++){

            listModel.addElement(adminsList.get(i).toString());
        }


        listOfAdmins.setModel(listModel);

        listOfAdmins.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfAdmins.setSelectedIndex(0);
        listOfAdmins.setVisibleRowCount(5);
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
