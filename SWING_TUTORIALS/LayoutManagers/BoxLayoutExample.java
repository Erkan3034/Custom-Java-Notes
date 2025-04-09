package LayoutManagers;

import javax.swing.*;

public class BoxLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("BoxLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Dikey düzen için JPanel oluştur
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Dikey düzen
        
        // Bileşenler oluştur
        JButton button1 = new JButton("Buton 1");
        JButton button2 = new JButton("Buton 2");
        JButton button3 = new JButton("Buton 3");
        
        // Bileşenleri panele ekle
        panel.add(button1);
        panel.add(Box.createVerticalStrut(10)); // 10 piksel boşluk ekle
        panel.add(button2);
        panel.add(Box.createVerticalGlue());    // Esnek boşluk ekle
        panel.add(button3);
        
        // Pencereye paneli ekle
        frame.add(panel);
        frame.pack(); // Pencere boyutunu içeriğe göre ayarla
        frame.setVisible(true);
    }
}
/*
BoxLayout bileşenleri tek sütun (Y_AXIS) veya tek satır (X_AXIS) halinde düzenler.
Bileşenler arasına boşluk eklemek için Box.createVerticalStrut() veya createHorizontalStrut() kullanılır.
Esnek boşluklar için createVerticalGlue() veya createHorizontalGlue() kullanılır.
*/