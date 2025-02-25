package Hospital_Rental_System_Apps;

import java.text.SimpleDateFormat;
import java.util.*;

// Temel bir DICOM görüntü sınıfı (Soyut sınıf)
abstract class DICOMImage {
    private String ID;                 // Görüntünün benzersiz kimliği
    private Date date;                 // Görüntünün tarihi
    private String modalityString;     // Görüntünün türü (MRI, CT, XRAY)
    private double sizeMB;             // Görüntü boyutu (MB olarak)

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

    // Soyut metot: Alt sınıflar tarafından override edilmesi zorunlu.
    public abstract String getImageDetails();
}

// MRI Görüntüleri için sınıf
class MRIImage extends DICOMImage {
    private String scanSequenceString; // MRI tarama sekansı bilgisi

    public MRIImage(String ID, Date date, double sizeMB, String scanSequenceString) {
        super(ID, date, "MRI", sizeMB); // Modality sabit olarak "MRI" atanır.
        this.scanSequenceString = scanSequenceString;
    }

    public String getImageDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // tarih formatlama
        return "MRI Image [ID:" + getID() + ", Date:" + sdf.format(getDate()) + ", Size:" + getSizeMB() + "MB, Scan Sequence: " + scanSequenceString + "]";
    }
}

// CT Görüntüleri için sınıf
class CTImage extends DICOMImage {
    private int sliceThickness; // Dilim kalınlığı bilgisi

    public CTImage(String ID, Date date, double sizeMB, int sliceThickness) {
        super(ID, date, "CT", sizeMB);
        this.sliceThickness = sliceThickness;
    }

    public String getImageDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "CT Image [ID:" + getID() + ", Date:" + sdf.format(getDate()) + ", Size:" + getSizeMB() + "MB, Slice Thickness: " + sliceThickness + "]";
    }
}

// X-Ray Görüntüleri için sınıf
class XRAYImage extends DICOMImage {
    private String bodyPart; // Görüntülenen vücut bölgesi

    public XRAYImage(String ID, Date date, double sizeMB, String bodyPart) {
        super(ID, date, "XRAY", sizeMB);
        this.bodyPart = bodyPart;
    }

    public String getImageDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "XRAY Image [ID:" + getID() + ", Date:" + sdf.format(getDate()) + ", Size:" + getSizeMB() + "MB, Body Part: " + bodyPart + "]";
    }
}

// Hasta sınıfı: Hasta bilgilerini ve görüntülerini saklar
class Patient {
    private String id;                        // Hasta ID'si
    private String name;                      // Hasta adı
    private int age;                          // Hasta yaşı
    private Map<String, DICOMImage> images;   // Görüntüleri ID'ye göre saklayan bir HashMap

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.images = new HashMap<>(); // Görüntüleri saklamak için Map oluşturulur.
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
        images.put(image.getID(), image); // Görüntü ID'si anahtar olarak kullanılır.
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

// Hastane sistemi sınıfı: Hastaları ve işlemleri yönetir
public class HospitalSystem {
    // Hastaları ID'ye göre saklamak için bir HashMap kullanılıyor.
    // Anahtar: Hasta ID'si (örneğin: "P001")
    // Değer: Patient nesnesi (Hastanın tüm bilgilerini tutar)
    private Map<String, Patient> patientsMap;

    // Benzersiz hasta ID'lerini kontrol etmek için bir Set kullanılıyor.
    // Bu, bir hastanın sistemde zaten kayıtlı olup olmadığını hızlıca kontrol etmemizi sağlar.
    private Set<String> uniquePatientSet;



    public HospitalSystem() { //constructor
        this.patientsMap = new HashMap<>(); // HashMap, hastaları saklamak için başlatılır.
        this.uniquePatientSet = new HashSet<>(); // Set, benzersiz ID'leri kontrol etmek için başlatılır.
    }

    // Bir hasta eklemek için kullanılan metot.
    public void addPatient(Patient patient) {
        // Eğer Set içinde hasta ID'si zaten mevcutsa, hata mesajı yazdırılır.
        if (uniquePatientSet.contains(patient.getId())) {
            System.out.println("Error: Patient ID already exists."); // Hata mesajı.
        } else {
            // Eğer hasta ID'si benzersizse:
            patientsMap.put(patient.getId(), patient); // Hasta, Map'e eklenir.
            uniquePatientSet.add(patient.getId());     // Hasta ID'si, Set'e eklenir.
            System.out.println("New patient added: " + patient.getName()); // Başarı mesajı.
        }
    }

    // Sistemde kayıtlı olan tüm hastaları listelemek için kullanılan metot.
    public void displayPatients() {
        System.out.println("All Registered Patients:");
        // patientsMap içinde bulunan tüm hasta nesnelerini dolaşır.
        for (Patient pt : patientsMap.values()) {
            // Her bir hastanın bilgileri yazdırılır.
            System.out.println("Patient [ID: " + pt.getId() + ", Name: " + pt.getName() + ", Age: " + pt.getAge() + "]");
        }
    }





    public static void main(String[] args) {
        HospitalSystem hospitalSystem = new HospitalSystem();

        // Hastalar oluşturulur
        Patient patient1 = new Patient("P001", "Ahmet Kaya", 45);
        Patient patient2 = new Patient("P002", "Ayşe Yılmaz", 32);

        // Görüntüler oluşturulur
        MRIImage mriImage = new MRIImage("Img001", new Date(), 12.5, "T1-weighted");
        CTImage ctImage = new CTImage("Img002", new Date(), 8.3, 5);
        XRAYImage xrayImage = new XRAYImage("Img003", new Date(), 3.2, "Chest");

        // Görüntüler hastalara atanır
        patient1.addImage(mriImage);
        patient2.addImage(ctImage);
        patient1.addImage(xrayImage);

        // Hastalar sisteme eklenir
        hospitalSystem.addPatient(patient1);
        hospitalSystem.addPatient(patient2);

        // Hastalar ve görüntü bilgileri yazdırılır
        hospitalSystem.displayPatients();
        patient1.displayPatientImages();
        patient2.displayPatientImages();
    }
}
