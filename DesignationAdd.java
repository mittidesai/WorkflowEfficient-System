/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;



import dal.DesignationDAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import to.Designation;


/**
 *
 * @author 02
 */
public class DesignationAdd extends javax.swing.JPanel {

    /**
     * Creates new form DesignationAdd
     */
    public DesignationAdd() {
        initComponents();
        clear();
        addBT.addActionListener(al);
        addBT.addKeyListener(k2);
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
        jLabel3 = new javax.swing.JLabel();
        dsgnTitleTF = new javax.swing.JTextField();
        dsgnDesVAL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsgnDesTA = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        dsgnTitleVAL = new javax.swing.JLabel();
        addBT = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(86, 86, 87));
        jLabel1.setText("Add Designation");

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(86, 86, 87));
        jLabel3.setText("Designation Description :");

        dsgnTitleTF.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N

        dsgnDesVAL.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        dsgnDesVAL.setForeground(new java.awt.Color(255, 0, 0));
        dsgnDesVAL.setText("jLabel5");

        dsgnDesTA.setColumns(20);
        dsgnDesTA.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        dsgnDesTA.setRows(5);
        jScrollPane1.setViewportView(dsgnDesTA);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(86, 86, 87));
        jLabel2.setText("Designation Title :");

        dsgnTitleVAL.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        dsgnTitleVAL.setForeground(new java.awt.Color(255, 0, 0));
        dsgnTitleVAL.setText("dsgnNameLB");

        addBT.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        addBT.setForeground(new java.awt.Color(86, 86, 87));
        addBT.setText("ADD");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(42, 42, 42)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 259, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(dsgnTitleTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 249, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 249, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(102, 102, 102)
                                .add(addBT)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(dsgnTitleVAL, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .add(dsgnDesVAL, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(35, 35, 35)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(dsgnTitleTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dsgnTitleVAL))
                .add(48, 48, 48)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dsgnDesVAL))
                .add(42, 42, 42)
                .add(addBT)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBT;
    private javax.swing.JTextArea dsgnDesTA;
    private javax.swing.JLabel dsgnDesVAL;
    private javax.swing.JTextField dsgnTitleTF;
    private javax.swing.JLabel dsgnTitleVAL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public void addButtonMethod(){
         if (validation()) {
                    
                    Designation designation = new Designation();
                    designation.setDsgnTitle(dsgnTitleTF.getText());
                    designation.setDsgnDesc(dsgnDesTA.getText());
                  
                    new DesignationDAL().addDesignationDetails(designation);

                    System.out.println("Done");

                }
    }
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addBT) {
                addButtonMethod();
               
            }
        }
    };
    KeyListener k2 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
             if (e.getSource() == addBT) {
                addButtonMethod();
               
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    

    void clear() {
        dsgnTitleVAL.setText("");
        dsgnDesVAL.setText("");
        
    }

    boolean validation() {
        boolean flag = true;
        clear();

        if (dsgnTitleTF.getText().equals("")) {
            dsgnTitleVAL.setText("Please enter designation title");
            flag = false;
        }
        if (dsgnDesTA.getText().equals("")) {
            dsgnDesVAL.setText("Please enter designation description");
            flag = false;
        }
        return flag;
    }
}
