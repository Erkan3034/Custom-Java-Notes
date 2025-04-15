package Swing_App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

// Kullanıcı bilgilerini saklayacak sınıf
class User {
    private String name;
    private String email;
    private String biography;
    private String password;

    public User(String name, String email, String biography, String password) {
        this.name = name;
        this.email = email;
        this.biography = biography;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBiography() {
        return biography;
    }

    @Override
    public String toString() {
        return "Kullanıcı Bilgileri:\n" +
               "İsim: " + name + "\n" +
               "Email: " + email + "\n" +
               "Biyografi: " + biography;
    }
}












public class UserFormApp extends JFrame {
    private JLabel nameLabel, emailLabel, bioLabel, passwordLabel;
    private JTextField nameField, emailField;
    private JTextArea bioArea, outputArea;
    private JPasswordField passwordField;
    private JButton saveButton, clearButton;
    private JScrollPane bioScrollPane, outputScrollPane;

    public UserFormApp() {
        // Frame ayarları
        setTitle("Kullanıcı Bilgi Formu");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);

        // Bileşenlerin oluşturulması -Labels
        nameLabel = new JLabel("İsim:");
        emailLabel = new JLabel("Email:");
        bioLabel = new JLabel("Biyografi:");
        passwordLabel = new JLabel("Parola:");
        
        //TexFıelds
        nameField = new JTextField();
        emailField = new JTextField();
        bioArea = new JTextArea();
        passwordField = new JPasswordField();
        
        bioScrollPane = new JScrollPane(bioArea);
        bioArea.setLineWrap(true);
        bioArea.setWrapStyleWord(true);
        
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputScrollPane = new JScrollPane(outputArea);
        
        saveButton = new JButton("Kaydet");
        clearButton = new JButton("Temizle");

        // Bileşenlerin konumlandırılması (setBounds)
        nameLabel.setBounds(30, 30, 100, 25);
        nameField.setBounds(150, 30, 300, 25);

        emailLabel.setBounds(30, 70, 100, 25);
        emailField.setBounds(150, 70, 300, 25);

        bioLabel.setBounds(30, 110, 100, 25);
        bioScrollPane.setBounds(150, 110, 300, 100);

        passwordLabel.setBounds(30, 230, 100, 25);
        passwordField.setBounds(150, 230, 300, 25);

        saveButton.setBounds(150, 280, 120, 30);
        clearButton.setBounds(330, 280, 120, 30);

        outputScrollPane.setBounds(30, 330, 420, 200);

        // Bileşenlerin frame'e eklenmesi
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(bioLabel);
        add(bioScrollPane);
        add(passwordLabel);
        add(passwordField);
        add(saveButton);
        add(clearButton);
        add(outputScrollPane);

        // Buton işlemleri
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveUserInfo();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
    }

    private void saveUserInfo() {
        // Form alanlarından verileri alms işlemleri
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String biography = bioArea.getText().trim();
        String password = new String(passwordField.getPassword());
        
        // Validate işsemleri
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "İsim alanı boş bırakılamaz!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email alanı boş bırakılamaz!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Email formatı kontrolü
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Geçerli bir email adresi giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Parola uzunluğu kontrolü
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Parola en az 6 karakter olmalıdır!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Kullanıcı oluştur
        User user = new User(name, email, biography, password);
        
        // Kullanıcı bilgilerini görüntüle
        outputArea.setText(user.toString());
        
        JOptionPane.showMessageDialog(this, "Kullanıcı bilgileri başarıyla kaydedildi.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    private boolean isValidEmail(String email) {
        // Basit email doğrulama regex uapısı
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        
        Pattern pattern = Pattern.compile(emailRegex);
        
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private void clearForm() {
        nameField.setText("");
        emailField.setText("");
        bioArea.setText("");
        passwordField.setText("");
        outputArea.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserFormApp().setVisible(true);
            }
        });
    }
}