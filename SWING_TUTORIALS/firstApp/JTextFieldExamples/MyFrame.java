package JTextFieldExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JTextField textField;
    JButton btn;
    JLabel label;

    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); // Ana pencereye BorderLayout
        this.setTitle("JTEXTFIELD EXPLANATION");

        // Üst panel (TextField ve Button)
        JPanel topPanel = new JPanel(new FlowLayout());
        textField = new JTextField(50);
        textField.setFont(new Font("Consolas",Font.BOLD,25));
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.GREEN);
        textField.setCaretColor(Color.CYAN);
        textField.setText("UserName...");
        
        btn = new JButton("Get!");
        btn.addActionListener(this);
        topPanel.add(textField);
        topPanel.add(btn);

        // Alt panel (Label)
        JPanel bottomPanel = new JPanel(new FlowLayout());
        label = new JLabel("Bir değer girin...");
        bottomPanel.add(label);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            label.setText("Girilen değer: " + textField.getText());
            System.out.println("Merhaba " + textField.getText());//consol

        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}