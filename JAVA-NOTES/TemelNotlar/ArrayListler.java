package TemelNotlar;


import java.util.ArrayList;

	public class ArrayListler {

		public static void main(String[] args) {
			/*
			 * 
			  Java'da ArrayList, dinamik boyutlu bir liste veri yapısıdır ve java.util
			  paketinde bulunur. Sabit boyutlu dizilerden farklı olarak, ArrayList'in
			  boyutu çalışma zamanında otomatik olarak artabilir veya azalabilir. Bu,
			  özellikle elemanların sayısının önceden bilinmediği durumlarda faydalıdır.
			  
			  ArrayList'in Özellikleri
			  Dinamik Boyut:   Eleman eklendikçe kapasitesi otomatik olarak artar. 
			  Sıralı Depolama: Elemanlar eklendiği sırada saklanır. Rastgele
			  Erişim: Dizi gibi indeks kullanarak elemanlara erişebilirsiniz. 
			  Tek Tip Elemanlar: ArrayList bir generik (generic) sınıf olduğu için belirli bir veri tipiyle sınırlanabilir (örneğin, ArrayList<String>). 
			  İçerik Manipülasyonu: Listeye eleman ekleme, çıkarma veya değiştirme işlemleri kolaydır.
			  
			 */

			ArrayList<Integer> sayiListesi = new ArrayList<>();

			ArrayList<String> isimListesi = new ArrayList<>();

			isimListesi.add("Erkan");
			isimListesi.add("Aslı");
			
			sayiListesi.add(12);
			sayiListesi.add(5);
			
			System.out.println(isimListesi);
			
			System.out.println(sayiListesi);
			
			
			//______________________________________________
			
			 //Elemanlara Erişim
			 //get(index) metodu ile bir elemanı alabilirsiniz.


			 System.out.println("get ile alınan değer:  " + sayiListesi.get(1)); // Çıktı: 5
			 
			 
			//______________________________________________
			 
			 //Eleman Çıkarma
			 //remove(index) veya remove(Object) metodu kullanılır.


			 isimListesi.remove(0); // İlk elemanı çıkarır (Erkan)
			 
			//______________________________________________
			 
			 //Boyutu Öğrenme
			 //size() metodu ile mevcut eleman sayısını alabilirsiniz.


			 System.out.println("Size of sayiListesi: " + sayiListesi.size()); // Çıktı: 2
			 
			//______________________________________________
			 
			 //Eleman Kontrolü
			 //contains() metodu belirli bir elemanın var olup olmadığını kontrol eder.


			 System.out.println(isimListesi.contains("Muz")); // Çıktı: false
			 
			 
			 
			//______________________________________________
			 //Listeyi Döngüyle Gezme

			 for (int sayi : sayiListesi) {
			     System.out.println(sayi);
			 }
			 
			 		 
			//______________________________________________
			 //Listeyi Temizleme
			 //clear() metodu tüm elemanları siler.


			 sayiListesi.clear();
			 
			 System.out.println("==================================");
			 
			 
			 
			 //=======================================================================
			 
			 //Her Türden Eleman İçeren Bir ArrayList





			         // Heterojen bir ArrayList
			         ArrayList<Object> liste = new ArrayList<>();

			         // Farklı türden elemanlar ekleme
			         liste.add("Merhaba");  // String
			         liste.add(42);         // Integer
			         liste.add(3.14);       // Double
			         liste.add(true);       // Boolean
			         liste.add(new int[]{1, 2, 3}); // Dizi(dizinin sınıf adı ve hash kodu döner)

			         // Listeyi yazdırma
			         for (Object eleman : liste) {
			             System.out.println(eleman);
			         }

			         // Özel türler için "cast" gerekebilir
			         String metin = (String) liste.get(0);
			         System.out.println("İlk eleman (String): " + metin);
			     
			 

		}

	}


