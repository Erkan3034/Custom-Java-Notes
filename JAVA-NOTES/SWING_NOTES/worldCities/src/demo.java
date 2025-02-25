
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

// Swing tabanlı bir GUI uygulamasını temsil eden sınıf
public class demo extends javax.swing.JFrame  {

    DefaultTableModel model; // JTable için veri modeli

    // Sınıfın yapıcı metodu
    public demo() {
        initComponents(); // GUI bileşenlerini başlatır
        populateTable();
    }
public void populateTable(){

        model = (DefaultTableModel) tblCities.getModel(); // Tablonun modelini alır
        model.setRowCount(0);
        // Boş satırları temizleme
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            if (model.getValueAt(i, 1) == null) { // 'Name' sütunu boşsa
                model.removeRow(i); // Boş satırı tablodan kaldır
            }
        }

        try {
            // Veritabanından şehir verilerini al ve tabloya ekle
            ArrayList<City> cities = getCities();
            for (City city : cities) {
                Object[] row = {city.getId(), city.getName(),
                    city.getCountryCode(), city.getDistrict(), city.getPopulation()};
                model.addRow(row); // Her şehir bilgisini tabloya ekle
            }
        } catch (SQLException e) {
            // Eğer bir SQL hatası oluşursa burada yakalanır
        }
}
    // Veritabanından şehir bilgilerini alır
    public ArrayList<City> getCities() throws SQLException {
        Connection connection = null; // Veritabanı bağlantısı
        DbHelper dbHelper = new DbHelper(); // Veritabanı yardımcı sınıfı
        Statement statement = null; // SQL sorgularını çalıştırmak için kullanılır
        ResultSet resultSet; // SQL sorgusunun sonuçlarını tutar
        ArrayList<City> cities = null; // Şehir listesini tutar

        try {
            connection = dbHelper.getConnection(); // Veritabanına bağlan
            statement = connection.createStatement(); // SQL sorguları oluştur
            resultSet = statement.executeQuery(
                    "SELECT Id, Name, CountryCode, District, Population FROM City WHERE Name IS NOT NULL"
            ); // Şehir bilgilerini çek

            cities = new ArrayList<City>(); // Şehir listesini başlat
            while (resultSet.next()) { // Sonuç setindeki her bir satır için
                Object[] row = {
                    resultSet.getInt("Id"), // ID sütunu
                    resultSet.getString("Name"), // Name sütunu
                    resultSet.getString("CountryCode"), // CountryCode sütunu
                    resultSet.getString("District"), // District sütunu
                    resultSet.getInt("Population") // Population sütunu
                };
                model.addRow(row); // Satırı tabloya ekle
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception); // Hata mesajını göster
        } finally {
            statement.close(); // Statement'i kapat
            connection.close(); // Veritabanı bağlantısını kapat
        }

        return cities; // Şehir listesini döndür
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCities = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDistriction = new javax.swing.JLabel();
        lblCountryCode = new javax.swing.JLabel();
        lblPopulation = new javax.swing.JLabel();
        tbxName = new javax.swing.JTextField();
        tbxDistrict = new javax.swing.JTextField();
        tbxCountryCode = new javax.swing.JTextField();
        tbxPopulation = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "CountryCode", "Distriction", "Population"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCities);

        txtSearch.setFont(new java.awt.Font("Yu Gothic UI Semilight", 2, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 255, 204), new java.awt.Color(204, 255, 204)));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Yu Gothic UI Semilight", 3, 14)); // NOI18N
        lblSearch.setText("Ara:");
        lblSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 255, 204), new java.awt.Color(204, 255, 204)));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Name:");

        lblDistriction.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDistriction.setText("District:");

        lblCountryCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCountryCode.setText("Country Code:");

        lblPopulation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPopulation.setText("Populaiton:");

        tbxName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxNameActionPerformed(evt);
            }
        });

        tbxDistrict.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbxCountryCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbxPopulation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbxPopulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxPopulationActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("EKLE");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbxName)
                                    .addComponent(tbxCountryCode, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                .addGap(155, 155, 155)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDistriction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPopulation, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbxDistrict)
                                    .addComponent(tbxPopulation, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(lblDistriction, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCountryCode)
                            .addComponent(tbxCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPopulation)
                            .addComponent(tbxPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
// Arama ve filtreleme işlemini gerçekleştiren kod.

        // Kullanıcının arama kutusuna (txtSearch) girdiği metni alır.
        String searchKey = txtSearch.getText();

        // Tabloyu filtrelemek için bir TableRowSorter nesnesi oluşturur.
        // Bu sorter, DefaultTableModel'i temel alır.
        TableRowSorter<DefaultTableModel> tableRowSorter
                = new TableRowSorter<DefaultTableModel>(model);

        // Oluşturulan sorter'ı tabloya bağlar.
        tblCities.setRowSorter(tableRowSorter);

        // Kullanıcının arama kutusuna yazdığı metni içeren satırları göstermek için filtre uygular.
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tbxPopulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxPopulationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxPopulationActionPerformed

    private void tbxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       Connection connection = null;
       DbHelper dbHelper = new DbHelper();
       PreparedStatement statement = null;
       
        try {
            
            connection = dbHelper.getConnection();
            
           String sql = "INSERT INTO City (Name,CountryCode,District,Population) VALUES(?,?,?,?)";
           statement = connection.prepareStatement(sql);
           statement.setString(1, tbxName.getText());
           statement.setString(2, tbxCountryCode.getText());
           statement.setString(3, tbxDistrict.getText());
           statement.setInt(4, Integer.valueOf(tbxPopulation.getText()));
           
           int result = statement.executeUpdate();
           populateTable(); //eklemeden sonra tabloyu yenile
            System.out.println("BASARILI");
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }finally{
           try {
               statement.close();
               connection.close();
           } catch (SQLException ex) {
           }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountryCode;
    private javax.swing.JLabel lblDistriction;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPopulation;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblCities;
    private javax.swing.JTextField tbxCountryCode;
    private javax.swing.JTextField tbxDistrict;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField tbxPopulation;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
