import javax.swing.*;

/**
 * Created by Michał on 17.03.2016.
 */
public class DealerMenu extends JFrame {
    private JButton dodajKlientaButton;
    private JButton dodajSamochódDoKlientaButton;
    private JButton drukujFaktureButton;
    private JPanel panel1;

    public DealerMenu(){

        super("Menu Sprzedawcy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);

        setContentPane(panel1);
    }


}
