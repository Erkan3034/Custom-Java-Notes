package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readingFileDemo {

	public static void main(String[] args) throws IOException  {
		BufferedReader reader = null; // Dosya okuma classı.
		int total = 0;

		
		try {
			reader = new BufferedReader(new FileReader(
					"C:\\Users\\ERKAN TURGUT\\OneDrive\\Masaüstü\\JavaClassNotes\\MyPersonalNotes\\src\\ExceptionHandling\\sayilar.txt")); // dosya
																																			// okuma
			String line = null;

			while ((line = reader.readLine()) != null) 
			{
				total += Integer.valueOf(line);

			}
			System.out.println("Listedeki Sayıların Toplamı: " + total);

		   } 
		
		catch (NumberFormatException e) {
			System.out.println("Listede yanlış formatta eleman bulunuyor(non-int): " + e.getMessage());
		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		} 
		finally {
			reader.close();
		}

	}

}
