package LayoutManagers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("CardLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // CardLayout oluştur ve panele ayarla
        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        
        // Kartlar (bileşenler) oluştur
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Bu Kart 1"));
        card1.setBackground(Color.RED);
        
        JPanel card2 = new JPanel();
        card2.add(new JLabel("Bu Kart 2"));
        card2.setBackground(Color.GREEN);
        
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Bu Kart 3"));
        card3.setBackground(Color.BLUE);
        
        // Kartları panele ekle (isimlerle birlikte)
        cardPanel.add(card1, "Kart1");
        cardPanel.add(card2, "Kart2");
        cardPanel.add(card3, "Kart3");
        
        // Butonlar oluştur (kartlar arasında geçiş için)
        JButton nextButton = new JButton("Sonraki Kart");
        JButton prevButton = new JButton("Önceki Kart");
        
        // Butonlara ActionListener ekle
        nextButton.addActionListener(e -> cardLayout.next(cardPanel));
        prevButton.addActionListener(e -> cardLayout.previous(cardPanel));
        
        // Butonları bir panelde topla
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        
        // Ana pencereye kart paneli ve buton panelini ekle
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
/*
CardLayout aynı alanda birden fazla bileşen saklar ve aralarında geçiş yapmayı sağlar.
next(), previous(), first(), last(), show() metodlarıyla kartlar arasında geçiş yapılır.
Sekmeli arayüzler veya sihirbaz adımları için idealdir.
*/