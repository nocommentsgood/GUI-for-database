import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OrderForm extends JFrame {
    private JTextField orNumField;
    private JTextField orDateField;
    private JTextField cNumField;
    private JButton addToOrderTableButton;
    private JLabel order;
    private JPanel orderFormPanel;

    public OrderForm() {
        setContentPane(orderFormPanel);
        setTitle("Order Table");
        setSize(500, 850);
        setVisible(true);

        addToOrderTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uName = "root";
                String uPass = "1timpfmsdb8!";
                int orNum = Integer.parseInt(orNumField.getText());
                String orDate = orDateField.getText();
                int orCNum = Integer.parseInt(cNumField.getText());

                Connection connection = null;
                PreparedStatement statement = null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_exhaust_shop", uName, uPass);
                    statement = connection.prepareStatement("Insert into orders values(?,?,?)");
                    statement.setInt(1, orNum);
                    statement.setString(2, orDate);
                    statement.setInt(3, orCNum);

                    int i = statement.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Data saved");
                    } else{
                        JOptionPane.showMessageDialog(null, "Data not saved");
                    }
                } catch(Exception exception){
                    JOptionPane.showMessageDialog(null, exception);
                }
            }
        });
    }

    public static void main(String[] args) {
        OrderForm myOrderForm =  new OrderForm();
    }
}
