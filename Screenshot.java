package wfes;

//package
// com.kushal.utils;
 
/**
 * @author Kushal Paudyal
 * JavaScreenCaptureUtil.java
 *
 * This utility captures the screenshot and saves
 * the captured image to disk.
 */
import Conversion.UtilToSql;
import dal.SpyModuleDAL;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
 
 
import javax.imageio.ImageIO;
import to.Employee;
import to.SpyModule;
 
public class Screenshot {
     SpyModule spymodule1 = new SpyModule();
      Date date =new Date();
 List<SpyModule> spymoduleList = null;
 
    public static void main(String args[]) throws Exception {
        Employee employee = new Employee();
        
  SpyModule spymodule1 = new SpyModule();
 
 
        /**
         * This class (Robot.java) is used to generate native system input events for the
         * purposes of test automation, self-running demos, and other
         * applications where control of the mouse and keyboard is needed.
         * The primary purpose of Robot is to facilitate automated testing
         * of Java platform implementations.
         */
        Robot robot = new Robot();
         
        /**
         * Get the current screen dimensions.
         */
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
         
         
        /**
         * Delay the robot for 5 seconds (5000 ms) allowing you to switch to proper
         * screen/window whose screenshot is to be taken.
         *
         * You can change the delay time as required.
         */
        robot.delay(15000);
         
        /**
         * Create a screen capture of the active window and then create a buffered image
         * to be saved to disk.
         */
        Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
                height));
 
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
       // RetrieveAndStoreImage();
        /*
         * Filename where to save the file to.
         * I am appending formatted timestamp to the filename.
         */
        String time=createTimeStampStr() ;
        String fileNameToSaveTo = "C:/Temp/screenCapture_"
                + time + ".PNG";
         
        /**
         * Write the captured image to a file.
         * I am using PNG format. You can choose PNG, JPG, GIF.
         */
        writeImage(bi, fileNameToSaveTo, "PNG");
     //   SimpleDateFormat d1= new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
       
        UtilToSql util2sql = new UtilToSql();
        Date date =new Date();
        Timestamp timestmp = new Timestamp(date.getYear(), date.getMonth(), date.getDate(),date.getHours(), date.getMinutes(), date.getSeconds(),00);
       
        java.sql.Date s2= util2sql.convertUtilToSql(date);
        
 
//        System.out.println("Screen Captured Successfully and Saved to:\n"+fileNameToSaveTo);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //use another encoding if JPG is innappropriate for you
        ImageIO.write(bi, "jpg", baos );
        baos.flush();
        byte[] immAsBytes = baos.toByteArray();
        baos.close();
          
//        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//        ImageIO.write(bi, "png", baos);        
//        InputStream is=new ByteArrayInputStream(baos.toByteArray());
  //      System.out.println("Im here 1");
        spymodule1.setDt(timestmp);
        spymodule1.setInputStream(immAsBytes);
       
        
        new SpyModuleDAL().addSpyModuleDetails(spymodule1);
 
    }
 
    /**run
     * This method writes a buffered image to a fgtile
     *
     * @param img -- > BufferedImage
     * @param fileLocation --> e.g. "C:/testImage.jpg"
     * @param extension --> e.g. "jpg","gif","png"
     */
    public static void writeImage(BufferedImage img, String fileLocation,
            String extension) {
        try {
            BufferedImage bi = img;
            File outputfile = new File(fileLocation);
            ImageIO.write(bi, extension, outputfile);
        } catch (IOException e) {
          //  e.printStackTrace();
        }
    }
   
 
    /**
     *
     * @return String representation of timestamp
     * in the format of yyyyMMdd_hhmmss (e.g. 20100426_111612)
     * @throws Exception
     */
    public static String createTimeStampStr() throws Exception {
        Calendar mycalendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hhmmss");
        String timeStamp = formatter.format(mycalendar.getTime());
 
        return timeStamp;
 
    }
    
 
       /*
     * SANJAAL CORPS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
     * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT
     * LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
     * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SANJAAL CORPS SHALL NOT BE
     * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
     * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
     *
     * THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
     * CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
     * PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
     * NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
     * SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
     * SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
     * PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). SANJAAL CORPS
     * SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
     * HIGH RISK ACTIVITIES.
     */
 

}