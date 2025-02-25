package LibraryManageSystem;

import java.util.ArrayList;

public interface KutuphaneYonetimInterface {
	//KütüphaneYonetimInterface interface'sini implement eden her class'ın bulundurması gereken metotlar.

	void kitapEkle(Kitap kitap); // Kitap ekleme metodu
    void kitapSil(int id); // Kitap silme metodu 
    ArrayList<Kitap> kitaplariListele(); // Kitapları listeleme metodu 
    Kitap kitapAra(String ad); // Kitap arama metodu 
    void kategoriler(Kitap kitap);
    void listele(String tur);
}
