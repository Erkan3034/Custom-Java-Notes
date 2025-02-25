package Threading;

public class Main {
	
	/*
	 * 
	 * -> Java'da threading, bir programın aynı anda birden fazla işlem veya görev gerçekleştirmesine olanak tanıyan bir paralel programlama tekniğidir.
	 * Thread'ler, bir Java uygulamasında eş zamanlı olarak çalışabilen, hafif ağırlıklı alt işlemler olarak tanımlanır. 
	 * 
	 * -> Multithreading, birden fazla thread'in aynı anda çalıştığı bir programlama modelidir ve daha iyi kaynak
	 * kullanımı, performans artışı ve daha hızlı işlem süresi sağlar.
	 * 
	 * 
	 * -> "Thread'lerin Özellikleri Bağımsızlık:" Thread'ler bir uygulamanın içinde
	 * bağımsız olarak çalışabilir. 
	 * -> Paylaşılan Bellek: Aynı süreç içindeki thread'ler, ortak belleği paylaşır. 
	 * Eşzamanlılık: Thread'ler aynı anda  çalışabilir, ancak işlemci çekirdekleri sayısıyla sınırlıdır.

	 * -> Durumlar: Thread'ler çeşitli durumlara sahip olabilir (New, Runnable, Running, Blocked,Terminated).
	 */

	public static void main(String[] args) {

		KronometreThread thread1 = new KronometreThread("Thread1");
		
		KronometreThread thread2 = new KronometreThread("Thread2");

		KronometreThread thread3 = new KronometreThread("Thread3");

		
		thread1.startThread();
		thread2.startThread();
		thread3.startThread();

	}

}
