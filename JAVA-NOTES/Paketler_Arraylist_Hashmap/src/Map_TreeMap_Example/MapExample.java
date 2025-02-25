package Map_TreeMap_Example;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class MapExample {
    public static void main(String[] args) {
        // Ad ve notları tutan bir TreeMap oluşturuyoruz(Alfabetik sırlama için TreeMap kullandık)
        Map<String, Integer> studentGrades = new TreeMap<>();

        // Kullanıcıdan giriş almak için bir Scanner oluşturuyoruz
        Scanner scanner = new Scanner(System.in);

        // 3 öğrencinin bilgilerini alıyoruz
        System.out.println("3 öğrencinin adını ve notunu girin:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Öğrenci adı: ");
            String name = scanner.nextLine();

            System.out.print("Öğrenci notu: ");
            int grade = scanner.nextInt();
            scanner.nextLine(); // Boş satırı temizliyoruz

            // Veriyi TreeMap'e ekliyoruz
            studentGrades.put(name, grade);
        }

        // Alfabetik sıralanmış verileri yazdırıyoruz
        System.out.println("\nÖğrenci Notları (Alfabetik Sıra):");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        scanner.close();
    }
}
