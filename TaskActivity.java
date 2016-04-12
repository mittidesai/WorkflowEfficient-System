/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import Conversion.DateStoring;
import Conversion.ProjectCompletion;
import dal.ConnectionDAL;
import dal.TaskDeptDAL;
import dal.TaskItemDAL;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import to.Employee;
import to.Task;
import to.TaskDept;
import to.TaskItem;

/**
 *
 * @author hp pav 15-e015tx
 */
public class TaskActivity extends javax.swing.JPanel {

    /**
     * Creates new form TaskActivity
     */
    TaskDept taskDept[] = new TaskDept[5];
    public static TaskDept taskDeptSel = new TaskDept();
    public static Date userResume = new Date();
    public static Timer timerBreak[] = {new Timer(0, null), new Timer(0, null), new Timer(0, null)};
    public static Timer timerStart[] = {new Timer(0, null), new Timer(0, null), new Timer(0, null)};
    public static Long elapsedSecondsBreak[] = {(long) 10, (long) 10, (long) 10};
    public static Long elapsedSecondsStart[] = {(long) 0, (long) 0, (long) 0};
    public static Long elapsedSecondsUpdate = (long) 0;
    public static Integer selectedTask = null;
    public static boolean stopButtonFlag;

    //public static Integer stopbit=0, resumebit=0;
    public TaskActivity() {
        initComponents();
        clear();


        userResume = new Date();
        timerBreak[0] = new Timer(0, null);
        timerBreak[1] = new Timer(0, null);
        timerBreak[2] = new Timer(0, null);


        timerStart[0] = new Timer(0, null);
        timerStart[1] = new Timer(0, null);
        timerStart[2] = new Timer(0, null);

        elapsedSecondsBreak[0] = (long) 10;
        elapsedSecondsBreak[1] = (long) 10;
        elapsedSecondsBreak[2] = (long) 10;

        elapsedSecondsStart[0] = (long) 0;
        elapsedSecondsStart[1] = (long) 0;
        elapsedSecondsStart[2] = (long) 0;



        elapsedSecondsUpdate = (long) 0;
        selectedTask = null;



        Employee je = LogIn.localempid;
        List<TaskDept> taskDeptList = new TaskDeptDAL().getTaskDeptDetails();
        int cnt = 0;
        int taskCheck = 0;
        Task task[] = new Task[5];
        for (TaskDept taskDeptTemp : taskDeptList) {

            if (taskDeptTemp.getAb() == 1) {


                if (taskDeptTemp.getEmpId().getEmpId() == je.getEmpId()) {
                    if (taskDeptTemp.getDeptId().getDeptId() == LogIn.localempid.getDeptId().getDeptId()) {
                        if (taskDeptTemp.getTdb() == 0) {

                            cnt++;
                            task[cnt] = taskDeptTemp.getTaskId();
                            taskDept[cnt] = taskDeptTemp;
                        }
                    }

                }

            }


        }
        if (cnt == 0) {
            clear();
            captionLB.setText("No task allocated");
            taskRB1.setVisible(false);
            taskRB2.setVisible(false);
            taskRB3.setVisible(false);
            startBT.setEnabled(false);
            stopBT.setEnabled(false);
            resumeBT.setEnabled(false);
            doneBT.setEnabled(false);
            jPanel3.setVisible(false);
        } else {

            jPanel3.setVisible(true);
            for (int i = 1; i <= cnt; i++) {

                if (cnt == 3) {

                    if (i == 1) {
                        proj1LB.setText(taskDept[i].getProjId().getTitle());
                        task1LB.setText(taskDept[i].getTaskId().getTitle());
                        priority1LB.setText(taskDept[i].getPri().getPriType());
                        taskRB1.setVisible(true);


                    }
                    if (i == 2) {
                        proj2LB.setText(taskDept[i].getProjId().getTitle());
                        task2LB.setText(taskDept[i].getTaskId().getTitle());
                        priority2LB.setText(taskDept[i].getPri().getPriType());
                        taskRB2.setVisible(true);


                    }
                    if (i == 3) {
                        proj3LB.setText(taskDept[i].getProjId().getTitle());
                        task3LB.setText(taskDept[i].getTaskId().getTitle());
                        priority3LB.setText(taskDept[i].getPri().getPriType());
                        taskRB3.setVisible(true);


                    }
                    captionLB.setText("");
                } else if (cnt == 2) {

                    if (i == 1) {
                        proj1LB.setText(taskDept[i].getProjId().getTitle());
                        task1LB.setText(taskDept[i].getTaskId().getTitle());

                        priority1LB.setText(taskDept[i].getPri().getPriType());
                        taskRB1.setVisible(true);

                    }
                    if (i == 2) {
                        proj2LB.setText(taskDept[i].getProjId().getTitle());
                        task2LB.setText(taskDept[i].getTaskId().getTitle());
                        priority2LB.setText(taskDept[i].getPri().getPriType());
                        taskRB2.setVisible(true);


                    }

                    proj3LB.setText("");
                    task3LB.setText("");
                    priority3LB.setText("");
                    taskRB3.setVisible(false);
                    captionLB.setText("");



                } else if (cnt == 1) {

                    if (i == 1) {
                        proj1LB.setText(taskDept[i].getProjId().getTitle());
                        task1LB.setText(taskDept[i].getTaskId().getTitle());
                        priority1LB.setText(taskDept[i].getPri().getPriType());
                        taskRB1.setVisible(true);


                    }

                    proj2LB.setText("");
                    task2LB.setText("");
                    priority2LB.setText("");
                    taskRB2.setVisible(false);



                    proj3LB.setText("");
                    task3LB.setText("");
                    priority3LB.setText("");
                    captionLB.setText("");
                    taskRB3.setVisible(false);



                }

            }
        }
        Timer timerUpdate = new Timer(1000, new TimerListenerUpdate());

        timerUpdate.start();

        startBT.setEnabled(false);
        stopBT.setEnabled(false);
        resumeBT.setEnabled(false);
        doneBT.setEnabled(false);

        taskRB1.addActionListener(al);

        taskRB2.addActionListener(al);

        taskRB3.addActionListener(al);

        startBT.addActionListener(a2);

        stopBT.addActionListener(a2);

        resumeBT.addActionListener(a2);

        doneBT.addActionListener(a2);
        startBT.addKeyListener(k2);
        stopBT.addKeyListener(k2);
        resumeBT.addKeyListener(k2);
        doneBT.addKeyListener(k2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        task1LB = new javax.swing.JLabel();
        priority1LB = new javax.swing.JLabel();
        proj2LB = new javax.swing.JLabel();
        task2LB = new javax.swing.JLabel();
        priority2LB = new javax.swing.JLabel();
        proj3LB = new javax.swing.JLabel();
        task3LB = new javax.swing.JLabel();
        priority3LB = new javax.swing.JLabel();
        proj1LB = new javax.swing.JLabel();
        taskRB1 = new javax.swing.JRadioButton();
        taskRB2 = new javax.swing.JRadioButton();
        taskRB3 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        descLB = new javax.swing.JLabel();
        totalLB = new javax.swing.JLabel();
        remLB = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        captionLB = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        startBT = new javax.swing.JButton();
        stopBT = new javax.swing.JButton();
        resumeBT = new javax.swing.JButton();
        doneBT = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel1.setText("Project");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel2.setText("Task");

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel3.setText("Priority");

        task1LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        task1LB.setText("jLabel14");

        priority1LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        priority1LB.setText("jLabel17");

        proj2LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        proj2LB.setText("jLabel10");

        task2LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        task2LB.setText("jLabel13");

        priority2LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        priority2LB.setText("jLabel18");

        proj3LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        proj3LB.setText("jLabel11");

        task3LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        task3LB.setText("jLabel15");

        priority3LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        priority3LB.setText("jLabel19");

        proj1LB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        proj1LB.setText("jLabel9");

        buttonGroup1.add(taskRB1);

        buttonGroup1.add(taskRB2);

        buttonGroup1.add(taskRB3);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel4.setText("Description:");

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel5.setText("Total Time Alloted:");

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel6.setText("Remaining Time:");

        descLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        descLB.setText("jLabel7");

        totalLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        totalLB.setText("jLabel8");

        remLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        remLB.setText("jLabel9");

        timerLabel.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        timerLabel.setText("jLabel8");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(remLB, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(descLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(descLB))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalLB))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(remLB)
                    .addComponent(timerLabel))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        captionLB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        captionLB.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(captionLB)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(proj1LB)
                                            .addComponent(proj2LB)
                                            .addComponent(proj3LB, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(85, 85, 85)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(task3LB)
                                            .addComponent(task2LB)
                                            .addComponent(task1LB)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(91, 91, 91)
                                        .addComponent(jLabel2)))
                                .addGap(123, 123, 123)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(priority1LB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                        .addComponent(taskRB1))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(priority2LB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(taskRB2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(priority3LB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(taskRB3)))))
                        .addGap(27, 27, 27))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskRB1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proj1LB)
                        .addComponent(task1LB)
                        .addComponent(priority1LB)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskRB2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proj2LB)
                        .addComponent(task2LB)
                        .addComponent(priority2LB)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proj3LB)
                    .addComponent(task3LB)
                    .addComponent(priority3LB)
                    .addComponent(taskRB3))
                .addGap(9, 9, 9)
                .addComponent(captionLB)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        startBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        startBT.setText("Start");
        startBT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        stopBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        stopBT.setText("Stop");
        stopBT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        resumeBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        resumeBT.setText("Resume");
        resumeBT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        doneBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        doneBT.setText("Done");
        doneBT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stopBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resumeBT, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(doneBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(startBT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(stopBT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(resumeBT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(doneBT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel7.setText("ACTIVITY");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel captionLB;
    private javax.swing.JLabel descLB;
    private javax.swing.JButton doneBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel priority1LB;
    private javax.swing.JLabel priority2LB;
    private javax.swing.JLabel priority3LB;
    private javax.swing.JLabel proj1LB;
    private javax.swing.JLabel proj2LB;
    private javax.swing.JLabel proj3LB;
    private javax.swing.JLabel remLB;
    private javax.swing.JButton resumeBT;
    private javax.swing.JButton startBT;
    private javax.swing.JButton stopBT;
    private javax.swing.JLabel task1LB;
    private javax.swing.JLabel task2LB;
    private javax.swing.JLabel task3LB;
    private javax.swing.JRadioButton taskRB1;
    private javax.swing.JRadioButton taskRB2;
    private javax.swing.JRadioButton taskRB3;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel totalLB;
    // End of variables declaration//GEN-END:variables
  
    public void doneButtonMethod(){
        

                taskDeptSel.setuStopDateTime(new DateStoring().getPresentDate());
                new TaskDeptDAL().updateUStopDateTime(taskDeptSel);
                doneBT.setEnabled(false);
                stopBT.setEnabled(false);
                stopButtonFlag = false;
                resumeBT.setEnabled(false);

                if (new ProjectCompletion().getProjCompPercent(taskDeptSel.getProjId()) == 100) {

                    String qry6 = "UPDATE `wfes`.`project` SET `STATUS`=2 where `proj_id`=" + taskDeptSel.getProjId().getProjId() + ";";
                    Connection connection = new ConnectionDAL().getConnection();
                    Statement st31;
                    try {
                        st31 = connection.createStatement();
                        int rowAdded = st31.executeUpdate(qry6);
                        if (rowAdded == 1) {
                            JOptionPane.showMessageDialog(null, "Status Updated Successfully");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }

                Integer tiid = new TaskItemDAL().getTiId(taskDeptSel);
                TaskItem ti = new TaskItem();
                ti.setTiId(tiid);
                ti.setTdId(taskDeptSel);
                if (selectedTask != null) {
                    ti.setElapseSec(elapsedSecondsStart[selectedTask]);

                    new TaskItemDAL().updateElapseSec(ti);


                }

                new ProjectCompletion().fillTR(taskDeptSel);


                if (taskRB1.isSelected()) {
                    timerStart[0].stop();

                    taskRB2.setEnabled(true);
                    taskRB3.setEnabled(true);
                }
                if (taskRB2.isSelected()) {
                    timerStart[1].stop();

                    taskRB1.setEnabled(true);
                    taskRB3.setEnabled(true);
                }
                if (taskRB3.isSelected()) {
                    timerStart[2].stop();


                    taskRB1.setEnabled(true);
                    taskRB2.setEnabled(true);
                }
                new ProjectCompletion().setTaskStatus(taskDeptSel);
    }
    public void startButtonMethod(){
       
                
                if (taskRB1.isSelected() || taskRB2.isSelected() || taskRB3.isSelected()) {
                    
                    new ProjectCompletion().setTaskStatusOnStart(taskDeptSel);
                    taskDeptSel.setuStartDateTime(new DateStoring().getPresentDate());
                    new TaskDeptDAL().updateUStartDateTime(taskDeptSel);

                    if (taskRB1.isSelected()) {

                        elapsedSecondsStart[0] = new ProjectCompletion().getTaskCompPercent(taskDeptSel);
                        timerStart[0] = new Timer(1000, new TimerListenerStart());
                        timerStart[0].start();

                        taskRB2.setEnabled(false);
                        taskRB3.setEnabled(false);
                        resumeBT.setEnabled(false);


                    }
                    if (taskRB2.isSelected()) {
                        elapsedSecondsStart[1] = new ProjectCompletion().getTaskCompPercent(taskDeptSel);
                        timerStart[1] = new Timer(1000, new TimerListenerStart());
                        timerStart[1].start();

                        taskRB1.setEnabled(false);
                        taskRB3.setEnabled(false);
                        resumeBT.setEnabled(false);
                    }
                    if (taskRB3.isSelected()) {
                        elapsedSecondsStart[2] = new ProjectCompletion().getTaskCompPercent(taskDeptSel);
                        timerStart[2] = new Timer(1000, new TimerListenerStart());
                        timerStart[2].start();

                        taskRB1.setEnabled(false);
                        taskRB2.setEnabled(false);
                        resumeBT.setEnabled(false);
                    }




                    startBT.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(WorkFlowEfficient.wfes, "Please select a task");
                }
   }
   public void stopButtonMethod(){
       

                new popup.popup().displayStopReason();

                TaskItem ti = new TaskItem();
                ti.setTdId(taskDeptSel);
                ti.setPause(new DateStoring().getPresentDate());

                if (StopReason.selitem.toString().equals("") || StopReason.selitem.toString().equals("Please Enter")) {
                    System.out.println("helooooo");
                } else {

                    ti.setReason(StopReason.selitem);

                    if (taskRB1.isSelected()) {
                        if (ti.getReason().equals("Break")) {
                            timerBreak[0] = new Timer(1000, new TimerListenerBreak());
                            if (elapsedSecondsBreak[0] > 0) {
                                timerBreak[0].start();
                                timerStart[0].stop();
                            } else {
                                timerBreak[0].stop();
                                timerStart[0].start();
                            }


                        }

                        if (ti.getReason().equals("Meeting")) {

                            timerStart[0].stop();
                        }
                        if (ti.getReason().equals("Query")) {
                            timerStart[0].stop();
                        }
                        if (ti.getReason().equals("End Of Working Hours")) {
                            timerStart[0].stop();
                        }

                        ti.setElapseSec(elapsedSecondsStart[0]);
                    }
                    if (taskRB2.isSelected()) {
                        if (ti.getReason().equals("Break")) {
                            timerBreak[1] = new Timer(1000, new TimerListenerBreak());
                            if (elapsedSecondsBreak[1] > 0) {
                                timerBreak[1].start();
                                timerStart[1].stop();
                            } else {
                                timerBreak[1].stop();
                                timerStart[1].start();
                            }

                        }

                        if (ti.getReason().equals("Meeting")) {

                            timerStart[1].stop();
                        }
                        if (ti.getReason().equals("Query")) {
                            timerStart[1].stop();
                        }
                        if (ti.getReason().equals("End Of Working Hours")) {
                            timerStart[1].stop();
                        }


                        ti.setElapseSec(elapsedSecondsStart[1]);
                    }
                    if (taskRB3.isSelected()) {
                        if (ti.getReason().equals("Break")) {
                            timerBreak[2] = new Timer(1000, new TimerListenerBreak());
                            if (elapsedSecondsBreak[2] > 0) {
                                timerBreak[2].start();
                                timerStart[2].stop();
                            } else {
                                timerBreak[2].stop();
                                timerStart[2].start();
                            }

                        }

                        if (ti.getReason().equals("Meeting")) {

                            timerStart[2].stop();
                        }
                        if (ti.getReason().equals("Query")) {
                            timerStart[2].stop();
                        }
                        if (ti.getReason().equals("End Of Working Hours")) {
                            timerStart[2].stop();
                        }


                        ti.setElapseSec(elapsedSecondsStart[2]);

                    }

                    taskRB1.setEnabled(true);
                    taskRB2.setEnabled(true);
                    taskRB3.setEnabled(true);



                    new TaskItemDAL().updateUStopDateTime(ti);

//                stopbit=1;
//                resumebit=0;


                    stopBT.setEnabled(false);
                    stopButtonFlag = false;
                    resumeBT.setEnabled(true);
                }
   }
   
   public void resumeButtonMethod(){
       
                TaskItem ti = new TaskItem();
                ti.setTdId(taskDeptSel);
                ti.setResume(new DateStoring().getPresentDate());


                new TaskItemDAL().updateUResumeDateTime(ti);

                if (taskRB1.isSelected()) {
                    timerBreak[0].stop();
                    timerStart[0].start();

                    taskRB2.setEnabled(false);
                    taskRB3.setEnabled(false);
                }
                if (taskRB2.isSelected()) {
                    timerBreak[1].stop();
                    timerStart[1].start();

                    taskRB1.setEnabled(false);
                    taskRB3.setEnabled(false);
                }
                if (taskRB3.isSelected()) {
                    timerBreak[2].stop();
                    timerStart[2].start();

                    taskRB1.setEnabled(false);
                    taskRB2.setEnabled(false);
                }



                userResume = ti.getResume();

                stopBT.setEnabled(true);
                stopButtonFlag = true;
                resumeBT.setEnabled(false);
   }
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == taskRB1) {

                startBT.setEnabled(true);
                stopBT.setEnabled(true);
                stopButtonFlag = true;
                resumeBT.setEnabled(true);
                doneBT.setEnabled(true);



                selectedTask = 0;

                taskDeptSel = taskDept[1];
                timerLabel.setText("");



                timerStart[0] = new Timer(1000, new TimerListenerStart());



                descLB.setText(taskDept[1].getTaskId().getDescription());
                totalLB.setText(taskDept[1].getDur().toString() + " hours");


                if (taskDeptSel.getuStartDateTime() != null) {

                    startBT.setEnabled(false);
                }

                if (startBT.isEnabled()) {
                    elapsedSecondsStart[0] = (long) taskDeptSel.getDur() * 3600;
                } else {

                    elapsedSecondsStart[0] = new ProjectCompletion().getElapseSec(taskDeptSel);

                }


                if (!startBT.isEnabled()) {
                    if (new ProjectCompletion().getTaskStopStatus(taskDeptSel)) {
                        resumeBT.setEnabled(true);
                        stopBT.setEnabled(false);
                        stopButtonFlag = false;

                    } else {
                        resumeBT.setEnabled(false);
                        stopBT.setEnabled(true);
                        stopButtonFlag = true;



                    }
                }

                if (taskDeptSel.getuStopDateTime() != null) {
                    doneBT.setEnabled(false);
                }

                if (!resumeBT.isEnabled()) {
                    timerStart[0].start();


                }


                long day = elapsedSecondsStart[0] / (3600 * 24);
                long hours = (elapsedSecondsStart[0] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsStart[0] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsStart[0] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);

                if (day >= 1) {
                    hours = hours + (day * 24);
                }
                if (sec < 10) {
                    remLB.setText(" " + hours + ": " + mins + " : 0" + sec);
                } else {
                    remLB.setText(" " + hours + ": " + mins + " : " + sec);
                }

                if (!doneBT.isEnabled()) {
                    startBT.setEnabled(false);
                    stopBT.setEnabled(false);
                    stopButtonFlag = false;
                    resumeBT.setEnabled(false);

                }


            } else if (e.getSource() == taskRB2) {

                startBT.setEnabled(true);
                stopBT.setEnabled(true);
                stopButtonFlag = true;
                resumeBT.setEnabled(true);
                doneBT.setEnabled(true);


                selectedTask = 1;


                taskDeptSel = taskDept[2];
                //  remLB.setText(""+new ProjectCompletion().getTaskCompPercent(taskDeptSel));
                timerLabel.setText("");

                elapsedSecondsStart[1] = new ProjectCompletion().getTaskCompPercent(taskDeptSel);
                timerStart[1] = new Timer(1000, new TimerListenerStart());
                // timerStart[1].start();

                descLB.setText(taskDept[2].getTaskId().getDescription());
                totalLB.setText(taskDept[2].getDur().toString() + " hours");


                if (taskDeptSel.getuStartDateTime() != null) {
                    startBT.setEnabled(false);
                }

                if (startBT.isEnabled()) {
                    elapsedSecondsStart[1] = (long) taskDeptSel.getDur() * 3600;
                } else {
                    elapsedSecondsStart[1] = new ProjectCompletion().getElapseSec(taskDeptSel);
                }

                if (!startBT.isEnabled()) {
                    if (new ProjectCompletion().getTaskStopStatus(taskDeptSel)) {
                        resumeBT.setEnabled(true);
                        stopBT.setEnabled(false);
                        stopButtonFlag = false;

                    } else {
                        resumeBT.setEnabled(false);
                        stopBT.setEnabled(true);
                        stopButtonFlag = true;


                    }
                }


                if (taskDeptSel.getuStopDateTime() != null) {
                    doneBT.setEnabled(false);
                }

                if (!resumeBT.isEnabled()) {
                    timerStart[1].start();
                }




                long day = elapsedSecondsStart[1] / (3600 * 24);
                long hours = (elapsedSecondsStart[1] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsStart[1] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsStart[1] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);

                if (day >= 1) {
                    hours = hours + (day * 24);
                }
                if (sec < 10) {
                    remLB.setText(" " + hours + ": " + mins + " : 0" + sec);
                } else {
                    remLB.setText(" " + hours + ": " + mins + " : " + sec);
                }

                if (!doneBT.isEnabled()) {
                    startBT.setEnabled(false);
                    stopBT.setEnabled(false);
                    stopButtonFlag = false;
                    resumeBT.setEnabled(false);

                }


            } else if (e.getSource() == taskRB3) {

                startBT.setEnabled(true);
                stopBT.setEnabled(true);
                stopButtonFlag = true;
                resumeBT.setEnabled(true);
                doneBT.setEnabled(true);


                selectedTask = 2;

                taskDeptSel = taskDept[3];

                timerLabel.setText("");


                elapsedSecondsStart[2] = new ProjectCompletion().getTaskCompPercent(taskDeptSel);
                timerStart[2] = new Timer(1000, new TimerListenerStart());



                descLB.setText(taskDept[3].getTaskId().getDescription());
                totalLB.setText(taskDept[3].getDur().toString() + " hours");


                if (taskDeptSel.getuStartDateTime() != null) {
                    startBT.setEnabled(false);
                }

                if (startBT.isEnabled()) {
                    elapsedSecondsStart[0] = (long) taskDeptSel.getDur() * 3600;
                } else {
                    elapsedSecondsStart[0] = new ProjectCompletion().getElapseSec(taskDeptSel);
                }

                if (!startBT.isEnabled()) {
                    if (new ProjectCompletion().getTaskStopStatus(taskDeptSel)) {
                        resumeBT.setEnabled(true);
                        stopBT.setEnabled(false);
                        stopButtonFlag = false;

                    } else {
                        resumeBT.setEnabled(false);
                        stopBT.setEnabled(true);
                        stopButtonFlag = true;


                    }
                }


                if (taskDeptSel.getuStopDateTime() != null) {
                    doneBT.setEnabled(false);
                    stopBT.setEnabled(false);
                    stopButtonFlag = false;
                    resumeBT.setEnabled(false);
                }

                if (!resumeBT.isEnabled()) {
                    timerStart[2].start();
                }

                long day = elapsedSecondsStart[2] / (3600 * 24);
                long hours = (elapsedSecondsStart[2] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsStart[2] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsStart[2] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);

                if (day >= 1) {
                    hours = hours + (day * 24);
                }
                if (sec < 10) {
                    remLB.setText(" " + hours + ": " + mins + " : 0" + sec);
                } else {
                    remLB.setText(" " + hours + ": " + mins + " : " + sec);
                }

                if (!doneBT.isEnabled()) {
                    startBT.setEnabled(false);
                    stopBT.setEnabled(false);
                    stopButtonFlag = false;
                    resumeBT.setEnabled(false);

                }
            }
        }
    };
    ActionListener a2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startBT) {
                startButtonMethod();
            }
            if (e.getSource() == stopBT) {
                stopButtonMethod();
            }
            if (e.getSource() == resumeBT) {
                resumeButtonMethod();
            }
            if (e.getSource() == doneBT) {
                doneButtonMethod();


            }
        }
    };
    KeyListener k2 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
             if (e.getSource() == startBT) {
                startButtonMethod();
            }
            if (e.getSource() == stopBT) {
                stopButtonMethod();
            }
            if (e.getSource() == resumeBT) {
                resumeButtonMethod();
            }
            if (e.getSource() == doneBT) {
                doneButtonMethod();


            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };

    void clear() {
        proj1LB.setText("");
        proj2LB.setText("");
        proj3LB.setText("");
        task1LB.setText("");
        task2LB.setText("");
        task3LB.setText("");
        priority1LB.setText("");
        priority2LB.setText("");
        priority3LB.setText("");
        descLB.setText("");
        totalLB.setText("");
        remLB.setText("");
        timerLabel.setText("");





    }

    private class TimerListenerBreak implements ActionListener {

        public void actionPerformed(ActionEvent evt) {

            if (taskRB1.isSelected()) {
                elapsedSecondsBreak[0]--;
                long day = elapsedSecondsBreak[0] / (3600 * 24);
                long hours = (elapsedSecondsBreak[0] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsBreak[0] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsBreak[0] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);


                if (elapsedSecondsBreak[0] == 0) {
                    timerBreak[0].stop();
                    timerStart[0].start();
                }


                if (sec < 10) {
                    timerLabel.setText("Break time: " + hours + ": " + mins + " : 0" + sec);
                } else {
                    timerLabel.setText("Break time: " + hours + ": " + mins + " : " + sec);
                }


            }

            if (taskRB2.isSelected()) {
                elapsedSecondsBreak[1]--;
                long day = elapsedSecondsBreak[1] / (3600 * 24);
                long hours = (elapsedSecondsBreak[1] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsBreak[1] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsBreak[1] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);


                if (elapsedSecondsBreak[1] == 0) {
                    timerBreak[1].stop();
                    timerStart[1].start();
                }


                if (sec < 10) {
                    timerLabel.setText("Break time: " + hours + ": " + mins + " : 0" + sec);
                } else {
                    timerLabel.setText("Break time: " + hours + ": " + mins + " : " + sec);
                }


            }

            if (taskRB3.isSelected()) {
                elapsedSecondsBreak[2]--;
                long day = elapsedSecondsBreak[2] / (3600 * 24);
                long hours = (elapsedSecondsBreak[2] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsBreak[2] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsBreak[2] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);


                if (elapsedSecondsBreak[2] == 0) {
                    timerBreak[2].stop();
                    timerStart[2].start();
                }


                if (sec < 10) {
                    timerLabel.setText("Break time: " + hours + ": " + mins + " : 0" + sec);
                } else {
                    timerLabel.setText("Break time: " + hours + ": " + mins + " : " + sec);
                }

            }

        }
    }

    private class TimerListenerStart implements ActionListener {

        public void actionPerformed(ActionEvent evt) {

            if (taskRB1.isSelected()) {
                elapsedSecondsStart[0]--;
                long day = elapsedSecondsStart[0] / (3600 * 24);
                long hours = (elapsedSecondsStart[0] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsStart[0] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsStart[0] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);


                //System.out.println("final day" + day + "hours" + hours + "mins" + mins + "sec" + sec);
                if (day >= 1) {
                    hours = hours + (day * 24);
                }
                if (sec < 10) {
                    remLB.setText(" " + hours + ": " + mins + " : 0" + sec);
                } else {
                    remLB.setText(" " + hours + ": " + mins + " : " + sec);
                }
                
                if(elapsedSecondsStart[0]<0){
                    
                    remLB.setForeground(Color.red);
                }
                else{
                    remLB.setForeground(Color.BLACK);
                }




//                Integer tiid = new TaskItemDAL().getTiId(taskDeptSel);
//                TaskItem ti = new TaskItem();
//                ti.setTiId(tiid);
//                ti.setTdId(taskDeptSel);
//                ti.setElapseSec(elapsedSecondsStart[0]);
////            System.out.println("tiid"+ti.getTiId()+"taskdeptsel"+ti.getTdId()+"elapsesec"+ti.getElapseSec());
//                new TaskItemDAL().updateElapseSec(ti);

            }


            if (taskRB2.isSelected()) {
                elapsedSecondsStart[1]--;
                long day = elapsedSecondsStart[1] / (3600 * 24);
                long hours = (elapsedSecondsStart[1] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsStart[1] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsStart[1] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);


                //System.out.println("final day" + day + "hours" + hours + "mins" + mins + "sec" + sec);
                if (day >= 1) {
                    hours = hours + (day * 24);
                }
                if (sec < 10) {
                    remLB.setText(" " + hours + ": " + mins + " : 0" + sec);
                } else {
                    remLB.setText(" " + hours + ": " + mins + " : " + sec);
                }
                
                if(elapsedSecondsStart[1]<0){
                    
                    remLB.setForeground(Color.red);
                }
                else{
                    remLB.setForeground(Color.BLACK);
                }
//                Integer tiid = new TaskItemDAL().getTiId(taskDeptSel);
//                TaskItem ti = new TaskItem();
//                ti.setTiId(tiid);
//                ti.setTdId(taskDeptSel);
//                ti.setElapseSec(elapsedSecondsStart[1]);
////            System.out.println("tiid"+ti.getTiId()+"taskdeptsel"+ti.getTdId()+"elapsesec"+ti.getElapseSec());
//                new TaskItemDAL().updateElapseSec(ti);
            }

            if (taskRB3.isSelected()) {
                elapsedSecondsStart[2]--;
                long day = elapsedSecondsStart[2] / (3600 * 24);
                long hours = (elapsedSecondsStart[2] % (3600 * 24)) / 3600;
                long mins = ((elapsedSecondsStart[2] % (3600 * 24)) % 3600) / 60;
                long sec = elapsedSecondsStart[2] - (day * 24 * 3600) - (hours * 3600) - (mins * 60);


                //System.out.println("final day" + day + "hours" + hours + "mins" + mins + "sec" + sec);
                if (day >= 1) {
                    hours = hours + (day * 24);
                }
                if (sec < 10) {
                    remLB.setText(" " + hours + ": " + mins + " : 0" + sec);
                } else {
                    remLB.setText(" " + hours + ": " + mins + " : " + sec);
                }
                
                if(elapsedSecondsStart[2]<0){
                    
                    remLB.setForeground(Color.red);
                }
                else{
                    remLB.setForeground(Color.BLACK);
                }
//                Integer tiid = new TaskItemDAL().getTiId(taskDeptSel);
//                TaskItem ti = new TaskItem();
//                ti.setTiId(tiid);
//                ti.setTdId(taskDeptSel);
//                ti.setElapseSec(elapsedSecondsStart[2]);
////            System.out.println("tiid"+ti.getTiId()+"taskdeptsel"+ti.getTdId()+"elapsesec"+ti.getElapseSec());
//                new TaskItemDAL().updateElapseSec(ti);


            }
            // Long es=  new ProjectCompletion().getElapseSec(taskDeptSel);

        }
    }

    private class TimerListenerUpdate implements ActionListener {

        public void actionPerformed(ActionEvent evt) {

            elapsedSecondsUpdate++;

            Integer tiid = new TaskItemDAL().getTiId(taskDeptSel);
            TaskItem ti = new TaskItem();
            ti.setTiId(tiid);
            ti.setTdId(taskDeptSel);
            if (selectedTask != null) {
                ti.setElapseSec(elapsedSecondsStart[selectedTask]);
                if (elapsedSecondsUpdate >= 30) {
                    new TaskItemDAL().updateElapseSec(ti);

                    elapsedSecondsUpdate = (long) 0;

                }

            }

        }
    }
}
