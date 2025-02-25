package Threading;

// KronometreThread sınıfı, Runnable arayüzünü uygular. Bu, sınıfın bir thread'de çalıştırılabilecek bir görev olduğunu belirtir.
public class KronometreThread implements Runnable {

	private Thread thread; // Thread nesnesini temsil eden bir değişken.
	private String _threadName; // Thread'e verilen adı tutar.

	// Kurucu metot: Bu, sınıfın bir nesnesi oluşturulduğunda çağrılır.
	public KronometreThread(String threadName) {
		_threadName = threadName; // Parametre olarak alınan adı sınıf değişkenine atar.
		System.out.println("oluşturuluyor...: " + _threadName); // Thread'in oluşturulmakta olduğunu belirtir.
	}

	@Override
	public void run() {
		// Thread çalışmaya başladığında bu metot çalışır
		System.out.println("Çalıştırılıyor...." + _threadName);

		try {
			// Bir döngü içinde 1'den 4'e kadar sayıları ekrana yazdırır
			for (int i = 1; i < 5; i++) {
				System.out.println(_threadName + ": " + i); // Thread adıyla birlikte sayaç değerini ekrana yazdırır.
				Thread.sleep(1000); // Thread'i 1 saniye (1000 milisaniye) uyutur.
			}

		} catch (InterruptedException e) {
			// Eğer thread kesintiye uğrarsa (örneğin, başka bir thread tarafından
			// durdurulursa) bu blok çalışır
			System.out.println("Kesildi... : " + _threadName + e.getMessage());
		}

		// Döngü tamamlandıktan sonra, thread'in bittiğini belirtir
		System.out.println("Thread bitti: " + _threadName);
	}

	// Thread'i başlatan özel bir metot.
	public void startThread() {
		// Thread'in oluşturulduğunu belirtir.
		System.out.println("Thread Nesnesi oluşuyor..." + _threadName);

		// Eğer thread nesnesi henüz oluşturulmamışsa (null kontrolü yapılır), yeni bir
		// thread oluşturulur.
		if (thread == null) {
			thread = new Thread(this, _threadName); //
			/*
			 * -> new Thread(this, _threadName): - `this`: `Runnable` arayüzünü uygulayan
			 * mevcut sınıfın (KronometreThread) bir örneğini belirtir. Yani, bu sınıfın
			 * `run()` metodunun thread tarafından çağrılmasını sağlar. - `_threadName`:
			 * Oluşturulan thread'e bir ad verir
			 */

			thread.start(); // Thread'i çalıştırır. Bu, `run()` metodunun çağrılmasını sağlar.
		}
	}
}
