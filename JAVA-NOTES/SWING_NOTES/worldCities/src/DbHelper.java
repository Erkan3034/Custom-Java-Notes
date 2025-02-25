import java.sql.*; // Veritabanı bağlantısı ve SQL işlemleri için gerekli kütüphane importu

// Veritabanı işlemlerini yönetmek için yardımcı sınıfımız
public class DbHelper {
    
    // Veritabanı kullanıcı adı
    private final String userName = "root"; 
    
    // Veritabanı kullanıcı şifresi
    private final String password = "Erkan1205/*-+";
    
    // Veritabanı bağlantı URL'si
    // "world" veritabanına bağlanmak için MySQL bağlantı adresi kullanılacaak
    // useSSL=false -> SSL kullanılmadan işleme devam et
    // serverTimezone=UTC -> Sunucunun zaman dilimi belirtilir(pc de farklı olabiir)
    private final String dbUrl = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
    
    // Veritabanı bağlantısını alan metot
    public Connection getConnection() throws SQLException {
        // DriverManager sınıfını kullanarak bağlantı oluşturma
        return DriverManager.getConnection(dbUrl, userName, password);
    }
    
    // SQL hatalarını gösteren method
    public void showErrorMessage(SQLException exception) {
        // Hata mesajını konsola yazdır
        System.out.println("ERROR: " + exception.getMessage());
        // Hatanın MySQL hata kodunu yazdır
        System.out.println("Error code: " + exception.getErrorCode());
    }
}
