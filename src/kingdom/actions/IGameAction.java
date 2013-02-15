/*
 * TEAM C in SOEN6441/WW
 */
package kingdom.actions;

/**
 * Interface of action. Class implemented IGameAction represent one time action.<br>
 * An action has to be independent and can be executed from any class/thread
 * Example of actions: <br>
 * - action move Tile from tile bank into game border.<br>
 * - score the user<br>
 * - end and increment epoch<br>
 * - ....<br>
 */
public interface IGameAction {
    
    /**
     * returned status of any action. Status contains information about result of the action
     */
    enum ActionResult{
        SUCCESS,    // successefully executed action
        ERROR,      // problem during execution of action
        REDO        // request to repeat execution of same action
        //TODO add more types if required
    }
    
    /**
     * implemented method may implement any kind of action. Example: move tile, count score, end game, ...
     * Only method <code>execute()</code> will be called to perform implemented action.
     * @return ActionResult (information about how success of action)
     */
    ActionResult execute();
}
