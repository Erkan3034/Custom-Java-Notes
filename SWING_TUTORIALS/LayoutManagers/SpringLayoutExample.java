package LayoutManagers;

import javax.swing.*;
import java.awt.*;

public class SpringLayoutExample {
    public static void main(String[] args) {
        // JFrame oluştur
        JFrame frame = new JFrame("SpringLayout Örneği");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // SpringLayout oluştur ve panele ayarla
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        
        // Bileşenler oluştur
        JLabel label = new JLabel("Şifre:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton button = new JButton("Giriş");
        
        // Bileşenleri panele ekle
        panel.add(label);
        panel.add(passwordField);
        panel.add(button);
        
        // Kısıtlamaları ayarla
        
        // Label'ın sol kenarı panelin solundan 10 piksel içeride
        layout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, panel);
        // Label'ın üst kenarı panelin üstünden 10 piksel içeride
        layout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, panel);
        
        // PasswordField'in sol kenarı label'in sağından 10 piksel uzakta
        layout.putConstraint(SpringLayout.WEST, passwordField, 10, SpringLayout.EAST, label);
        // PasswordField'in üst kenarı label ile aynı hizada
        layout.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH, label);
        
        // Button'ın sol kenarı passwordField'in sağından 10 piksel uzakta
        layout.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.EAST, passwordField);
        // Button'ın üst kenarı passwordField ile aynı hizada
        layout.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, passwordField);
        
        // Panelin sağ kenarı button'un sağından 10 piksel uzakta
        layout.putConstraint(SpringLayout.EAST, panel, 10, SpringLayout.EAST, button);
        // Panelin alt kenarı button'un altından 10 piksel uzakta
        layout.putConstraint(SpringLayout.SOUTH, panel, 10, SpringLayout.SOUTH, button);
        
        // Pencereye paneli ekle
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
/*
SpringLayout bileşenler arasındaki mesafeleri "yaylar" (springs) ile tanımlar.
putConstraint() metodu ile bileşenlerin birbirine göre konumları ayarlanır.
Karmaşık ve özelleştirilmiş arayüzler için idealdir.
*/