package JRadioButtonExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JRadioButton Örneği");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        
        // Radyo butonlarını oluşturuyoruz
        JRadioButton r1 = new JRadioButton("Erkek");
        JRadioButton r2 = new JRadioButton("Kadın");
        JRadioButton r3 = new JRadioButton("Belirtmek istemiyorum");

        
        // Sadece birinin seçilebilmesi için bu butonları bir gruba ekliyoruz
        ButtonGroup grup = new ButtonGroup();
        grup.add(r1);
        grup.add(r2);
        grup.add(r3);

        // Seçimi gösterecek buton
        JButton button = new JButton("Seçimi Göster");

        // Sonucu gösterecek etiket
        JLabel label = new JLabel("Seçiminiz burada gösterilecek");

        // Butona tıklanınca seçilen radyo butonuna göre işlem yapılır
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String secim = "Seçilen Cinsiyet: ";
                if (r1.isSelected()) {
                    secim += "Erkek.";
                } else if (r2.isSelected()) {
                    secim += "Kadın.";
                } else if (r3.isSelected()) {
                    secim += "Belirtmek istemiyorum.";
                } else {
                    secim = "Henüz bir seçim yapılmadı!";
                }

                label.setText(secim);
            }
        });

        // Bileşenleri frame'e ekliyoruz
        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        frame.add(button);
        frame.add(label);

        frame.setVisible(true);
    }
}
