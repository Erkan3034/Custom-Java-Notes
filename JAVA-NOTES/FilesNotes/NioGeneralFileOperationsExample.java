package FilesNotes;

import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NioGeneralFileOperationsExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ERKAN TURGUT\\OneDrive\\Masaüstü\\JavaClassNotes\\MyPersonalNotes\\example_general.txt";
        String content = "NIO ile genel dosya işlemleri örneği.";

        try {
            // Dosya oluştur ve yaz
            Files.write(Paths.get(filePath), content.getBytes(StandardCharsets.UTF_8));
            
            System.out.println("Dosya oluşturuldu ve yazıldı: " + filePath);
            // Dosya içeriğini oku
            String readContent = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            System.out.println("Dosya içeriği: " + readContent);

            // Dosya satırlarını oku
            Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(System.out::println);

            // Dosya ismini değiştir
            Path source = Paths.get(filePath);
            Path target = Paths.get("renamed_example.txt");
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Dosya yeniden adlandırıldı: " + target);

            // Dosyayı sil
            //Files.delete(target);
            //System.out.println("Dosya silindi: " + target);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
