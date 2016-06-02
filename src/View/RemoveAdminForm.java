package View;

import Controler.PersonControler;
import Model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 03.06.2016.
 */
public class RemoveAdminForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JComboBox comboBoxRemoveAdmin;
    private JButton buttonRemove;
    private JButton buttonCancel;

    private JFrame statusDialogWindow;

    private int IdAdminToRemove = -1;


    PersonControler pc = new PersonControler();

    public RemoveAdminForm(){

        super("Usun Administratora");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addDealersToComboBox(pc.getAdminFromDataBase());

        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRemoveAdmin.addActionListener(this);


    }

    private void addDealersToComboBox(List<Employee> adminList ){

        for(Employee A : adminList)
            comboBoxRemoveAdmin.addItem(A.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonRemove){


            if(IdAdminToRemove != -1) {

                if (pc.removeAdminFromDataBase(IdAdminToRemove)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane usuniecie administratora z bazy danych");

                } else {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy usuwaniu administratora z bazy danych (Nie można usunac admina o id: 1)", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Nie wybrano admina do usniecia", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveAdmin){
            IdAdminToRemove = comboBoxRemoveAdmin.getSelectedIndex() + 1;
        }

    }
}

