package Study_Exercises;

abstract class Character { 
    abstract void attack(); 
} 

 
public class AnonymousInnerClassExample { 
	
	
    public static void main(String[] args) {
    	
    	
        Character warrior = new Character() { //Non-Name class
            @Override 
            void attack() { 
                System.out.println("Warrior attacks with a sword!"); 
            } 
        }; 
 
        
        Character mage = new Character() { //Non-Name Class
            @Override 
            void attack() { 
                System.out.println("Mage casts a fireball!"); 
            } 
        }; 
        
 
        warrior.attack(); 
        mage.attack(); 
        
        
    } 
    
    
} 