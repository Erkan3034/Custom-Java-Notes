package Study_Exercises;

class Car { 
    private String model; 
    private int year; 
 
    Car(String model, int year) { 
        this.model = model; 
        this.year = year; 
    } 
 
    class Engine { 
        private int horsepower; 
 
        Engine(int horsepower) { 
            this.horsepower = horsepower; 
        } 
 
        void displayEngineInfo() { 
            System.out.println("Car Model: " + model + ", Year: " + year); 
            System.out.println("Engine Horsepower: " + horsepower + " HP"); 
        } 
    } 
} 
 


public class NonStaticExample2 { 
    public static void main(String[] args) { 
    	
        Car car = new Car("Dodge Challenger SRT Demon 170 ", 2023); 
        Car.Engine engine = car.new Engine(870); //Nesneye Bağımlı.(non-static)
 
        engine.displayEngineInfo(); 
        
        
    } 
    
    
} 