package LayoutManagers;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("FlowLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // FlowLayout oluştur ve panele ayarla (hizalama: LEFT, yatay boşluk: 10, dikey boşluk: 20)
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        
        // Bileşenler oluştur
        for (int i = 1; i <= 8; i++) {
            panel.add(new JButton("Buton " + i));
        }
        
        // Pencereye paneli ekle
        frame.add(panel);
        frame.pack(); // Pencere boyutunu içeriğe göre ayarla
        frame.setVisible(true);
    }
}
/*
FlowLayout bileşenleri soldan sağa doğru yerleştirir, satır dolunca bir alt satıra geçer.
Varsayılan hizalama CENTER'dır, ancak LEFT, RIGHT, LEADING, TRAILING de kullanılabilir.
Bileşenler arası yatay ve dikey boşluklar ayarlanabilir.
Pencere boyutu değiştiğinde bileşenler otomatik yeniden düzenlenir.
*/