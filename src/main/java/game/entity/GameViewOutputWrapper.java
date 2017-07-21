package game.entity;

/**
 * Hold the details of the created game
 */
public class GameViewOutputWrapper {

    private String id;
    private String name;
    private int maxRobotCount;
    private int currentRobotCount;


    public GameViewOutputWrapper() {
        //Empty constructor
    }

    /**
     * Constructor
     *
     * @param id                the id of the game
     * @param name              the name of the game
     * @param maxRobotCount     the maximum number of robots
     * @param currentRobotCount the count of joined robots
     */
    public GameViewOutputWrapper(final String id, final String name, final int maxRobotCount, final int currentRobotCount) {
        this.id = id;
        this.name = name;
        this.maxRobotCount = maxRobotCount;
        this.currentRobotCount = currentRobotCount;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getMaxRobotCount() {
        return maxRobotCount;
    }

    public void setMaxRobotCount(final int maxRobotCount) {
        this.maxRobotCount = maxRobotCount;
    }

    public int getCurrentRobotCount() {
        return currentRobotCount;
    }

    public void setCurrentRobotCount(final int currentRobotCount) {
        this.currentRobotCount = currentRobotCount;
    }
}