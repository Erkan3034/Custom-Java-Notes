package JLayeredPaneExamples;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/*
 * JLayeredPane, Java Swing kütüphanesinde, bileşenlerin katmanlar halinde yerleştirilmesine olanak tanıyan bir sınıftır. 
 * Yani, farklı bileşenleri farklı katmanlarda (layers) göstererek her bir bileşenin önünde veya arkasında görünmesini sağlayabilirsiniz. 
 * Bu, özellikle karmaşık arayüzlerde bileşenleri üst üste yerleştirme ve katmanları kontrol etme açısından çok faydalıdır.
 * 
 * Z-Index: Bileşenlerin hangi sırayla gösterileceğini kontrol edebiliriz
 * Katmanlar arasında önde veya arkada olma durumu, bileşenin z-index (katman sırası) değeri ile belirlenir.
 * */
public class JLayeredPaneExample {
    public static void main(String[] args) {

        
    	//Label-1
    	
    	JLabel label1 = new JLabel("İlk Katman");
    	label1.setHorizontalAlignment(JLabel.CENTER);
    	label1.setVerticalAlignment(JLabel.TOP);
    	
    	label1.setOpaque(true);
    	label1.setBackground(Color.red);
    	label1.setBounds(50,50,200,200);
    	
    	
    	//Label-2
    	
    	JLabel label2 = new JLabel("İkinci Katman");
    	label2.setHorizontalAlignment(JLabel.CENTER);
    	label2.setVerticalAlignment(JLabel.TOP);
    	
        label2.setOpaque(true);
        label2.setBackground(Color.orange);
    	label2.setBounds(150,150,200,200);
    	
    	
    	//Label-3
    	
    	JLabel label3 = new JLabel("Üçüncü Katman");
    	label3.setHorizontalAlignment(JLabel.CENTER);
    	label3.setVerticalAlignment(JLabel.TOP);
    	
    	label3.setOpaque(true);
    	label3.setBackground(Color.YELLOW);
    	label3.setBounds(250,250,200,200);

    	
    	//JLayeredPane
        
        JLayeredPane layeredPane = new JLayeredPane(); //JLayeredPane
        layeredPane.setBounds(0, 0, 500, 500);
        //layeredPane.setBackground(Color.BLACK);
        //layeredPane.setOpaque(true);
        
        layeredPane.add(label1,Integer.valueOf(1)); //üstteki katman
        layeredPane.add(label2,Integer.valueOf(2));
        layeredPane.add(label3,Integer.valueOf(3));
        
        
        
        
        
        // JFrame
        JFrame frame = new JFrame("JLayeredPane Örneği");
        
        frame.add(layeredPane);
        
        
        // JFrame özellikleri
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
