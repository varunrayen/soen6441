/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdom.actions;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import kingdom.gameitems.Const;
import kingdom.gameitems.Game;
import kingdom.ui.MainWindow;

/**
 *
 * @author andriy
 */
public class SaveCofigAction implements IGameAction {

    String fileToLoad = "";
    private final MainWindow mainWind;
    private final Game theGame;

    public SaveCofigAction(MainWindow mainWindow, Game theGame) {
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

        int returnVal = fc.showSaveDialog(mainWind);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            // force extension XML if file name does not ends with .xml 
            String pathOfFile = fc.getSelectedFile().getAbsolutePath().trim().toLowerCase();
            if(!pathOfFile.endsWith(".xml") ){
                pathOfFile += ".xml";
            }
            
            File file = new File(pathOfFile);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Const.logErr(this, "Cannot create file: " + file.getAbsolutePath());
                    return ActionResult.ERROR;
                }
            }
            theGame.saveAllConfigs(file.getName());
        } else {
            Const.logInfo(this, "Save command cancelled by user");
        }

        return ActionResult.SUCCESS;
    }
}
