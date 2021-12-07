import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReceiptForm extends JFrame{
    private JPanel receiptsPanel;
    private JTextField recCustNumField;
    private JTextField recDateField;
    private JTextField recTotalField;
    private JButton addToReceiptsTableButton;

    public ReceiptForm() {
        setContentPane(receiptsPanel);
        setTitle("Receipt Table");
        setSize(500, 850);
        setVisible(true);
        addToReceiptsTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int recCustNumber = Integer.parseInt(recCustNumField.getText());
                String recDate = recDateField.getText();
                int recTotal = Integer.parseInt(recTotalField.getText());

                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    String uName = "root";
                    String uPass = "1timpfmsdb8!";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_exhaust_shop", uName, uPass);
                    statement = connection.prepareStatement("Insert into reciepts values(?,?,?)");

                    statement.setInt(1, recCustNumber);
                    statement.setString(2, recDate);
                    statement.setInt(3, recTotal);

                    int i = statement.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Data saved");
                    } else{
                        JOptionPane.showMessageDialog(null, "Data not saved");
                    }
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null, exception);
                }
            }
        });
    }

    public static void main(String[] args) {
        ReceiptForm myReceiptForm = new ReceiptForm();
    }
}