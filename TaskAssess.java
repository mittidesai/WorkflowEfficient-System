/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import dal.EmployeeDAL;
import dal.PlTlDal;
import dal.TaskDeptDAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import to.Employee;
import to.PlTl;
import to.TaskDept;
import to.Team;

/**
 *
 * @author hp pav 15-e015tx
 */
public class TaskAssess extends javax.swing.JPanel {

    /**
     * Creates new form TaskAssess
     */
    Vector colVector = new Vector();
    List<TaskDept> taskDeptList = null;
    static int selectedRow = 0;

    public TaskAssess() {
        initComponents();

        colVector.add("TD_ID");

        colVector.add("PROJECT");
        colVector.add("TASK");


        searchTextField.setEnabled(false);
        taskLB.setVisible(false);
        taskTB.setVisible(false);
        AssessBT.setVisible(false);
        searchTextField.setVisible(false);
        tablePanel.setVisible(false);

        fillComboDataEmployee(employeeCB);
        employeeCB.addActionListener(al);
        AssessBT.addActionListener(al);
        AssessBT.addKeyListener(k2);
        taskTB.getSelectionModel().addListSelectionListener(l1);
        taskTB.addKeyListener(kl);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskTB = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        AssessBT = new javax.swing.JButton();
        employeeCB = new javax.swing.JComboBox();
        taskLB = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel1.setText("Task Assessment");

        tablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        taskTB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        taskTB.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(taskTB);

        org.jdesktop.layout.GroupLayout tablePanelLayout = new org.jdesktop.layout.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 255, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AssessBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        AssessBT.setText("Assess");

        employeeCB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        employeeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        taskLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        taskLB.setText("Task:");

        searchTextField.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel2.setText("Employee:");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(taskLB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(employeeCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(searchTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(68, 68, 68)
                        .add(AssessBT)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(employeeCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(58, 58, 58)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(taskLB)
                    .add(searchTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(AssessBT))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(tablePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(260, 260, 260)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createSequentialGroup()
                            .add(45, 45, 45)
                            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(59, 59, 59)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(tablePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AssessBT;
    private javax.swing.JComboBox employeeCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel taskLB;
    private javax.swing.JTable taskTB;
    // End of variables declaration//GEN-END:variables

    void refreshtb(){
         Employee employee = (Employee) employeeCB.getSelectedItem();
//               JOptionPane.showMessageDialog(WorkFlowEfficient.wfes, "Hello,"+employee.getEmpName());
                taskDeptList = new TaskDeptDAL().getTaskDeptDetailsCustom();


                Vector rowVector = new Vector();

                if (LogIn.localempid.getDsgnId().getDsgnTitle().toString().equals("ASSISTANT MANAGER")) {


                    for (TaskDept taskDeptTemp : taskDeptList) {

                        if (taskDeptTemp.getAb() == 1 && taskDeptTemp.getTdb() == 1 && taskDeptTemp.getAsb() == 0) {
                            if (taskDeptTemp.getEmpId().getEmpId() == employee.getEmpId()) {



                                Vector temp = new Vector();
                                temp.add(taskDeptTemp.getTdId());



                                temp.add(taskDeptTemp.getProjId().getTitle());
                                temp.add(taskDeptTemp.getTaskId().getTitle());




                                rowVector.add(temp);

                            }
                        }
                    }
                }

                TableModel model = new DefaultTableModel(rowVector, colVector) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                taskTB.setModel(model);
                taskTB.setAutoCreateRowSorter(true);
                taskTB.removeColumn(taskTB.getColumnModel().getColumn(0));
    }
    
    void fillComboDataEmployee(JComboBox jComboBox) {
        Vector vector = new Vector();
        vector.add("Please Enter");

        Employee tl = new Employee();
        Employee je = new Employee();

        int tlid = 0;




        PlTl plTl = new PlTl();
        List<PlTl> plTlList = new PlTlDal().getPlTlDetails();
        for (PlTl plTlTemp : plTlList) {
            if (plTlTemp.getTlId().getEmpId() == LogIn.localempid.getEmpId()) {
                tl = plTlTemp.getTlId();

            }
        }

        Team team = tl.getTeamId();
        List<Employee> employeeList = new EmployeeDAL().getEmployeeDetails();
        for (Employee employeeTemp : employeeList) {
            if (employeeTemp.getTeamId().getTeamId() == team.getTeamId() && employeeTemp.getDsgnId().getDsgnTitle().toString().equals("JUNIOR EXECUTIVE")) {

                vector.add(employeeTemp);
            }
        }

        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }
    KeyListener k2 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getSource()==AssessBT){
                new popup.popup().displayQualityPanel();
                refreshtb();
                
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            
            if(e.getSource()==AssessBT){
                new popup.popup().displayQualityPanel();
                refreshtb();
                
            }
            
            if (e.getSource() == employeeCB) {
                taskLB.setVisible(true);
                tablePanel.setVisible(true);
                taskTB.setVisible(true);
                AssessBT.setVisible(true);
                searchTextField.setVisible(true);

                Employee employee = (Employee) employeeCB.getSelectedItem();
//               JOptionPane.showMessageDialog(WorkFlowEfficient.wfes, "Hello,"+employee.getEmpName());
                taskDeptList = new TaskDeptDAL().getTaskDeptDetailsCustom();


                Vector rowVector = new Vector();

                if (LogIn.localempid.getDsgnId().getDsgnTitle().toString().equals("ASSISTANT MANAGER")) {


                    for (TaskDept taskDeptTemp : taskDeptList) {

                        if (taskDeptTemp.getAb() == 1 && taskDeptTemp.getTdb() == 1 && taskDeptTemp.getAsb() == 0) {
                            if (taskDeptTemp.getEmpId().getEmpId() == employee.getEmpId()) {



                                Vector temp = new Vector();
                                temp.add(taskDeptTemp.getTdId());



                                temp.add(taskDeptTemp.getProjId().getTitle());
                                temp.add(taskDeptTemp.getTaskId().getTitle());




                                rowVector.add(temp);

                            }
                        }
                    }
                }

                TableModel model = new DefaultTableModel(rowVector, colVector) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                taskTB.setModel(model);
                taskTB.setAutoCreateRowSorter(true);
                taskTB.removeColumn(taskTB.getColumnModel().getColumn(0));

            }
        }
    };
    ListSelectionListener l1 = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (taskTB.getSelectedRow() > -1) {
                int row = taskTB.convertRowIndexToModel(taskTB.getSelectedRow());


                int col = taskTB.convertColumnIndexToModel(taskTB.getSelectedColumn());

                Object obj = taskTB.getModel().getValueAt(row, 0);


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
            searchTaskList();

        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    };

    public void searchTaskList() {
        String data = searchTextField.getText();
        List<TaskDept> taskDeptListTemp = new ArrayList<TaskDept>();
        for (TaskDept taskDeptTemp : taskDeptList) {
            if (taskDeptTemp.getTaskId().getTitle().toLowerCase().contains(data) || taskDeptTemp.getProjId().getTitle().toLowerCase().contains(data)) {
                taskDeptListTemp.add(taskDeptTemp);
            }
        }

        Employee employee = (Employee) employeeCB.getSelectedItem();
        Vector rowVector = new Vector();

        if (LogIn.localempid.getDsgnId().getDsgnTitle().toString().equals("ASSISTANT MANAGER")) {


            for (TaskDept taskDeptTemp : taskDeptListTemp) {

                if (taskDeptTemp.getAb() == 1 && taskDeptTemp.getTdb() == 1 && taskDeptTemp.getAsb() == 0) {
                    if (taskDeptTemp.getEmpId().getEmpId() == employee.getEmpId()) {



                        Vector temp = new Vector();
                        temp.add(taskDeptTemp.getTdId());



                        temp.add(taskDeptTemp.getProjId().getTitle());
                        temp.add(taskDeptTemp.getTaskId().getTitle());




                        rowVector.add(temp);

                    }
                }
            }
        }








        TableModel model = new DefaultTableModel(rowVector, colVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        taskTB.setModel(model);



        taskTB.removeColumn(taskTB.getColumnModel().getColumn(0));

    }
}