package JPanelExamples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {

        // Resmi bir ImageIcon nesnesi olarak yüklüyoruz.
        ImageIcon image = new ImageIcon("CoderrZoneLogoCERCEVELIBUYUK.png");

        // Resmi bir Image nesnesine dönüştürüyoruz.
        Image img = image.getImage();

        // Resmi 100x100 piksel olarak yeniden boyutlandırıyoruz.
        Image resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        // Yeniden boyutlandırılmış resmi tekrar bir ImageIcon nesnesine çeviriyoruz.
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        
        
        // JLabel oluşturuluyor (Bu bileşen metin ve ikon içerebilir)
        JLabel label = new JLabel();
        label.setText("Merhaba"); // JLabel içine metin ekleniyor.
        label.setIcon(resizedIcon); // JLabel içine ikon (resim) ekleniyor.

        // JLabel’in içindeki metin ve resmin konumlandırılması
        label.setVerticalAlignment(JLabel.BOTTOM); // Dikey hizalama: Alt
        label.setHorizontalAlignment(JLabel.RIGHT); // Yatay hizalama: Sağ

        
        
        // *** Kırmızı Panel ***
        JPanel redPanel = new JPanel(); // Yeni bir JPanel bileşeni oluşturuluyor.
        redPanel.setBackground(Color.red); // Arka plan rengi kırmızı olarak ayarlanıyor.
        redPanel.setBounds(0, 0, 250, 250); // Panelin konumu ve boyutu belirleniyor.

        // *** Mavi Panel ***
        JPanel bluePanel = new JPanel(); // Yeni bir JPanel bileşeni oluşturuluyor.
        bluePanel.setBackground(Color.blue); // Arka plan rengi mavi olarak ayarlanıyor.
        bluePanel.setBounds(250, 0, 250, 250); // Panelin konumu ve boyutu belirleniyor.

        // *** Yeşil Panel ***
        JPanel greenPanel = new JPanel(); // Yeni bir JPanel bileşeni oluşturuluyor.
        greenPanel.setBackground(Color.green); // Arka plan rengi yeşil olarak ayarlanıyor.
        greenPanel.setBounds(0, 250, 500, 250); // Panelin konumu ve boyutu belirleniyor.
        greenPanel.setLayout(new BorderLayout()); // İçindeki bileşenleri düzenleyebilmek için BorderLayout kullanılıyor.

        // *** JFrame (Ana Pencere) ***
        JFrame frame = new JFrame(); // Yeni bir pencere (JFrame) oluşturuluyor.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pencere kapatıldığında program kapanacak.
        frame.setLayout(null); // Özel konumlandırma yapmak için layout iptal ediliyor.
        frame.setSize(750, 750); // Pencerenin genişliği ve yüksekliği belirleniyor.
        frame.setVisible(true); // Pencere görünür hale getiriliyor.

        // JLabel, yeşil panel içine ekleniyor.
        greenPanel.add(label);

        // Paneller pencereye ekleniyor.
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
    }
}
