package StringBuilder_StringBuffer;

/*
 * 
 * StringBuilder, eşzamanlılık (thread-safety) gereksinimi olmayan uygulamalarda daha hızlı bir seçenek olarak kullanılır. 
 * Çünkü StringBuilder, thread-safe (çoklu iş parçacığına güvenli) değildir, 
 * yani birden fazla iş parçacığı aynı nesne üzerinde işlem yaparsa, sonuçlar tutarsız olabilir.

====================Özellikleri:======================

StringBuilder, `thread-safe` değildir.
StringBuilder, genellikle tek iş parçacıklı (single-threaded) uygulamalarda tercih edilir.
Daha hızlıdır çünkü StringBuffer'ın yaptığı eşzamanlılık kontrolü yoktur.

 * -----------------------------------------------------------------------
 *
 * StringBuffer, eşzamanlılık (thread-safety) gereksinimi olan uygulamalarda kullanılır. 
 * Yani birden fazla iş parçacığının aynı nesne üzerinde işlem yapması gerektiğinde StringBuffer tercih edilmelidir.

====================Özellikleri:======================

StringBuffer, thread-safe (çoklu iş parçacığına güvenlidir).
StringBuffer, paralel iş parçacığına sahip uygulamalarda kullanılır, ancak daha yavaş olabilir çünkü her işlemde eşzamanlılık kontrolü yapar.
 * */

public class StringBuilderStringBufferExample {

	
	
	
	
	
	public static void main(String[] args) {
		
		//StringBuilder
		StringBuilder sb = new StringBuilder("Merhaba");
		sb.append(" Dünya");
		sb.insert(7, "Java ");
		sb.replace(0, 6, "Selam");
		sb.delete(5, 10);

		System.out.println(sb); // Çıktı: Selam Java
		
		
		
		//StringBuffer
		StringBuffer sbf = new StringBuffer("Merhaba");
        sbf.append(" Dünya");
        sbf.insert(7, "Java ");
        sbf.replace(0, 6, "Selam");
        sbf.delete(5, 10);

        System.out.println(sbf);  // Çıktı: Selam Java
	}

}
