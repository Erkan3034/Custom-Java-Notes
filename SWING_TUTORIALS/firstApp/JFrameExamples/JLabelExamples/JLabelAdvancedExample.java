package JLabelExamples;

import javax.swing.*;
import java.awt.*;

public class JLabelAdvancedExample extends JFrame {

    public JLabelAdvancedExample() {
        // JFrame ayarları
        setTitle("JLabel Örnek Uygulama");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 1. Constructor: Boş bir JLabel oluşturma
        JLabel label1 = new JLabel();
        label1.setText("Boş JLabel'e Metin Eklendi");
        label1.setBackground(Color.RED);
        label1.setOpaque(true);
        add(label1);

        // 2. Constructor: Metin içeren bir JLabel oluşturma
        JLabel label2 = new JLabel("Metin İçeren JLabel");
        label1.setBackground(Color.RED);
        label1.setOpaque(true);
        add(label2);

        // 3. Constructor: Metin, resim ve hizalama içeren bir JLabel oluşturma
        ImageIcon icon = new ImageIcon("Ekran görüntüsü 2025-04-04 015431.png"); // Resim dosyasının yolunu belirtin
        JLabel label3 = new JLabel("Resimli JLabel", icon, SwingConstants.CENTER);
        label3.setHorizontalTextPosition(SwingConstants.CENTER); // Metin resmin altında
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);   // Metin resmin altında
        add(label3);

        // 4. JLabel'e font ve renk ayarlama
        JLabel label4 = new JLabel("Özel Font ve Renkli JLabel");
        label4.setFont(new Font("Arial", Font.BOLD, 16)); // Font ayarı
        label4.setForeground(Color.BLUE); // Metin rengi
        add(label4);

        // 5. JLabel'e tooltip ekleme
        JLabel label5 = new JLabel("Tooltip Örnek");
        label5.setToolTipText("Bu bir tooltip örneğidir.");
        add(label5);

        // JFrame'i görünür yap
        setVisible(true);
    }

    public static void main(String[] args) {
        // Uygulamayı başlat
        new JLabelAdvancedExample();
    }
}