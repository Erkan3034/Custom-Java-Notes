package TemelNotlar;

public class MultipleDimensionsArrays {

	public static void main(String[] args) {
		// 2 boyutlu bir String dizisi yapalım.

		String[][] sehirler = new String[3][3];

		sehirler[0][0] = "İstanbul";
		sehirler[0][1] = "Bursa";
		sehirler[0][2] = "Sakarya";
		sehirler[1][0] = "Van";
		sehirler[1][1] = "Hakkari";
		sehirler[1][2] = "Bitlis";
		sehirler[2][0] = "Antep";
		sehirler[2][1] = "Urfa";
		sehirler[2][2] = "Mersin";

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				System.out.println(sehirler[i][j]);
			}
			System.out.println(" ");
		}
	}

}
