package LayoutManagers;
import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("GridBagLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // GridBagLayout oluştur ve panele ayarla
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        // Bileşen 1: Sol üst köşede (1x1)
        JButton button1 = new JButton("Buton 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(button1, gbc);
        
        // Bileşen 2: Sağ üst köşede (1x1)
        JButton button2 = new JButton("Buton 2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(button2, gbc);
        
        // Bileşen 3: Sol alt köşede (2x1)
        JButton button3 = new JButton("Uzun Buton");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // 2 sütun genişliğinde
        panel.add(button3, gbc);
        
        // Pencereye paneli ekle
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
/*
GridBagLayout en esnek layout yöneticisidir.
GridBagConstraints ile bileşenlerin konum, boyut ve davranışı kontrol edilir.
gridx, gridy: Hücre koordinatları
gridwidth, gridheight: Kaç hücre kaplayacağı
weightx, weighty: Ekstra alan paylaşımı
fill: Hücre içinde nasıl genişleyeceği
Karmaşık arayüzler için idealdir.
*/