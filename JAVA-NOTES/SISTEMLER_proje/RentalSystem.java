package SISTEMLER_proje;
import java.util.*;
import java.util.regex.*;

class Car extends Vehicle {
    private int seatCount;

    public Car(String plateNumber, String brand, String model, double rentalPrice, int seat) {
        super(plateNumber, brand, model, rentalPrice, true);
        this.seatCount = seat;
    }

    @Override
    public String getDetails() {
        return "Araba [Plaka No: " + getPlateNumber() + ", Marka: " + getBrand() + ", Model: " + getModel() + ", Koltuk Sayısı: " + seatCount + ", Fiyat: " + getRentalPrice() + ", Tl/Gün: ";
    }
}

class Truck extends Vehicle {
    private int loadCapacity;

    public Truck(String plateNumber, String brand, String model, double rentalPrice, int loadCapacity) {
        super(plateNumber, brand, model, rentalPrice, true);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getDetails() {
        return "Kamyon [Plaka No: " + getPlateNumber() + ", Marka: " + getBrand() + ", Model: " + getModel() + ", Yükleme Kapasitesi: " + loadCapacity + ", Fiyat: " + getRentalPrice() + ", TL/Gün";
    }
}

class Motorcycle extends Vehicle {
    private boolean hasHelmet;

    public Motorcycle(String plateNumber, String brand, String model, double rentalPrice, boolean hasHelmet) {
        super(plateNumber, brand, model, rentalPrice, true);
        this.hasHelmet = hasHelmet;
    }

    @Override
    public String getDetails() {
        return "Kamyon [Plaka No: " + getPlateNumber() + ", Marka: " + getBrand() + ", Model: " + getModel() + ", Kask Var Mı? : " + (hasHelmet ? "Evet" : "Hayır") + ", Fiyat: " + getRentalPrice() + ", TL/Gün";
    }
}

class Customer {
    private String name;
    private String email;
    private List<Vehicle> rentedVehicles;

    public Customer(String Name, String Email) {
        this.email = Email;
        this.name = Name;
        rentedVehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return email;
    }

    public List<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void rentVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
        vehicle.setAvailable(false);
    }

    public void displayRentedVehicles() {
        System.out.println("[" + name + "] için Kiralanan Araçlar");
        for (Vehicle vh : rentedVehicles) {
            System.out.println(vh.getDetails());
        }
    }
}

public class RentalSystem {
    private List<Vehicle> vehicles;
    private List<Customer> customers;

    public RentalSystem() {
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addVehicle(Vehicle vh) {
        vehicles.add(vh);
    }

    public void addCustomer(Customer cus) {
        if (isValidMail(cus.getMail())) {
            customers.add(cus);
            System.out.println("Müşteri Eklendi: " + cus.getName());
        } else {
            System.out.println("Geçerli Olmayan bir mail adresi: " + cus.getMail());
        }
    }

    public void displayAvailableVehicles() {
        System.out.println("Mevcut Kiralanabilecek Araçlar ");
        for (Vehicle vh : vehicles) {
            if (vh.isAvailable()) {
                System.out.println(vh.getDetails());
            }
        }
    }

    public Vehicle findVehiclePlate(String plateNumber) {
        for (Vehicle vh : vehicles) {
            if (vh.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                return vh;
            }
        }
        return null;
    }

    private boolean isValidMail(String Email) {
        String emailRegex = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
        Pattern pat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pat.matcher(Email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        RentalSystem rs = new RentalSystem();

        rs.addVehicle(new Car("34XYZ34", "Toyota", "Corolla", 2000, 5));
        rs.addVehicle(new Truck("06ABC06", "Ford", "F-Max", 5000, 10));
        rs.addVehicle(new Motorcycle("74AB74", "Honda", "C-125", 250, true));

        Customer cs1 = new Customer("ayşe yılmaz", "ayseyilmaz@hotmail.com");
        Customer cs2 = new Customer("fuat aymaz", "maz#hotmail.com");
        rs.addCustomer(cs1);
        rs.addCustomer(cs2);

        rs.displayAvailableVehicles();

        Vehicle sortingVehicle = rs.findVehiclePlate("34XYZ34");
        if (sortingVehicle != null && sortingVehicle.isAvailable()) {
            cs1.rentVehicle(sortingVehicle);
            System.out.println("Kiralanan araç: " + sortingVehicle.getDetails() + ", Şu Müşteri Kiraladı: " + cs1.getName());
        }

        cs1.displayRentedVehicles();
        rs.displayAvailableVehicles();
    }
}