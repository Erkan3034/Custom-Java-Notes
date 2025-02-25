package matematik;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int sayı1, sayı2;
		System.out.print("Sayı1: ");
		sayı1 = scanner.nextInt();
		System.out.print("Sayı2: ");
		sayı2 = scanner.nextInt();
		DortIslem dortIslem = new DortIslem(sayı1, sayı2);

		System.out.println("Sonuç: " + dortIslem.carpma());

		scanner.close();
	}

}
