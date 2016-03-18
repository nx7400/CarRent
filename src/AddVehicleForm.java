import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał on 18.03.2016.
 */
public class AddVehicleForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textFieldBrand;
    private JTextField textFieldModel;
    private JTextField textFieldPricePerDay;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    private JRadioButton RadioButtonCar;
    private JRadioButton RadioButtonMotorBike;
    private JFrame dialogWindow;

    public AddVehicleForm(){
        super("Dodaj Pojazd");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        buttonConfirm.addActionListener(this);
        buttonCancel.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonConfirm){

            String brand = textFieldBrand.getText();
            String model = textFieldModel.getText();
            String pricePerDayTemp = textFieldPricePerDay.getText();

            double pricePerDay = Double.parseDouble(pricePerDayTemp);


            // okodzic radiobuttony;


            //dispose();

            //Object[] options = {"Dodaj pojazd do klienta","Wróć do menu"};

            //int c = JOptionPane.showOptionDialog(dialogWindow,"Co chcesz zrobić dalej?","Wybierz opcje",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);

           // System.out.println(c);




        }

        if(source == buttonCancel){
            dispose();
        }

    }
}
