/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyPackage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JPanel;
//jdbc:mysql://localhost:3306/banque?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]
/**
 *
 * @author Mandranto
 */
public class Clients extends javax.swing.JFrame {
private static final String username = "root" ;
    private static final String password = "" ;
    private static final String dataConn = "jdbc:mysql://localhost:3306/banque" ;
    
    Connection sqlConn = null ;
    PreparedStatement pst = null ;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    public Clients() {
        initComponents();
        Read();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void Read() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        sqlConn = DriverManager.getConnection(dataConn, username, password);
        pst = sqlConn.prepareStatement("SELECT * FROM client");

        rs = pst.executeQuery();
        ResultSetMetaData rsMetaData = rs.getMetaData();

        int columnCount = rsMetaData.getColumnCount();
        DefaultTableModel recordTable = (DefaultTableModel) jTableClient.getModel();
        recordTable.setRowCount(0);

        while (rs.next()) {
            Vector<Object> rowData = new Vector<>();

            for (int i = 1; i <= columnCount; i++) {
                rowData.add(rs.getObject(i));
            }

            recordTable.addRow(rowData);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}

    public void Search() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        sqlConn = DriverManager.getConnection(dataConn, username, password);
        pst = sqlConn.prepareStatement("SELECT * FROM client WHERE numCompte LIKE ? OR nom LIKE ?");
        pst.setString(1, "%" + jTextRecherche.getText() + "%"); // Utilisez getText() pour obtenir la valeur de recherche du numéro de compte
        pst.setString(2, "%" + jTextRecherche.getText() + "%"); // Utilisez getText() pour obtenir la valeur de recherche du nom

        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rsMetaData = rs.getMetaData();

        int columnCount = rsMetaData.getColumnCount();
        DefaultTableModel recordTable = (DefaultTableModel) jTableClient.getModel();
        recordTable.setRowCount(0);

        while (rs.next()) {
            Vector<String> columnData = new Vector<>();

            for (int i = 1; i <= columnCount; i++) {
                columnData.add(rs.getString(i));
            }

            recordTable.addRow(columnData);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNuméroDeCompte = new javax.swing.JLabel();
        jTextNuméroDeCompte = new javax.swing.JTextField();
        jLabelNom = new javax.swing.JLabel();
        jTextNom = new javax.swing.JTextField();
        jLabelPrénoms = new javax.swing.JLabel();
        jTextPrénoms = new javax.swing.JTextField();
        jLabelTéléphone = new javax.swing.JLabel();
        jTextTéléphone = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabelSolde = new javax.swing.JLabel();
        jTextSolde = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClient = new javax.swing.JTable();
        jButtonAjouterClient = new javax.swing.JButton();
        jButtonModifierClient = new javax.swing.JButton();
        jButtonSupprimerClient = new javax.swing.JButton();
        jLabelRecherche = new javax.swing.JLabel();
        jTextRecherche = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNuméroDeCompte.setText("Numéro de Compte");

        jLabelNom.setText("Nom");

        jLabelPrénoms.setText("Prénoms");

        jTextPrénoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrénomsActionPerformed(evt);
            }
        });

        jLabelTéléphone.setText("Téléphone");

        jLabelEmail.setText("Email");

        jLabelSolde.setText("Solde");

        jTableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Num Compte", "Nom", "Prénoms", "Téléphone", "Email", "Solde"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClient);

        jButtonAjouterClient.setText("Ajouter");
        jButtonAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterClientActionPerformed(evt);
            }
        });

        jButtonModifierClient.setText("Modifier");
        jButtonModifierClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierClientActionPerformed(evt);
            }
        });

        jButtonSupprimerClient.setText("Supprimer");
        jButtonSupprimerClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerClientActionPerformed(evt);
            }
        });

        jLabelRecherche.setText("Recherche Client");

        jTextRecherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextRechercheKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelSolde, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextSolde))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTéléphone, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextTéléphone))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelPrénoms, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextPrénoms))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextNom))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNuméroDeCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextNuméroDeCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAjouterClient, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonModifierClient, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSupprimerClient))
                        .addGap(105, 105, 105))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabelRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jTextRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAjouterClient, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNuméroDeCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextNuméroDeCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModifierClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrénoms, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPrénoms, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSupprimerClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTéléphone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTéléphone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSolde, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSolde, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 14, 514, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModifierClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierClientActionPerformed

        try
            {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareStatement("UPDATE client SET NumCompte=? ,Nom=? ,Prénoms=? ,Tel=? ,mail=? , Solde=?   WHERE NumCompte=? ");
                              
                pst.setString(1, jTextNuméroDeCompte.getText());
                pst.setString(2, jTextNom.getText());
                pst.setString(3, jTextPrénoms.getText());
                pst.setString(4, jTextTéléphone.getText());
                pst.setString(5, jTextEmail.getText());
               
                pst.setString(6, jTextSolde.getText());
                pst.setString(7, jTextNuméroDeCompte.getText());

                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Updated");
                jTextNuméroDeCompte.setText("");
                jTextNom.setText("");
                jTextPrénoms.setText("");
                jTextTéléphone.setText("");
                jTextEmail.setText("");
                jTextSolde.setText("");
                Read();
                
            }
        catch(ClassNotFoundException | SQLException ex)
         {
             java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
         }
    }//GEN-LAST:event_jButtonModifierClientActionPerformed

    private void jButtonAjouterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterClientActionPerformed
        try
            {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareStatement("INSERT INTO client(NumCompte,Nom,Prénoms,Tel,mail,Solde)value(?,?,?,?,?,?)");
                
                pst.setString(1, jTextNuméroDeCompte.getText());
                pst.setString(2, jTextNom.getText());
                pst.setString(3, jTextPrénoms.getText());
                pst.setString(4, jTextTéléphone.getText());
                pst.setString(5, jTextEmail.getText());
                pst.setString(6, jTextSolde.getText());
               
                
                //JOptionPane.showMessageDialog(this, "Remplissez le champ");
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Added");
                jTextNuméroDeCompte.setText("");
                jTextNom.setText("");
                jTextPrénoms.setText("");
                jTextTéléphone.setText("");
                jTextEmail.setText("");
                jTextSolde.setText("");
                Read();
            }
         catch(ClassNotFoundException | SQLException ex)
         {
             java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
         }
    }//GEN-LAST:event_jButtonAjouterClientActionPerformed

    private void jTextPrénomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrénomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrénomsActionPerformed

    private void jButtonSupprimerClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerClientActionPerformed
        try
        {
            //id  = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());//tsy ilaina
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you wanna delete","warning",JOptionPane.YES_NO_OPTION);
            if(deleteItem == JOptionPane.YES_OPTION)
            {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareStatement("DELETE FROM client WHERE NumCompte = ? ");
              
              pst.setString(1, jTextNuméroDeCompte.getText());
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Deleted");
                Read();
                
                jTextNuméroDeCompte.setText("");
                jTextNuméroDeCompte.requestFocus();
                jTextNom.setText("");
                jTextPrénoms.setText("");
                jTextTéléphone.setText("");
                jTextEmail.setText("");
                jTextSolde.setText("");
            }
        }
        catch(ClassNotFoundException ex)
         {
             java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
         }
         catch(SQLException ex)
         {
            System.err.println(ex);
         }
        
    }//GEN-LAST:event_jButtonSupprimerClientActionPerformed

    private void jTableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientMouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel)jTableClient.getModel();
                int SelectedRows = jTableClient.getSelectedRow();
                jTextNuméroDeCompte.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
                jTextNom.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
                jTextPrénoms.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
                jTextTéléphone.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
                jTextEmail.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
                jTextSolde.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    }//GEN-LAST:event_jTableClientMouseClicked

    private void jTextRechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRechercheKeyReleased
        Search();
    }//GEN-LAST:event_jTextRechercheKeyReleased

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
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouterClient;
    private javax.swing.JButton jButtonModifierClient;
    private javax.swing.JButton jButtonSupprimerClient;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelNuméroDeCompte;
    private javax.swing.JLabel jLabelPrénoms;
    private javax.swing.JLabel jLabelRecherche;
    private javax.swing.JLabel jLabelSolde;
    private javax.swing.JLabel jLabelTéléphone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClient;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNom;
    private javax.swing.JTextField jTextNuméroDeCompte;
    private javax.swing.JTextField jTextPrénoms;
    private javax.swing.JTextField jTextRecherche;
    private javax.swing.JTextField jTextSolde;
    private javax.swing.JTextField jTextTéléphone;
    // End of variables declaration//GEN-END:variables

    void show(JPanel jPanelAffect, String clients) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
