package JMenuBarsExamples;
import javax.swing.*;
import java.awt.event.*;

public class MenuBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JMenuBar Örneği");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Menü çubuğu oluşturuluyor
        JMenuBar menuBar = new JMenuBar();

        // 2. Menü kategorileri (üst başlıklar)
        JMenu dosyaMenu = new JMenu("Dosya");
        JMenu yardimMenu = new JMenu("Yardım");

        // 3. Menü öğeleri
        JMenuItem yeniItem = new JMenuItem("Yeni");
        JMenuItem acItem = new JMenuItem("Aç");
        JMenuItem cikisItem = new JMenuItem("Çıkış");

        // 4. Menü öğelerini "Dosya" menüsüne ekle
        dosyaMenu.add(yeniItem);
        dosyaMenu.add(acItem);
        dosyaMenu.addSeparator(); // Ayraç (çizgi) ekler
        dosyaMenu.add(cikisItem);

        
        // 5. "Yardım" menüsüne bir tane öğe ekleyelim
        JMenuItem hakkindaItem = new JMenuItem("Hakkında");
        yardimMenu.add(hakkindaItem);

        // 6. Menüleri menu bar'a ekle
        menuBar.add(dosyaMenu);
        menuBar.add(yardimMenu);

        // 7. Menü çubuğunu frame'e ekle
        frame.setJMenuBar(menuBar);
        

        // --- Event'ler (İsteğe Bağlı) ---
        yeniItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Yeni dosya oluşturuluyor..."));
        acItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Dosya açılıyor..."));
        cikisItem.addActionListener(e -> System.exit(0)); // Programdan çık
        hakkindaItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Bu uygulama Erkan tarafından geliştirildi."));

        frame.setVisible(true);
    }
}
