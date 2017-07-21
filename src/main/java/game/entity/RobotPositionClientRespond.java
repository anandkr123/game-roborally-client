package game.entity;


/**
 * Contains details about the Robot position and robots
 */
public class RobotPositionClientRespond {
    private Robot robot;
    private Position position;

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
