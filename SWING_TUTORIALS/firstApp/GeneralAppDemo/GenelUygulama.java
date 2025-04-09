package GeneralAppDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GenelUygulama {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Menü Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu dosyaMenu = new JMenu("Dosya");
        JMenuItem cikisItem = new JMenuItem("Çıkış");
        dosyaMenu.add(cikisItem);
        menuBar.add(dosyaMenu);
        
        JMenu yardimMenu = new JMenu("Yardım");
        JMenuItem hakkindaItem = new JMenuItem("Hakkında");
        yardimMenu.add(hakkindaItem);
        menuBar.add(yardimMenu);
        
        frame.setJMenuBar(menuBar);

        // Menü Event'leri
        cikisItem.addActionListener(e -> System.exit(0));
        hakkindaItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Bu form, Erkan tarafınan Java Swing örneği olarak tasarlandi."));

        // Kullanıcı adı ve şifre alanları
        JLabel userLabel = new JLabel("Kullanıcı Adı:");
        JTextField userField = new JTextField(20);
        JLabel passLabel = new JLabel("Şifre:");
        JPasswordField passField = new JPasswordField(20);

        // Giriş Yap butonu
        JButton loginButton = new JButton("Giriş Yap");

        // Progress bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(300, 30));

        
        
        // Giriş yap butonuna tıklandığında
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Lütfen tüm alanları doldurun.");
            } else {
                // Progress Bar animasyonu başlat
                progressBar.setValue(0);
                Timer timer = new Timer(100, new ActionListener() {
                    int progress = 0;
                    public void actionPerformed(ActionEvent evt) {
                        progress += 10;
                        progressBar.setValue(progress);
                        if (progress >= 100) {
                            ((Timer)evt.getSource()).stop();  // Timer'ı durdur
                            JOptionPane.showMessageDialog(frame, "Giriş Başarılı!");
                        }
                    }
                });
                timer.start();
            }
        });

        // Bileşenleri ekle
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(progressBar);

        // Görünür yap
        frame.setVisible(true);
    }
}

