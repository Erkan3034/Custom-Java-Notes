package LibraryManageSystem;

//Ansiklopedi sınıfı, Kitap sınıfından türetilmiş ve Ansiklopedi türünü temsil eder.
public class Ansiklopedi extends Kitap {
 private int _ciltSayisi; // Ansiklopedinin cilt sayısı

 // Yapıcı metod, ID, ad, yazar ve cilt sayısını başlatır.
 public Ansiklopedi(int id, String ad, String yazar, int ciltSayisi) {
     super(id, ad, yazar); // Base sınıfın yapıcı metodunu çağırır.
     _ciltSayisi = ciltSayisi;
 }

 // Alt sınıfın, getDetay metodunu override ederek detaylı bilgi sağlaması.
 @Override
 public String getDetay() { 
     return "Tür: Ansiklopedi, Cilt Sayısı: " + _ciltSayisi;
 }
 
 
 @Override
 public String toString() {
     return "Ansiklopedi{" +
             "id=" + getId() +
             ", ad='" + getAd() + '\'' +
             ", yazar='" + getYazar() + '\'' +
             ", ciltSayisi=" + _ciltSayisi +
             '}';
 }
}