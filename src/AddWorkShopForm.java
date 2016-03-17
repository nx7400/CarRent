import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał on 11.03.2016.
 */
public class AddWorkShopForm extends JFrame implements ActionListener {
    private JTextField textFieldCity;
    private JTextField textFieldaddress;
    private JPanel panel1;
    private JButton buttonConfirm;
    private JButton buttonCancel;

    public AddWorkShopForm(){
        super("Dodaj Warsztat");
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

            String city = textFieldCity.getText();
            String address = textFieldaddress.getText();

            WorkShop W = new WorkShop(city,address);

        }

        if(source == buttonCancel){
            dispose();
        }

    }
}
