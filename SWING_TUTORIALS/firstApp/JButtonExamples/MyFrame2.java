package JButtonExamples;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button;
	JLabel label;

	public MyFrame2() {

		// Resmi bir ImageIcon nesnesi olarak yüklüyoruz.
		ImageIcon image = new ImageIcon("CoderrZoneLogoCERCEVELIBUYUK.png");

		// Resmi bir Image nesnesine dönüştürüyoruz.
		Image img = image.getImage();

		// Resmi 100x100 piksel olarak yeniden boyutlandırıyoruz.
		Image resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

		// Yeniden boyutlandırılmış resmi tekrar bir ImageIcon nesnesine çeviriyoruz.
		ImageIcon resizedIcon = new ImageIcon(resizedImage);

		
		label= new JLabel();
		label.setText("Şimdi pencereyi kapat🤧");
		label.setBounds(100,220,150,100);
		label.setVisible(false);
		
		button = new JButton();
		button.setBounds(100, 100, 110, 150);
		button.setText("Click!");
		button.addActionListener(this);
		// button.addActionListener(e-> System.out.println("POP")); //basıldığındna bunu
		// ayzdır.(acionPerformed() ile aynı işlevdedir)
		button.setFocusable(false); // butondaki text etrafında bulunan borderları kaldırır.
		button.setIcon(resizedIcon);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // çarpı butonuna tıklandığında kapat.
		this.setLayout(null);
		this.setIconImage(resizedImage);
		this.setSize(500, 500); // boyut
		this.setVisible(true); // görünürlük
		this.add(button);
		this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println("POP");
			label.setVisible(true);
		}

	}

}
