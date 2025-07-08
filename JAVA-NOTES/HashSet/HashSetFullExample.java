package HashSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetFullExample {
    public static void main(String[] args) {
    	
    	arrayListHashSetYazdırma();
    	System.out.println("______/______/______/____/______/_______/________/______/______/____/_____");
    	
    	
        // 1.) HashSet oluşturma (String türünde elemanlar tutacak)
        HashSet<String> hashSet = new HashSet<>();

        // 2.) Eleman ekleme
        hashSet.add("Java");        // "Java" eklenir.
        hashSet.add("Python");      // "Python" eklenir.
        hashSet.add("C++");         // "C++" eklenir.
        hashSet.add("JavaScript");  // "JavaScript" eklenir.
	hashSet.add("React");

        // 3.) Aynı eleman eklenmeye çalışılır
        hashSet.add("Java"); // "Java" zaten olduğu için eklenmez.

        // 4.) null değer eklenir
        hashSet.add(null); // null değeri eklenir. HashSet sadece bir tane null tutar.

        // 5.) HashSet içeriğini yazdırma
        System.out.println("HashSet içeriği: " + hashSet);
        // Sırasız olduğunu görebiliriz (elemanlar eklenme sırasına göre depolanmaz).
        System.out.println("________________________________________________________________");

        // 6. Eleman kontrolü
        boolean containsPython = hashSet.contains("Python"); // "Python" var mı?
        System.out.println("Python içeriyor mu?('contains()'): " + containsPython);
		System.out.println();
        // 7. Eleman kaldırma
        hashSet.remove("C++"); // "C++" elemanı çıkarılır.
        System.out.println("C++ çıkarıldıktan sonra HashSet('remove()'): " + hashSet);
        System.out.println();
        // 8. HashSet'in boyutunu öğrenme
        int size = hashSet.size();
        System.out.println("HashSet'in boyutu('size()'): " + size);
        System.out.println();
        // 9. Boş kontrolü
        boolean isEmpty = hashSet.isEmpty(); // HashSet boş mu?
        System.out.println("HashSet boş mu?('isEmpty()') " + isEmpty);
        System.out.println();
        // 10. Tüm elemanları döngüyle yazdırma

        // 10.1 For-each döngüsü ile yazdırma
        System.out.println("\nFor-each döngüsüyle elemanlar:");
        for (String eleman : hashSet) {
            System.out.println(eleman);
        }
        System.out.println();
        // 10.2 Iterator ile yazdırma
        System.out.println("\nIterator ile elemanlar:");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        // 11. Tüm elemanları temizleme
        hashSet.clear(); // HashSet'teki tüm elemanları kaldırır.
        System.out.println("\nHashSet temizlendikten sonra boş mu? " + hashSet.isEmpty());
    }
    
    
    //=========================================================================================================================================
    
    
    public static void arrayListHashSetYazdırma() {
    	
    	
    	ArrayList<Integer> setArrayList = new ArrayList<Integer>();
    	
    	setArrayList.add(1);
    	setArrayList.add(-45);
    	setArrayList.add(14);
    	setArrayList.add(54);
    	setArrayList.add(85);
    	setArrayList.add(85);
    	setArrayList.add(44);
    	
    	
    	HashSet<Integer> elemanlarHashSet = new HashSet<Integer>(setArrayList); //ArrayListteki tekrar eden elemanları hashset ile engelliyoruz.
    	
    	//Elemanları hashset ile yazdırma.
    	System.out.println("Elemanları hashset ile yazdırma: ");
    	for(Integer elemanInteger : elemanlarHashSet) {
    		System.out.println(elemanInteger);
    	}
    }
    
  //=========================================================================================================================================
    /*
     * HashSet, Java'da koleksiyon (collection) yapılarından biridir ve Set arayüzünü uygular. 
     * Elemanları "benzersiz şekilde depolar ve sıralama garantisi sağlamaz." Arka planda, elemanları depolamak için bir HashMap kullanır.
     * 
     */
    
}



