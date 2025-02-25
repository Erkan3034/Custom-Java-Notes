package TemelNotlar;


//Oda sınıfı: Her bir odayı temsil eder
class Oda {
 private int odaNumarasi; // Odanın numarası
 private boolean doluMu;  // Odanın doluluk durumu
 

 // Yapıcı metot: Oda numarası ile bir oda oluşturur ve varsayılan olarak boş yapar
 public Oda(int odaNumarasi) {
     this.odaNumarasi = odaNumarasi;
     this.doluMu = false; // Varsayılan olarak oda boş
 }

 
 
 // Oda rezerve etme
 public boolean rezervasyonYap() {
     if (!doluMu) { // Eğer oda boşsa rezerve et.
         doluMu = true; // Odayı dolu yap.
         return true;   // Başarılı olduğunu bildir.
     }
     return false; // Oda zaten doluysa rezervasyon yapma
 }

 
 
 // Rezervasyon iptali
 public boolean rezervasyonIptal() {
     if (doluMu) { // Eğer oda doluysa
         doluMu = false; // Odayı tekrar boş yap
         return true;    // Başarılı olduğunu bildir
     }
     return false; // Oda zaten boşsa işlem yapılamaz
 }

 
 
 
 // Odanın dolu olup olmadığını kontrol eder
 public boolean isDoluMu() {
     return doluMu;
 }
 
 

 // Oda numarasını döndürür
 public int getOdaNumarasi() {
     return odaNumarasi;
 }
}



//Otel sınıfı: Oteli ve içindeki odaları temsil eder
class Otel {
	
	
 private Oda[] odalar; // Oteldeki tüm odaları tutan dizi.

 // Yapıcı metot: Belirtilen sayıda oda oluşturacak.
 public Otel(int odaSayisi) {
	 
     odalar = new Oda[odaSayisi]; // SABİT boyutlu bir array oluşturulur
     
     for (int i = 0; i < odaSayisi; i++) {
         odalar[i] = new Oda(i + 1); // Her oda için bir nesne oluşturulur
     }
 }

 
 
 
 // Belirli bir oda numarasına rezervasyon yapar
 public boolean odaRezervasyonYap(int odaNumarasi) {
     if (odaNumarasi > 0 && odaNumarasi <= odalar.length) { // Geçerli bir oda numarası mı kontrolü
         return odalar[odaNumarasi - 1].rezervasyonYap(); // İlgili odada rezervasyon yap
     }
     return false; // Geçersiz oda numarası
 }
 
 
 
 

 // Tüm odaların durumlarını yazdırır
 public void odaDurumlariYazdir() {
     for (Oda oda : odalar) { // Tüm odalar üzerinde döngü
    	 
         System.out.println("Oda " + oda.getOdaNumarasi() + ": " + 
                            (oda.isDoluMu() ? "Dolu" : "Boş")); // Oda durumunu yazdır
     }
 }
}

//Main sınıfı: Programın çalışmasını sağlar
public class OtelRezervasyonSistemi_Array {
	
	
 public static void main(String[] args) {
     Otel otel = new Otel(10); // 5 odalı bir otel oluştur

     otel.odaRezervasyonYap(2); // 2. oda rezerve ediliyor
     otel.odaRezervasyonYap(4); // 4. oda rezerve ediliyor
     otel.odaRezervasyonYap(8);
     otel.odaDurumlariYazdir(); // Odaların durumlarını ekrana yazdır
 }
 
 
}
