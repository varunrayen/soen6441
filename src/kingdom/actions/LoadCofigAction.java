/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdom.actions;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import kingdom.gameitems.Const;
import kingdom.gameitems.Game;
import kingdom.ui.MainWindow;

/**
 *
 * @author andriy
 */
public class LoadCofigAction implements IGameAction {

    String fileToLoad = "";
    private final MainWindow mainWind;
    private final Game theGame;

    public LoadCofigAction(MainWindow mainWindow, Game theGame) {
        this.mainWind = mainWindow;
        this.theGame = theGame;
    }

    @Override
    public ActionResult execute() {

        if (theGame == null || mainWind == null) {
            Const.logErr(this, "Arguments are not valid");
            return ActionResult.ERROR;
        }

        File appDirectory = new File(Const.GAME_HOME_FOLDER);

        if (!appDirectory.exists()) {
            appDirectory.mkdirs();
        }
        final JFileChooser fc = new JFileChooser(appDirectory);
        fc.addChoosableFileFilter(new ExtensionFileFilter("XML", new String[]{"XML", "xml"}));
        int returnVal = fc.showOpenDialog(mainWind);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();

            if (file.exists()) {
                theGame.loadAllConfigs(file.getName());
            } else {
                JOptionPane.showMessageDialog(mainWind, "Selected file does not exists\nFile: " + file.getAbsolutePath());
                return ActionResult.ERROR;
            }
        } else {
            Const.logInfo(this, "Open command cancelled by user");
        }

        return ActionResult.SUCCESS;
    }
}
