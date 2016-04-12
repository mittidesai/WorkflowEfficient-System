/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import Conversion.ExtensionFileFilter;
import dal.ProjEmpDal;
import dal.ProjFileDAL;
import dal.ProjectDAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import to.ProjEmp;
import to.ProjFile;
import to.Project;

/**
 *
 * @author hp pav 15-e015tx
 */
public class SRSAttach extends javax.swing.JPanel {

    /**
     * Creates new form SRSAttach
     */
    public static int selid = 0;
    public static String type = "";

    public SRSAttach() {
        initComponents();


      
        if(LogIn.localempid.getDsgnId().getDsgnTitle().toString().equals("DEPUTY GENERAL MANAGER"))
        {
            fillComboDataProjectDgm(ProjCB);
        }
        else{
              fillComboDataProject(ProjCB);
        }
      
        fillComboDataAttachedFiles(AttachedFilesCB);
        fillComboDataFileType(FileTypeCB);

        BrowseBT.addActionListener(al);
        AttachBT.addActionListener(al);
        DownloadBT.addActionListener(al);
        EditBT.addActionListener(al);
        BrowseBT.addKeyListener(k2);
        AttachBT.addKeyListener(k2);
        DownloadBT.addKeyListener(k2);
        EditBT.addKeyListener(k2);
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
        jPanel2 = new javax.swing.JPanel();
        BrowseTF = new javax.swing.JTextField();
        ProjCB = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        BrowseBT = new javax.swing.JButton();
        EditBT = new javax.swing.JButton();
        DownloadBT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AttachBT = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AttachedFilesCB = new javax.swing.JComboBox();
        FileTypeCB = new javax.swing.JComboBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(86, 86, 87));
        jLabel1.setText("     Attach Files");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BrowseTF.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N

        ProjCB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        ProjCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel3.setText("Attach Files:");

        BrowseBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BrowseBT.setText("Browse");

        EditBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        EditBT.setText("Edit");

        DownloadBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        DownloadBT.setText("Download");

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel4.setText("Attached Files:");

        AttachBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        AttachBT.setText("Attach");

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel5.setText("File Type:");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel2.setText("Project:");

