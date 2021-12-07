import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BillForm extends JFrame{
    private JTextField billNumText;
    private JTextField billAmountText;
    private JTextField billDateText;
    private JLabel billNumField;
    private JLabel billAmountField;
    private JLabel billDateField;
    private JPanel billPanel;
    private JButton addToBillTableButton;

    public BillForm() {
        setContentPane(billPanel);
        setTitle("Bill Table");
        setSize(500, 850);
        setVisible(true);

        addToBillTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int billNum = Integer.parseInt(billNumText.getText());
                int billTotal = Integer.parseInt(billAmountText.getText());
                String billDate = billDateText.getText();

                Connection connection = null;
                PreparedStatement statement = null;

                try{
                    String uName = "root";
                    String uPass = "1timpfmsdb8!";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_exhaust_shop", uName, uPass);
                    statement = connection.prepareStatement("Insert into bills values(?,?,?)");
                    statement.setInt(1, billNum);
                    statement.setInt(2, billTotal);
                    statement.setString(3, billDate);

                    int i = statement.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Data is saved");
                    } else{
                        JOptionPane.showMessageDialog(null, "Data is not saved");
                    }
                } catch(Exception exception){
                    JOptionPane.showMessageDialog(null, exception);
                }
            }
        });
    }

    public static void main(String[] args) {
        BillForm myBillForm = new BillForm();
    }
}
