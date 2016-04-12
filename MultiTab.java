/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

import java.awt.Component;
import javax.swing.JTabbedPane;

/**
 *
 * @author DISHANT
 */
public class MultiTab extends JTabbedPane {

    public MultiTab() {
       // addTabCustom("Employee Form", new EmployeeAdd());
    }

    public void addTabCustom(String title, Component component) {
        addTab(title, component);
        setTabComponentAt(getTabCount() - 1,
                new ButtonTabComponent(this));
        setSelectedIndex(getTabCount() - 1);
    }
    
    public void addTabCustomTaskActivity(String title, Component component) {
        addTab(title, component);
        
        //setTabComponentAt(getTabCount() - 1,
          //      new ButtonTabComponent(this));
        setSelectedIndex(getTabCount() - 1);
    }
}
