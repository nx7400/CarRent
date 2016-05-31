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
public class RemoveDealerForm2 extends JFrame implements ActionListener {
    private JComboBox comboBoxRemoveDealer;
    private JPanel panel1;
    private JButton buttonRemove;
    private JButton buttonCancel;
    private JFrame statusDialogWindow;

    private int IdDealerToRemove = -1;

    PersonControler pc = new PersonControler();

    public RemoveDealerForm2(){

        super("Usun sprzedawce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addDealersToComboBox(pc.getDealersFromDataBase());

        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRemoveDealer.addActionListener(this);


    }

    private void addDealersToComboBox(List<Employee> dealerList ){

        for(Employee D : dealerList)
            comboBoxRemoveDealer.addItem(D.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonRemove){


            if(IdDealerToRemove != -1) {

                if (pc.removeDealerFromDataBase(IdDealerToRemove)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane usuniecie sprzedawcy z bazy danych");

                } else {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy usuwaniu sprzedawcy z bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Nie wybrano sprzedawcy do usniecia", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveDealer){
            IdDealerToRemove = comboBoxRemoveDealer.getSelectedIndex() + 1;
        }

    }
}
