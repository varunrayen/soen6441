/*
 * TEAM C in SOEN6441/WW
 */
package kingdom;

import javax.swing.SwingUtilities;
import kingdom.ui.MainWindow;
import kingdom.ui.StartWizard;

/**
 * Main class to start application
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("This is the start point of Application\n");
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MainWindow mWindow = new MainWindow();
                mWindow.setVisible(true);
            }
        });
        
    }
}
