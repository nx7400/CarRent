package View;

import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private JRadioButton radioButtonCar;
    private JRadioButton radioButtonMotorBike;
    private JComboBox comboBoxRental;
    private JComboBox comboBoxWrokShop;
    private JFrame wrongIdDialogWindow;
    private JFrame wrongVehicleType;

    private int idRentalSelected = -1;
    private int idWorkShopSelected = -1;
    private int vehicleType = -1; // -1-brak wyboru, 0-samochod, 1-motocykl


    public AddVehicleForm(){
        super("Dodaj Pojazd");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        DataBase B = new DataBase();

        List<Rental> rentalList;
        rentalList = B.selectRental();

        List<WorkShop> workShopList;
        workShopList = B.selectWorkShop();

        addRentalsToComboBox(rentalList);
        addWorkShopsToComboBox(workShopList);

        buttonConfirm.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRental.addActionListener(this);
        comboBoxWrokShop.addActionListener(this);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonCar);
        buttonGroup.add(radioButtonMotorBike);
        radioButtonCar.addActionListener(this);
        radioButtonMotorBike.addActionListener(this);


    }

    private void addRentalsToComboBox(List<Rental> rentalList ){

        for(Rental R : rentalList)
        comboBoxRental.addItem(R.toString());

    }

    private void addWorkShopsToComboBox(List<WorkShop> workShopList ){

        for(WorkShop W : workShopList)
            comboBoxWrokShop.addItem(W.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == buttonConfirm){

            String brand = textFieldBrand.getText();
            String model = textFieldModel.getText();
            String pricePerDayTemp = textFieldPricePerDay.getText();

            double pricePerDay = Double.parseDouble(pricePerDayTemp);
            int idWorkShop = 1;
            int idRental = 1;

            DataBase B = new DataBase();

            if(idRentalSelected == -1 || idWorkShopSelected == -1){

                JOptionPane.showMessageDialog(wrongIdDialogWindow, "Nie wybrano id wypozyczlani lub warsztatu !!!"); // alternatywnie prztpisywac domyslnie id == 1

            } else {
                idRental = idRentalSelected + 1;
                idWorkShop = idWorkShopSelected + 1;
            }


            switch(vehicleType){
                case 0:
                    Vehicle C = new Car(brand, model, idWorkShop, idRental, pricePerDay);
                    B.insertVehicle(C);
                    break;
                case 1:
                    Vehicle M = new MotorBike(brand, model, idWorkShop, idRental, pricePerDay);
                    B.insertVehicle(M);
                    break;
                default:
                    JOptionPane.showMessageDialog(wrongVehicleType, "Nie wybrano typu pojazdu !!!");

            }

            //dispose();
            //Object[] options = {"Dodaj pojazd do klienta","Wróć do menu"};
            //int c = JOptionPane.showOptionDialog(dialogWindow,"Co chcesz zrobić dalej?","Wybierz opcje",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
           // System.out.println(c);

        }

        if(source == comboBoxRental){
            idRentalSelected = comboBoxRental.getSelectedIndex();
        }

        if(source == comboBoxWrokShop){
            idWorkShopSelected = comboBoxWrokShop.getSelectedIndex();
        }

        if(source == radioButtonCar){
            vehicleType = 0;
        }

        if(source == radioButtonMotorBike){
            vehicleType = 1;
        }

        if(source == buttonCancel){
            dispose();
        }

    }
}
