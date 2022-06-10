/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author iwancell
 */
public class Pembelian extends javax.swing.JFrame {

    /**
     * Creates new form Pembelian
     */
    public Pembelian() {
        initComponents();
    load_table();
    }
    
    Ubah_Pembelian jtRowData = new Ubah_Pembelian();
    
    private void load_table(){
        //membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pembelian");
        model.addColumn("Nama Produk");
        model.addColumn("Waktu");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");
        model.addColumn("Nama Karyawan");

        //menampilkan data database kedalam tabel
        try {
            String sql = "SELECT pembelian.`kode_pembelian`, produk.`nama_produk`, pembelian.`waktu`, "
                    + "detail_pembelian.`jumlah`, detail_pembelian.`jumlah`*produk.`harga_beli` AS `total_harga`, karyawan.`nama`"+ 
            " FROM detail_pembelian JOIN produk ON detail_pembelian.`kode_produk`=produk.`kode_produk` "
                    + "JOIN pembelian ON detail_pembelian.`kode_pembelian`=pembelian.`kode_pembelian` JOIN karyawan on "
                    + "pembelian.`kode_karyawan`=karyawan.`kode_karyawan`"+
            " ORDER BY kode_pembelian asc";
            java.sql.Connection conn=(Connection)Konfigurasi.konfigurasiDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),
                    res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5),
                res.getString(6)});
            }
            
            jTablePembelian.setModel(model);
        } catch (Exception e){}
    tanggal();
    }
    public void tanggal(){
        SimpleDateFormat format = new SimpleDateFormat ("EEEE dd MMMM yyyy");
        java.util.Date date = new java.util.Date();
        txt_tanggal.setText(format.format(date));
    }
int post = 1;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePembelian = new javax.swing.JTable();
        txt_tanggal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblhome = new javax.swing.JLabel();
        lblproduk = new javax.swing.JLabel();
        lblpembelian = new javax.swing.JLabel();
        lblkaryawan = new javax.swing.JLabel();
        lbllaporan = new javax.swing.JLabel();
        lblpenjualan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePembelian.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablePembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePembelianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePembelian);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 770, -1));

        txt_tanggal.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        txt_tanggal.setText("tanggal");
        txt_tanggal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_tanggalMouseClicked(evt);
            }
        });
        jPanel1.add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 220, 40));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Tambah Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 110, 40));

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Ubah Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 110, 40));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Hapus");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 110, 40));

        logout_btn.setBackground(new java.awt.Color(0, 102, 102));
        logout_btn.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        logout_btn.setForeground(new java.awt.Color(255, 255, 255));
        logout_btn.setText("LOGOUT");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        jPanel1.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 130, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Pembelian.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 710));

        lblhome.setText("Home");
        lblhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhomeMouseClicked(evt);
            }
        });
        jPanel1.add(lblhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, 80));

        lblproduk.setText("Produk");
        lblproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblprodukMouseClicked(evt);
            }
        });
        jPanel1.add(lblproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 70));

        lblpembelian.setText("Pembelian");
        lblpembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblpembelianMouseClicked(evt);
            }
        });
        jPanel1.add(lblpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 90, 70));

        lblkaryawan.setText("Karyawan");
        lblkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkaryawanMouseClicked(evt);
            }
        });
        jPanel1.add(lblkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 100, 70));

        lbllaporan.setText("Laporan");
        lbllaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllaporanMouseClicked(evt);
            }
        });
        jPanel1.add(lbllaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 80, 70));

        lblpenjualan.setText("Penjualan");
        lblpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblpenjualanMouseClicked(evt);
            }
        });
        jPanel1.add(lblpenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 80, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePembelianMouseClicked
        // TODO add your handling code here:
        int index = jTablePembelian.getSelectedRow();
        TableModel model = jTablePembelian.getModel();
        String kode_pembelian = model.getValueAt(index, 0).toString();
        String jumlah = model.getValueAt(index, 2).toString();
        String total_harga = model.getValueAt(index, 3).toString();
    }//GEN-LAST:event_jTablePembelianMouseClicked

    private void txt_tanggalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tanggalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Tambah_Pembelian().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = jTablePembelian.getSelectedRow();
        TableModel model = jTablePembelian.getModel();
        String kode_pembelian = model.getValueAt(index, 0).toString();
        String nama_produk = model.getValueAt(index, 1).toString();
        String jumlah = model.getValueAt(index, 3).toString();

        this.setVisible(false);
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jtRowData.txt_kodepembelian.setText(kode_pembelian);
        jtRowData.txt_kodepembelian.disable();
        jtRowData.txt_nama.setText(nama_produk);
        jtRowData.txt_jumlah.setText(jumlah);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = jTablePembelian.getSelectedRow();
        TableModel model = jTablePembelian.getModel();
        String kode_pembelian = model.getValueAt(index, 0).toString();
        String nama_produk = model.getValueAt(index, 1).toString();
        String jumlah = model.getValueAt(index, 3).toString();

        this.setVisible(false);
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jtRowData.txt_kodepembelian.setText(kode_pembelian);
        jtRowData.txt_kodepembelian.disable();
        jtRowData.txt_nama.setText(nama_produk);
        jtRowData.txt_jumlah.setText(jumlah);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void lblprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprodukMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Produk().setVisible(true);
    }//GEN-LAST:event_lblprodukMouseClicked

    private void lblpembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpembelianMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Pembelian().setVisible(true);
    }//GEN-LAST:event_lblpembelianMouseClicked

    private void lblkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkaryawanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Karyawan().setVisible(true);
    }//GEN-LAST:event_lblkaryawanMouseClicked

    private void lbllaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllaporanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Laporan().setVisible(true);
    }//GEN-LAST:event_lbllaporanMouseClicked

    private void lblpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpenjualanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Penjualan().setVisible(true);
    }//GEN-LAST:event_lblpenjualanMouseClicked

    private void lblhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhomeMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_lblhomeMouseClicked

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
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePembelian;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblkaryawan;
    private javax.swing.JLabel lbllaporan;
    private javax.swing.JLabel lblpembelian;
    private javax.swing.JLabel lblpenjualan;
    private javax.swing.JLabel lblproduk;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel txt_tanggal;
    // End of variables declaration//GEN-END:variables
}
