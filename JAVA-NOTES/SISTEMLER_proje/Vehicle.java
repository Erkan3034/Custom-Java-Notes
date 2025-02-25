package SISTEMLER_proje;

public abstract class Vehicle {
    private String plateNumber;
    private String brand;
    private String model;
    private double rentalPrice;
    private boolean isAvailable;

    public Vehicle(String plateNumber, String brand, String model, double rentalPrice, boolean isAvailable) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.rentalPrice = rentalPrice;
        this.isAvailable = isAvailable;
    }

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

    public abstract String getDetails();
}