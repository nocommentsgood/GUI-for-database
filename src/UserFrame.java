import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserFrame extends JFrame{
    private JTextField fnameField;
    private JTextField lnameField;
    private JButton addCustomerButton;
    private JTextField phoneField;
    private JTextField addrField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField cnumField;
    private JPanel userFramePanel;
    String uName = "root";
    String uPass = "1timpfmsdb8!";

    public UserFrame(){
        setContentPane(userFramePanel);
        setTitle("Customer Table");
        setSize(500, 850);
        setVisible(true);
        addCustomerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent action) {
                int cnum = Integer.parseInt(cnumField.getText());
                String firstName = fnameField.getText();
                String lastName = lnameField.getText();
                long phone = Long.parseLong(phoneField.getText());
                String addr = addrField.getText();
                String city = cityField.getText();
                String state = stateField.getText();

                Connection connection = null;
                PreparedStatement statement = null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_exhaust_shop", uName, uPass);
                    statement = connection.prepareStatement("Insert into customer values(?,?,?,?,?,?,?)");
                    statement.setInt(1, cnum);
                    statement.setString(2, firstName);
                    statement.setString(3, lastName);
                    statement.setLong(4, phone);
                    statement.setString(5, addr);
                    statement.setString(6, city);
                    statement.setString(7,state);

                    int i = statement.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Data is saved");
                    } else{
                        JOptionPane.showMessageDialog(null, "Data not saved");
                    }

                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
    }

    public static void main(String[] args) {
        UserFrame myFrame = new UserFrame();
    }
}
