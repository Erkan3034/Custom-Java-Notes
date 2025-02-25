package Study_Exercises;

class OuterClass3 { 
    private int outerField = 10; 
 
    class InnerClass { 
        void display() { 
            System.out.println("Outer Field: " + outerField); // OuterClass'ın alanına doğrudan erişim 
        } 
    } 
 
    void createInner() { 
        InnerClass inner = new InnerClass(); 
        inner.display(); 
    } 
} 
 
public class NonStaticInnerClassExample { 
    public static void main(String[] args) { 
        OuterClass3 outer = new OuterClass3(); 
        outer.createInner(); // Outer Class üzerinden Inner Class çağrılır 
    } 
}