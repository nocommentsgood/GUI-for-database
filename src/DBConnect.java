import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnect extends Application {

    public static void main(String[] args) {
        UserFrame test = new UserFrame();
        test.setVisible(true);
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Scanner input = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String uName = "root";
        String uPass = "1timpfmsdb8!";
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_exhaust_shop", uName, uPass);

            // create statement
            statement = con.createStatement();

            // execute sql
            resultSet = statement.executeQuery("select * from customer");

            // process result set
            String data = "";
            while (resultSet.next()){
                data = data + resultSet.getString("Lname") + "," + resultSet.getString("Address") + "\n";

                System.out.println(resultSet.getString("Lname") + "," + resultSet.getString("Fname"));
            }

            Text text1 = new Text();
            text1.setText(data);

            VBox root = new VBox();

            root.getChildren().addAll(text1);

            root.setSpacing(10);

            root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
            + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

            Scene scene = new Scene(root, 300, 200);
            stage.setScene(scene);
            stage.setTitle("Example");
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (con != null){
                con.close();
            }
        }
    }
}
