package proje;

import java.util.HashMap;
import java.util.Scanner;

public class hashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> ogrencilerlist = new HashMap<>();

       
        ogrencilerlist.put("Baran", 88);
        ogrencilerlist.put("Erkan", 76);
        ogrencilerlist.put("Hüseyin", 100);
        ogrencilerlist.put("Uhud", 31);
        ogrencilerlist.put("Mertcan", 62);

        while (true) {
            System.out.print("""
                    Tüm öğrencileri listelemek için 1'e basın
                    Not sorgulamak için 2'ye basın
                    Tüm öğrencilerin notlarının ortalamasını buldurmak için 3'e tıklayın
                    Sistemden çıkmak için 4'e basın: """);

            int deger = scanner.nextInt();
            scanner.nextLine(); // Satır sonunu temizle

            switch (deger) {
                case 1 -> {
                    System.out.println("Tüm öğrenciler:");
                    int i = 1;
                    for (HashMap.Entry<String, Integer> entry : ogrencilerlist.entrySet()) {
                        System.out.println(i + ". öğrenci: " + entry.getKey() + " notu: " + entry.getValue());
                        i++;
                    }
                }
                case 2 -> {
                    System.out.print("Lütfen öğrencinin ismini giriniz: ");
                    String isim = scanner.nextLine();
                    if (ogrencilerlist.containsKey(isim)) {
                        System.out.println("Öğrencenin notu: " + ogrencilerlist.get(isim));
                    } else {
                        System.out.println("Öğrenci bulunamadı.");
                    }
                }
                case 3 -> {
                    int toplam = 0;
                    for (int not : ogrencilerlist.values()) {
                        toplam += not;
                    }
                    double ortalama = (double) toplam / ogrencilerlist.size();
                    System.out.println("Öğrencilerin not ortalaması: " + ortalama);
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

