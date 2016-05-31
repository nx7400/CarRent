package View;

import Controler.BuildingControler;
import Controler.VehicleControler;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private JFrame statusDialogWindow;

    BuildingControler bc = new BuildingControler();

    private int idRentalSelected = -1;
    private int idWorkShopSelected = -1;


    public AddVehicleForm(){
        super("Dodaj Pojazd");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);
        setContentPane(panel1);

        addRentalsToComboBox(bc.getRentalFromDataBase());
        addWorkShopsToComboBox(bc.getWorkShopFromDataBase());

        buttonConfirm.addActionListener(this);
        buttonCancel.addActionListener(this);
        comboBoxRental.addActionListener(this);
        comboBoxWrokShop.addActionListener(this);

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

        if(source == buttonConfirm) {

            String brand = textFieldBrand.getText();
            String model = textFieldModel.getText();
            String pricePerDay = textFieldPricePerDay.getText();

            Car C1 = new Car();

            Pattern brandPattern = Pattern.compile("[A-Z]([a-z])+");
            Matcher brandMatcher = brandPattern.matcher(brand);

            if (brandMatcher.matches()) {

                C1.setBrand(brand);

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Marka powinna zaczynać sie od dużej litery i zawierać tylko litery!!!", "Błędne marka pojazdu", JOptionPane.ERROR_MESSAGE);

            }


            Pattern modelPattern1 = Pattern.compile("([0-9])*[A-Z]([a-z])+([0-9])*");
            Matcher modelMatcher1 = modelPattern1.matcher(model);


            Pattern modelPattern2 = Pattern.compile("([0-9])+");
            Matcher modelMatcher2 = modelPattern2.matcher(model);

            if (modelMatcher1.matches() || modelMatcher2.matches()) {

                C1.setModel(model);

            } else {

                JOptionPane.showMessageDialog(statusDialogWindow, "Model moze zawierać cyfry oraz litery bez spacji!!!", "Błędny model pojazdu", JOptionPane.ERROR_MESSAGE);

            }

            Pattern pricePerDayPattern = Pattern.compile("[1-9]([0-9])*\\.[0-9]+");
            Matcher pricePerDayMatcher = pricePerDayPattern.matcher(pricePerDay);

            if (pricePerDayMatcher.matches()) {

                C1.setPricePerDay(Double.parseDouble(pricePerDay));

            } else{

                JOptionPane.showMessageDialog(statusDialogWindow, "Cena może zawierać tylko cyfry, nie może zaczynać się od zera oraz musi być w formie np. 250.00!!!", "Błędna cena pojazdu", JOptionPane.ERROR_MESSAGE);

            }


            if (idRentalSelected == -1 || idWorkShopSelected == -1) {

                JOptionPane.showMessageDialog(wrongIdDialogWindow, "Nie wybrano id wypozyczlani lub warsztatu !!!"); // alternatywnie prztpisywac domyslnie id == 1

            } else {
                C1.setIdRental(idRentalSelected + 1);
                C1.setIdWorkShop(idWorkShopSelected + 1);
            }


            if (brandMatcher.matches() && (modelMatcher1.matches() || modelMatcher2.matches())) {

                VehicleControler vc = new VehicleControler();

                if (vc.addVehicleToDataBase(C1)) {

                    JOptionPane.showMessageDialog(statusDialogWindow, "Udane dodanie samochodu do bazy danych");

                } else {
                    JOptionPane.showMessageDialog(statusDialogWindow, "Blad przy dodawaniu samochodu do bazy danych", "Error", JOptionPane.ERROR_MESSAGE);
                }


            }

        }

        if(source == comboBoxRental){
            idRentalSelected = comboBoxRental.getSelectedIndex();
        }

        if(source == comboBoxWrokShop){
            idWorkShopSelected = comboBoxWrokShop.getSelectedIndex();
        }

        if(source == buttonCancel){
            dispose();
        }

    }
}
