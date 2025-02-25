package Example1;

import java.sql.Statement; // SQL komutlarını çalıştırmak için kullanılır.
import java.util.ArrayList;
import java.sql.Connection; // Veritabanı bağlantısını temsil eder.
import java.sql.PreparedStatement;
import java.sql.ResultSet; // SQL sorgularının sonuçlarını saklar.
import java.sql.SQLException; // Veritabanı işlemlerinde oluşabilecek hataları yönetmek için kullanılır.

public class Main {

	public static void main(String[] args) throws SQLException {
		
		//insertDemo(); // Yeni kayıt ekleme
		deleteDemo();
		//UpdateData();
		

	}

	public static void insertDemo() throws SQLException {

		// Bağlantı oluşturmak için kullanılan nesne.
		Connection connection = null;

		// Veritabanı yardımcı sınıfı, bağlantı ve hata yönetimi işlemleri için
		// kullanılır.
		DbHelper helper = new DbHelper();

		// SQL komutlarını çalıştırmak için kullanılır.
		PreparedStatement statement = null;

		// SQL sorgularının sonuçlarını saklayan nesne.
		ResultSet resultSet;

		try {
			// helper.getConnection() ile veritabanı bağlantısı oluşturulur.
			connection = helper.getConnection();

			String sql = "INSERT into city (Name,CountryCode,District,Population) values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "ANTEP");
			statement.setString(2, "TUR");
			statement.setString(3, "TURKEY");
			statement.setInt(4, 450000);
			
			
			
			//statement = connection.prepareStatement("INSERT into city (Name,CountryCode,District,Population) values('GEWER','TUR','GEWER',80000);");
			int result = statement.executeUpdate();

			ArrayList<Country> countries = new ArrayList<Country>(); // ResultSet'i nesneye aktarma işlemi.

			System.out.println("Kayıt Başarıyla eklendi!!"); // kontrol.

			// Veritabanı bağlantısının başarılı olduğunu belirten mesaj.
			System.out.println("Veritabanı bağlantısı sağlandı!");

		} catch (SQLException exception) {
			// Veritabanı hataları varsa, helper.showError() ile hata mesajı yazdırılır.
			helper.showError(exception);
		} finally {

			// Kaynakları serbest bırakmak için bağlantı kapatılır.
			if (connection != null) {
				connection.close(); // Bağlantıyı kapatır.
			}
			// Statement nesnesini kapatır.
			if (statement != null) {
				statement.close();
			}
			// Bir hata olmasın diye tekrar kontrol edilerek bağlantı kapatılır.
			if (connection != null) {
				connection.close();
			}
		}
	}

	
	
