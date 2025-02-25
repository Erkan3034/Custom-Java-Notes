package Composition_InnerClasses_Static;

public class ProductManager {
	
	public void add(Product product) {
		
		//ProductValidator productValidator = new ProductValidator(); // BU işlem productValidator nesnesini kullanmak için yazdık. eğer direk ProductValidator. olarak kullanmak şstersek, bunu tanımladığımızda "static" olarak tanımlamamız lazım. 
		
		if (ProductValidator.isValid(product)) {
			System.out.println("Ürün eklendi...");
		} else {
			System.out.println("Ürün bilgileri hatalı!");
		}

	}

}


//metodu static yaptığımızda classın ismiyle direkt olarak çağırabiliriz.    Aslıııııııııııııııı