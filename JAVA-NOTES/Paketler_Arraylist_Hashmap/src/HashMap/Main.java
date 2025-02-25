package HashMap;

import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	/*
	 * Hash: Verilere hızlı erişim sağlamak için kullanılan bir yöntemdir. 
	 * HashMap: Anahtar-değer çiftleriyle çalışır, hızlı erişim sağlar. 
	 * HashSet: Benzersiz elemanlardan oluşan bir koleksiyondur. Bu yapıların hashing mekanizması
	 * sayesinde, büyük miktardaki verilere hızlı erişim ve işlem yapma imkânı
	 * sağlanır.
	 */

	public static void main(String[] args) {
		// HashMap oluşturma
		HashMap<String, String> countries = new HashMap<>(); // String, Int de olabilir...
		// Veri ekleme
		countries.put("TR", "Türkiye");
		countries.put("US", "Amerika");
		countries.put("FR", "Fransa");

		// Değere erişme
		System.out.println("TR kodu: " + countries.get("TR"));

		// Anahtarları ve değerleri yazdırma
		for (String key : countries.keySet()) // keyset() , hashmapte bulunan key setini ifade eder.
		{
			System.out.println("Anahtar: " + key + ", Değer: " + countries.get(key));
		}

		// Bir anahtarın varlığını kontrol etme
		if (countries.containsKey("FR")) {
			System.out.println("FR anahtarı mevcut.");
		}

		System.out.println("===========================================");
		System.out.println("Size of HashMap: " + countries.size());
		System.out.println("Keys of HashMap with keyset(): " + countries.keySet());
		System.out.println("Values of Hashmap with values(): " + countries.values());

		System.out.println("Tüm key-value çiftlerini döndürme");
		// Tüm key-value çiftlerini döndür
		for (Entry<String, String> entry : countries.entrySet()) {
			String key = entry.getKey(); // Anahtarı al
			String value = entry.getValue(); // Değeri al
			// System.out.println(countries.hashCode());
			// Key ve value'yu yazdır
			System.out.println("Key: " + key + ", Value: " + value);
		}

	}

	/*
	 * HashMap, Java'da bir "koleksiyon sınıfıdır" ve java.util paketinde bulunur.
	 * Anahtar-değer (key-value) çiftlerini depolamak için kullanılır. Her anahtar
	 * benzersizdir ve bir değere eşlenir. HashMap, anahtarların hızlı bir şekilde
	 * erişilmesini sağlamak için hashing mekanizmasını kullanır.
	 * 
	 * ======Özellikleri======
	 * 
	 * "Hızlı Erişim:" HashMap, O(1) zaman karmaşıklığında
	 * anahtarlar üzerinden verilere erişim sağlar (iyi bir hash fonksiyonu ile).
	 * "Sırasızdır:" HashMap, elemanları ekleme sırasına göre tutmaz. "Tekrar Eden
	 * Anahtarlar: Aynı anahtarı birden fazla kez eklemeye çalışırsanız, eski değer
	 * üzerine yazılır. "null Anahtar ve Değer:" Bir null anahtarına ve birden fazla
	 * null değerine izin verir.
	 */
}
