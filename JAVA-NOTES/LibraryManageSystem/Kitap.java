package LibraryManageSystem;

//Kitap sınıfı, temel özellikleri tanımlar ve alt sınıflar tarafından miras alınır.
public abstract class Kitap { //Classı direk örneklenmemesi için abstract olarak tanımladık.
 private int _id; // Kitap ID'si
 private String _ad; // Kitap adı
 private String _yazar; // Kitap yazarı

 // Yapıcı metod, kitabın ID, ad ve yazar bilgilerini başlatır.
 
 public Kitap(int id, String ad, String yazar) { //Her kitap türünde olacak olan bilgiler.
     _id = id;
     _ad= ad;
    _yazar= yazar;
 }

 // ID'yi döndüren getter metodu
 public int getId() {
     return _id;
 }

 // Kitap adını döndüren getter metodu
 public String getAd() {
     return _ad;
 } 

 // Kitap yazarını döndüren getter metodu
 public String getYazar() {
     return _yazar;
 }

 // Alt sınıflar tarafından uygulanması gereken soyut metod.
 public abstract String getDetay();

 // Kitap bilgilerini kolayca yazdırabilmek için toString metodu.
 @Override
 public String toString() {
     return "ID: " + _id + ", Ad: " + _ad + ", Yazar: " + _yazar + ", " + getDetay();
 }

}