	// Select işlemleri.
	public static void selectDemo() throws SQLException {

		// Bağlantı oluşturmak için kullanılan nesne.
		Connection connection = null;

		// Veritabanı yardımcı sınıfı, bağlantı ve hata yönetimi işlemleri için
		// kullanılır.
		DbHelper helper = new DbHelper();

		// SQL komutlarını çalıştırmak için kullanılır.
		Statement statement = null;

		// SQL sorgularının sonuçlarını saklayan nesne.
		ResultSet resultSet;

		try {
			// helper.getConnection() ile veritabanı bağlantısı oluşturulur.
			connection = helper.getConnection();

			// SQL komutlarını çalıştırmak için bir Statement nesnesi oluşturulur.
			statement = connection.createStatement();

			// Veritabanında "country" tablosundan "Code", "Name", "Continent", ve "Region"
			// sütunlarını seçen sorgu.
			resultSet = statement.executeQuery("SELECT Code, Name, Continent, Region FROM country");

			ArrayList<Country> countries = new ArrayList<Country>(); // ResultSet'i nesneye aktarma işlemi.

			// resultSet içindeki veriler satır satır okunur.
			while (resultSet.next()) {
				// Her satırdaki "Name" sütunundaki veriyi yazdırır.
				// System.out.println(resultSet.getString("Name"));

				countries.add(new Country(resultSet.getString("Code"), resultSet.getString("Name"),
						resultSet.getString("Continent"), resultSet.getString("region")));
			}
			System.out.println(countries.size() + " Tane veri ResultSetten nesneye aktarıldı...."); // kontrol.

			// Veritabanı bağlantısının başarılı olduğunu belirten mesaj.
			System.out.println("Veritabanı bağlantısı sağlandı!");

		} catch (SQLException exception) {
			// Veritabanı hataları varsa, helper.showError() ile hata mesajı yazdırılır.
			helper.showError(exception);
		} finally {
			// Kaynakları serbest bırakmak için bağlantı kapatılır.
			if (connection != null) {
				connection.close(); // Bağlantıyı kapatır.
			}
			// Statement nesnesini kapatır.
			if (statement != null) {
				statement.close();
			}
			// Bir hata olmasın diye tekrar kontrol edilerek bağlantı kapatılır.
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	
	
	public static void UpdateData() throws SQLException {
		// Bağlantı oluşturmak için kullanılan nesne.
		Connection connection = null;

		// Veritabanı yardımcı sınıfı, bağlantı ve hata yönetimi işlemleri için
		// kullanılır.
		DbHelper helper = new DbHelper();

		// SQL komutlarını çalıştırmak için kullanılır.
		PreparedStatement statement = null;

		// SQL sorgularının sonuçlarını saklayan nesne.
		ResultSet resultSet;

		try {
			// helper.getConnection() ile veritabanı bağlantısı oluşturulur.
			connection = helper.getConnection();

			String sql = "Update city set Population = 25000 ,district = 'ANTEP' Where name = 'ANTEP' ";
			statement = connection.prepareStatement(sql);
			
			int result = statement.executeUpdate();

			ArrayList<Country> countries = new ArrayList<Country>(); // ResultSet'i nesneye aktarma işlemi.

			System.out.println("Kayıt güncellendi!"); // kontrol.

			// Veritabanı bağlantısının başarılı olduğunu belirten mesaj.
			System.out.println("Veritabanı bağlantısı sağlandı!");

		} catch (SQLException exception) {
			// Veritabanı hataları varsa, helper.showError() ile hata mesajı yazdırılır.
			helper.showError(exception);
		} finally {

			// Kaynakları serbest bırakmak için bağlantı kapatılır.
			if (connection != null) {
				connection.close(); // Bağlantıyı kapatır.
			}
			// Statement nesnesini kapatır.
			if (statement != null) {
				statement.close();
			}
			// Bir hata olmasın diye tekrar kontrol edilerek bağlantı kapatılır.
			if (connection != null) {
				connection.close();
			}
		}
		
	}
	
	
	
	
	public static void deleteDemo() throws SQLException {
		
		// Bağlantı oluşturmak için kullanılan nesne.
		Connection connection = null;

		// Veritabanı yardımcı sınıfı, bağlantı ve hata yönetimi işlemleri için
		// kullanılır.
		DbHelper helper = new DbHelper();

		// SQL komutlarını çalıştırmak için kullanılır.
		PreparedStatement statement = null;

		// SQL sorgularının sonuçlarını saklayan nesne.
		ResultSet resultSet;

		try {
			// helper.getConnection() ile veritabanı bağlantısı oluşturulur.
			connection = helper.getConnection();

			String sql = "DELETE FROM city Where id = ? ";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 120517);
			
			int result = statement.executeUpdate();

			ArrayList<Country> countries = new ArrayList<Country>(); // ResultSet'i nesneye aktarma işlemi.

			System.out.println("Kayıt silindi!"); // kontrol.

			// Veritabanı bağlantısının başarılı olduğunu belirten mesaj.
			System.out.println("Veritabanı bağlantısı sağlandı!");

		} catch (SQLException exception) {
			// Veritabanı hataları varsa, helper.showError() ile hata mesajı yazdırılır.
			helper.showError(exception);
		} finally {

			// Kaynakları serbest bırakmak için bağlantı kapatılır.
			if (connection != null) {
				connection.close(); // Bağlantıyı kapatır.
			}
			// Statement nesnesini kapatır.
			if (statement != null) {
				statement.close();
			}
			// Bir hata olmasın diye tekrar kontrol edilerek bağlantı kapatılır.
			if (connection != null) {
				connection.close();
			}
		}
	}
}
