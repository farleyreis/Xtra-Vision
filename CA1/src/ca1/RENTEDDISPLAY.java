/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Farley Matheus
 */
public class RENTEDDISPLAY extends javax.swing.JFrame {

    /**
     * Creates new form Rented_Movies
     */
    public RENTEDDISPLAY() {
        initComponents();
        this.screen = this;
    }
    JFrame screen;

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_var = new javax.swing.JTable();
        back_btn = new javax.swing.JButton();
        load_data = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1400, 788));

        table_var.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Movie Name", "Genero", "Description", "Date", "Return"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_var.getTableHeader().setResizingAllowed(false);
        table_var.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_var);

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        load_data.setText("Load Data");
        load_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_dataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(back_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(load_data)
                .addGap(493, 493, 493))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(load_data)
                    .addComponent(back_btn))
                .addGap(100, 100, 100))
        );

        pack();
    }// </editor-fold>

    private void load_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_dataActionPerformed

           try {
            Connection connection = DriverManager.getConnection("com.mysql.jdbc.Driver");
            Statement  statement = connection.createStatement();
            statement.execute("select * from [Movies] INNER join [movie] ON movie.id=movie_record.idMovie");
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next())
            {
                
                Object[] row = { Integer.parseInt(resultSet.getString("id")) , (resultSet.getString("movie")), (resultSet.getString("price")) , (resultSet.getString("person_name")), (resultSet.getString("code")) , (resultSet.getString("movie_purchased")) , (resultSet.getString("total_amount")) , (resultSet.getString("returned"))    };         
                DefaultTableModel model;
                model = (DefaultTableModel) table_var.getModel();
                model.addRow(row);
            }
            resultSet.close();
            
            statement.close();
            connection.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DVDRENT.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        // TODO add your handling code here:
    }//GEN-LAST:event_load_dataActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        screen.setVisible(false);
        (new CA1()).setVisible(true);
    }//GEN-LAST:event_back_btnActionPerformed

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
            java.util.logging.Logger.getLogger(RENTEDDISPLAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RENTEDDISPLAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RENTEDDISPLAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RENTEDDISPLAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RENTEDDISPLAY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton load_data;
    private javax.swing.JTable table_var;
    // End of variables declaration//GEN-END:variables
}
