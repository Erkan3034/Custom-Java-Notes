package LibraryManageSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kütüphane yönetim sistemini başlatır
        KutuphaneYonetim kutuphane = new KutuphaneYonetim();
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için Scanner

        // Kullanıcıya menü seçeneklerini gösterir ve işlemleri başlatır
        while (true) {
            System.out.println("\n--- Kütüphane Yönetim Sistemi ---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Sil"); 
            System.out.println("3. Kitapları Listele");
            System.out.println("4. Kitap Ara");
            System.out.println("5. Kitapları Listele");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır
            scanner.nextLine(); // Boş bir satır alır, bu sayede sonraki girişler için problem olmaz

            switch (secim) {
                case 1: // Kitap ekleme
                    System.out.print("Kitap ID'si: "); //Id al
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Boş bir satır alır
                    System.out.print("Kitap Adı: "); //İsim al 
                    String ad = scanner.nextLine();
                    System.out.print("Kitap Yazarı: "); //Yazar al
                    String yazar = scanner.nextLine();

                    System.out.print("Kitap Türü (Roman/Ansiklopedi): "); //Tür belirle
                    String tur = scanner.nextLine();

                    if (tur.equalsIgnoreCase("Roman")) { //roman girişini kontrol et.
                        System.out.print("Alt Tür: ");   //Roman ise alt tür al.
                        String altTur = scanner.nextLine();
                        Roman roman = new Roman(id, ad, yazar, altTur); //parametreleri class'a ver.
                        kutuphane.kitapEkle(roman); 
                    } 
                    
                    else if (tur.equalsIgnoreCase("Ansiklopedi")) {
                        System.out.print("Cilt Sayısı: ");
                        int ciltSayisi = scanner.nextInt();
                        scanner.nextLine(); // Boş bir satır alır
                        Ansiklopedi ansiklopedi = new Ansiklopedi(id, ad, yazar, ciltSayisi);
                        kutuphane.kitapEkle(ansiklopedi);
                    } 
                    
                    else {
                        System.out.println("Geçersiz tür seçimi!");
                    }
                    break;

                case 2: // Kitap silme
                    System.out.print("Silmek istediğiniz kitabın ID'sini girin: ");
                    int silinecekId = scanner.nextInt();
                    kutuphane.kitapSil(silinecekId); //Silinecek kitaba ait Id'yi kitapS
                    break;

                case 3: // Kitapları listeleme
                    System.out.println("\n--- Kitap Listesi ---");
                    for (Kitap kitap : kutuphane.kitaplariListele()) {
                        System.out.println(kitap);
                    }
                    break;

                    
                case 4: // Kitap arama
                    System.out.print("Aramak istediğiniz kitabın adını girin: ");
                    String kitapAdi = scanner.nextLine();
                    Kitap bulunanKitap = kutuphane.kitapAra(kitapAdi);

                    if (bulunanKitap != null) {
                        System.out.println("Bulunan Kitap: " + bulunanKitap);
                    } else {
                        System.out.println("Kitap bulunamadı!");
                    }
                    break;
                    
                case 5:
                    // Listeleme
                    System.out.println("Listelemek istediğiniz türü seçin: (Roman / Ansiklopedi)");
                    String tur1 = scanner.nextLine(); // Kullanıcıdan tür al
                    kutuphane.listele(tur1); // Türlere göre listele
                    

                case 6: // Çıkış
                    System.out.println("Çıkılıyor...");
                    scanner.close(); // Scanner'ı kapatır
                    System.exit(0); // Programı sonlandırır
                    break;

                default: // Geçersiz seçim
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
                    break;
                    
            }

        }
        

    }
}
