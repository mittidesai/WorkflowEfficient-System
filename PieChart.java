/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import Conversion.ProjectCompletion;
import dal.ConnectionDAL;
import dal.TaskDeptDAL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import to.Employee;
import to.Project;
import to.TaskDept;

public class PieChart extends JFrame {

    private static final long serialVersionUID = 1L;

    public PieChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset 
        // PieDataset dataset = createDataset();
//        PieDataset dataset = projectduration();
//        // based on the dataset we create the chart
//        JFreeChart chart = createChart(dataset, chartTitle);
//        // we put the chart into a panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        // default size
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//        // add it to our application
//        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset
     */
    public void taskcomparisioncall(String chartTitle, Project project) {


        PieDataset dataset = taskcomparision(project);
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);
    }

    private PieDataset taskcomparision(Project project) {

        DefaultPieDataset result = new DefaultPieDataset();

        List<TaskDept> taskDeptList = new TaskDeptDAL().getTaskDeptDetails();

        for (TaskDept taskDeptTemp : taskDeptList) {

            if (taskDeptTemp.getProjId().getProjId() == project.getProjId() && taskDeptTemp.getDeptId().getDeptId() == LogIn.localempid.getDeptId().getDeptId()) {
                System.out.println("task::" + taskDeptTemp.getTaskId().getTaskId());

                double compper;
                long remainingtime = new ProjectCompletion().getElapseSec(taskDeptTemp);
                if (remainingtime < 0) {
                    remainingtime = Math.abs(remainingtime);
                }
                if (remainingtime == 0) {
                    remainingtime = taskDeptTemp.getDur() * 3600;
                }
                if (taskDeptTemp.getTdb() == 1) {
                    compper = 100;
                } else {
                    double dur = taskDeptTemp.getDur() * 3600;
                    System.out.println("dur::" + dur + "remaining time::" + remainingtime);
                    compper = ((dur - (double) remainingtime) / dur) * 100;
                }

                System.out.println("task::" + taskDeptTemp.getTaskId().getTaskId() + "Completion::" + compper);
                result.setValue(taskDeptTemp.getTaskId().getTitle(), compper);
            }

        }



//            result.setValue("Mac", 20);
//            result.setValue("Windows", 51);
        return result;

    }

    public void projectdurationcall(String chartTitle) {
        PieDataset dataset = projectduration();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);
    }

    private PieDataset projectduration() {
        Connection connection = ConnectionDAL.getConnection();
        Statement st;
        DefaultPieDataset result = new DefaultPieDataset();
        try {
            st = connection.createStatement();
            String qry1 = "select proj_id,title,end_date,start_date,DATEDIFF(end_date,start_date) as datediff from project";

            ResultSet rs = st.executeQuery(qry1);
            while (rs.next()) {
                result.setValue(rs.getString("TITLE"), rs.getInt("datediff"));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void employeeperformancecall(String chartTitle, Project project) {
        PieDataset dataset = employeeperformance(project);
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);
    }

    private PieDataset employeeperformance(Project project) {
        try {
            Connection connection = new ConnectionDAL().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select  avg(er) as avger,td.emp_id,emp.emp_name from taskdept td,task t, employee emp where td.task_id=t.task_id and td.emp_id=emp.emp_id and t.proj_id='"+project.getProjId()+"' and td.dept_id='"+LogIn.localempid.getDeptId().getDeptId()+"' group by emp_id");

            DefaultPieDataset result = new DefaultPieDataset();
            while (rs.next()) {
               result.setValue((Comparable)rs.getString("emp_name"), rs.getDouble("avger"));

            }
            return result;
      
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
    
      public void employeeperformanceinallprojectscall(String chartTitle, Employee employee) {
        PieDataset dataset = employeeperformanceinallprojects(employee);
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);
    }

    
     private PieDataset employeeperformanceinallprojects(Employee employee) {
        try {
            Connection connection = new ConnectionDAL().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select  avg(er) as avger,td.emp_id,emp.emp_name,proj.title from taskdept td,task t, employee emp, project proj where td.task_id=t.task_id and td.emp_id=emp.emp_id and t.proj_id=proj.proj_id and td.dept_id='"+LogIn.localempid.getDeptId().getDeptId()+"' and td.emp_id='"+employee.getEmpId()+"' group by t.proj_id");

            DefaultPieDataset result = new DefaultPieDataset();
            while (rs.next()) {
               result.setValue((Comparable)rs.getString("proj.title"), rs.getDouble("avger"));

            }
            return result;
      
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * Creates a chart
     */
    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(title, // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }
}
