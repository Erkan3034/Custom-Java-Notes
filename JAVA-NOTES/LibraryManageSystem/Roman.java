package LibraryManageSystem;

//Roman sınıfı, Kitap sınıfından türetilmiş ve Roman türünü temsil eder.
public class Roman extends Kitap {
 private String _tur; // Romanın alt türü

 // Yapıcı metod, ID, ad, yazar ve alt türü başlatır.
 public Roman(int id, String ad, String yazar, String tur) {
     super(id, ad, yazar); // Base sınıfın yapıcı metodunu çağırır.
     _tur = tur;
 }

 // Alt sınıfın, getDetay metodunu override ederek detaylı bilgi sağlaması.
 @Override
 public String getDetay() {
     return "Tür: Roman, Alt Tür: " + _tur;
 }
 
 
 @Override
 public String toString() {
     return "Roman{" +
             "id=" + getId() +
             ", ad='" + getAd() + '\'' +
             ", yazar='" + getYazar() + '\'' +
             ", tur='" + _tur + '\'' +
             '}';
 }
}
