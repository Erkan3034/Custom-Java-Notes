package Composition_InnerClasses_Static;

public class OuterClass {
	
	
	
	static String outerStatic = "Outer Static Variable";

	
	
	
	static class InnerStaticClass { // static inner class.
		void display() {
			System.out.println(outerStatic);
		}
	}
	
	
}
