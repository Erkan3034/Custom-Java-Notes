package JPanelExamples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLayoutsExample {

	public static void main(String[] args) {

		//Ana pencere (JFrame oluşturma)
		JFrame frame = new JFrame();
		frame.setTitle("JPanel Constructor Örnekleri");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3,2,10,10)); //grid düzeniyle paneller ekledik.(3 satır 2 sütun)
		
		
		
		// 1) Vrasayılan Panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.add(new JLabel("Varsaylan JPanel()"));
	
		
		
		// 2) JPanel(boolean isDoubleBuffered) -> Doule Buffering açık 

		// Double Buffering: Grafikte titremeyi önlemek için kullanılır (varsayılan olarak JPanel'de zaten aktiftir).
		JPanel panel2 = new JPanel(true);
		panel2.setBackground(Color.CYAN);
		panel2.add(new JLabel("JPanel(true)"));
		
		
		// 3) JPanel(LayoutManager layout) -> BorderLayout ile
		JPanel panel3 = new JPanel(new BorderLayout());
		panel3.setBackground(Color.ORANGE);
		panel3.add(new JLabel("JPanel(BorderLayout)") , BorderLayout.EAST);
		
		
		// 4) JPanel(ComponentOrientation, boolean) -> Sadan sola yönlendirme ve double buffering 
        JPanel panel4 = new JPanel(true); // Double buffering aktif
        panel4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panel4.setBackground(Color.PINK);
        panel4.add(new JLabel("JPanel (RTL, true)"));
        panel4.add(new JButton("Buton1"));
        panel4.add(new JButton("Buton2"));
		
        
        // 5) JPanel(LayoutManager layout, boolean isDoubleBuffered) -> GridLayout ve double buffering
        JPanel panel5 = new JPanel(new GridLayout(2,2),true);
        panel5.setBackground(Color.GREEN);
        panel5.add(new JButton("Buton1"));
        panel5.add(new JButton("Buton2"));
        panel5.add(new JButton("Buton3"));
        panel5.add(new JButton("Buton4"));
        
        
        

    	// 6) EKSTRA: Özelleştirimiş JPanel sınıfı ile constructor
    	class CustomPanel extends JPanel {
    		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public CustomPanel() {
    			super(true); //Double buffering açık
    			setBackground(Color.MAGENTA);
    			setLayout(new FlowLayout());
    			add(new JLabel("Özel Jabel"));
    			add(new JButton("TIKLA!"));
    		}
    	}
    	
        
        JPanel panel6 = new CustomPanel();
        
        
        //Panelleri Frame'e ekleme
        
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);
		
		
        //frame'i görüntüleme
        
        frame.setVisible(true);
		
	}
	


}
