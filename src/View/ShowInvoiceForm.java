package View;

import Controler.InvoiceControler;
import Controler.PersonControler;
import Controler.VehicleControler;
import Model.Customer;
import Model.Invoice;
import Model.Person;
import Model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michał on 02.06.2016.
 */
public class ShowInvoiceForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton cancelButton;
    private JButton buttonShow;
    private JComboBox comboBoxInvoice;
    private JTextArea textAreaCustomerData;
    private JTable tableOfVehiclesDaysAndCosts;
    private JTextArea textAreaCostsData;

    private JFrame statusDialogWindow;
    private JFrame dialogWindow;
    private JFrame wrongIdDialogWindow;

    private int idInvoiceSelected = -1;

    InvoiceControler ic = new InvoiceControler();
    VehicleControler vc = new VehicleControler();
    PersonControler pc = new PersonControler();

    public ShowInvoiceForm() {
        super("Wyświetl fakture");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        comboBoxInvoice.addActionListener(this);
        buttonShow.addActionListener(this);
        cancelButton.addActionListener(this);

        addInvoiceToComboBox(ic.getInvoiceFromDataBase());


    }

    private void addInvoiceToComboBox(List<Invoice> invoiceList ){

        for(Invoice In : invoiceList)
            comboBoxInvoice.addItem(In.toString());

    }

    public TableModel toTableModel(HashMap<?,?> map){
        DefaultTableModel model = new DefaultTableModel(new Object[] {"Key", "Value"},0);

        for (Map.Entry<?,?> entry : map.entrySet()){
            model.addRow(new Object[] {entry.getKey(), entry.getValue()});
        }

        return model;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonShow){

            Invoice In = ic.getInvoiceById(idInvoiceSelected);
            Customer C = pc.getCustomerById(In.getIdCustomer());

            textAreaCustomerData.setFont(new Font("Serif",Font.PLAIN,14));

            textAreaCustomerData.append("Faktura o id: " + In.getIdInvoice() + " wystwaiona na: " + C.showCustomerInInvoice());

            ic.getInvoice_Vehicle(In);

            tableOfVehiclesDaysAndCosts.setModel(toTableModel(In.getRentTimeOfVehicleMap()));

            textAreaCostsData.setFont(new Font("Serif", Font.PLAIN,14));
            textAreaCostsData.append("Całkowity koszt faktury netto: " + In.coutTotalCost() + "zł\nCałkowita kwota VAT 23%: " + In.coutTotalCost()*0.23 + "zł\nCałkowity koszy faktury brutto: " + In.coutTotalCost()*1.23 + "zł" );



        }

        if(source == cancelButton){
            dispose();
        }

        if(source == comboBoxInvoice){

            idInvoiceSelected = comboBoxInvoice.getSelectedIndex() + 1;
        }


    }


}

