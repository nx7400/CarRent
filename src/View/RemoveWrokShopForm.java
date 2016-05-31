package View;

import Controler.BuildingControler;
import Model.DataBase;
import Model.WorkShop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 31.05.2016.
 */
public class RemoveWrokShopForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JComboBox comboBoxRemoveWorkShop;
    private JButton buttonRemove;
    private JButton buttonCancel;
    private JFrame statusDialogWindow;

    BuildingControler bc = new BuildingControler();

    private int IdWorkShopToRemove = -1;

    public RemoveWrokShopForm(){

        super("Usun warsztat");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addWorkShopToComboBox(bc.getWorkShopFromDataBase());

        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRemoveWorkShop.addActionListener(this);




    }

    private void addWorkShopToComboBox(List<WorkShop> workShopList){

        for(WorkShop W : workShopList)
            comboBoxRemoveWorkShop.addItem(W.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonRemove){

            if(IdWorkShopToRemove != -1) {

                if (bc.removeWorkShopFormDataBase(IdWorkShopToRemove)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane usuniecie warsztatu z bazy danych");

                } else {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy usuwaniu warsztatu z bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Nie wybrano warsztatu do usniecia", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveWorkShop){
            IdWorkShopToRemove = comboBoxRemoveWorkShop.getSelectedIndex() + 1;
        }

    }
}
