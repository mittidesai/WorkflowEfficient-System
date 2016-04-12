package wfes;

import dal.ConnectionDAL;
import dal.EmployeeDAL;
import dal.PlTlDal;
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
import to.Employee;
import to.PlTl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 01
 */
public class EmployeeModify extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeModify
     */
    List<Employee> employeeList = null;
    Connection connection = new ConnectionDAL().getConnection();
    public static int selectedRow = 0;

    public EmployeeModify() {
        initComponents();

        //td.fillTableData(employeeModifyTB, new ConnectionDAL().getConnection(), "employee");
        refreshtb();


        employeeModifyTB.getSelectionModel().addListSelectionListener(l1);
        employeeModifyTB.addKeyListener(kl);
        searchTextField.setEnabled(false);
        UpdateBT.addActionListener(al);
        deleteBT.addActionListener(al);
        UpdateBT.addKeyListener(k2);
        deleteBT.addKeyListener(k2);



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
        UpdateBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeModifyTB = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        deleteBT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        UpdateBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        UpdateBT.setForeground(new java.awt.Color(86, 86, 87));
        UpdateBT.setText("UPDATE");

        employeeModifyTB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        employeeModifyTB.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(employeeModifyTB);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(86, 86, 87));
        jLabel1.setText("EMPLOYEE MODIFY");

        deleteBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        deleteBT.setForeground(new java.awt.Color(86, 86, 87));
        deleteBT.setText("DELETE");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(86, 86, 87));
        jLabel2.setText("Search:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(UpdateBT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(deleteBT))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(204, 204, 204)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UpdateBT)
                        .addComponent(deleteBT)
                        .addComponent(jLabel2))
                    .addComponent(filler2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateBT;
    private javax.swing.JButton deleteBT;
    private javax.swing.JTable employeeModifyTB;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
    
    public void deleteButtonMethod(){
         Employee employeeTempFinal = null;
                List<Employee> employeeList = new EmployeeDAL().getEmployeeDetails();

                for (Employee employeeTemp : employeeList) {
                    int x = EmployeeModify.returnSelectedRow();
                    System.out.println("Returned value" + x);
                    if (employeeTemp.getEmpId().toString().equals(x + "")) {
                        employeeTempFinal = employeeTemp;
                    }
                }

                System.out.println("EployeeTempFinal::::::"+employeeTempFinal);
                
                
                 PlTl plTlTempFinal = null;
                List<PlTl> plTlList = new PlTlDal().getPlTlDetails();

                int localflag = 0;

                for (PlTl plTlTemp : plTlList) {
                    System.out.println("Pltltemp:"+plTlTemp.getTlId().getEmpId());

                    if (plTlTemp.getTlId().getEmpId() == employeeTempFinal.getEmpId()) {
                        plTlTempFinal = plTlTemp;
                        localflag = 1;
                        break;

                    }
                }

                if (localflag == 1) {
                   // new PlTlDal().updateDeletePlTlDetails(plTlTempFinal);
                }
                
                
                
                
                new EmployeeDAL().deleteEmployeeDetails(employeeTempFinal);

               

                refreshtb();
    }
    void refreshtb() {
        Vector rowVector = new Vector();
        Vector colVector = new Vector();


        employeeList = new EmployeeDAL().getEmployeeDetails();



        for (Employee employeeTemp : employeeList) {
            Vector temp = new Vector();
            temp.add(employeeTemp.getEmpId());
            temp.add(employeeTemp.getEmpName());
            temp.add(employeeTemp.getDeptId().getDeptName().toString());
            temp.add(employeeTemp.getDsgnId().getDsgnTitle().toString());
            rowVector.add(temp);
        }

        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from employee where `DELETE_FLAG`=0");
            ResultSetMetaData rmd = rs.getMetaData();
            int j = rmd.getColumnCount();
            String[] type = new String[50];
            System.out.println("" + j);
            for (int i = 1; i <= j; i++) {

                String col = rmd.getColumnName(i);
                if (col.equals("EMP_ID")) {
                    colVector.add("Employee ID");
                } else if (col.equals("EMP_NAME")) {
                    colVector.add("Employee Name");
                } else if (col.equals("DEPT_ID")) {
                    colVector.add("Department Name");
                } else if (col.equals("DSGN_ID")) {
                    colVector.add("Designation Title");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        TableModel model = new DefaultTableModel(rowVector, colVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        employeeModifyTB.setModel(model);
        employeeModifyTB.setAutoCreateRowSorter(true);

        employeeModifyTB.removeColumn(employeeModifyTB.getColumnModel().getColumn(0));

    }
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == UpdateBT) {

                new popup.popup().displayEmployeeUpdate();
                refreshtb();
            }
            if (e.getSource() == deleteBT) {
                deleteButtonMethod();
               
            }



        }
    };
    KeyListener k2 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
             if (e.getSource() == UpdateBT) {

                new popup.popup().displayEmployeeUpdate();
                refreshtb();
            }
            if (e.getSource() == deleteBT) {
                deleteButtonMethod();
               
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    ListSelectionListener l1 = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (employeeModifyTB.getSelectedRow() > -1) {



                int row = employeeModifyTB.convertRowIndexToModel(employeeModifyTB.getSelectedRow());


                int col = employeeModifyTB.convertColumnIndexToModel(employeeModifyTB.getSelectedColumn());

                Object obj = employeeModifyTB.getModel().getValueAt(row, 0);

                String x = obj.toString();

                selectedRow = Integer.parseInt(x);

            }

        }
    };

    public static int returnSelectedRow() {
        return selectedRow;
    }
    KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

                String data = searchTextField.getText();
                if (data.length() > 0) {
                    data = data.substring(0, data.length() - 1);
                    searchTextField.setText(data);
                }
            } else {
                if ((e.getKeyCode() >= 'a' && e.getKeyCode() <= 'z') || (e.getKeyCode() >= 'A' && e.getKeyCode() <= 'Z') || (e.getKeyCode() >= '0' && e.getKeyCode() <= '9') || e.getKeyCode() == ' ') {
                    searchTextField.setText(searchTextField.getText() + e.getKeyChar());
                    searchTextField.setText(searchTextField.getText().toLowerCase());
                } else {
                    //System.out.println("hello");
                }
            }
            searchEmployeeList();

        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    };

    public void searchEmployeeList() {
        String data = searchTextField.getText();
        List<Employee> employeeListTemp = new ArrayList<Employee>();
        for (Employee employeeTemp : employeeList) {
            if (employeeTemp.getEmpName().toLowerCase().contains(data) || employeeTemp.getDeptId().getDeptName().toLowerCase().contains(data) || employeeTemp.getDsgnId().getDsgnTitle().toLowerCase().contains(data)) {
                employeeListTemp.add(employeeTemp);


            }
        }
        Vector rowVector = new Vector();
        for (Employee employeeTemp : employeeListTemp) {
            Vector temp = new Vector();
            temp.add(employeeTemp.getEmpId());
            temp.add(employeeTemp.getEmpName());
            temp.add(employeeTemp.getDeptId().getDeptName().toString());
            temp.add(employeeTemp.getDsgnId().getDsgnTitle().toString());
            rowVector.add(temp);
        }
        //System.out.println(rowVector);
        Vector colVector = new Vector();
        //System.out.println(td.colVector);
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from employee");
            ResultSetMetaData rmd = rs.getMetaData();
            int j = rmd.getColumnCount();
            String[] type = new String[50];
            System.out.println("" + j);
            for (int i = 1; i <= j; i++) {

                String col = rmd.getColumnName(i);
                if (col.equals("EMP_ID")) {
                    colVector.add("Employee ID");
                } else if (col.equals("EMP_NAME")) {
                    colVector.add("Employee Name");
                } else if (col.equals("DEPT_ID")) {
                    colVector.add("Department Name");
                } else if (col.equals("DSGN_ID")) {
                    colVector.add("Designation Title");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }





        TableModel model = new DefaultTableModel(rowVector, colVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        employeeModifyTB.setModel(model);


        employeeModifyTB.removeColumn(employeeModifyTB.getColumnModel().getColumn(0));

    }
}
