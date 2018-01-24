package warningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message>messages;

    public Logger() {
        this.messages = new ArrayList<>();
    }

    public void receiveMessage(Message message, Importance level){
        if (message.getLevel().compareTo(level)>=0){
            messages.add(message);
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}
