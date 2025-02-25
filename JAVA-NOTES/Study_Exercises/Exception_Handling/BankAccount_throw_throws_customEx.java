package Study_Exercises.Exception_Handling;

// Özel bir istisna sınıfı tanımlıyoruz.
// Bu, bankacılık işlemleri sırasında oluşabilecek özel hataları temsil eder.
class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientFundsException(String message) { //Bu hata mesajını biz vereceğşz.
		super(message);
	}
}

public class BankAccount_throw_throws_customEx {
	private double balance;

	// Constructor
	public BankAccount_throw_throws_customEx(double balance) {
		this.balance = balance;
	}

	
	// Metot: Hesaptan para çekme işlemi.
	// Bu metot bir 'throws' ifadesi içeriyor çünkü 'InsufficientFundsException' adlı Checked Exception'ı fırlatabilir.
	public void withdraw(double amount) throws InsufficientFundsException {
		// Eğer bakiye çekmek istediğimiz miktardan azsa, özel istisna fırlatıyoruz.
		if (amount > balance) {
			// 'throw' anahtar kelimesi kullanılarak istisna fırlatılıyor.
			throw new InsufficientFundsException("Yetersiz bakiye. Çekmek istediğiniz miktar: " + amount);
		}
		balance -= amount;
		System.out.println("Başarılı işlem. Kalan bakiye: " + balance);
	}

	
	public static void main(String[] args) {
		// Yeni bir banka hesabı oluşturuyoruz.
		BankAccount_throw_throws_customEx account = new BankAccount_throw_throws_customEx(1000);

		// Try-catch bloğu içinde para çekme işlemi yapıyoruz.
		// Çünkü 'withdraw' metodu bir istisna fırlatabilir ve bunu yakalamamız
		// gerekiyor.
		try {
			account.withdraw(500); // İlk çekme işlemi, başarılı olacak.
			account.withdraw(600); // Bu çekme işlemi, istisna fırlatacaj
			
		} catch (InsufficientFundsException e) {
			// Fırlatılan özel istisnayı yakalayıp bir hata mesajı yazdırıyoruz.
			System.out.println("Hata: " + e.getMessage());
		}
	}
}
