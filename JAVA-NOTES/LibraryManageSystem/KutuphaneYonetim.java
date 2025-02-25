package LibraryManageSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Kütüphane yönetim sınıfı, KutuphaneYonetimInterface'i implement eder.
public class KutuphaneYonetim implements KutuphaneYonetimInterface {
	
 private ArrayList<Kitap> kitapListesi = new ArrayList<>(); // Kitapları saklamak için liste

 // Kitap ekleme metodu
 /*@Override 
 public void kitapEkle(Kitap kitap)  //Parametre olarak Base classtan parametre veriyoruz.
 {
     kitapListesi.add(kitap); //ArrayList' kitap ekliyoruz.
     System.out.println(kitap.getAd() + " başarıyla eklendi!");
 }*/

 
 
 
 // Kitap silme metodu
 @Override
 public void kitapSil(int id) {
     Kitap silinecekKitap = null;

     // ID'ye göre silinecek kitabı bulma
     for (Kitap kitap : kitapListesi) {
         if (kitap.getId() == id) {
             silinecekKitap = kitap;
             break;
         }
     }

     // Kitap bulunduysa silinir
     if (silinecekKitap != null) { //Id doğruysa kitabı sil.
         kitapListesi.remove(silinecekKitap);
         System.out.println(silinecekKitap.getAd() + " başarıyla silindi!"); 
     } else {
         System.out.println("Bu ID'ye sahip bir kitap bulunamadı!");
     }
 }

 
 
 
 
 
 
 // Kitapları listeleme metodu
 @Override
 public ArrayList<Kitap> kitaplariListele() {
     return kitapListesi;
 }

 // Kitap arama metodu
 @Override
 public Kitap kitapAra(String ad) {
     for (Kitap kitap : kitapListesi) {
         if (kitap.getAd().equalsIgnoreCase(ad)) {
             return kitap;
         }
     }
     return null; // Kitap bulunamazsa null döner
 }




@Override
public void kategoriler(Kitap kitap) {
	
	
}

private HashMap<String, List<Kitap>> kitapGruplari;

public KutuphaneYonetim() {
    // Türler ve onların listelerini başlat
    kitapGruplari = new HashMap<>();
    kitapGruplari.put("Roman", new ArrayList<>());
    kitapGruplari.put("Ansiklopedi", new ArrayList<>());
}

@Override
public void kitapEkle(Kitap kitap) {
    if (kitap instanceof Roman) {
        kitapGruplari.get("Roman").add(kitap); // Roman listesine ekle
    } else if (kitap instanceof Ansiklopedi) {
        kitapGruplari.get("Ansiklopedi").add(kitap); // Ansiklopedi listesine ekle
    }
    System.out.println("Kitap eklendi: " + kitap.getAd());
}

@Override
public void listele(String tur) {
    List<Kitap> liste = kitapGruplari.get(tur); // İlgili türün listesini al
    if (liste == null || liste.isEmpty()) {
        System.out.println(tur + " türünde kitap bulunamadı.");
        return;
    }

    System.out.println(tur + " türündeki kitaplar:");
    for (Kitap kitap : liste) {
        System.out.println(kitap);
    }
}
 

 
 
 
}