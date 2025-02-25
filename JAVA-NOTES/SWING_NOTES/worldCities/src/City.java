/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */

/**
 * City sınıfı, veritabanından alınan şehir bilgilerini temsil eden sınıftır
 * Her bir şehir için id, isim, ülke kodu, ilçe adı ve nüfus gibi bilgileri tutacak
 * 
 * @author ERKAN TURGUT
 */
public class City {
    // Şehirle ilgili özellikler (field'lar)
    private int id;                // Şehrin benzersiz kimlik numarası
    private String name;           // Şehrin adı
    private String countryCode;    // Şehrin ait olduğu ülke kodu (ISO formatında)
    private String district;       // Şehrin bağlı olduğu bölge veya ilçe
    private int population;        // Şehrin nüfusu

    /**
     * Parametreli Constructor: Şehir nesnesini başlatmak için kullanılır.
     * @param id Şehrin ID'si (veritabanından gelir)
     * @param name Şehrin adı (veritabanından gelir)
     * @param countryCode Şehrin ülke kodu (veritabanından gelir) 
     * @param district Şehrin ilçesi (veritabanından gelir)
     * @param population Şehrin nüfusu (veritabanından gelir)
     */
    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    // Getter ve Setter metotları (özelliklere erişim ve değiştirme)

    // Şehrin ID'sini döndür
    public int getId() {
        return id;
    }

    // Şehrin ID'sini ayarlar
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }


    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public String getDistrict() {
        return district;
    }


    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }


    public void setPopulation(int population) {
        this.population = population;
    }
}
