package View;

import Controler.BuildingControler;
import Model.DataBase;
import Model.Rental;
import Model.WorkShop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 31.05.2016.
 */
public class RemoveRentalForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JComboBox comboBoxRemoveRental;
    private JButton buttonRemove;
    private JButton buttonCancel;
    private JFrame statusDialogWindow;

    BuildingControler bc = new BuildingControler();

    private int IdRentalToRemove = -1;

    public RemoveRentalForm(){

        super("Usun wypożyczalnie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addWorkShopToComboBox(bc.getRentalFromDataBase());

        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRemoveRental.addActionListener(this);




    }

    private void addWorkShopToComboBox(List<Rental> rentalList){

        for(Rental R : rentalList)
            comboBoxRemoveRental.addItem(R.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonRemove){

            if(IdRentalToRemove != -1) {

                if (bc.removeRentalFromDataBase(IdRentalToRemove)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane usuniecie wypożyczalni z bazy danych");

                } else {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy usuwaniu wypożyczalni z bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Nie wybrano wypożyczalni do usniecia", "Error", JOptionPane.ERROR_MESSAGE);
            }



        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveRental){
            IdRentalToRemove = comboBoxRemoveRental.getSelectedIndex() + 1;
        }

    }
}
