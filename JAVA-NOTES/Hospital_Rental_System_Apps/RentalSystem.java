package Hospital_Rental_System_Apps;

import java.util.*;
import java.util.regex.*;

// Soyut araç sınıfı: Tüm araç türleri için ortak özellikler
abstract class Vehicle {
    private String plateNumber; // Araç plaka numarası
    private String brand;       // Araç markası
    private String model;       // Araç modeli
    private double rentalPrice; // Günlük kiralama ücreti
    private boolean isAvailable; // Araç kiralanabilir mi?

    // Yapıcı metot: Ortak özellikleri başlatır
    public Vehicle(String plateNumber, String brand, String model, double rentalPrice, boolean isAvailable) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.rentalPrice = rentalPrice;
        this.isAvailable = isAvailable;
    }

    // Get ve set metotları
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Alt sınıflar tarafından uygulanacak soyut metot
    public abstract String getDetails();
}

// Araba sınıfı: Araç sınıfından türetilmiş
class Car extends Vehicle {
    private int seatCount; // Koltuk sayısı

    public Car(String plateNumber, String brand, String model, double rentalPrice, int seatCount) {
        super(plateNumber, brand, model, rentalPrice, true);
        this.seatCount = seatCount;
    }

    @Override
    public String getDetails() {
        return "Araba [Plaka No: " + getPlateNumber() + ", Marka: " + getBrand() +
               ", Model: " + getModel() + ", Koltuk Sayısı: " + seatCount +
               ", Fiyat: " + getRentalPrice() + " TL/Gün]";
    }
}

// Kamyon sınıfı: Araç sınıfından türetilmiş
class Truck extends Vehicle {
    private int loadCapacity; // Yükleme kapasitesi

    public Truck(String plateNumber, String brand, String model, double rentalPrice, int loadCapacity) {
        super(plateNumber, brand, model, rentalPrice, true);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getDetails() {
        return "Kamyon [Plaka No: " + getPlateNumber() + ", Marka: " + getBrand() +
               ", Model: " + getModel() + ", Yükleme Kapasitesi: " + loadCapacity +
               ", Fiyat: " + getRentalPrice() + " TL/Gün]";
    }
}

// Motosiklet sınıfı: Araç sınıfından türetilmiş
class Motorcycle extends Vehicle {
    private boolean hasHelmet; // Kask var mı?

    public Motorcycle(String plateNumber, String brand, String model, double rentalPrice, boolean hasHelmet) {
        super(plateNumber, brand, model, rentalPrice, true);
        this.hasHelmet = hasHelmet;
    }

    @Override
    public String getDetails() {
        return "Motosiklet [Plaka No: " + getPlateNumber() + ", Marka: " + getBrand() +
               ", Model: " + getModel() + ", Kask Var Mı? " + (hasHelmet ? "Evet" : "Hayır") +
               ", Fiyat: " + getRentalPrice() + " TL/Gün]";
    }
}

// Müşteri sınıfı: Müşteri bilgilerini ve kiralanan araçları tutar
class Customer {
    private String name; // Müşteri adı
    private String email; // Müşteri e-posta adresi
    private List<Vehicle> rentedVehicles; // Kiralanan araçlar listesi

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.rentedVehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void rentVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle); // Aracı kiralananlara ekler
        vehicle.setAvailable(false); // Aracı müsait değil olarak işaretler
    }

    public void displayRentedVehicles() {
        System.out.println("[" + name + "] için kiralanan araçlar:");
        for (Vehicle vh : rentedVehicles) {
            System.out.println(vh.getDetails());
        }
    }
}

// Kiralama sistemi: Araçları ve müşterileri yönetir
public class RentalSystem {
    private List<Vehicle> vehicles; // Sistemdeki tüm araçlar
    private List<Customer> customers; // Sistemdeki müşteriler
    private final String EMAIL_PATTERN = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"; // E-posta doğrulama deseni

    public RentalSystem() {
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle); // Sisteme yeni araç ekler
    }

    public void addCustomer(Customer customer) {
        if (isValidEmail(customer.getEmail())) { // E-posta doğrulama
            customers.add(customer);
            System.out.println("Müşteri eklendi: " + customer.getName());
        } else {
            System.out.println("Geçersiz e-posta adresi: " + customer.getEmail());
        }
    }

    public void displayAvailableVehicles() {
        System.out.println("Mevcut kiralanabilir araçlar:");
        for (Vehicle vh : vehicles) {
            if (vh.isAvailable()) {
                System.out.println(vh.getDetails());
            }
        }
    }

    public Vehicle findVehicleByPlate(String plateNumber) {
        for (Vehicle vh : vehicles) {
            if (vh.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                return vh;
            }
        }
        return null; // Plaka bulunamazsa null döner
    }

    private boolean isValidEmail(String email) {
        Pattern pat = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pat.matcher(email);
        return matcher.matches(); // E-posta formatı doğru mu?
    }

    public static void main(String[] args) {
        RentalSystem rs = new RentalSystem();

        // Araç ekleme
        rs.addVehicle(new Car("34XYZ34", "Toyota", "Corolla", 2000, 5));
        rs.addVehicle(new Truck("06ABC06", "Ford", "F-Max", 5000, 10));
        rs.addVehicle(new Motorcycle("74AB74", "Honda", "C-125", 250, true));

        // Müşteri ekleme
        Customer cs1 = new Customer("Ayşe Yılmaz", "ayseyilmaz@hotmail.com");
        Customer cs2 = new Customer("Fuat Aymaz", "maz#hotmail.com");
        rs.addCustomer(cs1);
        rs.addCustomer(cs2);

        // Müsait araçları listeleme
        rs.displayAvailableVehicles();

        // Araç kiralama
        Vehicle vehicle = rs.findVehicleByPlate("34XYZ34");
        if (vehicle != null && vehicle.isAvailable()) {
            cs1.rentVehicle(vehicle);
            System.out.println("Kiralanan araç: " + vehicle.getDetails() + ", Şu müşteri kiraladı: " + cs1.getName());
        }

        // Müşterinin kiraladığı araçları listeleme
        cs1.displayRentedVehicles();

        // Güncel müsait araçları listeleme
        rs.displayAvailableVehicles();
    }
}
