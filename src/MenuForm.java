import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał on 09.03.2016.
 */
public class MenuForm extends JFrame implements ActionListener{
    private JPanel panel1;
    private JButton buttonAddCustomer;
    private JButton button2;
    private JButton button3;
    private JPanel panel2;
    private JLabel menuLabel;

    public MenuForm(){

        super("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);

        setContentPane(panel1);

        buttonAddCustomer.addActionListener(this);




    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == buttonAddCustomer) {
            AddCustomerForm addCustomer = new AddCustomerForm();
        }

    }
}