package game.entity;
/**
 * Wrapper model for game join service
 */

public class GameJoinInputWrapper {
    private String playerName;
    private String clientRestBaseUrl;

    public GameJoinInputWrapper(){
        //Default constructor
    }

    public GameJoinInputWrapper(String playerName, String clientRestBaseUrl) {
        this.playerName = playerName;
        this.clientRestBaseUrl = clientRestBaseUrl;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
 
    public String getClientRestBaseUrl() {
        return clientRestBaseUrl;
    }

    public void setClientRestBaseUrl(String clientRestBaseUrl) {
        this.clientRestBaseUrl = clientRestBaseUrl;
    }

}
