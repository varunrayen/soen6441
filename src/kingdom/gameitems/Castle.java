/*
 * TEAM C in SOEN6441/WW
 */
package kingdom.gameitems;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import kingdom.gameitems.Const.UserColor;

/**
 * Represent an Castle on the GameBoard
 */
public class Castle extends BorderItem {

    /* rank of castle 1-4 */
    private final int rank;
    /* color of castle */
    private final UserColor color;
    /* path to get small image for this Castle */
    private final String smallImagePath;
    /* path to get big image for this Castle */
    private final String bigImagePath;

    /**
     * @param color users color (use constant from {@link UserColor})
     * @param rank rank of castle (may be 1 .. 6)
     */
    public Castle(UserColor color, int rank) {
        super("" + color + " R" + rank);
        this.color = color;
        this.rank = rank;
        smallImagePath = "/res/24x24/" + String.valueOf(color).toLowerCase().charAt(0) + String.valueOf(rank) + ".png";
        bigImagePath = "/res/80x80/" + String.valueOf(color).toLowerCase().charAt(0) + String.valueOf(rank) + ".png";
    }

    /**
     *
     * @return rank of castle (may be 1 .. 6)
     */
    public int getRank() {
        return rank;
    }

    /**
     *
     * @return users color (use constant from {@link UserColor})
     */
    public UserColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.valueOf(color) + "[" + rank + "]";
    }

    @Override
    public Icon getSmallImage() {
        return new ImageIcon(getClass().getResource(smallImagePath));
    }

    @Override
    public Icon getBigImage() {
        return new ImageIcon(getClass().getResource(bigImagePath));
    }
}
