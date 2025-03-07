package ödevJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//sabit bilet türü(sadece iki tür seçim saplaması için)
enum BiletTuru {
	NORMAL, INDIRIMLI
}
//bilet bilgileri ve özellikleri

 class Bilet {

	private String filmAdi;
	private String seans;
	private int koltukNumarasi;
	private BiletTuru tur;
	private double fiyat;

	// constructor

	public Bilet(String filmAdi, String seans, int koltukNumarasi, BiletTuru tur) {
		this.filmAdi = filmAdi;
		this.seans = seans;
		this.koltukNumarasi = koltukNumarasi;
		this.tur = tur;
		fiyat = tur == BiletTuru.INDIRIMLI ? 30.0 : 50.0; //bilet türüne göre fiyat belirleme..

	}
	
	public void biletBİlgileriniGöster() {
      System.out.println(
      		"Film: " + filmAdi + 
      		" | Seans: " + seans + 
      		" | Koltuk: " + koltukNumarasi + 
      		" | Bilet Türü: " + tur + 
      		" | Fiyat: " + fiyat + " TL");
	}

}



 class Salon {
	private int salonNumarasi;
    private int kapasite;
    private Map<Integer, Boolean> oturmaPlani; 

    public Salon(int salonNumarasi, int kapasite) {
        this.salonNumarasi = salonNumarasi;
        this.kapasite = kapasite;
        oturmaPlani = new HashMap<>();
        for (int i = 1; i <= kapasite; i++) {
            oturmaPlani.put(i, false); // Başlangıçta tüm koltuklar boş
        }
    }

    public boolean bosYerVarMi() {
        return oturmaPlani.containsValue(false); // En az bir boş koltuk var mı kontrolü
    }

    public boolean koltukAyir(int koltukNumarasi) {
        // Koltuk boşsa rezerve eder, doluysa işlem reddedilir
        if (oturmaPlani.containsKey(koltukNumarasi) && !oturmaPlani.get(koltukNumarasi)) {
            oturmaPlani.put(koltukNumarasi, true);
            return true;
        }
        return false;
    }

    public void salonDurumunuGöster() {
        // Salon doluluk durumunu ekrana yazdırır
        System.out.println("============= Salon " + salonNumarasi + " oturma planı:==============");
        System.out.println("");
        for (int i = 1; i <= kapasite; i++) {
            System.out.print(String.format(oturmaPlani.get(i) ? "[X] " : "[%s] ",i));
            if (i % 10 == 0) System.out.println();// Her 10 koltukta bir alt satıra geç
        }
    }

}

 class SinemaSistemi {
	private Salon salon;
	
	public SinemaSistemi( Salon salon) {
		this.salon = salon;
		
	}
	
	public void biletSat(String filmAdi , String seans, int koltukNumarasi, BiletTuru tur) {
		//koltuk numarsı uygunluk kontorlü
		
		if (salon.koltukAyir(koltukNumarasi)) {
			Bilet bilet = new Bilet(filmAdi, seans, koltukNumarasi, tur);
			
			System.out.println("Bilet satıldı...");
			bilet.biletBİlgileriniGöster();
		}else {
			 System.out.println("Seçilen koltuk dolu! Lütfen başka bir koltuk seçin.");
		}
	}
	

	

}

//ANA PROGRAM:
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Salon salon = new Salon(1, 50); // salon 1 için 50 kişilik yer 
        SinemaSistemi sistem = new SinemaSistemi(salon);

        System.out.println("Sinema Bilet Satış Sistemine Hoş Geldiniz!");
        boolean devam = true;
        while (devam) {
            // Kullanıcıya menü seçenekleri sunuluyor
            System.out.println("1 - Oturma Planını Görüntüle");
            System.out.println("2 - Bilet Satın Al");
            System.out.println("3 - Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    salon.salonDurumunuGöster();
                    break;
                case 2:
                	System.out.print("Film Adı: ");
                	scanner.nextLine();
                	String filmAdi = scanner.nextLine();  
                	System.out.print("Seans (örn: 18:00): ");
                	String seans = scanner.nextLine();
                	System.out.print("Koltuk Numarası: ");
                	int koltukNo = scanner.nextInt();
                	System.out.print("Bilet Türü (1-Normal, 2-İndirimli): ");
                	int turSecim = scanner.nextInt();
                	BiletTuru tur = (turSecim == 2) ? BiletTuru.INDIRIMLI : BiletTuru.NORMAL;
                	sistem.biletSat(filmAdi, seans, koltukNo, tur);
                    break;
                case 3:
                    devam = false;
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }
        scanner.close();

		

	}
}
