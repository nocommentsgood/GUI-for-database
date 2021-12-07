import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LikesForm extends JFrame {
    private JPanel likesPanel;
    private JTextField likesTotalField;
    private JTextField likesDateField;
    private JTextField likesCustNameField;
    private JButton addToLikesTableButton;
    private JLabel likesField;

    public LikesForm() {
        setContentPane(likesPanel);
        setTitle("Likes Table");
        setSize(500, 850);
        setVisible(true);
        addToLikesTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalLikes = Integer.parseInt(likesTotalField.getText());
                String likesDate = likesDateField.getText();
                String likesCustomerName = likesCustNameField.getText();

                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    String uName = "root";
                    String uPass = "1timpfmsdb8!";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_exhaust_shop", uName, uPass);
                    statement = connection.prepareStatement("Insert into likes values(?,?,?)");

                    statement.setInt(1, totalLikes);
                    statement.setString(2, likesDate);
                    statement.setString(3, likesCustomerName);

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

    public static void main(String[] args) {LikesForm myLikesForm = new LikesForm();}
}
