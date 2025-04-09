package JFrameExamples;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame() { // her çaırdığımda bana bu nesneyi ver.


		this.setTitle("ERKAN TURGUT"); // Frame başlığı
		this.setResizable(false);// boyutlandırma tercihi
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // çarpı butonuna tıklandığında kapat.
		this.setSize(450, 450); // boyut
		this.setVisible(true); // görünürlük

		ImageIcon iconImageIcon = new ImageIcon("CoderrZoneLogoCERCEVELIBUYUK.png");
		this.setIconImage(iconImageIcon.getImage()); // icon

		this.getContentPane().setBackground(Color.BLACK); // arkaplan rengi.

	}

}
