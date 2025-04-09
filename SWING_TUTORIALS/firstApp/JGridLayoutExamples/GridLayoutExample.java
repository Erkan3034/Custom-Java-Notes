package JGridLayoutExamples;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
/*
 *==================  GridLayout Nedir?================
 * 
 -> GridLayout, bir GUI (grafiksel kullanıcı arayüzü) düzeni sağlar ve bileşenleri satırlara ve sütunlara yerleştirir. 
 -> Yani, her bileşen bir "kare"ye yerleştirilir ve her bir "kare" bir hücre gibi düşünülebilir. GridLayout kullanarak, bileşenleri belirli bir ızgara düzenine yerleştirebiliriz. 
 -> Her bir bileşenin boyutları eşit olur.

==================== GridLayout Özellikleri==============================
 -> Satır ve sütun sayısı belirlenir: GridLayout(int rows, int cols) ile satır ve sütun sayısını belirtebilirsiniz. 
 -> Eğer sadece sütun sayısını belirtirseniz, satır sayısı otomatik olarak hesaplanır.

Bileşenlerin eşit büyüklükte olması: GridLayout tüm bileşenleri eşit boyutta yerleştirir.

*/

public class GridLayoutExample {
	public static void main(String[] args) {
		
		// JFrame nesnesi 
		JFrame frame = new JFrame("GridLayout Örneği");
		// GridLayout ile 3 satır ve 3 sütunlu bir düzen oluşturuluyor
		frame.setLayout(new GridLayout(3, 3,5,5));
		
		// 6 tane buton ekleyelim
		for (int i = 1; i < 10; i++) {
			frame.add(new JButton("Buton " + i));
		}

		// JFrame özelliklerini ayarlayalım
		frame.setSize(300, 200); // Boyut
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Çıkışta uygulamayı kapat
		frame.setVisible(true); // Görünür yap

	}
}
