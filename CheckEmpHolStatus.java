/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import dal.CheckEmpHolRequestsDAL;
import dal.ConnectionDAL;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import to.EmpHol;

/**
 *
 * @author sai
 */
public class CheckEmpHolStatus extends javax.swing.JPanel {
 List<EmpHol> EmpHolRequestList = null;
    Vector colVector = new Vector();
    Connection connection = new ConnectionDAL().getConnection();
    /**
     * Creates new form CheckEmpHolStatus
     */
    public CheckEmpHolStatus() {
        initComponents();
        refreshtb();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        holidaystatusTB = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        holidaystatusTB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        holidaystatusTB.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(holidaystatusTB);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel1.setText("your holiday's status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel1)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable holidaystatusTB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

void refreshtb() {

        EmpHolRequestList = new CheckEmpHolRequestsDAL().getCheckEmpHolStatusDetails();


        Vector rowVector = new Vector();
        for (EmpHol requestTemp : EmpHolRequestList) {
            Vector temp = new Vector();
            temp.add(requestTemp.getempname().getEmpName());          
            temp.add(requestTemp.getStartDate());
            temp.add(requestTemp.getEndDate());
            temp.add(requestTemp.getReason());
            temp.add(requestTemp.getType());
            temp.add(requestTemp.getEhId());
            temp.add(requestTemp.getStatus());
            temp.add(requestTemp.getRejReason());
            rowVector.add(temp);
        }
        colVector.add(0,"EMPLOYEE-NAME");
        colVector.add(1,"START_DATE");
        colVector.add(2,"END_DATE");
        colVector.add(3,"REASON");
        colVector.add(4,"TYPE");
        colVector.add(5,"EH_ID");
        colVector.add(6,"STATUS");
        colVector.add(7,"COMMENTS");
        TableModel model = new DefaultTableModel(rowVector, colVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        holidaystatusTB.setModel(model);
                holidaystatusTB.removeColumn(holidaystatusTB.getColumnModel().getColumn(5));
                holidaystatusTB.removeColumn(holidaystatusTB.getColumnModel().getColumn(4));
                holidaystatusTB.removeColumn(holidaystatusTB.getColumnModel().getColumn(0));
                

    }

}
