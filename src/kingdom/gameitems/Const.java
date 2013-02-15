/*
 * TEAM C in SOEN6441/WW
 */
package kingdom.gameitems;

import java.awt.Color;

/**
 * Keep all constants and types
 */
public class Const {
    
    /**
     * OS dependant character "/" or "\"
     */
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    /**
     * Default background color for application
     */
    public static final Color BG_DEFAULT_COLOR = new Color(237,236,235);
    
    /**
     * Total number of rows in the game board
     */
    public static final int ROWS = 5;
    /**
     * Total number of columns in the game board
     */
    public static final int COLS = 6;

    public enum LogType{
        ERROR,
        WARNING,
        INFO
    }
    
    public static void logErr(Object source, String message){
        Const.log(source, message, LogType.ERROR);
    }
    
    public static void logInfo(Object source, String message){
        Const.log(source, message, LogType.INFO);
    }
    
    public static void log(Object source, String string, LogType messageType) {
        String text = "\n: " + messageType + "\t[" + source.getClass().getSimpleName() + "]\t" + string;
        System.out.print(text);
    }
    
    /**
     * type of tile on the board
     */
    public enum TileType {
        RESOURCE,   // resource tile
        WIZARD,     // wizard tile
        MOUNTAIN,   // mountain tile
        HAZARD,     // hazard tile
        DRAGON,     // dragon tile
        GOLD,       // gold tile
        };
    
    /**
     * Color of the tile (and user)
     */
    public enum UserColor {
        RED,
        GREEN,
        BLUE,
        YELLOW
    }
    
    /**
     * folder where all game resources are stored
     */
    public static final String GAME_HOME_FOLDER = System.getProperty("user.home") + FILE_SEPARATOR + "kingdom" + FILE_SEPARATOR;
}
