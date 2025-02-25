package Generics;

/*
Java'da Generics (Tür Belirleyiciler), kodumuzda kullanılan türleri daha esnek, okunabilir ve 
güvenli hale getiren bir özelliktir. 
Generics, Java’nın 5.0 sürümünde tanıtılmıştır ve genelde koleksiyonlarla birlikte kullanılır. 
Generics, sınıf - metot veya koleksiyonların, belirli bir türle çalışmasını sağlayan bir özelliktir. 
Böylece veri türlerini çalıştırmadan önce kontrol edebiliriz (type-safety) ve tip dönüşümlerini azaltabiliriz.

Tip Dönüşümü Gerekmez: Tür dönüştürme işlemlerine gerek kalmadan türle çalışabilirsiniz.
*
*/

//-------> Generics, parametreli türler anlamına gelir
public class Generic {

	public static void main(String[] args) {

		/*
		 * //Generics Olmadan: ArrayList list = new ArrayList(); list.add("Merhaba");
		 * String s = (String) list.get(0); System.out.println(s);
		 * 
		 */

		Printer<Integer> integerPrinter = new Printer<Integer>(25); // Parametre olarak Integer verdik
		integerPrinter.printThing();

		Printer<Double> doubPrinter = new Printer<Double>(15.5); // Parametre olarak Double verdik.
		doubPrinter.printThing();

		Printer<String> stringPrinter = new Printer<String>("Erkan TURGUT"); // Parametre olarak String verdik.
		stringPrinter.printThing();

		
		//!!! GENERİCLER küçük harfle başlayan primitive değişkenlerle çalışmaz(int,double,float...) !!!
		
	}
}
