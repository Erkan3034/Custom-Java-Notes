package JProgressBarExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgressBarTimerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JProgressBar Timer Örneği");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Progress bar (0'dan 100'e kadar)
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0); // Başlangıçta %0
        progressBar.setStringPainted(true); // Yüzde gösterilsin

        
        // Başlat butonu
        JButton button = new JButton("İlerle");

        // Timer değişkeni dışarıda tanımlanıyor
        
        final Timer[] timer = new Timer[1]; // Java'da closure için böyle tanımlanır
        final int[] progress = {0}; // Progress değerini sakla
        

        // Butona tıklanınca çalışacak işlem
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Her 100 ms'de bir çalışacak Timer tanımla
                timer[0] = new Timer(100, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        progress[0] += 5; // her adımda 5 artır
                        progressBar.setValue(progress[0]); // güncelle

                        // 100'e ulaşınca durdur
                        if (progress[0] >= 100) {
                            timer[0].stop();
                            JOptionPane.showMessageDialog(frame, "İşlem tamamlandı!");
                        }
                    }
                });

                progress[0] = 0; // her tıklamada sıfırla
                progressBar.setValue(progress[0]);
                timer[0].start(); // Timer'ı başlat
            }
        });

        frame.add(progressBar);
        frame.add(button);
        frame.setVisible(true);
    }
}

