package JFlowLayoutExample;

import javax.swing.*;


import java.awt.*;

public class FlowLayoutOrnegi {
    public static void main(String[] args) {
    	
    	
        JFrame frame = new JFrame("FlowLayout Mantığı");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // FlowLayout (varsayılan ortalı)
        
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,15,15)); //FlowLayout.Center , Left gibi parametre de verebiliriz.
        frame.setSize(400, 300);

        JPanel panel = new JPanel(); // JPanel oluşturduk
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); //FlowLayout.Center , Left gibi parametre de verebiliriz.
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(120,250));


        // 10 tane buton ekleyelim
        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton(""+i));
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}
