import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FeedbackForm extends JFrame {
    private JPanel feedbackPanel;
    private JTextField feedCustNameField;
    private JTextField feedMessageField;
    private JTextField feedDateField;
    private JButton feedButton;

    public FeedbackForm(){
        setContentPane(feedbackPanel);
        setTitle("Feedback Table");
        setSize(500, 850);
        setVisible(true);
        feedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedbackCustomerName = feedCustNameField.getText();
                String feedbackMessage = feedMessageField.getText();
                String feedbackDate = feedDateField.getText();

                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    String uName = "root";
                    String uPass = "1timpfmsdb8!";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_exhaust_shop", uName, uPass);
                    statement = connection.prepareStatement("Insert into feedback values(?,?,?)");

                    statement.setString(1, feedbackCustomerName);
                    statement.setString(2, feedbackMessage);
                    statement.setString(3, feedbackDate);

                    int i = statement.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "Data saved");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data not saved");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }
            }
        });
    }

    public static void main(String[] args) {
        FeedbackForm myFeedbackForm = new FeedbackForm();
    }
}
