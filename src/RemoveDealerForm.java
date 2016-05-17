import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 15.04.2016.
 */
public class RemoveDealerForm extends JFrame {
    private DefaultListModel listModel;
    private JPanel panel1;
    private JButton buttonRemove;
    private JButton buttonCancel;
    private String[] array;
    private JList list1;

    public RemoveDealerForm(){
        super("Usun sprzedawce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(640,480);
        setLocation(50,50);


        DataBase B = new DataBase();

        List<Employee> dealerList = B.selectDealer();

        String[] array = new String[dealerList.size()];

        listModel = new DefaultListModel();

        for(int i = 0; i<dealerList.size(); i++){

            array[i] = dealerList.get(i).toString();
            listModel.addElement(dealerList.get(i).toString());
        }


        list1.setModel(listModel);

        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setSelectedIndex(0);
        list1.setVisibleRowCount(5);
        //JScrollPane listScrollPane = new JScrollPane(list1);
        //list1.updateUI();

        setContentPane(panel1);


    }

}
