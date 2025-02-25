package Study_Exercises;

class SmartHome { 
	
	
	
    void controlRoomDevices(String roomName) //Method
    { 
    	
        class DeviceController { //LocalInner Class(Tek kullanımlık class yapısı yani eventListener gibi düşünülebilir.)
            void turnOnLights() { 
                System.out.println("Lights turned ON in " + roomName); 
            } 
 
            void turnOffLights() { 
                System.out.println("Lights turned OFF in " + roomName); 
            } 
        } 
 
        
        DeviceController controller = new DeviceController(); 
        controller.turnOnLights(); 
        controller.turnOffLights(); 
    } 
    
    
    
} 
 


public class LocalInnerClassExample { 
    public static void main(String[] args) { 
        SmartHome home = new SmartHome(); 
        home.controlRoomDevices("Living Room"); 
    } 
} 