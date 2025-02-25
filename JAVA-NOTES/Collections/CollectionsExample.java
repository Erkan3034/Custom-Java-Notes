package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CollectionsExample {

	/*
	 * -> Collections.reverse(list):  Listeyi tersine çevirir. 
	 * 
	 * ->Collections.shuffle(list):   Listeyi rastgele karıştırır. 
	 * 
	 * ->Collections.sort(list):      Listeyi doğal sıralamaya göre sıralar (örneğin alfabetik). 
	 * 
	 * ->Collections.max(list) ve Collections.min(list): Liste içindeki en büyük ve en küçük elemanları bulur. 
	 * 
	 * -> Collections.frequency(list, "Elma"):Belirli bir elemanın listede kaç kez geçtiğini sayar.
	 * 
	 * -> Collections.copy(destinationList, sourceList): Bir listeden diğerine
	 * elemanları kopyalar. 
	 * 
	 * -> Collections.swap(list, 1, 3): Belirtilen indekslerdeki elemanları yer değiştirir.
	 */

	public static void main(String[] args) {

		sıklıkBul();
		kesisimBul();
		
		System.out.println();
		
		
        int[] array = {1, 2, 3, 2, 1}; // Kontrol edilecek dizi
        if (isPalindrome(array)) {
            System.out.println("Dizi bir palindromdur.");
        } else {
            System.out.println("Dizi bir palindrom değildir.");
        }

		System.out.println("___________________________________________________________________________________");

		// 1. Listeyi oluştur
		List<String> list = new ArrayList<>();
		list.add("Elma");
		list.add("Armut");
		list.add("Muz");
		list.add("Kiraz");
		list.add("Çilek");
		list.add("Elma"); // Tekrar eden eleman

		System.out.println("Orijinal liste: " + list);

		// 2. Listeyi ters çevir
		Collections.reverse(list);
		System.out.println("Ters çevrilmiş liste: " + list);

		// 3. Listeyi rastgele karıştır
		Collections.shuffle(list);
		System.out.println("Karıştırılmış liste: " + list);

		// 4. Listeyi sıralar (doğal sıralama)
		Collections.sort(list);
		System.out.println("Sıralanmış liste: " + list);

		// 5. Liste içerisindeki en büyük ve en küçük elemanları bul
		String max = Collections.max(list);
		String min = Collections.min(list);
		System.out.println("En büyük eleman: " + max);
		System.out.println("En küçük eleman: " + min);

		// 6. 'Elma' kelimesinin kaç kez geçtiğini bul
		int frequency = Collections.frequency(list, "Elma");
		System.out.println("'Elma' kelimesi listede " + frequency + " kez geçiyor.");

		// 7. Listeyi kopyalama (yeni bir liste oluşturup elemanları kopyala)
		List<String> copiedList = new ArrayList<>(list); // Kopyalamak istediğimiz listeyi yeni listeye parametre olarak
															// gönderdik.
		System.out.println("Kopyalanmış liste: " + copiedList);

		// 8. Elemanları yer değiştirme (örneğin 1. ve 3. elemanı yer değiştir)
		Collections.swap(list, 1, 3);
		System.out.println("Yer değiştirilmiş liste: " + list);

		// 9. Listeyi tekrar sıralama
		Collections.sort(list);
		System.out.println("Yine sıralanmış liste: " + list);
	}

	public static void sıklıkBul() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(15);
		arrayList.add(45);
		arrayList.add(15);
		arrayList.add(75);
		arrayList.add(85);
		arrayList.add(15);
		arrayList.add(125);
		arrayList.add(445);
		arrayList.add(135);
		arrayList.add(475);

		int frekans = 0;

		/*
		 * for(int eleman:arrayList) { if (eleman ==15) { frekans +=1; } }
		 */

		for (Integer item : arrayList) {
			if (item.equals(15)) {
				frekans++;
			}
		}
		System.out.printf("Eleman(15) listede %d kere geçiyor.", frekans);
		System.out.println();

		Collections.sort(arrayList); // Sıralama.

		System.out.println("Sıralanmış liste: " + arrayList);

		
		
		HashSet<Integer> hashSet = new HashSet<Integer>(arrayList); // Benzersiz liste olışturma
		System.out.println("Hashset ile unique edilmiş liste: " + hashSet);

		System.out.println("_______________________________________________");

	}

	public static void kesisimBul() {
		// İlk koleksiyon
		List<String> list1 = new ArrayList<>();
		list1.add("Elma");
		list1.add("Armut");
		list1.add("Muz");
		list1.add("Kiraz");
		list1.add("Çilek");

		// İkinci koleksiyon
		List<String> list2 = new ArrayList<>();
		list2.add("Elma");
		list2.add("Muz");
		list2.add("Çilek");

		System.out.println("Orijinal list1: " + list1);
		System.out.println("list2: " + list2);

		// list1 üzerinde retainAll() metodunu çağır
		list1.retainAll(list2); //retainAll() kesişim alır.

		System.out.println("---->list1 ve list2'nin kesişimi: " + list1);
	}

	public static boolean isPalindrome(int[] array) {
		int left = 0;
		int right = array.length - 1;
        //1,2,3,2,1
		while (left < right) {
			if (array[left] != array[right]) {
				return false; // Eğer bir eleman eşleşmiyorsa, dizi palindrom değildir
			}
			left++;
			right--;
		}

		return true; // Eğer tüm elemanlar eşleştiyse, dizi palindromdur
	}

}
