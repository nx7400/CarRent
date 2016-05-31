package View;

import Model.DataBase;
import Model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 15.04.2016.
 */
public class RemoveMechnicFrom2 extends JFrame implements ActionListener {
    private JPanel panel1;
    private JComboBox comboBoxRemoveMechanic;
    private JButton buttonRemove;
    private JButton buttonCancel;

    private int removeMechanicId;

    public RemoveMechnicFrom2(){

        super("Usun sprzedawce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        DataBase B = new DataBase();

        List<Employee> mechanicList = B.selectMechanic();

        addDealersToComboBox(mechanicList);

        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRemoveMechanic.addActionListener(this);




    }

    private void addDealersToComboBox(List<Employee> mechanicList ){

        for(Employee M : mechanicList)
            comboBoxRemoveMechanic.addItem(M.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonRemove){

            DataBase B = new DataBase();

            if(B.removeMechanic(removeMechanicId)){
                System.out.println("Poprawne usuniecie sprzedawcy");
            } else{
                System.out.println("Blad przy usuwani sprzedawcy");
            }


        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveMechanic){
            removeMechanicId = comboBoxRemoveMechanic.getSelectedIndex() + 1;
        }

    }
}


