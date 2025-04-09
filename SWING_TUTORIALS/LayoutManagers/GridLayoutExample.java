package LayoutManagers;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("GridLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // GridLayout oluştur ve panele ayarla (3 satır, 2 sütun, yatay/dikey boşluk: 5)
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        // Bileşenler oluştur
        for (int i = 1; i <= 6; i++) {
            panel.add(new JButton("Buton " + i));
        }
        
        // Pencereye paneli ekle
        frame.add(panel);
        frame.pack(); // Pencere boyutunu içeriğe göre ayarla
        frame.setVisible(true);
    }
}
/*
GridLayout bileşenleri belirtilen satır ve sütun sayısına göre ızgara şeklinde düzenler.
Tüm hücreler eşit boyuttadır.
Bileşenler eklenme sırasına göre soldan sağa ve yukarıdan aşağıya yerleştirilir.
Pencere boyutu değiştiğinde hücreler otomatik yeniden boyutlandırılır.
*/