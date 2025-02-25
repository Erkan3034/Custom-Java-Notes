package ExceptionHandling;

public class Main {

	public static void main(String[] args) {
		// String sehir = "Ankara";
		// int sayı = sehir; //hata

		int sayılar[] = new int[] { 1, 2, 3 }; // Bu ksıımlar dinamik olarak gelir, o yüzden gelen veriye göre hata
												// yönetimi yapmamız lazım. 
		// System.out.println(sayılar[5]); // Runtime hata.

		// try-catch ile dizinin boyutunu aşan hatayı yakadık.
		try {
			System.out.println(sayılar[5]); 
		} 
		
		catch (ArrayIndexOutOfBoundsException exception) //Bu blok çalışır
		{
			System.out.println("İstenen değer bulunamadı! (' " + exception.getMessage() + " ')");
		}
		
		 catch (StringIndexOutOfBoundsException exception) 
		{
				System.out.println("İstenen değer bulunamadı! (' " + exception.getMessage() + " ')");
		}
		
		catch (Exception exception) {
			System.out.println("Bilinmeyen bir hata oluştu! Tekrar deneyin..."); // Bu catch bloğu diğer catch blokları çalışmazsa o zaman çalışacak.
		}
		
		
		finally // try ya da catch bloğundan hangisi çalışırsa çalışsın bu finally bloğu her
					// türlü çalışacak.!
		{
			System.out.println("This finally block runs whatever happen!");
		}

		/*
		 * finally bloğunu örneğin veritabanına ulaşmaya çalıştık, veritabanını açtık
		 * ama veri almada hata yaşadık. Bu durumda veri alsak da almasak da işlem
		 * sonunda veritabanını geri kapatmamız lazım. İşte burda finally bloğunu
		 * kullanmamız lazım(finally bloğu içerisine veri tabanı kapatmaa şlemlerini ekleriz).
		 */
	}

}
