package warningLevels;

public class Message {
    private  String message;
    private Importance level;

    public Message(String message, String level) {
        this.message = message;
        this.level = Importance.valueOf(Importance.class, level);
    }

    public String getMessage() {
        return message;
    }

    public Importance getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return this.getLevel() + ": " + this.getMessage();
    }
}
