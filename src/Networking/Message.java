package Networking;

public class Message {
    private String destination;
    private String message;
    private String source;

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }

    public Message(String source, String destination, String message) {
        this.source=source;
        this.destination=destination;
        this.message=message;
    }
}
