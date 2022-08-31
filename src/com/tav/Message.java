package com.tav;

public class Message {
    private final long id;
    private String content;

    public Message(long id) {
        this.id = id;
    }

    public Message(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
