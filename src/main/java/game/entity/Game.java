package game.entity;

/**
 * Holds the game details
 */
public class Game {

    private String name;
    private int maxRobotCount ;

    /**
     *
     * @return  returns the game name
     */
    public String getName() {
        return name;
    }

    /**
     * game name set by player
     * @param name game name received from player
     */
    public void setName(String name) {this.name = name;}

    /**
     *
     * @return returns the max robot count
     */
    public int getMaxRobotCount() {
        return maxRobotCount;
    }

    /**
     *  sets the maxRobotCount
     * @param maxRobotCount gets the maxRobotCount by player
     */
    public void setMaxRobotCount(int maxRobotCount) {
        this.maxRobotCount = maxRobotCount;
    }
}
