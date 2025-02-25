package FilesNotes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Main.createFile();
		createFile();
		System.out.println("_____________________________________");
		getFileInfo();
		System.out.println("_____________________________________");
		writeFile();
		System.out.println("Dosya içeriği: ");
		readFile();
	}

	// =============================CREATE FILE=============================
	public static void createFile() {
		File file = new File(
				"C:\\Users\\ERKAN TURGUT\\OneDrive\\Masaüstü\\JavaClassNotes\\MyPersonalNotes\\src\\FilesNotes\\students.txt");

		try {
			if (file.createNewFile()) { // Yolunu belirttiğimiz, students.txt dosyasını oluşturur.
				System.out.println("Dosya başarıyla oluşturuldu!");

			} else {
				System.out.println("Bu dosya zaten var!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// =============================GET FILE INFO=============================

	public static void getFileInfo() {
		File dosya = new File(
				"C:\\Users\\ERKAN TURGUT\\OneDrive\\Masaüstü\\JavaClassNotes\\MyPersonalNotes\\src\\FilesNotes\\students.txt");

		// exists() -> dosyanın olup olmadığını kontrol eder.(boolean)

		if (dosya.exists()) {
			System.out.println("Dosya adı : " + dosya.getName()); // Dosya ismi al.
			System.out.println("Dosya yolu : " + dosya.getAbsolutePath()); // Dosyanın yolunu al.
			System.out.println("Dosya yazılabilir mi ? : " + dosya.canWrite()); // Dosya yazdrılabilir mi.
			System.out.println("Dosya okunabilir mi ? : " + dosya.canRead()); // Dosya okunabilir mi ?
			System.out.println("Dosya çalıştırılabilir mi ? : " + dosya.canExecute()); // Dosya çalıştırılabilir mi ?
			System.out.println("Dosya boyutu(byte) : " + dosya.length()); // Dosya uzunluğu.

		} else {
			System.out.println("Maalesef böyle bir dosya bulunmamaktadır!");
		}

	}

	// =============================READ FILE=============================

	public static void readFile() {
		File dosya2 = new File(
				"C:\\Users\\ERKAN TURGUT\\OneDrive\\Masaüstü\\JavaClassNotes\\MyPersonalNotes\\src\\FilesNotes\\students.txt");

		try {
			Scanner reader = new Scanner(dosya2);

			while (reader.hasNextLine()) { // Bir sonraki satır olduğu sürece dosyayı oku.
				String line = reader.nextLine();
				System.out.println(line);

			}

			reader.close(); // Dosyayı kapat.
		} catch (FileNotFoundException e) { // Dosya bulunmazsa hata mesajı döndür.
			System.out.println(e.getMessage());
		}
	}

	// =============================WRİTE FILE=============================

	public static void writeFile() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"C:\\Users\\ERKAN TURGUT\\OneDrive\\Masaüstü\\JavaClassNotes\\MyPersonalNotes\\src\\FilesNotes\\students.txt",true)); // true paramatresini append olarak işlem yapması için verdik.

			writer.newLine(); // Önceki dosya elemanından sonra yeni satır oluşturup yaz.
			writer.write("ABC TURGUT");
			writer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// =============================DELETE FILE=============================
	public void deleteFİle() {
		File myObj = new File(
				"C:\\Users\\ERKAN TURGUT\\OneDrive\\Masaüstü\\JavaClassNotes\\MyPersonalNotes\\src\\FilesNotes\\students.txt");
		if (myObj.delete()) {
			System.out.println("Deleted the file: " + myObj.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}

	}
}
