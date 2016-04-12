/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import dal.EmployeeDAL;
import dal.PlTlDal;
import dal.ProjEmpDal;
import dal.TaskDAL;
import dal.TaskDeptDAL;
import email.EmailClass;
import email.EmailDetails;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import to.Employee;
import to.PlTl;
import to.ProjEmp;
import to.Project;
import to.Task;
import to.TaskDept;
import to.Team;

/**
 *
 * @author hp pav 15-e015tx
 */
public class TaskAllocateUpdate extends javax.swing.JPanel {

    /**
     * Creates new form TaskAllocateUpdate
     */
    TaskDept taskDept = null;

    public TaskAllocateUpdate() {
        initComponents();

        clear();




    }

    public TaskAllocateUpdate(TaskDept taskDept) {
        initComponents();
        clear();


        this.taskDept = taskDept;

        fillComboDataProject();



        int itemCountProj = projCB.getItemCount();
        for (int i = 1; i < itemCountProj; i++) {
            if (projCB.getItemAt(i).toString().equals(taskDept.getProjId() + "")) {
                projCB.setSelectedIndex(i);
            }
        }
//        projCB.setEnabled(false);

        fillComboDataTask();

        int itemCountTask = taskCB.getItemCount();
        for (int i = 1; i < itemCountTask; i++) {
            if (taskCB.getItemAt(i).toString().equals(taskDept.getTaskId() + "")) {
                taskCB.setSelectedIndex(i);
            }
        }
        projCB.setEnabled(false);
        taskCB.setEnabled(false);

        fillComboDataEmployee(junexeCB);

        junexeCB.addActionListener(a2);

        allocateBT.addActionListener(al);   
        allocateBT.addKeyListener(k2);

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
        captionLB = new javax.swing.JLabel();
        allocateBT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        projmanVal = new javax.swing.JLabel();
        taskVal = new javax.swing.JLabel();
        junexeCB = new javax.swing.JComboBox();
        projVal = new javax.swing.JLabel();
        projCB = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        taskCB = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        ed3LB = new javax.swing.JLabel();
        title1LB = new javax.swing.JLabel();
        sd2LB = new javax.swing.JLabel();
        sdLB = new javax.swing.JLabel();
        sd3LB = new javax.swing.JLabel();
        ed1LB = new javax.swing.JLabel();
        projmannameLB = new javax.swing.JLabel();
        titleLB = new javax.swing.JLabel();
        edLB = new javax.swing.JLabel();
        ed2LB = new javax.swing.JLabel();
        title2LB = new javax.swing.JLabel();
        sd1LB = new javax.swing.JLabel();
        title3LB = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel1.setText("Allocate Task");

        captionLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        captionLB.setText("jLabel5");

        allocateBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        allocateBT.setText("Allocate");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel3.setText("Junior Executives:");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel2.setText("Task To Be Allocated:");

        projmanVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        projmanVal.setForeground(new java.awt.Color(255, 0, 0));
        projmanVal.setText("jLabel7");

        taskVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        taskVal.setForeground(new java.awt.Color(255, 0, 0));
        taskVal.setText("jLabel6");

        junexeCB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        junexeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        projVal.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        projVal.setForeground(new java.awt.Color(255, 0, 0));
        projVal.setText("jLabel5");

        projCB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        projCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel4.setText("Project:");

        taskCB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        taskCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(taskCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(junexeCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projCB, javax.swing.GroupLayout.Alignment.LEADING, 0, 302, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(projVal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(taskVal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(projmanVal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(projCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projVal))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(taskCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(taskVal)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(junexeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projmanVal))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ed3LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        ed3LB.setText("jLabel19");

        title1LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        title1LB.setText("jLabel9");

        sd2LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        sd2LB.setText("jLabel13");

        sdLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        sdLB.setText("Start Date");

        sd3LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        sd3LB.setText("jLabel15");

        ed1LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        ed1LB.setText("jLabel17");

        projmannameLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        projmannameLB.setText("jLabel4");

        titleLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        titleLB.setText("Title");

        edLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        edLB.setText("End Date");

        ed2LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        ed2LB.setText("jLabel18");

        title2LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        title2LB.setText("jLabel10");

        sd1LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        sd1LB.setText("jLabel14");

        title3LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        title3LB.setText("jLabel11");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projmannameLB)
                .addGap(154, 154, 154)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleLB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(title2LB)
                        .addComponent(title1LB))
                    .addComponent(title3LB))
                .addGap(150, 150, 150)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sd3LB)
                    .addComponent(sd1LB)
                    .addComponent(sdLB)
                    .addComponent(sd2LB))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edLB)
                    .addComponent(ed1LB)
                    .addComponent(ed2LB)
                    .addComponent(ed3LB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLB)
                    .addComponent(sdLB)
                    .addComponent(edLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title1LB)
                    .addComponent(sd1LB)
                    .addComponent(ed1LB)
                    .addComponent(projmannameLB))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title2LB)
                    .addComponent(sd2LB)
                    .addComponent(ed2LB))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title3LB)
                    .addComponent(sd3LB)
                    .addComponent(ed3LB))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(allocateBT)
                    .addComponent(captionLB, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(277, 277, 277))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(captionLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allocateBT)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allocateBT;
    private javax.swing.JLabel captionLB;
    private javax.swing.JLabel ed1LB;
    private javax.swing.JLabel ed2LB;
    private javax.swing.JLabel ed3LB;
    private javax.swing.JLabel edLB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox junexeCB;
    private javax.swing.JComboBox projCB;
    private javax.swing.JLabel projVal;
    private javax.swing.JLabel projmanVal;
    private javax.swing.JLabel projmannameLB;
    private javax.swing.JLabel sd1LB;
    private javax.swing.JLabel sd2LB;
    private javax.swing.JLabel sd3LB;
    private javax.swing.JLabel sdLB;
    private javax.swing.JComboBox taskCB;
    private javax.swing.JLabel taskVal;
    private javax.swing.JLabel title1LB;
    private javax.swing.JLabel title2LB;
    private javax.swing.JLabel title3LB;
    private javax.swing.JLabel titleLB;
    // End of variables declaration//GEN-END:variables

    public void allocationUpdateMethod(){
                     System.out.println("after bt");
                if (validation()) {
                    int flag = 0;
                    Task task = (Task) taskCB.getSelectedItem();
                    taskemail=task;
                    Employee employee = (Employee) junexeCB.getSelectedItem();
                    Project project = (Project) projCB.getSelectedItem();



                    TaskDept taskDept = new TaskDept();
                    taskDept.setTaskId(task);
                    taskDept.setEmpId(employee);
                    taskDept.setDeptId(LogIn.localempid.getDeptId());

                    int taskCheck = 0;


                    List<TaskDept> TaskDeptList = new TaskDeptDAL().getTaskDeptDetails();
                    for (TaskDept taskDeptTemp : TaskDeptList) {

                        if (taskDeptTemp.getAb() == 1) {

                            if (taskDeptTemp.getTaskId().getTaskId() == taskDept.getTaskId().getTaskId()) {

                                if (taskDeptTemp.getDeptId().getDeptId() == LogIn.localempid.getDeptId().getDeptId()) {
                                    //JOptionPane.showMessageDialog(WorkFlowEfficient.wfes, "Task already allocated");
                                    taskDept.setTdId(taskDeptTemp.getTdId());
                                    new TaskDeptDAL().updateAllocateTaskDeptDetails(taskDept);
                                    Window w = SwingUtilities.getWindowAncestor(popup.popup.taskAllocateUpdate);
                                    w.setVisible(false);

                                    
                                    int emlcnt = 0;

                                    emailList[0] = employee.getEmailId();
                                    SwingWorker worker = new SwingWorker<Void, Void>() {
                                        @Override
                                        protected Void doInBackground() throws Exception {



                                            EmailDetails emailDetails = new EmailDetails();
                                            emailDetails.setTo(emailList);
                                            emailDetails.setFrom("workflowefficientsystem@gmail.com");
                                            emailDetails.setSubject("New Task:" + taskemail.getTitle());
                                            emailDetails.setMessage("You are allocated task :" + taskemail.getTitle());
                                            new EmailClass().sendEmail(emailDetails);
                                            return null;
                                        }
                                    };

                                    worker.execute();
                                }

                            }


                        }

                    }









                }
    }
    void fillComboDataProject() {
        Vector vector = new Vector();
        vector.add("Please Enter");

        List<ProjEmp> projEmpList = new ProjEmpDal().getProjEmpDetails();
        ProjEmp projEmpTempFinal = null;
        for (ProjEmp projEmpTemp : projEmpList) {
            if (projEmpTemp.getProjId().getStatus() != 2 && projEmpTemp.getEmpId().getEmpId() == LogIn.localempid.getEmpId()) {
                vector.add(projEmpTemp.getProjId());
            }
        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        projCB.setModel(cbm);

    }

    void fillComboDataTask() {
        Vector vector = new Vector();
        vector.add("Please Enter");
        Project p1 = (Project) projCB.getSelectedItem();


        List<Task> taskList = new TaskDAL().getTaskDetails();
        List<TaskDept> taskDeptList = new TaskDeptDAL().getTaskDeptDetails();
        int taskCheck = 0;


        for (Task taskTemp : taskList) {

            if (taskTemp.getProjId().getProjId() == p1.getProjId()) {
                if (taskCheck == taskTemp.getTaskId()) {
                    continue;
                } else {
                    for (TaskDept taskDeptTemp : taskDeptList) {

                        if (taskDeptTemp.getTaskId().getTaskId() == taskTemp.getTaskId()) {
                            if (taskDeptTemp.getDeptId().getDeptId() == LogIn.localempid.getDeptId().getDeptId()) {

                                if (taskDeptTemp.getTdb() == 0) {

                                    vector.add(taskTemp);
                                    taskCheck = taskTemp.getTaskId();
                                }
                            }
                        }
                    }
                }
            }
        }


        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        taskCB.setModel(cbm);

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
    ActionListener a2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == junexeCB) {

                if (junexeCB.getSelectedIndex() > 0) {
                    Employee je = (Employee) junexeCB.getSelectedItem();
                    Project project = (Project) projCB.getSelectedItem();
                    Task task1 = (Task) taskCB.getSelectedItem();


                    projmannameLB.setText(je.getEmpName());
                    titleLB.setText("Title");
                    sdLB.setText("Start Date");
                    edLB.setText("End Date");

                    List<TaskDept> taskDeptList = new TaskDeptDAL().getTaskDeptDetails();

                    int cnt = 0;



                    int taskCheck = 0;

                    Task task[] = new Task[5];
                    TaskDept taskDept[] = new TaskDept[5];
                    for (TaskDept taskDeptTemp : taskDeptList) {

                        if (taskDeptTemp.getAb() == 1) {


                            if (taskDeptTemp.getEmpId().getEmpId() == je.getEmpId() && taskDeptTemp.getTdb() == 0) {
                                if (taskDeptTemp.getDeptId().getDeptId() == LogIn.localempid.getDeptId().getDeptId()) {

                                    cnt++;
                                    task[cnt] = taskDeptTemp.getTaskId();
                                    taskDept[cnt] = taskDeptTemp;
                                }

                            }

                        }


                    }
                    if (cnt == 0) {
                        clear();
                        captionLB.setText("No task alloctaed");
                    } else {
                        System.out.println("cnt" + cnt);
                        for (int i = 1; i <= cnt; i++) {

                            if (cnt == 3) {

                                if (i == 1) {
                                    title1LB.setText(task[i].getTitle());
                                    sd1LB.setText(taskDept[i].getStartDate().toString());
                                    ed1LB.setText(taskDept[i].getEndDate().toString());


                                }
                                if (i == 2) {
                                    title2LB.setText(task[i].getTitle());
                                    sd2LB.setText(taskDept[i].getStartDate().toString());
                                    ed2LB.setText(taskDept[i].getEndDate().toString());


                                }
                                if (i == 3) {
                                    title3LB.setText(task[i].getTitle());
                                    sd3LB.setText(taskDept[i].getStartDate().toString());
                                    ed3LB.setText(taskDept[i].getEndDate().toString());


                                }
                                captionLB.setText("");
                            } else if (cnt == 2) {

                                if (i == 1) {
                                    title1LB.setText(task[i].getTitle());
                                    sd1LB.setText(taskDept[i].getStartDate().toString());
                                    ed1LB.setText(taskDept[i].getEndDate().toString());


                                }
                                if (i == 2) {
                                    title2LB.setText(task[i].getTitle());
                                    sd2LB.setText(taskDept[i].getStartDate().toString());
                                    ed2LB.setText(taskDept[i].getEndDate().toString());


                                }

                                title3LB.setText("");
                                sd3LB.setText("");
                                ed3LB.setText("");
                                captionLB.setText("");



                            } else if (cnt == 1) {

                                if (i == 1) {
                                    title1LB.setText(task[i].getTitle());
                                    //System.out.println("Lb display::" + task);
                                    sd1LB.setText(taskDept[i].getStartDate().toString());
                                    ed1LB.setText(taskDept[i].getEndDate().toString());


                                }

                                title2LB.setText("");
                                sd2LB.setText("");
                                ed2LB.setText("");



                                title3LB.setText("");
                                sd3LB.setText("");
                                ed3LB.setText("");
                                captionLB.setText("");



                            }

                        }
                    }


                }

            }


        }
    };
    public static String emailList[] = new String[50];
    public static Task taskemail=new Task();
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == allocateBT) {
                allocationUpdateMethod();
            }
        }
    };

KeyListener k2 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
             if (e.getSource() == allocateBT) {
                allocationUpdateMethod();
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    void clear() {
        projmanVal.setText("");
        taskVal.setText("");
        title1LB.setText("");
        title2LB.setText("");
        title3LB.setText("");
        sd1LB.setText("");
        sd2LB.setText("");
        sd3LB.setText("");
        ed1LB.setText("");
        ed2LB.setText("");
        ed3LB.setText("");
        projmannameLB.setText("");
        titleLB.setText("");
        sdLB.setText("");
        edLB.setText("");
        captionLB.setText("");
    }

    boolean validation() {
        boolean flag = true;
        if (!title3LB.getText().equals("")) {
            JOptionPane.showMessageDialog(WorkFlowEfficient.wfes, "Sorry project allocation reached threshold");
            flag = false;
        }
        clear();
        if (taskCB.getSelectedIndex() == 0) {
            taskVal.setText("Please select Project");
            flag = false;
        }

        if (junexeCB.getSelectedIndex() == 0) {
            projmanVal.setText("Please select Project Manager");
            flag = false;
        }



        return flag;
    }
}
