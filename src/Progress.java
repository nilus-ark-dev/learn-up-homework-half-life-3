import java.io.Serializable;

public class Progress implements Serializable {

    private String level;
    private String playerNick;
    private int saveNumber;

    public Progress(String level, String playerNick, int saveNumber) {
        this.level = level;
        this.playerNick = playerNick;
        this.saveNumber = saveNumber;
    }

    public String getLevel() {
        return level;
    }

    public String getPlayerNick() {
        return playerNick;
    }

    public int getSaveNumber() {
        return saveNumber;
    }
}
