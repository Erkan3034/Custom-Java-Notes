package LayoutManagers;

import javax.swing.*;

public class AbsoluteLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("AbsoluteLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Layout manager'ı null yaparak AbsoluteLayout kullanımını etkinleştir
        frame.setLayout(null);
        
        // Butonlar oluştur
        JButton button1 = new JButton("Buton 1");
        JButton button2 = new JButton("Buton 2");
        JButton button3 = new JButton("Buton 3");
        
        // Butonların konum ve boyutlarını elle ayarla (x, y, width, height)
        button1.setBounds(50, 50, 100, 30);  // x=50, y=50, genişlik=100, yükseklik=30
        button2.setBounds(150, 100, 120, 40);
        button3.setBounds(100, 200, 80, 80);
        
        // Butonları frame'e ekle
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        
        frame.setVisible(true);
    }
}
/*
AbsoluteLayout'da bileşenlerin konum ve boyutlarını elle belirlersiniz.
Avantajı: Tam kontrol sağlar.
Dezavantajı: Pencere boyutu değiştiğinde uyum sağlamaz.
*/