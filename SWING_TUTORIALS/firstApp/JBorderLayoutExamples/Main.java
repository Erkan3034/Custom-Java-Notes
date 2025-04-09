package JBorderLayoutExamples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {

	public static void main(String[] args) {
		// Layout Manager = Defines the naturel layout for components within a container

		// BorderLayout, Java Swing'de kullanılan bir layout manager (yerleşim
		// düzenleyici).
		// Yani bir pencere (JFrame gibi) içinde bileşenlerin (buton, textfield vs.)
		// nereye yerleşeceğini kontrol ediyor.

		/*
		 * BorderLayout, bir container’ı 5 farklı bölgeye ayırır:
		 * 
		 * NORTH (üst)
		 * 
		 * SOUTH (alt)
		 * 
		 * EAST (sağ)
		 * 
		 * WEST (sol)
		 * 
		 * CENTER (orta)
		 */
		//Ne zaman kullanırız? -> Bir pencerenin belirli aanlarına belirgin olarak bileeşen yerleştirmek istediğimizde(ör: üstte menü,altta durum çubuğu, ortada içerik vs.)
		
		
		/*
        JFrame pencere = new JFrame("BorderLayout Örneği");
        pencere.setLayout(new BorderLayout());

        pencere.add(new JButton("Üst (NORTH)"), BorderLayout.NORTH);
        pencere.add(new JButton("Alt (SOUTH)"), BorderLayout.SOUTH);
        pencere.add(new JButton("Sağ (EAST)"), BorderLayout.EAST);
        pencere.add(new JButton("Sol (WEST)"), BorderLayout.WEST);
        pencere.add(new JButton("Merkez (CENTER)"), BorderLayout.CENTER);

        pencere.setSize(400, 300);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setVisible(true);
        
        */
		
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10,10));//Layout Manager olarak BorderLayout verdik.(HorizontalGap, VerticalGap)

        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        panel1.setPreferredSize(new Dimension(100, 100));
        panel1.setToolTipText("Üstte(NORTH)");

        
        
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.RED);
        panel2.setPreferredSize(new Dimension(100, 100));
        panel2.setToolTipText("Altta(SOUTH)");
        
        
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.setPreferredSize(new Dimension(100, 100));
        panel3.setToolTipText("SAĞDA(EAST)");
        
        
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.BLACK);
        panel4.setPreferredSize(new Dimension(100, 100));
        panel4.setToolTipText("SOLDA(WEST)");
        
        
        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.GRAY);
        panel5.setPreferredSize(new Dimension(100, 100));
        panel5.setToolTipText("Merkezde(CENTER)");
        
        
        //=================================SUB PANELS START=======================
        JPanel panel6 = new JPanel();
        panel6 .setBackground(Color.DARK_GRAY);
        panel6 .setPreferredSize(new Dimension(50, 50));
        panel6 .setToolTipText("Üstte(NORTH)");

        
        
        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.cyan);
        panel7.setPreferredSize(new Dimension(50, 50));
        panel7.setToolTipText("Altta(SOUTH)");
        
        
        JPanel panel8 = new JPanel();
        panel8.setBackground(Color.magenta);
        panel8.setPreferredSize(new Dimension(50, 50));
        panel8.setToolTipText("SAĞDA(EAST)");
        
        
        JPanel panel9 = new JPanel();
        panel9.setBackground(Color.orange);
        panel9.setPreferredSize(new Dimension(50, 50));
        panel9.setToolTipText("SOLDA(WEST)");
        
        
        JPanel panel10 = new JPanel();
        panel10.setBackground(Color.PINK);
        panel10.setPreferredSize(new Dimension(50, 50));
        panel10.setToolTipText("Merkezde(CENTER)");
        
        
        //=================================SUB PANELS END =========================
        //panelleri frame'e ekle
        frame.add(panel1, BorderLayout.NORTH);   // üst
        frame.add(panel2, BorderLayout.SOUTH);   // alt
        frame.add(panel3, BorderLayout.EAST);    // sağ
        frame.add(panel4, BorderLayout.WEST);    // sol 
        frame.add(panel5, BorderLayout.CENTER);  // merkez

        
        
        //Sub panelleri panel5(merkezdeki)'e ekledik.
        panel5.setLayout(new BorderLayout(5,5));
        
        panel5.add(panel6, BorderLayout.NORTH);
        panel5.add(panel7, BorderLayout.SOUTH);   // alt
        panel5.add(panel8, BorderLayout.EAST);    // sağ
        panel5.add(panel9, BorderLayout.WEST);    // sol 
        panel5.add(panel10, BorderLayout.CENTER);  // merkez
        
        frame.setVisible(true);
		

	}

}
