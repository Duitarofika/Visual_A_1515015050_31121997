package Tugas7;

/**
 *
 * @author Duita */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FormDataBuku extends javax.swing.JFrame {
    private DefaultTableModel model;//untuk membuat model pada tabel
    private Connection con = koneksi.getConnection();//untuk mengambil koneksi
    private Statement stt;//untuk eksekusi query database
    private ResultSet rss;//untuk penampung data dari database
    
    private int baris;//mendeklarasikan variabel baris
    private boolean kuyuy=true; //mendeklarasikan variabel untuk validasi yang bernilai boolean

    /**
     * Creates new form database
     */
    public FormDataBuku() {
        initComponents();
    }
    public void InitTable(){//method formdatabuku
        model = new DefaultTableModel();
        model.addColumn("Ïd");
        model.addColumn("Judul");
        model.addColumn("Penulis");
        model.addColumn("Harga");
        
        tabel.setModel(model);
    }
    
    private void TampilData(){//method untuk menampilkan data
        try{
            String sql = "SELECT * FROM buku";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getString("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        }catch(SQLException e){//digunakan untuk menangkap kesalahan
            System.out.println(e.getMessage());
        }
    }
    
    private void TambahData(String judul, String penulis, String harga){//method untuk menambahkan data
        try{
            String sql = "INSERT buku VALUES (NULL,'"+judul+"','"+penulis+"','"+harga+"')";
            stt = con.createStatement();
            stt.executeQuery(sql);
        }catch(SQLException e){//digunakan untuk menangkap kesalahan
            System.out.println(e.getMessage());
        }
        
    }
    private void UbahData(String judul, String penulis, String harga, String id){//method untuk mengubah data
        try{
            String sql = "UPDATE buku SET judul='"+judul+"', penulis='"+penulis+"', harga='"+harga+"' WHERE id='"+id+"'";
            stt = con.createStatement();
            stt.executeQuery(sql);
        }catch(SQLException e){//digunakan untuk menangkap kesalahan
            System.out.println(e.getMessage());
        }
    }
    
    private void HapusData(String id, int baris){//method untuk menghapus data
        try{
        String sql = "DELETE FROM buku WHERE id='"+id+"'";
        stt=con.createStatement();
        stt.executeUpdate(sql);
        model.removeRow(baris);
    }catch(SQLException e){//digunakan untuk menangkap kesalahan
            System.out.println(e.getMessage());
        }
    }
    
    private void CariData(){//method untuk mencari data
        try{
            String sql = "SELECT * FROM buku WHERE judul='"+txtcari.getText()+"'|| penulis='"+txtcari.getText()+"'|| harga='"+txtcari.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getString("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        }catch(SQLException e){//digunakan untuk menangkap kesalahan
            System.out.println(e.getMessage());
        }
    }
   
    private void PencarianData(String by, String cari){
        try{
            String sql = "SELECT * FROM buku where "+by+" LIKE '%"+cari+"%';";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] data = new Object[4];
                data[0] = rss.getString("id");
                data[1] = rss.getString("judul");
                data[2] = rss.getString("penulis");
                data[3] = rss.getInt("harga");
                model.addRow(data);
            }
        }catch(Exception e){
        System.out.println(e.getMessage());
    }
    }
    
    private void kuy(String judul, String penulis, String harga){
        try{
            String sql = "SELECT * FROM buku";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getString("judul").toLowerCase();
                o[1] = rss.getString("penulis").toLowerCase();
                
                if(o[0].equals(judul.toLowerCase()) && o[1].equals(penulis.toLowerCase())){
                    JOptionPane.showMessageDialog(null,"Your Data Ready");
                    kuyuy=false;
                    break;
                }
        }
            if(kuyuy==true)
                TambahData(judul,penulis,harga);
    }catch(SQLException e){//digunakan untuk menangkap kesalahan
            System.out.println(e.getMessage());
    }
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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtjudul = new javax.swing.JTextField();
        cbpenulis = new javax.swing.JComboBox();
        txtharga = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btncari = new javax.swing.JButton();
        btntampil = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Form Data Buku");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Penulis");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Harga");

        txtjudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjudulActionPerformed(evt);
            }
        });

        cbpenulis.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbpenulis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tere Liye", "Dewi Lestari", "Asma Nadia", "J.K. Rowling", "Stephen Hawking" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjudul, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(txtharga))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(cbpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 255));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnsimpan.setBackground(new java.awt.Color(255, 102, 255));
        btnsimpan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnsimpan);

        btnubah.setBackground(new java.awt.Color(255, 102, 255));
        btnubah.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });
        jPanel3.add(btnubah);

        btnhapus.setBackground(new java.awt.Color(255, 102, 255));
        btnhapus.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnhapus);

        btnkeluar.setBackground(new java.awt.Color(255, 102, 255));
        btnkeluar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnkeluar.setText("Keluar");
        btnkeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkeluarMouseClicked(evt);
            }
        });
        jPanel3.add(btnkeluar);

        tabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Judul", "Penulis", "Harga"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        jPanel4.setBackground(new java.awt.Color(255, 102, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Search");

        btncari.setBackground(new java.awt.Color(0, 255, 102));
        btncari.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        btntampil.setBackground(new java.awt.Color(0, 255, 102));
        btntampil.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btntampil.setText("Tampil");
        btntampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntampilActionPerformed(evt);
            }
        });

        txtcari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtcariCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btncari)
                .addGap(18, 18, 18)
                .addComponent(btntampil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btncari)
                    .addComponent(btntampil)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        //untuk action tombol ubah
        int baris = tabel.getSelectedRow();
        
        String judul = tabel.getValueAt(baris, 1).toString();
        String penulis = tabel.getValueAt(baris, 2).toString();
        String harga = tabel.getValueAt(baris, 3).toString();
        String id = tabel.getValueAt(baris, 0).toString();
        
        if(HapusData(id))
            JOptionPane.showMessageDialog(null, "Berhasil Hapus Data");
        else
            JOptionPane.showConfirmDialog(null, "Gagal Hapus Data");
        
        InitTable();TampilData();
    }//GEN-LAST:event_btnubahActionPerformed

    
    private void txtjudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjudulActionPerformed
        
    }//GEN-LAST:event_txtjudulActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        InitTable();//untuk menghubungkan data inputan yang ada ke tabel
        TampilData();//untuk menampilkan data
    }//GEN-LAST:event_formComponentShown

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        //untuk action tombol simpan
        String judul = txtjudul.getText();
        String penulis = cbpenulis.getSelectedItem().toString();
        String harga = txtharga.getText();
        kuy(judul,penulis,harga);
        InitTable();
        TampilData();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        //digunakan untuk mengambil data yang ada ketika tombol yang dipilih di klik
        int baris = tabel.getSelectedRow();
        
        String judul = tabel.getValueAt(baris, 1).toString();
        String penulis = tabel.getValueAt(baris, 2).toString();
        String harga = tabel.getValueAt(baris, 3).toString();
        String id = tabel.getValueAt(baris, 0).toString();
        
        txtjudul.setText(judul);
        cbpenulis.setSelectedItem(penulis);
        txtharga.setText(harga);
    }//GEN-LAST:event_tabelMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        //untuk menghapus data
        int baris = tabel.getSelectedRow();
        String id = tabel.getValueAt(baris, 0).toString();
        HapusData(id,baris);
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntampilActionPerformed
        InitTable();
        TampilData();
    }//GEN-LAST:event_btntampilActionPerformed

    private void btnkeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkeluarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnkeluarMouseClicked

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        model.getDataVector().removeAllElements();//untuk menghapus semua data pada tabel
        model.fireTableDataChanged();//untuk mengubah dan menghapus data yang ada pada tabel
        CariData();
    }//GEN-LAST:event_btncariActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        int baris = tabel.getSelectedRow();
        
        txtjudul.setText(tabel.getValueAt(baris, 1)).toString());
        cbpenulis.setSelectedItem(tabel.getValueAt(baris, 2).toString());
        txtharga.setText(tabel.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_formMouseClicked

    private void txtcariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtcariCaretUpdate
        // TODO add your handling code here:
        InitTable();
        if(txtcari.getText().length()==0){
                TampilData();
        }else{
            PencarianData(comboSearchBy.getSelectedItem().toString(),txtcari.getText());
        }
    }//GEN-LAST:event_txtcariCaretUpdate

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
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntampil;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox cbpenulis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjudul;
    // End of variables declaration//GEN-END:variables
}
