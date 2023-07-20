package puskesmas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
public class Home extends javax.swing.JFrame{
    
    public Statement st;
    public ResultSet rs;
    Connection conn = koneksi.Conn.BukaConn();
    EditData edit = new EditData(); 
    public Home() {
        initComponents();
        TampilData();
    }
    
    private void Bersih() {
        
    }
    
    public void CariData () {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM tb_puskes WHERE nm_puskes = '" + txtCari.getText() + "'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nama");
            model.addColumn("Alamat");
            model.addColumn("Telepon");
            model.addColumn("Jam Buka");
            model.addColumn("Jam Tutup");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object [] data = {
                    rs.getString("nm_puskes"),
                    rs.getString("alamat"),
                    rs.getString("telepon"),
                    rs.getString("jam_buka"),
                    rs.getString("jam_tutup"),
                };
                model.addRow(data);
                tblData.setModel(model);
            }
        } catch (Exception e) {
            
        }
    }
    public void TampilData () {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM tb_puskes");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nama");
            model.addColumn("Alamat");
            model.addColumn("Telepon");
            model.addColumn("Jam Buka");
            model.addColumn("Jam Tutup");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object [] data = {
                    rs.getString("nm_puskes"),
                    rs.getString("alamat"),
                    rs.getString("telepon"),
                    rs.getString("jam_buka"),
                    rs.getString("jam_tutup"),
                };
                model.addRow(data);
                tblData.setModel(model);
            }
        } catch (Exception e) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SELAMAT DATANG");

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama Puskesmas", "Alamat", "Telepon", "Jam Buka", "Jam Tutup"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        jLabel2.setText("SISTEM INFORMASI PUSKESMAS DESA");

        jLabel3.setText("Search");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        TableModel model = tblData.getModel();
        
        EditData update = new EditData();
        update.setVisible(true);
        this.dispose();
        
        int data = tblData.getSelectedRow();
        if (data == -1) {
            JOptionPane.showMessageDialog(null,"Silahkan Pilih Data Terlebih Dahulu!!");
        } else {
            
            String nama = model.getValueAt(data,0).toString();
            String alamat = model.getValueAt(data,1).toString();
            String telepon = model.getValueAt(data,2).toString();
            String buka = model.getValueAt(data,3).toString();
            String tutup = model.getValueAt(data,4).toString();
            
            
            update.txtNama.setText(nama);
            update.txtAlamat.setText(alamat);
            update.txtTlp.setText(telepon);
            update.txtBuka.setText(buka);
            update.txtTutup.setText(tutup);
        }
    }//GEN-LAST:event_btnEditActionPerformed
    
    
    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked

        //int index = tblData.getSelectedRow();
        //TableModel model = tblData.getModel();
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        
        try {
            st = conn.createStatement();
            String del = ("DELETE FROM tb_puskes WHERE nm_puskes = '" + tblData + "'");
            int SelectedRowIndex = tblData.getSelectedRow();
            model.removeRow(SelectedRowIndex);
            st.executeUpdate(del);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            //TampilData();
            //Bersih();
            //String jawab;
            //return  String jawab = JOptionPane.showMessageDialog(null, "Anda Yakin Ingin menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Dulu !");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
       CariData();
    }//GEN-LAST:event_txtCariKeyPressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       TambahData add = new TambahData();
       add.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

  
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

   
}
