package Study_Exercises;

class School { 
    private static String schoolName = "Greenwood High School"; 
 
    
    static class Classroom { 
        private String className; 
        private int studentCount; 
 
        Classroom(String className, int studentCount) { 
            this.className = className; 
            this.studentCount = studentCount; 
        } 
 
        void displayClassInfo() { 
            System.out.println("School: " + schoolName); 
            System.out.println("Classroom: " + className); 
            System.out.println("Number of Students: " + studentCount); 
        } 
    } 
    
    
} 
 


public class StaticNestedClassExample { 
    public static void main(String[] args) { 
        School.Classroom class10A = new School.Classroom("10-A", 35);  //Static İnner Class call.(Nesneye bağlı değil)
        class10A.displayClassInfo(); 
    } 
}