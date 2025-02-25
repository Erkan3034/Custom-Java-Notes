package Composition_InnerClasses_Static;

public class Main {

	public static void main(String[] args) {
		// Yardımcı araçları(kullan bırak) ststic yapabilriiz.manager sınıfları static
		// yapmamaya özen göstermeliyiz.

		ProductManager manager = new ProductManager();
		Product product = new Product();
		product.id = 1;
		product.name = "LAPTOP";
		product.price = 12.4;
		
		manager.add(product);
		
		
		//Classın static metotlarına direk class ismi üzerinden ulaşabiliriz.
		OuterClass.InnerStaticClass inner = new OuterClass.InnerStaticClass();
		
		inner.display();
	}

}
