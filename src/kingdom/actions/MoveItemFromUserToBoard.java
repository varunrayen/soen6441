/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdom.actions;

import java.awt.Component;
import javax.swing.JOptionPane;
import kingdom.gameitems.BoardCell;
import kingdom.gameitems.BorderItem;
import kingdom.gameitems.Const;
import kingdom.gameitems.Game;

/**
 *
 * @author andriy
 */
public class MoveItemFromUserToBoard implements IGameAction {

    private final Component callerComponent;
    private Game theGame;
    private BoardCell destination;
    private BorderItem item;

    
    public MoveItemFromUserToBoard(Component callerComponent, Game game) {
        this.callerComponent = callerComponent;
        this.theGame = game;
    }

    @Override
    public ActionResult execute() {
        
        if(!initAndValidate()){
            return ActionResult.ERROR;
        }
        
        BorderItem removed = ActionHelper.findAndRemoveUserItem(theGame, item);
        
        if (removed != null) {
            destination.setItem(item);
            
            //cleare previously selected items
            theGame.setSelectedItem(null);
            theGame.setSelectedCell(null);
            
            return ActionResult.SUCCESS;
        } else {
            Const.logErr(this, "User item not found: " + this.item.getClass().getSimpleName());
            return ActionResult.ERROR;
        }
    }

    private boolean initAndValidate() {
        if (theGame == null || callerComponent == null) {
            return false;
        }
        
        destination = theGame.getSelectedCell();
        if (destination == null) {
            JOptionPane.showMessageDialog(callerComponent, "Please, select cell on the boarder");
            return false;
        }

        if (theGame.getSelectedItem() == null || theGame.getSelectedItem().getItem() == null) {
            JOptionPane.showMessageDialog(callerComponent, "Missing user selection");
            return false;
        }

        item = theGame.getSelectedItem().getItem();
        
        return true;
    }
}
