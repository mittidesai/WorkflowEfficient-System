package wfes;

import Conversion.TableData;
import dal.ConnectionDAL;
import dal.EmployeeDAL;
import dal.ProjectDAL;
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
import to.Project;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 01
 */
public class ProjectView extends javax.swing.JPanel {

    /**
     * Creates new form ProjectView
     */
    List<Project> projectList = null;
    Vector colVector = new Vector();
    public static int selectedRow = 0;

    public ProjectView() {
        initComponents();


        //td.fillTableData(projectViewTB, new ConnectionDAL().getConnection(), "project");


        refreshtb();
        projectList = new ProjectDAL().getProjectDetails();

        projectViewTB.getSelectionModel().addListSelectionListener(l1);
        projectViewTB.addKeyListener(kl);
        searchTF.setEnabled(false);
        detailedViewBT.addActionListener(al);
        detailedViewBT.addKeyListener(k2);


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
        searchTF = new javax.swing.JTextField();
        detailedViewBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectViewTB = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        searchTF.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        searchTF.setForeground(new java.awt.Color(86, 86, 87));

        detailedViewBT.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        detailedViewBT.setForeground(new java.awt.Color(86, 86, 87));
        detailedViewBT.setText("DETAILED VIEW");

        projectViewTB.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        projectViewTB.setForeground(new java.awt.Color(86, 86, 87));
        projectViewTB.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(projectViewTB);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(86, 86, 87));
        jLabel1.setText("PROJECT VIEW");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(86, 86, 87));
        jLabel2.setText("Search:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(detailedViewBT))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(230, 230, 230))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailedViewBT)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
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
    private javax.swing.JButton detailedViewBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable projectViewTB;
    private javax.swing.JTextField searchTF;
    // End of variables declaration//GEN-END:variables

    void refreshtb() {
        projectList = new ProjectDAL().getProjectDetails();
        colVector = new ProjectDAL().getProjectColumnDetails();

        Vector rowVector = new Vector();
        for (Project projectTemp : projectList) {
            Vector temp = new Vector();
            temp.add(projectTemp.getProjId());
            temp.add(projectTemp.getTitle());
            temp.add(projectTemp.getDescription());
            temp.add(projectTemp.getClient());
            rowVector.add(temp);
        }
        TableModel model = new DefaultTableModel(rowVector, colVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        projectViewTB.setModel(model);
            projectViewTB.setAutoCreateRowSorter(true);

        //projectModifyTB.removeColumn(projectModifyTB.getColumnModel().getColumn(0));


       // projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(17));
       // projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(16));
//        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(15));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(14));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(13));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(12));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(11));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(10));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(9));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(8));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(7));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(6));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(5));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(4));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(0));



    }
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == detailedViewBT) {

                new popup.popup().displayProjectDetail();
            }
        }
    };
    KeyListener k2 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
             if (e.getSource() == detailedViewBT) {

                new popup.popup().displayProjectDetail();
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    ListSelectionListener l1 = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {

            if (projectViewTB.getSelectedRow() > -1) {
                int row = projectViewTB.convertRowIndexToModel(projectViewTB.getSelectedRow());


                int col = projectViewTB.convertColumnIndexToModel(projectViewTB.getSelectedColumn());

                Object obj = projectViewTB.getModel().getValueAt(row, 0);

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

                String data = searchTF.getText();
                if (data.length() > 0) {
                    data = data.substring(0, data.length() - 1);
                    searchTF.setText(data);
                }
            } else {
                if ((e.getKeyCode() >= 'a' && e.getKeyCode() <= 'z') || (e.getKeyCode() >= 'A' && e.getKeyCode() <= 'Z') || (e.getKeyCode() >= '0' && e.getKeyCode() <= '9') || e.getKeyCode() == ' ') {
                    searchTF.setText(searchTF.getText() + e.getKeyChar());
                    searchTF.setText(searchTF.getText().toLowerCase());
                } else {
                    //System.out.println("hello");
                }
            }
            searchProjectList();

        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    };

    public void searchProjectList() {
        String data = searchTF.getText();
        List<Project> projectListTemp = new ArrayList<Project>();
        for (Project projectTemp : projectList) {
            if (projectTemp.getTitle().toLowerCase().contains(data) || projectTemp.getDescription().toLowerCase().contains(data) || projectTemp.getClient().toLowerCase().contains(data)) {
                projectListTemp.add(projectTemp);
            }
        }
        Vector rowVector = new Vector();
        for (Project projectTemp : projectListTemp) {
            Vector temp = new Vector();
            temp.add(projectTemp.getProjId());
            temp.add(projectTemp.getTitle());
            temp.add(projectTemp.getDescription());
            temp.add(projectTemp.getClient());
            rowVector.add(temp);
        }
        
        TableModel model = new DefaultTableModel(rowVector, colVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        projectViewTB.setModel(model);


       // projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(0));
       // projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(17));
       // projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(16));
       // projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(15));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(14));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(13));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(12));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(11));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(10));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(9));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(8));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(7));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(6));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(5));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(4));
        projectViewTB.removeColumn(projectViewTB.getColumnModel().getColumn(0));


    }
}