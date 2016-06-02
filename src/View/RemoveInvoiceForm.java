package View;

import Controler.InvoiceControler;
import Controler.PersonControler;
import Model.Invoice;
import Model.Invoice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 03.06.2016.
 */
public class RemoveInvoiceForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JComboBox comboBoxRemoveInvoice;
    private JButton buttonRemove;
    private JButton buttonCancel;

    private JFrame statusDialogWindow;

    private int IdInvoiceToRemove = -1;

    InvoiceControler ic = new InvoiceControler();

    public RemoveInvoiceForm(){

        super("Usun sprzedawce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addDealersToComboBox(ic.getInvoiceFromDataBase());

        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRemoveInvoice.addActionListener(this);


    }

    private void addDealersToComboBox(List<Invoice> invoiceList ){

        for(Invoice In : invoiceList)
            comboBoxRemoveInvoice.addItem(In.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonRemove){


            if(IdInvoiceToRemove != -1) {

                if (ic.removeInvoiceFromDataBase(IdInvoiceToRemove)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane usuniecie faktury z bazy danych");

                } else {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy usuwaniu faktury z bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Nie wybrano faktury do usniecia", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }

        if(source == buttonCancel){
            dispose();
        }

        if(source == comboBoxRemoveInvoice){
            IdInvoiceToRemove = comboBoxRemoveInvoice.getSelectedIndex() + 1;
        }

    }
}


