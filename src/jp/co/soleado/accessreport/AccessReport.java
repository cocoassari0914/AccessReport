package jp.co.soleado.accessreport;

import javax.swing.JFrame;

import jp.co.soleado.accessreport.ui.MainWindow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccessReport {
    private static ApplicationContext context = null;

    public static void main(String[] args) {
        try {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");

            JFrame mainWindow = new MainWindow(context);

            mainWindow.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
