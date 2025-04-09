package JButtonExamples;

import javax.swing.*;
import java.awt.*;

public class JButtonAdvancedExample {

    public static void main(String[] args) {
        // Ana pencere (JFrame) oluşturma
        JFrame frame = new JFrame("JButton Geniş Kapsamlı Örnek");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        
        
        // 1. Buton (Metni Değiştiren)
        JButton btnChangeText = new JButton("Metni Değiştir");
        JLabel lblInfo = new JLabel("Butona tıklayın...");
        btnChangeText.addActionListener(e -> lblInfo.setText("Buton tıklandı!")); //ActionListener ile değişim sağlandı

        
        
        // 2. Buton (Renkleri Değiştiren)
        JButton btnChangeColor = new JButton("Renk Değiştir");
        btnChangeColor.setBackground(Color.BLUE);
        btnChangeColor.setForeground(Color.WHITE);
        
        btnChangeColor.addActionListener(e -> {
            btnChangeColor.setBackground(Color.RED);
            btnChangeColor.setForeground(Color.YELLOW);
        });
        
        
        

        // 3. Buton (Butonu Devre Dışı Bırakan)
        JButton btnDisable = new JButton("Butonu Devre Dışı Bırak");
        btnDisable.addActionListener(e -> btnDisable.setEnabled(false));

        
        
        
  
        
        // 4. Buton (İkon Değiştiren)
        JButton btnIcon = new JButton("İkon Değiştir");
        
		// Resmi bir ImageIcon nesnesi olarak yüklüyoruz.
		ImageIcon image = new ImageIcon("CoderrZoneLogoCERCEVELIBUYUK.png");

		// Resmi bir Image nesnesine dönüştürüyoruz.
		Image img = image.getImage();

		// Resmi 100x100 piksel olarak yeniden boyutlandırıyoruz.
		Image resizedImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		
        ImageIcon icon1 = new ImageIcon(resizedImage);
        ImageIcon icon2 = new ImageIcon("Ekran görüntüsü 2025-04-04 015431.png");
        btnIcon.setIcon(icon1);
        btnIcon.addActionListener(e -> btnIcon.setIcon(btnIcon.getIcon() == icon1 ? icon2 : icon1));

        
        
        
        // 5. Buton (Araç İpucu Ekleyen)
        JButton btnTooltip = new JButton("İpucu Göster");
        btnTooltip.setToolTipText("Bu bir Tooltip butondur. Üzerine gelerek bilgi alabilirsiniz.");
        btnTooltip.addActionListener(e ->{
            JOptionPane.showMessageDialog(frame, "Tıklama yapmadan, buton üzerine gelerek de ToolTip alabilirsinz.");
        });

        // 6. Buton (Görünürlüğü Değiştiren)
        JButton btnVisibility = new JButton("Gizle");
        btnVisibility.addActionListener(e -> {
            btnVisibility.setVisible(false);
            JOptionPane.showMessageDialog(frame, "Buton gizlendi!");
        });

        // Butonları Frame'e ekleme
        frame.add(lblInfo);
        frame.add(btnChangeText);
        frame.add(btnChangeColor);
        frame.add(btnDisable);
        frame.add(btnIcon);
        frame.add(btnTooltip);
        frame.add(btnVisibility);

        // Pencereyi görünür hale getirme
        frame.setVisible(true);
    }
}