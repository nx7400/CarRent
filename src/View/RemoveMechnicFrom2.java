package View;

import Controler.PersonControler;
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
    private JFrame statusDialogWindow;

    PersonControler pc = new PersonControler();

    private int IdMechanicToRemove = -1;

    public RemoveMechnicFrom2(){

        super("Usun sprzedawce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addDealersToComboBox(pc.getMechanicFromDataBase());

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

            if(IdMechanicToRemove != -1) {

                if (pc.removeMechanicFromDataBase(IdMechanicToRemove)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane usuniecie mechanika z bazy danych");

                } else {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy usuwaniu mechanika z bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Nie wybrano mechanika do usniecia", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveMechanic){
            IdMechanicToRemove = comboBoxRemoveMechanic.getSelectedIndex() + 1;
        }

    }
}


