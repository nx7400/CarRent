import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Michał on 21.04.2016.
 */
public class ShowWorkShopsForm extends JFrame {
    private JPanel panel1;
    private JList listOfWorkShops;
    private JButton buttonReturn;
    private DefaultListModel listModel;

    public ShowWorkShopsForm(){


        super("Lista warsztatów");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);


        DataBase B = new DataBase();

        List<WorkShop> workShopsList = B.selectWorkShop();


        listModel = new DefaultListModel();

        for(int i = 0; i<workShopsList.size(); i++){

            listModel.addElement(workShopsList.get(i).toString());
        }


        listOfWorkShops.setModel(listModel);

        listOfWorkShops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfWorkShops.setSelectedIndex(0);
        listOfWorkShops.setVisibleRowCount(5);
        //JScrollPane listScrollPane = new JScrollPane(list1);
        //list1.updateUI();

        setContentPane(panel1);

        buttonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

}
