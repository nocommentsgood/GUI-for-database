import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductsForm extends JFrame{
    private JPanel ProductPanel;
    private JTextField pCodeField;
    private JTextField pNameField;
    private JTextField pQuantField;
    private JTextField pPriceField;
    private JButton addToProductTableButton;

    public ProductsForm() {
        setContentPane(ProductPanel);
        setTitle("Product Table");
        setSize(500, 850);
        setVisible(true);
        addToProductTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pCode = Integer.parseInt(pCodeField.getText());
                String pName = pNameField.getText();
                int pQuantity = Integer.parseInt(pQuantField.getText());
                int pPrice = Integer.parseInt(pPriceField.getText());

                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    String uName = "root";
                    String uPass = "1timpfmsdb8!";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_exhaust_shop", uName, uPass);
                    statement = connection.prepareStatement("Insert into products values(?,?,?,?)");

                    statement.setInt(1, pCode);
                    statement.setString(2, pName);
                    statement.setInt(3, pQuantity);
                    statement.setInt(4, pPrice);

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
        ProductsForm myProductForm = new ProductsForm();
    }
}
