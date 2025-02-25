package proje;

import java.util.*;

abstract class DICOMImage {
    private String ID;
    private Date date;
    private String modalityString;
    private double sizeMB;

    public DICOMImage(String ID, Date date, String modalityString, double sizeMB) {
        this.ID = ID;
        this.date = date;
        this.modalityString = modalityString;
        this.sizeMB = sizeMB;
    }

    public String getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public String getModality() {
        return modalityString;
    }

    public double getSizeMB() {
        return sizeMB;
    }

    public abstract String getImageDetails();
}

class MRIImage extends DICOMImage {
    private String scanSequenceString;

    public MRIImage(String ID, Date date, double sizeMB, String scanSequenceString) {
        super(ID, date, "MRI", sizeMB);
        this.scanSequenceString = scanSequenceString;
    }

    public String getImageDetails() {
        return "MRI Image [ID:" + getID() + ", Date:" + getDate() + ", Size:" + getSizeMB() + "MB, Scan Sequence: " + scanSequenceString + "]";
    }
}

class CTImage extends DICOMImage {
    private int sliceThickness;

    public CTImage(String ID, Date date, double sizeMB, int sliceThickness) {
        super(ID, date, "CT", sizeMB);
        this.sliceThickness = sliceThickness;
    }

    public String getImageDetails() {
        return "CT Image [ID:" + getID() + ", Date:" + getDate() + ", Size:" + getSizeMB() + "MB, Slice Thickness: " + sliceThickness + "]";
    }
}

class XRAYImage extends DICOMImage {
    private String bodyPart;

    public XRAYImage(String ID, Date date, double sizeMB, String bodyPart) {
        super(ID, date, "XRAY", sizeMB);
        this.bodyPart = bodyPart;
    }

    public String getImageDetails() {
        return "XRAY Image [ID:" + getID() + ", Date:" + getDate() + ", Size:" + getSizeMB() + "MB, Body Part: " + bodyPart + "]";
    }
}

class Patient {
    private String id;
    private String name;
    private int age;
    private Map<String, DICOMImage> images;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.images = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addImage(DICOMImage image) {
        images.put(image.getID(), image);
    }

    public DICOMImage getImage(String imageID) {
        return images.get(imageID);
    }

    public void displayPatientImages() {
        System.out.println("Patient [" + name + "]'s Radiology Images:");
        for (DICOMImage img : images.values()) {
            System.out.println(img.getImageDetails());
        }
    }
}

public class HospitalSystem {
    private Map<String, Patient> patientsMap;
    private Set<String> uniquePatientSet;

    public HospitalSystem() {
        this.patientsMap = new HashMap<>();
        this.uniquePatientSet = new HashSet<>();
    }

    public void addPatient(Patient patient) {
        if (uniquePatientSet.contains(patient.getId())) {
            System.out.println("Error: Patient ID already exists.");
        } else {
            patientsMap.put(patient.getId(), patient);
            uniquePatientSet.add(patient.getId());
            System.out.println("New patient added: " + patient.getName());
        }
    }

    public Patient getPatient(String patientID) {
        return patientsMap.get(patientID);
    }

    public void displayPatients() {
        System.out.println("All Registered Patients:");
        for (Patient pt : patientsMap.values()) {
            System.out.println("Patient [ID: " + pt.getId() + ", Name: " + pt.getName() + ", Age: " + pt.getAge() + "]");
        }
    }

    public static void main(String[] args) {
        HospitalSystem hospitalSystem = new HospitalSystem();

        Patient patient1 = new Patient("P001", "Ahmet Kaya", 45);
        Patient patient2 = new Patient("P002", "Ayşe Yılmaz", 32);

        MRIImage mriImage = new MRIImage("Img001", new Date(), 12.5, "T1-weighted");
        CTImage ctImage = new CTImage("Img002", new Date(), 8.3, 5);
        XRAYImage xrayImage = new XRAYImage("Img003", new Date(), 3.2, "Chest");

        patient1.addImage(mriImage);
        patient2.addImage(ctImage);
        patient1.addImage(xrayImage);

        hospitalSystem.addPatient(patient1);
        hospitalSystem.addPatient(patient2);

        hospitalSystem.displayPatients();
        patient1.displayPatientImages();
        patient2.displayPatientImages();
    }
}
