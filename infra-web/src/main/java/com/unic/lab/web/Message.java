package com.unic.lab.web;

public class Message {

    private String fromName;
    private String toName;
    private String text;

    public Message() {
    }

    public Message(String fromName) {
        this.fromName = fromName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName){
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public void reset() {
        this.text = "";
        this.toName = "";
    }

    public boolean isNotEmpty() {
        return !text.isEmpty();
    }
}
