package game.entity;

/**
 * Holds the details of time limit warning
 */
public class TimeLimitWarning {
long secondsLeft;
String reason;

    public long getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondsLeft(long secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

