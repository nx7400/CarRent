package View;

import javax.swing.*;

/**
 * Created by Michał on 17.03.2016.
 */
public class MechanicMenu extends JFrame {
    private JButton dodajPrzeglądButton;
    private JButton dodajUsterkeButton;
    private JPanel panel1;

    public MechanicMenu(){

        super("Menu Mechanika");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);

        setContentPane(panel1);
    }
}
