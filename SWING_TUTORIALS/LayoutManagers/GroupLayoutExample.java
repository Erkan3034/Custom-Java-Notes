package LayoutManagers;

import javax.swing.*;
import java.awt.*;

public class GroupLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("GroupLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // GroupLayout oluştur ve panele ayarla
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        // Otomatik boşluklar oluştur
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        // Bileşenler oluştur
        JLabel label = new JLabel("Kullanıcı Adı:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Giriş Yap");
        
        // Yatay grup oluştur (soldan sağa: label, textField, button)
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(label)
                .addComponent(textField)
                .addComponent(button)
        );
        
        // Dikey grup oluştur (tüm bileşenleri aynı hizada)
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label)
                .addComponent(textField)
                .addComponent(button)
        );
        
        // Pencereye paneli ekle
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
/*
GroupLayout bileşenleri hem yatay hem de dikey eksende gruplar halinde düzenler.
createSequentialGroup(): Bileşenleri sırayla yerleştirir
createParallelGroup(): Bileşenleri aynı hizada yerleştirir
Özellikle form tasarımları için idealdir.
*/