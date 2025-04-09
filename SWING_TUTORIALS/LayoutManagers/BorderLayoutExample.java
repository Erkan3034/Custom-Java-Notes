package LayoutManagers;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("BorderLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // BorderLayout olarak ayarla
        frame.setLayout(new BorderLayout());
        
        // Farklı bölgelere butonlar ekle
        frame.add(new JButton("Kuzey"), BorderLayout.NORTH);
        frame.add(new JButton("Güney"), BorderLayout.SOUTH);
        frame.add(new JButton("Doğu"), BorderLayout.EAST);
        frame.add(new JButton("Batı"), BorderLayout.WEST);
        frame.add(new JButton("Merkez"), BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}
/*
BorderLayout pencerenin 5 bölgesine (NORTH, SOUTH, EAST, WEST, CENTER) bileşen yerleştirir.
Merkez bölgesi en fazla alanı kaplar.
Pencere boyutu değiştiğinde bileşenler otomatik yeniden boyutlandırılır.
*/