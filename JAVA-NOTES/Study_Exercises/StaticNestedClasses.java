package Study_Exercises;

class OuterClass2 { 
	
    private static int outerStaticField = 20; 
 
    
    static class StaticNestedClass { 
        void display() { 
            System.out.println("Static Field: " + outerStaticField); //Static Inner Class, OuterClassın static ögesine erisebilir
        } 
    } 
} 

 
public class StaticNestedClasses { 
    public static void main(String[] args) { 
        OuterClass2.StaticNestedClass nested = new OuterClass2.StaticNestedClass(); 
        nested.display(); 
    } 
}