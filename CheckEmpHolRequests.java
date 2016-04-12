/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import dal.CheckEmpHolRequestsDAL;
import dal.ConnectionDAL;
import dal.EmpHolDAL;
import dal.RequestDAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import to.EmpHol;
import to.Request;

/**
 *
 * @author sai
 */
public class CheckEmpHolRequests extends javax.swing.JPanel {

    /**
     * Creates new form CheckEmpHolRequests
     */
    List<EmpHol> EmpHolRequestList = null;
    Vector colVector = new Vector();
    Connection connection = new ConnectionDAL().getConnection();
    public static int selectedRow = 0;

    public CheckEmpHolRequests() {
        initComponents();
        System.out.println("before refresh");
        refreshtb();
      //  EmpHolRequestList = new CheckEmpHolRequestsDAL().getCheckEmpHolRequestDetails();

//        empholreqTB.getSelectionModel().addListSelectionListener(l1);          
      //  searchTF.setEnabled(false);
        takeactionBT.addActionListener(al);
        empholreqTB.getSelectionModel().addListSelectionListener(l1);


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
        pendingreqLB = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empholreqTB = new javax.swing.JTable();
        takeactionBT = new javax.swing.JButton();

        pendingreqLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        pendingreqLB.setText("PENDING REQUESTS");

        empholreqTB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        empholreqTB.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(empholreqTB);

        takeactionBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        takeactionBT.setText("take action");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(takeactionBT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(299, 299, 299)
                            .addComponent(pendingreqLB))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pendingreqLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(takeactionBT)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable empholreqTB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pendingreqLB;
    private javax.swing.JButton takeactionBT;
    // End of variables declaration//GEN-END:variables

    void refreshtb() {

        EmpHolRequestList = new CheckEmpHolRequestsDAL().getCheckEmpHolRequestDetails();
        
        //colVector = new RequestDAL().getRequestColumnDetails();

        Vector rowVector = new Vector();
        for (EmpHol requestTemp : EmpHolRequestList) {

            Vector temp = new Vector();
            temp.add(requestTemp.getempname().getEmpName());          
            temp.add(requestTemp.getStartDate());
            temp.add(requestTemp.getEndDate());
            temp.add(requestTemp.getReason());
            if(requestTemp.getType1()==600){
                temp.add("Casual Leave");
            }
            else if(requestTemp.getType1()==500){
                temp.add("Sick Leave");
            }
            else if(requestTemp.getType1()==200){
                temp.add("Maternity Leave");
            }
            else if(requestTemp.getType1()==100){
                temp.add("Compensatory Leave");
            }
            else if(requestTemp.getType1()==300){
                temp.add("Loss Of Pay Leave");
            }
            else if(requestTemp.getType1()==400){
                temp.add("Earned Leave");
            }
            
           // System.out.println("CO_COUNT is:"+requestTemp.getType().getCOCount());
           // temp.add(requestTemp.getType1());
            temp.add(requestTemp.getEhId());
            temp.add(requestTemp.getType().getElCount());
            temp.add(requestTemp.getType().getClCount());
            temp.add(requestTemp.getType().getSlCount());
            temp.add(requestTemp.getType().getLOPCount());
            temp.add(requestTemp.getType().getMLCount());
            temp.add(requestTemp.getType().getCOCount());
            rowVector.add(temp);
        }
        colVector.add(0,"EMPLOYEE-NAME");
        colVector.add(1,"STRT_DT");
        colVector.add(2,"END_DT");
        colVector.add(3,"REASON");
        colVector.add(4,"TYPE");
        colVector.add(5,"EH_ID");
        colVector.add(6,"El_CNT");
        colVector.add(7,"Cl_CNT");
        colVector.add(8,"Sl_CNT");
        colVector.add(9,"LOP_CNT");
        colVector.add(10,"ML_CNT");
        colVector.add(11,"CO_CNT");
        
        TableModel model = new DefaultTableModel(rowVector, colVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        
        empholreqTB.setModel(model);
        empholreqTB.setAutoCreateRowSorter(true);
        empholreqTB.setVisible(true);
        pendingreqLB.setVisible(true);
        empholreqTB.removeColumn(empholreqTB.getColumnModel().getColumn(5));

    }

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == takeactionBT) {

                new popup.popup().displayEmpholDetail();
            }
        }
 };
    ListSelectionListener l1 = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {

            if (empholreqTB.getSelectedRow() > -1) {
                int row = empholreqTB.convertRowIndexToModel(empholreqTB.getSelectedRow());



                int col = empholreqTB.convertColumnIndexToModel(empholreqTB.getSelectedColumn());

                
                Object obj = empholreqTB.getModel().getValueAt(row, 5);

                String x = obj.toString();

                
                selectedRow = Integer.parseInt(x);
            }

        }
    };

    public static int returnSelectedRow() {
        return selectedRow;
    }
    

  
}
