/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import dal.ConnectionDAL;
import dal.EmpHCountDAL;
import dal.EmployeeDAL;
import dal.PlTlDal;
import dal.SpyModuleDAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import to.EmpHol;
import to.Employee;
import to.SpyModule;

/**
 *
 * @author sai
 */
public final class Monitor extends javax.swing.JPanel {

    List<SpyModule> spymoduleList = null;
    int flag=0;
    Vector colVector = new Vector();
    Connection connection = new ConnectionDAL().getConnection();
    public static int selectedRow = 0;
    Object y;
    SpyModule spymod = new SpyModule();
    String combovalue;
    List<SpyModule> spy = null;
    int row;

    public Monitor() {
        initComponents();
        fillEmployeeComboData(employeeCB);
        
        openimageBT.addActionListener(al);
        valuesTB.getSelectionModel().addListSelectionListener(l1);
        filterBT.addActionListener(a2);
        List<SpyModule> spymod1 = null;
        spymod1 = new SpyModuleDAL().getSpyModuleDALDetails();
        for (SpyModule requestemp : spymod1) {
        
        }



    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        employeeCB = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        valuesTB = new javax.swing.JTable();
        openimageBT = new javax.swing.JButton();
        filterBT = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel1.setText("spy on employee");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel2.setText("select the employee you want to monitor :");

        employeeCB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        employeeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        valuesTB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        valuesTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(valuesTB);

        openimageBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        openimageBT.setText("open image");

        filterBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        filterBT.setText("Filter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addComponent(filterBT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(openimageBT)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employeeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openimageBT)
                    .addComponent(filterBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox employeeCB;
    private javax.swing.JButton filterBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openimageBT;
    private javax.swing.JTable valuesTB;
    // End of variables declaration//GEN-END:variables

    void fillEmployeeComboData(JComboBox jComboBox) {
        Vector vector = new Vector();
        vector.add("Please Select Junior Executive");

        int empId = LogIn.loginEmployee.getEmpId();
        int[] array = new EmpHCountDAL().getDesignation();
        int designationId = array[0];
        int deptId = array[1];
        int teamId = array[2];
        Employee tlTemp = null;
        Employee plId = null;



        List<Employee> employeelist = new EmployeeDAL().getEmployeeDetails();
        EmpHol employeeTempFinal = null;

        
        int x = LogIn.loginEmployee.getDsgnId().getDsgnId();

        for (Employee employeeTemp : employeelist) {
        
            if (x == 5||x==3) {
        
                if (employeeTemp.getDsgnId().getDsgnId() == x + 1 && employeeTemp.getDeptId().getDeptId() == deptId && employeeTemp.getTeamId().getTeamId() == teamId) {


                    vector.add(employeeTemp.getEmpName());

        
                }
            } 
          

        }
        if(x==4){
                
                Employee e2=new  PlTlDal().getJunior(LogIn.loginEmployee.getEmpId());
                vector.add(e2.getEmpName());
            }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
            jComboBox.setModel(cbm);
    }

    void refreshtb() {
      

        int x = LogIn.loginEmployee.getDsgnId().getDsgnId();
         if(x==4)  
         {
              spymoduleList = new SpyModuleDAL().getSpyModuleDALDetails2();
         }else
         {
             spymoduleList = new SpyModuleDAL().getSpyModuleDALDetails();
         }
        

        Vector rowVector = new Vector();
        for (SpyModule requestTemp : spymoduleList) {
            Vector temp = new Vector();

            if (combovalue == null ? requestTemp.getEmpId().getEmpName().toString() == null : combovalue.equals(requestTemp.getEmpId().getEmpName().toString())) {


                temp.add(requestTemp.getSpId());
                temp.add(requestTemp.getDt());
                temp.add(requestTemp.getEmpId().getEmpId());
                temp.add(requestTemp.getFile());

                rowVector.add(temp);
            }
        }
        if(flag==0)
        {
            colVector.add(0, "SP_ID");
            colVector.add(1, "DT");
            colVector.add(2, "EMP_ID");

            colVector.add(3, "FILE");
            flag=1;
        }



        TableModel model = new DefaultTableModel(rowVector, colVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        valuesTB.setModel(model);
      
        valuesTB.removeColumn(valuesTB.getColumnModel().getColumn(3));

        valuesTB.setAutoCreateRowSorter(true);
        valuesTB.setVisible(true);
        
    }
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == openimageBT) {
                new popup.popup().displayScreenshotImage();

            }
        }
    };
    ActionListener a2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == filterBT) {
                combovalue = employeeCB.getSelectedItem().toString();
                refreshtb();

            }

        }
    };
    ListSelectionListener l1 = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {

            if (valuesTB.getSelectedRow() > -1) {
                row = valuesTB.convertRowIndexToModel(valuesTB.getSelectedRow());

                List<SpyModule> spy = new SpyModuleDAL().getSpyModuleDALDetails();

                int col = valuesTB.convertColumnIndexToModel(valuesTB.getSelectedColumn());
                Object obj = valuesTB.convertRowIndexToModel(row);

                String x = obj.toString();
                

try{
     selectedRow = Integer.parseInt(x);
}
catch(Exception ex){
    
}
               
            }

        }
    };

    public static int returnSelectedRow() {
        return selectedRow;
    }
}
