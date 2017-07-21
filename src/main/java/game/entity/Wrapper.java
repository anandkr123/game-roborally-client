package game.entity;
import java.util.List;

/**
 * Wrapper for holding list of games
 */
public class Wrapper {
    private List<GameViewOutputWrapper> games;
    public List<GameViewOutputWrapper> getGames() {
        return games;
    }
    public void setGames(List<GameViewOutputWrapper> games) {
        this.games = games;
    }
}