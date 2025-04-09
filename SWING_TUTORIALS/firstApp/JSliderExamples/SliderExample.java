package JSliderExamples;

import javax.swing.*;
import java.awt.*;

public class SliderExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JSlider Örneği");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // JSlider oluşturuluyor: min = 0, max = 100, başlangıç değeri = 50
        JSlider slider = new JSlider(0, 100, 50);

        // Değerleri göstermesini sağlıyoruz (sayısal etiketler)
        slider.setPaintTicks(true); // küçük çizgiler
        slider.setMajorTickSpacing(20); // büyük çizgi aralığı
        slider.setMinorTickSpacing(5); // küçük çizgi aralığı
        slider.setPaintLabels(true); // sayı etiketleri

        // Seçilen değeri gösterecek etiket
        JLabel label = new JLabel("Seçilen Değer: 50");

        // Slider hareket ettikçe değeri etikete yaz
        slider.addChangeListener(e -> {
            int value = slider.getValue(); // anlık slider değeri
            label.setText("Seçilen Değer: " + value);
            System.out.println("Seçilen Değer: " + value);
        });

        // Bileşenleri frame'e ekliyoruz
        frame.add(slider);
        frame.add(label);

        frame.setVisible(true);
    }
}
