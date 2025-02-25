package TemelNotlar;

import java.util.ArrayList;

//Ürün sınıfı: E-ticaret platformundaki bir ürünü temsil eder
class Urun {

	private String isim; // Ürünün ismi
	private double fiyat; // Ürünün fiyatı

	// Yapıcı metot: Ürün ismi ve fiyatı ile bir ürün oluşturur
	public Urun(String isim, double fiyat) {
		this.isim = isim;
		this.fiyat = fiyat;
	}

	// Ürünün ismini döndürür
	public String getIsim() {
		return isim;
	}

	// Ürünün fiyatını döndürür
	public double getFiyat() {
		return fiyat;
	}
}

//Sepet sınıfı: Alışveriş sepetini temsil eder
class Sepet {

	private ArrayList<Urun> urunler; // Sepetteki ürünleri tutar

	// Yapıcı metot: Boş bir sepet oluşturur
	public Sepet() {
		urunler = new ArrayList<>(); // Dinamik bir liste oluşturulur
	}

	// Sepete ürün ekler
	public void urunEkle(Urun urun) {
		urunler.add(urun); // ArrayList'e dinamik olarak ürün eklenir.
	}

	// Sepetten belirli bir ürünü çıkarır
	public void urunCikar(String urunIsmi) {
		urunler.removeIf(urun -> urun.getIsim().equals(urunIsmi)); // Girilen ürün mevcutta varsa ürünü çıkar
	}

	
	
	// Sepetteki ürünlerin toplam fiyatını hesaplar
	public double toplamFiyat() {
		return urunler.stream().mapToDouble(Urun::getFiyat).sum(); // Tüm ürün fiyatlarını toplar
	}

	
	// Sepetteki ürünleri ve toplam fiyatı ekrana yazdırır
	public void sepetiGoster() {
		System.out.println("Sepetinizdeki ürünler:");
		for (Urun urun : urunler) { // Liste üzerinde döngü
			System.out.println("- " + urun.getIsim() + ": " + urun.getFiyat() + " TL"); // Ürün bilgisi
		}
		System.out.println("Toplam: " + toplamFiyat() + " TL"); // Toplam fiyat
	}
}

//Main sınıfı: Programın çalışmasını sağlar
public class E_Ticaret_Sepet_Yönetimi_ARRAYLIST {

	public static void main(String[] args) {
		Sepet sepet = new Sepet(); // Yeni bir alışveriş sepeti oluştur

		// Ürünler oluşturuluyor
		Urun urun1 = new Urun("Laptop", 15000);
		Urun urun2 = new Urun("Klavye", 500);
		Urun urun3 = new Urun("Mouse", 250);

		// Ürünler sepete ekleniyor
		sepet.urunEkle(urun1);
		sepet.urunEkle(urun2);
		sepet.urunEkle(urun3);

		sepet.sepetiGoster(); // Sepetin içeriği ve toplam fiyat gösteriliyor

		// Sepetten bir ürün çıkarılıyor
		sepet.urunCikar("Klavye");
		sepet.sepetiGoster(); // Güncellenmiş sepet gösteriliyor
	}

}
