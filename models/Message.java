package models;

import java.lang.Math;   

public class Message extends ModelMessage {

    private String message;

    public Message(String message) {
        super();
        this.message = message;
    }

    public Message() {
        super();
    }

    public String getMessage(){
        return message;
    }

    public String getThankYouMessage(){
        return "Thank you! " + Math.random();
    }

}
