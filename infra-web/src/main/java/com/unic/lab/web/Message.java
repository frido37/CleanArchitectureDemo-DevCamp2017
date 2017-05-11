package com.unic.lab.web;

public class Message {


    private String fromName;
    private String toName;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromName() {
        return fromName;
    }

    public Message withFromName(String fromName) {
        this.fromName = fromName;
        return this;
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
}
