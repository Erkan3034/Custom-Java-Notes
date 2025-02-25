package Study_Exercises;

class OuterClass {

	void display() {
		final int localVar = 30;

		class LocalInnerClass {
			void show() {
				System.out.println("Local Variable: " + localVar);
			}
		}

		LocalInnerClass localInner = new LocalInnerClass();
		localInner.show();
	}

}

/*
 * • Metotların içinde tanımlanır. 
 * • Yerel değişkenlere erişim sağlayabilir, bu değişkenler final (Java 8 sonrası "effectively final") olmalıdır. 
 * •Sınıf tanımı yalnızca metodun veya bloğun içinde geçerlidir.
 */

public class OuterInnerClasses {
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.display();
	}
}