/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

//import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.coobird.thumbnailator.Thumbnails;
import nusantarafood.DatabaseUtilities;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class ManipulationData extends javax.swing.JFrame {

    /**
     * Creates new form ManipulationData
     */
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public ManipulationData() {
        initComponents();
        conn = DatabaseUtilities.getConnection();
        readData();
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
        jLabel1 = new javax.swing.JLabel();
        textField_foodName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBox_province = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        label_foodImage = new javax.swing.JLabel();
        textField_imagePath = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_uploadImage = new javax.swing.JButton();
        btn_uploadImage.setUI(new RoundedCornerButtonUI());
        btn_save = new javax.swing.JButton();
        btn_save.setUI(new RoundedCornerButtonUI());
        btn_clear = new javax.swing.JButton();
        btn_clear.setUI(new RoundedCornerButtonUI());
        btn_update = new javax.swing.JButton();
        btn_update.setUI(new RoundedCornerButtonUI());
        btn_delete = new javax.swing.JButton();
        btn_delete.setUI(new RoundedCornerButtonUI());
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        textArea_steps = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        textArea_ingredients = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        textField_foodID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton1.setUI(new RoundedCornerButtonUI());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 185, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Makanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Javanese Text", 0, 18))); // NOI18N

        jLabel1.setText("Nama Makanan");

        jLabel2.setText("Asal Makanan");

        jLabel3.setLabelFor(textArea_ingredients);
        jLabel3.setText("Cara Masak");

        comboBox_province.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nanggroe Aceh Darussalam", "Sumatera Utara", "Sumatera Barat", "Riau", "Kepulauan Riau", "Jambi", "Bengkulu", "Sumatera Selatan", "Bangka Belitung", "Lampung", "Banten", "DKI Jakarta", "Jawa Barat", "Jawa Tengah", "DI Yogyakarta", "Jawa Timur", "Bali", "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Tengah", "Kalimantan Selatan", "Kalimantan Timur", "Kalimantan Utara", "Sulawesi Barat", "Sulawesi Tengah", "Sulawesi Selatan", "Sulawesi Tenggara", "Sulawesi Utara", "Gorontalo", "Maluku", "Maluku Utara", "Papua Barat", "Papua" }));
        comboBox_province.setSelectedIndex(-1);

        jLabel4.setText("Bahan");

        jDesktopPane1.setLayer(label_foodImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_foodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_foodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setText("Image Path");

        btn_uploadImage.setForeground(new java.awt.Color(255, 255, 255));
        btn_uploadImage.setText("Upload Image");
        btn_uploadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadImageActionPerformed(evt);
            }
        });

        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/Save-icon.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/clear.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/update.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/delete.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "FoodID", "Food", "Province"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        textArea_steps.setColumns(20);
        textArea_steps.setRows(5);
        jScrollPane4.setViewportView(textArea_steps);

        textArea_ingredients.setColumns(20);
        textArea_ingredients.setRows(5);
        jScrollPane5.setViewportView(textArea_ingredients);

        jLabel6.setText("ID Makanan");

        textField_foodID.setEnabled(false);

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textField_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btn_uploadImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_save)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_update)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_delete)))
                            .addGap(104, 104, 104))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textField_foodName, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_foodID, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBox_province, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addGap(8, 8, 8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(textField_foodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textField_foodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(comboBox_province, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textField_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_uploadImage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_save)
                            .addComponent(btn_update)
                            .addComponent(btn_delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clear))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_uploadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadImageActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        textField_imagePath.setText(filename);
        try {
            File image = new File(filename);
            BufferedImage thumbnail = Thumbnails.of(image).size(300, 225).asBufferedImage();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(thumbnail, "jpeg", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum = is.read(buf))!=-1;){
                bos.write(buf,0,readNum);
            }
            viewimage = new ImageIcon(thumbnail);
            label_foodImage.setIcon(viewimage);
            foodimage = bos.toByteArray();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_uploadImageActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "insert into makanan (nama_makanan, id_provinsi, bahan, cara_masak, "
                    + "gambar_makanan) values (?, ?, ?, ?, ?);";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, textField_foodName.getText());
            pst.setInt(2, comboBox_province.getSelectedIndex()+1);
            pst.setString(3, textArea_ingredients.getText());
            pst.setString(4, textArea_steps.getText());
            pst.setBytes(5, foodimage);
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Saved Succesful");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        } finally{
            try {
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        readData();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        textField_foodID.setText("");
        textField_foodName.setText("");
        textField_imagePath.setText("");
        textArea_ingredients.setText("");
        textArea_steps.setText("");
        label_foodImage.setIcon(null);
        comboBox_province.setSelectedIndex(-1);
        btn_save.setEnabled(true);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try{
        String sql = "UPDATE  makanan set nama_makanan=?, id_provinsi=?, bahan=?,"
                + " cara_masak=?, gambar_makanan=? where id_makanan = ?";
        pst = conn.prepareStatement(sql);
        System.out.println("Success to create prepare");
        
        
       pst = conn.prepareStatement(sql);
            pst.setString(1, textField_foodName.getText());
            pst.setInt(2, comboBox_province.getSelectedIndex()+1);
            pst.setString(3, textArea_ingredients.getText());
            pst.setString(4, textArea_steps.getText());
            pst.setBytes(5, foodimage);
            pst.setString(6, textField_foodID.getText());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Updated Succesfull");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        } finally{
            try {
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if(textField_foodName.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please select data to delete");
        }
        else{
            int p =JOptionPane.showConfirmDialog(null, "Do you really want to delete", "Delete",JOptionPane.YES_NO_OPTION);
            if(p == 0){
                try{
                    String sql = "DELETE from makanan WHERE id_makanan =?;";
                    pst = conn.prepareStatement(sql);
                    System.out.println("Success to create prepare");

                    pst.setInt(1, Integer.parseInt(textField_foodID.getText()));
                    pst.execute();
                }
                catch(SQLException ex){
                    System.out.println("Failed to create prepare :"+ex.getMessage());
                }
                finally{
                    if(pst !=null){
                        try{
                            readData();
                            pst.close();
                            System.out.println("Success to close prepare");
                        }
                        catch(SQLException ex){
                            System.out.println("Fail to close prepare "+ex.getMessage());
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        String idClickedTable = (jTable1.getModel().getValueAt(row, 0).toString());
        
        try {
            String sql = "select m.id_makanan, m.nama_makanan, p.nama_provinsi, m.bahan, m.cara_masak, m.gambar_makanan"
                    + " from makanan m, provinsi p where m.id_provinsi=p.id_provinsi and id_makanan = " + idClickedTable;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                String strid = rs.getString("id_makanan");
                textField_foodID.setText(strid);
                String strname = rs.getString("nama_makanan");
                textField_foodName.setText(strname);
                String stringre = rs.getString("bahan");
                textArea_ingredients.setText(stringre);
                String strstep = rs.getString("cara_masak");
                textArea_steps.setText(strstep);
                String strasal = rs.getString("nama_provinsi");
                comboBox_province.setSelectedItem(strasal);

                byte[] imagedata = rs.getBytes("gambar_makanan");
                foodimage = imagedata;
                viewimage = new ImageIcon(imagedata);
                label_foodImage.setIcon(viewimage);
                btn_save.setEnabled(false);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+" 1");
        }
        finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage()+" 2");
            }
        }
      
      readData();  
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new LoginAdmin().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void readData() {
        try {
            String sql = "select m.id_makanan, m.nama_makanan, p.nama_provinsi from makanan m join provinsi p on (m.id_provinsi=p.id_provinsi)";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
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
            java.util.logging.Logger.getLogger(ManipulationData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManipulationData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManipulationData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManipulationData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManipulationData md = new ManipulationData();
                md.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_uploadImage;
    private javax.swing.JComboBox<String> comboBox_province;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_foodImage;
    private javax.swing.JTextArea textArea_ingredients;
    private javax.swing.JTextArea textArea_steps;
    private javax.swing.JTextField textField_foodID;
    private javax.swing.JTextField textField_foodName;
    private javax.swing.JTextField textField_imagePath;
    // End of variables declaration//GEN-END:variables

    String filename;
    private ImageIcon viewimage = null;
    byte[] foodimage = null;
}