        AttachedFilesCB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        AttachedFilesCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        FileTypeCB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BrowseTF, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(FileTypeCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ProjCB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AttachedFilesCB, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BrowseBT, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AttachBT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(DownloadBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EditBT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ProjCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FileTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(BrowseTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BrowseBT)
                            .addComponent(AttachBT))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(AttachedFilesCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DownloadBT)
                            .addComponent(EditBT))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
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
    private javax.swing.JButton AttachBT;
    private javax.swing.JComboBox AttachedFilesCB;
    private javax.swing.JButton BrowseBT;
    private javax.swing.JTextField BrowseTF;
    private javax.swing.JButton DownloadBT;
    private javax.swing.JButton EditBT;
    private javax.swing.JComboBox FileTypeCB;
    private javax.swing.JComboBox ProjCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    
    public void BrowseButtonMethod()
    {
         JFileChooser fc = new JFileChooser();

                ExtensionFileFilter filter1 = new ExtensionFileFilter("PDF", new String[]{"pdf", "pdf"});
                fc.setFileFilter(filter1);
                int result = fc.showOpenDialog(WorkFlowEfficient.wfes);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {

                        s = fc.getSelectedFile().getAbsolutePath();
                        file = new File(s);

                        BrowseTF.setText(s);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
    }
    
    public void attachButtonMethod(){
        ProjFile projFile = new ProjFile();

                projFile.setProjId((Project) ProjCB.getSelectedItem());
                projFile.setFile(file);
                projFile.setfiletype(FileTypeCB.getSelectedItem().toString());
                System.out.println("File:" + file);

                int flag=0;
                List<ProjFile> projfileList = new ProjFileDAL().getProjFileDetails();
                ProjFile projfileTempFinal = null;
                for (ProjFile projfileTemp : projfileList) {

                    if(projFile.getProjId().getProjId()==projfileTemp.getProjId().getProjId() && projFile.getfiletype().toString().equals(projfileTemp.getfiletype().toString())){
                        flag=1;
                        JOptionPane.showMessageDialog(WorkFlowEfficient.wfes, "File Already Exists");
                        break;
                    }
                    

                }

                if(flag==0){
                new ProjFileDAL().addProjFileDetails(projFile);
                fillComboDataAttachedFiles(AttachedFilesCB);
                }
    }
    
    public void downloadButtonMethod(){
         selid = ((ProjFile) AttachedFilesCB.getSelectedItem()).getProjId().getProjId();
                type = ((ProjFile) AttachedFilesCB.getSelectedItem()).getfiletype();


              


                JFileChooser fc = new JFileChooser();

                ExtensionFileFilter filter1 = new ExtensionFileFilter("PDF", new String[]{"pdf", "pdf"});
                fc.setFileFilter(filter1);

                int result = fc.showSaveDialog(WorkFlowEfficient.wfes);




                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        s = fc.getSelectedFile().getAbsolutePath();

                        new ProjFileDAL().retrievedata(s);


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
    }
    
    public void editButtonMethod(){
          ProjFile projFile = (ProjFile) AttachedFilesCB.getSelectedItem();

                JFileChooser fc = new JFileChooser();

                ExtensionFileFilter filter1 = new ExtensionFileFilter("PDF", new String[]{"pdf", "pdf"});
                fc.setFileFilter(filter1);

                int result = fc.showOpenDialog(WorkFlowEfficient.wfes);




                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        s = fc.getSelectedFile().getAbsolutePath();
                        file = new File(s);
                        projFile.setFile(file);
                        new ProjFileDAL().updateProjFileDetails(projFile);
                        //new ProjFileDAL().retrievedata(s);


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
    }
    void fillComboDataProject(JComboBox jComboBox) {
        Vector vector = new Vector();
        List<ProjEmp> projEmpList = new ProjEmpDal().getProjEmpDetails();
        vector.add("Please Select");
       ProjEmp projEmpTempFinal = null;
        for (ProjEmp projEmpTemp : projEmpList) {
            if(projEmpTemp.getEmpId().getEmpId()==LogIn.localempid.getEmpId()){
                System.out.println("in fil proj"+projEmpTemp.getProjId().getTitle());
                vector.add(projEmpTemp.getProjId());
            }
            
        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }
    
      void fillComboDataProjectDgm(JComboBox jComboBox) {
        Vector vector = new Vector();
        List<Project> projectList = new ProjectDAL().getProjectDetails();
        vector.add("Please Select");
        for (Project projectTemp : projectList) {
            if(projectTemp.getStatus() != 2){
               // System.out.println("in fil proj"+projEmpTemp.getProjId().getTitle());
                vector.add(projectTemp);
            }
            
        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }
      
       void fillComboDataFileType(JComboBox jComboBox) {
        Vector vector = new Vector();
       
  
       if(LogIn.localempid.getDsgnId().getDsgnTitle().toString().equals("DEPUTY GENERAL MANAGER")){
        vector.add("Information");
       }
       else{
           vector.add("Please Select");
           vector.add("SRS");
           vector.add("Design");
           vector.add("Diagram");
           vector.add("Report");
           
       }
           
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }

    void fillComboDataAttachedFiles(JComboBox jComboBox) {
        Vector vector = new Vector();
        vector.add("Please Enter");
        List<ProjFile> projfileList = new ProjFileDAL().getProjFileDetails();
        ProjFile projfileTempFinal = null;
        for (ProjFile projfileTemp : projfileList) {

            vector.add(projfileTemp);

        }
        ComboBoxModel cbm = new DefaultComboBoxModel(vector);
        jComboBox.setModel(cbm);

    }
    String s = "";
    File file = null;
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == BrowseBT) {
               BrowseButtonMethod();
            }
            if (e.getSource() == AttachBT) {
                
                attachButtonMethod();
            }
            if (e.getSource() == DownloadBT) {
                downloadButtonMethod();
               
            }

            if (e.getSource() == EditBT) {
               editButtonMethod();
            }


        }
    };
    KeyListener k2 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
             if (e.getSource() == BrowseBT) {
               BrowseButtonMethod();
            }
            if (e.getSource() == AttachBT) {
                
                attachButtonMethod();
            }
            if (e.getSource() == DownloadBT) {
                downloadButtonMethod();
               
            }

            if (e.getSource() == EditBT) {
               editButtonMethod();
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
}
