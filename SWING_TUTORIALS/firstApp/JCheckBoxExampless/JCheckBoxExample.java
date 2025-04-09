package JCheckBoxExampless;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class JCheckBoxExample {

	public static void main(String[] args) {
		/*
		 * JFrame frame = new JFrame();
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(500,500);
		 * 
		 * 
		 * JCheckBox checkBox = new JCheckBox();
		 * checkBox.setText("Are you agree With Me ?");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * frame.add(checkBox); frame.setVisible(true);
		 */

        // Yeni bir pencere (JFrame) oluşturuyoruz
        JFrame frame = new JFrame("JCheckBox Örneği");
        frame.setSize(400, 300); // pencere boyutu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // pencereyi kapatınca uygulama da kapansın
        frame.setLayout(new FlowLayout()); // bileşenleri yan yana dizer

        
        // 3 adet checkbox (onay kutusu) oluşturuyoruz
        JCheckBox cb1 = new JCheckBox("Java");
        JCheckBox cb2 = new JCheckBox("Python");
        JCheckBox cb3 = new JCheckBox("C#");

        // Buton ekliyoruz: Seçimleri gösterecek
        JButton button = new JButton("Seçimleri Göster");

        // Metin gösterecek bir etiket
        JLabel label = new JLabel("Seçilenler burada gösterilecek");

        // Butona tıklanınca yapılacak işlemi tanımlıyoruz
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = "Seçilen Diller: ";

                // Hangi checkbox'lar seçilmiş kontrol ediyoruz
                if (cb1.isSelected()) {
                    selected += "Java ";
                }
                if (cb2.isSelected()) {
                    selected += "Python ";
                }
                if (cb3.isSelected()) {
                    selected += "C# ";
                }

                // Etikete yazıyı ayarlıyoruz
                label.setText(selected);
            }
        });

        // Bileşenleri pencereye ekliyoruz
        frame.add(cb1);
        frame.add(cb2);
        frame.add(cb3);
        frame.add(button);
        frame.add(label);

        // Pencereyi görünür hale getiriyoruz
        frame.setVisible(true);
		
		
	}

}
