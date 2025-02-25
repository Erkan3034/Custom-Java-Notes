package FilesNotes;

import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class NioFileExample {
    public static void main(String[] args) {
        // 1. Path nesnesi oluştur
        Path filePath = Paths.get("example.txt");
        Path copiedFilePath = Paths.get("example_copy.txt");

        try {
            // 2. Dosya oluştur
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                System.out.println("Dosya oluşturuldu: " + filePath);
            } else {
                System.out.println("Dosya zaten mevcut: " + filePath);
            }

            // 3. Dosyaya içerik yaz
            String content = "Merhaba, java.nio.file kullanıyoruz!";
            Files.write(filePath, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("Dosyaya içerik yazıldı.");

            // 4. Dosyayı oku
            String fileContent = Files.readString(filePath, StandardCharsets.UTF_8);
            System.out.println("Dosya içeriği: " + fileContent);

            // 5. Dosyayı başka bir konuma kopyala
            Files.copy(filePath, copiedFilePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Dosya kopyalandı: " + copiedFilePath);

            // 6. Orijinal dosyayı sil
            Files.delete(filePath);
            System.out.println("Orijinal dosya silindi.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
