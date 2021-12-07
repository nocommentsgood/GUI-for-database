import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainframePanel;
    private JButton customerButton;
    private JButton ordersButton;
    private JButton productsButton;
    private JButton billsButton;
    private JButton receiptsButton;
    private JButton likesButton;
    private JButton feedbackButton;

    public MainFrame() {
        setContentPane(mainframePanel);
        setTitle("Feedback Table");
        setSize(500, 850);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserFrame myUserFrame = new UserFrame();
                myUserFrame.setVisible(true);
            }
        });
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderForm myOrderForm = new OrderForm();
                myOrderForm.setVisible(true);
            }
        });
        productsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsForm myProductsForm = new ProductsForm();
                myProductsForm.setVisible(true);
            }
        });
        billsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillForm myBillForm = new BillForm();
                myBillForm.setVisible(true);
            }
        });
        receiptsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceiptForm myReceiptsForm = new ReceiptForm();
                myReceiptsForm.setVisible(true);
            }
        });
        likesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LikesForm myLikesForm = new LikesForm();
                myLikesForm.setVisible(true);
            }
        });
        feedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FeedbackForm myFeedBackForm = new FeedbackForm();
                myFeedBackForm.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MainFrame myMainFrame = new MainFrame();
    }
}
