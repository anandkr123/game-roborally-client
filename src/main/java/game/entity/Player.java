package game.entity;

/**
 * Holds the details of the players
 */
public class Player {
private PlayerPositions []playerPositions;
private Cards []drawPile=new Cards[9];

    public PlayerPositions[] getPlayerPositions() {
        return playerPositions;
    }

    public void setPlayerPositions(PlayerPositions[] playerPositions) {
        this.playerPositions = playerPositions;
    }

    public Cards[] getDrawPile() {
        return drawPile;
    }

    public void setDrawPile(Cards[] drawPile) {
        this.drawPile = drawPile;
    }
}
