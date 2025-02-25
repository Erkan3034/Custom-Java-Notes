package Strings;

import java.util.HashMap;

public class Stringler {

	public static void main(String[] args) {

		String s1 = "Java";
		String s2 = "Java";
		System.out.println(s1 == s2);

		String s3 = new String("Java");
		System.out.println(s1 == s3);

		System.out.println(s1.equals(s3));

		StringBuilder sBuilder = new StringBuilder("Hello");
		System.out.println(sBuilder.toString());
		sBuilder.append(" Dünya");
		System.out.println(sBuilder.toString());

		StringBuffer sBuilder2 = new StringBuffer("Hi");
		System.out.println(sBuilder2.toString());
		sBuilder2.append(" There");
		System.out.println(sBuilder2.toString());

		// PALİNDROMU
		String st = "KAYAK";

		String reversed = new StringBuilder(st).reverse().toString(); // tersini al stringe çevir.
		// System.out.println(reversed);

		if (st.equals(reversed)) {
			System.out.println("Palindromdur");
		} else {
			System.out.println("Palindrom değildir!!");
		}

		// =========================================================
		// 1. StringBuilder oluştur
		StringBuilder sb = new StringBuilder("Merhaba");

		// 2. Sonuna metin ekle
		sb.append(" Dünya");
		System.out.println("Append sonrası: " + sb); // Çıktı: Merhaba Dünya

		// 3. Belirli bir konuma metin ekle
		sb.insert(7, " Güzel");
		System.out.println("Insert sonrası: " + sb); // Çıktı: Merhaba Güzel Dünya

		// 4. Metni değiştir
		sb.replace(7, 13, "Sevgili");
		System.out.println("Replace sonrası: " + sb); // Çıktı: Merhaba Sevgili Dünya

		// 5. Belirli bir kısmı sil
		sb.delete(7, 15);
		System.out.println("Delete sonrası: " + sb); // Çıktı: Merhaba Dünya

		// 6. Ters çevir
		sb.reverse();
		System.out.println("Reverse sonrası: " + sb); // Çıktı: ayınD abahreM

		// Parçalama
		String str1 = "Java,Python,C#,F#";
		String[] languages = str1.split(",");
		for (String lang : languages) {
			System.out.println(lang);
		}

		// Frekans bulma.
		String str3 = "Java programlama";
		HashMap<Character, Integer> frequency = new HashMap<>();

		for(char ch :str3.toCharArray()) //karakter dizisi oluşturma
		{
			frequency.put(ch,frequency.getOrDefault(ch, 0)+1);
			
		}System.out.println(frequency);
		
		//Length bulma:
		
		System.out.println("String uzunluğu: " +str3.length());
		System.out.println("İndex : " +str3.charAt(5));
		
		
		//SubString:
		
		String str4 = str3.substring(5,12);
		System.out.println("Substring ile alınan metin parçası: " + str4);
		
		
		//=========METOTLAR========================
		System.out.println("_________________GENEL METOTLAR____________________");
		String str = "Merhaba Dünya";

        // 1. charAt() - Belirli bir indexteki karakteri döner.
        System.out.println(str.charAt(0)); // Çıktı: M
        

        // 2. codePointAt() - Belirli indexteki Unicode kod noktasını döner.
        System.out.println(str.codePointAt(0)); // Çıktı: 77 (M'nin Unicode değeri)
        

        // 3. codePointBefore() - Belirtilen indexin bir öncesindeki Unicode değerini döner.
        System.out.println(str.codePointBefore(1)); // Çıktı: 77 (M'nin Unicode değeri)

        
        // 4. codePointCount() - İki index arasındaki Unicode kod noktası sayısını döner.
        System.out.println(str.codePointCount(0, 7)); // Çıktı: 7

        
        // 5. compareTo() - Alfabetik olarak karşılaştırır (büyük-küçük harf duyarlı).
        System.out.println("A".compareTo("B")); // Çıktı: -1

        
        // 6. compareToIgnoreCase() - Büyük-küçük harf farkını dikkate almaz.
        System.out.println("A".compareToIgnoreCase("a")); // Çıktı: 0

        
        // 7. concat() - İki string'i birleştirir.
        System.out.println(str.concat("!")); // Çıktı: Merhaba Dünya!

        
        // 8. contains() - Belirtilen alt string'i içerip içermediğini kontrol eder.
        System.out.println(str.contains("Dünya")); // Çıktı: true

        // 9. contentEquals() - İçeriklerin aynı olup olmadığını kontrol eder.
        System.out.println(str.contentEquals("Merhaba Dünya")); // Çıktı: true

        // 10. copyValueOf() - Karakter dizisini string'e dönüştürür.
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        System.out.println(String.copyValueOf(chars)); // Çıktı: Hello

        // 11. endsWith() - String'in belirli bir sonla bitip bitmediğini kontrol eder.
        System.out.println(str.endsWith("Dünya")); // Çıktı: true

        // 12. equals() - String'lerin eşit olup olmadığını kontrol eder.
        System.out.println(str.equals("Merhaba Dünya")); // Çıktı: true

        // 13. equalsIgnoreCase() - Büyük/küçük harf farkını dikkate almadan karşılaştırır.
        System.out.println(str.equalsIgnoreCase("merhaba dünya")); // Çıktı: true

        // 14. format() - Formatlanmış string oluşturur.
        System.out.println(String.format("Merhaba %s", "Dünya")); // Çıktı: Merhaba Dünya

        // 15. getBytes() - String'i byte dizisine dönüştürür.
        byte[] bytes = str.getBytes();
        System.out.println(bytes.length); // Çıktı: 13 (bayt sayısı)

        // 16. getChars() - Belirli bir aralıktaki karakterleri kopyalar.
        char[] charArray = new char[5];
        str.getChars(0, 5, charArray, 0);
        System.out.println(charArray); // Çıktı: Merha

        
        
        // 17. hashCode() - String'in hash kodunu döner.
        System.out.println(str.hashCode());

        
        
        // 18. indexOf() - Belirli bir karakterin/dizenin ilk bulunduğu yeri döner.
        System.out.println(str.indexOf("a")); // Çıktı: 4

        
        
        // 19. intern() - String'i string havuzuna ekler.
        String interned = str.intern();
        System.out.println(interned); // Çıktı: Merhaba Dünya

        
        
        // 20. isEmpty() - String'in boş olup olmadığını kontrol eder.
        System.out.println(str.isEmpty()); // Çıktı: false
        
        

        // 21. join() - Belirtilen ayırıcıyla stringleri birleştirir.
        System.out.println(String.join("-", "Java", "NIO", "Files")); // Çıktı: Java-NIO-Files

        
        // 22. lastIndexOf() - Belirli bir karakterin/dizenin son bulunduğu yeri döner.
        System.out.println(str.lastIndexOf("a")); // Çıktı: 10

        
        // 23. length() - String'in uzunluğunu döner.
        System.out.println(str.length()); // Çıktı: 13

        
        // 24. matches() - Regex ile eşleşip eşleşmediğini kontrol eder.
        System.out.println(str.matches(".*Dünya.*")); // Çıktı: true

        
        // 25. offsetByCodePoints() - Belirli bir kod noktası offset'ini döner.
        System.out.println(str.offsetByCodePoints(0, 5)); // Çıktı: 5
        

        // 26. regionMatches() - Belirtilen iki bölgenin eşleşip eşleşmediğini kontrol eder.
        System.out.println(str.regionMatches(8, "Dünya Merhaba", 0, 5)); // Çıktı: true

        
        // 27. replace() - Alt string'i başka bir string ile değiştirir.
        System.out.println(str.replace("Dünya", "Java")); // Çıktı: Merhaba Java

        
        // 28. replaceAll() - Regex ile eşleşen tüm kısımları değiştirir.
        System.out.println(str.replaceAll("a", "@")); // Çıktı: Merh@b@ Düny@

        
        // 29. replaceFirst() - Regex ile eşleşen ilk kısmı değiştirir.
        System.out.println(str.replaceFirst("a", "@")); // Çıktı: Merh@ba Dünya

        
        // 30. split() - Regex kullanarak string'i böler.
        String[] parts = str.split(" ");
        System.out.println(parts[1]); // Çıktı: Dünya
        

        // 31. startsWith() - String'in belirli bir dizgeyle başlayıp başlamadığını kontrol eder.
        System.out.println(str.startsWith("Merhaba")); // Çıktı: true
        

        // 32. subSequence() - Belirli bir aralığı döner (substring'e benzer).
        System.out.println(str.subSequence(0, 7)); // Çıktı: Merhaba

        
        // 33. substring() - Belirli bir aralığı döner.
        System.out.println(str.substring(8, 13)); // Çıktı: Dünya

        
        // 34. toCharArray() - String'i bir karakter dizisine dönüştürür.
        char[] charArr = str.toCharArray();
        System.out.println(charArr[0]); // Çıktı: M
        

        // 35. toLowerCase() - Tüm karakterleri küçük harfe çevirir.
        System.out.println(str.toLowerCase()); // Çıktı: merhaba dünya

        
        // 36. toString() - String'in kendisini döner.
        System.out.println(str.toString()); // Çıktı: Merhaba Dünya
        

        // 37. toUpperCase() - Tüm karakterleri büyük harfe çevirir.
        System.out.println(str.toUpperCase()); // Çıktı: MERHABA DÜNYA
        

        // 38. trim() - Baş ve sondaki boşlukları kaldırır.
        System.out.println("  Merhaba Dünya  ".trim()); // Çıktı: Merhaba Dünya

        
        // 39. valueOf() - Farklı türleri string'e dönüştürür.
        System.out.println(String.valueOf(123)); // Çıktı: 123
        
        
		
	}

}
