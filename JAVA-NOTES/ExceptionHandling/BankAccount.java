 package ExceptionHandling;

import java.util.Scanner;

public class BankAccount {
	
	
	
	

	private double balance; // Hesap bakiyesi

	// Constructor: Başlangıç bakiyesini ayarlıyor
	public BankAccount(double initialBalance) { 
		if (initialBalance < 0) {
			// Eğer başlangıç bakiyesi negatifse hata fırlatılır
			throw new IllegalArgumentException("Başlangıç bakiyesi negatif olamaz!"); //Hata kontrolü.
		}
		this.balance = initialBalance;
	}
	
	
	
	
	

	// Para çekme metodu
	public void withdraw(double amount) throws BalanceInsufficentException {// throws ifadesi  Bu metodun bildiriminde, bu metot tarafından fırlatılabilecek istisnaları belirtir.(Custom EXCEPTION.)
		// Çekilmek istenen miktar negatif olamaz
		if (amount <= 0) {
			throw new IllegalArgumentException("Çekilecek miktar sıfır veya negatif olamaz!");
		}

		/*
		 * // Eğer hesap bakiyesi yeterli değilse hata fırlatılır
		 * 
		 * 
		 * 
		 * if (amount > balance) { throw new
		 * IllegalArgumentException("Yetersiz bakiye! Çekim işlemi başarısız."); }
		 * 
		 * 
		 * 
		 */
		// İşlem başarılıysa bakiye güncellenir

		if (amount > balance) {
			throw new BalanceInsufficentException("Yetersiz Bakiye!. Çekilmek istenen tutar: " +amount  +" (Mevcut Bakiyeniz: "+ getBalance() +")"); //throw: Belirli bir istisna fırlatmak için kullanılır.
		}
		balance -= amount;
		System.out.printf("Başarılı işlem! Çekilen tutar: %.2f  Kalan bakiye: %.2f%n", amount, balance);
	}

	
	
	
	
	
	
	// Hesap bakiyesini görüntüleme metodu
	public double getBalance() {
		return balance;
	}

	
	
	public static void main(String[] args) {
		// Yeni bir hesap oluşturuluyor
		BankAccount myAccount = new BankAccount(500); // Başlangıç bakiyesi: 500
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Çekmek istediğiniz tutar: ");
		int withdrawAmount = scanner.nextInt();
		
		
		
		try {
			System.out.println("Mevcut bakiye: " + myAccount.getBalance());

			
			
			try {
			
				myAccount.withdraw(withdrawAmount); // 880 çekiliyor
			} catch (BalanceInsufficentException e) {
				System.out.println(e.getMessage());
			}

			
			
			try {
				myAccount.withdraw(600); // Yetersiz bakiye hatası fırlatılacak

			} catch (BalanceInsufficentException e) {
				System.out.println(e.getMessage());
			}
			
			

		} 
		
		
		catch (IllegalArgumentException e) {
			// Fırlatılan hatalar burada yakalanır ve mesajı ekrana yazdırılır
			System.out.println("Hata: " + e.getMessage());
		}

		System.out.println("Program devam ediyor...");
		
		
		scanner.close();
	}
	
	
	
	
	
}
