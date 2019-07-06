/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import nusantarafood.DatabaseUtilities;
import nusantarafood.Makanan;
import nusantarafood.RequestImage;
import java.awt.Graphics;

/**
 *
 * @author User
 */
public class Region extends javax.swing.JFrame {

    /**
     * Creates new form Region
     */
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Region(int regionID) {
        this.regionID = regionID;
//        d = new Dimension(900, 675);
        addFoodLabels();
        initComponents();
//        System.out.println(foodLabel.get(0).size());
        backgroundPanel = RequestImage.requesting("src\\images\\background4.jpg",1092,676);
    }
    
    public void setPrev(JFrame prev){
        this. prev = prev;
    }

    public void setPanel2Dim(int rows){
        int viewrow = (int) Math.ceil(rows/3);
        d = new Dimension(930, ((225*viewrow)+((viewrow-1)*15)));
    }

    private void addFoodLabels(){
        foodLabel = new ArrayList<JLabel>();
        foodAtribute = new HashMap<JLabel,Makanan>();
        try {
            String sql = "SELECT m.id_makanan, m.nama_makanan, p.nama_provinsi, m.gambar_makanan "
                    + "from makanan m, provinsi p, regional r "
                    + "where m.id_provinsi = p.id_provinsi and p.id_regional = r.id_regional "
                    + "and r.id_regional = "+regionID+" order by m.id_makanan";
            conn = DatabaseUtilities.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            int rows = 0;
            while(rs.next()){
                byte[] foodPhoto = rs.getBytes("gambar_makanan");
                JLabel food = new JLabel("");
                food.setIcon(new ImageIcon(foodPhoto));
                foodLabel.add(food);
                Integer id = rs.getInt("id_makanan");
                String name = rs.getString("nama_makanan");
                String asal = rs.getString("nama_provinsi");
                Makanan m = new Makanan(id, name, asal);
                foodAtribute.put(food,m);
                rows++;
            }
            setPanel2Dim(rows);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);    
        } finally{
            try {
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void clicked(Masakan m){
        m.setPrev(this);
        m.setVisible(true);
        this.setVisible(false);
    }
    
    private void addFoodLabelListener(){
        for(int i=0; i<foodLabel.size(); i++){
            JLabel food = foodLabel.get(i);
            Makanan mk = foodAtribute.get(food);
            food.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
//                    JOptionPane.showMessageDialog(null, foodID.get(food));
//                    System.out.println(mk.getId() + mk.getNama() + mk.getAsal());
                    Masakan m = new Masakan(mk.getId());
                    clicked(m);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt){
//                    System.out.println(food.getBounds());
                    label_foodName.setText(mk.getNama());
                    label_foodProvince.setText(mk.getAsal());
                }
                public void mouseExited(java.awt.event.MouseEvent evt){
                    label_foodName.setText("Nama Makanan");
                    label_foodProvince.setText("Provinsi");
                }
            });
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

        jPanel2 = new javax.swing.JPanel();
        jPanel2.setPreferredSize(d);
        jPanel1 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundPanel, 0, 0, this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        label_foodName = new javax.swing.JLabel();
        label_foodProvince = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        btn_back.setUI(new RoundedCornerButtonUI());

        addFoodLabelListener();
        jPanel2.setBackground(new java.awt.Color(255, 185, 1));
        jPanel2.setLayout(new java.awt.GridLayout(0, 3, 15, 15));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(234, 217, 171));

        jLabel1.setFont(new java.awt.Font("Javanese Text", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Papua");

        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        label_foodName.setFont(new java.awt.Font("Javanese Text", 0, 18)); // NOI18N
        label_foodName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_foodName.setText("Makanan");

        label_foodProvince.setFont(new java.awt.Font("Javanese Text", 0, 18)); // NOI18N
        label_foodProvince.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_foodProvince.setText("Provinsi");

        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel1.setText(island[regionID-1]);
        for (int i=0; i<foodLabel.size(); i++){
            JLabel food = foodLabel.get(i);
            food.setText("");
            jPanel2.add(food);
        }
        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_back)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_foodName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_foodProvince, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_back)
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_foodName)
                .addGap(11, 11, 11)
                .addComponent(label_foodProvince)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        dispose();
        new Indonesia().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(Region.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Region.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Region.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Region.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Region(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_foodName;
    private javax.swing.JLabel label_foodProvince;
    // End of variables declaration//GEN-END:variables

    private ArrayList<JLabel> foodLabel;
    private JFrame prev;
    private HashMap<JLabel,Makanan> foodAtribute;
    private ImageIcon viewimage = null;
    private Dimension d;
    private int regionID;
    private String[] island = {"Sumatera","Jawa","Kalimantan","Sulawesi","Bali dan Nusa Tenggara","Maluku dan Papua"};
    private Image backgroundPanel = null;
}
