package game.entity;

import java.util.List;

/**
 * Contains details about the robot actions
 */

public class RobotActionDetail {
    private String playerId;
    private String action;
    private List<String> damageCards;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<String> getDamageCards() {
        return damageCards;
    }

    public void setDamageCards(List<String> damageCards) {
        this.damageCards = damageCards;
    }
}
