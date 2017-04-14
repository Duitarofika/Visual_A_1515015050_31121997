import POSTTEST7.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duita
 */
public class FormDataBuku extends javax.swing.JFrame {
private DefaultTableModel model;
private Connection con = Koneksi.getConnection();
private Statement stt;
private ResultSet rss;
private boolean status;
private void InitTable(){ //inisiasi tabel
    model = new DefaultTableModel();//pembuatan variabel baru model
    model.addColumn("ID BUKU");//penambahan kolom ID pada tabel model
    model.addColumn("JUDUL");
    model.addColumn("PENULIS");
    model.addColumn("HARGA");
    jTable1.setModel(model);
}
private void TambahData(String judul,String penulis,String harga){//Method untuk menambahkan data
    try{//blok percobaan
        String sql =
                "INSERT INTO buku VALUES(NULL,'"+judul+"','"+penulis+"',"+harga+")";//pengisian tabel pada databaase
        stt = con.createStatement();//pembuatan statement
        stt.executeUpdate(sql);
        model.addRow(new Object[]{judul,penulis,harga});//penambahan objek berupa array
        while(rss.next()){
        Object[] o=new Object[2];
        o[0]=rss.getString("judul").toLowerCase();
        o[1]=rss.getString("penulis").toLowerCase();
        if(o[0].equals(judul.toLowerCase())&& o[1].equals(penulis.toLowerCase())){
            JOptionPane.showMessageDialog(null,"Data Sudah ada");
            status=false;
            break;
        }
    }
    if(status==true){
        TambahData(judul,penulis,harga);
    }
    }
    catch(SQLException e){//blok penagkap kesalaan
        System.out.println(e.getMessage());//jika terjadi kesalahan akan menampilkan pemberitahuan kesalahan yang terjadi
    }
}
private void ValidasiData(String judul,String penulis,String harga){
try{
    String sql="select*from buku";
    stt=con.createStatement();
    rss=stt.executeQuery(sql);
    while(rss.next()){
        Object[] o=new Object[2];
        o[0]=rss.getString("judul").toLowerCase();
        o[1]=rss.getString("penulis").toLowerCase();
        if(o[0].equals(judul.toLowerCase())&& o[1].equals(penulis.toLowerCase())){
            JOptionPane.showMessageDialog(null,"Data Sudah ada");
            status=false;
            break;
        }
    }
    if(status==true){
        TambahData(judul,penulis,harga);
    }
}
catch(SQLException e){
    System.out.println(e.getMessage());
}
}
    private void TampilData(){//method untuk menampilkan data
        try{//blok percobaan
            String sql = "SELECT * FROM buku";//variabel sql yang bernilai menampilkan isi tabel pada database
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){//tampilkan data 
                Object[] o = new Object[4];//penambahan array untuk pengisian tabel
                o[0] = rss.getString("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        }catch(SQLException e){//digunakan untuk menangkap kesalahan yang terjadi
            System.out.println(e.getMessage());
        }
    }
private boolean UbahData(String id, String judul, String penulis, String harga){//method untuk mengubah data
        try{//blok percoban
            String sql = "UPDATE buku SET judul='"+judul+"', penulis='"+penulis+"', harga='"+harga+"' WHERE id="+id+";";//variabel sql untuk pengupdatetan di tabel
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){//penangkap kesalahan
            System.out.println(e.getMessage());
            return false;
        }
}
 private boolean HapusData(String id){//method untuk menghapus data
        try{
        String sql = "DELETE FROM buku WHERE id='"+id+"'";
        stt=con.createStatement();
        stt.executeUpdate(sql);
        return true;//menghapus baris dalam tabel
    }catch(SQLException e){//blok penangkap kesalahan
            System.out.println(e.getMessage());
            return false;
        }
    }
 private void PencarianData(String by, String cari){//method untuk pencarian 
        try{
            String sql = "SELECT * FROM buku where "+by+" LIKE'%"+cari+"%';";//menampilkan seluruh isi tabel
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] data = new Object[4];//penambahan array yang akan ditambahkan ke tabel
                data[0] = rss.getString("id");
                data[1] = rss.getString("judul");
                data[2] = rss.getString("penulis");
                data[3] = rss.getString("harga");
            model.addRow(data);
            }
    }catch(SQLException e){//digunakan untuk menangkap kesalahan
            System.out.println(e.getMessage());
    }
        }
 
 
    /**
     * Creates new form FormDataBuku
     */
    public FormDataBuku() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Penulis = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboPenulis = new javax.swing.JComboBox();
        txtJudul = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        txtHapus = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        comboSearchBy = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Form Data Buku");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));

        jLabel1.setText("Judul");

        Penulis.setText("Penulis");

        jLabel3.setText("Harga");

        comboPenulis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tere Liye", "W.s Rendra", "Felix Siauw", "Asma Nadia", "Dewi Lestari" }));

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        txtHapus.setText("Hapus");
        txtHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHapusActionPerformed(evt);
            }
        });

        jButton4.setText("Keluar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Search :");

        txtCari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCariCaretUpdate(evt);
            }
        });
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        comboSearchBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "judul", "penulis", "harga" }));

        jLabel5.setText("By");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(comboSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnubah, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(90, 90, 90)
                        .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Penulis))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Penulis))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "JUDUL", "PENGARANG", "HARGA"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
InitTable();
TampilData();// TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
System.exit(0);        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

String judul=txtJudul.getText();
String penulis=comboPenulis.getSelectedItem().toString();
String harga=txtHarga.getText();
TambahData(judul,penulis,harga);// TODO add your handling code here:
ValidasiData(judul,penulis,harga);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        int baris = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(baris, 0).toString();
        String judul = txtJudul.getText();
        String penulis = comboPenulis.getSelectedItem().toString();
        String harga = txtHarga.getText();
        
        if(UbahData(id, judul, penulis, harga))
            JOptionPane.showMessageDialog(null,"Berhasil Ubah Data");
        else
            JOptionPane.showMessageDialog(null,"Gagal Ubah Data");
    }//GEN-LAST:event_btnubahActionPerformed

    private void txtHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHapusActionPerformed
        int baris = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(baris, 0).toString();
        
        if(HapusData(id)){
            JOptionPane.showMessageDialog(null,"Berhasil Hapus Data");}
    }//GEN-LAST:event_txtHapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
int baris=jTable1.getSelectedRow();

txtJudul.setText(jTable1.getValueAt(baris,1).toString());
comboPenulis.setSelectedItem(jTable1.getValueAt(baris, 2).toString());
txtHarga.setText(jTable1.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCariCaretUpdate
InitTable();
if(txtCari.getText().length()==0){
TampilData();
}else {
PencarianData(comboSearchBy.getSelectedItem().toString(),txtCari.getText());
}// TODO add your handling code here:
    }//GEN-LAST:event_txtCariCaretUpdate
    
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
            @Override
            public void run() {
                new FormDataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Penulis;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox comboPenulis;
    private javax.swing.JComboBox<String> comboSearchBy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCari;
    private javax.swing.JButton txtHapus;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJudul;
    // End of variables declaration//GEN-END:variables
}
