/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import Conversion.ProjectCompletion;
import dal.ConnectionDAL;
import dal.TaskDeptDAL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;
import to.Employee;
import to.Project;
import to.TaskDept;

public class BarChartDemo extends JFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title the frame title.
     */
    public BarChartDemo(final String title) {

        super(title);

//        final CategoryDataset dataset = createDataset();
//        final JFreeChart chart = createChart(dataset);
//        final ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new Dimension(500, 270));
//        setContentPane(chartPanel);

    }

    /**
     * Returns a sample dataset.
     *
     * @return The dataset.
     */
    private CategoryDataset createDataset() {

        // row keys...
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";

        // column keys...
        final String category1 = "Category 1";
        final String category2 = "Category 2";
        final String category3 = "Category 3";
        final String category4 = "Category 4";
        final String category5 = "Category 5";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5.0, series1, category5);

        dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(6.0, series2, category3);
        dataset.addValue(8.0, series2, category4);
        dataset.addValue(4.0, series2, category5);

        dataset.addValue(4.0, series3, category1);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);

        return dataset;

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset the dataset.
     *
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset,String value,String chartTitle, String category) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
                chartTitle, // chart title
                category, // domain axis label
                value, // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
                );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
                0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, Color.lightGray);
        final GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, Color.lightGray);
        final GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.red,
                0.0f, 0.0f, Color.lightGray);
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }

    public void taskcomparisioncall(String chartTitle, Project project) {


        final CategoryDataset dataset = taskcomparision(project);
        final JFreeChart chart = createChart(dataset,"Completion Percentage","Task Comparision","Tasks");
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private CategoryDataset taskcomparision(Project project) {

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<TaskDept> taskDeptList = new TaskDeptDAL().getTaskDeptDetails();
        String series[] = new String[50];
        int i = 1;

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
               // result.setValue(taskDeptTemp.getTaskId().getTitle(), compper);
                series[i] = taskDeptTemp.getTaskId().getTitle();


                // column keys...
                final String category1 = "";
              //  final String category2 = "Urgent";
                // create the dataset...
               
                    dataset.addValue(compper, series[i], category1);
                    i++;
                
            }

        }



//            result.setValue("Mac", 20);
//            result.setValue("Windows", 51);
        return dataset;

    }

    public void projectdurationcall(String chartTitle) {


        final CategoryDataset dataset = projectduration();
        final JFreeChart chart = createChart(dataset,"Days","Project Duration Analysis","Projects");
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private CategoryDataset projectduration() {
        Connection connection = ConnectionDAL.getConnection();
        Statement st;

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            st = connection.createStatement();
            String qry1 = "select proj_id,title,end_date,start_date,DATEDIFF(end_date,start_date) as datediff,priority from project";

            String series[] = new String[50];
            ResultSet rs = st.executeQuery(qry1);
            int i = 1;
            while (rs.next()) {

                series[i] = rs.getString("title");


                // column keys...
                final String category1 = "Routine";
                final String category2 = "Urgent";
                // create the dataset...
                if (rs.getInt("priority") == 1) {
                    dataset.addValue(rs.getInt("datediff"), series[i], category1);
                } else if (rs.getInt("priority") == 2) {
                    dataset.addValue(rs.getInt("datediff"), series[i], category2);
                }



                //  dataset.addValue(rs.getInt("datediff"), series[i], category1);

                i++;
            }
            return dataset;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
     public void employeeperformancecall(String chartTitle, Project project) {
      
        final CategoryDataset dataset = employeeperformance(project);
        final JFreeChart chart = createChart(dataset,"Employee Performance","Team Performance Analysis","Employee");
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private CategoryDataset employeeperformance(Project project) {
        try {
            Connection connection = new ConnectionDAL().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select  avg(er) as avger,td.emp_id,emp.emp_name from taskdept td,task t, employee emp where td.task_id=t.task_id and td.emp_id=emp.emp_id and t.proj_id='"+project.getProjId()+"' and td.dept_id='"+LogIn.localempid.getDeptId().getDeptId()+"' group by emp_id");

          final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
          String series[] = new String[50];
            int i = 1;
            while (rs.next()) {
              // result.setValue((Comparable)rs.getString("emp_name"), rs.getDouble("avgkra"));
                  series[i] = rs.getString("emp_name");


                // column keys...
                final String category1 = "";
               // final String category2 = "Urgent";
                // create the dataset...
//                if (rs.getInt("priority") == 1) {
//                    dataset.addValue(rs.getInt("datediff"), series[i], category1);
//                } else if (rs.getInt("priority") == 2) {
                    dataset.addValue(rs.getDouble("avger"), series[i], category1);
               // }



                //  dataset.addValue(rs.getInt("datediff"), series[i], category1);

                i++;

            }
            return dataset;
      
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
     public void employeeperformanceinallprojectscall(String chartTitle, Employee employee) {
          final CategoryDataset dataset = employeeperformanceinallprojects(employee);
        final JFreeChart chart = createChart(dataset,"Employee Performance","Employee Performance Analysis","Project");
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    
     private CategoryDataset employeeperformanceinallprojects(Employee employee) {
        try {
            Connection connection = new ConnectionDAL().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select  avg(er) as avger,td.emp_id,emp.emp_name,proj.title from taskdept td,task t, employee emp, project proj where td.task_id=t.task_id and td.emp_id=emp.emp_id and t.proj_id=proj.proj_id and td.dept_id='"+LogIn.localempid.getDeptId().getDeptId()+"' and td.emp_id='"+employee.getEmpId()+"' group by t.proj_id");

            final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            String series[] = new String[50];
            int i=0;
            while (rs.next()) {
              // result.setValue((Comparable)rs.getString("proj.title"), rs.getDouble("avgkra"));
               
                series[i] = rs.getString("proj.title");


                // column keys...
                final String category1 = "";
               // final String category2 = "Urgent";
                // create the dataset...
//                if (rs.getInt("priority") == 1) {
//                    dataset.addValue(rs.getInt("datediff"), series[i], category1);
//                } else if (rs.getInt("priority") == 2) {
                    dataset.addValue(rs.getDouble("avger"), series[i], category1);
               // }



                //  dataset.addValue(rs.getInt("datediff"), series[i], category1);

                i++;

            }
            return dataset;
      
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}