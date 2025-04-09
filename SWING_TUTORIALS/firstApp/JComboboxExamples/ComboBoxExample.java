package JComboboxExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Örneği");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        

        // ComboBox için bir dizi oluşturuyoruz (açılır menüdeki seçenekler)
        String[] diller = {"Java", "Python", "C#", "JavaScript", "C++"};

        
        // ComboBox oluşturuyoruz
        //JComboBox comboBox = new JComboBox(diller);
        JComboBox<String> comboBox = new JComboBox<>(diller); //parametre olarak diller dizesini veriyoruz

        // Buton: seçimi gösterecek
        JButton button = new JButton("Dil Seçimini Göster");

        // Seçilen dili gösterecek etiket
        JLabel label = new JLabel("Henüz bir dil seçilmedi");

        
        // Butona tıklanınca seçilen dil gösterilir
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ComboBox'tan seçilen elemanı alıyoruz
                String secilenDil = (String) comboBox.getSelectedItem();

                // Label'a yazdırıyoruz
                label.setText("Seçilen Dil: " + secilenDil);
            }
        });

        // Bileşenleri frame'e ekliyoruz
        frame.add(comboBox);
        frame.add(button);
        frame.add(label);

        frame.setVisible(true);
    }
}
