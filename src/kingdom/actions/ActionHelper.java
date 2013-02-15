/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdom.actions;

import java.util.List;
import kingdom.gameitems.BorderItem;
import kingdom.gameitems.Castle;
import kingdom.gameitems.Game;
import kingdom.gameitems.Tile;
import kingdom.gameitems.User;

/**
 *
 * @author andriy
 */
class ActionHelper {

    public static BorderItem findAndRemoveUserItem(Game theGame, BorderItem item) {

        User user = theGame.getCurrentUser();

        if (item instanceof Tile) {
            if (user.getOwnedTile() == item) {
                user.setOwnedTile(null);
                return item;
            } else {
                return null;
            }

        } else if (item instanceof Castle) {
            List<Castle> castles = user.getCastles();
            int foundIndex = castles.indexOf(item);
            if (foundIndex < 0) {
                return null;
            } else {
                return castles.remove(foundIndex);
            }
        } else {
            return null;
        }
    }
}
