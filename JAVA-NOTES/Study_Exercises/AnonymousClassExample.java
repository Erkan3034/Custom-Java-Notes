package Study_Exercises;

abstract class Animal {

	abstract void sound();

}

public class AnonymousClassExample {
	public static void main(String[] args) {

		Animal animal = new Animal() {

			@Override // Override edilen abstract classa ait metot
			void sound() {
				System.out.println("Anonymous Inner Class: Meow!");
			}
		};
		animal.sound();
	}

	/*
	 * • Tek seferlik kullanım için uygun. 
	 * • Yeni bir alt sınıf oluşturmadan bir sınıfı veya arayüzü genişletir. 
	 * • Genellikle olay dinleyicileri gibi hızlı  işlemlerde kullanılır.
	 */

}
