package REGEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		// ===========================================================
		/*
		 * 
		 * Java'da regex (düzenli ifadeler), metin arama ve işleme için kullanılan güçlü
		 * bir araçtır. 
		 * Regex, belirli bir metin desenini tanımlamanıza olanak tanır.
		 * Java'da regex kullanımı genellikle java.util.regex paketindeki "Pattern" ve
		 * "Matcher" sınıfları ile gerçekleştirilir.
		 * 
		 * Aşağıda regex’in temel özelliklerini, sık kullanılan yapıları ve Java'daki
		 * kullanım örneklerini sade bir şekilde açıklayalım....
		 */

		// ========================================================================

		/*
		 * "1. Regex Temelleri": Regex, belirli bir metin desenini tanımlamak için kullanılır. 
		 * 
		 * Örneğin: 
		 * \d → Bir rakam (0-9) 
		 * 
		 * \w → Bir kelime karakteri (a-z,A-Z, 0-9, _) 
		 * 
		 * \s → Bir boşluk karakteri (space, tab, newline) 
		 * 
		 * . → Herhangi bir karakter (newlinehariç)
		 * 
		 * * , +, ? → Tekrarlama operatörleri:
		 * 
		 * 		* → Sıfır veya daha fazla tekrar. 
		 * 		+ → Bir veya daha fazla tekrar. 
		 * 		? → Sıfır veya bir tekrar.
		 * 
		 */

		// =========================================================================

		/*
		 * "Regex ile Java’da Kullanım":
		 *  'Pattern ve Matcher' Sınıfları Java’da regex kullanımında şu adımlar izlenir:
		 * 
		 * Deseni (pattern) tanımlarız: Pattern.compile() 
		 * Eşleşme (matcher) oluşturalım: pattern.matcher() 
		 * Sonuçları kontrol edelim: matcher.find(), matcher.matches(), vb.
		 */
		// =========================================================================
		
		//BASİT BİR ÖRNEK:
		    String metin = "Merhaba Erkan";
	        String desen = "Java"; // Aradığımız desen

	        Pattern pattern2 = Pattern.compile(desen); // deseni işle
	        Matcher matcher2 = pattern2.matcher(metin); //deseni eşle(ara)

	        if (matcher2.find()) {
	            System.out.println("Eşleşme bulundu!");
	        } else {
	            System.out.println("Eşleşme bulunamadı.");
	        }
		
	        
	    //=======================================
	        
	        
	        
	    /*
	     * "Sık Kullanılan Regex Yapıları"
	    _________________________________________________________ 
		| Yapı|	   | Açıklama	                   |Örnek|
	    ________________________________________________________
	    |														|
		| \d	    Rakam (0-9)	          			"123"		|
		| \D	    Rakam olmayan	      			"abc"		|
		| \w	    Kelime karakteri	   			"a1_b"		|
		| \W	    Kelime olmayan karakter			"#@"		|
		| \s	    Boşluk	            			" " (space) |
		| \S	    Boşluk olmayan					"abc"		|
		| ^			Metin başlangıcı				"^Hello"	|
		| $			Metin sonu						"World$"	|
		| .*		Herhangi bir karakter dizisi	"abc123"    |
		| [abc]		a, b veya c karakteri			"a"    		|
		| [^abc]	a, b, c dışındaki karakter		"d"    		|
		| [a-z]		Küçük harfler aralığı			"a"    		|
		| [A-Z]		Büyük harfler aralığı			"A"	   		|
		| [0-9]		Rakamlar aralığı				"5"    		|
		| `a	b`	a veya b							   		|
		| (abc)		Grup							"abc"  		|
	    |_______________________________________________________|
	    
	     * */
	        
	     //============E-MAIL DOGRULAMA============================
	        String email = "test@example.com";
	        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

	        if (email.matches(emailRegex)) {
	            System.out.println("Geçerli e-posta!");
	        } else {
	            System.out.println("Geçersiz e-posta!");
	        }
	        
        //=============Metindeki Rakamları Bulma====================
	        
	        String text5 = "Telefon numaram: 12345.";
	        Pattern pattern5 = Pattern.compile("\\d+"); //ARANACAK DEĞERLER.
	        Matcher matcher5 = pattern5.matcher(text5);

	        while (matcher5.find()) {
	            System.out.println("Bulunan rakam: " + matcher5.group()); //Bulunan rakamları grup halinde yazdır
	        }
	        
	        
	    //==============Telefon Numarası Doğrulama===================
	        String phone = "(555) 123-4567";
	        String phoneRegex = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";

	        if (phone.matches(phoneRegex)) {
	            System.out.println("Geçerli telefon numarasi");
	        } else {
	            System.out.println("Geçersiz telefom numarası: ");
	        }
	        
	    //===========================================================
	        
	        
	        
	        /*
	         * 	matches()       =>  Tüm metni desene göre eşleştirir 				 =>     "123".matches("\\d+")
				find()			=>	Metinde eşleşme arar							 =>	    matcher.find()
				group()			=>	Bulunan eşleşmeyi döner							 =>	    matcher.group()
				start() , end() =>	Eşleşmenin başlangıç ve bitiş indekslerini döner =>	    matcher.start()
				replaceAll()	=>	Eşleşen tüm metinleri değiştirir				 => 	text.replaceAll()

	         * 
	         */
	        
		// REGEX - Pattern _ Matcher

		Pattern pattern = Pattern.compile("Erkan", Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher("Hello Erkan!");

		boolean matchFound = matcher.find();

		if (matchFound) {
			System.out.println("Match found");
		} else {
			System.out.println("Match not found");
		}

		System.out.println("");
		// ========================================================================

		String text = "Erkan turgut is a software developer! in turgut Tech Company";

		Pattern pattern1 = Pattern.compile("turgut");
		Matcher matcher3 = pattern1.matcher(text);

		int sayac = 0;
		while (matcher3.find()) {
			sayac++;

		}
		System.out.println("Eşleşme bulundu! Eşleşme sayısı:  " + sayac + " " + matcher2);
		{

			System.out.println("Eşleşme bulunamadı!!");
		}

	}

}