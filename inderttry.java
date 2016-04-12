/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import dal.ConnectionDAL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.rmi.CORBA.Util;

/**
 *
 * @author hp pav 15-e015tx
 */
public class inderttry {

    void insertdata() {
        try {
            PreparedStatement preparedStatement = new ConnectionDAL().getConnection().prepareStatement("INSERT INTO `wfes`.`imagetry` (`FILE_NAME`) VALUES (?)");
            File fBlob = new File("C:\\Users\\hp pav 15-e015tx\\Documents\\new.pdf");
            FileInputStream is = new FileInputStream(fBlob);
            preparedStatement.setBinaryStream(1, is, (int) fBlob.length());
            preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void retrievedata() {
        Statement statement;
        try {
            statement = new ConnectionDAL().getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `wfes`.`imagetry`");
            InputStream val = null;
            while (rs.next()) {
                val = rs.getBinaryStream(2);
            }
            File fBlob1 = new File("C:\\Users\\hp pav 15-e015tx\\Documents\\out.pdf");
            try {
                FileOutputStream os = new FileOutputStream(fBlob1);
                byte[] buffer = new byte[1024];
                int bytesRead;
                //read from is to buffer
                while ((bytesRead = val.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                val.close();
                //flush OutputStream to write any buffered data to file
                os.flush();
                os.close();
//                while (val.read() != -1) {
//                    os.write(val.read());
//                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

  
}
