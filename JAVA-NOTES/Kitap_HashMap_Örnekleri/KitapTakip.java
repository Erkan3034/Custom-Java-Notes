package Kitap_HashMap_Örnekleri;

import java.util.HashMap;
import java.util.Scanner;

public class KitapTakip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        HashMap<String, String> kitaplar = new HashMap<>(); //(K , V)
        

        // Örnek kitaplar
        kitaplar.put("1984", "George Orwell");
        kitaplar.put("Savaş ve Barış", "Lev Tolstoy");
        kitaplar.put("Küçük Prens", "Antoine de Saint-Exupéry");
        kitaplar.put("Suç ve Ceza", "Fyodor Dostoyevski");
        kitaplar.put("Harry Potter", "J.K. Rowling");

        while (true) { //Döngü
            System.out.print("""
                    Kitap listesini görüntülemek için 1'e basın
                    
                    Kitap yazarı sorgulamak için 2'ye basın
                    
                    Yeni bir kitap eklemek için 3'e basın
                    
                    Sistemden çıkmak için 4'e basın: """);

            int secim = scanner.nextInt();
            scanner.nextLine(); // Satır sonunu temizle

            
            
            
            switch (secim) {
                case 1 -> {
                    System.out.println("Kitap Listesi:");
                    int i = 1;
                    for (HashMap.Entry<String, String> entry : kitaplar.entrySet()) {
                        System.out.println(i + ". Kitap: " + entry.getKey() + " - Yazar: " + entry.getValue());
                        i++;
                    }
                }
                case 2 -> {
                    System.out.print("Yazarını öğrenmek istediğiniz kitabın adını giriniz: ");
                    String kitapAdi = scanner.nextLine();
                    
                    if (kitaplar.containsKey(kitapAdi)) {
                        System.out.println("Kitabın yazarı: " + kitaplar.get(kitapAdi));
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                }
                
                case 3 -> {
                    System.out.print("Eklemek istediğiniz kitabın adını giriniz: ");
                    String yeniKitap = scanner.nextLine();
                    System.out.print("Kitabın yazarını giriniz: ");                    
                    String yeniYazar = scanner.nextLine();
                    
                    
                    if (!kitaplar.containsKey(yeniKitap)) {
                        kitaplar.put(yeniKitap, yeniYazar);
                        System.out.println("Kitap başarıyla eklendi.");
                    } else {
                        System.out.println("Bu kitap zaten mevcut.");
                    }
                }
                case 4 -> {
                    System.out.println("Sistemden çıkılıyor...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Geçersiz bir seçim yaptınız. Lütfen tekrar deneyin.");
            }
        }
        
        
        
        
        
    }
}
