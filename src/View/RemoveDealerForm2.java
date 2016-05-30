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
public class RemoveDealerForm2 extends JFrame implements ActionListener {
    private JComboBox comboBoxRemoveDealer;
    private JPanel panel1;
    private JButton buttonRemove;
    private JButton buttonCancel;

    private int removeDealerId;

    public RemoveDealerForm2(){

        super("Usun sprzedawce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        DataBase B = new DataBase();

        List<Employee> dealerList = B.selectDealer();

        addDealersToComboBox(dealerList);

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

            DataBase B = new DataBase();

            if(B.removeDealer(removeDealerId)){
                System.out.println("Poprawne usuniecie sprzedawcy");
            } else{
                System.out.println("Blad przy usuwani sprzedawcy");
            }



        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveDealer){
            removeDealerId = comboBoxRemoveDealer.getSelectedIndex() + 1;
        }

    }
}
