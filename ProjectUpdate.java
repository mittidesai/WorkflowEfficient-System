package wfes;

//import Conversion.ComboData;
import Conversion.UtilToSql;
import dal.ConnectionDAL;
import dal.EmployeeDAL;
import dal.PriorityDAL;
import dal.ProjectDAL;
import dal.StatusDAL;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import to.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 01
 */
public class ProjectUpdate extends javax.swing.JPanel {

    Project project = null;
    Connection connection = new ConnectionDAL().getConnection();

    public ProjectUpdate() {
        initComponents();
        clear();
        fillComboDataProject(projIdCB);
        //  fillComboDataPL(ProjectLeaderIdCB);
        // fillComboDataTL(TeamLeaderIdCB);
        fillComboDataStatus(StatusCB);
        fillComboDataPriority(PriorityCB);


        UpdateButton.addActionListener(al);
    }

    public ProjectUpdate(Project project) {
        initComponents();
        clear();
        fillComboDataProject(projIdCB);
        //fillComboDataPL(ProjectLeaderIdCB);
        //fillComboDataTL(TeamLeaderIdCB);
        fillComboDataStatus(StatusCB);
        fillComboDataPriority(PriorityCB);

        this.project = project;

        projIdCB.setSelectedIndex(project.getProjId() - 1);
        TitleTF.setText(project.getTitle());
        DescriptionTA.setText(project.getDescription());
        ClientTF.setText(project.getClient());
        StartDateDC.setDate(project.getStartDate());
        EndDateDC.setDate(project.getEndDate());
        StatusCB.setSelectedIndex(project.getStatus() - 1);
        PriorityCB.setSelectedIndex(project.getPriority() - 1);
       

        //  System.out.println("Empid:"+project.getPlId());

//        int itemCountPL = ProjectLeaderIdCB.getItemCount();
//        for (int i = 0; i < itemCountPL; i++) {
//            if (ProjectLeaderIdCB.getItemAt(i).toString().equals(project.getPlId() + "")) {
//                ProjectLeaderIdCB.setSelectedIndex(i);
//            }
//        }

//        int itemCountTL = TeamLeaderIdCB.getItemCount();
//        for (int i = 0; i < itemCountTL; i++) {
//            if (TeamLeaderIdCB.getItemAt(i).toString().equals(project.getTlId() + "")) {
//                TeamLeaderIdCB.setSelectedIndex(i);
//            }
//        }


        UpdateButton.addActionListener(al);
        UpdateButton.addKeyListener(kl);
        UpdateButton.setNextFocusableComponent(WorkFlowEfficient.wfes.getjMenuBar1());
        
        StatusCB.setEnabled(false);
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
        UpdateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        clientVal = new javax.swing.JLabel();
        TitleTF = new javax.swing.JTextField();
        projIdVal = new javax.swing.JLabel();
        titleVal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ClientTF = new javax.swing.JTextField();
        DescriptionSP = new javax.swing.JScrollPane();
        DescriptionTA = new javax.swing.JTextArea();
        projIdCB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        descriptionVal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        StartDateDC = new com.toedter.calendar.JDateChooser();
        EndDateDC = new com.toedter.calendar.JDateChooser();
        statusVal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        priorityVal = new javax.swing.JLabel();
        PriorityCB = new javax.swing.JComboBox();
        StatusCB = new javax.swing.JComboBox();
        endDateVal = new javax.swing.JLabel();
        startDateVal = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 0, 51));

        UpdateButton.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        UpdateButton.setForeground(new java.awt.Color(86, 86, 87));
        UpdateButton.setText("UPDATE");

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(86, 86, 87));
        jLabel1.setText("EDIT PROJECT DETAILS");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(86, 86, 87));
        jLabel5.setText("Client :");

        clientVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        clientVal.setForeground(new java.awt.Color(255, 0, 51));
        clientVal.setText("jLabel17");

        TitleTF.setNextFocusableComponent(DescriptionTA);

        projIdVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        projIdVal.setForeground(new java.awt.Color(255, 0, 51));
        projIdVal.setText("jLabel15");

        titleVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        titleVal.setForeground(new java.awt.Color(255, 0, 51));
        titleVal.setText("jLabel15");

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(86, 86, 87));
        jLabel4.setText("Description :");

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(86, 86, 87));
        jLabel3.setText("Title :");

        ClientTF.setNextFocusableComponent(StartDateDC);

        DescriptionTA.setColumns(20);
        DescriptionTA.setRows(5);
        DescriptionTA.setNextFocusableComponent(ClientTF);
        DescriptionSP.setViewportView(DescriptionTA);

        projIdCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        projIdCB.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(86, 86, 87));
        jLabel2.setText("Project");

        descriptionVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        descriptionVal.setForeground(new java.awt.Color(255, 0, 51));
        descriptionVal.setText("jLabel16");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(projIdCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleTF)
                    .addComponent(DescriptionSP, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(ClientTF))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projIdVal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleVal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionVal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(projIdCB)
                        .addComponent(projIdVal))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TitleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleVal))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(DescriptionSP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(clientVal)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(ClientTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(86, 86, 87));
        jLabel9.setText("Priority :");

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(86, 86, 87));
        jLabel7.setText("End_Date :");

        StartDateDC.setNextFocusableComponent(EndDateDC);

        EndDateDC.setNextFocusableComponent(StatusCB);

        statusVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        statusVal.setForeground(new java.awt.Color(255, 0, 51));
        statusVal.setText("jLabel20");

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(86, 86, 87));
        jLabel8.setText("Status :");

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(86, 86, 87));
        jLabel6.setText("Start_Date :");

        priorityVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        priorityVal.setForeground(new java.awt.Color(255, 0, 51));
        priorityVal.setText("jLabel15");

        PriorityCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PriorityCB.setNextFocusableComponent(UpdateButton);

        StatusCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        StatusCB.setNextFocusableComponent(PriorityCB);

        endDateVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        endDateVal.setForeground(new java.awt.Color(255, 0, 51));
        endDateVal.setText("jLabel19");

        startDateVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        startDateVal.setForeground(new java.awt.Color(255, 0, 51));
        startDateVal.setText("jLabel18");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priorityVal, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(StatusCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EndDateDC, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addComponent(startDateVal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StartDateDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(endDateVal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusVal, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PriorityCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(StartDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startDateVal)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EndDateDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDateVal)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(StatusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusVal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(PriorityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(priorityVal)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(376, 376, 376))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(UpdateButton)
                        .addGap(460, 460, 460))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(UpdateButton)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClientTF;
    private javax.swing.JScrollPane DescriptionSP;
    private javax.swing.JTextArea DescriptionTA;
    private com.toedter.calendar.JDateChooser EndDateDC;
    private javax.swing.JComboBox PriorityCB;
    private com.toedter.calendar.JDateChooser StartDateDC;
    private javax.swing.JComboBox StatusCB;
    private javax.swing.JTextField TitleTF;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel clientVal;
    private javax.swing.JLabel descriptionVal;
    private javax.swing.JLabel endDateVal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel priorityVal;
    private javax.swing.JComboBox projIdCB;
    private javax.swing.JLabel projIdVal;
    private javax.swing.JLabel startDateVal;
    private javax.swing.JLabel statusVal;
    private javax.swing.JLabel titleVal;
    // End of variables declaration//GEN-END:variables

    public void updateButtonMethod()
    {
        if (validation()) {
                    Project projecttemp = new Project();

                    projecttemp.setProjId(project.getProjId());
                    System.out.println("Text is:" + TitleTF.getText());
                    projecttemp.setTitle(TitleTF.getText());
                    projecttemp.setDescription(DescriptionTA.getText());
                    projecttemp.setClient(ClientTF.getText());
                    projecttemp.setStartDate(new UtilToSql().convertUtilToSql(StartDateDC.getDate()));
                    projecttemp.setEndDate(new UtilToSql().convertUtilToSql(EndDateDC.getDate()));
                    projecttemp.setStatus(((Status) StatusCB.getSelectedItem()).getStatusId());
                    projecttemp.setPriority(((Priority) PriorityCB.getSelectedItem()).getPriId());
                   
//                    projecttemp.setTlId((Employee)TeamLeaderIdCB.getSelectedItem());
//                    projecttemp.setPlId((Employee)ProjectLeaderIdCB.getSelectedItem());
                    // project.setFileName(FileNameTF.getText());





                    new ProjectDAL().updateProjectDetails(projecttemp);
                    Window w = SwingUtilities.getWindowAncestor(popup.popup.projectUpdate);
                    w.setVisible(false);


                    System.out.println("Done");

                }
    }
    void fillComboDataPL(JComboBox jComboBox) {
        Vector vector = new Vector();
        List<Employee> employeeList = new EmployeeDAL().getEmployeeDetails();
        Employee employeeTempFinal = null;
        for (Employee employeeTemp : employeeList) {
            if (employeeTemp.getDsgnId().getDsgnId() == 8) {
                vector.add(employeeTemp);
            }
        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }

    void fillComboDataTL(JComboBox jComboBox) {
        Vector vector = new Vector();
        List<Employee> employeeList = new EmployeeDAL().getEmployeeDetails();
        Employee employeeTempFinal = null;
        for (Employee employeeTemp : employeeList) {
            if (employeeTemp.getDsgnId().getDsgnId() == 9) {
                vector.add(employeeTemp);
            }
        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }

    void fillComboDataStatus(JComboBox jComboBox) {
        Vector vector = new Vector();
        List<Status> statusList = new StatusDAL().getStatusDetails();
        Status statusTempFinal = null;
        for (Status statusTemp : statusList) {

            vector.add(statusTemp);

        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }

    void fillComboDataPriority(JComboBox jComboBox) {
        Vector vector = new Vector();
        List<Priority> priorityList = new PriorityDAL().getPriorityDetails();
        Priority priorityTempFinal = null;
        for (Priority priorityTemp : priorityList) {

            vector.add(priorityTemp);

        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }

    void fillComboDataProject(JComboBox jComboBox) {
        Vector vector = new Vector();
        List<Project> projectList = new ProjectDAL().getProjectDetails();
        Project projectTempFinal = null;
        for (Project projectTemp : projectList) {

            vector.add(projectTemp);
        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == UpdateButton) {
                updateButtonMethod();
            }
        }
    };
     KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getSource() == UpdateButton && e.getKeyCode() == KeyEvent.VK_ENTER) {
                updateButtonMethod();
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };

    void clear() {
        projIdVal.setText("");
        titleVal.setText("");
        descriptionVal.setText("");
        clientVal.setText("");
        startDateVal.setText("");
        endDateVal.setText("");
        statusVal.setText("");
        priorityVal.setText("");
      
//        fileNameVal.setText("");
//        projectLeaderIdVal.setText("");
//        teamLeaderIdVal.setText("");
    }

    boolean validation() {
        boolean flag = true;
        clear();

        if (projIdCB.getSelectedIndex() == -1) {
            projIdVal.setText("Please enter Project ID");
            flag = false;
        }
        if (TitleTF.getText().equals("")) {
            titleVal.setText("Please enter Title");
            flag = false;
        }
        if (DescriptionTA.getText().equals("")) {
            descriptionVal.setText("Please enter description");
            flag = false;
        }

        if (ClientTF.getText().equals("")) {
            clientVal.setText("Please enter Client");
            flag = false;
        }
        if (StartDateDC.getDate() == null) {
            startDateVal.setText("Please enter Start Date");
            flag = false;
        }
        if (EndDateDC.getDate() == null) {
            endDateVal.setText("Please enter End Date");
            flag = false;
        }
        if (StatusCB.getSelectedIndex() == -1) {
            statusVal.setText("Please enter Status");
            flag = false;
        }
        if (PriorityCB.getSelectedIndex() == -1) {
            priorityVal.setText("Please enter Priority");
            flag = false;
        }
//        if (ProjCompletionPerTF.getText().equals("")) {
//            projCompletionPercentageVal.setText("Please enter % Project Completed");
//            flag = false;
//        }
//
//        if (FinishDateDC.getDate() == null) {
//            finishDateVal.setText("Please enter Finish Date");
//            flag = false;
//        }
        //if (FileNameTF.getText().equals()) {
        //  DeptVal.setText("Please enter Department");
        //flag = false;
        // }
//        if (ProjectLeaderIdCB.getSelectedIndex() == -1) {
//            projectLeaderIdVal.setText("Please enter ProjectID");
//            flag = false;
//        }
//        if (TeamLeaderIdCB.getSelectedIndex() == -1) {
//            teamLeaderIdVal.setText("Please enter Team");
//            flag = false;
//        }


        return flag;
    }
}
