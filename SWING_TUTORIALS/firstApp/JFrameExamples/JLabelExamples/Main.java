package JLabelExamples;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {

        // Yeşil renkli 5 piksellik bir çerçeve oluşturuluyor.
        Border border = BorderFactory.createLineBorder(Color.green, 5);

        // Resmi yüklüyoruz.
        ImageIcon image = new ImageIcon("CoderrZoneLogoCERCEVELIBUYUK.png");
        
        // Resmi Image nesnesine çeviriyoruz.
        Image img = image.getImage();
        
        // Resmi 100x100 piksel olacak şekilde yeniden boyutlandırıyoruz.
        Image resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        // Yeniden boyutlandırılmış resmi bir ImageIcon nesnesine çeviriyoruz.
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // JLabel oluşturuluyor.
        JLabel label = new JLabel();
        
        // JLabel'e yazı ekleniyor.
        label.setText("Hello Erkan, this is Label Example.");
        
        // JLabel'e yeniden boyutlandırılmış ikon ekleniyor.
        label.setIcon(resizedIcon);
        
        // Metnin ikonun soluna, sağına veya ortasına konumlandırılması (Burada merkezde).
        label.setHorizontalTextPosition(JLabel.CENTER);
        
        // Metnin ikonun altına, üstüne veya ortasına konumlandırılması (Burada üstte).
        label.setVerticalTextPosition(JLabel.TOP);
        
        // Metnin rengi belirleniyor (Pembe tonu).
        label.setForeground(new Color(255, 25, 120));
        
        // Metnin fontu ve boyutu belirleniyor.
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        
        // Metin ile ikon arasındaki boşluk ayarlanıyor.
        label.setIconTextGap(5);
        
        // Arka plan rengi belirleniyor.
        label.setBackground(new Color(193, 207, 161));
        
        // JLabel'in arka plan renginin görünür olmasını sağlıyor.
        label.setOpaque(true);
        
        // JLabel'e yeşil çerçeve ekleniyor.
        label.setBorder(border);
        
		//label.setBounds(125,125,250,250); //set x,y posisiton within frame as well as dimensions
        
        // JLabel'in dikey hizalaması (Merkezde olacak şekilde ayarlanıyor).
        label.setVerticalAlignment(JLabel.CENTER);
        
        // JLabel'in yatay hizalaması (Merkezde olacak şekilde ayarlanıyor).
        label.setHorizontalAlignment(JLabel.CENTER);

        
        
        
        // JFrame oluşturuluyor.
        JFrame frame = new JFrame();
        
        // Pencere boyutu 500x500 piksel olarak belirleniyor.
        frame.setSize(500, 500);
        
        // Pencereyi görünür hale getiriyoruz.
        frame.setVisible(true);
        
        // Kullanıcı pencereyi kapattığında programın kapanmasını sağlıyor.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Pencerenin simge resmini belirliyor.
        frame.setIconImage(resizedImage);
        
        // frame.setLayout(null);  //  manuel konumlandırma için
        
        // Bileşenlerin otomatik olarak boyutlandırılmasını sağlıyor.
        frame.pack();
        
        // JLabel'i JFrame'e ekliyoruz.
        frame.add(label);
    }
}
