package TextAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 
=============Algoritma===============
Kullanıcıdan bir metin al.
Kelime Sayısı:
Metni boşluklara göre bölerek kelime sayısını hesapla.
Cümle Sayısı:
Metni . (nokta), ! (ünlem) veya ? (soru işareti) gibi ayırıcı karakterlere göre bölerek cümle sayısını bul.
Harf Sayısı:
Sadece alfabe karakterlerini say.
En Sık Kullanılan Kelime ve Sayısı:
Her kelimenin tekrarını bir HashMap kullanarak say ve en sık tekrar eden kelimeyi bul.
Replace ile verilen kelimeyi değiştir.
Büyük-Küçük Harf Dönüşümü:
Metni tamamen büyük harfe ve tamamen küçük harfe dönüştür.
 * */


public class TextProcessor {
    private String text; 

    // Constructör.
    public TextProcessor(String text) {
        this.text = text;
    }

    
    // Text analizi için inner class
    class TextAnalyzer {
        public int getWordCount() {
            return text.split("\\s+").length; //boşluklara göre ayırma yap( kelime sayısını boşluklara göre alır)
        }

        public int getSentenceCount() {
            String[] sentences = text.split("[.!?]"); //Cümleleri verilen regex yapısına göre ayırır dizziye atar
            return (int) Arrays.stream(sentences) 
                    .filter(sentence -> !sentence.trim().isEmpty()) //boş kelimeleri saymaz
                    .count();
        }

        public Map<String, Integer> getMostFrequentWords(int topN) { //en sık kullanılanı bulan metot
            // Metni temizleyiip kelimelere böler
            String[] words = text.toLowerCase()
                    .replaceAll("[^a-zA-ZğĞıİöÖüÜşŞçÇ0-9\\s]", "") //(tr karakter desteği) harf ,  rakam ve boşluk dışındaki karakterleri sil.
                    .split("\\s+");

            // sık kullanılan kelime sayaci
            Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            // Sort by frequency and get top N words
            return wordFrequency.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // Değere göre büyükten küçüğe sırala
                    .limit(topN)
                    .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                    ));
        }
    }

    
    
    // metin düzenlemesi için inner ckass
    class TextEditor {
        public String replaceWord(String target, String replacement) {
            return text.replaceAll("\\b" + target + "\\b", replacement);
        }

        public int getCharacterCount() {
            return text.length();
        }

        public String toLowerCase() {
            return text.toLowerCase();
        }

        public String toUpperCase() {
            return text.toUpperCase();
        }
    }

    public static void main(String[] args) {
        // örnek metin
        String sampleText = "Günes, sabahın erken saatlerinde doğarken, kuşlar neşeyle cıvıldıyor. Ağaçların yaprakları rüzgarda sallanıyor. İnsanlar parklarda yürüyüş yaparken, çocuklar oyun alanında eğleniyor. Doğa, huzur ve mutluluk dolu bir gün sunuyor. Günes, her zaman parlıyor.";

        //  TextProcessor nesnesi oluştruma
        TextProcessor processor = new TextProcessor(sampleText);
        
        // İnner class nesnesı
        TextProcessor.TextAnalyzer analyzer = processor.new TextAnalyzer();
        TextProcessor.TextEditor editor = processor.new TextEditor();

        //yazdırma işlemleri
        System.out.println("==================================================Metin Analiz Sonuçları=============================================:");
        System.out.println("Kelime sayisi: " + analyzer.getWordCount());
        System.out.println("Cümle sayısı: " + analyzer.getSentenceCount());
        System.out.println("En çok tekrar edilen 3 kelime: " + analyzer.getMostFrequentWords(3));
        
        System.out.println();
        
        System.out.println("\nDüzenlenmiş metin:");
        System.out.println("Karakter sayısı: " + editor.getCharacterCount());
        System.out.println("'Güneş' kelimesinin 'ışık' ile değişimi: " + 
                          editor.replaceWord("Günes", "ışık"));
        System.out.println("Büyük: " + editor.toUpperCase());
        System.out.println("Küçük: " + editor.toLowerCase());
        
    }
}
